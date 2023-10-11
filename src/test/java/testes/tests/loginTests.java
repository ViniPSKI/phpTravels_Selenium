package testes.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import testes.pages.loginPage;

import static org.junit.Assert.*;

public class loginTests {

    private WebDriver driver;
    private loginPage login;

    @Before
    public void inicia(){
        System.setProperty("webdriver.chrome.driver", "/home/vinicius/Downloads/chromedriver-linux64/chromedriver");
        this.driver = new ChromeDriver();
        this.login = new loginPage(driver);
    }

    @After
    public void finaliza(){
        driver.close();
    }

    @Test
    public void adicionaUsuarioSemResultado(){

        login.acessaSite();
        login.cadastra("Joao","Souza", "Joao LTDA","joao@email.com");
        login.aceitaAlerta();

    }

    @Test
    public void adicionaUsuarioComResultado(){

        login.acessaSite();
        login.calculaResultado();
        login.cadastra("Vera","Macedo","Macedo SA","macedo@email.com");
        assertTrue(driver.getPageSource().contains("Thank you!"));

    }

}
