package com.purplle;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public  class Retryanalayzer implements IRetryAnalyzer{

	int i=1, j=2;
	private boolean flase;
	@Override
	public boolean retry(ITestResult result) {
		if(i<2) {
			i++;
		return true ;
	}
	   return flase;

    }  
  } 
