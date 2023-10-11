package testes.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class essentials {

    protected WebDriver driver;

    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "/home/vinicius/Downloads/chromedriver-linux64/chromedriver");
        driver = new ChromeDriver();

        //Configurações do Driver
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

}
