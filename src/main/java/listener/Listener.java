package listener;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class Listener implements ITestListener
{
	@Override
	public void onTestFailure(ITestResult result)
	{
		Reporter.log("This test " + result.getName() + "failed, pl try again", true);
	}
	@Override
	public void onTestSkipped(ITestResult result) 
	{
		Reporter.log("This TC" + result.getName() +"plz check dependend method", true);
	}
	@Override
	public void onTestSuccess(ITestResult result)
	{
		Reporter.log("This" + result.getName() +" excecution started", true);
	}
    @Override
    public void onTestStart(ITestResult result) 
    {
    	Reporter.log("This" + result.getName() +" method completed sucessfully", true);
    }
}
