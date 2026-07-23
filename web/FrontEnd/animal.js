// 처음 페이지가 로딩됐을 때 전체 목록이 나오게 하기
const API_URL = "http://localhost:10000/reservations"; // 백엔드 엔드포인트 경로 규칙 맞춤 (/reservations)

// HTML 요소 가져오기
const reservationId = document.querySelector("#reservationId");
// 동물이름
const petName = document.querySelector("#petName");
// 주인
const ownerName = document.querySelector("#ownerName");
// 동물의 종류
const animalType = document.querySelector("#animalType"); // [오타 수정] ainmalType -> animalType
// 의사이름
const doctorName = document.querySelector("#doctorName");
// 예약날짜
const reservationDate = document.querySelector("#reservationDate");
// 상태
const status = document.querySelector("#status");
// 금액
const price = document.querySelector("#price");
// 등록버튼
const saveBtn = document.querySelector("#saveBtn");
// 취소버튼
const cancelBtn = document.querySelector("#cancelBtn"); // [오타 수정] calcelBtn -> cancelBtn
const reservationList = document.querySelector("#reservationList");


// ==========================================
// 1. 전체 목록 불러오기 (GET)
// ==========================================
const loadReservations = () => {
    // 기존 목록 초기화 (중복 출력 방지)
    reservationList.innerHTML = "";

    fetch(API_URL)
        .then(res => res.json())
        .then(data => {
            data.forEach(reservation => {
                // tr생성
                const tr = document.createElement("tr");

                tr.innerHTML = `
                    <td>${reservation.id}</td>
                    <td>${reservation.petName}</td>
                    <td>${reservation.ownerName}</td>
                    <td>${reservation.animalType}</td>
                    <td>${reservation.doctorName}</td>
                    <td>${reservation.reservationDate}</td>
                    <td>${reservation.status}</td>
                    <td>${reservation.price.toLocaleString()}원</td>
                    <td>
                        <button class="edit-btn" onclick="editReservation(${reservation.id})">수정</button>
                        <button class="delete-btn" onclick="deleteReservation(${reservation.id})">삭제</button>
                    </td>
                `;

                // tbody에 추가
                reservationList.appendChild(tr);
            });
        })
        .catch(error => {
            console.error(error);
            alert("예약 정보를 불러올 수 없습니다.");
        });
};


// ==========================================
// 2. 예약 등록 및 수정 처리 (클릭 이벤트)
// ==========================================
saveBtn.addEventListener("click", () => {
    // 입력값 검사
    if (petName.value.trim() === "") {
        alert("반려동물 이름을 입력하세요");
        petName.focus(); // [오타 수정] .focus -> .focus()
        return;
    }

    if (ownerName.value.trim() === "") {
        alert("보호자 이름을 입력하세요");
        ownerName.focus(); // [오타 수정] .focus -> .focus()
        return;
    }

    if (animalType.value === "") { // [오타 수정] ainmalType -> animalType
        alert("동물 종류를 선택하세요");
        animalType.focus();
        return;
    }

    if (doctorName.value.trim() === "") {
        alert("담당 수의사 이름을 입력하세요");
        doctorName.focus();
        return;
    }

    if (reservationDate.value === "") {
        alert("예약 날짜를 선택하세요");
        reservationDate.focus();
        return;
    }

    if (price.value === "") {
        alert("예상 진료비를 작성하세요");
        price.focus();
        return;
    }

    // 서버로 전송할 객체
    const reservation = {
        petName: petName.value,
        ownerName: ownerName.value,
        animalType: animalType.value,
        doctorName: doctorName.value,
        reservationDate: reservationDate.value,
        status: status.value,
        price: parseInt(price.value)
    };

    // ID 유무에 따라 등록(POST) / 수정(PUT) 분기 처리
    const id = reservationId.value;
    if (id) {
        updateReservation(id, reservation);
    } else {
        insertReservation(reservation);
    }
});


// ==========================================
// 3. 서버 통신 보조 함수들 (신규 등록, 수정, 삭제)
// ==========================================

// [신규 등록 - POST]
const insertReservation = (reservation) => {
    fetch(API_URL, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(reservation)
    })
    .then(res => {
        if (res.ok) {
            alert("예약이 등록되었습니다.");
            resetForm();
            loadReservations();
        } else {
            alert("등록 실패");
        }
    })
    .catch(error => console.error("등록 오류:", error));
};

// [수정 전 단건 조회 및 폼 채우기 - GET]
const editReservation = (id) => {
    fetch(`${API_URL}/${id}`)
        .then(res => res.json())
        .then(data => {
            reservationId.value = data.id;
            petName.value = data.petName;
            ownerName.value = data.ownerName;
            animalType.value = data.animalType;
            doctorName.value = data.doctorName;
            reservationDate.value = data.reservationDate;
            status.value = data.status;
            price.value = data.price;

            saveBtn.textContent = "수정 완료"; // 버튼 텍스트 변경
        })
        .catch(error => console.error("조회 오류:", error));
};

// [수정 저장 - PUT]
const updateReservation = (id, reservation) => {
    fetch(`${API_URL}/${id}`, {
        method: "PUT",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(reservation)
    })
    .then(res => {
        if (res.ok) {
            alert("예약이 수정되었습니다.");
            resetForm();
            loadReservations();
        } else {
            alert("수정 실패");
        }
    })
    .catch(error => console.error("수정 오류:", error));
};

// [삭제 처리 - DELETE]
const deleteReservation = (id) => {
    if (!confirm(`${id}번 예약을 정말 삭제하시겠습니까?`)) return;

    fetch(`${API_URL}/${id}`, { method: "DELETE" })
        .then(res => {
            if (res.ok) {
                alert("삭제되었습니다.");
                loadReservations();
            } else {
                alert("삭제 실패");
            }
        })
        .catch(error => console.error("삭제 오류:", error));
};

// [폼 초기화]
const resetForm = () => {
    reservationId.value = "";
    petName.value = "";
    ownerName.value = "";
    animalType.value = "";
    doctorName.value = "";
    reservationDate.value = "";
    status.value = "예약";
    price.value = "";
    
    saveBtn.textContent = "등록"; // 버튼 글자 원복
};

// 취소 버튼 이벤트 연동
cancelBtn.addEventListener("click", resetForm);

// 최초 페이지 로드시 실행
loadReservations();
