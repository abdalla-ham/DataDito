document.getElementById("forgot-password-form").addEventListener("submit", async function (event) {
    event.preventDefault();

    const tcNumber = document.getElementById("tcNumber").value;
    const email = document.getElementById("email").value;

    try {
        const response = await fetch("/http://34.56.3.235:8080/v1/api/forgetPassword/reset", {
            method: "POST",
            headers: {
                'Content-Type': 'application/json',
                'Accept': 'application/json',
            },
            body : JSON.stringify({
                tcNumber : tcNumber,
                email : email,
            })
        })

        if (response.ok) {
            alert("Password reset successfully. Check your inbox.");
            window.location.replace("http://localhost:8080/LoginPage/index.html");
        }

        else {
            alert("Invalid credentials. Please try again.");
        }


    } catch (error) {
        alert("Something went wrong!");
        console.log("Error occured! Message : ", error);
    }

})