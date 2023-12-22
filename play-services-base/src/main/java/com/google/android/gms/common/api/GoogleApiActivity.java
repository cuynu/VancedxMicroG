<<<<<<< HEAD
package com.google.android.gms.common.api;

import android.app.Activity;

public class GoogleApiActivity extends Activity {
=======
/*
 * SPDX-FileCopyrightText: 2020, microG Project Team
 * SPDX-License-Identifier: Apache-2.0
 * Notice: Portions of this file are reproduced from work created and shared by Google and used
 *         according to terms described in the Creative Commons 4.0 Attribution License.
 *         See https://developers.google.com/readme/policies for details.
 */

package com.google.android.gms.common.api;

import android.app.Activity;
import android.content.DialogInterface;

import org.microg.gms.common.PublicApi;

/**
 * Helper activity used by Google Play services APIs to display resolutions for connection errors.
 */
@PublicApi
public class GoogleApiActivity extends Activity implements DialogInterface.OnCancelListener {
    @Override
    @PublicApi(exclude = true)
    public void onCancel(DialogInterface dialog) {

    }
>>>>>>> 49892e88 (Restructure modules https://github.com/microg/GmsCore/commit/18c3a6154dc41cebe1d4aeda5592b8f23928356f)
}
