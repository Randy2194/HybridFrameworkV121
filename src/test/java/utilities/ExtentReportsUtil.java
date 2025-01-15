package utilities;

import java.awt.image.DataBuffer;
import java.text.DateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsUtil {
	public ExtentSparkReporter _spark;
	public ExtentReports _report;
	public ExtentTest _extentTest;
	
	public void addExtentReport() {
		 LocalDateTime now = LocalDateTime.now();
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmm");
		_spark.config().setReportName("");
	}

}
