package org.cuner.spi.framework.core;

import org.cuner.spi.framework.client.SpiBase;
import org.cuner.spi.framework.client.SpiConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by houan on 18/4/9.
 */
public class SpiProviderFactory<T> implements FactoryBean<T> {

    private Logger logger = LoggerFactory.getLogger(SpiProviderFactory.class);

    private Class<T> targetClass;

    public T getObject() throws Exception {
        InvocationHandler invocationHandler = new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                List<SpiBase> spiList = SpiManager.getSpiProviderMap(targetClass);

                // 支持组合,所以必须返回list; 每一个功能点实现也必须返回list
                List combinationResult = new ArrayList();
                for (SpiBase spi : spiList) {
                    if (SpiBase.class.isInstance(spi)) {
                        if (args != null && spi.condition(args[0])) {
                            SpiConfig spiConfig = spi.config(args[0]);
                            List result = (List) method.invoke(spi, args);
                            if (result != null) {
                                combinationResult.addAll(result);
                                if (spiConfig.isMutex()) {
                                    break;
                                }
                            }
                        }
                    }
                }
                return combinationResult;
            }
        };
        return (T) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                new Class[]{targetClass},
                invocationHandler);
    }

    public Class<?> getObjectType() {
        return targetClass;
    }

    public boolean isSingleton() {
        return true;
    }

    public Class<T> getTargetClass() {
        return targetClass;
    }

    public void setTargetClass(Class<T> targetClass) {
        this.targetClass = targetClass;
    }
}
