SUMMARY = "Custom Yocto image for Raspberry Pi CM4 industrial gateway"
LICENSE = "MIT"

inherit core-image
inherit extrausers

IMAGE_FEATURES += "ssh-server-openssh"
DEPENDS += "qtbase qtdeclarative"
RDEPENDS:${PN} += "qtbase qtdeclarative"
IMAGE_INSTALL:append = " dl-device "

PASSWD = "\$5\$y9Aeg5ctwntRHo/g\$CAKtoTfQg7VPGfVAMGo5ZG/0GJLn3AD0JdoQ.i0dDFC"
EXTRA_USERS_PARAMS = "\
    usermod -p '${PASSWD}' root; \
    "

IMAGE_INSTALL:append = " \
    bash \
    busybox \
    iproute2 \
    iputils \
    net-tools \
    can-utils \
    i2c-tools \
    python3 \
    python3-pip \
    minicom \
    can0-bringup \
    u-boot \
    u-boot-default-env \
"