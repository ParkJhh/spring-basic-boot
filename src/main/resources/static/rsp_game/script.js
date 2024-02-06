const api = "/api/rsp"
let winCount = 0;
let loseCount = 0;
let drawCount =0;

//초기화면
function First(){
    //초기화
    document.querySelector('#count').innerHTML = "";

    let viewHtml = ``;
    viewHtml += `
        <li>Win count : ${winCount}</li>
        <li>Lose count : ${loseCount}</li>
        <li>Draw count : ${drawCount}</li>
    `;
    findResult = document.querySelector('#count');
    findResult.innerHTML += viewHtml;
}
First();
//사용자의 가위바위보 선택
document.querySelector("#form").addEventListener('click',(event)=>{
    let humanChoice = event.target.className;
    console.log(rspMatch(humanChoice))
})

//컴퓨터 랜덤선택 > 0을 바위로 ,1을 가위로, 2를 보자기로 한다
function comRandom(){
    let number = 0;
    number = Math.floor(Math.random() * 3);
    if(number >= 0 && number < 1){
        return "rock"
    } else if(number >=1 && number < 2){
        return "scissors"
    } else if(number >=2 && number < 3){
        return "paper"
    }
}
//사용자의 선택과 컴퓨터의 랜덤 생성 비교
function rspMatch(humanChoice){
    let comChoice = comRandom()
    if(humanChoice === comChoice){
        //드로우
        drawCount++;
        rspStyle(0).then(r => First());
        return `인간 선택: ${humanChoice} 컴퓨터 선택: ${comChoice} 무승부`
    } else {
        //인간 바위
        if(humanChoice === "rock" && comChoice === "scissors"){
            winCount++;
            rspStyle(1).then(r => First());
            return `인간 선택: ${humanChoice} 컴퓨터 선택: ${comChoice} 인간 승`
        }
        if(humanChoice === "rock" && comChoice === "paper"){
            loseCount++;
            rspStyle(2).then(r => First());
            return `인간 선택: ${humanChoice} 컴퓨터 선택: ${comChoice} 컴퓨터 승`
        }
        //인간 가위
        if(humanChoice === "scissors" && comChoice === "rock"){
            loseCount++;
            rspStyle(2).then(r => First());
            return `인간 선택: ${humanChoice} 컴퓨터 선택: ${comChoice} 컴퓨터 승`
        }
        if(humanChoice === "scissors" && comChoice === "paper"){
            winCount++;
            rspStyle(1).then(r => First());
            return `인간 선택: ${humanChoice} 컴퓨터 선택: ${comChoice} 인간 승`
        }
        //인간 보자기
        if(humanChoice === "paper" && comChoice === "rock"){
            winCount++;
            rspStyle(1).then(r => First());
            return `인간 선택: ${humanChoice} 컴퓨터 선택: ${comChoice} 인간 승`
        }
        if(humanChoice === "paper" && comChoice === "scissors"){
            loseCount++;
            rspStyle(2).then(r => First());
            return `인간 선택: ${humanChoice} 컴퓨터 선택: ${comChoice} 컴퓨터 승`
        }
    }
}
//가위바위보 결과에 따른 css스타일 적용 0이면 무승부,1이면 사람, 2이면 컴퓨터
async function rspStyle(x){
    let res = await fetch(api + "/x");
    data = await res.json();
    //초기화
    document.querySelector('#you').className = ""
    document.querySelector('#computer').className = "";
    if(x === 0){
        //아무것도 없음
    } else if(x === 1){
        document.querySelector('#you').className = "winner"
    } else if(x === 2){
        document.querySelector('#computer').className = "winner";
    }
}