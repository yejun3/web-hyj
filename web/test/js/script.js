let searchInput = document.getElementById("searchInput").value;
let searchBtn = document.getElementById("searchBtn");
let allBtn = document.getElementById("allBtn");
let message = document.getElementById("message");
let count = document.getElementById("count");
let productList = document.getElementById("productList");
let regexInput = /^[a-zA-z0-9]{2,}$/;

const products=[];

function pageload(){
    fetch(`https://dummyjson.com/products?limit=30`)
    .then(res  =>res.json())
    .then(data=>{
        productList.innerHTML=""
        return`
        <div class="product-card">
        <img src="${data.img}"></img>
        <div>카테고리: ${data.category}</div>
        <div>가격:${data.price}</div>
        <div>할인율${data.rate}</div>
        <div>재고:${data.stock}</div>
         </div>`
    })
}

searchBtn.addEventListener("click",()=>{
    if(searchInput===""){
        message.textContent("검색어를 입력하세요")
    }
    if(!regexInput.test(searchInput)){
        message.textContent("검색어는 2글자 이상 입력하세요")
    }
    fetch(`https://dummyjson.com/products/search?${searchInput}`)
        .then(res  =>res.json())
})

allBtn.addEventListener("click",()=>{

})









