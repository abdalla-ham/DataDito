namespace Web.NetDataDito.Models
{
    public class DashboardViewModel
    {
        public string UserName { get; set; } = "User";
        public string UserEmail { get; set; }
        public string UserPhone { get; set; }
        public string PackageName { get; set; }

        public int UsedData { get; set; }
        public int TotalData { get; set; }
        public int RemainingData { get; set; }

        public int UsedMinutes { get; set; }
        public int TotalMinutes { get; set; }
        public int RemainingMinutes { get; set; }

        public int UsedSMS { get; set; }
        public int TotalSMS { get; set; }
        public int RemainingSMS { get; set; }

        // Percentage calculations
        public double DataPercentage => TotalData > 0 ? (UsedData * 100.0 / TotalData) : 0;
        public double MinutesPercentage => TotalMinutes > 0 ? (UsedMinutes * 100.0 / TotalMinutes) : 0;
        public double SMSPercentage => TotalSMS > 0 ? (UsedSMS * 100.0 / TotalSMS) : 0;

        // Helper methods to calculate used amounts
        public void CalculateUsedAmounts()
        {
            UsedData = TotalData - RemainingData;
            UsedMinutes = TotalMinutes - RemainingMinutes;
            UsedSMS = TotalSMS - RemainingSMS;
        }
    }
}