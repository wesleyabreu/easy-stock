package com.easy.stock;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TesteEditarProduto {    
    
    @Test
    public void testeEditarProduto() {
        // Definindo o driver do Chrome
        System.setProperty("webdriver.chrome.driver", "/home/wesley/others/chromedriver_linux64/chromedriver");
        WebDriver driver = new ChromeDriver();

        // Abrindo a página
        driver.get("http://localhost:8080/vendedor/gerenciar");

        // Encontrando o botão que abre o modal
        WebElement botao = driver.findElement(By.cssSelector("a[href='#editEmployeeModal8']"));

        // Clicando no botão
        botao.click();

        try {
            // Aguardando 3 segundos
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("A thread foi interrompida enquanto estava em estado de espera");
        }

        // Preenchendo o formulário
        WebElement modalContent = driver.findElement(By.id("editEmployeeModal8"));
        WebElement nomeInput = modalContent.findElement(By.name("nome"));
        WebElement descricaoTextarea = modalContent.findElement(By.name("descricao"));
        WebElement precoInput = modalContent.findElement(By.name("preco"));
        WebElement quantidadeInput = modalContent.findElement(By.name("quantidade"));

        nomeInput.clear();
        descricaoTextarea.clear();
        precoInput.clear();
        quantidadeInput.clear();

        nomeInput.sendKeys("Produto altera teste");
        descricaoTextarea.sendKeys("Descrição do Produto de Teste");
        precoInput.sendKeys("582.00");
        quantidadeInput.sendKeys("16");

        // Submetendo o formulário
        WebElement cadastrarButton = modalContent.findElement(By.cssSelector("input[type='submit']"));
        cadastrarButton.click();

        // Aguardando 5 segundos para visualizar o resultado
        

        // Fechando o driver
        driver.quit();
    }
}