/**
 * Author:- Manjeet Kumar
 */

package com.training.fileparser;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.training.constants.ConfigConstant;
import com.training.webdriverhelper.BaseTestSetup;


public class FileSystemUtils extends BaseTestSetup{

	private static Logger logger = LoggerFactory.getLogger(FileSystemUtils.class);
	public static String currentFolderLocation;
	private static String testDataLocation;

	public static void createDir(String dirName){
		File f = new File(dirName);
		try {
			if (!f.exists()) {
				f.mkdir();
				System.out.println("Directory Created :: " +dirName);
			}
		} catch (Throwable e) {
			System.out.println("Unable to create directory  '" +dirName+"'");
		}

	}

	public String currentDirectoryPath() {
	    currentFolderLocation = String.format("%s/%s", System.getProperty("user.dir"), this.getClass().getPackage().getName().replace(".", "/"));
	    logger.info("Current directory location is \t " + currentFolderLocation);
		return currentFolderLocation;
	}

	public static String getExcelColumnData(){
		testDataLocation = currentFolderLocation + ConfigConstant.TESTDATAPATH;
		return testDataLocation;
	}
}
