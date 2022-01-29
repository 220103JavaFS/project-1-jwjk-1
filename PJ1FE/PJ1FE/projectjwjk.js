//DOM Selection
let Username = document.getElementById("username");
let Password = document.getElementById("passwords");

let button = document.getElementById("Login")
button.addEventListener("click", ajaxFunc);
    console.log('clicked');

function ajaxFunc(){

    let xhr = new XMLHttpRequest();

    xhr.onreadystatechange = function(){

        xhr.open("projectjwjka");
    }
}
