import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumWebSignupTest {
    //Import the selenium WebDriver
    private WebDriver driver;
    @BeforeTest
    public void start() throws InterruptedException {
        //Locate where the chromedriver is
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        //1. Open your chrome browser
        driver = new ChromeDriver();
        //2. Input your selenium Demo page url (https://selenium-blog.herokuapp.com)
        driver. get("https://selenium-blog.herokuapp.com");
        Thread.sleep(5000);

        //Test case 1. Verify that the Url leads to the right page
        if (driver.getCurrentUrl().contains("https://selenium-blog.herokuapp.com"))
            System.out.println("correct webpage"); // pass
        else
            System.out.println("incorrect webpage");// fail

        //3. Maximize the browser
        driver.manage().window().maximize();
        //4. Click on Sign up button to open the Signup page
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        Thread.sleep(10000);
    }
    @Test (priority = 0)
    public void positiveSignup() throws InterruptedException {
        //5. Locate the username field and input your username on the username field
        driver.findElement(By.id("user_username")).sendKeys("Bashirat51");
        //6. Locate the email field and input an email address on the email field
        driver.findElement(By.id("user_email")).sendKeys("bashirat51@mailinator.com");
        //7. Locate the password field and input your password on the password field
        driver.findElement(By.id("user_password")).sendKeys("Bashirat51");
        //8. Click on the signup button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);
    }
    @Test (priority = 1)
    public void ClickUser1Item() throws InterruptedException {
        //9. Click on the user1 item on the list page
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/ul/div/div/li[1]")).click();
        Thread.sleep(5000);
    }

    @Test (priority = 2)
    public void verifyItem() throws InterruptedException {
        //10. Search for an item (using python with selenium) and confirm if it is present
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/div[1]/a")).click();
        Thread.sleep(5000);

    //11. Click on log out
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[3]/a")).click();
    }
    @AfterTest
    public void closebrowser(){
        //Quit the browser
        driver.quit();
    }
}
