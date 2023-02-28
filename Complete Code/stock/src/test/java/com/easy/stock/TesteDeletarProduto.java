package com.easy.stock;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TesteDeletarProduto {    
    
    @Test
    public void testeEditarProduto() {

        System.setProperty("webdriver.chrome.driver", "/home/wesley/others/chromedriver_linux64/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("http://localhost:8080/vendedor/gerenciar");
        // Encontrando o botão que abre o modal
        WebElement botao = driver.findElement(By.cssSelector("a[href='#deleteEmployeeModal6']"));

        // Clicando no botão
        botao.click();

        try {
            // Aguardando 3 segundos
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("A thread foi interrompida enquanto estava em estado de espera");
        }

        // Localizar o elemento form que contém o botão "Deletar"
        WebElement form = driver.findElement(By.cssSelector("form[action*='/api/deletar-produto/']"));

        WebElement deletar = form.findElement(By.id("deletar-botao"));
        deletar.click();

    }
}