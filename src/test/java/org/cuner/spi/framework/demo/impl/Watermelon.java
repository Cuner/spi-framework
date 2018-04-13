package org.cuner.spi.framework.demo.impl;

import org.cuner.spi.framework.client.annotation.BizSpi;
import org.cuner.spi.framework.demo.domain.FoodCategory;
import org.cuner.spi.framework.demo.api.FoodSpi;
import org.cuner.spi.framework.client.SpiConfig;

import java.util.Collections;
import java.util.List;

/**
 * Created by houan on 18/4/12.
 */
@BizSpi
public class Watermelon implements FoodSpi {
    public boolean condition(FoodCategory query) {
        return FoodCategory.FRUIT.equals(query);
    }

    public List<String> invoke(FoodCategory query) {
        return Collections.singletonList("Watermelon");
    }

    public SpiConfig config(FoodCategory query) {
        return new SpiConfig(false, 8);
    }
}
