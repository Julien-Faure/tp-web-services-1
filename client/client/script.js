var currentDateTime = new Date();
var year = currentDateTime.getFullYear();
var month = (currentDateTime.getMonth() + 1);
var date = (currentDateTime.getDate() + 1);

if (date < 10) {
    date = '0' + date;
}
if (month < 10) {
    month = '0' + month;
}

var dateTomorrow = year + "-" + month + "-" + date;
var checkinElem = document.querySelector("#checkin-date");
var checkoutElem = document.querySelector("#checkout-date");

checkinElem.setAttribute("min", dateTomorrow);

checkinElem.onchange = function () {
    checkoutElem.setAttribute("min", this.value);
}

window.addEventListener("load", function () {
    function sendData() {
        var xhr = new XMLHttpRequest();
        var dateDebut = document.getElementById("checkin-date");
        var dateFin = document.getElementById("checkout-date");
        xhr.addEventListener("load", function (event) {
            console.log(event.target.responseText);
        });

        xhr.addEventListener("error", function (event) {
            alert('Oups! Quelque chose s\'est mal passé.');
        });
        var param = "?checkInDate=" + dateDebut + "&checkOutDate" + dateFin;
        xhr.open("GET", "https://example.com/cors" + param + "", true);

        xhr.send(null);
    }

    var form = document.getElementById("reservation");


    form.addEventListener("submit", function (event) {
        event.preventDefault();
        sendData();
    });
});