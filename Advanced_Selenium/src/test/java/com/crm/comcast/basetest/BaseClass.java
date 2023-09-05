//package com.crm.comcast.basetest;
//
//import java.io.IOException;
//import java.time.Duration;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.AfterSuite;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeSuite;
//import org.testng.annotations.Parameters;
//
//import com.comcast.crm.generic.ObjectRepo.HomePage;
//import com.comcast.crm.generic.ObjectRepo.LoginPage;
//import com.comcast.crm.generic.fileutility.ExcelUtility;
//import com.comcast.crm.generic.fileutility.FileUtility;
//import com.comcast.crm.generic.webdriverutility.JavaUtility;
//import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
//
//public class BaseClass {
//
//	public FileUtility fu=new FileUtility();
//	public ExcelUtility eu=new ExcelUtility();
//	public JavaUtility ju=new JavaUtility();
//	public WebDriverUtility wu=new WebDriverUtility();
//	public WebDriver driver;
//	public LoginPage login;
//	public HomePage home;
//	
//	@BeforeSuite
//	public void beforesuite() {
//		System.out.println(" Before Suite ");
//	}
//
//		@Parameters("browser")
//		@BeforeClass
//		public void beforeclass(String bro) throws IOException {
//			System.out.println(" Before Class ");
//			if(bro.equalsIgnoreCase("Chrome")) {
//				driver=new ChromeDriver();
//			}		
//			else if (bro.equalsIgnoreCase("firefox")) {
//				driver=new FirefoxDriver();
//			}
//			driver.manage().window().maximize();
//			driver.get(fu.getPropertyData("url"));
//		}
//
////	@BeforeClass
////	public void beforeclass() throws IOException {
////		System.out.println(" Before Class ");
////		driver=new ChromeDriver();
////		driver.manage().window().maximize();
////		driver.get(fu.getPropertyData("url"));
////		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
////	}	
//
//	@BeforeMethod
//	public void beforemethod() throws IOException {
//		login=new LoginPage(driver);
//		System.out.println(" Before Method ");
////		driver.findElement(By.name("user_name")).sendKeys(fu.getPropertyData("username"));
////		driver.findElement(By.name("user_password")).sendKeys(fu.getPropertyData("password"));
////		driver.findElement(By.id("submitButton")).click();
//		login.getUsername().sendKeys(fu.getPropertyData("username"));
//		login.getPassword().sendKeys(fu.getPropertyData("password"));
//		login.getLoginbtn().click();
//	}
//
//	@AfterMethod
//	public void afterMethod() throws InterruptedException {
//		System.out.println(" After Method ");
//		Thread.sleep(1000);
//		wu.moveElement(driver,home.getAccountbtn());
//		home.getSignbtn().click();
////		wu.moveElement(driver,driver.findElement(By.xpath("(//td[@class='small'])[2]/img")));
////		driver.findElement(By.linkText("Sign Out")).click();
//	}
//
//	@AfterClass
//	public void afterclass() throws InterruptedException {
//		System.out.println(" After Class ");
//		Thread.sleep(3000);
//		driver.quit();
//	}
//
//	@AfterSuite
//	public void aftersuite() {
//		System.out.println(" After Suite ");
//	}
//
//}
