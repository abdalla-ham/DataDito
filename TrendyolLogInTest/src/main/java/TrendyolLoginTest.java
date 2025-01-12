package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class TrendyolLoginTest {
    public static void main(String[] args) {
        WebDriver driver = new SafariDriver();

        try {
            // Step 1: Navigate to Trendyol
            driver.get("https://www.trendyol.com/giris?cb=%2F");
            driver.manage().window().maximize();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

            // Step 2: Locate login fields and button
            WebElement emailField = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login-email")));
            WebElement passwordField = driver.findElement(By.id("login-password-input"));
            WebElement submitButton = driver.findElement(By.cssSelector("button.q-primary.q-fluid.q-button-medium.q-button.submit"));

            // Debug visibility and interactability
            System.out.println("Email Field Visible: " + emailField.isDisplayed());
            System.out.println("Password Field Visible: " + passwordField.isDisplayed());
            System.out.println("Login Button Visible: " + submitButton.isDisplayed());
            System.out.println("Login Button Enabled: " + submitButton.isEnabled());

            // Step 3: Enter credentials and submit
            emailField.sendKeys("malekshark16@gmail.com"); // Replace with valid email
            passwordField.sendKeys("malek340"); // Replace with valid password
            submitButton.click();

            // Step 4: Validate successful login by checking the "browsing-gw-homepage" element
            try {
                WebElement homepageElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("browsing-gw-homepage")));
                System.out.println("Login Test Passed! 'browsing-gw-homepage' element is present.");
            } catch (Exception e) {
                System.out.println("Login Test Failed! 'browsing-gw-homepage' element not found.");
                throw e;
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Login Test Failed!");
        } finally {
            driver.quit();
        }
    }
}
