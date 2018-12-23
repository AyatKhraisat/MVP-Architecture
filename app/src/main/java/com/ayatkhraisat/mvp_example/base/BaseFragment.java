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

package com.ayatkhraisat.mvp_example.base;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.ayatkhraisat.mvp_example.di.components.ViewComponent;

/**
 * Created by janisharali on 27/01/17.
 */

public class BaseFragment extends Fragment implements BaseContract.BaseView {

    protected BaseActivity baseActivity;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof BaseActivity) {
            BaseActivity activity = (BaseActivity) context;
            this.baseActivity = activity;
        }
    }


    @Override
    public void onDetach() {
        baseActivity = null;
        super.onDetach();
    }


    public ViewComponent getActivityComponent() {
        if (baseActivity != null) {
            return baseActivity.getViewComponent();
        }
        return null;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(false);
    }

    public BaseActivity getBaseActivity() {
        return baseActivity;
    }

    @Override
    public void onDestroy() {

        super.onDestroy();
    }


    @Override
    public void showError(String errorMessage) {
        baseActivity.showError(errorMessage);

    }

    @Override
    public void showMessage(String title, String message) {
        baseActivity.showMessage(title, message);
    }

    @Override
    public void toastLong(String message) {
        baseActivity.toastLong(message);
    }

    @Override
    public void toastShort(String message) {
        baseActivity.toastShort(message);
    }


    public interface Callback {

        void onFragmentAttached();

        void onFragmentDetached(String tag);
    }
}
