var form = document.querySelector('#signup-form');

form.addEventListener('submit', sendRequest);

function sendRequest(event) 
{

    // disable default action
    event.preventDefault();

    // configure a request
    var xhr = new XMLHttpRequest();
    xhr.open('POST', 'http://localhost:8167/api/users/login');
    
    // set headers
    xhr.setRequestHeader('Content-Type', 'application/json');
    // xhr.setRequestHeader('X-Requested-With', 'XMLHttpRequest');

    // prepare form data
    var data = JSON.stringify(
        {
            username : form.elements[0].value,
            password : form.elements[1].value
        }
    );

    // send request
    xhr.send(data);

    // listen state event
    xhr.onreadystatechange = function(){
        if(xhr.readyState === 4){
            if(xhr.status === 200)
            {
                var result = JSON.parse(xhr.responseText);
                console.log(result);
                
                sessionStorage.setItem("token", result.token);
                sessionStorage.setItem("message", "Welcome to Parrot Says!")
                
                form.submit();
            }
            else{
                alert("An error occurred during your request: Error "+ xhr.status+" - "+xhr.statusText);                
                sessionStorage.setItem("error", "Please, try again!")
            }
        }
    }
    
};