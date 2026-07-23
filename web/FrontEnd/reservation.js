// 스프링 부트 서버 기본 주소 (포트 10000)
const API_BASE_URL = 'http://localhost:10000/reservations';

// 페이지 로드 완료 시 이벤트 할당 및 초기 데이터 조회
document.addEventListener('DOMContentLoaded', () => {
  loadAllData();

  // 이벤트 리스너 등록
  document.getElementById('btnSearch').addEventListener('click', handleSearch);
  document.getElementById('btnReset').addEventListener('click', loadAllData);
  document.getElementById('sortType').addEventListener('change', handleSort);
  document.getElementById('btnOpenModal').addEventListener('click', () => openModal());
  document.getElementById('btnCloseModal').addEventListener('click', closeModal);
  document.getElementById('reservationForm').addEventListener('submit', handleFormSubmit);
});

// [통합 초기화] 전체 목록 및 상태 카운트 로드
async function loadAllData() {
  document.getElementById('keyword').value = '';
  document.getElementById('sortType').value = '';
  fetchReservations();
  fetchStatusCounts();
}

// [문제 3] 전체 예약 목록 조회 (GET /reservations)
async function fetchReservations() {
  try {
    const res = await fetch(API_BASE_URL);
    const data = await res.json();
    renderTable(data);
  } catch (err) {
    console.error('목록 불러오기 실패:', err);
  }
}

// [문제 10] 상태별 예약 수 조회 (GET /reservations/status-count)
async function fetchStatusCounts() {
  try {
    const res = await fetch(`${API_BASE_URL}/status-count`);
    const data = await res.json();

    // 카운트 초기화
    let counts = { '예약': 0, '진료완료': 0, '예약취소': 0 };
    data.forEach(item => {
      counts[item.status] = item.count;
    });

    document.getElementById('count-reserved').textContent = counts['예약'];
    document.getElementById('count-completed').textContent = counts['진료완료'];
    document.getElementById('count-cancelled').textContent = counts['예약취소'];
  } catch (err) {
    console.error('상태 카운트 불러오기 실패:', err);
  }
}

// [문제 8] 조건 검색 (GET /reservations/search-detail)
async function handleSearch() {
  const searchType = document.getElementById('searchType').value;
  const keyword = document.getElementById('keyword').value.trim();

  if (!keyword) {
    alert('검색어를 입력하세요.');
    return;
  }

  try {
    const res = await fetch(`${API_BASE_URL}/search-detail?searchType=${searchType}&keyword=${encodeURIComponent(keyword)}`);
    const data = await res.json();
    renderTable(data);
  } catch (err) {
    console.error('검색 실패:', err);
  }
}

// [문제 9] 진료비 정렬 (GET /reservations/sort)
async function handleSort(e) {
  const sort = e.target.value;
  if (!sort) return;

  try {
    const res = await fetch(`${API_BASE_URL}/sort?sort=${sort}`);
    const data = await res.json();
    renderTable(data);
  } catch (err) {
    console.error('정렬 실패:', err);
  }
}

// [문제 5 & 6] 등록(POST) 및 수정(PUT) 폼 제출 처리
async function handleFormSubmit(e) {
  e.preventDefault();

  const id = document.getElementById('formId').value;
  const payload = {
    petName: document.getElementById('petName').value,
    ownerName: document.getElementById('ownerName').value,
    animalType: document.getElementById('animalType').value,
    doctorName: document.getElementById('doctorName').value,
    reservationDate: document.getElementById('reservationDate').value,
    status: document.getElementById('status').value,
    price: parseInt(document.getElementById('price').value)
  };

  const isEdit = Boolean(id);
  const url = isEdit ? `${API_BASE_URL}/${id}` : API_BASE_URL;
  const method = isEdit ? 'PUT' : 'POST';

  try {
    const res = await fetch(url, {
      method: method,
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(payload)
    });

    if (res.ok) {
      alert(isEdit ? '예약이 수정되었습니다.' : '새 예약이 등록되었습니다.');
      closeModal();
      loadAllData();
    }
  } catch (err) {
    console.error('저장 실패:', err);
  }
}

// [문제 4 & 6] 수정 모달 오픈 (단건 조회 GET /reservations/{id})
async function openEditModal(id) {
  try {
    const res = await fetch(`${API_BASE_URL}/${id}`);
    const data = await res.json();

    document.getElementById('formId').value = data.id;
    document.getElementById('petName').value = data.petName;
    document.getElementById('ownerName').value = data.ownerName;
    document.getElementById('animalType').value = data.animalType;
    document.getElementById('doctorName').value = data.doctorName;
    document.getElementById('reservationDate').value = data.reservationDate;
    document.getElementById('status').value = data.status;
    document.getElementById('price').value = data.price;

    openModal('예약 정보 수정');
  } catch (err) {
    console.error('단건 조회 실패:', err);
  }
}

// [문제 7] 예약 삭제 (DELETE /reservations/{id})
async function deleteReservation(id) {
  if (!confirm(`${id}번 예약을 정말 삭제하시겠습니까?`)) return;

  try {
    const res = await fetch(`${API_BASE_URL}/${id}`, { method: 'DELETE' });
    if (res.ok) {
      alert('삭제되었습니다.');
      loadAllData();
    }
  } catch (err) {
    console.error('삭제 실패:', err);
  }
}

// 테이블 HTML 랜더링 함수
function renderTable(list) {
  const tbody = document.getElementById('reservationList');
  tbody.innerHTML = '';

  if (list.length === 0) {
    tbody.innerHTML = '<tr><td colspan="9">조회된 데이터가 없습니다.</td></tr>';
    return;
  }

  list.forEach(item => {
    const tr = document.createElement('tr');
    tr.innerHTML = `
      <td>${item.id}</td>
      <td><strong>${item.petName}</strong></td>
      <td>${item.ownerName}</td>
      <td>${item.animalType}</td>
      <td>${item.doctorName}</td>
      <td>${item.reservationDate}</td>
      <td>${item.status}</td>
      <td>${item.price.toLocaleString()}원</td>
      <td>
        <button class="btn btn-warning" onclick="openEditModal(${item.id})">수정</button>
        <button class="btn btn-danger" onclick="deleteReservation(${item.id})">삭제</button>
      </td>
    `;
    tbody.appendChild(tr);
  });
}

// 모달 제어 함수
function openModal(title = '예약 등록') {
  document.getElementById('modalTitle').textContent = title;
  if (title === '예약 등록') {
    document.getElementById('reservationForm').reset();
    document.getElementById('formId').value = '';
  }
  document.getElementById('modal').classList.remove('hidden');
}

function closeModal() {
  document.getElementById('modal').classList.add('hidden');
}