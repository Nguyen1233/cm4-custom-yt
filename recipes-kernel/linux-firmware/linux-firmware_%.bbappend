do_install:append() {
    dest="${D}${nonarch_base_libdir}/firmware/brcm"

    if [ -d "${dest}" ]; then
        if [ -f "${dest}/brcmfmac43455-sdio.bin" ]; then
            ln -sf brcmfmac43455-sdio.bin \
                "${dest}/brcmfmac43455-sdio.raspberrypi,4-compute-module.bin"
        fi

        if [ -f "${dest}/brcmfmac43455-sdio.clm_blob" ]; then
            ln -sf brcmfmac43455-sdio.clm_blob \
                "${dest}/brcmfmac43455-sdio.raspberrypi,4-compute-module.clm_blob"
        fi

        if [ -f "${dest}/brcmfmac43455-sdio.raspberrypi,4-model-b.txt" ]; then
            ln -sf brcmfmac43455-sdio.raspberrypi,4-model-b.txt \
                "${dest}/brcmfmac43455-sdio.raspberrypi,4-compute-module.txt"
        fi
    fi
}

FILES:${PN}-bcm43455:append = " \
    ${nonarch_base_libdir}/firmware/brcm/brcmfmac43455-sdio.raspberrypi,4-compute-module.bin \
    ${nonarch_base_libdir}/firmware/brcm/brcmfmac43455-sdio.raspberrypi,4-compute-module.clm_blob \
    ${nonarch_base_libdir}/firmware/brcm/brcmfmac43455-sdio.raspberrypi,4-compute-module.txt \
"
