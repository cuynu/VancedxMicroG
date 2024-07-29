# Vanced+ MicroG

This fork tweaks MicroG to be usable by applications that require Google authentication such as [YouTube Vanced+](https://gitlab.com/cuynu/vancedx).

## Warning!
Vanced+ microG are currently **DOES NOT WORK** with ReVanced/RVX as they now uses their own ReVanced microG with specific package name! However, there are workaround : [Issues #15](https://gitlab.com/cuynu/VancedxMicroG/-/issues/15#note_1837372638)

## Notable changes

- No longer a system app
- Package name changed from `com.google.android.gms` to `com.mgoogle.android.gms` to support installation alongside the official MicroG or device with Google Play Services pre-installed
- Removed unnecessary features:
  - Ads
  - Analytics
  - Car
  - Droidguard
  - Exposure-Notifications
  - Feedback
  - Firebase
  - Games
  - Maps
  - Recovery
  - Registering app permissions
  - SafetyNet
  - Self-Check
  - Search
  - TapAndPay
  - Wallet
  - Wear-Api
- Removed all permissions, as none are required for Google authentication

## Credits

- Source Code for MicroG 0.2.25.224113 was provided by [@OxrxL](https://github.com/OxrxL)
- [@shadow578](https://github.com/shadow578)'s commit used to apply `SPOOFED_PACKAGE_SIGNATURE`
