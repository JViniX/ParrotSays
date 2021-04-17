var frame = document.getElementById("mainFrame");

var divMessage = document.getElementById("sessionMessage");
var pMessage = document.createElement("p");

var messageSuccess = sessionStorage.getItem("message");
var messageError = sessionStorage.getItem("error");

if (messageSuccess !== null)
{		   
    pMessage.innerHTML = "<strong>Success!</strong> "+ messageSuccess;
    divMessage.className  = "alert alert-success";
    divMessage.appendChild(pMessage);

    sessionStorage.removeItem("message");
}
else if(messageError !== null)
{
    pMessage.innerHTML = "<strong>Error!</strong> "+ messageError;
    divMessage.className  = "alert alert-danger";
    divMessage.appendChild(pMessage);

    sessionStorage.removeItem("error");
}

function loadAbout()
{
    frame.src = "about.html";
}
function loadLogin()
{
    frame.src = "login.html";
}
function loadReportList()
{
    frame.src = "reportlist.html";
}