FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI:append = " file://hostapd.conf"

do_install:append() {
    install -d ${D}${sysconfdir}
    install -m 0600 ${WORKDIR}/hostapd.conf ${D}${sysconfdir}/hostapd.conf
}

CONFFILES:${PN} += " ${sysconfdir}/hostapd.conf"

SYSTEMD_AUTO_ENABLE:${PN} = "enable"
