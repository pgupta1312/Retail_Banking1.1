var app = angular.module('app', []);

app.controller('homeCtrl', function($scope, $filter) {

  var foo = {
    "results": [{
      "id": 1,
      "account_number": "1200001",
      "balance": "50000.00",
      "total_credit": "40000.00",
      "total_debit": "20000.00",

      "transactions" :[
      {
      "Date": "15-08-2018",
      "Transaction Id": "100500001",
      "Type": "Credit",
      "Amount":"5000.00"},

      {
      "Date": "13-08-2018",
      "Transaction Id": "100500002",
      "Type": "Credit",
      "Amount":"3000.00"},

      {
      "Date": "03-08-2018",
      "Transaction Id": "100500003",
      "Type": "Debit",
      "Amount":"4000.00"}

      ]}, 

      {
      "id": 2,
      "account_number": "1200002",
      "balance": "47000.00",
      "total_credit": "30000.00",
      "total_debit": "30000.00",
       "transactions" :[
      {
      "Date": "15-08-2018",
      "Transaction Id": "100400001",
      "Type": "Credit",
      "Amount":"5000.00"},

      {
      "Date": "13-08-2018",
      "Transaction Id": "100400002",
      "Type": "Credit",
      "Amount":"3000.00"},

      {
      "Date": "03-08-2018",
      "Transaction Id": "100400003",
      "Type": "Debit",
      "Amount":"4000.00"}

      ]},
      
      {
      "id": 3,
      "account_number": "1200003",
      "balance": "62000.00",
      "total_credit": "50000.00",
      "total_debit": "20000.00",
       "transactions" :[
      {
      "Date": "15-08-2018",
      "Transaction Id": "100800001",
      "Type": "Credit",
      "Amount":"6500.00"},

      {
      "Date": "13-08-2018",
      "Transaction Id": "100800002",
      "Type": "Credit",
      "Amount":"3700.00"},

      {
      "Date": "03-08-2018",
      "Transaction Id": "100800003",
      "Type": "Debit",
      "Amount":"4300.00"}

      ]
    }]
  };

  var result = $filter('filter')(foo.results, {id:Math.floor(3*Math.random()+1)})[0];

  // $scope.account_number = parseFloat(result["account_number"]);
  // $scope.balance = parseFloat(result["balance"]);
  // $scope.credit = parseFloat(result["total_credit"]);
  // $scope.debit = parseFloat(result["total_debit"]);

  $scope.account_number = result.account_number;
  $scope.balance = result.balance;
  $scope.credit = result.total_credit;
  $scope.debit = result.total_debit;

  
        var myBooks = [];
        for(var j = 0; j < result.transactions.length; j++) {
            myBooks.push(result.transactions[j]);
        }

        var $table = $('#table');

        $(function () {
    $('#table').bootstrapTable({
        data: myBooks
    });
});
        //console.log(myBooks)

        // EXTRACT VALUE FOR HTML HEADER. 
        // ('Book ID', 'Book Name', 'Category' and 'Price')
        // var col = [];
        // for (var i = 0; i < myBooks.length; i++) {
        //     for (var key in myBooks[i]) {
        //         if (col.indexOf(key) === -1) {
        //             col.push(key);
        //         }
        //     }
        // }

        // // CREATE DYNAMIC TABLE.
        // var table = document.createElement("table");

        // // CREATE HTML TABLE HEADER ROW USING THE EXTRACTED HEADERS ABOVE.

        // var tr = table.insertRow(-1);                   // TABLE ROW.

        // for (var i = 0; i < col.length; i++) {
        //     var th = document.createElement("th");      // TABLE HEADER.
        //     th.innerHTML = col[i];
        //     tr.appendChild(th);
        // }

        // // ADD JSON DATA TO THE TABLE AS ROWS.
        // for (var i = 0; i < myBooks.length; i++) {

        //     tr = table.insertRow(-1);

        //     for (var j = 0; j < col.length; j++) {
        //         var tabCell = tr.insertCell(-1);
        //         tabCell.innerHTML = myBooks[i][col[j]];
        //     }
        // }

        // // FINALLY ADD THE NEWLY CREATED TABLE WITH JSON DATA TO A CONTAINER.
        // var divContainer = document.getElementById("showData");
        // divContainer.innerHTML = "";
        // divContainer.appendChild(table);


google.charts.load('current', {'packages':['corechart']});
google.charts.setOnLoadCallback(drawChart);

// Draw the chart and set the chart values
function drawChart() {
  console.log(result["account_number"]);
  console.log(result["total_credit"]);
  console.log(result["total_debit"]);
  var data = google.visualization.arrayToDataTable([
  ['Type', 'Amount'],
  ['Cr', parseFloat(result["total_credit"])],
  ['Dr', parseFloat(result["total_debit"])]
]);

  // Optional; add a title and set the width and height of the chart
  var options = {'title':'Net Value', 'width':280, 'height':200};

  // Display the chart inside the <div> element with id="piechart"
  var chart = new google.visualization.PieChart(document.getElementById('piechart'));
  chart.draw(data, options);
}


});
