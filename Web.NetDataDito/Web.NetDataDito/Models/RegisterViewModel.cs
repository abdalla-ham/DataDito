using System.ComponentModel.DataAnnotations;

namespace Web.NetDataDito.Models
{
    public class RegisterViewModel
    {
        [Required]
        public string Name { get; set; }

        [Required]
        public string Surname { get; set; }

        [Required]
        [Phone]
        public string Msisdn { get; set; }

        [Required]
        [EmailAddress]
        public string Email { get; set; }

        [Required]
        public string Password { get; set; }

        [Required]
        public string TcNumber { get; set; }

        [Required]
        public string PackageName { get; set; }

        public string Sdate { get; set; } = DateTime.Now.ToString("yyyy-MM-dd");
    }
}
