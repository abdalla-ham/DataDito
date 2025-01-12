using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Net.Http;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using Newtonsoft.Json;

namespace DataDito
{
    public partial class LoginPage : Form
    {
        private static readonly HttpClient client = new HttpClient();
        private static readonly string loginEndpoint = "http://34.56.3.235:8080/v1/api/auth/login";
        private static readonly string registerEndpoint = "http://34.56.3.235:8080/v1/api/auth/register";
        private static readonly string forgotEndpoint = "http://34.56.3.235:8080/v1/api/forgetPassword/reset";

        public LoginPage()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            loginPanel.Visible = false;
            registerPanel.Visible = false;
            forgotPanel.Visible = true;
        }

        private void checkBox1_CheckedChanged(object sender, EventArgs e)
        {

        }

        private void button2_Click(object sender, EventArgs e)
        {
            if (!registerPanel.Visible){
                loginPanel.Visible = false;
                registerPanel.Visible = true;
            }
        }

        private async void button3_Click(object sender, EventArgs e)
        {
            var password = loginPassBox.Text;
            var phone = loginPhoneBox.Text;

           

            var json = new {

                msisdn = phone,
                password = password
            
            };
            string jsonstring = JsonConvert.SerializeObject(json);

            var payload = new StringContent(jsonstring, Encoding.UTF8, "application/json");
            var response = await client.PostAsync(loginEndpoint, payload);
            string responsebody = await response.Content.ReadAsStringAsync();
            MessageBox.Show(responsebody);
            if (responsebody.StartsWith("Login successful"))
            {
                MessageBox.Show("Login Successful!", "Success", MessageBoxButtons.OK, MessageBoxIcon.Information);
                loginPanel.Visible = false;
                userPanel.Visible = true;
                return;
            }

            MessageBox.Show("Wrong Credentials.", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
            loginPanel.Visible=false;
            userPanel.Visible=true;
            return;


        }

        private void textBox1_TextChanged(object sender, EventArgs e)
        {

        }

        private void textBox1_Enter(object sender, EventArgs e)
        {
            if (loginPhoneBox.Text == "Phone Number")
            {
                loginPhoneBox.Text = "";
                loginPhoneBox.ForeColor = Color.Black;
            }
        }

        private void textBox1_Leave(object sender, EventArgs e)
        {
            if (loginPhoneBox.Text == "")
            {
                loginPhoneBox.Text = "Phone Number";
                loginPhoneBox.ForeColor = Color.DarkGray;
            }
        }

        private void textBox2_Enter(object sender, EventArgs e)
        {
            if (loginPassBox.Text == "Password")
            {
                loginPassBox.Text = "";
                loginPassBox.ForeColor = Color.Black;
                loginPassBox.PasswordChar = '●';
            }
        }

        private void textBox2_Leave(object sender, EventArgs e)
        {
            if (loginPassBox.Text == "")
            {
                loginPassBox.Text = "Password";
                loginPassBox.ForeColor = Color.DarkGray;
                loginPassBox.PasswordChar = '\0';
            }
        }

        private void textBox1_KeyPress(object sender, KeyPressEventArgs e)
        {
            if (char.IsControl(e.KeyChar))
            {
                return;
            }

            if (char.IsDigit(e.KeyChar))
            {
                e.Handled = false;
            }

            else
            {
                e.Handled = true;
            }
        }

        private void forgotIDBox_Enter(object sender, EventArgs e)
        {
            if (forgotIDBox.Text == "National ID:")
            {
                forgotIDBox.Text = "";
                forgotIDBox.ForeColor = Color.Black;
            }
        }

        private void forgotIDBox_Leave(object sender, EventArgs e)
        {
            
            if (forgotIDBox.Text == "")
            {
                forgotIDBox.Text = "National ID:";
                forgotIDBox.ForeColor = Color.DarkGray;
            }


        }

        private void forgotEmailBox_Enter(object sender, EventArgs e)
        {
            if (forgotEmailBox.Text == "Email:")
            {
                forgotEmailBox.Text = "";
                forgotEmailBox.ForeColor = Color.Black;
            }
        }

        private void forgotEmailBox_Leave(object sender, EventArgs e)
        {
            if (forgotEmailBox.Text == "")
            {
                forgotEmailBox.Text = "Email:";
                forgotEmailBox.ForeColor = Color.DarkGray;
            }
        }

        private void forgotToLogin_Click(object sender, EventArgs e)
        {
            registerPanel.Visible = false;
            forgotPanel.Visible = false;
            loginPanel.Visible = true;
        }

        private void registerToLogin_Click(object sender, EventArgs e)
        {
            forgotPanel.Visible = false;
            registerPanel.Visible = false;
            loginPanel.Visible = true;

        }

        private void registerPassBox_Enter(object sender, EventArgs e)
        {
            if (registerPassBox.Text == "Password:")
            {
                registerPassBox.Text = "";
                registerPassBox.ForeColor = Color.Black;
                registerPassBox.PasswordChar = '●';
            }
        }

        private void registerPassBox_Leave(object sender, EventArgs e)
        {
            if (registerPassBox.Text == "")
            {
                registerPassBox.Text = "Password:";
                registerPassBox.ForeColor = Color.DarkGray;
                registerPassBox.PasswordChar = '\0';
            }
        }

        private void registerNameBox_Enter(object sender, EventArgs e)
        {
            if (registerNameBox.Text == "Name:")
            {
                registerNameBox.Text = "";
                registerNameBox.ForeColor = Color.Black;
            }
        }

        private void registerNameBox_Leave(object sender, EventArgs e)
        {
            if (registerNameBox.Text == "")
            {
                registerNameBox.Text = "Name:";
                registerNameBox.ForeColor = Color.DarkGray;
            }
        }

        private void registerSurnameBox_Enter(object sender, EventArgs e)
        {
            if (registerSurnameBox.Text == "Surname:")
            {
                registerSurnameBox.Text = "";
                registerSurnameBox.ForeColor = Color.Black;
            }
        }

        private void registerSurnameBox_Leave(object sender, EventArgs e)
        {
            if (registerSurnameBox.Text == "")
            {
                registerSurnameBox.Text = "Surname:";
                registerSurnameBox.ForeColor = Color.DarkGray;
            }
        }

        private void registerIDBox_Enter(object sender, EventArgs e)
        {
            if (registerIDBox.Text == "National ID:")
            {
                registerIDBox.Text = "";
                registerIDBox.ForeColor = Color.Black;
            }
        }

        private void registerIDBox_Leave(object sender, EventArgs e)
        {
            if (registerIDBox.Text == "")
            {
                registerIDBox.Text = "National ID:";
                registerIDBox.ForeColor = Color.DarkGray;
            }
        }

        private void registerPhoneBox_Enter(object sender, EventArgs e)
        {
            if (registerPhoneBox.Text == "Phone:")
            {
                registerPhoneBox.Text = "";
                registerPhoneBox.ForeColor = Color.Black;
            }
        }

        private void registerPhoneBox_Leave(object sender, EventArgs e)
        {
            if (registerPhoneBox.Text == "")
            {
                registerPhoneBox.Text = "Phone:";
                registerPhoneBox.ForeColor = Color.DarkGray;
            }
        }

        private void registerEmailBox_Enter(object sender, EventArgs e)
        {
            if (registerEmailBox.Text == "Email:")
            {
                registerEmailBox.Text = "";
                registerEmailBox.ForeColor = Color.Black;
            }
        }

        private void registerEmailBox_Leave(object sender, EventArgs e)
        {
            if (registerEmailBox.Text == "")
            {
                registerEmailBox.Text = "Email:";
                registerEmailBox.ForeColor = Color.DarkGray;
            }
        }

        private async void forgotSendButton_Click(object sender, EventArgs e)
        {
            string email = forgotEmailBox.Text;
            string id = forgotIDBox.Text;

            var json = new { 
            
            email = email,
            tcNumber = id
            };

            string jsonstring = JsonConvert.SerializeObject(json);
            var payload = new StringContent(jsonstring,Encoding.UTF8,"application/json");
            var response = await client.PostAsync(forgotEndpoint, payload);
            string responsebody = await response.Content.ReadAsStringAsync();

            MessageBox.Show(responsebody);

            if (responsebody.StartsWith("reset password successful"))
            {

                MessageBox.Show("Succesfully sent the reset link.", "Success", MessageBoxButtons.OK, MessageBoxIcon.Information);
                   return;
            }

            else { 
                
                MessageBox.Show("Something went wrong!","Error", MessageBoxButtons.OK,MessageBoxIcon.Error);
                return;
            }

        }

        private void userLogoutButton_Click(object sender, EventArgs e)
        {
            userPanel.Visible = false;
            loginPanel.Visible = true;
        }

        private async void registerRegisterButton_Click(object sender, EventArgs e)
        {
            string name = registerNameBox.Text;
            string id = registerIDBox.Text;
            string surname = registerSurnameBox.Text;
            string email = registerEmailBox.Text;
            string password = registerPassBox.Text;
            string phone = registerPhoneBox.Text;
            string package = registerComboBox.Text;
            package = "default";
            DateTime sdate = DateTime.Now;
            var json = new { 
            
                name = name,
                surname = surname,
                msisdn = phone,
                email = email,
                password = password,
                tcNumber = id,
                packageName = package,
                sdate = sdate
           
            };

            string jsonstring = JsonConvert.SerializeObject(json);
            var content = new StringContent(jsonstring,Encoding.UTF8, "application/json");
            var response = await client.PostAsync(registerEndpoint, content);
            string responsebody = await response.Content.ReadAsStringAsync();

            MessageBox.Show(responsebody);

            if (responsebody.StartsWith("register successful"))
            {

                MessageBox.Show("Succesfully registered.", "Success", MessageBoxButtons.OK, MessageBoxIcon.Information);
                return;
            }

            else
            {

                MessageBox.Show("Something went wrong!", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
                return;
            }

        }
    }
}
