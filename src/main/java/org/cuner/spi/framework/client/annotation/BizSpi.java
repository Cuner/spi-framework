package org.cuner.spi.framework.client.annotation;

import org.springframework.stereotype.Service;

import java.lang.annotation.*;

/**
 * Created by houan on 18/3/16.
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Service
public @interface BizSpi {
}
