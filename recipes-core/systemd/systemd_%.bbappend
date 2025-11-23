PACKAGECONFIG:append = " networkd resolved"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += " \
    file://10-eth0-static.network \
    file://20-wlan0-ap.network \
"

FILES:${PN} += " \
    ${sysconfdir}/systemd/network/10-eth0-static.network \
    ${sysconfdir}/systemd/network/20-wlan0-ap.network \
"

do_install:append() {
    install -d ${D}${sysconfdir}/systemd/network
    install -m 0644 ${WORKDIR}/10-eth0-static.network ${D}${sysconfdir}/systemd/network
    install -m 0644 ${WORKDIR}/20-wlan0-ap.network ${D}${sysconfdir}/systemd/network
}

FILES:${PN}-networkd:append = " ${sysconfdir}/systemd/network/10-eth0-static.network ${sysconfdir}/systemd/network/20-wlan0-ap.network"