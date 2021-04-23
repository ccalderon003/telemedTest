package com.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class DashboardLoginPageTest {
    static WebDriver driver;
    static WebDriverWait wait;

    @BeforeClass
    public static void startDriver(){
        driver = new ChromeDriver();
        driver.get("https://fe-dash-api-telemedicine-test-eastus2.azurewebsites.net/");

    }

    @Test
    public void loginPageLoads(){
        wait = new WebDriverWait(driver, 10);
        wait.until(presenceOfElementLocated(
                By.cssSelector("input[type='submit']")));

        assertEquals("Sign in to your account", driver.getTitle() );
    }

    @Test
    public void userLoginDashboard(){
        WebElement passwordField;
        WebElement emailField;
        WebElement nextButton;

        wait = new WebDriverWait(driver, 10);
        wait.until(presenceOfElementLocated(By.cssSelector("input[type='submit'")));

        emailField = driver.findElement(By.cssSelector("input[type='email'"));
        nextButton = driver.findElement(By.cssSelector("input[type='submit'"));

        emailField.sendKeys("calderc1@mskcc.org");
        nextButton.click();

        wait.until(presenceOfElementLocated(By.id("submitButton")));

        assertEquals("Sign In", driver.getTitle());

    }

    @AfterClass
    public static void endClass(){
        driver.quit();
    }

}
