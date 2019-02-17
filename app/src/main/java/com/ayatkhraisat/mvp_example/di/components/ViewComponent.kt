package com.ayatkhraisat.mvp_example.di.components


import com.ayatkhraisat.mvp_example.di.modules.ActivityModule
import com.ayatkhraisat.mvp_example.di.scopes.ViewScope
import com.ayatkhraisat.mvp_example.main.MainActivity
import dagger.Component

/**
 * Created by Ayat Khriasat on 14,December,2018 at 7:33 PM
 * Email: ayatzkhraisat@gmail.com
 */

@ViewScope
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [ActivityModule::class]
)
interface ViewComponent {

    fun inject(mainActivity: MainActivity)


}
