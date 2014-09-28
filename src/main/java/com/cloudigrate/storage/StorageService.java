/*
 * StorageService is the main service class of this stand-alone application, that allows - 
 * 		Migration of files from:
 * 			1. AWS S3 to Google Cloud Storage
 * 			2. Google Cloud Storage to AWS S3
 */

package com.cloudigrate.storage;

import java.util.List;

import com.cloudigrate.storage.GoogleStorageFacade;

public class StorageService {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		StorageFacade storageFacade = new StorageFacade();
		
		int choice=1;
		
		System.out.println("How do you want to migrate your data?");
		System.out.println("1. Amazon to Google");
		System.out.println("2. Google to Amazon");
		System.out.println("Please enter appropriate choice -");
		
		if(choice == 1)
		{
			// AMAZON S3 TO GOOGLE CLOUD STORAGE
			System.out.println("You selected --> Amazon to Google");
			storageFacade.awsToGoogle();
			
		}
		
		else if(choice == 2)
		{
			// GOOGLE CLOUD STORAGE TO AMAZON S3
			System.out.println("You selected --> Google to Amazon");
			
		}
		
	}

}
