DESCRIPTION = "serviceapp service for enigma2"
AUTHOR = "Maroš Ondrášek <mx3ldev@gmail.com>"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

DEPENDS = "enigma2 uchardet openssl"
RDEPENDS_${PN} = "enigma2 uchardet openssl exteplayer3 ${PYTHON_PN}-json"
RCONFLICTS_${PN} = "enigma2-plugin-extensions-serviceapp"
RREPLACES_${PN} = "enigma2-plugin-extensions-serviceapp"

SRCREV = "${AUTOREV}"
SRC_URI = "git://github.com/oe-mirrors/serviceapp.git;branch=develop"
SRC_URI_openvix = "git://github.com/OpenViX/serviceapp.git;branch=develop"


S = "${WORKDIR}/git"

inherit autotools gitpkgv ${PYTHON_PN}native pkgconfig gettext ${@bb.utils.contains("PYTHON_PN", "python3", "python3targetconfig", "", d)}

CXXFLAGS_append = " -std=c++11"

PV = "0.5+git${SRCPV}"
PKGV = "0.5+git${GITPKGV}"

PR = "r0"

EXTRA_OECONF = "\
	BUILD_SYS=${BUILD_SYS} \
	HOST_SYS=${HOST_SYS} \
	STAGING_INCDIR=${STAGING_INCDIR} \
	STAGING_LIBDIR=${STAGING_LIBDIR} \
	"

PACKAGES = "${PN} ${PN}-src ${PN}-dbg"

FILES_${PN} = "\
    ${libdir}/enigma2/python/Plugins/SystemPlugins/ServiceApp/*.py \
    ${libdir}/enigma2/python/Plugins/SystemPlugins/ServiceApp/serviceapp.so \
    ${libdir}/enigma2/python/Plugins/SystemPlugins/ServiceApp/locale/*/*/*.mo \
    "

FILES_${PN}-src = "\
    ${libdir}/enigma2/python/Plugins/SystemPlugins/ServiceApp/locale/*/LC_MESSAGES/*.mo \
    /usr/src/debug/* \
    "

FILES_${PN}-dbg = "\
    ${libdir}/enigma2/python/Plugins/SystemPlugins/ServiceApp/serviceapp.la \
    /usr/src/debug/enigma2-plugin-systemplugins-serviceapp/*/*/*/*/*.cpp \
    /usr/src/debug/enigma2-plugin-systemplugins-serviceapp/*/*/*/*/*.h \
    /usr/src/debug/enigma2-plugin-systemplugins-serviceapp/*/*/*/*/*.c \
    /usr/src/debug/enigma2-plugin-systemplugins-serviceapp/*/*/*/*/*/*.cpp \
    /usr/src/debug/enigma2-plugin-systemplugins-serviceapp/*/*/*/*/*/*.h \
    /usr/src/debug/enigma2-plugin-systemplugins-serviceapp/*/*/*/*/*/*.c \
    "
