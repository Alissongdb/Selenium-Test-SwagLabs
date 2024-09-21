package modulos.login;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import paginas.LoginPage;
import paginas.ProdutoPage;

import java.time.Duration;

@DisplayName("Testes do formulário de Produtos")
public class ProdutoTest {
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

        LoginPage loginPage = new LoginPage(navegador);
        loginPage.informarUsuario("standard_user");
        loginPage.informarSenha("secret_sauce");
        loginPage.submeterFormularioDeLogin();
    }

    @Test
    @DisplayName("Adicionar produto no carrinho e finalizar venda com sucesso")
    public void testAdicionarProdutoNoCarrinho(){

        ProdutoPage produtoPage = new ProdutoPage(navegador);

        produtoPage.clicarAddToCart();
        produtoPage.clicarNoProdutoDoCarrinho();
        produtoPage.clicarEmCheckout();
        produtoPage.preencherConfirmacaoDaCompra("Alisson", "Dal Bosco", "04956");
        produtoPage.btnContinuar();
        produtoPage.btnFINISH();
        String VendaMessageSucesso = String.valueOf(produtoPage.capturarMensagemApresentadaVendaSucesso());

    }

    @AfterEach
    public void AfterEach(){
        navegador.close();
    }

}