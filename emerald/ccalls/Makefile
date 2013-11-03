# Makefile.in generated automatically by automake 1.5 from Makefile.am.

# Copyright 1994, 1995, 1996, 1997, 1998, 1999, 2000, 2001
# Free Software Foundation, Inc.
# This Makefile.in is free software; the Free Software Foundation
# gives unlimited permission to copy and/or distribute it,
# with or without modifications, as long as this notice is preserved.

# This program is distributed in the hope that it will be useful,
# but WITHOUT ANY WARRANTY, to the extent permitted by law; without
# even the implied warranty of MERCHANTABILITY or FITNESS FOR A
# PARTICULAR PURPOSE.



SHELL = /bin/sh

srcdir = .
top_srcdir = ..

prefix = /home/kkho/em_beta
exec_prefix = ${prefix}

bindir = ${exec_prefix}/bin
sbindir = ${exec_prefix}/sbin
libexecdir = ${exec_prefix}/libexec
datadir = ${prefix}/share
sysconfdir = ${prefix}/etc
sharedstatedir = ${prefix}/com
localstatedir = ${prefix}/var
libdir = ${exec_prefix}/lib
infodir = ${prefix}/info
mandir = ${prefix}/man
includedir = ${prefix}/include
oldincludedir = /usr/include
pkgdatadir = $(datadir)/emerald
pkglibdir = $(libdir)/emerald
pkgincludedir = $(includedir)/emerald
top_builddir = ..

ACLOCAL = ${SHELL} /home/kkho/emerald/missing --run aclocal
AUTOCONF = ${SHELL} /home/kkho/emerald/missing --run autoconf
AUTOMAKE = ${SHELL} /home/kkho/emerald/missing --run automake
AUTOHEADER = ${SHELL} /home/kkho/emerald/missing --run autoheader

INSTALL = /usr/bin/install -c
INSTALL_PROGRAM = ${INSTALL}
INSTALL_DATA = ${INSTALL} -m 644
INSTALL_SCRIPT = ${INSTALL}
INSTALL_HEADER = $(INSTALL_DATA)
transform = s,x,x,
NORMAL_INSTALL = :
PRE_INSTALL = :
POST_INSTALL = :
NORMAL_UNINSTALL = :
PRE_UNINSTALL = :
POST_UNINSTALL = :
AMTAR = ${SHELL} /home/kkho/emerald/missing --run tar
AWK = gawk
CC = gcc
DEPDIR = .deps
EXEEXT = 
INSTALL_STRIP_PROGRAM = ${SHELL} $(install_sh) -c -s
LEX = flex
LN_S = ln -s
OBJEXT = o
PACKAGE = emerald
RANLIB = ranlib
SH = /bin/sh
VERSION = 1.06alpha
YACC = bison -y
am__include = include
am__quote = 
install_sh = /home/kkho/emerald/install-sh

noinst_LIBRARIES = libccalls.a

libccalls_a_SOURCES = emstream/emstream.c \
	emstream/emstream.h \
	string/string.h \
	string/string.c \
	rand/rand.h \
	rand/rand.c \
	misk/misk.c  \
	misk/misk.h 


#	regexp/regexp.c \
#	xforms/xforms.c \
#	xforms/xforms.h \
#	xliba/xliba.c \
#	xliba/xliba.h \
#	xta/xta.c \
#	xta/xta.h \
#	xta/xta.va \
#	xma/xma.c \
#	xma/xma.h \
#	bani/bani.c \
#	bani/bani.h \
#	myristream/myristream.c
#	myristream/myristream.h

#libccalls_a_DEPENDENCIES = export
BUILT_SOURCES = emstream.h string.h rand.h misk.h
CLEANFILES = emstream.h string.h rand.h misk.h

INCLUDES = -I../vm/src #-I./string -I./emstream -I./rand -I./misk

EXTRA_DIST = bani misc myristream notreadable regexp xforms xliba xma xta

DOTHS = \
        emstream.h \
        string.h \
        rand.h \
        misk.h \
        regexp.h \
        xforms.h \
        xliba.h \
        xta.h \
        xma.h \
        bani.h \
        myristream.h

subdir = ccalls
mkinstalldirs = $(SHELL) $(top_srcdir)/mkinstalldirs
CONFIG_CLEAN_FILES =
LIBRARIES = $(noinst_LIBRARIES)

libccalls_a_AR = $(AR) cru
libccalls_a_LIBADD =
am_libccalls_a_OBJECTS = emstream.$(OBJEXT) string.$(OBJEXT) \
	rand.$(OBJEXT) misk.$(OBJEXT)
libccalls_a_OBJECTS = $(am_libccalls_a_OBJECTS)

DEFS = -DPACKAGE_NAME=\"\" -DPACKAGE_TARNAME=\"\" -DPACKAGE_VERSION=\"\" -DPACKAGE_STRING=\"\" -DPACKAGE_BUGREPORT=\"\" -DPACKAGE=\"emerald\" -DVERSION=\"1.06alpha\" -DSINGLESTEP=1 -DCOUNTBYTECODES=1 -DSTDARG_WORKS=1 -DDISTRIBUTED=1 -DYYTEXT_POINTER=1 -DHAVE_LIBL=1 -DHAVE_LIBM=1 -DHAVE_DIRENT_H=1 -DSTDC_HEADERS=1 -DHAVE_SYS_TYPES_H=1 -DHAVE_SYS_STAT_H=1 -DHAVE_STDLIB_H=1 -DHAVE_STRING_H=1 -DHAVE_MEMORY_H=1 -DHAVE_STRINGS_H=1 -DHAVE_INTTYPES_H=1 -DHAVE_STDINT_H=1 -DHAVE_UNISTD_H=1 -DHAVE_FCNTL_H=1 -DHAVE_SYS_FILE_H=1 -DHAVE_SYS_TIME_H=1 -DHAVE_UNISTD_H=1 -DTIME_WITH_SYS_TIME=1 -DRETSIGTYPE=void -DHAVE_STRFTIME=1 -DHAVE_VPRINTF=1 -DHAVE_FTIME=1 -DHAVE_GETHOSTNAME=1 -DHAVE_GETTIMEOFDAY=1 -DHAVE_MKTIME=1 -DHAVE_REGCOMP=1 -DHAVE_SOCKET=1 -DHAVE_STRCSPN=1 -DHAVE_STRERROR=1 
DEFAULT_INCLUDES =  -I. -I$(srcdir)
CPPFLAGS = 
LDFLAGS = 
LIBS = -lm -ll 
depcomp = $(SHELL) $(top_srcdir)/depcomp
DEP_FILES = $(DEPDIR)/emstream.Po $(DEPDIR)/misk.Po \
	$(DEPDIR)/rand.Po $(DEPDIR)/string.Po
COMPILE = $(CC) $(DEFS) $(DEFAULT_INCLUDES) $(INCLUDES) $(AM_CPPFLAGS) \
	$(CPPFLAGS) $(AM_CFLAGS) $(CFLAGS)
CCLD = $(CC)
LINK = $(CCLD) $(AM_CFLAGS) $(CFLAGS) $(AM_LDFLAGS) $(LDFLAGS) -o $@
CFLAGS = -g -O2
DIST_SOURCES = $(libccalls_a_SOURCES)
DIST_COMMON = Makefile.am Makefile.in
SOURCES = $(libccalls_a_SOURCES)

all: $(BUILT_SOURCES)
	$(MAKE) $(AM_MAKEFLAGS) all-am

.SUFFIXES:
.SUFFIXES: .c .o .obj
$(srcdir)/Makefile.in:  Makefile.am  $(top_srcdir)/configure.ac $(ACLOCAL_M4)
	cd $(top_srcdir) && \
	  $(AUTOMAKE) --gnu  ccalls/Makefile
Makefile:  $(srcdir)/Makefile.in  $(top_builddir)/config.status
	cd $(top_builddir) && \
	  CONFIG_HEADERS= CONFIG_LINKS= \
	  CONFIG_FILES=$(subdir)/$@ $(SHELL) ./config.status

AR = ar

clean-noinstLIBRARIES:
	-test -z "$(noinst_LIBRARIES)" || rm -f $(noinst_LIBRARIES)
emstream.$(OBJEXT): emstream/emstream.c
string.$(OBJEXT): string/string.c
rand.$(OBJEXT): rand/rand.c
misk.$(OBJEXT): misk/misk.c
libccalls.a: $(libccalls_a_OBJECTS) $(libccalls_a_DEPENDENCIES) 
	-rm -f libccalls.a
	$(libccalls_a_AR) libccalls.a $(libccalls_a_OBJECTS) $(libccalls_a_LIBADD)
	$(RANLIB) libccalls.a

mostlyclean-compile:
	-rm -f *.$(OBJEXT) core *.core

distclean-compile:
	-rm -f *.tab.c

include $(DEPDIR)/emstream.Po
include $(DEPDIR)/misk.Po
include $(DEPDIR)/rand.Po
include $(DEPDIR)/string.Po

distclean-depend:
	-rm -rf $(DEPDIR)

.c.o:
	source='$<' object='$@' libtool=no \
	depfile='$(DEPDIR)/$*.Po' tmpdepfile='$(DEPDIR)/$*.TPo' \
	$(CCDEPMODE) $(depcomp) \
	$(COMPILE) -c `test -f $< || echo '$(srcdir)/'`$<

.c.obj:
	source='$<' object='$@' libtool=no \
	depfile='$(DEPDIR)/$*.Po' tmpdepfile='$(DEPDIR)/$*.TPo' \
	$(CCDEPMODE) $(depcomp) \
	$(COMPILE) -c `cygpath -w $<`

emstream.o: emstream/emstream.c
	source='emstream/emstream.c' object='emstream.o' libtool=no \
	depfile='$(DEPDIR)/emstream.Po' tmpdepfile='$(DEPDIR)/emstream.TPo' \
	$(CCDEPMODE) $(depcomp) \
	$(CC) $(DEFS) $(DEFAULT_INCLUDES) $(INCLUDES) $(AM_CPPFLAGS) $(CPPFLAGS) $(AM_CFLAGS) $(CFLAGS) -c -o emstream.o `test -f emstream/emstream.c || echo '$(srcdir)/'`emstream/emstream.c

emstream.obj: emstream/emstream.c
	source='emstream/emstream.c' object='emstream.obj' libtool=no \
	depfile='$(DEPDIR)/emstream.Po' tmpdepfile='$(DEPDIR)/emstream.TPo' \
	$(CCDEPMODE) $(depcomp) \
	$(CC) $(DEFS) $(DEFAULT_INCLUDES) $(INCLUDES) $(AM_CPPFLAGS) $(CPPFLAGS) $(AM_CFLAGS) $(CFLAGS) -c -o emstream.obj `cygpath -w emstream/emstream.c`

string.o: string/string.c
	source='string/string.c' object='string.o' libtool=no \
	depfile='$(DEPDIR)/string.Po' tmpdepfile='$(DEPDIR)/string.TPo' \
	$(CCDEPMODE) $(depcomp) \
	$(CC) $(DEFS) $(DEFAULT_INCLUDES) $(INCLUDES) $(AM_CPPFLAGS) $(CPPFLAGS) $(AM_CFLAGS) $(CFLAGS) -c -o string.o `test -f string/string.c || echo '$(srcdir)/'`string/string.c

string.obj: string/string.c
	source='string/string.c' object='string.obj' libtool=no \
	depfile='$(DEPDIR)/string.Po' tmpdepfile='$(DEPDIR)/string.TPo' \
	$(CCDEPMODE) $(depcomp) \
	$(CC) $(DEFS) $(DEFAULT_INCLUDES) $(INCLUDES) $(AM_CPPFLAGS) $(CPPFLAGS) $(AM_CFLAGS) $(CFLAGS) -c -o string.obj `cygpath -w string/string.c`

rand.o: rand/rand.c
	source='rand/rand.c' object='rand.o' libtool=no \
	depfile='$(DEPDIR)/rand.Po' tmpdepfile='$(DEPDIR)/rand.TPo' \
	$(CCDEPMODE) $(depcomp) \
	$(CC) $(DEFS) $(DEFAULT_INCLUDES) $(INCLUDES) $(AM_CPPFLAGS) $(CPPFLAGS) $(AM_CFLAGS) $(CFLAGS) -c -o rand.o `test -f rand/rand.c || echo '$(srcdir)/'`rand/rand.c

rand.obj: rand/rand.c
	source='rand/rand.c' object='rand.obj' libtool=no \
	depfile='$(DEPDIR)/rand.Po' tmpdepfile='$(DEPDIR)/rand.TPo' \
	$(CCDEPMODE) $(depcomp) \
	$(CC) $(DEFS) $(DEFAULT_INCLUDES) $(INCLUDES) $(AM_CPPFLAGS) $(CPPFLAGS) $(AM_CFLAGS) $(CFLAGS) -c -o rand.obj `cygpath -w rand/rand.c`

misk.o: misk/misk.c
	source='misk/misk.c' object='misk.o' libtool=no \
	depfile='$(DEPDIR)/misk.Po' tmpdepfile='$(DEPDIR)/misk.TPo' \
	$(CCDEPMODE) $(depcomp) \
	$(CC) $(DEFS) $(DEFAULT_INCLUDES) $(INCLUDES) $(AM_CPPFLAGS) $(CPPFLAGS) $(AM_CFLAGS) $(CFLAGS) -c -o misk.o `test -f misk/misk.c || echo '$(srcdir)/'`misk/misk.c

misk.obj: misk/misk.c
	source='misk/misk.c' object='misk.obj' libtool=no \
	depfile='$(DEPDIR)/misk.Po' tmpdepfile='$(DEPDIR)/misk.TPo' \
	$(CCDEPMODE) $(depcomp) \
	$(CC) $(DEFS) $(DEFAULT_INCLUDES) $(INCLUDES) $(AM_CPPFLAGS) $(CPPFLAGS) $(AM_CFLAGS) $(CFLAGS) -c -o misk.obj `cygpath -w misk/misk.c`
CCDEPMODE = depmode=gcc3
uninstall-info-am:

tags: TAGS

ID: $(HEADERS) $(SOURCES) $(LISP) $(TAGS_FILES)
	list='$(SOURCES) $(HEADERS) $(TAGS_FILES)'; \
	unique=`for i in $$list; do \
	    if test -f "$$i"; then echo $$i; else echo $(srcdir)/$$i; fi; \
	  done | \
	  $(AWK) '    { files[$$0] = 1; } \
	       END { for (i in files) print i; }'`; \
	mkid -fID $$unique $(LISP)

TAGS:  $(HEADERS) $(SOURCES)  $(TAGS_DEPENDENCIES) \
		$(TAGS_FILES) $(LISP)
	tags=; \
	here=`pwd`; \
	list='$(SOURCES) $(HEADERS) $(TAGS_FILES)'; \
	unique=`for i in $$list; do \
	    if test -f "$$i"; then echo $$i; else echo $(srcdir)/$$i; fi; \
	  done | \
	  $(AWK) '    { files[$$0] = 1; } \
	       END { for (i in files) print i; }'`; \
	test -z "$(ETAGS_ARGS)$$unique$(LISP)$$tags" \
	  || etags $(ETAGS_ARGS) $$tags  $$unique $(LISP)

GTAGS:
	here=`CDPATH=: && cd $(top_builddir) && pwd` \
	  && cd $(top_srcdir) \
	  && gtags -i $(GTAGS_ARGS) $$here

distclean-tags:
	-rm -f TAGS ID GTAGS GRTAGS GSYMS GPATH

DISTFILES = $(DIST_COMMON) $(DIST_SOURCES) $(TEXINFOS) $(EXTRA_DIST)

top_distdir = ..
distdir = $(top_distdir)/$(PACKAGE)-$(VERSION)

distdir: $(DISTFILES)
	@for file in $(DISTFILES); do \
	  if test -f $$file; then d=.; else d=$(srcdir); fi; \
	  dir=`echo "$$file" | sed -e 's,/[^/]*$$,,'`; \
	  if test "$$dir" != "$$file" && test "$$dir" != "."; then \
	    $(mkinstalldirs) "$(distdir)/$$dir"; \
	  fi; \
	  if test -d $$d/$$file; then \
	    cp -pR $$d/$$file $(distdir) \
	    || exit 1; \
	  else \
	    test -f $(distdir)/$$file \
	    || cp -p $$d/$$file $(distdir)/$$file \
	    || exit 1; \
	  fi; \
	done
check-am: all-am
check: check-am
all-am: Makefile $(LIBRARIES)

installdirs:

install: install-am
install-exec: install-exec-am
install-data: install-data-am
uninstall: uninstall-am

install-am: all-am
	@$(MAKE) $(AM_MAKEFLAGS) install-exec-am install-data-am

installcheck: installcheck-am
install-strip:
	$(MAKE) $(AM_MAKEFLAGS) INSTALL_PROGRAM="$(INSTALL_STRIP_PROGRAM)" \
	  `test -z '$(STRIP)' || \
	    echo "INSTALL_PROGRAM_ENV=STRIPPROG='$(STRIP)'"` install
mostlyclean-generic:

clean-generic:
	-test -z "$(CLEANFILES)" || rm -f $(CLEANFILES)

distclean-generic:
	-rm -f Makefile $(CONFIG_CLEAN_FILES) stamp-h stamp-h[0-9]*

maintainer-clean-generic:
	@echo "This command is intended for maintainers to use"
	@echo "it deletes files that may require special tools to rebuild."
	-test -z "$(BUILT_SOURCES)" || rm -f $(BUILT_SOURCES)
clean: clean-am

clean-am: clean-generic clean-noinstLIBRARIES mostlyclean-am

distclean: distclean-am

distclean-am: clean-am distclean-compile distclean-depend \
	distclean-generic distclean-tags

dvi: dvi-am

dvi-am:

info: info-am

info-am:

install-data-am:

install-exec-am:

install-info: install-info-am

install-man:

installcheck-am:

maintainer-clean: maintainer-clean-am

maintainer-clean-am: distclean-am maintainer-clean-generic

mostlyclean: mostlyclean-am

mostlyclean-am: mostlyclean-compile mostlyclean-generic

uninstall-am: uninstall-info-am

.PHONY: GTAGS all all-am check check-am clean clean-generic \
	clean-noinstLIBRARIES distclean distclean-compile \
	distclean-depend distclean-generic distclean-tags distdir dvi \
	dvi-am info info-am install install-am install-data \
	install-data-am install-exec install-exec-am install-info \
	install-info-am install-man install-strip installcheck \
	installcheck-am installdirs maintainer-clean \
	maintainer-clean-generic mostlyclean mostlyclean-compile \
	mostlyclean-generic tags uninstall uninstall-am \
	uninstall-info-am


dummy:
	echo hum;
	cd ../vm/src/; make codeptrextra.h;cd ../../ccalls

emstream.h: dummy
	cp emstream/emstream.h .

string.h: dummy
	cp string/string.h .

rand.h: dummy
	cp rand/rand.h .

misk.h:dummy
	cp misk/misk.h .

doths:
	@echo $(DOTHS)
# Tell versions [3.59,3.63) of GNU make to not export all variables.
# Otherwise a system limit (for SysV at least) may be exceeded.
.NOEXPORT:
