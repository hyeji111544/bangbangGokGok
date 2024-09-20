

const weatherApiKey = 'a5cee686f14868c871fb019a181b220a'; // 여기에 OpenWeatherMap API 키 입력
const weatherInfo = document.getElementById('weather-info');

var mapContainer = document.getElementById('map');
var mapOption = {
    center: new kakao.maps.LatLng(37.5665, 126.9780), // 초기 서울 중심 좌표
    level: 3 // 확대 레벨
};

// 지도 생성
var map = new kakao.maps.Map(mapContainer, mapOption);

// 장소 검색 객체 생성
var ps = new kakao.maps.services.Places(map);
var markers = [];

// 지역 선택 시 지도 이동 및 날씨 정보 업데이트
document.getElementById('location-selector').addEventListener('change', function() {
    var selectedLocation = this.value.split(",");
    var lat = parseFloat(selectedLocation[0]);
    var lon = parseFloat(selectedLocation[1]);

    var locPosition = new kakao.maps.LatLng(lat, lon);
    map.setCenter(locPosition); // 지도 중심을 해당 위치로 이동

    fetchWeatherData(lat, lon); // 날씨 정보 업데이트
});

// 선택한 카테고리로 장소 검색 함수
function selectCategory(category) {
    var selectedLocation = document.getElementById('location-selector').value.split(",");
    var lat = parseFloat(selectedLocation[0]);
    var lon = parseFloat(selectedLocation[1]);

    var locPosition = new kakao.maps.LatLng(lat, lon);
    searchPlaces(category, locPosition);
}

// 날씨 정보를 가져오는 함수 (OpenWeatherMap API 사용)
function fetchWeatherData(lat, lon) {
    const url = `https://api.openweathermap.org/data/2.5/weather?lat=${lat}&lon=${lon}&appid=a5cee686f14868c871fb019a181b220a&units=metric&lang=kr`;

    fetch(url)
        .then(response => response.json())
        .then(data => {
            const temp = data.main.temp;  // 온도
            const weather = data.weather[0].description;  // 날씨 설명
            const city = data.name;  // 지역 이름

            weatherInfo.innerText = `현재 ${city}의 날씨: ${temp}°C, ${weather}`;
        })
        .catch(error => {
            console.error('Error fetching weather data:', error);
            weatherInfo.innerText = '날씨 정보를 불러올 수 없습니다.';
        });
}

// 마커를 제거하는 함수
function removeMarkers() {
    for (var i = 0; i < markers.length; i++) {
        markers[i].setMap(null); // 지도에서 마커 제거
    }
    markers = []; // 마커 배열 초기화
}

// 카테고리별 장소 검색 함수
function searchPlaces(category, locPosition) {
    var placesOptions = {
        location: locPosition,
        radius: 1000 // 1km 반경 검색
    };

    removeMarkers(); // 이전 마커 제거
    ps.categorySearch(category, placesSearchCB, placesOptions);
}

// 장소 검색 완료 시 호출되는 콜백 함수
function placesSearchCB(data, status, pagination) {
    if (status === kakao.maps.services.Status.OK) {
        displayPlaces(data); // 검색된 장소들을 마커로 표시
    }
}

var currentInfoWindow = null; // 현재 열려있는 정보창을 저장할 변수
var infoWindows = []; // 모든 열린 정보창을 저장할 배열

// 장소를 마커로 표시하는 함수
function displayPlaces(places) {
    removeMarkers();
    closeInfoWindows();

    for (var i = 0; i < places.length; i++) {
        var placePosition = new kakao.maps.LatLng(places[i].y, places[i].x),
            marker = new kakao.maps.Marker({
                map: map,
                position: placePosition
            });

        // 마커 배열에 추가
        markers.push(marker);

        // 마커 클릭 시 장소 이름 표시 및 이전 정보창 닫기
        (function(marker, place) {
            kakao.maps.event.addListener(marker, 'click', function() {
                closeInfoWindows();

                var infowindow = new kakao.maps.InfoWindow({
                    content: '<div style="padding:5px;">' + place.place_name + '</div>'
                });

                infowindow.open(map, marker);

                infoWindows.push(infowindow);
            });
        })(marker, places[i]);
    }
}

// 모든 정보창을 닫는 함수
function closeInfoWindows() {
    for (var i = 0; i < infoWindows.length; i++) {
        infoWindows[i].close(); // 각 정보창 닫기
    }
    infoWindows = []; // 배열 초기화
}