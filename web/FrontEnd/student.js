const nameInput = document.getElementById("name");
const courseSelect = document.getElementById("course");
const emailInput = document.getElementById("email");
const addBtn = document.getElementById("addBtn");
const loadBtn = document.getElementById("loadBtn");
const studentList = document.getElementById("studentList");


// 백엔드 주소 (포트 10000)
const BASE_URL = "http://localhost:10000/api/students";

// [기능 1] 수강생 목록 조회 함수
function loadStudents() {
    fetch(BASE_URL)
        .then(res => res.json()) // 응답을 JSON 객체로 파싱
        .then(responseDto => {
            const students = responseDto.data; // ResponseDTO의 data 꺼내기
            studentList.innerHTML = ""; // 표 초기화
             
            students.forEach(student => {
                const tr = document.createElement("tr");
                tr.innerHTML = `
                    <td>${student.id}</td>
                    <td>${student.name}</td>
                    <td>${student.course}</td>
                    <td>${student.email}</td>
                `;
                studentList.appendChild(tr);
            });
        })
        .catch(err => console.error("조회 실패:", err));
}

// 조회 버튼 클릭 시 목록 불러오기
loadBtn.addEventListener("click", loadStudents);

// [기능 2] 수강생 등록 이벤트
addBtn.addEventListener("click", () => {
    const name = nameInput.value.trim();
    const course = courseSelect.value;
    const email = emailInput.value.trim();

    // 입력값 유효성 검사 (7-1 ~ 7-3 조건)
    if (name === "") {
        alert("이름을 입력해야 합니다.");
        return;
    }
    if (course === "") {
        alert("과정명을 선택해야 합니다.");
        return;
    }
    if (email === "") {
        alert("이메일을 입력해야 합니다.");
        return;
    }
    if (!email.includes("@")) {
        alert("이메일에 @가 포함되어야 합니다.");
        return;
    }

    // 서버로 보낼 JSON 편지 봉투 작성
    const studentData = {
        name: name,
        course: course,
        email: email
    };

    // POST 요청 전송
    fetch(BASE_URL, {
        method: "POST",
        headers: {
            "Content-Type": "application/json" // 서버에 "나 지금 JSON 보낸다"고 알림
        },
        body: JSON.stringify(studentData) // 자바스크립트 객체를 문자열 JSON으로 압축
    })
    .then(res => res.json())
    .then(data => {
        alert("등록 성공!"); // 알림
        
        // 입력창 초기화
        nameInput.value = "";
        courseSelect.value = "";
        emailInput.value = "";

        // 등록 완료 후 수강생 목록 새로고침
        loadStudents();
    })
    .catch(err => {
        console.error("등록 실패:", err);
        alert("등록 중 에러가 발생했습니다.");
    });
});