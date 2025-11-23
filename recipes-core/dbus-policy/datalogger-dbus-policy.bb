SUMMARY = "DBus policy for org.promiselabs.DataLogger"
LICENSE = "CLOSED"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI = "file://org.promiselabs.datalogger.conf"

do_install() {
    install -d ${D}${sysconfdir}/dbus-1/system.d
    install -m 0644 ${WORKDIR}/org.promiselabs.datalogger.conf \
        ${D}${sysconfdir}/dbus-1/system.d/
}

FILES:${PN} += "${sysconfdir}/dbus-1/system.d/org.promiselabs.datalogger.conf"