const submitButtonReimb = document.getElementById("employee_reimb_submit"); 

submitButtonReimb.addEventListener("click", function(event){
    
let reimb_type = document.getElementById("Reimbursement-type").value; //works as intended 
let reimb_amount = document.getElementById("reimbursement-amount").value; 
let reimb_receipt = document.getElementById("receipt").value;//need to research 
let reimb_descr = document.getElementById("reimb_desc").value
event.preventDefault(); 
console.log(reimb_type, reimb_amount, reimb_descr, reimb_receipt)
let formDataSubmitted = packageFormData(reimb_type, reimb_amount, reimb_receipt,reimb_descr); //creates object from input values
console.log(formDataSubmitted);
})

function packageFormData (reimb_type, reimb_amount, reimb_recipt = null, reimb_desc){
    return {
        reimb_type:reimb_type,
        reimb_amount: reimb_amount, 
        reimb_recipt: reimb_recipt,
        reimb_desc: reimb_desc
    }
}

function sendData(jsDataObject){
    //XHR method 
    let jsonData = JSON.stringify(jsDataObject);
    let xhr = new XMLHttpRequest(); 
    let url = "/reimbursement_submit"; 
    xhr.open("POST", url, true)

    xhr.setRequestHeader("Content-Type", "application/json")
    xhr.send(jsonData);
    let resultP = document.getElementsByClassName("result")
    xhr.onreadystatechange = function(){
        if(xhr.readyState === 4 && xhr.status === 200){
            resultP.innerHTML = this.responseText;
        }
    }

}

const getUserInfoButton = document.getElementById("get-user-info");

getUserInfoButton.addEventListener('click', function(event){
    console.log("clicked")
    async function getInfo(){
         let data = await fetch("http://localhost:8080/reimbursement-app/getEmployeeInfo")
         .then(Response => Response.json())
        try{
            userData = JSON.parse(data)
        } catch(e){
            userData = data
        }

        console.log(userData)
    }
    getInfo();
})