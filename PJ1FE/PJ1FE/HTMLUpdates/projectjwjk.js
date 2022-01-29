//DOM Selection
let Username = document.getElementById("username");
let Password = document.getElementById("passwords");
let Logout = document.getElementById("logout");
let button = document.getElementById("Login");

button.addEventListener("click", ajaxFunc);
    console.log('login');
button.addEventListener("click", ajaxFunc);
    console.log('logged out!')

function ajaxFunc(){

    let xhr = new XMLHttpRequest();

    xhr.onreadystatechange = function(){

        xhr.open("projectjwjka");
    }
}
