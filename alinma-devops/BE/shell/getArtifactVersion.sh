#################################################################
# Script Purpose is to get artifact version from pom.properties #
#################################################################

#!/bin/bash

WORKSPACE=$1
uservice=$2

#grep version ${WORKSPACE}/Code/${uservice}/target/maven-archiver/pom.properties | cut -d'=' -f2
grep version ${WORKSPACE}/Code/target/maven-archiver/pom.properties | cut -d'=' -f2
