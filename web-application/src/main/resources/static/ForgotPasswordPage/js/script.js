document.getElementById("forgot-password-form").addEventListener("submit", async function (event) {
    event.preventDefault();

    const nid = document.getElementById("nid").value;
    const email = document.getElementById("email").value;

    try {
        const response = await fetch("/api", {
            method: "POST",
            headers: {
                'Content-Type': 'application/json',
                'Accept': 'application/json',
            },
            body : JSON.stringify({
                nid : nid,
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