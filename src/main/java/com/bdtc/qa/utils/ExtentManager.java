package com.bdtc.qa.utils;

import java.io.File;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.bdtc.qa.base.Basepage;

public class ExtentManager extends Basepage {
	public static String path;

	public static ExtentReports getExtentReports() {

		ExtentReports reports = new ExtentReports();

		Date d = new Date();
		String filename = d.toString().replace(" ", "_").replace(":", "_");

		path = System.getProperty("user.dir") + "\\extentreports\\extents" + filename + ".html";
		File filepath = new File(System.getProperty("user.dir") + "\\extentreports\\extents" + filename + ".html");

		ExtentSparkReporter sparkreporter = new ExtentSparkReporter(filepath);

		sparkreporter.config().setTheme(Theme.DARK);
		sparkreporter.config().setReportName("BDTAutomation Report");
		sparkreporter.config().setDocumentTitle("BDT Test Automation Report");
		sparkreporter.config().setTimeStampFormat("dd/mm/yyyy hh:mm:ss");

		reports.attachReporter(sparkreporter);
		reports.setSystemInfo("Author", "Uma");
		reports.setSystemInfo("ProjectName", "BDT Cucumber Automation");
		reports.setSystemInfo("URL", "bestitcourses.com");
		reports.setSystemInfo("Operating System", System.getProperty("os.name"));

		reports.setSystemInfo("Java_Version", System.getProperty("java.version"));

		return reports;

	}

	public static String getreportpath() {
		return path;
	}


}
