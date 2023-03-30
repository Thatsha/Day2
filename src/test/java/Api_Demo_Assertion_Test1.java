import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

public class Api_Demo_Assertion_Test1 {
    private AndroidDriver driver;
    private WebDriverWait wait;

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("appium:deviceName", "AOSP on IA Emulator");
        desiredCapabilities.setCapability("appium:platformVersion", "9");
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("appium:appPackage", "io.appium.android.apis");
        desiredCapabilities.setCapability("appium:appActivity", ".ApiDemos");
        desiredCapabilities.setCapability("appium:automationName", "Appium");
        desiredCapabilities.setCapability("appium:noReset", false);
        desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
        desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
        desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
        desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);

        URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);

        wait=new WebDriverWait(driver,10);
    }

    @Test
    public void validate_Text_At_The_Text_Box() throws InterruptedException {
        SoftAssert softAssert=new SoftAssert();
        MobileElement btnText = (MobileElement) driver.findElementByAccessibilityId("Text");
        btnText.click();
        Thread.sleep(3000);

        MobileElement btnLogTextBox = (MobileElement) driver.findElementByAccessibilityId("LogTextBox");
        btnLogTextBox.click();
        Thread.sleep(3000);

        MobileElement btnAdd = (MobileElement) driver.findElementByAccessibilityId("Add");
        btnAdd.click();
        Thread.sleep(3000);

        MobileElement lbl_This_Is_A_Test = (MobileElement) driver.findElementById("io.appium.android.apis:id/text");
        lbl_This_Is_A_Test.click();
        Thread.sleep(3000);

        String text=lbl_This_Is_A_Test.getText();
        softAssert.assertEquals(text,"This is a test");
        softAssert.assertAll();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}


