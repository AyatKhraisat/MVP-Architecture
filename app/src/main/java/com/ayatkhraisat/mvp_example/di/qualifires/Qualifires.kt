package com.ayatkhraisat.mvp_example.di.qualifires



import javax.inject.Qualifier

/**
 * Created by Ayat khraisat  on 1/30/19
 * akhraisat@blessedtreeit.com
 * <p>
 * Project Name: MVP_Architecture
 * <p>
 */

@Qualifier
@MustBeDocumented
@Retention(AnnotationRetention.RUNTIME)
annotation class ActivityContext


@Qualifier
@MustBeDocumented
@Retention(AnnotationRetention.RUNTIME)
annotation class ApplicationContext
