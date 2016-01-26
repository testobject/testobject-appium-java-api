package org.testobject.appium.junit;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testobject.appium.common.TestObject;
import org.testobject.appium.common.TestObjectCapabilities;

import java.net.MalformedURLException;

@TestObject(testObjectApiKey = "7CDE94EFFE3E4EF4A773DB2728688C53", testObjectSuiteId = 780)
@RunWith(TestObjectAppiumSuite.class)
//@Ignore // remove @Ignore to run this test
public class CalculatorTest {

	@Rule
	public TestObjectTestResultWatcher watcher = new TestObjectTestResultWatcher();

	private AndroidDriver driver;

	@Before
	public void setup() throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability(TestObjectCapabilities.TESTOBJECT_API_KEY, watcher.getApiKey());
		capabilities.setCapability(TestObjectCapabilities.TESTOBJECT_TEST_REPORT_ID, watcher.getTestReportId());

		driver = new AndroidDriver(TestObjectCapabilities.TESTOBJECT_APPIUM_ENDPOINT, capabilities);
		watcher.setAppiumDriver(driver);

		System.out.println("Test live view: " + driver.getCapabilities().getCapability("testobject_test_live_view_url"));
		System.out.println("Test report: " + driver.getCapabilities().getCapability("testobject_test_report_url"));
	}


	@Test
	public void twoPlusTwoOperation() {

        /* Get the elements. */
		MobileElement buttonTwo = (MobileElement)(driver.findElement(By.id("net.ludeke.calculator:id/digit2")));
		MobileElement buttonPlus = (MobileElement)(driver.findElement(By.id("net.ludeke.calculator:id/plus")));
		MobileElement buttonEquals = (MobileElement)(driver.findElement(By.id("net.ludeke.calculator:id/equal")));
		MobileElement resultField = (MobileElement)(driver.findElement(By.xpath("//android.widget.EditText[1]")));

        /* Add two and two. */
		buttonTwo.click();
		buttonPlus.click();
		buttonTwo.click();
		buttonEquals.click();

        /* Check if within given time the correct result appears in the designated field. */
		(new WebDriverWait(driver, 30)).until(ExpectedConditions.textToBePresentInElement(resultField, "4"));

	}

}
