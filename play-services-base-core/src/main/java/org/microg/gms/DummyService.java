/*
<<<<<<< HEAD:play-services-base-core/src/main/java/org/microg/gms/DummyService.java
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
=======
 * SPDX-FileCopyrightText: 2017 microG Project Team
 * SPDX-License-Identifier: Apache-2.0
 * Notice: Portions of this file are reproduced from work created and shared by Google and used
 *         according to terms described in the Creative Commons 4.0 Attribution License.
 *         See https://developers.google.com/readme/policies for details.
>>>>>>> 2e4d3ae4 (Location: Implement settings request (#2216)):play-services-location/src/main/java/com/google/android/gms/location/LocationSettingsStatusCodes.java
 */

package org.microg.gms;

import android.os.RemoteException;

import androidx.annotation.NonNull;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.internal.GetServiceRequest;
import com.google.android.gms.common.internal.IGmsCallbacks;

<<<<<<< HEAD:play-services-base-core/src/main/java/org/microg/gms/DummyService.java
import org.microg.gms.common.GmsService;

public class DummyService extends BaseService {
    public DummyService() {
        super("GmsDummySvc", GmsService.ANY);
    }

    @Override
    public void handleServiceRequest(IGmsCallbacks callback, GetServiceRequest request, GmsService service) throws RemoteException {
        callback.onPostInitComplete(CommonStatusCodes.ERROR, null, null);
=======
import org.microg.gms.common.Hide;
import org.microg.gms.common.PublicApi;

/**
 * Location settings specific status codes, for use in {@link Status#getStatusCode()}
 */
@PublicApi
public class LocationSettingsStatusCodes extends CommonStatusCodes {
    /**
     * Location settings can't be changed to meet the requirements, no dialog pops up
     */
    public static final int SETTINGS_CHANGE_UNAVAILABLE = 8502;

    @NonNull
    @Hide
    public static String getStatusCodeString(int statusCode) {
        switch (statusCode) {
            case SETTINGS_CHANGE_UNAVAILABLE:
                return "SETTINGS_CHANGE_UNAVAILABLE";
            case 8500:
            case 8501:
            case 8503:
            case 8505:
                return "INTERNAL_LOCATION_SETTINGS_STATUS_CODE";
            default:
                return CommonStatusCodes.getStatusCodeString(statusCode);
        }
>>>>>>> 2e4d3ae4 (Location: Implement settings request (#2216)):play-services-location/src/main/java/com/google/android/gms/location/LocationSettingsStatusCodes.java
    }
}
