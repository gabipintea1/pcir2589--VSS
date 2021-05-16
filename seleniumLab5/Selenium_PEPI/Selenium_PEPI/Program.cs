using System;
using System.Text.Json;
using NUnit.Framework;
using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;
using OpenQA.Selenium.Support.UI;
using System.Threading.Tasks;
using System.Threading;
using System.IO;
namespace Selenium_PEPI
{
    class Program
    {
        string USER = null;
        string PASS = null;
        string INVALID_MSG = null;
        IWebDriver driver;


        private void init()
        {
            StreamReader reader = new StreamReader("E:/GitHubRepos/pcir2589--VSS/seleniumLab5/Selenium_PEPI/Selenium_PEPI/data.csv");
            string[] data = reader.ReadToEnd().Split(",");
            Console.WriteLine(data.ToString());
            USER = data[0];
            PASS = data[1];
            INVALID_MSG = data[2];

        }

        public void TestLogin()
        {
            
            IWebElement loginButton = driver.FindElement(By.Id("login2"));
            loginButton.Click();

            IWebElement emailField = driver.FindElement(By.Id("loginusername"));
            IWebElement passField = driver.FindElement(By.Id("loginpassword"));

            emailField.SendKeys(USER);
            passField.SendKeys(PASS);

            IWebElement loginModal = driver.FindElement(By.Id("logInModal"));
            IWebElement modalFooter = loginModal.FindElement(By.ClassName("modal-footer"));
            IWebElement confirmButton = modalFooter.FindElement(By.CssSelector(":nth-child(2)"));
            confirmButton.Click();
        }

        public void TestAddToCart()
        {
            IWebElement samsungRef = driver.FindElement(By.LinkText("Samsung galaxy s6"));
            samsungRef.Click();
            IWebElement addButton = driver.FindElement(By.LinkText("Add to cart"));
            addButton.Click();
        }

        public void TestRemoveFromCart()
        {
            IWebElement cartRef = driver.FindElement(By.LinkText("Cart"));
            cartRef.Click();
            IWebElement deleteRef = driver.FindElement(By.LinkText("Delete"));
            Thread.Sleep(2000);
            deleteRef.Click();

        }

        public void TestLogout()
        {

            
            
            IWebElement loginButton = driver.FindElement(By.Id("logout2"));
            Console.WriteLine(loginButton.Text);
            loginButton.Click();
        }

        [SetUp]
        public void startBrowser()
        {
            init();
            driver = new ChromeDriver("E:/GitHubRepos/pcir2589--VSS/seleniumLab5/Selenium_PEPI");
            driver.Url = "https://www.demoblaze.com/";
            driver.Manage().Window.Maximize();
            driver.Manage().Timeouts().ImplicitWait = TimeSpan.FromSeconds(2);
        }

        [Test]
        public void RunInvalidTest()
        {
            IWebElement loginButton = driver.FindElement(By.Id("login2"));
            loginButton.Click();

            IWebElement emailField = driver.FindElement(By.Id("loginusername"));
            IWebElement passField = driver.FindElement(By.Id("loginpassword"));

            emailField.SendKeys("INVALID");
            passField.SendKeys("INVALID");

            IWebElement loginModal = driver.FindElement(By.Id("logInModal"));
            IWebElement modalFooter = loginModal.FindElement(By.ClassName("modal-footer"));
            IWebElement confirmButton = modalFooter.FindElement(By.CssSelector(":nth-child(2)"));
            confirmButton.Click();
            Thread.Sleep(2000);
            string invalidModalText = driver.SwitchTo().Alert().Text;
            driver.SwitchTo().Alert().Accept();
            Assert.AreEqual(INVALID_MSG,invalidModalText);
            Console.WriteLine("INVALID LOGIN PASSED");
        }

        [Test]
        public void RunTests()
        {
            TestLogin();
            Console.WriteLine("LOGIN PASSED");
            Thread.Sleep(3000);
            TestAddToCart();
            Console.WriteLine("ADD PASSED");
            Thread.Sleep(3000);
            driver.SwitchTo().Alert().Accept();
            TestRemoveFromCart();
            Console.WriteLine("REMOVE PASSED");
            Thread.Sleep(3000);
            TestLogout();
            Console.WriteLine("LOGOUT PASSED");
            

        }

        [TearDown]
        public void closeBrowser()
        {
            Thread.Sleep(2000);
            driver.Close();
        }

    }
}
