let username = document.getElementById("username");
let password = document.getElementById("password");
let loginBtn = document.getElementById("loginBtn");
let login_div = document.getElementById("loginDiv");

const url = "http://localhost:8080/"

if (sessionStorage.getItem("userSession") != null){
    login_div.style.display = 'block';
}  

loginBtn.addEventListener("click", loginFunc);

async function loginFunc(){
    let user = {
        userName: username.value,
        password: password.value
    }

    console.log("Username: "+ user.userName +  "   Password: " +  user.password);

    let response = await fetch(
        url+"login",
        {
          method : "POST",
          body : JSON.stringify(user),
          credentials: "include"
        }
      );
    
      if(response.status===200){
        login_div.style.display = 'none';
        if (username.value == "PWhite") {
            window.location.replace(url + "manager.html")
            logoutBtn.style.display = 'block';
        }else if (username.value == "superman") {
            window.location.replace(url + "employee.html")
            logoutBtn.style.display = 'block';
        }else if (username.value == "pultizerwinner") {
            window.location.replace(url + "employee.html")
            logoutBtn.style.display = 'block';
        }
      }else{
        console.log("Login unsuccessful. Returned status code :"+response.status);
      }

}

