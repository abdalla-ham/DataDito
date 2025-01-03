document.addEventListener("DOMContentLoaded", function () {

    const savedMsisdn = localStorage.getItem("savedMsisdn");
    const savedPassword = localStorage.getItem("savedPassword");

    if (savedMsisdn && savedPassword) {
        autoLogin(savedMsisdn, savedPassword);
    }
});

async function autoLogin(msisdn, password) {
    try {
        const response = await fetch("http://34.56.3.235:8080/v1/api/auth/login", {
            method: "POST",
            headers: {
                'Content-Type': 'application/json',
            },
            credentials: 'include',
            body: JSON.stringify({
                msisdn: msisdn,
                password: password,
            }),
        });

        if (response.ok) {
            window.location.replace("http://localhost:8080/UserInformationPage/index.html");
        } else {
            alert("Invalid saved credentials. Please log in manually.");
            localStorage.removeItem("savedMsisdn");
            localStorage.removeItem("savedPassword");
        }
    } catch (error) {
        console.error("Error during auto-login:", error);
        alert("Auto-login failed. Please try logging in manually.");
    }
}

document.getElementById("login-form").addEventListener("submit", async function (event) {
    event.preventDefault();

    let msisdn = document.getElementById('msisdn').value;
    msisdn = '90' + msisdn;
    const password = document.getElementById('password').value;
    const rememberMe = document.getElementById('rememberMe').checked;

    console.log("Msisdn:", msisdn);
    console.log("Password:", password);

    try {
        const response = await fetch("http://34.56.3.235:8080/v1/api/auth/login", {
            method: "POST",
            headers: {
                'Content-Type': 'application/json',
            },
            credentials: "include",
            body: JSON.stringify({
                msisdn: msisdn,
                password: password,
            }),
        });

        if (response.ok) {
            if (rememberMe) {
                localStorage.setItem("savedMsisdn", msisdn);
                localStorage.setItem("savedPassword", password);
            } else {
                localStorage.removeItem("savedMsisdn");
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
