

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumWebSignupTest {
    //import selenium WebDriver
    private WebDriver driver;

    @BeforeTest
    public void start() throws InterruptedException {
        //locate where chromedriver is
        System.setProperty("web-driver.chrome.driver", "resources/chromedriver.exe");
        //1.Open your chrome browser
        driver = new ChromeDriver();
        //2. Input your selenium Demo Page URL (https://selenium-blog.herokuapp.com)
        driver.get("https://selenium-blog.herokuapp.com");
        //Test 1. verify that user input the right URL on the right webpage
        if (driver.getCurrentUrl().contains("https://selenium-blog.herokuapp.com"))
            //Pass
            System.out.println("correct webpage");
        else
            //fail
            System.out.println("wrong webpage");

        Thread.sleep(5000);
        //3.Maximize the browser
        driver.manage().window().maximize();
        //4. Click on the signup button to open the signup page
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        Thread.sleep(5000);
    }
    @Test (priority = 0)
    public void positiveSignup() throws InterruptedException {
        // Test 7.verify that user can successfully signup when valid details are inputted
        //5. Input username on the username field
        driver.findElement(By.id("user_username")).sendKeys("Bashirat44");
        //6. Input email address on email field
        driver.findElement(By.id("user_email")).sendKeys("Bashirat44@mailinator.com");
        //7. Locate the password field and input your password on the password field
        driver.findElement(By.id("user_password")).sendKeys("Bashirat44");
        //8. Click on the signup button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);
    }

    @Test (priority = 1)
    public void clickuser1item() throws InterruptedException {
        //9. Click on the username item on the list page
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/ul/div/div/li[1]")).click();
        //Test 2. verify that when user clicks on the signup button,the user is directed to the signup page
        String expectedUrl = "https://selenium-blog.herokuapp.com/signup";
        String actualUrl =driver.getCurrentUrl();
        if(actualUrl.contains("expectedUrl"))
            //Pass
            System.out.println("correct webpage");
        else
            //fail
            System.out.println("wrong webpage");
        Thread.sleep(5000);
    }

    @Test (priority = 2)
    public void verifyItem() throws InterruptedException {
        //10. Search for an item (Using python with selenium) and confirm it is present
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/div[1]/a")).click();
        //Test 9. verify that the item searched for on the User1 page is present
        String expectedPageUrl = "/users/1";
        String actualPageUrl = driver.getCurrentUrl();
        if(actualPageUrl.contains(expectedPageUrl))
            //Pass
            System.out.println("correct User1page");
        else
            //fail
            System.out.println("wrong User1page");
        Thread.sleep(5000);
    }

    @Test (priority = 3)
    public void verifyItem2 () throws InterruptedException {
        //11. Search for an item in (using python with selenium ) and confirm it is present
        driver.findElement (By.xpath("/html/body/div[2]/div[2]/div/div/div[1]/a")).click();
        //Test 8. verify that meaghan is present
        String expectedPageUrl = "https://selenium-blog.herokuapp.com/users/1";
        String actualPageUrl = driver.getCurrentUrl();
        if (actualPageUrl.contains(expectedPageUrl))
            //Pass
            System.out.println("correct user 1678412985 ");
        else
            //fail
            System.out.println("wrong user 1678412985");
        Thread.sleep(5000);
    }



    @Test(priority = 4)
    public void logoutsucessfully() {
        //11. Click on log out
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[3]/a")).click();
        //Test 10.verify that when the user log out he/she is directed back to the home page
        String expectedTitle = "Alphablog";
        String actualTitle = driver.getTitle();
        if(expectedTitle.contains(actualTitle))
            //Pass
            System.out.println("correct user1 page");
        else
            //fail
            System.out.println("wrong user1page");

    }
    @Test (priority = 6)
    public void testWrongemail() throws InterruptedException {
        //Click on the signup button to open the signup page
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[2]/a")).click();
        Thread.sleep(5000);
        //5. Input username on the username field
        driver.findElement(By.id("user_username")).sendKeys("Bashirat44");
        //6. Input email address on email field
        //Test 4. verify that user cannot sign in with invalid email address
        driver.findElement(By.id("user_email")).sendKeys("Bashirat44@mailinator");
        //7. Locate the password field and input your password on the password field
        driver.findElement(By.id("user_password")).sendKeys("Bashirat44");
        //8. Click on the signup button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);
    }

    @Test (priority = 7)
    public void testincompletepassword () throws InterruptedException {
        //Click on the signup button to open the signup page
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[2]/a")).click();
        Thread.sleep(5000);
        //5. Input username on the username field
        driver.findElement(By.id("user_username")).sendKeys("Bashirat44");
        //6. Input email address on email field
        driver.findElement(By.id("user_email")).sendKeys("Bashirat44@mailinator.com");
        //7. Locate the password field and input your password on the password field
        // Test 5. verify that user cannot sign in with password less than 8 characters
        driver.findElement(By.id("user_password")).sendKeys("B44");
        //8. Click on the signup button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);
    }
    @Test (priority = 8)
    public void blankemailaddressfield () throws InterruptedException {
        //Click on the signup button to open the signup page
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[2]/a")).click();
        Thread.sleep(5000);
        //5. Input username on the username field
        driver.findElement(By.id("user_username")).sendKeys("Bashirat44");
        //6. Input email address on email field
        driver.findElement(By.id("user_email")).sendKeys();
        //7. Locate the password field and input your password on the password field
        // Test 6. verify that user cannot sign in with blank email address field
        driver.findElement(By.id("user_password")).sendKeys("Bashirat44");
        //8. Click on the signup button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);
    }
    @Test (priority = 9)
    public void blankpasswordfield () throws InterruptedException {
        //Click on the signup button to open the signup page
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[2]/a")).click();
        Thread.sleep(5000);
        //5. Input username on the username field
        driver.findElement(By.id("user_username")).sendKeys("Bashirat44");
        //6. Input email address on email field
        driver.findElement(By.id("user_email")).sendKeys("Bashirat44@mailinator.com");
        //7. Locate the password field and input your password on the password field
        // Test 3. verify that user cannot sign in with a blank password field
        driver.findElement(By.id("user_password")).sendKeys();
        //8. Click on the signup button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);
    }
    @AfterTest
    public void closeBrowser() {
        //12. Quit your browser
        driver.quit();

    }



}
