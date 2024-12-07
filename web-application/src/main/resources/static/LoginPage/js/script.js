document.addEventListener("DOMContentLoaded", function () {
    const savedPhone = localStorage.getItem("savedPhone");
    const savedPassword = localStorage.getItem("savedPassword");

    if (savedPhone && savedPassword) {
        autoLogin(savedPhone, savedPassword);
    }
});

async function autoLogin(phone, password) {
    try {
        const response = await fetch("/api", {
            method: "POST",
            headers: {
                'Content-Type': 'application/json',
                'Accept': 'application/json',
            },
            body: JSON.stringify({
                phone: phone,
                password: password,
            }),
        });

        if (response.ok) {
            window.location.replace("http://localhost:8080/UserInformationPage/index.html");
        } else {
            alert("Invalid saved credentials. Please log in manually.");
            localStorage.removeItem("savedPhone");
            localStorage.removeItem("savedPassword");
        }
    } catch (error) {
        console.error("Error during auto-login:", error);
        alert("Auto-login failed. Please try logging in manually.");
    }
}

document.getElementById("login-form").addEventListener("submit", async function (event) {
    event.preventDefault();

    let phone = document.getElementById('phone').value;
    phone = '90' + phone;
    const password = document.getElementById('password').value;
    const rememberMe = document.getElementById('rememberMe').checked;

    console.log("Phone:", phone);
    console.log("Password:", password);

    try {
        const response = await fetch("/api", {
            method: "POST",
            headers: {
                'Content-Type': 'application/json',
                'Accept': 'application/json',
            },
            body: JSON.stringify({
                phone: phone,
                password: password,
            }),
        });

        if (response.ok) {
            if (rememberMe) {
                localStorage.setItem("savedPhone", phone);
                localStorage.setItem("savedPassword", password);
            } else {
                localStorage.removeItem("savedPhone");
                localStorage.removeItem("savedPassword");
            }

            window.location.replace("http://localhost:8080/UserInformationPage/index.html");
        } else {
            alert("Invalid credentials. Please try again.");
        }
    } catch (error) {
        alert("Something went wrong!");
        console.error("Error occurred! Message:", error);
    }
});
