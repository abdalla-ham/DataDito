document.getElementById('loginButton').addEventListener('click', function () {
    let phone = document.getElementById('phone').value;
    const password = document.getElementById('password').value;
    phone = '90' + phone;

    /*fetch('api', {
        method: 'POST',
        headers: {
            "Content-Type": "application/json",
            "Accept": "application/json",
        },
        body: JSON.stringify({
            phone: phone,
            password: password,
        })
    }).then(response => {
        if (response.ok) {
            localStorage.removeItem('phone');
            localStorage.setItem('phone', phone);
            window.location.href = '../../UserInformationPage/index.html';
        }
        else{
            console.log("data");
            alert(response.message);
        }
    }).catch(error => {
        console.error(error);
        alert(error);
    })*/

});