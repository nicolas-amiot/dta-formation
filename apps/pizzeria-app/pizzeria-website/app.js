$(document).ready(function() {
    $.ajax({ 
        type: "GET",
        dataType: "json",
        url: "http://localhost:8080/pizzeria-admin-app/api/rest/pizzas",
        success: function(data){
            data = data.sort(function(a, b) {
                var attr = "categorie";
                return (a[attr] > b[attr]) ? 1 : ((a[attr] < b[attr]) ? -1 : 0);
            });
            var lines = data.map(function(pizza) {
                return '<tr>'
                +'<td>'+pizza.code+'</td>'+
                '<td>'+pizza.nom+'</td>'+
                '<td>'+pizza.prix.toFixed(2)+'</td>'+
                '<td>'+pizza.categorie+'</td>'+
                '<td><img src="'+pizza.url+'" height="100" width="100px" /></td>'+
                '</tr>';
            });
            $('tbody').append(lines);
        }
    });
});