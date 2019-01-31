/*
 * Copyright (C) 2017 MINDORKS NEXTGEN PRIVATE LIMITED
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://mindorks.com/license/apache-v2
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License
 */

package com.ayatkhraisat.mvp_example.base

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.ayatkhraisat.mvp_example.di.components.ViewComponent

/**
 * Created by janisharali on 27/01/17.
 */

abstract class BaseFragment : Fragment(), BaseContract.BaseView {

    lateinit var baseActivity: BaseActivity

    val activityComponent: ViewComponent?
        get() = baseActivity.viewComponent


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is BaseActivity) {
            this.baseActivity = context
            inject(baseActivity)
        }
    }

    protected abstract fun inject(base: BaseActivity)


    override fun onDetach() {
        super.onDetach()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(false)
    }

    override fun onDestroy() {

        super.onDestroy()
    }


    override fun toastLong(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }

    override fun toastShort(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }


}
