using System;
using NUnit.Framework;
using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;


namespace Selenium_PEPI
{
    class Program
    {
        const string USER = "pepi_test";
        const string PASS = "Pepi1234";
        IWebDriver driver;

        [SetUp]
        public void startBrowser()
        {
            driver = new ChromeDriver("E:/GitHubRepos/pcir2589--VSS/seleniumLab5/Selenium_PEPI");
        }

        [Test]
        public void TestLogin()
        {
            driver.Url = "https://www.demoblaze.com/";
            driver.Manage().Window.Maximize();
            driver.Manage().Timeouts().ImplicitWait = TimeSpan.FromSeconds(1);
            IWebElement loginButton = driver.FindElement(By.Id("login2"));
            loginButton.Click();
      
            IWebElement emailField = driver.FindElement(By.Id("loginusername"));
            IWebElement passField = driver.FindElement(By.Id("loginpassword"));

            emailField.SendKeys(USER);
            passField.SendKeys(PASS);

            IWebElement confirmButton = driver.FindElement(By.CssSelector("div.modal-footer:nth-child(0)"));

            confirmButton.Click();
            
            

        }

        [Test]
        public void TestLogout()
        {
            driver.Url = "https://www.olx.ro/myaccount/#login";
            
        }

        [TearDown]
        public void closeBrowser()
        {
            driver.Close();
        }

    }
}
