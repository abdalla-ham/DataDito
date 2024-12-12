namespace Web.NetDataDito.Models
{
    public class DashboardViewModel
    {
        public string UserName { get; set; } 
        public int UsedData { get; set; }    
        public int TotalData { get; set; }   
        public int UsedMinutes { get; set; }
        public int TotalMinutes { get; set; }
        public int UsedSMS { get; set; }
        public int TotalSMS { get; set; }
    }
}
