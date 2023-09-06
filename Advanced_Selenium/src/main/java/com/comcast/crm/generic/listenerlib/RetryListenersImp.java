package com.comcast.crm.generic.listenerlib;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryListenersImp implements IRetryAnalyzer{
	
	int count=0;
	int limitcount=5;
	
	public boolean retry(ITestResult result) {
		if(count<limitcount) {
			count++;
			return true;
		}
		return false;
	}
	
}
