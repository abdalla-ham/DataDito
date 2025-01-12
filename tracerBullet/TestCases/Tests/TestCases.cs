using OpenQA.Selenium;
using Xunit;
using LoginTest.Drivers;
using LoginTest.Pages;
using TestAutomation.Pages;
using TestCases.Helpers;
using System.Threading;

namespace TestAutomation.Tests
{
    [TestCaseOrderer("TestCases.Helpers.PriorityOrderer", "TestCases")]
    public class TestCases : IDisposable
    {
        private IWebDriver driver;
        private LoginPage loginPage;
        private SearchPage searchPage;

        // Constructor for setting up the test
        public TestCases()
        {
            driver = DriverSetup.GetDriver();  // Use the driver setup from DriverSetup.cs
            loginPage = new LoginPage(driver);  // Initialize login page
            searchPage = new SearchPage(driver);  // Initialize search page
        }

        // --- Login Tests ---

        [Fact]
        [TestPriority(1)]
        public void TestValidLogin()
        {
            driver.Navigate().GoToUrl("https://www.trendyol.com/giris?cb=%2F");
            loginPage.EnterUsername("demotrendyol01@gmail.com");
            Thread.Sleep(2000);
            loginPage.EnterPassword("Trendyoldemo01");
            Thread.Sleep(2000);
            loginPage.ClickLoginButton();
            Thread.Sleep(2000);
            string expectedURL = "https://www.trendyol.com/";
            Xunit.Assert.True(driver.Url == expectedURL, $"The current URL '{driver.Url}' does not match the expected URL '{expectedURL}'.");
        }

        [Fact]
        [TestPriority(2)]
        public void TestInvalidUserNameLogin()
        {
            driver.Navigate().GoToUrl("https://www.trendyol.com/giris?cb=%2F");
            loginPage.EnterUsername("invalidUser");
            Thread.Sleep(2000);
            loginPage.EnterPassword("trendyoldemo01");
            Thread.Sleep(2000);
            loginPage.ClickLoginButton();
            Thread.Sleep(2000);

            Xunit.Assert.Contains("Lütfen geçerli", driver.PageSource); // Verify error message
        }

[       Fact]
        [TestPriority(3)]
        public void TestInvalidPasswordLogin()
        {
            driver.Navigate().GoToUrl("https://www.trendyol.com/giris?cb=%2F");
            loginPage.EnterUsername("demotrendyol01@gmail.com");
            Thread.Sleep(2000);
            loginPage.EnterPassword("wrongPassword");
            Thread.Sleep(2000);
            loginPage.ClickLoginButton();
            Thread.Sleep(2000);

            Xunit.Assert.Contains("şifreniz hatalı", driver.PageSource); // Verify error message
        }


        // --- Search Tests ---

        [Fact]
        [TestPriority(4)]
        public void TestSearchForItem()
        {
            driver.Navigate().GoToUrl("https://www.trendyol.com/"); 
            Thread.Sleep(3000);
            driver.FindElement(By.XPath("//*[@id='gender-popup-modal']/div/div/div[1]")).Click();
            Thread.Sleep(3000);
            string searchTerm = "Telefon";  // Sample search term
            searchPage.EnterSearchTerm(searchTerm);
            searchPage.ClickSearchButton();

            Thread.Sleep(5000);  // Simulate a wait for results to load (replace with explicit waits if needed)

            string resultText = searchPage.GetSearchResultText();  // Get search result text
            Xunit.Assert.Contains("sonuç listeleniyor", resultText, StringComparison.OrdinalIgnoreCase);
        }

        [Fact]
        [TestPriority(5)]
        public void TestSearchForNonExistentItem()
        {
            driver.Navigate().GoToUrl("https://www.trendyol.com/"); 
            Thread.Sleep(3000);
            driver.FindElement(By.XPath("//*[@id='gender-popup-modal']/div/div/div[1]")).Click();
            Thread.Sleep(3000);
            string searchTerm = "NonExistentItemXYZ";  // Example of a term that likely returns no results
            searchPage.EnterSearchTerm(searchTerm);
            searchPage.ClickSearchButton();

            Thread.Sleep(5000);

            Xunit.Assert.Contains("bulunamadı", driver.PageSource);  // Verify the "no results" message
        } 

        [Fact]
        [TestPriority(6)]
        public void TestAddToCart()
        {
            driver.Navigate().GoToUrl("https://www.trendyol.com/xiaomi/redmi-13-8-gb-ram-256-gb-siyah-cep-telefonu-xiaomi-turkiye-garantili-p-836127382?boutiqueId=61&merchantId=107024");
            Thread.Sleep(3000);
            driver.FindElement(By.Id("onetrust-reject-all-handler")).Click();
            Thread.Sleep(2000);

            IWebElement anladimButton= driver.FindElement(By.XPath("//*[@id='product-detail-app']/div/div[2]/div/div[2]/div[2]/div/div[1]/aside/div/div/div[2]/div/div[2]/div/div/button"));
            anladimButton.Click();

            Thread.Sleep(1000);

            IWebElement addToBasket = driver.FindElement(By.ClassName("add-to-basket"));
            addToBasket.Click();

            Thread.Sleep(2000);

            IWebElement cart = driver.FindElement(By.XPath("//*[@id='account-navigation-container']/div/div[2]/a/div[2]"));
            Xunit.Assert.True(cart.Displayed);
        }

        [Fact]
        [TestPriority(7)]
        public void RemoveCart()
        {
            driver.Navigate().GoToUrl("https://www.trendyol.com/xiaomi/redmi-13-8-gb-ram-256-gb-siyah-cep-telefonu-xiaomi-turkiye-garantili-p-836127382?boutiqueId=61&merchantId=107024");
            Thread.Sleep(3000);
            driver.FindElement(By.Id("onetrust-reject-all-handler")).Click();
            Thread.Sleep(2000);

            IWebElement anladimButton= driver.FindElement(By.XPath("//*[@id='product-detail-app']/div/div[2]/div/div[2]/div[2]/div/div[1]/aside/div/div/div[2]/div/div[2]/div/div/button"));
            anladimButton.Click();

            Thread.Sleep(1000);

            IWebElement addToBasket = driver.FindElement(By.ClassName("add-to-basket"));
            addToBasket.Click();
            Thread.Sleep(1000);

            IWebElement sepeteGit = driver.FindElement(By.XPath("//*[@id='account-navigation-container']/div/div[2]/a/p"));
            sepeteGit.Click();
            Thread.Sleep(3000);

            IWebElement anladimSepet = driver.FindElement(By.XPath("//*[@id='pb-container']/div/div[3]/div[3]/div/div[3]/div/div/div[3]/div/div/div/button"));
            anladimSepet.Click();

            driver.FindElement(By.ClassName("checkout-saving-remove-button")).Click();
            Thread.Sleep(2000);
            Xunit.Assert.Contains("kaldırıldı", driver.PageSource);
        }


        // Cleanup after each test
        public void Dispose()
        {
           driver.Quit();  // Close the browser after each test
        }
    }
}
