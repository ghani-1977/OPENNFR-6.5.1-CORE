FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-2.33:"

SRC_URI += " file://0001-ptrace-protect-ptrace_peeksiginfo_args-from-redefint.patch \
             file://0002-fix-build-for-old-libcheader.patch \
             file://0003-glibc-c-utf8-locale.patch \
             file://0004-sunrpc-use-snprintf-instead-of-an-implied-length-gua.patch \
"

SRC_URI_append_arm = " file://stdlib-canonicalize-realpath_stk-dest-maybe-uninit.patch"

SSTATE_DUPWHITELIST += "${STAGING_INCDIR}/netatalk/at.h ${STAGING_INCDIR}/scsi/scsi_ioctl.h ${STAGING_INCDIR}/scsi/sg.h"
