SUMMARY = "Auto bring-up CAN0 on CM4 at boot"
DESCRIPTION = "Installs script and systemd service to configure and enable CAN0 (mcp2515 via SPI) with desired bitrate."
LICENSE = "CLOSED"

SRC_URI = " \
    file://can0-bringup.sh \
    file://can0-bringup.service \
"

S = "${WORKDIR}"

inherit systemd

SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE:${PN} = "can0-bringup.service"

do_install() {
    install -d ${D}${sbindir}
    install -m 0755 ${WORKDIR}/can0-bringup.sh ${D}${sbindir}/can0-bringup.sh

    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/can0-bringup.service ${D}${systemd_system_unitdir}/can0-bringup.service
}

FILES:${PN} += " \
    ${sbindir}/can0-bringup.sh \
    ${systemd_system_unitdir}/can0-bringup.service \
"

RDEPENDS:${PN} += "iproute2"
SYSTEMD_AUTO_ENABLE:${PN} = "enable"
