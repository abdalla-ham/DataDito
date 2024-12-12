using Microsoft.AspNetCore.Mvc;
using System.Net.Http;
using System.Text;
using System.Text.Json;
using System.Threading.Tasks;
using Web.NetDataDito.Models;

namespace Web.NetDataDito.Controllers
{
    public class AccountController : Controller
    {
        private readonly HttpClient _httpClient;

        public AccountController(IHttpClientFactory httpClientFactory)
        {
            _httpClient = httpClientFactory.CreateClient();
        }

        [HttpGet]
        public async Task<IActionResult> Register()
        {
            // Fetch roles from API
            var apiEndpoint = "https://APILink"; 
            var roles = new List<string> { "User", "Admin", "Editor" }; // Default roles in case API fails

            try
            {
                var response = await _httpClient.GetAsync(apiEndpoint);
                if (response.IsSuccessStatusCode)
                {
                    var jsonResponse = await response.Content.ReadAsStringAsync();
                    roles = JsonSerializer.Deserialize<List<string>>(jsonResponse);
                }
            }
            catch
            {
                // Log error or handle exception
            }

            ViewBag.Roles = roles;
            return View(new RegisterViewModel());
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> Register(RegisterViewModel model)
        {
            if (ModelState.IsValid)
            {
                // Write form data to console for debugging
                Console.WriteLine($"Name: {model.Name}");
                Console.WriteLine($"Surname: {model.Surname}");
                Console.WriteLine($"National ID: {model.NationalID}");
                Console.WriteLine($"Telephone Number: {model.TelephoneNumber}");
                Console.WriteLine($"Email: {model.Email}");
                Console.WriteLine($"Role: {model.Role}");
                Console.WriteLine($"Password: {model.Password}");

                // Send form data to API
                var apiEndpoint = "https://randomapi.com/api/register"; // Replace with your API endpoint
                var jsonContent = JsonSerializer.Serialize(model);
                var content = new StringContent(jsonContent, Encoding.UTF8, "application/json");

                try
                {
                    var response = await _httpClient.PostAsync(apiEndpoint, content);
                    if (response.IsSuccessStatusCode)
                    {
                        TempData["SuccessMessage"] = "Registration successful!";
                        return RedirectToAction("Login");
                    }
                    else
                    {
                        ModelState.AddModelError("", "An error occurred while registering. Please try again.");
                    }
                }
                catch
                {
                    ModelState.AddModelError("", "Failed to connect to the API. Please try again later.");
                }
            }

            // Reload roles if registration fails
            ViewBag.Roles = new List<string> { "User", "Admin", "Editor" }; // Default roles
            return View(model);
        }

        [HttpGet]
        public IActionResult ForgotPassword()
        {
            return View(); 
        }
    }
}
