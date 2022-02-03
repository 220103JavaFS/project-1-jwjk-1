let employee_div = document.getElementById("employeeDiv");
let requestBtn = document.getElementById("requestBtn");
let searchBtn = document.getElementById("searchBtn");
let logoutBtn = document.getElementById("logoutBtn");

const url = "http://localhost:8080/"

searchBtn.addEventListener("click",viewPastRequests);
requestBtn.addEventListener("click",addRequest);
logoutBtn.addEventListener("click", logoutFunc);

logoutBtn.style.display = 'block';

async function logoutFunc(){

    let response = await fetch(
        url+"logout",
        {
        method : "POST",   
        credentials: "include"
        }
    );

    if(response.status===200){
        sessionStorage.clear();
        window.location.replace(url + "login.html");
    }else{
        console.log("Logout failed. Returned status code :"+response.status);
  }
}

async function viewPastRequests(){
    let authorId = document.getElementById('authorId').value;

    let response = await fetch(url+"employee/"+authorId,{
        credentials:"include"
    });
    if(response.status === 200) {
        let reimbs = await response.json();
        listReimb(reimbs);
    }else{
        console.log("Error viewing past requests")
    }
    
    function listReimb(reimbs){
        reimbTbl.innerText = "";
        for (let reimb of reimbs){
            let row = document.createElement("tr");
            for (let data in reimb){
                let td = document.createElement("td");
                td.innerText = reimb[data];

                if (data == "reimbursementSubmitted" || data == "reimbursementResolved"){
                        if(reimb[data]==null){
                            td.innerText == null
                        }else{
                        td.innerText = new Date(reimb[data]);}
                }
                if (data == "reimbursementAmount"){
                    td.innerText = "$" + reimb[data];
                }
                if (data == "reimbursementAuthor" || data == "reimbursementResolver"){
                    if(reimb[data] == null){
                        td.innerText = null;
                    }else {
                        td.innerText = reimb[data];
                        console.log(reimb[data]);
                    }
                }
                if(data == "reimbursementStatusId"){
                    td.innerText = reimb[data];
                }
                if(data == "reimbursementTypeId"){
                    td.innerText = reimb[data];
                }
                row.appendChild(td);
            }
            reimbTbl.appendChild(row);
        }
    }

}


  async function addRequest() {
   
    let typeId_value = 1;
  
    if (document.querySelector('#types').value == "travel"){
      typeId_value = 2;
    } else if(document.querySelector('#types').value =="accomodation"){
        typeId_value = 3;
    }
  

    let status = {
        
      reimbursementAuthor:document.getElementById("authorId").value,  
      reimbursementAmount:document.getElementById("reimbAmount").value,
      reimbursementDescription:document.getElementById("reimbDesc").value,
      
      reimbursementTypeId:typeId_value
  
    } 
    console.log(status);
  
  
    let response = await fetch(url + "employee", {
        method:"POST",
        body:JSON.stringify(status),
        credentials:"include"
    })
  
    if(response.status === 202){
  
        console.log("Reimbursement request sent successfully!");
        
    }else {
  
      console.log("Unsuccessful" +response.status);
    }
    
  }

