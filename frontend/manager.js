let manager_div = document.getElementById("managerDiv");
let reimbTbl = document.getElementById("reimbTbl");
let viewAllReimbBtn = document.getElementById("viewAllReimbBtn");
let viewAllReqBtn = document.getElementById("viewAllReqBtn")
let updateRequestBtn = document.getElementById("updateRequestBtn");
let updateStatusBtn = document.getElementById("updateStsBtn")
let logoutBtn = document.getElementById("logoutBtn");

const url = "http://localhost:8080/"

viewAllReimbBtn.addEventListener("click", findAllReimbursement);
viewAllReqBtn.addEventListener("click", findAllRequest);
updateStsBtn.addEventListener("click", updateStatus);
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

async function findAllReimbursement(){
    

    let response = await fetch(url+"manager/allReimbursement",{
        credentials:"include"
});
    if(response.status === 200) {
    let reimbs = await response.json();
    listReimb(reimbs);
    }else{
    console.log("Error viewing all reimbursement")
    }
    
    
    function listReimb(reimbs){
        reimbTbl.innerText = "";
        for (let reimb of reimbs){
            let row = document.createElement("tr");
            for (let data in reimb){
                let td = document.createElement("td");
                td.innerText = reimb[data];

                if (data == "reimbursementAmount"){
                    td.innerText = "$" + reimb[data];}
                if (data == "reimbursementSubmitted" || data == "reimbursementResolved"){
                    if(reimb[data]==null){
                        td.innerText == null
                    }else{
                    td.innerText = new Date(reimb[data]);}
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

async function findAllRequest(){

    let response = await fetch(url+"manager/findAllRequest",{
        credentials:"include"
});

    if(response.status === 200) {
        let reimbs = await response.json();
        listReimb(reimbs);
        }else{
        console.log("Error viewing all requests")
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

async function updateStatus(){
    
    let statusId_value = 1;
  
    if (document.querySelector('#types').value == "accepted"){
      statusId_value = 2;
    } else if(document.querySelector('#types').value =="denied"){
        statusId_value = 3;
    }

    let status = {
        
        reimbursementId:document.getElementById("reimbId").value,  
        reimbursementResolver:document.getElementById("resolverId").value,
    
        
        reimbursementStatusId:statusId_value
    
      }
      console.log(status);
      
      let response = await fetch(url + "manager/updateStatus", {
        method:"PUT",
        body:JSON.stringify(status),
        credentials:"include"
        })
  
        if(response.status === 202){
  
        console.log("Update status successfully!");
        
        }else {
  
      console.log("Update status unsuccessful" +response.status);
    }
}

