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
    function createTable(jsonData) {
        $(document).ready(function () {
                $('#roomTable').DataTable({
                    "searching": false,
                    "info": false,
                    "paging": false,
                    "data": jsonData.roomList,
                    "columns": [
                        {"title": "Id", "data": "id"},
                        {"title": "Prix", "data": "price"},
                        {"title": "Type", "data": "roomType"},
                        {
                            "title": "Date de départ", "data": "startDate", "render": function (data) {
                                var date = new Date(data)
                                return date.toLocaleString();
                            }
                        },
                        {
                            "title": "Date d'arrivée", "data": "endDate", "render": function (data) {
                                var date = new Date(data)
                                return date.toLocaleString();
                            }
                        },

                    ]
                });
                $('#flightsTable').DataTable({
                    "searching": false,
                    "info": false,
                    "paging": false,
                    "data": jsonData.flightList,
                    "columns": [
                        {"title": "N° vol", "data": "id"},
                        {"title": "Lieu de départ", "data": "departureLocation"},
                        {"title": "Lieu d'arrivé", "data": "arrivalLocation"},
                        {
                            "title": "Date de départ", "data": "departureDate", "render": function (data) {
                                var date = new Date(data)
                                return date.toLocaleString();
                            }
                        },

                        {
                            "title": "Date d'arrivée", "data": "arrivalDate", "render": function (data) {
                                var date = new Date(data)
                                return date.toLocaleString();
                            }
                        },


                    ]
                });
            }
        );
    }

    function getAvailability() {
        var xhr = new XMLHttpRequest();
        var dateDebut = document.getElementById("checkin-date").value;
        var dateFin = document.getElementById("checkout-date").value;
        xhr.addEventListener("load", function (event) {
              var jsonData = JSON.parse(event.target.responseText);
            /*var jsonData = {
                "flightList": [
                    {
                        "id": 12,
                        "departureLocation": "Nîmes",
                        "arrivalLocation": "Paris",
                        "departureDate": 1613121780000,
                        "arrivalDate": 1613128980000
                    },
                    {
                        "id": 13,
                        "departureLocation": "Nîmes",
                        "arrivalLocation": "Lyon",
                        "departureDate": 1613121790000,
                        "arrivalDate": 1613128992000
                    }
                ],
                "roomList": [
                    {
                        "id": 12,
                        "type": "basic",
                        "price": 100,
                        "departureDate": 1613121780000,
                        "arrivalDate": 1613128980000
                    }
                ]
            };*/
            createTable(jsonData);
        });
        xhr.addEventListener("error", function (event) {
            alert('Erreur lors de la requête API.');
        });
        // var param = "?checkInDate=" + dateDebut + "&checkOutDate" + dateFin;
        // xhr.open("GET", "https://example.com/cors" + param + "", true);
        xhr.open("GET", "http://localhost:8080/rest-api/api/availability/all", true);
        xhr.setRequestHeader("Content-type", "application/json");
        xhr.send(null);
    }

    var form = document.getElementById("reservation");


    form.addEventListener("submit", function (event) {
        event.preventDefault();
        getAvailability();
    });
})
;