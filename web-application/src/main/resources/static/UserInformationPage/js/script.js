document.addEventListener("DOMContentLoaded", function () {
    const dataUsageBar = document.getElementById("data-bar");
    const minutesUsageBar = document.getElementById("minutes-bar");
    const smsUsageBar = document.getElementById("sms-bar");

    const dataUsageText = document.getElementById("data-usage-text");
    const minutesUsageText = document.getElementById("minutes-usage-text");
    const smsUsageText = document.getElementById("sms-usage-text");

    let usedData = 0;
    let usedMinutes = 0;
    let usedSMS = 0;

    const totalData = 100;
    const totalMinutes = 1000;
    const totalSMS = 250;

    function updateDataUsage(used) {
        const percentage = (used / totalData) * 100
        dataUsageBar.style.width = `${percentage}%`;
        dataUsageText.textContent = `Used ${usedData} GB / ${totalData} GB`
    }

    function updateMinutesUsage(used) {
        const percentage = (used / totalMinutes) * 100
        minutesUsageBar.style.width = `${percentage}%`;
        minutesUsageText.textContent = `Used ${usedMinutes} Minutes / ${totalMinutes} Minutes`
    }

    function updateSMSUsage(used) {
        const percentage = (used / totalSMS) * 100
        smsUsageBar.style.width = `${percentage}%`;
        smsUsageText.textContent = `Used ${usedSMS} SMS / ${totalSMS} SMS`
    }

    // Simulation code, unnecessary, testing purposes

    const dataUsageSimulation = setInterval(() => {
        if (usedData < totalData) {
            usedData += 5;
            updateDataUsage(usedData)
        } else {
            clearInterval(dataUsageSimulation);
        }
    }, 1000)

    const minutesUsageSimulation = setInterval(() => {
        if (usedMinutes < totalMinutes) {
            usedMinutes += 20;
            updateMinutesUsage(usedMinutes)
        } else {
            clearInterval(minutesUsageSimulation);
        }
    }, 1000)

    const smsUsageSimulation = setInterval(() => {
        if (usedSMS < totalSMS) {
            usedSMS += 1;
            updateSMSUsage(usedSMS)
        } else {
            clearInterval(smsUsageSimulation);
        }
    }, 1000)

})