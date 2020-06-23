#################################################################
# Script Purpose is to get artifact version from pom.properties #
#################################################################

#!/bin/bash

WORKSPACE=$1
uservice=$2

#grep packaging ${WORKSPACE}/Code/${uservice}/pom.xml | sed 's/[[:blank:]]<packaging>//g; s/<\/packaging>//g'
grep packaging ${WORKSPACE}/Code/pom.xml | sed 's/[[:blank:]]<packaging>//g; s/<\/packaging>//g'
