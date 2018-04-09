package org.cuner.spi.framework.client.annotation;

import org.springframework.stereotype.Service;

import java.lang.annotation.*;

/**
 * Created by houan on 18/3/16.
 */
@Target({ElementType.TYPE})//目标作用于类
@Retention(RetentionPolicy.RUNTIME)// 注解在class字节码文件中存在，在运行时可以通过反射获取到
@Documented
@Service
public @interface BizSpi {
}
