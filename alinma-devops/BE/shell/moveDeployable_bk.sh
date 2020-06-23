#################################################################
# Script Purpose is to move deployable war to ansible source directory #
#################################################################

#!/bin/bash


sudo cp /home/jenkins/.m2/repository/com/alinma/rib/${uservice}/${ARTIFACT_VERSION}/*.war /etc/ansible/deploy_service/DEV/artifacts/
