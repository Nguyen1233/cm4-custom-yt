SUMMARY = "DL_Device applications (from GitHub)"
DESCRIPTION = "Build and install DL_Device apps from https://github.com/bienxanh1901/DL_Device"
LICENSE = "CLOSED"

DEPENDS = "dbus qtbase qtserialport qtserialbus qtmqtt"

SRC_URI = "gitsm://git@github.com/bienxanh1901/DL_Device.git;branch=dev;protocol=ssh; \
           file://datalogger.logrotate \
           file://datalogger.service \
           file://seriallistener.logrotate \
           file://seriallistener.service \
           file://webserver.logrotate \
           file://webserver.service \
    "

SRCREV = "${AUTOREV}"
PV = "1.0+git${SRCPV}"

S = "${WORKDIR}/git"

inherit cmake pkgconfig qt6-cmake systemd

EXTRA_OECMAKE ?= ""

do_install:append() {
    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/datalogger.service ${D}${systemd_system_unitdir}/datalogger.service
    install -d ${D}${sysconfdir}/logrotate.d
    install -m 0644 ${WORKDIR}/datalogger.logrotate ${D}${sysconfdir}/logrotate.d/datalogger

    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/seriallistener.service ${D}${systemd_system_unitdir}/seriallistener.service
    install -d ${D}${sysconfdir}/logrotate.d
    install -m 0644 ${WORKDIR}/seriallistener.logrotate ${D}${sysconfdir}/logrotate.d/seriallistener

    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/webserver.service ${D}${systemd_system_unitdir}/webserver.service
    install -d ${D}${sysconfdir}/logrotate.d
    install -m 0644 ${WORKDIR}/webserver.logrotate ${D}${sysconfdir}/logrotate.d/webserver
}