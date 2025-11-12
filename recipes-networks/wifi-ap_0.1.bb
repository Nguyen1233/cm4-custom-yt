
SUMMARY = "Wi-Fi Access Point configuration for Raspberry Pi CM4"
DESCRIPTION = "Installs and configures hostapd and dnsmasq for AP mode"
LICENSE = "CLOSED"
PR = "r0"

# Required packages
DEPENDS = "hostapd dnsmasq iw wpa-supplicant"

# Install configuration files

SRC_URI = "file://hostapd.conf \
           file://dnsmasq.conf \
           file://wifi-ap.service"

S = "${WORKDIR}"

do_install() {
    # Hostapd configuration
    install -d ${D}${sysconfdir}/hostapd
    install -m 0644 ${WORKDIR}/hostapd.conf ${D}${sysconfdir}/hostapd/hostapd.conf

    # Dnsmasq custom config in dnsmasq.d to avoid conflict
    install -d ${D}${sysconfdir}/dnsmasq.d
    install -m 0644 ${WORKDIR}/dnsmasq.conf ${D}${sysconfdir}/dnsmasq.d/wifi-ap.conf

    # Systemd service for hostapd
    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/wifi-ap.service ${D}${systemd_system_unitdir}/wifi-ap.service
}

FILES:${PN} += "${sysconfdir}/hostapd/hostapd.conf \
                ${sysconfdir}/dnsmasq.d/wifi-ap.conf \
                ${systemd_system_unitdir}/wifi-ap.service"

CONFFILES:${PN} += "${sysconfdir}/hostapd/hostapd.conf \
                    ${sysconfdir}/dnsmasq.d/wifi-ap.conf"

SYSTEMD_AUTO_ENABLE:${PN} = "enable"
SYSTEMD_SERVICE:${PN} = "wifi-ap.service"
