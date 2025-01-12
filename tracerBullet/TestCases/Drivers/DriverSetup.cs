using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;

namespace LoginTest.Drivers
{
    public static class DriverSetup
    {
        public static IWebDriver GetDriver()
        {
            var options = new ChromeOptions();
            options.AddArgument("--start-maximized");
            options.AddArgument("--disable-notifications");  // Disable browser-level notifications
            options.AddArgument("--disable-popup-blocking");  // Disable popup blocking
            return new ChromeDriver(options);
        }
    }
}