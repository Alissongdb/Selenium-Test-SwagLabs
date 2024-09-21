package modulos.login;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import paginas.LoginPage;

import java.time.Duration;

@DisplayName("Testes do formulário de Login")
public class LoginTest {
    private WebDriver navegador;

    @BeforeEach
    public void beforeEach(){

        //Abrir o navegador
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers Selenium\\chromedriver.exe");
        this.navegador = new ChromeDriver();

        // Maximizar a tela
        this.navegador.manage().window().maximize();

        // Definir tempo de espera padrao de 5s
        this.navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //Navegar para a pagina da Saucedemo
        this.navegador.get("https://www.saucedemo.com/v1/index.html");

    }

    @Test
    @DisplayName("Realizar login com sucesso página")
    public void testLoginSucesso(){

        LoginPage loginPage = new LoginPage(navegador);

        loginPage.informarUsuario("standard_user");
        loginPage.informarSenha("secret_sauce");
        loginPage.submeterFormularioDeLogin();

    }

    @Test
    @DisplayName("Login com falha")
    public void testLoginFalha(){

        LoginPage loginPage = new LoginPage(navegador);

        loginPage.informarUsuario("standard_userr");
        loginPage.informarSenha("secret_saucee");
        loginPage.submeterFormularioDeLogin();
        String errorMessage = loginPage.capturarMensagemApresentadaFalhaLogin();
        Assertions.assertEquals("Epic sadface: Username and password do not match any user in this service", errorMessage);
    }

    @AfterEach
    public void AfterEach(){
        navegador.close();
    }
}