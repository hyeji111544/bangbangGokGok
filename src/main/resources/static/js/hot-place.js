// 사진 슬라이드 & 좋아요
function toggleLike(button) {
    const svg = button.querySelector('svg');
    const isLiked = svg.style.fill === "red";

    if (isLiked) {
        svg.style.fill = "none";
        console.log("좋아요 해제됨");
        sendLikeStatus(button.dataset.id, false); // 좋아요 해제 요청
    } else {
        svg.style.fill = "red";
        console.log("좋아요 체크됨");
        sendLikeStatus(button.dataset.id, true); // 좋아요 체크 요청
    }
}

// AJAX로 좋아요 상태 전송
async function sendLikeStatus(id, isLiked) {
    try {
        const response = await fetch('/like', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                id: id,
                liked: isLiked
            })
        });

        if (!response.ok) {
            throw new Error('좋아요 상태 전송 실패');
        }

        const data = await response.json();
        console.log('서버 응답:', data);
    } catch (error) {
        console.error('오류 발생:', error);
    }
}

// 슬라이드 변경 함수
function showSlide(index, button) {
    console.log('Button clicked:', button);  // 클릭된 버튼 확인
    const card = button.closest('.hot__place__card');
    if (!card) {
        console.error('Card not found');
        return;
    }

    console.log('Card found:', card);  // 찾은 카드 확인
    const images = card.querySelectorAll('img');
    const dots = card.querySelectorAll('.dots button');

    if (images.length === 0 || dots.length === 0) {
        console.error('Images or dots not found in the card.');
        return;
    }


    images.forEach(function (img, i) {
        img.classList.toggle('active', i === index);
        dots[i].classList.toggle('active', i === index);
    });
}


// 버튼 생성 후 검색
let areas = [];
let areaCode;
let sigunguCode = [];

let modal = document.querySelector("#modal");
let closeModal = document.querySelector(".close");
let areaSelectionDiv = document.querySelector("#area-selection");
let searchBtn = document.querySelector("#searchBtn");
let areaCodeInput = document.querySelector(".area-code");
let sigunguSelect = document.querySelector("#sigungu-select");

// 모달 열기
let openModalBtns = document.querySelectorAll(".open__modal");
openModalBtns.forEach(function (button) {
    button.onclick = function () {
        modal.style.display = "block";

        // 지역 이름 표시
        let modalArea = button.querySelector(".hotplace__name").textContent;
        document.querySelector(".modal__area").textContent = modalArea;

        // '전체' 버튼 추가
        areaSelectionDiv.innerHTML = ""; // 기존 버튼들을 초기화
        let allButton = document.createElement("button");
        allButton.classList.add("area-btn", "selected");
        allButton.textContent = "전체";
        areaSelectionDiv.appendChild(allButton);

        areaCode = button.querySelector(".area-code").value;

        // AJAX로 시군구 데이터 가져오기
        $.ajax({
            url: `/get-sigungu?area=${areaCode}`,
            type: 'GET',
            dataType: 'json',
            success: function (response) {
                areas = response.body; // 시군구 데이터를 areas에 추가
                generateAreaButtons(); // 받은 데이터를 이용해 버튼 생성
                console.log(areas);
            },
            error: function (error) {
                console.error("에러 발생:", error);
            }
        });
    }
});

// 모달 닫기
closeModal.onclick = function () {
    modal.style.display = "none";
}

window.onclick = function (event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}

// 시군구 버튼 동적 생성
function generateAreaButtons() {
    areas.forEach(function (area) {
        let button = document.createElement("button");
        button.classList.add("area-btn");
        button.textContent = area.name; // 시군구 이름을 버튼에 표시
        button.setAttribute("data-code", area.code); // 시군구 코드 저장

        // 모든 버튼의 이벤트를 초기화하고 한 번만 설정
        document.querySelectorAll('.area-btn').forEach(function (button) {
            button.onclick = function () {
                let allButton = document.querySelector(".area-btn:first-child"); // '전체' 버튼

                if (button.textContent === '전체') {
                    // '전체' 버튼이 클릭되면 모든 하위지역 버튼들의 'selected' 클래스를 제거
                    document.querySelectorAll(".area-btn").forEach(function (btn) {
                        if (btn.textContent !== '전체') {
                            btn.classList.remove("selected");
                        }
                    });

                    // '전체' 버튼에 'selected' 클래스 추가
                    button.classList.add("selected");

                    // 하위 지역 코드를 비움
                    sigunguCode = [];

                } else {
                    // 하위지역 버튼 클릭 시 '전체' 버튼의 선택을 해제
                    button.classList.toggle("selected");
                    allButton.classList.remove("selected");

                    // 선택된 하위지역 버튼들을 배열로 모음
                    const selectedAreas = document.querySelectorAll(".area-btn.selected");

                    // 선택된 하위지역이 없을 경우, '전체' 버튼을 다시 선택
                    if (selectedAreas.length === 0) {
                        allButton.classList.add("selected");
                        sigunguCode = [];
                    } else {
                        // 선택된 하위지역 버튼들의 코드를 sigunguCode에 저장
                        sigunguCode = Array.from(selectedAreas).map(function (area) {
                            return area.getAttribute("data-code");
                        });
                    }
                }
            };

        });

        areaSelectionDiv.appendChild(button);
    });
}

// 검색 버튼 클릭 시 AJAX로 areaCode와 sigungu code 전송
searchBtn.addEventListener("click", function () {
    // "전체" 버튼이 선택된 경우 sigunguCode는 비워둠
    let isAllSelected = document.querySelector(".area-btn:first-child").classList.contains("selected");

    // 쿼리스트링을 만들기 위한 배열 생성
    let sigunguQueries = '';
    if (!isAllSelected && sigunguCode.length > 0) {
        sigunguQueries = sigunguCode.map(function (code) {
            return `sigungu=${code}`;
        }).join('&');
    }

    // URL 변수로 쿼리스트링을 깔끔하게 처리
    let url = `/get-hotplace?area=${areaCode}`;
    if (sigunguQueries) {
        url += `&${sigunguQueries}`;
    }
    console.log("areaCode: " + areaCode);
    console.log("sigunguCode: " + sigunguCode);

    $.ajax({
        url: url,
        type: 'GET',
        dataType: 'json',
        success: function (response) {
            console.log("검색 결과:", response);
            loadHotPlace(response);
        },
        error: function (error) {
            console.error("검색 에러:", error);
        }
    });

    // 검색 후 모달 닫기
    modal.style.display = "none";

    //검색 누르고 나서 시군구 코드 비움
    sigunguCode = [];
});


function loadHotPlace(response) {
    // 응답이 오면 box를 비움
    console.log(response)
    if (response) {
        $(".hot__place__card__box").empty();

        // fetch는 데이터를 받아서 .json()으로 파싱(json -> js object)해줘야 하는데
        // ajax의 success 콜백 함수는 json -> js object로 자동 파싱된다. 그냥 쓰면 됨
        let placeList = response.body;

        // 파싱한 데이터를 출력할 박스에 출력
        for (place of placeList) {
            $(".hot__place__card__box").prepend(printHotPlace(place));
        }
    } else {
        return `<h2>검색 결과가 없습니다.</h2>`;
    }
}

function printHotPlace(place) {
    return ` <div class="hot__place__card">
            <a href="/get-info/${place.contentId}">
                            <div class="hot__place__img__box">
                                <img src="${place.firstImage}" class="active" alt="이미지 1">
                <img src="${place.firstImage}" alt="이미지 2">                              

                            </div>
                        </a>

                        <button class="like-btn" onclick="toggleLike(this)">
                            <svg id="like-icon" viewBox="0 0 24 24" fill="none" stroke="currentColor"
                                 xmlns="http://www.w3.org/2000/svg">
                                <path
                                        d="M12 21.35l-1.45-1.32C5.4 15.36 2 12.28 2 8.5 2 5.42 4.42 3 7.5 3c1.74 0 3.41.81 4.5 2.09C13.09 3.81 14.76 3 16.5 3 19.58 3 22 5.42 22 8.5c0 3.78-3.4 6.86-8.55 11.54L12 21.35z"
                                        stroke-width="1" stroke-linecap="round" stroke-linejoin="round" />
                            </svg>
                        </button>
                        <div class="dots">
                            <button class="active" onclick="showSlide(0, this)"></button>
                            <button onclick="showSlide(1, this)"></button>                            
                        </div>

                        <div class="hot__place__description">
                            <p class="hot__place__name">${place.title}</p>
                            <p class="hot__place__location">${place.addr1}</p>
                        </div>
                    </div>`;
}


// 인기 여행지, 인기 맛집 클릭 시 AJAX 호출
let placeLink = document.querySelector(".hotpl");
let foodLink = document.querySelector(".hotf");

placeLink.addEventListener("click", function (event) {
    event.preventDefault();
    toggleActive(placeLink, foodLink);
    fetchData('place');
});

foodLink.addEventListener("click", function (event) {
    event.preventDefault();
    toggleActive(foodLink, placeLink);
    fetchData('food');
});

function toggleActive(activeLink, inactiveLink) {
    activeLink.classList.add("active");
    inactiveLink.classList.remove("active");
}

// 인기 여행지, 맛집 데이터를 AJAX로 불러오기
async function fetchData(type) {
    try {
        const response = await fetch(`/${type}`, {
            method: 'GET'
        });

        if (!response.ok) {
            throw new Error(`${type} 데이터 로드 실패`);
        }

        const data = await response.json();
        console.log(`${type} 데이터:`, data);
    } catch (error) {
        console.error(`${type} 데이터 로드 중 오류:`, error);
    }
}












