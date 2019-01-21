package com.ayatkhraisat.mvp_example.di.qualifires;

import javax.inject.Qualifier;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by: Ahmed Al-Hashimi
 * Created on: Dec. 27, 2018.
 * <p>
 * aalhashimi@blessedtreeit.com
 * <p>
 * Project Name: ActivityCenterProduct
 * <p>
 * BTIT
 */
public interface Qualifiers {
    @Qualifier
    @Retention(RetentionPolicy.RUNTIME)
    public @interface ActivityContext {
    }

    @Qualifier
    @Retention(RetentionPolicy.RUNTIME)
    public @interface ApplicationContext {
    }

}
