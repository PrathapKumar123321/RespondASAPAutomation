import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class RespondASAP {
        public static WebDriver webDriver;
        public static Properties properties;
        public void init(){
            try {
                System.setProperty("webdriver.chrome.driver","D:\\\\Jar Files\\\\Selenium Jars\\\\chromedriver.exe");
                webDriver = new ChromeDriver();
                webDriver.manage().window().maximize();
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    public void homePage(){
        webDriver.get("http://35.179.12.155:3000/webconsole/");
    }
    public void propertiesFile(){
        try {
            properties = new Properties();
            /*Thread curentThread = Thread.currentThread();
            ClassLoader contextClassLoader = curentThread.getContextClassLoader();*/
            InputStream inputStream = RespondASAP.class.getResourceAsStream("/Resources.properties");
            if(inputStream!=null) {
                properties.load(inputStream);
            }
            else {
                System.out.println("file Not Found Exception");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loginAdministrtor() throws InterruptedException {

            //properties.load(RespondAutomation.class.getClassLoader().getResourceAsStream("Resources.properties"));
            webDriver.findElement(By.xpath("/html/body/app-root/div/app-home/app-pre-login/app-login/div/div/form/div[2]/input[1]")).sendKeys(properties.getProperty("user_name"));
            Thread.sleep(2000);
            webDriver.findElement(By.xpath("/html/body/app-root/div/app-home/app-pre-login/app-login/div/div/form/div[2]/input[2]")).sendKeys(properties.getProperty("password"));
            Thread.sleep(2000);
            webDriver.findElement(By.xpath("/html/body/app-root/div/app-home/app-pre-login/app-login/div/div/form/div[2]/button")).click();

    }
    public void createAdmin() throws InterruptedException {
        webDriver.findElement(By.xpath("/html/body/app-root/div/app-home/app-post-login/div/div[1]/a[3]")).click();
        Thread.sleep(2000);
        webDriver.findElement(By.xpath("//*[@id=\"first_name\"]")).sendKeys(properties.getProperty("a_first_name"));
        Thread.sleep(2000);
        webDriver.findElement(By.xpath("//*[@id=\"last_name\"]")).sendKeys(properties.getProperty("a_surname"));
        Thread.sleep(2000);
        webDriver.findElement(By.xpath("//*[@id=\"email_address\"]")).sendKeys(properties.getProperty("a_email-id"));
        Thread.sleep(10000);
        /*webDriver.findElement(By.xpath("/html/body/app-root/div/app-home/app-post-login/div/div[2]/app-create-admin/form/div[5]/select")).click();
        Thread.sleep(2000);
        WebElement mySelectElement = webDriver.findElement(By.xpath("/html/body/app-root/div/app-home/app-post-login/div/div[2]/app-create-admin/form/div[5]/select"));*/
        Select dropDown = new Select(webDriver.findElement(By.xpath("/html/body/app-root/div/app-home/app-post-login/div/div[2]/app-create-admin/form/div[4]/select")));
        dropDown.selectByVisibleText("India");
        Thread.sleep(2000);
        webDriver.findElement(By.xpath("//*[@id=\"mobile_number\"]")).sendKeys(properties.getProperty("a_mobile_number"));
        Thread.sleep(2000);
        webDriver.findElement(By.xpath("//*[@id=\"password_text\"]")).sendKeys(properties.getProperty("a_password"));
        Thread.sleep(2000);
        webDriver.findElement(By.xpath("//*[@id=\"password_text2\"]")).sendKeys(properties.getProperty("a_confirm_password"));
        Thread.sleep(5000);
        webDriver.findElement(By.className("button")).click();
        Thread.sleep(5000);
        webDriver.findElement(By.xpath("/html/body/div/div/div[3]/button[1]")).click();
    }
    public void viewAdmin(){
        //webDriver.findElement(By.xpath("/html/body/app-root/div/app-home/app-post-login/div/div[1]/a[5]")).click();
        System.out.println(properties.getProperty("name"));
    }
    public void createUser() throws InterruptedException {
        webDriver.findElement(By.xpath("/html/body/app-root/div/app-home/app-post-login/div/div[1]/a[4]")).click();
        Thread.sleep(5000);
        webDriver.findElement(By.xpath("//*[@id=\"first_name\"]")).sendKeys(properties.getProperty("u_first_name"));
        Thread.sleep(2000);
        webDriver.findElement(By.xpath("//*[@id=\"last_name\"]")).sendKeys(properties.getProperty("u_surname"));
        Thread.sleep(5000);
        Select dropDown = new Select(webDriver.findElement(By.xpath("//*[@id=\"country\"]")));
        dropDown.selectByVisibleText(" India ");
        Thread.sleep(3000);
        webDriver.findElement(By.xpath("//*[@id=\"mobile_number\"]")).sendKeys(properties.getProperty("u_mobile_number"));
        Thread.sleep(5000);
        webDriver.findElement(By.xpath("/html/body/app-root/div/app-home/app-post-login/div/div[2]/app-create-user/form/div[6]/button")).click();
        Thread.sleep(5000);
        webDriver.findElement(By.xpath("/html/body/div/div/div[3]/button[1]")).click();
    }
    public void viewUser(){
        webDriver.findElement(By.xpath("/html/body/app-root/div/app-home/app-post-login/div/div[1]/a[6]")).click();
    }
}
