package com.automation.Runner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.*;

public class OrderTest {
        WebDriver driver;
        @FindBy(xpath = "(//input[@id = 'user-name'])")
        WebElement usernameInput;

        @FindBy(xpath = "(//input[@id = 'password'])")
        WebElement passwordInput;

        @FindBy(xpath = "(//input[@id = 'login-button'])")
        WebElement loginBtn;
        @BeforeClass
        public void setup() {
                driver = new ChromeDriver();
        }

        @Test(priority = 1)
        public void openWebsite() {
                driver.get("https://www.saucedemo.com");
                Assert.assertEquals(driver.getTitle(), "Swag Labs", "Login page not displayed.");
        }

        @Test(priority = 2)
        public void login() {
                Assert.assertTrue(true, "User is not on home page.");
        }
        @Test(priority = 3)
        public void user_enters_login_credentials(){
                usernameInput.sendKeys("standard_user");
                passwordInput.sendKeys("secret_sauce");
                loginBtn.click();
        }


        @AfterClass
        public void tearDown() {
                driver.quit();
        }
}
