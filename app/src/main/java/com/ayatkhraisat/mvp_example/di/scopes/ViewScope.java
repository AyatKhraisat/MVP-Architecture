package com.ayatkhraisat.mvp_example.di.scopes;

import javax.inject.Scope;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by Ayat Khriasat on 14,December,2018 at 7:33 PM
 * Email: ayatzkhraisat@gmail.com
 * Project: MvpExample
 */

@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface ViewScope {
}
