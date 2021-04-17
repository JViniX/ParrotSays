var arrItems;

function loadJson()
{
    var client = new XMLHttpRequest();
    client.open("get", "http://localhost:8167/api/reports/getall", true);

    // setting the headers with the token.
    client.setRequestHeader('Content-Type', 'application/json');
    client.setRequestHeader('Authorization', 'Bearer '+sessionStorage.getItem('token'));
    
    client.send();
    client.onreadystatechange = function(){
        if(client.readyState === 4){
            if(client.status === 200)
            {
                arrItems = JSON.parse(client.responseText);
                showTheList();
            }
            else{
                alert("An error occurred during your request: Error "+ client.status+" - "+client.statusText);
            }
        }
    }
}


function showTheList()
{ 
    var tableBody = document.getElementById("reportList");   

    // Loop through data in the JSON array.
    for (var i = 0; i < arrItems.length; i++) {
        var report =  arrItems[i];
        var line = 
                "<td>"+ report.reportId +"</td>"+
                "<td>"+ report.description +"</td>"+
                "<td>"+ report.latitude +"</td>"+
                "<td>"+ report.longitude +"</td>"+
                "<td>"+ new Date(report.dateTimeReport).toString().substring(0,21) +"</td>"+
                "<td>"+ report.statusCode +"</td>"+
                "<td>"+
                    "<a href='reportdetails.html?reportId="+ report.reportId +"'><i class='fa fa-edit text-body'></i></a> | "+
                    "<a href='#' onclick=deleteItem("+ report.reportId +")><i class='fa fa-trash text-body'></i></a>"+
				"</td>";
        var tr = document.createElement("tr");
        tr.innerHTML = line;        
        tableBody.appendChild(tr);

        
    }
}

function deleteItem(reportId)
{
    console.log("=======> delete report "+reportId);
    if (confirm("Are you sure you want to remove this report?")) {
        console.log("You pressed OK!");

        var client = new XMLHttpRequest();
        client.open("delete", "http://localhost:8167/api/reports/delreport/"+reportId, true);
    
        // setting the headers with the token.
        client.setRequestHeader('Content-Type', 'application/json');
        client.setRequestHeader('Authorization', 'Bearer '+sessionStorage.getItem('token'));
        
        client.send();
        client.onreadystatechange = function(){
            if(client.readyState === 4){
                if(client.status === 200)
                {
                    location.reload();
                }
                else{
                    alert("An error occurred during your request: Error "+ client.status+" - "+client.statusText);
                }
            }
        }
    } else {
        console.log("You pressed Cancel!");
    } 
}

loadJson();