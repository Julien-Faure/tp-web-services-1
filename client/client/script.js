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

let TOKEN = undefined;

var keycloak = new Keycloak({
    url: 'http://localhost:8080/auth',
    realm: 'infres',
    clientId: 'api-token-provider'
});
keycloak.init({onLoad: 'login-required'}).then(function (authenticated) {
    console.log("TOKEN : " + keycloak.token);
    TOKEN = keycloak.token;
}).catch(function (e) {
    console.error(e)
    alert('failed to initialize : ' + e);
});

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
        xhr.open("GET", "http://127.0.0.1:8082/rest-api/api/availability/all", true);
        xhr.setRequestHeader("Content-type", "application/json");
        xhr.setRequestHeader("Authorization", "Bearer " + TOKEN)
        xhr.send({});
    }

    var form = document.getElementById("reservation");


    form.addEventListener("submit", function (event) {
        event.preventDefault();
        getAvailability();
    });
});

function onSignIn(googleUser) {
    var profile = googleUser.getBasicProfile();
    console.log('ID: ' + profile.getId()); // Do not send to your backend! Use an ID token instead.
    console.log('Name: ' + profile.getName());
    console.log('Image URL: ' + profile.getImageUrl());
    console.log('Email: ' + profile.getEmail()); // This is null if the 'email' scope is not present.
    var id_token = googleUser.getAuthResponse().id_token;
    var xhr = new XMLHttpRequest();
    xhr.open('POST', 'http://localhost:8080/rest-api/api/tokensignin');
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xhr.onload = function() {
        console.log('Signed in as: ' + xhr.responseText);
    };
    xhr.send('idtoken=' + id_token);
}