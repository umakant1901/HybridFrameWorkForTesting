package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter {

	public ExtentHtmlReporter htmlreporter;
	public ExtentReports extentreport;
	public ExtentTest extenttest;
	
	@Override
	public void onStart(ITestContext testContext)
	{
		String timestamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String repName="Test-Report"+timestamp+".html";
		htmlreporter=new ExtentHtmlReporter("./Test-Reports/"+repName);
		htmlreporter.loadXMLConfig("./extent-config.xml");
		htmlreporter.config().setDocumentTitle("Regression Automation Testing Report");
		htmlreporter.config().setReportName("Regression Testing for report demo");
		htmlreporter.config().setTheme(Theme.DARK);
		
		
		extentreport=new ExtentReports();
		extentreport.attachReporter(htmlreporter);
		extentreport.setSystemInfo("Organisation", "Hybrid Frame Work");
		extentreport.setSystemInfo("Module", "Reorting demo");
		extentreport.setSystemInfo("Env", "SIT");
		extentreport.setSystemInfo("Type", "Regression");
		extentreport.setSystemInfo("Author", "Umakant");
		
		
	}
	
	@Override
	public void onTestSuccess(ITestResult tr)
	{
		extenttest=extentreport.createTest(tr.getName()); // create new entry in the report
		extenttest.log(Status.PASS,MarkupHelper.createLabel(tr.getName(),ExtentColor.GREEN));
		
				
	}
	
	@Override
	public void onTestFailure(ITestResult tr)
	{
		extenttest=extentreport.createTest(tr.getName());
		extenttest.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(),ExtentColor.RED));
		
		String screenshotpath="./ScreenShots/"+tr.getName()+".png";
		
		File ss=new File(screenshotpath);
		if(ss.exists())
		{
			try {
				extenttest.fail("Screen Shot is Showing Below : "+extenttest.addScreenCaptureFromPath(screenshotpath));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	@Override
	public void onTestSkipped(ITestResult tr)
	{
		extenttest=extentreport.createTest(tr.getName());
		extenttest.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE));
		
	}
	
	@Override
	public void onFinish(ITestContext testcontext)
	{
		extentreport.flush();
	}
	
	
	
}
