/*
 * SPDX-FileCopyrightText: 2022 microG Project Team
 * SPDX-License-Identifier: Apache-2.0
 */

package com.google.android.gms.auth;

import android.accounts.Account;

import org.microg.safeparcel.AutoSafeParcelable;

public class HasCapabilitiesRequest extends AutoSafeParcelable {
    @Field(1)
    public Account account;
<<<<<<< HEAD:play-services-api/src/main/java/com/google/android/gms/auth/HasCababilitiesRequest.java
    public static final Creator<HasCababilitiesRequest> CREATOR = new AutoCreator<>(HasCababilitiesRequest.class);
=======
    @Field(2)
    public String[] capabilities;
    public static final Creator<HasCapabilitiesRequest> CREATOR = new AutoCreator<>(HasCapabilitiesRequest.class);
>>>>>>> d04e2718 (Auth: Forward UID/PID from IAuthManagerService.getTokenWithAccount https://github.com/microg/GmsCore/commit/4a7bac35f8eeb1bb3cb1607dc03b439b819abe40):play-services-api/src/main/java/com/google/android/gms/auth/HasCapabilitiesRequest.java
}
