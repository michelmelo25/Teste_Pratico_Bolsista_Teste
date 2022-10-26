package teste;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class testlinkTest {

    private WebDriver navegador;

    @Before
    public void setUp(){
        //informando local do webdriver
        System.setProperty("webdriver.chrome.driver","/home/michel/drivers/chromedriver");
        //setando google chrome como navegador
        navegador = new ChromeDriver();
        //definindo timeout para garantir o carregamento da pagina antes da execucao do comendo
        navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //Maximizar janela
//        navegador.manage().window().maximize();
        //navegando para a pagina
        navegador.get("https://testlink.org/");
    }

    @Test
    public void testLink(){
        // Verificar se esta na pagina da testLink div[class="header"]
        WebElement title = navegador.findElement(By.className("header"));
        // Verificando se esta na pagina do testlink
        Assert.assertEquals("TestLink",title.getText());
        // Realizar mais alguns Assertions
        // Clicar no link para o github do testLink
        navegador.findElement(By.className("col-lg-6")).findElement(By.linkText("Access Git Repository (GitHub)")).click();

        //Realizar assertions para verificar se esta na pagina do github do testlink
        //selecionando div pai do titolo do repositorio
        WebElement div = navegador.findElement(By.id("repository-container-header"));
//        findElement(By.className("d-flex flex-wrap flex-items-center wb-break-word f3 text-normal"))
        //obtendo identificacao do proprietario do repositorio
        WebElement fistTitle = div.findElement(By.linkText("TestLinkOpenSourceTRMS"));
        //obtendo nome do repositorio
        WebElement secondTitle = div.findElement(By.linkText("testlink-code"));
        //verificando se esta na pagina do github do testlink
        Assert.assertEquals("TestLinkOpenSourceTRMS",fistTitle.getText());
        Assert.assertEquals("testlink-code",secondTitle.getText());

        //Bonus
        //realizar uma pesquisa no github
        //validar resultado
    }

    @After
    public void tearDown(){
        //fechando todas as guias abertas do navegador
        navegador.quit();
    }
}
