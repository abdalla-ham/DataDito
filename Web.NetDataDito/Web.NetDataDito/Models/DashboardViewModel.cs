namespace Web.NetDataDito.Models
{
    public class DashboardViewModel
    {
        public string UserName { get; set; } = "User";
        public int UsedData { get; set; }
        public int TotalData { get; set; }
        public int UsedMinutes { get; set; }
        public int TotalMinutes { get; set; }
        public int UsedSMS { get; set; }
        public int TotalSMS { get; set; }

  
        public double DataPercentage => TotalData > 0 ? (UsedData * 100.0 / TotalData) : 0;
        public double MinutesPercentage => TotalMinutes > 0 ? (UsedMinutes * 100.0 / TotalMinutes) : 0;
        public double SMSPercentage => TotalSMS > 0 ? (UsedSMS * 100.0 / TotalSMS) : 0;
    }
}
