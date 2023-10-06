# Vanced+ MicroG

This fork tweaks MicroG to be usable by applications that require Google authentication such as [YouTube Vanced+](https://gitlab.com/cuynu/ytvancedx) or [ReVanced](https://github.com/revanced), [ReVanced Extended](https://github.com/inotia00) / [ReX](https://github.com/YT-Advanced).

## Donate this project (Not required)
<p align="left">
    <a href="https://github.com/sponsors/cuynu"><img src="https://img.shields.io/badge/Support%20Project-%E2%9D%A4-%23db61a2.svg?&logo=github&logoColor=white&labelColor=181717&style=flat-square" alt="Badage"></img></a>

## Warning!
Vanced+ microG probably not work in ReVanced/RVX in future as recent changes from ReVanced/RVX to use with they specific MicroG called ReVanced MicroG with different package name !

## Notable changes

- No longer a system app
- Package name changed from `com.google.android.gms` to `com.mgoogle.android.gms` to support installation alongside the official MicroG
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
