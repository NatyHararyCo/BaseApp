# BaseApp

A playground app which can be used as a base for other applications with similar functionality.

### Currently uses the following components/features:
- Kotlin-only
- Retrofit2 + Kotlin Coroutines
- MVVM architecture
- Livedata
- Bottom Navigation + Fragments
- Firebase Authentication

### How to use this repo?

This base app uses Firebase Auth UI, which requires secrets and sensitive info.

1. After cloning this repo, add a keys.xml file and replace the values with your own FB application ID.
You can get it through the Facebook developer console. It should look like this:
```
<?xml version="1.0" encoding="utf-8"?>
<resources>
    <string name="facebook_application_id" translatable="false">FB_APPLICATION_ID</string>
    <string name="fb_login_protocol_scheme" translatable="false">fbFB_APPLICATION_ID</string>
</resources>
```

2. Download the google-services.json from the Firebase console and place it under 'app'.