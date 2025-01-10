using Microsoft.AspNetCore.Mvc;
using System.Text.Json;

using Microsoft.AspNetCore.Mvc;
using System.Text.Json;
using Web.NetDataDito.Models;

namespace Web.NetDataDito.Controllers
{
    public class DashboardController : Controller
    {
        private readonly HttpClient _httpClient;
        private readonly ILogger<DashboardController> _logger;
        private const string BaseApiUrl = "http://34.56.3.235:8080/v1/api";

        public DashboardController(IHttpClientFactory httpClientFactory, ILogger<DashboardController> logger)
        {
            _httpClient = httpClientFactory.CreateClient();
            _logger = logger;
        }

        [HttpGet]
        public async Task<IActionResult> Index()
        {
            try
            {
                var msisdn = HttpContext.Session.GetString("UserMsisdn");
                if (string.IsNullOrEmpty(msisdn))
                {
                    return RedirectToAction("Login", "Account");
                }

                // Get customer details
                var customerResponse = await _httpClient.GetAsync($"{BaseApiUrl}/customer/getCustomerByMsisdn?msisdn={msisdn}");
                var customerContent = await customerResponse.Content.ReadAsStringAsync();
                _logger.LogInformation($"Customer Response: {customerContent}");

                CustomerDetails customerDetails = null;
                if (customerResponse.IsSuccessStatusCode)
                {
                    customerDetails = JsonSerializer.Deserialize<CustomerDetails>(customerContent, new JsonSerializerOptions
                    {
                        PropertyNameCaseInsensitive = true
                    });
                }

                // Get user's package
                var packageResponse = await _httpClient.GetAsync($"{BaseApiUrl}/packages/getUserPackageByMsisdn?msisdn={msisdn}");
                var packageContent = await packageResponse.Content.ReadAsStringAsync();
                _logger.LogInformation($"Package Response: {packageContent}");

                PackageDetails packageDetails = null;
                if (packageResponse.IsSuccessStatusCode)
                {
                    packageDetails = JsonSerializer.Deserialize<PackageDetails>(packageContent, new JsonSerializerOptions
                    {
                        PropertyNameCaseInsensitive = true
                    });
                }

                var viewModel = new DashboardViewModel
                {
                    UserName = $"{customerDetails?.Name} {customerDetails?.Surname}",
                    TotalData = packageDetails?.AmountData ?? 0,
                    UsedData = 0, // This should come from API
                    TotalMinutes = packageDetails?.AmountMinutes ?? 0,
                    UsedMinutes = 0, // This should come from API
                    TotalSMS = packageDetails?.AmountSms ?? 0,
                    UsedSMS = 0 // This should come from API
                };

                return View(viewModel);
            }
            catch (Exception ex)
            {
                _logger.LogError($"Dashboard Error: {ex.Message}");
                return View(new DashboardViewModel());
            }
        }
    }

    public class CustomerDetails
    {
        public string Name { get; set; }
        public string Surname { get; set; }
        public string Email { get; set; }
        public string Msisdn { get; set; }
    }

    public class PackageDetails
    {
        public string PackageName { get; set; }
        public int AmountData { get; set; }
        public int AmountMinutes { get; set; }
        public int AmountSms { get; set; }
    }
}