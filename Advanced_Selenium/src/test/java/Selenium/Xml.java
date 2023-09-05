package Selenium;

import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class Xml {
	
	@Test
	public void sampleTest(XmlTest test) {
		System.out.println(test.getParameter("url"));
	}
	
}
