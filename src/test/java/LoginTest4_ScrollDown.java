import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
public class LoginTest4_ScrollDown {
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
    public void Scroll_Down_Test() throws InterruptedException {
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

        MobileElement lyrHome = (MobileElement) driver.findElementById("com.iitdh.sonusourav.instigo:id/include_home");
        List<MobileElement> tileList=lyrHome.findElements(By.className("android.widget.LinearLayout"));
        tileList.get(1).click();

        MobileElement btnComplaints = (MobileElement) driver.findElementById("com.iitdh.sonusourav.instigo:id/imagebt_bp");
        btnComplaints.click();

        MobileElement btnStatus = (MobileElement) driver.findElementById("com.iitdh.sonusourav.instigo:id/maintenance_status");
        btnStatus.click();

        Thread.sleep(5000); //use to load for some time & if the test get fails
        //get it from the recording box after completion of scroll down
        //below command can be used again and again to go for the bottom option in the page. (if there are so many options available)
        (new TouchAction(driver)).press(PointOption.point(547, 1914)).moveTo(PointOption.point(555, 991)).release().perform();

        }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
