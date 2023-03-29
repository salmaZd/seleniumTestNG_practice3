package myTests;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;

public class FirstTest {

	public WebDriver driver;

	@BeforeTest
	public void beforeTest() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/inventory.html");
		driver.manage().window().maximize();

		String userName = "standard_user";
		String password = "secret_sauce";

		driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys(userName);
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(password);
		driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();

	}

	@Test
	public void f() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select/option[3]")).click();

		List<WebElement> pricesList = driver.findElements(By.className("inventory_item_price"));
		List<Double> myNewList = new ArrayList<Double>();

		for (int i = 0; i < pricesList.size(); i++) {

//			System.out.println(pricesList.get(i).getText());

			String price = pricesList.get(i).getText();
			price.trim();

			String mPrice = price.replace("$", " ");
			
			
//			System.out.println("+++++++++++++++++++++BEFORE+++++++++++++++++++++");
//			System.out.println(price);
//			System.out.println("+++++++++++++++++++++AFTER+++++++++++++++++++++");
			
			
//			System.out.println(mPrice.trim());
			double val = Double.parseDouble(mPrice.trim());
			myNewList.add(val);
//			System.out.println();
			
			
			
//			System.out.println();
//			System.out.println();
//
//			System.out.println("===============================================");
//
//			System.out.println();
//			System.out.println();

//			String[] p = price.split("$");
//			System.out.println(p);

		}
		
//		System.out.println(myNewList.size());
//		System.out.println(myNewList);
		
		for(int v = 0 ; v < myNewList.size() ; v++) {
			boolean checkProccess = myNewList.get(0) < myNewList.get(myNewList.size()-1);
			
			Assert.assertEquals(checkProccess, true);
		}

	}

}
