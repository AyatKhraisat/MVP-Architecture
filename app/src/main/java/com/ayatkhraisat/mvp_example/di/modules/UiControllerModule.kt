package com.ayatkhraisat.mvp_example.di.modules

import android.content.Context
import com.ayatkhraisat.mvp_example.di.qualifires.Qualifiers
import com.ayatkhraisat.mvp_example.di.scopes.ViewScope
import dagger.Module
import dagger.Provides

/**
 * Created by Ayat khraisat  on 1/21/19
 * akhraisat@blessedtreeit.com
 * <p>
 * Project Name: MVP-Architecture
 * <p>
 * Blessed Tree IT
 */
@Module
class UiControllerModule(@Qualifiers.ActivityContext val context: Context) {

    @Provides
    @Qualifiers.ActivityContext
    @ViewScope
    internal fun provideContext(): Context {
        return context
    }


}