FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI:append = " file://dnsmasq.conf \
                   file://dnsmasq.service.override \
                "

do_install:append() {
    install -d ${D}${sysconfdir}/dnsmasq.d
    install -m 0644 ${WORKDIR}/dnsmasq.conf ${D}${sysconfdir}/dnsmasq.d/dnsmasq.conf

    install -d ${D}${systemd_system_unitdir}/dnsmasq.service.d
    install -m 0644 ${WORKDIR}/dnsmasq.service.override \
        ${D}${systemd_system_unitdir}/dnsmasq.service.d/override.conf
}

CONFFILES:${PN} += "${sysconfdir}/dnsmasq.d/dnsmasq.conf"

FILES:${PN}:append = " ${systemd_system_unitdir}/dnsmasq.service.d \
                       ${systemd_system_unitdir}/dnsmasq.service.d/override.conf"