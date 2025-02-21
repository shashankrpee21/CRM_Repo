package generic.listenerUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryListenerImplementation implements IRetryAnalyzer {

	int count = 0;
	int limitCount = 3;

	@Override
	public boolean retry(ITestResult result) {
		if (count < limitCount) {
			count++;
			return true;
		}
		return false;
	}
}