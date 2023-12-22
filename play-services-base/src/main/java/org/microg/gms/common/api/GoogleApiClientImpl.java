/*
 * Copyright (C) 2013-2017 microG Project Team
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.microg.gms.common.api;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;

<<<<<<< HEAD
=======
import androidx.fragment.app.FragmentActivity;

import android.util.Log;

import com.google.android.gms.common.ConnectionResult;
>>>>>>> 49892e88 (Restructure modules https://github.com/microg/GmsCore/commit/18c3a6154dc41cebe1d4aeda5592b8f23928356f)
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GoogleApiClientImpl implements GoogleApiClient {
    private static final String TAG = "GmsApiClientImpl";

<<<<<<< HEAD
    private final Map<Api, ApiClient> apiConnections = new HashMap<>();
    private final Set<ConnectionCallbacks> connectionCallbacks = new HashSet<>();
    private final Set<OnConnectionFailedListener> connectionFailedListeners = new HashSet<>();
=======
    private final Context context;
    private final Looper looper;
    private final ApiClientSettings clientSettings;
    private final Map<Api, Api.ApiOptions> apis = new HashMap<Api, Api.ApiOptions>();
    private final Map<Api, Api.Client> apiConnections = new HashMap<Api, Api.Client>();
    private final Set<ConnectionCallbacks> connectionCallbacks = new HashSet<ConnectionCallbacks>();
    private final Set<OnConnectionFailedListener> connectionFailedListeners = new HashSet<OnConnectionFailedListener>();
    private final int clientId;
    private final ConnectionCallbacks baseConnectionCallbacks = new ConnectionCallbacks() {
        @Override
        public void onConnected(Bundle connectionHint) {
            Log.d(TAG, "ConnectionCallbacks : onConnected()");
            for (ConnectionCallbacks callback : connectionCallbacks) {
                callback.onConnected(connectionHint);
            }
        }

        @Override
        public void onConnectionSuspended(int cause) {
            Log.d(TAG, "ConnectionCallbacks : onConnectionSuspended()");
            for (ConnectionCallbacks callback : connectionCallbacks) {
                callback.onConnectionSuspended(cause);
            }
        }
    };
    private final OnConnectionFailedListener baseConnectionFailedListener = new
            OnConnectionFailedListener() {
                @Override
                public void onConnectionFailed(ConnectionResult result) {
                    Log.d(TAG, "OnConnectionFailedListener : onConnectionFailed()");
                    for (OnConnectionFailedListener listener : connectionFailedListeners) {
                        listener.onConnectionFailed(result);
                    }
                }
            };
    private int usageCounter = 0;
>>>>>>> 49892e88 (Restructure modules https://github.com/microg/GmsCore/commit/18c3a6154dc41cebe1d4aeda5592b8f23928356f)
    private boolean shouldDisconnect = false;

    public GoogleApiClientImpl(Context context, Looper looper, ApiClientSettings clientSettings,
                               Map<Api, Api.ApiOptions> apis,
                               Set<ConnectionCallbacks> connectionCallbacks,
                               Set<OnConnectionFailedListener> connectionFailedListeners) {
        this.connectionCallbacks.addAll(connectionCallbacks);
        this.connectionFailedListeners.addAll(connectionFailedListeners);

        if (this.clientSettings.sessionId == null) {
            this.clientSettings.sessionId = hashCode();
        }

        for (Api api : apis.keySet()) {
            ConnectionCallbacks baseConnectionCallbacks = new ConnectionCallbacks() {
                @Override
                public void onConnected(Bundle connectionHint) {
                    Log.d(TAG, "ConnectionCallbacks : onConnected()");
                    for (ConnectionCallbacks callback : connectionCallbacks) {
                        callback.onConnected(connectionHint);
                    }
                }

                @Override
                public void onConnectionSuspended(int cause) {
                    Log.d(TAG, "ConnectionCallbacks : onConnectionSuspended()");
                    for (ConnectionCallbacks callback : connectionCallbacks) {
                        callback.onConnectionSuspended(cause);
                    }
                }
            };
            OnConnectionFailedListener baseConnectionFailedListener = result -> {
                Log.d(TAG, "OnConnectionFailedListener : onConnectionFailed()");
                for (OnConnectionFailedListener listener : connectionFailedListeners) {
                    listener.onConnectionFailed(result);
                }
            };
            apiConnections.put(api, api.getBuilder().build(apis.get(api), context, looper, clientSettings, baseConnectionCallbacks, baseConnectionFailedListener));
        }
    }

<<<<<<< HEAD
=======
    public synchronized void incrementUsageCounter() {
        usageCounter++;
    }

    public synchronized void decrementUsageCounter() {
        usageCounter--;
        if (shouldDisconnect) disconnect();
    }

    public Looper getLooper() {
        return looper;
    }

    public Api.Client getApiConnection(Api api) {
        return apiConnections.get(api);
    }

    @Override
    public ConnectionResult blockingConnect() {
        return null;
    }

    @Override
    public ConnectionResult blockingConnect(long timeout, TimeUnit unit) {
        return null;
    }

    @Override
    public PendingResult<Status> clearDefaultAccountAndReconnect() {
        return null;
    }

>>>>>>> 49892e88 (Restructure modules https://github.com/microg/GmsCore/commit/18c3a6154dc41cebe1d4aeda5592b8f23928356f)
    @Override
    public synchronized void connect() {
        Log.d(TAG, "connect()");
        if (isConnected() || isConnecting()) {
            if (shouldDisconnect) {
                shouldDisconnect = false;
                return;
            }
            Log.d(TAG, "Already connected/connecting, nothing to do");
            return;
        }
        for (Api.Client connection : apiConnections.values()) {
            if (!connection.isConnected()) {
                connection.connect();
            }
        }
    }

    @Override
    public synchronized void disconnect() {
<<<<<<< HEAD
        Log.d(TAG, "disconnect()");
        for (ApiClient connection : apiConnections.values()) {
            if (connection.isConnected()) {
                connection.disconnect();
=======
        if (usageCounter > 0) {
            shouldDisconnect = true;
        } else {
            Log.d(TAG, "disconnect()");
            for (Api.Client connection : apiConnections.values()) {
                if (connection.isConnected()) {
                    connection.disconnect();
                }
>>>>>>> 49892e88 (Restructure modules https://github.com/microg/GmsCore/commit/18c3a6154dc41cebe1d4aeda5592b8f23928356f)
            }
        }
    }

    @Override
    public synchronized boolean isConnected() {
        for (Api.Client connection : apiConnections.values()) {
            if (!connection.isConnected()) return false;
        }
        return true;
    }

    @Override
    public synchronized boolean isConnecting() {
        for (Api.Client connection : apiConnections.values()) {
            if (connection.isConnecting()) return true;
        }
        return false;
    }

    @Override
    public boolean isConnectionCallbacksRegistered(ConnectionCallbacks listener) {
        return connectionCallbacks.contains(listener);
    }

    @Override
    public boolean isConnectionFailedListenerRegistered(
            OnConnectionFailedListener listener) {
        return connectionFailedListeners.contains(listener);
    }

    @Override
    public void registerConnectionCallbacks(ConnectionCallbacks listener) {
        connectionCallbacks.add(listener);
    }

    @Override
    public void registerConnectionFailedListener(OnConnectionFailedListener listener) {
        connectionFailedListeners.add(listener);
    }

    @Override
    public void unregisterConnectionCallbacks(ConnectionCallbacks listener) {
        connectionCallbacks.remove(listener);
    }

}
