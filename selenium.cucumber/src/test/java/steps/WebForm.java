package steps;

import static org.junit.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WebForm {

	WebDriver driver = new ChromeDriver();

	@Given("que esteja no formualario")
	public void que_esteja_no_formualario() {
		WebDriverManager.chromedriver().setup();
		driver.get("https://www.selenium.dev/selenium/web/web-form.html");
		String title = driver.getTitle();
		assertEquals("Web form", title);
	}

	@When("enviar formualario com dados validos")
	public void enviar_formualario_com_dados_validos() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
		WebElement textBox = driver.findElement(By.name("my-text"));
		WebElement submitButton = driver.findElement(By.cssSelector("button"));
		textBox.sendKeys("Selenium");
	Thread.sleep(2000);
	submitButton.click();
	}
		
		
	

	@Then("valido mensagem de recebido")
	public void valido_mensagem_de_recebido() {
		WebElement message = driver.findElement(By.id("message"));
		String value = message.getText();
		assertEquals("Received!", value);
		driver.quit();
	}

}
