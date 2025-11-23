FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI:append = " file://cm4-wifi-wcc.cfg"

KERNEL_CONFIG_FRAGMENTS:append = " cm4-wifi-wcc.cfg"