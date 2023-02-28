package com.easy.stock;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TesteCadastro {

    private final String BASE_URL = "http://localhost:8080";
    private final String CHROME_DRIVER_PATH = "/home/wesley/others/chromedriver_linux64/chromedriver";

    @Test
    public void testeCadastroCliente() {
        // Configuração do Selenium WebDriver
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
        WebDriver driver = new ChromeDriver();

        String[][] dados = new String[3][5];

        dados[0] = new String[] {"wrb123", "Wesley Ronald Gabriel", "123.456.789-00", "123 Main St", "password1"};
        dados[1] = new String[] {"abcdefghijklmnopqrstuvwxyz1234567891011121314", "is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's s",
         "987.654.321-00", "is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's s", "htfaefghijklmnopqrstuvwxyz1234567891011121314"};
        dados[2] = new String[] {"", "", "", "", ""};
        for (int i = 0; i < dados.length; i++) {
            driver.get(BASE_URL + "/redirect");

            WebElement userField = driver.findElement(By.id("user"));
            userField.sendKeys(dados[i][0]);
          
            WebElement nameField = driver.findElement(By.id("nome"));
            nameField.sendKeys(dados[i][1]);
          
            WebElement cpfField = driver.findElement(By.id("cpf"));
            cpfField.sendKeys(dados[i][2]);
          
            WebElement addressField = driver.findElement(By.id("endereco"));
            addressField.sendKeys(dados[i][3]);
          
            WebElement passwordField = driver.findElement(By.id("senha"));
            passwordField.sendKeys(dados[i][4]);
          
            WebElement submitButton = driver.findElement(By.tagName("button"));
            submitButton.click();
            
            // Verifica se o usuário foi redirecionado para a página correta após o cadastro
            String expectedUrl = BASE_URL + "/cadastrar";
            String actualUrl = driver.getCurrentUrl();
            assertEquals(expectedUrl, actualUrl);

            // Limpa os campos para a próxima iteração
            userField.clear();
            nameField.clear();
            cpfField.clear();
            addressField.clear();
            passwordField.clear();
        }
        
        // Fecha o navegador
        driver.quit();
    }
}
