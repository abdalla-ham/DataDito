using System.ComponentModel.DataAnnotations;

namespace Web.NetDataDito.Models
{
    public class RegisterViewModel
    {
        [Required]
        [StringLength(50, ErrorMessage = "Name cannot exceed 50 characters.")]
        public string Name { get; set; }

        [Required]
        [StringLength(50, ErrorMessage = "Surname cannot exceed 50 characters.")]
        public string Surname { get; set; }

        [Required]
        [RegularExpression("^[0-9]{11}$", ErrorMessage = "National ID must be 11 digits.")]
        public string NationalID { get; set; }

        [Required]
        [RegularExpression("^5[0-9]{9}$", ErrorMessage = "Telephone Number must be in the format 5xx-xxx-xxxx.")]
        public string TelephoneNumber { get; set; }

        [Required]
        [EmailAddress]
        public string Email { get; set; }

        [Required]
        public string Role { get; set; } // For dropdown selection.

        [Required]
        [StringLength(32, MinimumLength = 8, ErrorMessage = "Password must be between 8 and 32 characters.")]
        [DataType(DataType.Password)]
        public string Password { get; set; }
    }
}
