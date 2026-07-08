// 고정된 도시 데이터 객체 배열
const cities = [
    { name: "서울", lat: 37.5665, lon: 126.9780 },
    { name: "부산", lat: 35.1796, lon: 129.0756 },
    { name: "제주", lat: 33.4996, lon: 126.5312 },
    { name: "도쿄", lat: 35.6762, lon: 139.6503 },
    { name: "뉴욕", lat: 40.7128, lon: -74.0060 }
];

// DOM 요소 가져오기
const citySelect = document.getElementById('citySelect');
const weatherBtn = document.getElementById('weatherBtn');
const message = document.getElementById('message');
const weatherBox = document.getElementById('weatherBox');

// 날씨 조회 버튼 클릭 이벤트 리스너
weatherBtn.addEventListener('click', async function() {
    // 초기화
    message.textContent = '';
    weatherBox.style.display = 'none';
    weatherBox.innerHTML = '';

    const selectedCityName = citySelect.value;

    // 1. 유효성 검사: 도시 미선택
    if (!selectedCityName) {
        message.textContent = '도시를 선택해주세요.';
        return;
    }

    // 2. find()를 사용하여 선택한 도시 데이터 찾기
    const cityData = cities.find(city => city.name === selectedCityName);

    // 3. 유효성 검사: 존재하지 않는 도시값 조회 차단
    if (!cityData) {
        message.textContent = '유효하지 않거나 존재하지 않는 도시입니다.';
        return;
    }

    // 4. 유효성 검사: 위도(lat)와 경도(lon)가 올바른 Number 타입인지 검사
    if (typeof cityData.lat !== 'number' || typeof cityData.lon !== 'number' || isNaN(cityData.lat) || isNaN(cityData.lon)) {
        message.textContent = '도시의 좌표 데이터가 올바른 숫자 형식이 아닙니다.';
        return;
    }

    // API URL 동적 생성 (선택된 도시의 위도와 경도 삽입)
    const apiUrl = `https://api.open-meteo.com/v1/forecast?latitude=${cityData.lat}&longitude=${cityData.lon}&current_weather=true`;

    // 5. try / catch 문을 이용한 API 요청 및 예외 처리
    try {
        // fetch()와 async / await 적용
        const response = await fetch(apiUrl);
        
        // API 응답 자체 실패 처리 (예: 404, 500 에러 등)
        if (!response.ok) {
            throw new Error('API 응답 실패 (서버 오류)');
        }

        const data = await response.json();

        // 6. 유효성 검사: 날씨 데이터가 없는 경우
        if (!data || !data.current_weather) {
            weatherBox.innerHTML = '<p>날씨 데이터가 없습니다.</p>';
            weatherBox.style.style.display = 'block';
            return;
        }

        // 출력할 데이터 가공 (Open-Meteo API 구조 반영)
        const weather = data.current_weather;
        const temperature = weather.temperature;
        const windspeed = weather.windspeed;
        const weathercode = weather.weathercode;
        const time = weather.time;

        // 7. 출력 조건 만족하는 결과 화면 렌더링
        weatherBox.innerHTML = `
            <h3>📍 ${cityData.name} 날씨 결과</h3>
            <p><strong>현재 기온:</strong> ${temperature}°C</p>
            <p><strong>풍속:</strong> ${windspeed} km/h</p>
            <p><strong>날씨 코드:</strong> ${weathercode}</p>
            <p><strong>조회 시간:</strong> ${time}</p>
        `;
        
        // 결과 영역 표시
        weatherBox.style.display = 'block';

    } catch (error) {
        // API 연결 실패 등 네트워크 오류 에러 메시지 출력
        message.textContent = `날씨 정보를 가져오는 데 실패했습니다. (${error.message})`;
    }
});