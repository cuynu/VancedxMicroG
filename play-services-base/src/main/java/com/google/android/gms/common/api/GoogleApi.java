/*
 * SPDX-FileCopyrightText: 2020, microG Project Team
 * SPDX-License-Identifier: Apache-2.0
 */

package com.google.android.gms.common.api;

import android.content.Context;

<<<<<<< HEAD
=======
import com.google.android.gms.common.api.internal.ApiKey;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

import org.microg.gms.common.Hide;
>>>>>>> 49892e88 (Restructure modules https://github.com/microg/GmsCore/commit/18c3a6154dc41cebe1d4aeda5592b8f23928356f)
import org.microg.gms.common.PublicApi;
import org.microg.gms.common.api.GoogleApiManager;

@PublicApi
<<<<<<< HEAD
public abstract class GoogleApi<O extends Api.ApiOptions> implements HasApiKey {
    @PublicApi(exclude = true)
=======
public abstract class GoogleApi<O extends Api.ApiOptions> implements HasApiKey<O> {
    private GoogleApiManager manager;
    @Hide
>>>>>>> 49892e88 (Restructure modules https://github.com/microg/GmsCore/commit/18c3a6154dc41cebe1d4aeda5592b8f23928356f)
    public Api<O> api;
    @Hide
    public O options;

    @PublicApi(exclude = true)
    protected GoogleApi(Context context, Api<O> api) {
        this.api = api;
<<<<<<< HEAD
        GoogleApiManager.getInstance();
=======
        this.manager = GoogleApiManager.getInstance(context);
    }

    @PublicApi(exclude = true)
    protected GoogleApi(Context context, Api<O> api, O options) {
        this.api = api;
        this.manager = GoogleApiManager.getInstance(context);
        this.options = options;
    }

    @PublicApi(exclude = true)
    protected <R, A extends Api.Client> Task<R> scheduleTask(PendingGoogleApiCall<R, A> apiCall) {
        TaskCompletionSource<R> completionSource = new TaskCompletionSource<>();
        manager.scheduleTask(this, apiCall, completionSource);
        return completionSource.getTask();
    }

    @Override
    @PublicApi(exclude = true)
    public ApiKey<O> getApiKey() {
        return null;
>>>>>>> 49892e88 (Restructure modules https://github.com/microg/GmsCore/commit/18c3a6154dc41cebe1d4aeda5592b8f23928356f)
    }

    @PublicApi(exclude = true)
    public O getOptions() {
        return options;
    }
}
