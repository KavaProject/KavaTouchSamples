# Kava Touch Samples

This repository contains sample applications for [Kava Touch](https://github.com/KavaProject/KavaTouch). License details of Kava Touch apply were not stated differently.

## Building

At the repository root, issue a clone command for the KavaTouch framework:
```bash
cd KavaTouchSamples
git clone https://github.com/KavaProject/KavaTouch.git KavaTouch
```
This will populate the KavaTouch sub-directory. To install a sample application using Gradle, make sure an Android device is connected and issue gradle's installDebug command (Replace the device IP, the Android SDK install location and the application you want to install):
```bash
adb connect 192.168.0.200
export ANDROID_HOME=/Applications/android-sdk-macosx/; ./gradlew HelloWorld:installDebug
```
You can also open the repository as an IntelliJ IDEA project, or import it into Eclipse.
