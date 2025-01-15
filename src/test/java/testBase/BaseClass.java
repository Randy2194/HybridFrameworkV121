package testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

public class BaseClass {
	public static WebDriver driver;
	public Logger logger;
	public Properties prop;
	
	@SuppressWarnings("deprecation")
	@BeforeClass(groups="sanity")
	@Parameters({"os","browser"})
	public void setup(String os,String br) throws InterruptedException {
		
		try {
			prop=new Properties();
			FileReader input=new FileReader("D:\\Automation_Workspace\\HybridFrameworkV121\\src\\test\\resources\\config.properties");
			prop.load(input);
			//This line will get the logger file
			logger=LogManager.getLogger(this.getClass());
			
			if(prop.getProperty("exe_env").equalsIgnoreCase("remote"))
			{
				DesiredCapabilities cap=new DesiredCapabilities();
				switch (os.toLowerCase()) {
				case "windows": cap.setPlatform(Platform.WIN11); break;
				case "mac"    : cap.setPlatform(Platform.MAC); break;
				case "linux"  : cap.setPlatform(Platform.LINUX); break;
				default: System.out.println("Platform not valid"); return;
				}
				switch (br.toLowerCase()) {
				case "chrome": cap.setBrowserName("chrome"); break;
				case "edge": cap.setBrowserName("MicrosoftEdge"); break;
				default:System.out.println("Invalid browser name"); return;
				}
				driver=new RemoteWebDriver(new URL(prop.getProperty("remote-url")),cap);
				
			}
			
			if(prop.getProperty("exe_env").equalsIgnoreCase("local")) {
				switch(br.toLowerCase()) {
				case "chrome": driver=new ChromeDriver(); break;
				case "edge" : driver=new EdgeDriver(); break;
				default: System.out.println("Invalid browser name"); return;}
			}
			
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get(prop.getProperty("appURL"));
			
			//driver.get("https://demo.opencart.com/en-gb?route=account/login");
			System.out.println("Application is launched successfully");
			Thread.sleep(10000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			e.printStackTrace();
			
		}
		
	}
	@AfterClass(groups="sanity")
	public void tearDown() {
		driver.quit();
	}
	public String randomString() {
		String generatedString=RandomStringUtils.randomAlphabetic(5);
		return generatedString;
		
	}
	
	public String takeScreenshot(String tname) {
		LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmm");
        String formattedTimestamp = now.format(formatter);
        
        TakesScreenshot _shot=(TakesScreenshot) driver;
        File sourcefile= _shot.getScreenshotAs(OutputType.FILE);
        
        String filepath=System.getProperty("user.dir")+"\\screenshots\\"+tname+"_"+formattedTimestamp+".png";
        File targetfile=new File(filepath);
        sourcefile.renameTo(targetfile);
        return filepath;
        
	}
	
	
 
}
