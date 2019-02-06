package com.ayatkhraisat.mvp_example.top_rated;

import android.os.Handler;
import android.os.Looper;
import io.reactivex.annotations.NonNull;

import java.util.concurrent.Executor;

/**
 * Created by Ayat khraisat  on 2/6/19
 * akhraisat@blessedtreeit.com
 * <p>
 * Project Name: MVP_Architecture
 * <p>
 * Blessed Tree IT
 */
public class MainThreadExecutor implements Executor {

    private final Handler mHandler = new Handler(Looper.getMainLooper());

    @Override
    public void execute(@NonNull Runnable command) {
        mHandler.post(command);
    }

}