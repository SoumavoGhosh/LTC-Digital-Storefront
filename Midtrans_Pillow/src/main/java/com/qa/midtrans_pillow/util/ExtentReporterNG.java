package com.qa.midtrans_pillow.util;

/*import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	static ExtentReports extent;
	
	public static ExtentReports getReportObject()
	{
		Date now=new Date();
		SimpleDateFormat dateformat=new SimpleDateFormat();
		String time=dateformat.format(now);
		System.out.println(time);
		String trimmedtime1=time.replaceAll(":", "\\\\");
		String trimmedtime2=trimmedtime1.replaceAll("\\\\", "-");
		String trimmedtime3=trimmedtime2.replaceAll(" ", "-");
		String trimmedtime4=trimmedtime3.replaceAll("/", "-");
		System.out.println(trimmedtime4);
		String path =System.getProperty("user.dir")+"\\Reports\\"+trimmedtime4+"\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Test Results");
		
		extent =new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Soumavo Ghosh");
		return extent;
		
	}
}*/