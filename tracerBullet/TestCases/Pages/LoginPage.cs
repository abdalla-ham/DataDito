using OpenQA.Selenium;

namespace LoginTest.Pages
{
    public class LoginPage
    {
        private IWebDriver driver;

        // Locators
        private By usernameField = By.Id("login-email");
        private By passwordField = By.Id("login-password-input");
        private By loginButton = By.XPath("//*[@id=\"login-register\"]/div[3]/div[1]/form/button");

        // Constructor
        public LoginPage(IWebDriver driver)
        {
            this.driver = driver;
        }

        public void EnterUsername(string username)
        {
            driver.FindElement(usernameField).SendKeys(username);
        }

        public void EnterPassword(string password)
        {
            driver.FindElement(passwordField).SendKeys(password);
        }

        public void ClickLoginButton()
        {
            driver.FindElement(loginButton).Click();
        }
    }
}
