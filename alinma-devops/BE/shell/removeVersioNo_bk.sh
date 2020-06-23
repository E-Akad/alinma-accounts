#!/bin/bash

# Source Dir
SOURCE_DIR=.m2/repository/com/alinma/rib/${uservice}/${ARTIFACT_VERSION}/

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
mv ${file} ${file%%_*}."war"
done

clear
echo "files have been extracted and backed up, please verify the war files"
ls -ltr

exit 0