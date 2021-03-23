var API_URL = 'http://localhost:8080/javabank5/api/customer';

$(document).ready(fetchCustomers);

function fetchCustomers(){

    $.ajax({
        url : API_URL,
        async : true,
        success: populateCustomers,
        error: errorMessage
        
    });

}

function errorMessage(){
    console.log("shit");
}

function populateCustomers(customerData) {

    var elementStr;
    var customersTable = $("#customer-table");

    customerData.forEach(function(element) {
        elementStr =
            "<tr>" +
            "<td>" +
            element.firstName +
            "</td>" +

            "<td>" +
            element.lastName +
            "</td>" +

            "<td>" +
            element.email +
            "</td>" +

            "<td>" +
            element.phone +
            "</td>" +

            '<td><button type="button" id="edit-btn-' +
            element.id +
            '" class="edit-btn btn btn-success">edit</button></td>' +
            '<td><button type="button" id="remove-btn-' +
            element.id +
            '" class="remove-btn btn btn-danger">delete</button></td>' +
            "</tr>";

        //row = customersTable.insertRow(-1);
        customersTable.append(elementStr);
        //row.innerHTML = elementStr;

        //row.setAttribute("id", "customer-" + element.id);
        //row.setAttribute("class", "customer-data");
    });
}
