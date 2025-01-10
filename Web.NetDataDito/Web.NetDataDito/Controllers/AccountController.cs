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
        private readonly ILogger<AccountController> _logger;
        private const string BaseApiUrl = "http://34.56.3.235:8080/v1/api";

        public AccountController(IHttpClientFactory httpClientFactory, ILogger<AccountController> logger)
        {
            _httpClient = httpClientFactory.CreateClient();
            _logger = logger;
            _httpClient.DefaultRequestHeaders.Accept.Add(new System.Net.Http.Headers.MediaTypeWithQualityHeaderValue("application/json"));
        }

        [HttpGet]
        public IActionResult Login()
        {
            return View();
        }

        [HttpPost]
        public async Task<IActionResult> Login([FromBody] LoginRequest model)
        {
            try
            {
                var loginData = new
                {
                    msisdn = model.Msisdn,
                    password = model.Password
                };

                var jsonContent = JsonSerializer.Serialize(loginData);
                var content = new StringContent(jsonContent, Encoding.UTF8, "application/json");

                // First, check if user exists
                var userCheckResponse = await _httpClient.GetAsync($"{BaseApiUrl}/customer/getCustomerByMsisdn?msisdn={model.Msisdn}");

                if (!userCheckResponse.IsSuccessStatusCode)
                {
                    return Json(new { success = false, message = "User not found. Please register first." });
                }

                // Proceed with login
                var loginResponse = await _httpClient.PostAsync($"{BaseApiUrl}/auth/login", content);
                var responseContent = await loginResponse.Content.ReadAsStringAsync();

                _logger.LogInformation($"Login API Response: {responseContent}");

                if (loginResponse.IsSuccessStatusCode)
                {
                    if (responseContent.Contains("Login successful"))
                    {
                        // Store user information in session
                        HttpContext.Session.SetString("UserMsisdn", model.Msisdn);

                        // Get user's package information
                        var packageResponse = await _httpClient.GetAsync($"{BaseApiUrl}/packages/getUserPackageByMsisdn?msisdn={model.Msisdn}");
                        var packageContent = await packageResponse.Content.ReadAsStringAsync();

                        if (packageResponse.IsSuccessStatusCode)
                        {
                            HttpContext.Session.SetString("UserPackage", packageContent);
                        }

                        return Json(new { success = true });
                    }
                    return Json(new { success = false, message = "Invalid credentials" });
                }

                return Json(new { success = false, message = "Login failed" });
            }
            catch (Exception ex)
            {
                _logger.LogError($"Login Error: {ex.Message}");
                return Json(new { success = false, message = "An error occurred during login" });
            }
        }

        [HttpGet]
        public IActionResult Register()
        {
            return View();
        }

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

                var jsonContent = JsonSerializer.Serialize(registerData);
                var content = new StringContent(jsonContent, Encoding.UTF8, "application/json");

                var response = await _httpClient.PostAsync($"{BaseApiUrl}/auth/register", content);
                var responseContent = await response.Content.ReadAsStringAsync();

                _logger.LogInformation($"Register API Response: {responseContent}");

                if (response.IsSuccessStatusCode)
                {
                    if (Request.Headers["X-Requested-With"] == "XMLHttpRequest")
                    {
                        return Json(new { success = true });
                    }
                    TempData["SuccessMessage"] = "Registration successful!";
                    return RedirectToAction(nameof(Login));
                }

                if (Request.Headers["X-Requested-With"] == "XMLHttpRequest")
                {
                    return Json(new { success = false, message = responseContent });
                }
                ModelState.AddModelError("", $"Registration failed: {responseContent}");
            }
            catch (Exception ex)
            {
                _logger.LogError($"Registration Error: {ex.Message}");
                if (Request.Headers["X-Requested-With"] == "XMLHttpRequest")
                {
                    return Json(new { success = false, message = "An error occurred during registration" });
                }
                ModelState.AddModelError("", "An error occurred during registration");
            }

            return View(model);
        }

        [HttpGet]
        public IActionResult ForgotPassword()
        {
            return View();
        }

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

                var jsonContent = JsonSerializer.Serialize(forgotPasswordData);
                var content = new StringContent(jsonContent, Encoding.UTF8, "application/json");

                var response = await _httpClient.PostAsync($"{BaseApiUrl}/forgetPassword/reset", content);
                var responseContent = await response.Content.ReadAsStringAsync();

                _logger.LogInformation($"Forgot Password API Response: {responseContent}");

                if (response.IsSuccessStatusCode)
                {
                    return View("SuccessInformation");
                }

                _logger.LogWarning($"Password reset failed: {responseContent}");
                ModelState.AddModelError("", $"Password reset failed: {responseContent}");
            }
            catch (Exception ex)
            {
                _logger.LogError($"Forgot Password Error: {ex.Message}");
                ModelState.AddModelError("", "An error occurred during password reset");
            }

            return View(model);
        }

        [HttpPost]
        public IActionResult Logout()
        {
            // Clear all session data
            HttpContext.Session.Clear();
            return RedirectToAction(nameof(Login));
        }

        private async Task<string> HandleApiError(HttpResponseMessage response)
        {
            var content = await response.Content.ReadAsStringAsync();
            _logger.LogError($"API Error: {response.StatusCode} - {content}");
            return content;
        }

        // Helper method to check if user is logged in
        private bool IsUserLoggedIn()
        {
            return !string.IsNullOrEmpty(HttpContext.Session.GetString("UserMsisdn"));
        }
    }

    public class LoginResponse
    {
        public bool Success { get; set; }
        public string Token { get; set; }
        public string Message { get; set; }
    }
}