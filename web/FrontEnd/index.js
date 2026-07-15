// 1. 요소 가져오기
const btn = document.getElementById("btn");
const name = document.querySelector("input[type=text]");
const result = document.getElementById("result");

// 버튼 클릭 이벤트 리스너 등록
btn.addEventListener("click",() => {
    fetch(`http://localhost:10000/api/hello?name=${name.value}`)
    .then(res => res.text())//text() : 응답 본문을 문자열로 읽는 메서드
    .then(data => {
        result.textContent = data;
    });
})