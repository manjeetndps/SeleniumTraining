package com.common.utility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class RandomNumberGeneration {
	
	
	
	public int  getRandomNuber()
	{
		  Random ran=new Random();
		  int num=ran.nextInt(9999999);
		  return num;
	}
	
	public String getToDayDate()
	{
		
		
		SimpleDateFormat formatToday = new SimpleDateFormat("MMddyy");
		String date=formatToday.format(new Date());
		System.out.println("To Day Date ::"+date);
		
		return date;
		
	}
	
	public String getDateAndTime()
	{
		SimpleDateFormat scrShot = new SimpleDateFormat("MMddyyHHmmss");
		String dateandtime = scrShot.format(new Date());
		System.out.println("Date And Time ::"+dateandtime);
		return  dateandtime;
		
	}
	
	
	public static void main(String[] args) {
		
		RandomNumberGeneration ran=new RandomNumberGeneration();
		ran.getDateAndTime();
	}

}
