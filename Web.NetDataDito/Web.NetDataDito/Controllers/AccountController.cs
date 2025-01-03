using Microsoft.AspNetCore.Mvc;
using System.Net.Http;
using System.Text;
using System.Text.Json;
using System.Threading.Tasks;
using Web.NetDataDito.Models;
using Web.NetDataDito.ApiModels;

namespace Web.NetDataDito.Controllers
{
    public class AccountController : Controller
    {
        private readonly HttpClient _httpClient;
        private const string BaseApiUrl = "http://34.56.3.235:8080/v1/api";

        public AccountController(IHttpClientFactory httpClientFactory)
        {
            _httpClient = httpClientFactory.CreateClient();
        }

        // GET: /Account/Login
        [HttpGet]
        public IActionResult Login()
        {
            return View();
        }

        // POST: /Account/Login
        [HttpPost]
        public async Task<IActionResult> Login([FromBody] LoginRequest model)
        {
            try
            {
                var response = await _httpClient.PostAsJsonAsync($"{BaseApiUrl}/auth/login", new
                {
                    msisdn = model.Msisdn,
                    password = model.Password
                });

                if (response.IsSuccessStatusCode)
                {
                    var result = await response.Content.ReadFromJsonAsync<LoginResponse>();
                    // Here you might want to store the token/user info in session/cookie
                    return Json(new { success = true });
                }

                return Json(new { success = false, message = "Invalid credentials" });
            }
            catch (Exception ex)
            {
                // Log the exception
                return Json(new { success = false, message = "An error occurred during login "});
            }
        }

        // GET: /Account/Register
        [HttpGet]
        public IActionResult Register()
        {
            return View();
        }

        // POST: /Account/Register
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> Register(RegisterRequest model)
        {
            try
            {
                var registerData = new
                {
                    name = model.Name,
                    surname = model.Surname,
                    msisdn = model.Msisdn,
                    email = model.Email,
                    password = model.Password,
                    tcNumber = model.TcNumber,
                    packageName = model.PackageName,
                    sdate = model.Sdate ?? DateTime.Now.ToString("yyyy-MM-dd")
                };

                var response = await _httpClient.PostAsJsonAsync($"{BaseApiUrl}/auth/register", registerData);

                if (response.IsSuccessStatusCode)
                {
                    TempData["SuccessMessage"] = "Registration successful!";
                    return RedirectToAction(nameof(Login));
                }

                var errorContent = await response.Content.ReadAsStringAsync();
                ModelState.AddModelError("", "Registration failed: " + errorContent);
            }
            catch (Exception ex)
            {
                // Log the exception
                ModelState.AddModelError("", "An error occurred during registration " +ex);
            }

            return View(model);
        }

        // GET: /Account/ForgotPassword
        [HttpGet]
        public IActionResult ForgotPassword()
        {
            return View();
        }

        // POST: /Account/ForgotPassword
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> ForgotPassword(ForgotPasswordRequest model)
        {
            try
            {
                var forgotPasswordData = new
                {
                    email = model.Email,
                    tcNumber = model.TcNumber
                };

                var response = await _httpClient.PostAsJsonAsync($"{BaseApiUrl}/forgetPassword/reset", forgotPasswordData);

                if (response.IsSuccessStatusCode)
                {
                    return View("SuccessInformation");
                }

                var errorContent = await response.Content.ReadAsStringAsync();
                ModelState.AddModelError("", "Password reset failed: " + errorContent);
            }
            catch (Exception ex)
            {
                // Log the exception
                ModelState.AddModelError("", "An error occurred during password reset "+ex);
            }

            return View(model);
        }

        // POST: /Account/Logout
        [HttpPost]
        public IActionResult Logout()
        {
            // Clear any authentication cookies or session data
            // Redirect to login page
            return RedirectToAction(nameof(Login));
        }

        // Helper method to handle API errors
        private void HandleApiError(HttpResponseMessage response)
        {
            if (!response.IsSuccessStatusCode)
            {
                var error = response.Content.ReadAsStringAsync().Result;
                throw new Exception($"API Error: {response.StatusCode} - {error}");
            }
        }
    }

    // Response classes for API
    public class LoginResponse
    {
        public bool Success { get; set; }
        public string Token { get; set; }
        public string Message { get; set; }
    }
}