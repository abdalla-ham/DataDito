using System.ComponentModel.DataAnnotations;

namespace Web.NetDataDito.Models
{
    public class RegisterViewModel
    {
        [Required(ErrorMessage = "Name is required")]
        [StringLength(50, MinimumLength = 2, ErrorMessage = "Name must be between 2 and 50 characters")]
        [RegularExpression(@"^[a-zA-ZðüþýöçÐÜÞÝÖÇ\s]*$", ErrorMessage = "Name can only contain letters")]
        public string Name { get; set; }

        [Required(ErrorMessage = "Surname is required")]
        [StringLength(50, MinimumLength = 2, ErrorMessage = "Surname must be between 2 and 50 characters")]
        [RegularExpression(@"^[a-zA-ZðüþýöçÐÜÞÝÖÇ\s]*$", ErrorMessage = "Surname can only contain letters")]
        public string Surname { get; set; }

        [Required(ErrorMessage = "Phone number is required")]
        [RegularExpression(@"^5[0-9]{9}$", ErrorMessage = "Phone number must start with 5 and be 10 digits")]
        [Phone(ErrorMessage = "Please enter a valid phone number")]
        public string Msisdn { get; set; }

        [Required(ErrorMessage = "Email is required")]
        [EmailAddress(ErrorMessage = "Please enter a valid email address")]
        [StringLength(100, ErrorMessage = "Email cannot be longer than 100 characters")]
        public string Email { get; set; }

        [Required(ErrorMessage = "Password is required")]
        [StringLength(32, MinimumLength = 6, ErrorMessage = "Password must be between 6 and 32 characters")]
        [RegularExpression(@"^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{6,32}$",
            ErrorMessage = "Password must contain at least one uppercase letter, one lowercase letter, one number and one special character")]
        public string Password { get; set; }

        [Required(ErrorMessage = "TC Number is required")]
        [StringLength(11, MinimumLength = 11, ErrorMessage = "TC Number must be 11 digits")]
        [RegularExpression(@"^[0-9]{11}$", ErrorMessage = "TC Number must be 11 digits and contain only numbers")]
        public string TcNumber { get; set; }

        [Required(ErrorMessage = "Package Name is required")]
        [StringLength(50, ErrorMessage = "Package Name cannot be longer than 50 characters")]
        public string PackageName { get; set; }

        [DataType(DataType.Date)]
        [DisplayFormat(DataFormatString = "{0:yyyy-MM-dd}", ApplyFormatInEditMode = true)]
        public string Sdate { get; set; } = DateTime.Now.ToString("yyyy-MM-dd");
    }
}