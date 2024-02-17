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

package org.microg.gms.common;

public enum GmsService {
    UNKNOWN(-2),
    ANY(-1),
    PEOPLE(5, "com.google.android.gms.people.service.START"),
    ACCOUNT(9, "com.google.android.gms.accounts.ACCOUNT_SERVICE"),
    ADDRESS(12, "com.google.android.gms.identity.service.BIND"),
    AUTH_PROXY(16, "com.google.android.gms.auth.service.START"),
    INDEX(21, "com.google.android.gms.icing.INDEX_SERVICE"),
    COMMON(39, "com.google.android.gms.common.service.START"),
    SIGN_IN(44, "com.google.android.gms.signin.service.START"),
    CREDENTIALS(68, "com.google.android.gms.auth.api.credentials.service.START"),
<<<<<<< HEAD
=======
    NEARBY_BOOTSTRAP(69, "com.google.android.gms.nearby.bootstrap.service.NearbyBootstrapService.START"),
    PLUS_INTERNAL(70),
    SOURCE_DEVICE(75, "com.google.android.gms.smartdevice.d2d.SourceDeviceService.START"),
    TARGET_DEVICE(76, "com.google.android.gms.smartdevice.d2d.TargetDeviceService.START"),
    APP_INVITE(77, "com.google.android.gms.appinvite.service.START"),
    TAP_AND_PAY(79, "com.google.android.gms.tapandpay.service.BIND"),
    CHROME_SYNC(80, "com.google.android.gms.chromesync.service.START"),
    ACCOUNTS(81, "com.google.android.gms.smartdevice.setup.accounts.AccountsService.START"),
    CAST_REMOTE_DISPLAY(83, "com.google.android.gms.cast.remote_display.service.START"),
    TRUST_AGENT(85, "com.google.android.gms.trustagent.StateApi.START"),
    AUTH_SIGN_IN(91, "com.google.android.gms.auth.api.signin.service.START"),
    MEASUREMENT(93, "com.google.android.gms.measurement.START"),
    FREIGHTER(98, "com.google.android.gms.freighter.service.START"),
    GUNS(110, "com.google.android.gms.notifications.service.START"),
    BLE(111, "com.google.android.gms.beacon.internal.IBleService.START"),
    FIREBASE_AUTH(112, "com.google.firebase.auth.api.gms.service.START"),
    APP_INDEXING(113),
    GASS(116, "com.google.android.gms.gass.START"),
    WORK_ACCOUNT(120),
    INSTANT_APPS(121, "com.google.android.gms.instantapps.START"),
    CAST_FIRSTPATY(122, "com.google.android.gms.cast.firstparty.START"),
    AD_CACHE(123, "com.google.android.gms.ads.service.CACHE"),
    SMS_RETRIEVER(126, "com.google.android.gms.auth.api.phone.service.SmsRetrieverApiService.START"),
    CRYPT_AUTH(129, "com.google.android.gms.auth.cryptauth.cryptauthservice.START"),
    DYNAMIC_LINKS(131, "com.google.firebase.dynamiclinks.service.START"),
    FONTS(132, "com.google.android.gms.fonts.service.START"),
    ROMANESCO(135, "com.google.android.gms.romanesco.service.START"),
    TRAINER(139, "com.google.android.gms.learning.trainer.START"),
    FIDO2_REGULAR(148, "com.google.android.gms.fido.fido2.regular.START"),
    FIDO2_PRIVILEGED(149, "com.google.android.gms.fido.fido2.privileged.START"),
    DATA_DOWNLOAD(152, "com.google.android.mdd.service.START"),
    ACCOUNT_DATA(153, "com.google.android.gms.auth.account.data.service.START"),
    CONSTELLATION(155, "com.google.android.gms.constellation.service.START"),
    AUDIT(154, "com.google.android.gms.audit.service.START"),
    SYSTEM_UPDATE(157, "com.google.android.gms.update.START_API_SERVICE"),
    MOBSTORE(160, "com.google.android.mobstore.service.START"),
    USER_LOCATION(163, "com.google.android.gms.userlocation.service.START"),
    AD_HTTP(166, "com.google.android.gms.ads.service.HTTP"),
    LANGUAGE_PROFILE(167, "com.google.android.gms.languageprofile.service.START"),
    MDNS(168, "com.google.android.gms.mdns.service.START"),
    SEMANTIC_LOCATION(173, "com.google.android.gms.semanticlocation.service.START_ODLH"),
    FIDO2_ZEROPARTY(180, "com.google.android.gms.fido.fido2.zeroparty.START"),
    G1_RESTORE(181, "com.google.android.gms.backup.G1_RESTORE"),
    G1_BACKUP(182, "com.google.android.gms.backup.G1_BACKUP"),
    OSS_LICENSES(185, "com.google.android.gms.oss.licenses.service.START"),
    PAYSE(188, "com.google.android.gms.payse.service.BIND"),
    RCS(189, "com.google.android.gms.rcs.START"),
    CARRIER_AUTH(191, "com.google.android.gms.carrierauth.service.START"),
    SYSTEM_UPDATE_SINGLE_UESR(192, "com.google.android.gms.update.START_SINGLE_USER_API_SERVICE"),
    APP_USAGE(193, "com.google.android.gms.appusage.service.START"),
    NEARBY_SHARING_2(194, "com.google.android.gms.nearby.sharing.START_SERVICE"),
    AD_CONSENT_LOOKUP(195, "com.google.android.gms.ads.service.CONSENT_LOOKUP"),
    CREDENTIAL_MANAGER(196, "com.google.android.gms.credential.manager.service.firstparty.START"),
    PHONE_INTERNAL(197, "com.google.android.gms.auth.api.phone.service.InternalService.START"),
    PAY(198, "com.google.android.gms.pay.service.BIND"),
    ASTERISM(199, "com.google.android.gms.asterism.service.START"),
    MODULE_RESTORE(201, "com.google.android.gms.backup.GMS_MODULE_RESTORE"),
    FACS_CACHE(202, "com.google.android.gms.facs.cache.service.START"),
    RECAPTCHA(205, "com.google.android.gms.recaptcha.service.START"),
    CONTACT_SYNC(208, "com.google.android.gms.people.contactssync.service.START"),
>>>>>>> 37dd2b59 (Add dummy service for SEMANTIC_LOCATION(173) (#2174))
    IDENTITY_SIGN_IN(212, "com.google.android.gms.auth.api.identity.service.signin.START"),
    ;

    public final int SERVICE_ID;
    public final String ACTION;
    public final String[] SECONDARY_ACTIONS;

    GmsService(int serviceId, String... actions) {
        this.SERVICE_ID = serviceId;
        this.ACTION = actions.length > 0 ? actions[0] : null;
        this.SECONDARY_ACTIONS = actions;
    }

    public static GmsService byServiceId(int serviceId) {
        for (GmsService service : values()) {
            if (service.SERVICE_ID == serviceId) return service;
        }
        return UNKNOWN;
    }

    public static String nameFromServiceId(int serviceId) {
        return byServiceId(serviceId).toString(serviceId);
    }

    public String toString(int serviceId) {
        if (this != UNKNOWN) return toString();
        return "UNKNOWN(" + serviceId + ")";
    }
}