using OpenQA.Selenium;
using OpenQA.Selenium.Support.UI;
using SeleniumExtras.WaitHelpers;

namespace TestAutomation.Pages
{
    public class SearchPage
    {
        private IWebDriver driver;

        // Locators for the search feature
        private By searchBar = By.XPath("//*[@id='sfx-discovery-search-suggestions']/div/div[1]/input");  // Locator for the search bar
        private By searchButton = By.XPath("//*[@id='sfx-discovery-search-suggestions']/div/div[1]/i");  // Locator for the search button
        private By searchResultItems = By.XPath("//*[@id='search-app']/div/div/div/div[2]/div[1]/div[1]/div/h2");  // Locator for product results

        // Constructor
        public SearchPage(IWebDriver driver)
        {
            this.driver = driver;
        }

        // Method to enter the search term in the search bar
        public void EnterSearchTerm(string searchTerm)
        {
            driver.FindElement(searchBar).Clear();  // Clear the search bar first
            driver.FindElement(searchBar).SendKeys(searchTerm);  // Enter the search term
        }

        // Method to click the search button
       public void ClickSearchButton()
{
    try
    {
        // Wait for the button to be clickable
        WebDriverWait wait = new WebDriverWait(driver, TimeSpan.FromSeconds(10));
        IWebElement searchButton = wait.Until(ExpectedConditions.ElementToBeClickable(By.CssSelector("[data-testid='search-icon']")));

        // Handle overlay if present
        try
        {
            IWebElement overlay = driver.FindElement(By.CssSelector("div.shadow"));
            if (overlay.Displayed)
            {
                ((IJavaScriptExecutor)driver).ExecuteScript("arguments[0].style.display='none';", overlay);  // Hide overlay using JavaScript
                Console.WriteLine("Overlay dismissed.");
            }
        }
        catch (NoSuchElementException)
        {
            Console.WriteLine("No overlay found.");
        }

        // Click the search button
        searchButton.Click();
    }
    catch (ElementClickInterceptedException e)
    {
        Console.WriteLine($"Element click intercepted: {e.Message}");
    }
}


        // Method to get the number of search results displayed
        public string GetSearchResultText()
        {
            var items = driver.FindElement(searchResultItems);  // Get all product cards
            return items.Text;  // Return the count of the items
        }
    }
}
