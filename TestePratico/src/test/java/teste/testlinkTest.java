package teste;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
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
        // Verificar se esta na pagina da testLink
        // Realizar mais alguns Assertions
        // Clicar no link para o github do testLink
    }

    @Test
    public void github(){
        //Realizar assertions para verificar se esta na pagina do github do testlink
        //realizar uma pesquisa no github
        //validar resultado
    }

    @After
    public void tearDown(){
        //fechando todas as guias abertas do navegador
        navegador.quit();
    }
}
