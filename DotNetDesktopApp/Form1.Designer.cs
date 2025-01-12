namespace DataDito
{
    partial class LoginPage
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(LoginPage));
            this.loginRememberCheck = new System.Windows.Forms.CheckBox();
            this.loginPhoneBox = new System.Windows.Forms.TextBox();
            this.loginForgotButton = new System.Windows.Forms.Button();
            this.loginLoginButton = new System.Windows.Forms.Button();
            this.loginRegButton = new System.Windows.Forms.Button();
            this.loginPassBox = new System.Windows.Forms.TextBox();
            this.pictureBox1 = new System.Windows.Forms.PictureBox();
            this.loginPanel = new System.Windows.Forms.Panel();
            this.registerPanel = new System.Windows.Forms.Panel();
            this.registerComboBox = new System.Windows.Forms.ComboBox();
            this.registerToLogin = new System.Windows.Forms.Button();
            this.pictureBox2 = new System.Windows.Forms.PictureBox();
            this.registerRegisterButton = new System.Windows.Forms.Button();
            this.registerPassBox = new System.Windows.Forms.TextBox();
            this.registerEmailBox = new System.Windows.Forms.TextBox();
            this.registerPhoneBox = new System.Windows.Forms.TextBox();
            this.registerIDBox = new System.Windows.Forms.TextBox();
            this.registerSurnameBox = new System.Windows.Forms.TextBox();
            this.registerNameBox = new System.Windows.Forms.TextBox();
            this.forgotPanel = new System.Windows.Forms.Panel();
            this.pictureBox3 = new System.Windows.Forms.PictureBox();
            this.forgotToLogin = new System.Windows.Forms.Button();
            this.forgotEmailBox = new System.Windows.Forms.TextBox();
            this.forgotIDBox = new System.Windows.Forms.TextBox();
            this.forgotSendButton = new System.Windows.Forms.Button();
            this.userPanel = new System.Windows.Forms.Panel();
            this.pictureBox4 = new System.Windows.Forms.PictureBox();
            this.userDataBar = new System.Windows.Forms.ProgressBar();
            this.userMinutesBar = new System.Windows.Forms.ProgressBar();
            this.userSmsBar = new System.Windows.Forms.ProgressBar();
            this.label1 = new System.Windows.Forms.Label();
            this.minutesLabel = new System.Windows.Forms.Label();
            this.SmsLabel = new System.Windows.Forms.Label();
            this.userLogoutButton = new System.Windows.Forms.Button();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).BeginInit();
            this.loginPanel.SuspendLayout();
            this.registerPanel.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox2)).BeginInit();
            this.forgotPanel.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox3)).BeginInit();
            this.userPanel.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox4)).BeginInit();
            this.SuspendLayout();
            // 
            // loginRememberCheck
            // 
            this.loginRememberCheck.AutoSize = true;
            this.loginRememberCheck.Location = new System.Drawing.Point(218, 199);
            this.loginRememberCheck.Name = "loginRememberCheck";
            this.loginRememberCheck.Size = new System.Drawing.Size(95, 17);
            this.loginRememberCheck.TabIndex = 0;
            this.loginRememberCheck.Text = "Remember Me";
            this.loginRememberCheck.UseVisualStyleBackColor = true;
            this.loginRememberCheck.CheckedChanged += new System.EventHandler(this.checkBox1_CheckedChanged);
            // 
            // loginPhoneBox
            // 
            this.loginPhoneBox.Font = new System.Drawing.Font("Microsoft Sans Serif", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.loginPhoneBox.ForeColor = System.Drawing.Color.DarkGray;
            this.loginPhoneBox.Location = new System.Drawing.Point(222, 123);
            this.loginPhoneBox.Multiline = true;
            this.loginPhoneBox.Name = "loginPhoneBox";
            this.loginPhoneBox.Size = new System.Drawing.Size(230, 32);
            this.loginPhoneBox.TabIndex = 1;
            this.loginPhoneBox.Text = "Phone Number";
            this.loginPhoneBox.TextChanged += new System.EventHandler(this.textBox1_TextChanged);
            this.loginPhoneBox.Enter += new System.EventHandler(this.textBox1_Enter);
            this.loginPhoneBox.KeyPress += new System.Windows.Forms.KeyPressEventHandler(this.textBox1_KeyPress);
            this.loginPhoneBox.Leave += new System.EventHandler(this.textBox1_Leave);
            // 
            // loginForgotButton
            // 
            this.loginForgotButton.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.loginForgotButton.Location = new System.Drawing.Point(187, 222);
            this.loginForgotButton.Name = "loginForgotButton";
            this.loginForgotButton.Size = new System.Drawing.Size(142, 47);
            this.loginForgotButton.TabIndex = 3;
            this.loginForgotButton.Text = "Forgot Password";
            this.loginForgotButton.UseVisualStyleBackColor = true;
            this.loginForgotButton.Click += new System.EventHandler(this.button1_Click);
            // 
            // loginLoginButton
            // 
            this.loginLoginButton.BackColor = System.Drawing.Color.Red;
            this.loginLoginButton.Font = new System.Drawing.Font("Microsoft Sans Serif", 14.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.loginLoginButton.ForeColor = System.Drawing.SystemColors.ButtonFace;
            this.loginLoginButton.Location = new System.Drawing.Point(255, 328);
            this.loginLoginButton.Name = "loginLoginButton";
            this.loginLoginButton.Size = new System.Drawing.Size(163, 54);
            this.loginLoginButton.TabIndex = 5;
            this.loginLoginButton.Text = "Login";
            this.loginLoginButton.UseVisualStyleBackColor = false;
            this.loginLoginButton.Click += new System.EventHandler(this.button3_Click);
            // 
            // loginRegButton
            // 
            this.loginRegButton.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.loginRegButton.Location = new System.Drawing.Point(187, 275);
            this.loginRegButton.Name = "loginRegButton";
            this.loginRegButton.Size = new System.Drawing.Size(142, 47);
            this.loginRegButton.TabIndex = 7;
            this.loginRegButton.Text = "Register";
            this.loginRegButton.UseVisualStyleBackColor = true;
            this.loginRegButton.Click += new System.EventHandler(this.button2_Click);
            // 
            // loginPassBox
            // 
            this.loginPassBox.Font = new System.Drawing.Font("Microsoft Sans Serif", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.loginPassBox.ForeColor = System.Drawing.Color.DarkGray;
            this.loginPassBox.Location = new System.Drawing.Point(222, 161);
            this.loginPassBox.Multiline = true;
            this.loginPassBox.Name = "loginPassBox";
            this.loginPassBox.Size = new System.Drawing.Size(230, 32);
            this.loginPassBox.TabIndex = 8;
            this.loginPassBox.Text = "Password";
            this.loginPassBox.Enter += new System.EventHandler(this.textBox2_Enter);
            this.loginPassBox.Leave += new System.EventHandler(this.textBox2_Leave);
            // 
            // pictureBox1
            // 
            this.pictureBox1.Image = ((System.Drawing.Image)(resources.GetObject("pictureBox1.Image")));
            this.pictureBox1.Location = new System.Drawing.Point(139, 32);
            this.pictureBox1.Name = "pictureBox1";
            this.pictureBox1.Size = new System.Drawing.Size(408, 76);
            this.pictureBox1.SizeMode = System.Windows.Forms.PictureBoxSizeMode.Zoom;
            this.pictureBox1.TabIndex = 9;
            this.pictureBox1.TabStop = false;
            // 
            // loginPanel
            // 
            this.loginPanel.BackColor = System.Drawing.SystemColors.ControlLightLight;
            this.loginPanel.Controls.Add(this.pictureBox1);
            this.loginPanel.Controls.Add(this.loginLoginButton);
            this.loginPanel.Controls.Add(this.loginRegButton);
            this.loginPanel.Controls.Add(this.loginPassBox);
            this.loginPanel.Controls.Add(this.loginPhoneBox);
            this.loginPanel.Controls.Add(this.loginForgotButton);
            this.loginPanel.Controls.Add(this.loginRememberCheck);
            this.loginPanel.Location = new System.Drawing.Point(0, 0);
            this.loginPanel.Name = "loginPanel";
            this.loginPanel.Size = new System.Drawing.Size(694, 426);
            this.loginPanel.TabIndex = 10;
            // 
            // registerPanel
            // 
            this.registerPanel.BackColor = System.Drawing.SystemColors.ControlLightLight;
            this.registerPanel.Controls.Add(this.registerComboBox);
            this.registerPanel.Controls.Add(this.registerToLogin);
            this.registerPanel.Controls.Add(this.pictureBox2);
            this.registerPanel.Controls.Add(this.registerRegisterButton);
            this.registerPanel.Controls.Add(this.registerPassBox);
            this.registerPanel.Controls.Add(this.registerEmailBox);
            this.registerPanel.Controls.Add(this.registerPhoneBox);
            this.registerPanel.Controls.Add(this.registerIDBox);
            this.registerPanel.Controls.Add(this.registerSurnameBox);
            this.registerPanel.Controls.Add(this.registerNameBox);
            this.registerPanel.Location = new System.Drawing.Point(12, 12);
            this.registerPanel.Name = "registerPanel";
            this.registerPanel.Size = new System.Drawing.Size(703, 426);
            this.registerPanel.TabIndex = 10;
            this.registerPanel.Visible = false;
            // 
            // registerComboBox
            // 
            this.registerComboBox.DropDownHeight = 100;
            this.registerComboBox.Font = new System.Drawing.Font("Microsoft Sans Serif", 11.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.registerComboBox.FormattingEnabled = true;
            this.registerComboBox.IntegralHeight = false;
            this.registerComboBox.ItemHeight = 18;
            this.registerComboBox.Location = new System.Drawing.Point(82, 255);
            this.registerComboBox.Name = "registerComboBox";
            this.registerComboBox.Size = new System.Drawing.Size(230, 26);
            this.registerComboBox.TabIndex = 14;
            this.registerComboBox.Text = "Select a package";
            // 
            // registerToLogin
            // 
            this.registerToLogin.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.registerToLogin.Location = new System.Drawing.Point(292, 350);
            this.registerToLogin.Name = "registerToLogin";
            this.registerToLogin.Size = new System.Drawing.Size(142, 38);
            this.registerToLogin.TabIndex = 13;
            this.registerToLogin.Text = "Back to Login";
            this.registerToLogin.UseVisualStyleBackColor = true;
            this.registerToLogin.Click += new System.EventHandler(this.registerToLogin_Click);
            // 
            // pictureBox2
            // 
            this.pictureBox2.Image = ((System.Drawing.Image)(resources.GetObject("pictureBox2.Image")));
            this.pictureBox2.Location = new System.Drawing.Point(333, 55);
            this.pictureBox2.Name = "pictureBox2";
            this.pictureBox2.Size = new System.Drawing.Size(361, 265);
            this.pictureBox2.SizeMode = System.Windows.Forms.PictureBoxSizeMode.Zoom;
            this.pictureBox2.TabIndex = 9;
            this.pictureBox2.TabStop = false;
            // 
            // registerRegisterButton
            // 
            this.registerRegisterButton.BackColor = System.Drawing.Color.Red;
            this.registerRegisterButton.Font = new System.Drawing.Font("Microsoft Sans Serif", 14.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.registerRegisterButton.ForeColor = System.Drawing.SystemColors.ButtonFace;
            this.registerRegisterButton.Location = new System.Drawing.Point(106, 340);
            this.registerRegisterButton.Name = "registerRegisterButton";
            this.registerRegisterButton.Size = new System.Drawing.Size(163, 54);
            this.registerRegisterButton.TabIndex = 8;
            this.registerRegisterButton.Text = "Register";
            this.registerRegisterButton.UseVisualStyleBackColor = false;
            this.registerRegisterButton.Click += new System.EventHandler(this.registerRegisterButton_Click);
            // 
            // registerPassBox
            // 
            this.registerPassBox.Font = new System.Drawing.Font("Microsoft Sans Serif", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.registerPassBox.ForeColor = System.Drawing.Color.DarkGray;
            this.registerPassBox.Location = new System.Drawing.Point(82, 288);
            this.registerPassBox.Multiline = true;
            this.registerPassBox.Name = "registerPassBox";
            this.registerPassBox.Size = new System.Drawing.Size(230, 32);
            this.registerPassBox.TabIndex = 7;
            this.registerPassBox.Text = "Password:";
            this.registerPassBox.Enter += new System.EventHandler(this.registerPassBox_Enter);
            this.registerPassBox.Leave += new System.EventHandler(this.registerPassBox_Leave);
            // 
            // registerEmailBox
            // 
            this.registerEmailBox.Font = new System.Drawing.Font("Microsoft Sans Serif", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.registerEmailBox.ForeColor = System.Drawing.Color.DarkGray;
            this.registerEmailBox.Location = new System.Drawing.Point(82, 207);
            this.registerEmailBox.Multiline = true;
            this.registerEmailBox.Name = "registerEmailBox";
            this.registerEmailBox.Size = new System.Drawing.Size(230, 32);
            this.registerEmailBox.TabIndex = 6;
            this.registerEmailBox.Text = "Email:";
            this.registerEmailBox.Enter += new System.EventHandler(this.registerEmailBox_Enter);
            this.registerEmailBox.Leave += new System.EventHandler(this.registerEmailBox_Leave);
            // 
            // registerPhoneBox
            // 
            this.registerPhoneBox.Font = new System.Drawing.Font("Microsoft Sans Serif", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.registerPhoneBox.ForeColor = System.Drawing.Color.DarkGray;
            this.registerPhoneBox.Location = new System.Drawing.Point(82, 169);
            this.registerPhoneBox.Multiline = true;
            this.registerPhoneBox.Name = "registerPhoneBox";
            this.registerPhoneBox.Size = new System.Drawing.Size(230, 32);
            this.registerPhoneBox.TabIndex = 5;
            this.registerPhoneBox.Text = "Phone:";
            this.registerPhoneBox.Enter += new System.EventHandler(this.registerPhoneBox_Enter);
            this.registerPhoneBox.Leave += new System.EventHandler(this.registerPhoneBox_Leave);
            // 
            // registerIDBox
            // 
            this.registerIDBox.Font = new System.Drawing.Font("Microsoft Sans Serif", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.registerIDBox.ForeColor = System.Drawing.Color.DarkGray;
            this.registerIDBox.Location = new System.Drawing.Point(82, 131);
            this.registerIDBox.Multiline = true;
            this.registerIDBox.Name = "registerIDBox";
            this.registerIDBox.Size = new System.Drawing.Size(230, 32);
            this.registerIDBox.TabIndex = 4;
            this.registerIDBox.Text = "National ID:";
            this.registerIDBox.Enter += new System.EventHandler(this.registerIDBox_Enter);
            this.registerIDBox.Leave += new System.EventHandler(this.registerIDBox_Leave);
            // 
            // registerSurnameBox
            // 
            this.registerSurnameBox.Font = new System.Drawing.Font("Microsoft Sans Serif", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.registerSurnameBox.ForeColor = System.Drawing.Color.DarkGray;
            this.registerSurnameBox.Location = new System.Drawing.Point(82, 93);
            this.registerSurnameBox.Multiline = true;
            this.registerSurnameBox.Name = "registerSurnameBox";
            this.registerSurnameBox.Size = new System.Drawing.Size(230, 32);
            this.registerSurnameBox.TabIndex = 3;
            this.registerSurnameBox.Text = "Surname:";
            this.registerSurnameBox.Enter += new System.EventHandler(this.registerSurnameBox_Enter);
            this.registerSurnameBox.Leave += new System.EventHandler(this.registerSurnameBox_Leave);
            // 
            // registerNameBox
            // 
            this.registerNameBox.Font = new System.Drawing.Font("Microsoft Sans Serif", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.registerNameBox.ForeColor = System.Drawing.Color.DarkGray;
            this.registerNameBox.Location = new System.Drawing.Point(82, 55);
            this.registerNameBox.Multiline = true;
            this.registerNameBox.Name = "registerNameBox";
            this.registerNameBox.Size = new System.Drawing.Size(230, 32);
            this.registerNameBox.TabIndex = 2;
            this.registerNameBox.Text = "Name:";
            this.registerNameBox.Enter += new System.EventHandler(this.registerNameBox_Enter);
            this.registerNameBox.Leave += new System.EventHandler(this.registerNameBox_Leave);
            // 
            // forgotPanel
            // 
            this.forgotPanel.BackColor = System.Drawing.SystemColors.ControlLightLight;
            this.forgotPanel.Controls.Add(this.pictureBox3);
            this.forgotPanel.Controls.Add(this.forgotToLogin);
            this.forgotPanel.Controls.Add(this.forgotEmailBox);
            this.forgotPanel.Controls.Add(this.forgotIDBox);
            this.forgotPanel.Controls.Add(this.forgotSendButton);
            this.forgotPanel.Location = new System.Drawing.Point(31, 23);
            this.forgotPanel.Name = "forgotPanel";
            this.forgotPanel.Size = new System.Drawing.Size(639, 383);
            this.forgotPanel.TabIndex = 10;
            this.forgotPanel.Visible = false;
            // 
            // pictureBox3
            // 
            this.pictureBox3.Image = ((System.Drawing.Image)(resources.GetObject("pictureBox3.Image")));
            this.pictureBox3.Location = new System.Drawing.Point(349, 73);
            this.pictureBox3.Name = "pictureBox3";
            this.pictureBox3.Size = new System.Drawing.Size(265, 275);
            this.pictureBox3.SizeMode = System.Windows.Forms.PictureBoxSizeMode.Zoom;
            this.pictureBox3.TabIndex = 13;
            this.pictureBox3.TabStop = false;
            // 
            // forgotToLogin
            // 
            this.forgotToLogin.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.forgotToLogin.Location = new System.Drawing.Point(117, 310);
            this.forgotToLogin.Name = "forgotToLogin";
            this.forgotToLogin.Size = new System.Drawing.Size(142, 38);
            this.forgotToLogin.TabIndex = 12;
            this.forgotToLogin.Text = "Back to Login";
            this.forgotToLogin.UseVisualStyleBackColor = true;
            this.forgotToLogin.Click += new System.EventHandler(this.forgotToLogin_Click);
            // 
            // forgotEmailBox
            // 
            this.forgotEmailBox.Font = new System.Drawing.Font("Microsoft Sans Serif", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.forgotEmailBox.ForeColor = System.Drawing.Color.DarkGray;
            this.forgotEmailBox.Location = new System.Drawing.Point(82, 171);
            this.forgotEmailBox.Multiline = true;
            this.forgotEmailBox.Name = "forgotEmailBox";
            this.forgotEmailBox.Size = new System.Drawing.Size(230, 32);
            this.forgotEmailBox.TabIndex = 11;
            this.forgotEmailBox.Text = "Email:";
            this.forgotEmailBox.Enter += new System.EventHandler(this.forgotEmailBox_Enter);
            this.forgotEmailBox.Leave += new System.EventHandler(this.forgotEmailBox_Leave);
            // 
            // forgotIDBox
            // 
            this.forgotIDBox.Font = new System.Drawing.Font("Microsoft Sans Serif", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.forgotIDBox.ForeColor = System.Drawing.Color.DarkGray;
            this.forgotIDBox.Location = new System.Drawing.Point(82, 120);
            this.forgotIDBox.Multiline = true;
            this.forgotIDBox.Name = "forgotIDBox";
            this.forgotIDBox.Size = new System.Drawing.Size(230, 32);
            this.forgotIDBox.TabIndex = 10;
            this.forgotIDBox.Text = "National ID:";
            this.forgotIDBox.Enter += new System.EventHandler(this.forgotIDBox_Enter);
            this.forgotIDBox.Leave += new System.EventHandler(this.forgotIDBox_Leave);
            // 
            // forgotSendButton
            // 
            this.forgotSendButton.BackColor = System.Drawing.Color.Red;
            this.forgotSendButton.Font = new System.Drawing.Font("Microsoft Sans Serif", 14.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.forgotSendButton.ForeColor = System.Drawing.SystemColors.ButtonFace;
            this.forgotSendButton.Location = new System.Drawing.Point(78, 236);
            this.forgotSendButton.Name = "forgotSendButton";
            this.forgotSendButton.Size = new System.Drawing.Size(234, 44);
            this.forgotSendButton.TabIndex = 9;
            this.forgotSendButton.Text = "Send recovery email";
            this.forgotSendButton.UseVisualStyleBackColor = false;
            this.forgotSendButton.Click += new System.EventHandler(this.forgotSendButton_Click);
            // 
            // userPanel
            // 
            this.userPanel.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(255)))), ((int)(((byte)(192)))), ((int)(((byte)(192)))));
            this.userPanel.Controls.Add(this.userLogoutButton);
            this.userPanel.Controls.Add(this.SmsLabel);
            this.userPanel.Controls.Add(this.minutesLabel);
            this.userPanel.Controls.Add(this.label1);
            this.userPanel.Controls.Add(this.userSmsBar);
            this.userPanel.Controls.Add(this.userMinutesBar);
            this.userPanel.Controls.Add(this.userDataBar);
            this.userPanel.Controls.Add(this.pictureBox4);
            this.userPanel.Location = new System.Drawing.Point(0, 0);
            this.userPanel.Name = "userPanel";
            this.userPanel.Size = new System.Drawing.Size(726, 452);
            this.userPanel.TabIndex = 14;
            this.userPanel.Visible = false;
            // 
            // pictureBox4
            // 
            this.pictureBox4.BackColor = System.Drawing.Color.White;
            this.pictureBox4.Image = ((System.Drawing.Image)(resources.GetObject("pictureBox4.Image")));
            this.pictureBox4.Location = new System.Drawing.Point(409, 81);
            this.pictureBox4.Name = "pictureBox4";
            this.pictureBox4.Size = new System.Drawing.Size(297, 251);
            this.pictureBox4.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.pictureBox4.TabIndex = 0;
            this.pictureBox4.TabStop = false;
            // 
            // userDataBar
            // 
            this.userDataBar.Location = new System.Drawing.Point(94, 137);
            this.userDataBar.Name = "userDataBar";
            this.userDataBar.Size = new System.Drawing.Size(221, 23);
            this.userDataBar.TabIndex = 1;
            // 
            // userMinutesBar
            // 
            this.userMinutesBar.Location = new System.Drawing.Point(94, 197);
            this.userMinutesBar.Name = "userMinutesBar";
            this.userMinutesBar.Size = new System.Drawing.Size(221, 23);
            this.userMinutesBar.TabIndex = 2;
            // 
            // userSmsBar
            // 
            this.userSmsBar.Location = new System.Drawing.Point(94, 265);
            this.userSmsBar.Name = "userSmsBar";
            this.userSmsBar.Size = new System.Drawing.Size(221, 23);
            this.userSmsBar.TabIndex = 3;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Microsoft Sans Serif", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.Location = new System.Drawing.Point(89, 102);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(68, 25);
            this.label1.TabIndex = 4;
            this.label1.Text = "Data |";
            // 
            // minutesLabel
            // 
            this.minutesLabel.AutoSize = true;
            this.minutesLabel.Font = new System.Drawing.Font("Microsoft Sans Serif", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.minutesLabel.Location = new System.Drawing.Point(89, 169);
            this.minutesLabel.Name = "minutesLabel";
            this.minutesLabel.Size = new System.Drawing.Size(99, 25);
            this.minutesLabel.TabIndex = 5;
            this.minutesLabel.Text = "Minutes |";
            // 
            // SmsLabel
            // 
            this.SmsLabel.AutoSize = true;
            this.SmsLabel.Font = new System.Drawing.Font("Microsoft Sans Serif", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.SmsLabel.Location = new System.Drawing.Point(89, 238);
            this.SmsLabel.Name = "SmsLabel";
            this.SmsLabel.Size = new System.Drawing.Size(65, 25);
            this.SmsLabel.TabIndex = 6;
            this.SmsLabel.Text = "Sms |";
            // 
            // userLogoutButton
            // 
            this.userLogoutButton.BackColor = System.Drawing.Color.Red;
            this.userLogoutButton.Font = new System.Drawing.Font("Microsoft Sans Serif", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.userLogoutButton.ForeColor = System.Drawing.SystemColors.ControlLightLight;
            this.userLogoutButton.Location = new System.Drawing.Point(139, 333);
            this.userLogoutButton.Name = "userLogoutButton";
            this.userLogoutButton.Size = new System.Drawing.Size(121, 53);
            this.userLogoutButton.TabIndex = 7;
            this.userLogoutButton.Text = "Logout";
            this.userLogoutButton.UseVisualStyleBackColor = false;
            this.userLogoutButton.Click += new System.EventHandler(this.userLogoutButton_Click);
            // 
            // LoginPage
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.SystemColors.ControlLightLight;
            this.ClientSize = new System.Drawing.Size(718, 450);
            this.Controls.Add(this.userPanel);
            this.Controls.Add(this.forgotPanel);
            this.Controls.Add(this.loginPanel);
            this.Controls.Add(this.registerPanel);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.Fixed3D;
            this.MaximizeBox = false;
            this.MinimizeBox = false;
            this.Name = "LoginPage";
            this.Text = "DataDito Desktop App";
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).EndInit();
            this.loginPanel.ResumeLayout(false);
            this.loginPanel.PerformLayout();
            this.registerPanel.ResumeLayout(false);
            this.registerPanel.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox2)).EndInit();
            this.forgotPanel.ResumeLayout(false);
            this.forgotPanel.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox3)).EndInit();
            this.userPanel.ResumeLayout(false);
            this.userPanel.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox4)).EndInit();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.CheckBox loginRememberCheck;
        private System.Windows.Forms.TextBox loginPhoneBox;
        private System.Windows.Forms.Button loginForgotButton;
        private System.Windows.Forms.Button loginLoginButton;
        private System.Windows.Forms.Button loginRegButton;
        private System.Windows.Forms.TextBox loginPassBox;
        private System.Windows.Forms.PictureBox pictureBox1;
        private System.Windows.Forms.Panel loginPanel;
        private System.Windows.Forms.Panel registerPanel;
        private System.Windows.Forms.TextBox registerIDBox;
        private System.Windows.Forms.TextBox registerSurnameBox;
        private System.Windows.Forms.TextBox registerNameBox;
        private System.Windows.Forms.PictureBox pictureBox2;
        private System.Windows.Forms.Button registerRegisterButton;
        private System.Windows.Forms.TextBox registerPassBox;
        private System.Windows.Forms.TextBox registerEmailBox;
        private System.Windows.Forms.TextBox registerPhoneBox;
        private System.Windows.Forms.Panel forgotPanel;
        private System.Windows.Forms.TextBox forgotEmailBox;
        private System.Windows.Forms.TextBox forgotIDBox;
        private System.Windows.Forms.Button forgotSendButton;
        private System.Windows.Forms.Button forgotToLogin;
        private System.Windows.Forms.Button registerToLogin;
        private System.Windows.Forms.PictureBox pictureBox3;
        private System.Windows.Forms.ComboBox registerComboBox;
        private System.Windows.Forms.Panel userPanel;
        private System.Windows.Forms.PictureBox pictureBox4;
        private System.Windows.Forms.ProgressBar userDataBar;
        private System.Windows.Forms.ProgressBar userSmsBar;
        private System.Windows.Forms.ProgressBar userMinutesBar;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label SmsLabel;
        private System.Windows.Forms.Label minutesLabel;
        private System.Windows.Forms.Button userLogoutButton;
    }
}

