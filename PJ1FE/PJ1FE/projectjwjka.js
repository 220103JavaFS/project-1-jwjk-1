//DOM Selector
let ReimbursmentAmount = document.getElementById("reimb_amoutn");
let ReimbursmentDescription = document.getElementById("reimb_decription");

let button = document.addEventListener ("submit");
button.addEventListener("click", ajaxFunc);
    console.log('click');

    function ajaxFunc(){

        let xhr = new XMLHttpRequest();
    
        xhr.onreadystatechange = function(){
    
            xhr.open("projectjwjk");
        }
    }