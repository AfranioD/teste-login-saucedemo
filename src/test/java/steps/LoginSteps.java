package steps;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginSteps {
    private WebDriver driver;

        @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Dado("que estou na página de login")
    public void abrirPaginaLogin() {
        driver.get("https://www.saucedemo.com/");
    }

    @Quando("eu preencho o campo de usuário com {string}")
    public void preencherUsuario(String usuario) {
        driver.findElement(By.id("user-name")).sendKeys(usuario);
    }

    @Quando("eu preencho o campo de senha com {string}")
    public void preencherSenha(String senha) {
        driver.findElement(By.id("password")).sendKeys(senha);
    }

    @Quando("eu clico no botão de login")
    public void clicarBotaoLogin() {
        driver.findElement(By.id("login-button")).click();
    }

    @Então("eu sou redirecionado para a página de produtos")
    public void verificarPaginaProdutos() {
        String tituloEsperado = "Swag Labs";
        String tituloAtual = driver.getTitle();
        Assert.assertEquals(tituloEsperado, tituloAtual);
    }

    @Então("uma mensagem de erro é exibida")
    public void verificarMensagemErro() {
        String mensagemEsperada = "Epic sadface: Username and password do not match any user in this service";
        String mensagemAtual = driver.findElement(By.cssSelector("[data-test='error']")).getText();
        Assert.assertEquals(mensagemEsperada, mensagemAtual);
    }

    @Então("eu permaneço na página de login")
    public void verificarPaginaLogin() {
        String tituloEsperado = "Swag Labs";
        String tituloAtual = driver.getTitle();
        Assert.assertNotEquals(tituloEsperado, tituloAtual);
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000); // Espera 5 segundos antes de fechar o navegador
        driver.quit();
    }
}
