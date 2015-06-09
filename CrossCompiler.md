# Introduction #

Before you actually want to do run the Emerald compiler, it would have been better to know how we made the compiler run on the phone.

Check the script file here:
http://code.google.com/p/master-thesis-emerald/source/browse/emerald/em_script.sh


# Details #

The variables on the script you have to know is how to redirect to where these sources lies. All of the toolchain utilities can be found on the Android NDK directory you download from Developers Android page.

NDK=~/adt-bundle-linux-x86-20130917/android-ndk-[r9](https://code.google.com/p/master-thesis-emerald/source/detail?r=9)/
SYSROOT=$NDK/platforms/android-9/arch-arm/
CROSS\_PATH=$NDK/toolchains/arm-linux-androideabi-4.8/prebuilt/linux-x86/bin

(these variables above must be specific!)

We also specify the CC and RANLIB for the cross compilation.
When all this is done, the last execution is to do ./configure of the emerald source file to build up the Makefiles necessary:

./configure --target=arm-linux-androideabi --host=i686-linux --enable-static=true --prefix=/home/kkho/em\_output --exec-prefix=/home/kkho/em\_output