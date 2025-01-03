using Web.NetDataDito.ApiModels;
using Web.NetDataDito.Models;
using System.Diagnostics;
using Microsoft.AspNetCore.Mvc;

public class DashboardController : Controller
{
    private readonly HttpClient _httpClient;
    private const string BaseApiUrl = "http://34.56.3.235:8080/v1/api";

    public DashboardController(IHttpClientFactory httpClientFactory)
    {
        _httpClient = httpClientFactory.CreateClient();
    }

    public async Task<IActionResult> Index()
    {
        try
        {
            // Get user's MSISDN from session/claims
            var msisdn = User.Identity.Name; // Adjust based on your authentication setup

            // Get user package
            var packageResponse = await _httpClient.GetAsync($"{BaseApiUrl}/packages/getUserPackageByMsisdn?msisdn={msisdn}");
            var packageDetails = await packageResponse.Content.ReadFromJsonAsync<PackageDetails>();

            // Get remaining balance
            var balanceResponse = await _httpClient.GetAsync($"{BaseApiUrl}/balance/remainingBalance?accountId={msisdn}");
            var balanceDetails = await balanceResponse.Content.ReadFromJsonAsync<RemainingBalance>();

            var viewModel = new DashboardViewModel
            {
                // Map API response to view model
                // Add properties as needed
            };

            return View(viewModel);
        }
        catch (Exception ex)
        {
            return View("Error");
        }
    }
}