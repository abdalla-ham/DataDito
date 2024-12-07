document.addEventListener("DOMContentLoaded", function () {
    const packageSelect = document.getElementById("package");

    fetch("/api")
        .then(response => {
            if (!response.ok) {
                throw new Error("Failed to fetch package options.");
            }
            return response.json();
        })
        .then(data => {
            if (data.length === 0) {
                const noOption = document.createElement("option");
                noOption.textContent = "No packages available";
                noOption.disabled = true;
                packageSelect.appendChild(noOption);
                packageSelect.disabled = true;
            } else {
                data.forEach(pkg => {
                    const option = document.createElement("option");
                    option.value = pkg.packageName;
                    option.textContent = `${pkg.packageName} - ${pkg.amountMinutes} min - ${pkg.price} $ - ${pkg.amountData} MB - ${pkg.amountSms} SMS - ${pkg.period} period`;
                    packageSelect.appendChild(option);
                });
            }
        })
        .catch(error => {
            console.error("Error fetching packages:", error);
            alert("Failed to load packages. Please try again later.");
        });

    // Handle form submission
    document.getElementById("registerForm").addEventListener("submit", function (event) {
        event.preventDefault();

        // Collect form data
        const name = document.getElementById("name").value.trim();
        const surname = document.getElementById("surname").value.trim();
        const nid = document.getElementById("nid").value.trim();
        let phone = document.getElementById("phone").value.trim();
        const email = document.getElementById("email").value.trim();
        const password = document.getElementById("password").value.trim();
        const packageName = packageSelect.value;

        if (!phone.startsWith("90")) {
            phone = "90" + phone;
        }

        console.log(name, surname, nid, phone, email, packageName);

        // Send registration request
        fetch("/api", {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
                "Accept": "application/json",
            },
            body: JSON.stringify({
                name: name,
                surname: surname,
                phone: phone,
                email: email,
                password: password,
                nid: nid,
                package: packageName,
            }),
        })
            .then(response => {
                if (!response.ok) {
                    throw new Error("Failed to submit registration.");
                }
                return response.json();
            })
            .then(data => {
                if (data.status === 200) {
                    alert("Registration successful");
                    window.location.replace("http://localhost:8080/LoginPage/index.html");
                } else {
                    alert(data.message || "Registration failed, please try again later.");
                }
            })
            .catch(error => {
                console.error("Error:", error);
                alert("Something went wrong. Please try again later.");
            });
    });
});
