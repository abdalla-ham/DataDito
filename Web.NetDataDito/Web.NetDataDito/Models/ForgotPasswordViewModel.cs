using System.ComponentModel.DataAnnotations;

namespace Web.NetDataDito.Models
{
    public class ForgotPasswordViewModel
    {
        [Required]
        [Display(Name = "National ID")]
        [RegularExpression("^[0-9]{11}$", ErrorMessage = "National ID must be 11 digits.")]
        public string NationalID { get; set; }

        [Required]
        [EmailAddress]
        [Display(Name = "Email")]
        public string Email { get; set; }
    }
}
