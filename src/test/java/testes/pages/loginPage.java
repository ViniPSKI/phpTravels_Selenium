package testes.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class loginPage {

    private WebDriver driver;

    private By firstName = By.name("first_name");
    private By lastName = By.name("last_name");
    private By businessName = By.name("business_name");
    private By email = By.name("email");

    private By numb1 = By.id("numb1");
    private By numb2 = By.id("numb2");
    private By number = By.id("number");

    private By submit = By.id("demo");

    public loginPage(WebDriver driver){
        this.driver = driver;
    }

    public void acessaSite(){
        driver.get("https://phptravels.com/demo/");

        //Configurações do Driver
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public void cadastra(String first, String last, String business, String sendEmail){

        WebElement inpFirstName = driver.findElement(firstName);
        WebElement inpLastName = driver.findElement(lastName);
        WebElement inpBusinessName = driver.findElement(businessName);
        WebElement inpEmail = driver.findElement(email);

        WebElement btSubmit = driver.findElement(submit);

        inpFirstName.sendKeys(first);
        inpLastName.sendKeys(last);
        inpBusinessName.sendKeys(business);
        inpEmail.sendKeys(sendEmail);

        btSubmit.click();

    }

    public void calculaResultado(){

        WebElement numero1 = driver.findElement(numb1);
        WebElement numero2 = driver.findElement(numb2);
        WebElement resultado = driver.findElement(number);

        int number1 = Integer.parseInt(numero1.getText());
        int number2 = Integer.parseInt(numero2.getText());

        int soma = number1 + number2;

        resultado.sendKeys(String.valueOf(soma));

    }

    public void aceitaAlerta(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        alert.accept();

    }

}
