import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

public class LoginTest5_Instigo {
    private AndroidDriver driver;
    private WebDriverWait wait;

    @Before
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
    public void validate_user_can_successfully_create_a_complaint() throws InterruptedException {
        SoftAssert softAssert=new SoftAssert();

        By btnSkip= By.id("com.iitdh.sonusourav.instigo:id/btn_skip");
        wait.until(ExpectedConditions.visibilityOfElementLocated(btnSkip));
        driver.findElement(btnSkip).click();

        //MobileElement btnSkip = (MobileElement) driver.findElementById("com.iitdh.sonusourav.instigo:id/btn_skip");
        //btnSkip.click();

        MobileElement textEmail = (MobileElement) driver.findElementById("com.iitdh.sonusourav.instigo:id/ed_user_name");
        textEmail.sendKeys("pthatsha@gmail.com");
        Thread.sleep(3000);

        MobileElement textPassword = (MobileElement) driver.findElementById("com.iitdh.sonusourav.instigo:id/ed_password");
        textPassword.sendKeys("Abcdef68");
        Thread.sleep(3000);

        MobileElement chkRememberMe = (MobileElement) driver.findElementById("com.iitdh.sonusourav.instigo:id/remember_me_chk_box");
        chkRememberMe.click();
        Thread.sleep(3000);

        MobileElement btnLogin = (MobileElement) driver.findElementById("com.iitdh.sonusourav.instigo:id/button_login");
        btnLogin.click();
        Thread.sleep(3000);

        MobileElement btnHamburgerMenu = (MobileElement) driver.findElementByAccessibilityId("Drawer Open");
        btnHamburgerMenu.click();
        Thread.sleep(3000);

        MobileElement btnComplaints = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/androidx.appcompat.widget.LinearLayoutCompat[3]/android.widget.CheckedTextView");
        btnComplaints.click();
        Thread.sleep(3000);

        MobileElement btnRegisterComplaint = (MobileElement) driver.findElementById("com.iitdh.sonusourav.instigo:id/maintenance_register");
        btnRegisterComplaint.click();
        Thread.sleep(3000);

        MobileElement textName = (MobileElement) driver.findElementById("com.iitdh.sonusourav.instigo:id/complain_username");
        textName.sendKeys("Thatsha");
        Thread.sleep(3000);

        MobileElement textComplaintTitle = (MobileElement) driver.findElementById("com.iitdh.sonusourav.instigo:id/complain_title");
        textComplaintTitle.sendKeys("Maintenance");
        Thread.sleep(3000);

        MobileElement textHouseNo = (MobileElement) driver.findElementById("com.iitdh.sonusourav.instigo:id/complain_house_no");
        textHouseNo.sendKeys("9A");
        Thread.sleep(3000);

        MobileElement dropDownHostel = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.Spinner[1]/android.widget.TextView");
        dropDownHostel.click();
        Thread.sleep(3000);
        MobileElement labelHostel6 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[6]");
        labelHostel6.click();
        Thread.sleep(3000);

        MobileElement dropDown2 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[7]");
        dropDown2.click();
        Thread.sleep(3000);
        MobileElement labelHouseKeeping = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[4]");
        labelHouseKeeping.click();
        Thread.sleep(3000);

        MobileElement textComplaintDescription = (MobileElement) driver.findElementById("com.iitdh.sonusourav.instigo:id/et_complain_desc");
        textComplaintDescription.sendKeys("Maintenance Issue");
        Thread.sleep(3000);

        MobileElement chkMakeMePrivate = (MobileElement) driver.findElementById("com.iitdh.sonusourav.instigo:id/complain_is_private");
        chkMakeMePrivate.click();
        Thread.sleep(3000);

        MobileElement btnSubmit = (MobileElement) driver.findElementById("com.iitdh.sonusourav.instigo:id/complain_submit");
        btnSubmit.click();
        Thread.sleep(3000);

        MobileElement btnStatus = (MobileElement) driver.findElementById("com.iitdh.sonusourav.instigo:id/maintenance_status");
        btnStatus.click();
        Thread.sleep(3000);

        MobileElement lblMaintenance = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.view.ViewGroup/android.widget.ListView/android.widget.RelativeLayout[1]/android.widget.TextView[3]");
        lblMaintenance.click();
        Thread.sleep(3000);

        String Maintenance=lblMaintenance.getText();
        softAssert.assertEquals(Maintenance,"Maintenance");
        //actual value is available in the UI & Expected value is what I am expecting
        softAssert.assertAll();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}

