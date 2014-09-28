/*
 * StorageFacade is the actual integration class which combines low level functionalities
 * of AWSS3Facade and GoogleStorageFacade to design migration functionalities.
 * Following are the functionalities provided by this class:
 * 			1. AWS S3 to Google Cloud Storage file migration
 * 
 * Following functionality is pending in this class:
 * 			1. Google Cloud Storage to AWS S3 
 * 				- Pending due to non-completion of "Uploading to AWS" function in AWS S3 POC
 */

package com.cloudigrate.storage;

import java.io.IOException;

public class StorageFacade {
	
	/*
	 * This function migrates files from AWS S3 to Google Cloud Storage ensuring the following things:
	 * 			1. Same bucket name across AWS and Google Cloud
	 * 			2. Same file name across AWS and Google Cloud
	 */
	public void awsToGoogle() throws Exception {
		AWSS3Facade awsS3Facade = new AWSS3Facade();
		GoogleStorageFacade googleStoragefacade = new GoogleStorageFacade();
		
		String bucketName = "testcirk";
		String filePath = "C:/Users/rkothari/Downloads/S3DownloadTrial/useful-links.txt";
		
		// Fetching files from AWS S3
		awsS3Facade.authenticateAWS();
		awsS3Facade.createAWSBucket();
		awsS3Facade.downloadFromAWS();
		
		// Uploading files to Google Cloud Storage
		GoogleStorageFacade.createBucket(bucketName);
		googleStoragefacade.uploadFile(bucketName, filePath);
		
	}
}
