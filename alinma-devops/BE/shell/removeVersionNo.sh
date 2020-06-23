#!/bin/bash

#This script to remove version no. from artifact to be deplyed by ansible

# Source Dir
SOURCE_DIR=/etc/ansible/deploy_service/DEV/artifacts/

cd $SOURCE_DIR

if [ -d $SOURCE_DIR ]; then
  if [ "$(ls *.war)" ]; then
    echo "Starting preparing files"
  else
    echo "The Source directory is Empty!"
    exit 1
  fi
else
   exit 1
fi

for file in $(ls *.war); do
sudo mv ${file} ${file%-*}."war"
done

clear
echo "files have been extracted and backed up, please verify the war files"
ls -ltr

