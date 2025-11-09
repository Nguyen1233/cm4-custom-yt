# meta-dl-device/recipes-apps/dl-device/dl-device_git.bb

SUMMARY = "DL_Device applications (from GitHub)"
DESCRIPTION = "Build and install DL_Device apps from https://github.com/bienxanh1901/DL_Device"
LICENSE = "CLOSED"

# If the project has a LICENSE file you want to reference, replace CLOSED with proper license
# and set LIC_FILES_CHKSUM accordingly, e.g.:
# LICENSE = "MIT"
# LIC_FILES_CHKSUM = "file://LICENSE;md5=<PUT_MD5_HERE>"

# Fetch from Git (with submodules if any)
SRC_URI = "git://github.com/bienxanh1901/DL_Device.git;branch=dev_version;protocol=ssh;user=git;submodules=1"
# Có thể giữ AUTOREV (không khuyến nghị cho release), hoặc pin:
SRCREV = "e3f957f0a3ad67b1bb4b077c1e91d31ddc78c901"
# hoặc pin SHA như cách 1


S = "${WORKDIR}/git"

# Assume the project uses CMake (change inherit if it's qmake/meson/autotools)
inherit cmake pkgconfig qt6-cmake

# Extra CMake options (edit as needed)
EXTRA_OECMAKE ?= ""

# If the project doesn't define an install step, you can add a fallback do_install()
# by uncommenting the following block and adjusting binary names/paths.
#
# do_install:append() {
#     # Example fallback: install built binaries if the project lacks 'install' target
#     if [ -f "${B}/datalogger" ]; then
#         install -d ${D}${bindir}
#         install -m 0755 ${B}/datalogger ${D}${bindir}/
#     fi
#     if [ -f "${B}/seriallistener" ]; then
#         install -d ${D}${bindir}
#         install -m 0755 ${B}/seriallistener ${D}${bindir}/
#     fi
# }
#
# If the binaries install to non-standard paths, list them here:
FILES:${PN} += " ${bindir}/* "
IMAGE_INSTALL:append = " \
  qtbase \
  qtbase-plugins \
  qtserialport \
  qtserialbus \
  qtbase-tools \
  sqlite3 \
  qtmqtt \
"

# If Qt is required, uncomment appropriate dependencies (adjust versions as needed)
DEPENDS += "zeromq cppzmq qtbase qtdeclarative qtserialport qtserialbus qtmqtt"
RDEPENDS:${PN} += "zeromq qtbase qtdeclarative qtserialport qtserialbus qtmqtt"

