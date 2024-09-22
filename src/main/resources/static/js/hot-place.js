//핫플 기본상태는 인기 여행지 체크
$(function () {
    placeLink.classList.add("active");
});


// 사진 슬라이드 & 좋아요
function toggleLike(button) {
    let svg = button.querySelector('svg');
    let isLiked = svg.style.fill === "red";
    let contentId = button.dataset.id;

    if (isLiked) {
        svg.style.fill = "none";
        console.log("좋아요 해제됨");
        console.log("contentId", contentId);
        sendLikeStatus(contentId, false); // 좋아요 해제 요청
    } else {
        svg.style.fill = "red";
        console.log("좋아요 체크됨");
        console.log("contentId", contentId);
        sendLikeStatus(contentId, true); // 좋아요 체크 요청
    }
}

// AJAX로 좋아요 상태 전송
async function sendLikeStatus(id, isLiked) {
    try {
        let response = await fetch('/like', {
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
let sigungus = [];
let areaCode;
let sigunguCode = [];
let category = 'touristAttractions';
let sigunguQueries = '';

let modal = document.querySelector("#modal");
let closeModal = document.querySelector(".close");
let areaSelectionDiv = document.querySelector("#area-selection");
let searchBtn = document.querySelector("#searchBtn");


// 모달 열기
let openModalBtns = document.querySelectorAll(".open__modal");
openModalBtns.forEach(function (button) {
    button.onclick = function () {
        modal.style.display = "block";


        // '전체' 버튼 추가
        areaSelectionDiv.innerHTML = ""; // 기존 버튼들을 초기화
        let allButton = document.createElement("button");
        allButton.classList.add("area-btn", "selected");
        allButton.textContent = "전체";
        areaSelectionDiv.appendChild(allButton);

        areaCode = button.querySelector(".area__code").value;

        // AJAX로 시군구 데이터 가져오기
        $.ajax({
            url: `/get-sigungu?area=${areaCode}`,
            type: 'GET',
            dataType: 'json',
            success: function (response) {
                sigungus = response.body.sigunguDtos; // 시군구 데이터를 areas에 추가
                // 지역 이름 표시
                $(".modal__area").text(response.body.name);
                generateAreaButtons(); // 받은 데이터를 이용해 버튼 생성

                console.log(response);
                console.log(sigungus);
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
    // '전체' 버튼은 한 번만 생성
    areaSelectionDiv.innerHTML = ""; // 기존 버튼들을 초기화
    let allButton = document.createElement("button");
    allButton.classList.add("area-btn", "selected");
    allButton.textContent = "전체"; // '전체' 버튼 텍스트 설정
    allButton.setAttribute("id", "all-btn"); // '전체' 버튼에 ID 추가

    // '전체' 버튼 클릭 이벤트 설정
    allButton.addEventListener("click", function () {
        // 모든 하위지역 버튼의 'selected' 클래스를 제거
        document.querySelectorAll(".area-btn").forEach(function (btn) {
            if (btn !== allButton) { // '전체' 버튼은 제외
                btn.classList.remove("selected");
            }
        });
        // '전체' 버튼에 'selected' 클래스 추가
        allButton.classList.add("selected");

        // 하위 지역 코드를 비움
        sigunguCode = [];
    });

    // '전체' 버튼을 DOM에 추가
    areaSelectionDiv.appendChild(allButton);

    // 그 다음에 하위지역 버튼들을 동적으로 생성 (전체 제외)
    sigungus.forEach(function (area) {
        let button = document.createElement("button");
        button.classList.add("area-btn");
        button.textContent = area.name; // 시군구 이름을 버튼에 표시
        button.setAttribute("data-code", area.code); // 시군구 코드 저장

        // 하위지역 버튼 클릭 이벤트 설정
        button.addEventListener("click", function () {
            // '전체' 버튼 선택 해제
            allButton.classList.remove("selected");

            // 현재 클릭한 하위지역 버튼의 선택 상태를 토글
            button.classList.toggle("selected");

            // 선택된 하위지역 버튼을 확인하여 처리
            let selectedAreas = document.querySelectorAll(".area-btn.selected:not(#all-btn)");

            // 선택된 하위지역이 없으면 '전체' 버튼을 다시 선택
            if (selectedAreas.length === 0) {
                allButton.classList.add("selected");
                sigunguCode = [];
            } else {
                // 선택된 하위지역 버튼들의 코드를 sigunguCode에 저장
                sigunguCode = Array.from(selectedAreas).map(function (area) {
                    return area.getAttribute("data-code");
                });
            }
        });

        // 동적으로 생성된 하위지역 버튼을 DOM에 추가
        areaSelectionDiv.appendChild(button);
    });
}


// 검색 버튼 클릭 시 AJAX로 areaCode와 sigungu code 전송
searchBtn.addEventListener("click", function () {
    // "전체" 버튼이 선택된 경우 sigunguCode는 비워둠
    let isAllSelected = document.querySelector(".area-btn:first-child").classList.contains("selected");

    // 쿼리스트링을 만들기 위한 배열 생성
    sigunguQueries = '';
    if (!isAllSelected && sigunguCode.length > 0) {
        sigunguQueries = sigunguCode.map(function (code) {
            return `sigungu=${code}`;
        }).join('&');
    }

    if (placeLink.classList.contains("active")) {
        category = 'touristAttractions';
    } else if (foodLink.classList.contains("active")) {
        category = 'restaurants';
    }

    let url = `/get-hotplace?category=${category}&area=${areaCode}`;
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
            makePageList(response);
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
        let placeList = response.body.contents;

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

                        <button class="like__btn" onclick="toggleLike(this)">
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
    if (!placeLink.classList.contains("active")) {
        toggleActive(placeLink, foodLink);
        category = 'touristAttractions';
        $(".rec__text").text("인기 여행지");
        printList();
    }
});

foodLink.addEventListener("click", function (event) {
    event.preventDefault();
    if (!foodLink.classList.contains("active")) {
        toggleActive(foodLink, placeLink);
        category = 'restaurants';
        $(".rec__text").text("인기 맛집");
        printList();
    }
});

function toggleActive(activeLink, inactiveLink) {
    activeLink.classList.add("active");
    inactiveLink.classList.remove("active");
}

// 인기 여행지, 맛집 데이터를 AJAX로 불러오기
function printList(page) {
    console.log("category", category);
    console.log("areaCode", areaCode);


    let url = `/get-hotplace?category=${category}&area=${areaCode}`;
    if (sigunguQueries) {
        url += `&${sigunguQueries}`;
    }
    //지역, 시군구 코드가 정해지지 않았으면 지역 선택 안 한 것 -> 전체 리스트에서 카테고리만 변경
    if (areaCode === undefined && sigunguQueries === '') {
        url = `/get-hotplace?category=${category}`;
    }

    if (page) {
        url += '&page=' + page;
    }

    $.ajax({
        url: url,
        type: 'GET',
        dataType: 'json',
        success: function (response) {
            console.log("검색 결과:", response);
            loadHotPlace(response);
            makePageList(response);
        },
        error: function (error) {
            console.error("검색 에러:", error);
        }
    });
}


// 컨텐츠 박스 전체를 a링크가 감싸고 있는데 내부에 좋아요 버튼과 사진 선택 dot 버튼은 a링크 영향 안 받게.
$('.like__btn, .dot__btn').on('click', function (event) {
    event.preventDefault(); // 상위 <a> 태그의 기본 동작(링크 이동) 방지
});


function makePageList(response) {
    // 응답이 오면 기존 page리스트를 지움
    console.log(response)
    if (response.body) {
        $(".page__box").empty();
        console.log("ok");

        // fetch는 데이터를 받아서 .json()으로 파싱(json -> js object)해줘야 하는데
        // ajax의 success 콜백 함수는 json -> js object로 자동 파싱된다. 그냥 쓰면 됨
        let pageInfo = response.body;

        // 계산한 페이지를 그리기
        $(".page__box").prepend(printPageList(pageInfo));
        let pageArr = pageInfo.numbers;
        for (let i = pageArr[0]; i <= pageArr[pageArr.length - 1]; i++) {
            $(".page__count__box").append(printPageListNumber(i));
        }
        if (pageInfo.first == true) {
            // remove로 첫 페이지에서는 화살표 지워도 괜찮은 것 같다. prop은 button, input에만 적용돼서 add클래스로 추가하고 css에서 opacity와 이벤트 클릭방지 처리
            $(".prev__btn").addClass("disabled");
        } else {
            $(".prev__btn").removeClass("disabled");
        }

        console.log("first", pageInfo.first);
        if (pageInfo.last == true) {
            $(".next__btn").addClass("disabled");
        } else {{
            $(".next__btn").removeClass("disabled");
        }}
        console.log("last", pageInfo.last);


    } else {
        $(".page__box").prepend('<h2>검색 결과가 없습니다.</h2>');
    }


}

function printPageList(pageInfo) {
    return `
                        <ul class="pagination justify-content-center">
                        <li class="page-item prev__btn"><a class="page-link" href="#" onClick='printList(${pageInfo.prev});'>&lt;</a></li>
                        
                        <li class="page-item page__count__box"></li>
                        
                        <li class="page-item next__btn"><a class="page-link" href="#" onClick='printList(${pageInfo.next});'>&gt;</a></li>
                    </ul>
    `;
}

function printPageListNumber(number) {
    return `
                <a class="page-link" href="#" onClick="printList(${number});">${number}</a>
    `;
}




