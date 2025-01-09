using Microsoft.AspNetCore.Mvc;
using System.Text.Json;
using Web.NetDataDito.Models;

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
            // Get user's MSISDN from session
            var msisdn = HttpContext.Session.GetString("UserMsisdn");
            if (string.IsNullOrEmpty(msisdn))
            {
                return RedirectToAction("Login", "Account");
            }

            // Get user package
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

            // Since the balance API is not providing usage information,
            // we'll show package limits and assume some usage for demonstration
            var viewModel = new DashboardViewModel
            {
                UserName = msisdn, // Or get from session if available
                TotalData = packageDetails?.AmountData ?? 100,
                UsedData = 30, // Example usage (30%)
                TotalMinutes = packageDetails?.AmountMinutes ?? 100,
                UsedMinutes = 40, // Example usage (40%)
                TotalSMS = packageDetails?.AmountSms ?? 100,
                UsedSMS = 20 // Example usage (20%)
            };

            return View(viewModel);
        }
        catch (Exception ex)
        {
            _logger.LogError($"Dashboard Error: {ex.Message}");
            return View(new DashboardViewModel
            {
                UserName = "User",
                TotalData = 100,
                UsedData = 0,
                TotalMinutes = 100,
                UsedMinutes = 0,
                TotalSMS = 100,
                UsedSMS = 0
            });
        }
    }
}

public class PackageDetails
{
    public int PackageId { get; set; }
    public string PackageName { get; set; }
    public decimal Price { get; set; }
    public int AmountMinutes { get; set; }
    public int AmountData { get; set; }
    public int AmountSms { get; set; }
    public int Period { get; set; }
}