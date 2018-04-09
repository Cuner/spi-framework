package org.cuner.spi.framework.core;

import org.cuner.spi.framework.client.SpiBase;
import org.cuner.spi.framework.client.annotation.BizSpi;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by houan on 18/4/9.
 */
public class SpiManager implements ApplicationListener<ContextRefreshedEvent> {

    private static Map<Class, List<SpiBase>> spiProviderMap = new ConcurrentHashMap<Class, List<SpiBase>>();

    private static volatile boolean isLoaded = false;

    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        if (!isLoaded) {
            Map<String, Object> spiInstanceMap = contextRefreshedEvent.getApplicationContext().getBeansWithAnnotation(BizSpi.class);

            for (Object spiInstance : spiInstanceMap.values()) {
                Class spiInterface = spiInstance.getClass().getInterfaces()[0];
                if (spiProviderMap.containsKey(spiInterface)) {
                    spiProviderMap.get(spiInterface).add((SpiBase) spiInstance);
                } else {
                    spiProviderMap.put(spiInterface, Collections.singletonList((SpiBase) spiInstance));
                }
            }

            for (List<SpiBase> spiProviderList : spiProviderMap.values()) {
                Collections.sort(spiProviderList, new Comparator<SpiBase>() {
                    public int compare(SpiBase spiBase1, SpiBase spiBase2) {
                        return spiBase2.config(null).getPriority() - spiBase1.config(null).getPriority();
                    }
                });
            }
        }
        isLoaded = true;
    }

    public static List<SpiBase> getSpiProviderMap(Class spiInterface) {
        return spiProviderMap.get(spiInterface);
    }

}
