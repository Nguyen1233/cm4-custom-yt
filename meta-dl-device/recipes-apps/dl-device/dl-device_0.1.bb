SUMMARY = "DL_Device applications (from GitHub)"
DESCRIPTION = "Build and install DL_Device apps from https://github.com/bienxanh1901/DL_Device"
LICENSE = "CLOSED"

DEPENDS = "dbus qtbase qtserialport qtserialbus qtmqtt opencv"

SRC_URI = "gitsm://git@github.com/bienxanh1901/DL_Device.git;branch=test_flow;protocol=ssh; \
           file://datalogger.logrotate \
           file://datalogger.service \
           file://stationmanager.logrotate \
           file://stationmanager.service \
           file://webserver.logrotate \
           file://webserver.service \
    "

SRCREV = "${AUTOREV}"
PV = "1.0+git${SRCPV}"

S = "${WORKDIR}/git"

inherit cmake pkgconfig qt6-cmake systemd

EXTRA_OECMAKE ?= ""

SYSTEMD_SERVICE:${PN} = "webserver.service stationmanager.service datalogger.service"
SYSTEMD_AUTO_ENABLE:${PN} = "enable"

do_install:append() {
    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/datalogger.service ${D}${systemd_system_unitdir}/datalogger.service
    install -m 0644 ${WORKDIR}/stationmanager.service ${D}${systemd_system_unitdir}/stationmanager.service
    install -m 0644 ${WORKDIR}/webserver.service ${D}${systemd_system_unitdir}/webserver.service
    install -d ${D}${sysconfdir}/logrotate.d
    install -m 0644 ${WORKDIR}/datalogger.logrotate ${D}${sysconfdir}/logrotate.d/datalogger
    install -m 0644 ${WORKDIR}/stationmanager.logrotate ${D}${sysconfdir}/logrotate.d/stationmanager
    install -m 0644 ${WORKDIR}/webserver.logrotate ${D}${sysconfdir}/logrotate.d/webserver
}

FILES:${PN} += "${systemd_system_unitdir}/datalogger.service \
                ${systemd_system_unitdir}/stationmanager.service \
                ${systemd_system_unitdir}/webserver.service \
                ${sysconfdir}/logrotate.d/datalogger \
                ${sysconfdir}/logrotate.d/stationmanager \
                ${sysconfdir}/logrotate.d/webserver \
                /usr/bin/wifi-auto-switch.sh"

FILES:${PN} += " \
    /opt/datalogger \
    /opt/datalogger/model \
    /opt/datalogger/model/* \
"