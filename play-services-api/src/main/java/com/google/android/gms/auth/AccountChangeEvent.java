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

package com.google.android.gms.auth;

import org.microg.safeparcel.AutoSafeParcelable;

<<<<<<< HEAD:play-services-api/src/main/java/com/google/android/gms/auth/AccountChangeEvent.java
public class AccountChangeEvent extends AutoSafeParcelable {
    public static Creator<AccountChangeEvent> CREATOR = new AutoCreator<>(AccountChangeEvent.class);
=======
import java.util.List;

public class GetAllCapabilitiesResponse extends AutoSafeParcelable {
    @Field(1)
    private int versionCode = 1;
    @Field(2)
    public int statusCode;
    @Field(3)
    public List<CapabilityInfoParcelable> capabilities;

    public static final Creator<GetAllCapabilitiesResponse> CREATOR = findCreator(GetAllCapabilitiesResponse.class);
>>>>>>> 1cc72500 (Wearable: Invoke callback on WearableService.getAllCapabilities()):play-services-wearable/src/main/java/com/google/android/gms/wearable/internal/GetAllCapabilitiesResponse.java
}
