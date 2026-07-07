function hello(){
    alert('안녕하세요')
}

//아직 버튼이 랜더링 되지 않음
let btn = document.getElementById("btn");

btn.addEventListener("click", () => {
    alert("하이")
});