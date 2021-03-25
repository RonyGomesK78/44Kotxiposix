/*var customerData = [
    {"id":1,"firstName":"Rui","lastName":"Ferrão","email":"rui@gmail.com","phone":"777888"},
    {"id":2,"firstName":"Sergio","lastName":"Gouveia","email":"sergio@gmail.com","phone":"777999"},
    {"id":3,"firstName":"Bruno","lastName":"Ferreira","email":"bruno@gmail.com","phone":"777666"},
    {"id":4,"firstName":"Rodolfo","lastName":"Matos","email":"rodolfo@gmail.com","phone":"777333"}
];*/


let ajax;


if(window.XMLHttpRequest){
    ajax = new XMLHttpRequest();

}else if(window.ActiveXObject){
    ajax = new ActiveXObject("Microsoft.XMLHTTP");
}



var populateTable = function(){
    
    var customerTable = document.getElementById("customer-table");

    var object = JSON.parse(ajax.responseText);
    object.forEach(function(element){
        
        var newRow = customerTable.insertRow(-1);

        newRow.innerHTML = "<td>" + element.firstName + "</td>";
        newRow.innerHTML += "<td>" + element.lastName + "</td>";
        newRow.innerHTML += "<td>" + element.email + "</td>";
        newRow.innerHTML += "<td>" + element.phone + "</td>";
        newRow.innerHTML += "<td> <a class= 'btn btn-warning'>Edit</a> </td>";
        newRow.innerHTML += "<td> <a class= 'btn btn-danger'>Delete</a> </td>";
        
    });

}

ajax.open('GET', 'http://localhost:8080/javabank5/api/customer', true);
ajax.send();

window.onload = populateTable;