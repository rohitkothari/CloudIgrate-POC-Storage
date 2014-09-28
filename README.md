CloudIgrate-POC-Storage
=======================

A proof-of-concept to demonstrate the integration of storage services of various cloud vendors.

It is a stand-alone console application.

Following features are currently present in this POC -
  Migration of files from:
    1. AWS S3 to Google Cloud Storage
    2. Google Cloud Storage to AWS S3
    
Note:
  - Make sure you have your Google cloud project credentials filled up in /src/main/resources/cloudstorage
  - Make sure your AWS creds file is present at the default location
  - You have set the local path of sample file to be migrated
