package org.cuner.spi.framework.client;

import java.util.List;

/**
 * Created by houan on 18/3/16.
 */
public interface SpiBase<T, R> {

    boolean condition(T query);

    List<R> invoke(T query);

    SpiConfig config(T query);
}
