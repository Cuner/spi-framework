package org.cuner.spi.framework;

import org.cuner.spi.framework.demo.domain.FoodCategory;
import org.cuner.spi.framework.demo.api.FoodSpi;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by houan on 18/4/12.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:spring.xml"})
public class testSpi {

    @Resource(name = "foodSpi")
    private FoodSpi foodSpi;

    @Test
    public void spiTest() {
        List<String> result = foodSpi.invoke(FoodCategory.FRUIT);
        for (String food : result) {
            System.out.println(food);
        }
    }
}
