document.addEventListener("DOMContentLoaded", function () {
    const msisdn = "1234";
    console.log(`MSISDN: ${msisdn}`);

    // Progress bar elements
    const dataUsageBar = document.getElementById("data-bar");
    const minutesUsageBar = document.getElementById("minutes-bar");
    const smsUsageBar = document.getElementById("sms-bar");

    // Text elements
    const dataUsageText = document.getElementById("data-usage-text");
    const minutesUsageText = document.getElementById("minutes-usage-text");
    const smsUsageText = document.getElementById("sms-usage-text");

    let totalData, totalMinutes, totalSMS; // To be updated dynamically

    // Fetch user's package details
    fetch(`http://34.56.3.235:8080/v1/api/package/getPackage?accountId=1&msisdn=${msisdn}`)
        .then((response) => response.json())
        .then((packageData) => {
            totalData = packageData.totalData; // Example: 100 GB
            totalMinutes = packageData.totalMinutes; // Example: 1000 Minutes
            totalSMS = packageData.totalSms; // Example: 250 SMS

            // Fetch user's remaining balance using the fetched package data
            return fetch(`http://34.56.3.235:8080/v1/api/balance/remainingBalance?accountId=1&msisdn=${msisdn}`);
        })
        .then((response) => response.json())
        .then((balanceData) => {
            const usedData = totalData - balanceData.balanceData;
            const usedMinutes = totalMinutes - balanceData.balanceMinutes;
            const usedSMS = totalSMS - balanceData.balanceSms;

            // Update bars and text
            updateDataUsage(usedData);
            updateMinutesUsage(usedMinutes);
            updateSMSUsage(usedSMS);
        })
        .catch((error) => {
            console.error("Error fetching user data:", error);
        });

    // Function to update the data usage bar and text
    function updateDataUsage(used) {
        const percentage = ((used / totalData) * 100).toFixed(1);
        dataUsageBar.style.width = `${percentage}%`;
        dataUsageText.textContent = `Used ${used} GB / ${totalData} GB`;
    }

    // Function to update the minutes usage bar and text
    function updateMinutesUsage(used) {
        const percentage = ((used / totalMinutes) * 100).toFixed(1);
        minutesUsageBar.style.width = `${percentage}%`;
        minutesUsageText.textContent = `Used ${used} Minutes / ${totalMinutes} Minutes`;
    }

    // Function to update the SMS usage bar and text
    function updateSMSUsage(used) {
        const percentage = ((used / totalSMS) * 100).toFixed(1);
        smsUsageBar.style.width = `${percentage}%`;
        smsUsageText.textContent = `Used ${used} SMS / ${totalSMS} SMS`;
    }
});
