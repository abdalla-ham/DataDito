using Microsoft.AspNetCore.Mvc;
using Web.NetDataDito.Models;
using System.Net.Http;
using System.Text.Json;
using System.Threading.Tasks;

namespace Web.NetDataDito.Controllers
{
    public class DashboardController : Controller
    {
        private readonly HttpClient _httpClient;

        public DashboardController(IHttpClientFactory httpClientFactory)
        {
            _httpClient = httpClientFactory.CreateClient();
        }

        [HttpGet]
        public async Task<IActionResult> Index()
        {
            // Replace this with your actual API endpoint
            var apiEndpoint = "https://randomapi.com/api/dashboard";

            try
            {
                // Call the API to fetch dashboard information
                var response = await _httpClient.GetAsync(apiEndpoint);
                if (response.IsSuccessStatusCode)
                {
                    // Deserialize API response into DashboardViewModel
                    var apiResponse = await response.Content.ReadAsStringAsync();
                    var dashboardData = JsonSerializer.Deserialize<DashboardViewModel>(apiResponse);

                    // Pass the data to the view
                    return View(dashboardData);
                }
                else
                {
                    // Handle API error (log it, show a fallback view, etc.)
                    ModelState.AddModelError(string.Empty, "Unable to fetch dashboard information. Please try again later.");
                    return View(new DashboardViewModel());
                }
            }
            catch (Exception ex)
            {
                // Handle any unexpected errors (network issues, etc.)
                ModelState.AddModelError(string.Empty, $"An error occurred: {ex.Message}");
                return View(new DashboardViewModel());
            }
        }
    }
}
