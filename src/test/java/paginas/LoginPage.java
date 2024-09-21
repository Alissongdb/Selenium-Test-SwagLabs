package paginas;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver navegador;

    public LoginPage(WebDriver navegador) {
        this.navegador = navegador;
    }

    public LoginPage informarUsuario(String usuario) {

        navegador.findElement(By.id("user-name")).sendKeys(usuario);

        return this;
    }

    public LoginPage informarSenha(String senha){

        navegador.findElement(By.id("password")).sendKeys(senha);

        return this;
    }

    public LoginPage submeterFormularioDeLogin(){
        navegador.findElement(By.id("login-button")).click();

        return new LoginPage(navegador);
    }

    public String capturarMensagemApresentadaFalhaLogin() {

        WebElement mensagemDeErro = navegador.findElement(By.cssSelector("h3[data-test='error']"));
        String errorMessage = mensagemDeErro.getText();

        return errorMessage;
    }
}