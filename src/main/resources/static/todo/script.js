const api = "/api/todos"

async function First(){
    let res = await fetch(api);
    data = await res.json();

    let count = 0;
    let viewHtml = ``;
    for(i in data){
        let chk = data[count].chk;
        viewHtml += `
        <li class="${classChk(chk)}"><input type="hidden" value="${data[count].id}">${data[count].todo}</li>
    `;
        count++;
    }
    findResult = document.querySelector('#todos');
    findResult.innerHTML += viewHtml;
}
//초기 데이터 조회
First();
//취소선 값 확인하여 클래스명 지정
function classChk(chk){
    if(chk === "true"){
        return "completed"
    } else {
        return ""
    }
}
//todo추가하는 폼태그 받기
form.addEventListener("submit", event => {
    event.preventDefault()
    let ans = document.getElementById("input")
    let todo = ans.value;
    //데이터 흘러들어오는 것 확인
    add(todo)
})
//폼태그로 받은 데이터 추가
async function add(todo){
    let addRes = await fetch(api + "/save",{ method: 'POST',headers:{'Content-type' : 'application/json'},
        body: JSON.stringify({
            // id : count,
            todo : todo,
            chk : "false"
        })});

}
//버블링 이벤트리스너로 취소선 추가 및 상태 함수 호출
document.querySelector("#todos").addEventListener('click',(event)=>{
    let k = event.target.childNodes[0].value;
    if(event.target.className !== 'completed'){
        event.target.className += 'completed'
        chkTrue(k);
    } else {
        event.target.className = "";
        chkFalse(k);
    }
})
//이벤트리스너로 취소선 추가후 상태를 true
async function chkTrue(k){
    let addRes = await fetch(api + "/chk",{ method: 'POST',headers:{'Content-type' : 'application/json'},
        body: JSON.stringify({
            id : k,
            chk : "true"
        })});
}
//이벤트리스너로 취소선 추가후 상태를 false
async function chkFalse(k){
    let addRes = await fetch(api + "/chk",{ method: 'POST',headers:{'Content-type' : 'application/json'},
        body: JSON.stringify({
            id : k,
            chk : "false"
        })});
}
//버블링 이벤트리스너로 삭제 함수 호출
document.querySelector("#todos").addEventListener('contextmenu',(event)=>{
    event.preventDefault();
    let status = event.target.className;
    let x = event.target.childNodes[0].value;
    deleteli(status,x);
})
async function deleteli(status,x){
    if(status === 'completed') {
        let addRes = await fetch(api + "/delete", {
            method: 'POST', headers: {'Content-type': 'application/json'},
            body: JSON.stringify({
                id: x
            })
        });
    } else {
        alert("ToDolist 완료 후 우클릭으로 삭제하셈")
    }
}