package com.easy.stock;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TesteLogin {
    private WebDriver driver;

    @BeforeAll
    public static void setupClass() {
        System.setProperty("webdriver.chrome.driver", "/home/wesley/others/chromedriver_linux64/chromedriver");
    }

    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testLogin() {
        driver.get("http://localhost:8080");

        WebElement usuarioInput = driver.findElement(By.id("usuario"));
        usuarioInput.sendKeys("admin");

        WebElement senhaInput = driver.findElement(By.id("senha"));
        senhaInput.sendKeys("admin");

        WebElement loginButton = driver.findElement(By.tagName("button"));
        loginButton.click();

        Assertions.assertEquals("http://localhost:8080/painel-cliente", driver.getCurrentUrl());
    }
}
