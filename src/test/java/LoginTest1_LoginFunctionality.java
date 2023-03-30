import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class LoginTest1_LoginFunctionality {
    private AndroidDriver driver;//create an object for AndroidDriver in globe level
    private WebDriverWait wait;//create an object for wait in globe level
    @BeforeSuite
    public void setUp() throws MalformedURLException {
        //All the desired capabilities are automatically generated from session information from Appium Inspector
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("deviceName", "AOSP on IA Emulator");
        desiredCapabilities.setCapability("platformVersion", "9");
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("appPackage", "com.iitdh.sonusourav.instigo");
        desiredCapabilities.setCapability("appActivity", ".Account.SplashActivity");
        desiredCapabilities.setCapability("automationName", "Appium");//ULAutomator2
        desiredCapabilities.setCapability("noReset", false);
        desiredCapabilities.setCapability("ensureWebviewsHavePages", true);
        desiredCapabilities.setCapability("nativeWebScreenshot", true);
        desiredCapabilities.setCapability("newCommandTimeout", 3600);
        desiredCapabilities.setCapability("connectHardwareKeyboard", true);

        URL remoteUrl = new URL("http://localhost:4723/wd/hub");//automatically generated from session information

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);

        //Implicit Wait
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //It will wait for 20 Seconds until login page next element is available.
        // If it's available less than 20 seconds then it will automatically stop waiting and then will go to the next step.
        // But it will affect all the elements.

        wait=new WebDriverWait(driver,10);
        //we are requesting the driver to wait alleast 10 millisecond before doing any activities.
    }
    @Test
    public void validate_User_Can_LogIn_To_The_System_Successfully()  {//Best Practice is to have industrial standard naming conversion
        //Best approach would be what we are going to do (validation or verification).
        // We are going to validate the Username. And follow the steps as below:

        SoftAssert softAssert=new SoftAssert();// create an object for Soft Assertion in @Test Method level
        //We can use Soft Assertion if we have multiple assertions inside the test method.

        //Explicit Wait
        By btnSkip= By.id("com.iitdh.sonusourav.instigo:id/btn_skip");
        wait.until(ExpectedConditions.visibilityOfElementLocated(btnSkip));
        driver.findElement(btnSkip).click();

        //MobileElement btnSkip = (MobileElement) driver.findElementById("com.iitdh.sonusourav.instigo:id/btn_skip");
        //btnSkip.click();

        MobileElement txtEmail = (MobileElement) driver.findElementById("com.iitdh.sonusourav.instigo:id/ed_user_name");
        txtEmail.sendKeys("pthatsha@gmail.com");

        MobileElement txtPassword = (MobileElement) driver.findElementById("com.iitdh.sonusourav.instigo:id/ed_password");
        txtPassword.sendKeys("Abcdef68");

        MobileElement chkRememberMe = (MobileElement) driver.findElementById("com.iitdh.sonusourav.instigo:id/remember_me_chk_box");
        chkRememberMe.click();

        MobileElement btnLogin = (MobileElement) driver.findElementById("com.iitdh.sonusourav.instigo:id/button_login");
        btnLogin.click();

        MobileElement btnHamburgerMenu = (MobileElement) driver.findElementByAccessibilityId("Drawer Open");
        btnHamburgerMenu.click();

        MobileElement lblUserName = (MobileElement) driver.findElementById("com.iitdh.sonusourav.instigo:id/nav_header_username");
        lblUserName.click();

        //get the userName
        String userName=lblUserName.getText();
        softAssert.assertEquals(userName,"Thatsha Preman");
        //actual value is available in the UI & Expected value is what I am expecting
        softAssert.assertAll();
    }
    @AfterTest
    public void tearDown() {
        driver.quit();
    }}
