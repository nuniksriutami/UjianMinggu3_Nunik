package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) {

        String path = "/Users/macbookpro/Downloads/chromedriver-mac-x64/chromedriver";
        System.setProperty("webdriver.chrome.driver", path);
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String url = "https://www.saucedemo.com/";
        driver.get(url);
        System.out.println("Open web eCommerce");

        // login
        WebElement username = driver.findElement(By.xpath("//input[@name='user-name']"));
        username.sendKeys("standard_user");
        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("secret_sauce");
        WebElement btnLogin = driver.findElement(By.xpath("//input[@type='submit']"));
        btnLogin.click();
        Utils.delay(1); // 3 detik

        // pilih product - add to cart
        WebElement addToCartButton = driver.findElement(By.xpath("//button[contains(text(),'Add to cart')]"));
        addToCartButton.click();
        Utils.delay(1);

        // validasi, Assert login
        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);
        Utils.assertLogin(currentUrl,expectedUrl);

        // validasi assert add to cart
        String expectedTxt = "Swag Labs";
        String appLogo = driver.findElement(By.xpath("//div[@class='app_logo']")).getText();
        Utils.assertAddCart(appLogo, expectedTxt);

        Utils.delay(1);
        WebElement CartButton = driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a"));
        CartButton.click();

//        //cart
//        String expectedUrlInventory = "https://www.saucedemo.com/cart.html";
//        String currentUrlInventory = driver.getCurrentUrl();
//        System.out.println(currentUrlInventory);
//        Utils.assertAddCart(currentUrlInventory, expectedUrlInventory);


        //*[@id="shopping_cart_container"]/a

        Utils.delay(3); // 3 detik
        driver.quit();
    }
}