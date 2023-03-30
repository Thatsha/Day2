import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class LoginTest2_Assertions {
    private AndroidDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("appium:deviceName", "AOSP on IA Emulator");
        desiredCapabilities.setCapability("appium:platformVersion", "9");
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("appium:appPackage", "com.iitdh.sonusourav.instigo");
        desiredCapabilities.setCapability("appium:appActivity", ".Account.SplashActivity");
        desiredCapabilities.setCapability("appium:automationName", "Appium");
        desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
        desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
        desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
        desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);

        URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        wait=new WebDriverWait(driver,10);
    }
    @Test
    public void validate_Complaint_Landing_Page_Test() {

        SoftAssert softAssert=new SoftAssert();

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

        //Assert Complaints - ID available
        MobileElement lblComplaints = (MobileElement) driver.findElementById("com.iitdh.sonusourav.instigo:id/imagebt_bp");
        lblComplaints.click();
        String complaints=lblComplaints.getText();
        softAssert.assertEquals(complaints,"Complaints");

        //Hamburger Menu
        MobileElement btnHamburgerMenu = (MobileElement) driver.findElementByAccessibilityId("Drawer Open");
        btnHamburgerMenu.click();

        //Complaint button via Hamburger Menu - XPath available
        MobileElement btnComplaints = (MobileElement) driver.findElementByXPath
                ("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget." +
                        "LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/" +
                        "androidx.recyclerview.widget.RecyclerView/androidx.appcompat.widget.LinearLayoutCompat[3]/android.widget.CheckedTextView");
        btnComplaints.click();

        //Assert - Register_Complaint
        MobileElement lblRegisterComplaint = (MobileElement) driver.findElementById("com.iitdh.sonusourav.instigo:id/maintenance_register");
        lblRegisterComplaint.click();
        String register_Complaint=lblRegisterComplaint.getText();
        softAssert.assertEquals(register_Complaint,"Register Complaint");

        //Assert - Status
        MobileElement lblStatus = (MobileElement) driver.findElementById("com.iitdh.sonusourav.instigo:id/maintenance_status");
        lblStatus.click();
        String status=lblStatus.getText();
        softAssert.assertEquals(status,"Status");

        softAssert.assertAll();
    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }}
