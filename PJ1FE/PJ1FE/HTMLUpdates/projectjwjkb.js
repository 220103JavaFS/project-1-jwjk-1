//DOM Selector

let button = document.getElementById("Accepted");
let button = document.getElementById("Denied");
let button = document.getElementById("logout");

button.addEventListener('click', ajaxFunc);
    console.log(Accepted);


button.addEventListener('click', ajaxFunc);
    console.log(Denied);

button.addEventListener('click', ajaxFunc);
    console.log(Logout);

    function ajaxFunc(){

        let xhr = new XMLHttpRequest();
    
        xhr.onreadystatechange = function(){
    
            xhr.open("projectjwjk");
        }
    }