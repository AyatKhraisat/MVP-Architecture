package com.ayatkhraisat.mvp_example.di.scopes

import java.lang.annotation.RetentionPolicy
import javax.inject.Scope
import kotlin.annotation.Retention

/**
 * Created by Ayat khraisat  on 2/12/19
 * akhraisat@blessedtreeit.com
 * <p>
 * Project Name: MVP_Architecture
 * <p>
 * Blessed Tree IT
 */
@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class ViewScope
