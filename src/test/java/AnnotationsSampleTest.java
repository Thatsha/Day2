import org.testng.annotations.*;

public class AnnotationsSampleTest {
    @Test
    public void annotationTest1(){
System.out.println("Thatsha1");
    }
    @Test
    public void annotationTest2(){
        System.out.println("Thatsha2");

    }
    @AfterTest
    public void annotationTest3(){
        System.out.println("Thatsha3");

    }
    @AfterMethod
    public void annotationTest4(){
        System.out.println("Thatsha4");

    }
    @BeforeTest
    public void annotationTest5(){
        System.out.println("Thatsha5");

    }
    @BeforeMethod
    public void annotationTest(){
        System.out.println("Thatsha6");

    }
}
