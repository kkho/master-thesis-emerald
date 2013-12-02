#!/bin/sh
#CROSS_PATH=~/CodeSourcery/Sourcery_CodeBench_Lite_for_ARM_GNU_Linux/bin
NDK=~/adt-bundle-linux-x86-20130917/android-ndk-r9/
SYSROOT=$NDK/platforms/android-9/arch-arm/
CROSS_PATH=$NDK/toolchains/arm-linux-androideabi-4.8/prebuilt/linux-x86/bin

 export CFLAGS="-fpic -fno-builtin-memcpy -fno-builtin-memset -fno-builtin-memchr -fno-builtin-strlen \
    -ffunction-sections \
     -fsigned-char "




#export RANLIB=$CROSS_PATH/arm-none-linux-gnueabi-ranlib
export RANLIB="$CROSS_PATH/arm-linux-androideabi-ranlib"
#export CC=$CROSS_PATH/arm-none-linux-gnueabi-gcc
export CC="$CROSS_PATH/arm-linux-androideabi-gcc-4.8  --sysroot=$SYSROOT -static"
#USE BELOW
./configure --target=arm-linux-androideabi --host=i686-linux --enable-static=true --prefix=/home/kkho/em_output --exec-prefix=/home/kkho/em_output



#./configure --host=arm-linux-androideabi --enable-static-link --build=arm-linux-androideabi --host=i686-linux

#./configure --target=arm-none-linux-androideabi --host=i686-linux --enable-static=true --prefix=/home/kkho/em_output --exec-prefix=/home/kkho/em_output

sudo make clean
sudo make
sudo make install

