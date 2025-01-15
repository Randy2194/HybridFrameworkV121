package utilities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.BaseClass;

public class ExtentReportManager implements ITestListener {
	ExtentSparkReporter stackReport;
	ExtentReports reports;
	ExtentTest exTest;
	public Properties pro;
	public void onStart(ITestContext context) {
		
		pro=new Properties();
		FileReader input;
		try {
			input = new FileReader("D:\\Automation_Workspace\\HybridFrameworkV121\\src\\test\\resources\\config.properties");
			pro.load(input);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmm");
        String formattedTimestamp = now.format(formatter);
	
		  stackReport=new ExtentSparkReporter(System.getProperty("user.dir")+"\\reports\\TestReport_"+formattedTimestamp+".html");
		  stackReport.config().setDocumentTitle("Automation Report");
		  stackReport.config().setReportName("Functional Testing");
		  stackReport.config().setTheme(Theme.DARK);
		 
		  reports=new ExtentReports();
		  reports.attachReporter(stackReport);
		  reports.setSystemInfo("Computer name", pro.getProperty("computerName"));
		  reports.setSystemInfo("Environment", pro.getProperty("env"));
		  reports.setSystemInfo("Application",pro.getProperty("application"));
		  reports.setSystemInfo("Developer", pro.getProperty("developer"));
		  reports.setSystemInfo("UserName", System.getProperty("user.name"));
		  String br=context.getCurrentXmlTest().getParameter("browser");
		  reports.setSystemInfo("Browser", br);
		  String os=context.getCurrentXmlTest().getParameter("os");
		  reports.setSystemInfo("Operating System", os);
		  List<String> groups=context.getCurrentXmlTest().getIncludedGroups();
		  if(!groups.isEmpty()) {
			  reports.setSystemInfo("Groups", groups.toString());
		  }
		
		   System.out.println("Test execution is started"); //Only once it will execute throughout the execution
		  }
		public void onTestStart(ITestResult result) {
		   System.out.println("Test is started"); //It will execute on before every test
		  }
		public void onTestSuccess(ITestResult result) {
			exTest=reports.createTest(result.getTestClass().getName());
			exTest.assignCategory(result.getMethod().getGroups());
			exTest.log(Status.PASS,result.getName()+" got executed successfully");
			 System.out.println("Test is Passed"); //It will execute once test is passed
			  }
		public void onTestFailure(ITestResult result) {
			exTest=reports.createTest(result.getTestClass().getName());
			exTest.assignCategory(result.getMethod().getGroups());
			exTest.log(Status.FAIL,result.getName()+" got failed");
			exTest.log(Status.INFO, result.getThrowable().getMessage());
			  System.out.println("Test is Failed"); //It will execute once test is Failed 
			  try {
				  String path=new BaseClass().takeScreenshot("Test");
				  exTest.addScreenCaptureFromPath(path);
			  }
			  catch(Exception e) {
				  System.out.println(e);
				  System.out.println("Take Screenshot failed");
			  }
			  
			  }
		public void onTestSkipped(ITestResult result) {
			exTest=reports.createTest(result.getTestClass().getName());
			exTest.assignCategory(result.getMethod().getGroups());
			exTest.log(Status.SKIP,result.getName()+" test is Skipped");
			exTest.log(Status.INFO, result.getThrowable().getMessage());
			 System.out.println("Test is Skipped"); //It will execute once test is Skipped
			  }
		
		public void onFinish(ITestContext context) {
			reports.flush();
			 System.out.println("Test execution is completed"); //Only once it will execute after all the test execution
			  }

}
