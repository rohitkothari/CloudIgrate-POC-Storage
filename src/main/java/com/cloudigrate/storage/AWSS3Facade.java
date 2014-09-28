/*
 * AWSS3Facade contains implementation of all the functionalities related to AWS S3.
 * It currently has the following functionalities:
 * 			1. Authenticate to AWS
 * 			2. Create an AWS S3 Bucket
 * 			3. Download a file from S3 Bucket
 * 
 * Following functionalities need to be added to this:
 * 			1. Upload a file to S3 Bucket
 */


package com.cloudigrate.storage;

import org.apache.commons.io.IOUtils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

import com.amazonaws.AmazonClientException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;

public class AWSS3Facade{

	//Global declarations
	AmazonS3 s3 = null;
	
	public void authenticateAWS(){
		AWSCredentials credentials = null;
        try {
            credentials = new ProfileCredentialsProvider("Rohit").getCredentials();
        } catch (Exception e) {
            throw new AmazonClientException(
                    "Cannot load the credentials from the credential profiles file. " +
                    "Please make sure that your credentials file is at the correct " +
                    "location (C:\\Users\\{username}\\.aws\\credentials), and is in valid format.",
                    e);
        }

        s3 = new AmazonS3Client(credentials);
        Region usWest2 = Region.getRegion(Regions.US_WEST_1);
        s3.setRegion(usWest2);
	}
	
	public void createAWSBucket(){
		String bucketName = "testcirk" + UUID.randomUUID();
       

        
        System.out.println("Creating bucket " + bucketName + "\n");
        
        /*
         * Api for creating bucket
         */
        s3.createBucket(bucketName);
	}
	
	public void downloadFromAWS() throws IOException{
		String bucketName2 = "cloudigratestorage";
        String key = "useful-links.txt";
        GetObjectRequest request = new GetObjectRequest(bucketName2,
        	    key);
        	  S3Object object = s3.getObject(request);
        	  S3ObjectInputStream objectContent = object.getObjectContent();
        	  IOUtils.copy(objectContent, new FileOutputStream("C:/Users/rkothari/Downloads/S3DownloadTrial/useful-links.txt"));

	}
}

/*
 * 	--------------PLEASE IGNORE THIS PART------------------------------
 * This was my rough work trying to make functionalities run.
 * I am keeping these here to keep track of my approach
 * -------------------------X------------------------------------------
 */
/*public static void main(String[] args) throws IOException {
		
        AWSCredentials credentials = null;
        try {
            credentials = new ProfileCredentialsProvider("Rohit").getCredentials();
        } catch (Exception e) {
            throw new AmazonClientException(
                    "Cannot load the credentials from the credential profiles file. " +
                    "Please make sure that your credentials file is at the correct " +
                    "location (C:\\Users\\{username}\\.aws\\credentials), and is in valid format.",
                    e);
        }

        AmazonS3 s3 = new AmazonS3Client(credentials);
        Region usWest2 = Region.getRegion(Regions.US_WEST_1);
        s3.setRegion(usWest2);
        String bucketName = "testcirk" + UUID.randomUUID();
       

        
        System.out.println("Creating bucket " + bucketName + "\n");
        
        
         * Api for creating bucket
         
        s3.createBucket(bucketName);
        
        
         * uploading an object
         
        
       System.out.println("Uploading a new object to S3 from a file\n");
        s3.putObject(new PutObjectRequest(bucketName, bucketName, "C:/Users/rkothari/Documents/useful-links.txt"));
        
        //Download key from S3
        String bucketName2 = "cloudigratestorage";
        String key = "useful-links.txt";
        GetObjectRequest request = new GetObjectRequest(bucketName2,
        	    key);
        	  S3Object object = s3.getObject(request);
        	  S3ObjectInputStream objectContent = object.getObjectContent();
        	  IOUtils.copy(objectContent, new FileOutputStream("C:/Users/rkothari/Downloads/S3DownloadTrial/useful-links.txt"));

        
         * Deleting the bucket
         
        
      //s3.deleteBucket(bucketName);
        
	}
}*/
