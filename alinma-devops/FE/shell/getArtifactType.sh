#################################################################
# Script Purpose is to get artifact version from pom.properties #
#################################################################

#!/bin/bash

WORKSPACE=$1
uservice=$1

#grep packaging ${WORKSPACE}/CI-Pipelines/Code/${uservice}/pom.xml | sed 's/[[:blank:]]<packaging>//g; s/<\/packaging>//g'
grep packaging ${WORKSPACE}/CI-Pipelines/alinma-accounts-git-ci/Code/pom.xml | sed 's/[[:blank:]]<packaging>//g; s/<\/packaging>//g'
