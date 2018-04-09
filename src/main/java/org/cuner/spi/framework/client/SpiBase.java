package org.cuner.spi.framework.client;

import java.util.List;

/**
 * Created by houan on 18/3/16.
 */
public interface SpiBase<T, R> {

    /**
     * 是否执行当前实现的条件
     * @param query
     * @return
     */
    boolean condition(T query);

    /**
     * 具体操作
     * @param query
     * @return
     */
    List<R> invoke(T query);

    /**
     * spi执行时候的配置
     * @param query
     * @return
     */
    SpiConfig config(T query);
}
