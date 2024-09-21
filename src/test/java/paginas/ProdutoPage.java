package paginas;

import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProdutoPage {

    private WebDriver navegador;

    public ProdutoPage(WebDriver navegador) {
        this.navegador = navegador;
    }

    public ProdutoPage clicarAddToCart(){
        navegador.findElement(By.cssSelector("button[class=\"btn_primary btn_inventory\"]")).click();

        return new ProdutoPage(navegador);
    }

    public ProdutoPage clicarNoProdutoDoCarrinho() {
        navegador.findElement(By.id("shopping_cart_container")).click();

        return new ProdutoPage(navegador);
    }

    public ProdutoPage clicarEmCheckout() {
        navegador.findElement(By.cssSelector("a[class=\"btn_action checkout_button\"]")).click();

        return new ProdutoPage(navegador);
    }

    public ProdutoPage preencherConfirmacaoDaCompra(String name, String lastName, String zipCode) {
        navegador.findElement(By.id("first-name")).sendKeys(name);
        navegador.findElement(By.id("last-name")).sendKeys(lastName);
        navegador.findElement(By.id("postal-code")).sendKeys(zipCode);

        return this;

    }

    public ProdutoPage btnContinuar(){
        navegador. findElement(By.cssSelector("input[class=\"btn_primary cart_button\"]")).click();

        return new ProdutoPage(navegador);

    }

    public  ProdutoPage btnFINISH(){
        navegador.findElement(By.linkText("FINISH")).click();

        return new ProdutoPage(navegador);
    }

    public String capturarMensagemApresentadaVendaSucesso(){
        WebElement mensagemDeVendaConcluida = navegador.findElement(By.cssSelector("h2[class=\"complete-header\"]"));
        String VendaMessageSucesso = mensagemDeVendaConcluida.getText();

        return VendaMessageSucesso;
    }

}
