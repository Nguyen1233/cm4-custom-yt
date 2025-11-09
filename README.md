# cm4-custom-yt

#tree
# 1. Poky (core)
git clone -b kirkstone git://git.yoctoproject.org/poky.git
# 2. meta-openembedded
git clone -b kirkstone git://git.openembedded.org/meta-openembedded
# 3. meta-raspberrypi (support Raspberry Pi & CM4)
git clone -b kirkstone https://git.yoctoproject.org/meta-raspberrypi
# 4. meta-qt6
git clone -b 6.6 https://github.com/YoeDistro/meta-qt6.git


yocto-cm4/
├─ poky/
├─ meta-openembedded/
├─ meta-raspberrypi/
├─ meta-qt6/            
└─ meta-cm4-custom/
   ├─ conf/
   ├─ recipes-core/
   ├─ recipes-bsp/
   ├─ meta-dl-device/
  
  + source poky/oe-init-build-env build-cm4
  + bitbake cm4-custom

