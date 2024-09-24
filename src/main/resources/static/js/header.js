$(function () {
    // 검색어 저장 배열 (쿠키에서 로드)
    let searchKeywords = getCookie('searchKeywords') ? JSON.parse(getCookie('searchKeywords')) : [];
    // 검색어 저장 배열
    //let searchKeywords = [];


    // input-group 클릭 시 모달 열기
    $('.input-group').on('click', function () {
        $('#search__modal').fadeIn(); // 모달을 페이드인으로 표시
        $('.modal__search input').focus();

        // 최근 검색어
        // 배열에 값이 있으면 로딩
        if (searchKeywords.length > 0) {
            // 기존 검색어 목록 초기화
            $('.recent__searches').empty();

            // 배열의 값을 <ul>에 동적으로 추가
            searchKeywords.forEach(function (recentKeyword) {
                $('.recent__searches').prepend(`
                        <li>${recentKeyword} <button class="delete__btn">X</button></li>
                    `);
            });
        }


    });


    // 모달 바깥을 클릭하면 모달 닫기
    $('#search__modal').on('click', function (e) {
        if ($(e.target).is('#search__modal')) {
            $('#search__modal').fadeOut(); // 모달을 페이드아웃으로 닫기
            $('.searching__keyword').val("");
        }
    });


//검색 버튼 클릭시
    $('.btn-primary').on('click', function () {
        let keyword = $('.searching__keyword').val().trim();
        console.log(keyword);

        let recentKeyword = $('.searching__keyword').val().trim();

        if (recentKeyword.trim() !== '') {
            // 검색어를 배열에 추가 (중복 제거)
            searchKeywords = searchKeywords.filter(keyword => keyword.trim() !== recentKeyword);
            searchKeywords.push(recentKeyword);

            // 최대 10개의 최근 검색어만 유지
            if (searchKeywords.length > 8) {
                searchKeywords.shift();
            }

            // 쿠키에 검색어 목록 저장
            updateSearchKeywordsInCookie();

            // 화면에 업데이트
            updateRecentSearches();

            // <ul>에 동적으로 추가
            $('.recent__searches').prepend(`
                <li>${recentKeyword} <button class="delete__btn">X</button></li>
            `);

            // 검색어 입력 필드 초기화
            $('.searching__keyword').val('');


            //페이지 이동
            if (keyword == '') {
                return;
            }
            //해보고 특수문자 문제 생기면 encodeURIComponent
            let url = `/hotplace?keyword=${keyword}`
            window.location.href = url;


        }


    });


//검색창에서 엔터치면 검색
    $('.searching__keyword').on('keydown', function (e) {
        if (e.keyCode === 13) { // 엔터 키 감지
            $('.btn-primary').trigger('click'); // 검색 버튼 클릭 이벤트 실행
        }
    });


// 최근 검색어 클릭 시 검색창에 해당 검색어 넣기
    $(document).on('click', '.recent__searches li', function () {
        let selectedKeyword = $(this).text().trim().slice(0, -1); // 'X'를 제외한 텍스트만 가져옴
        $('.searching__keyword').val(selectedKeyword); // 검색창에 선택한 검색어 넣기
    });

    // 검색어 삭제 기능
    $(document).on('click', '.delete__btn', function (e) {
        e.stopPropagation(); // delete 버튼 눌렀을 때 li 클릭 이벤트 방지
        // 삭제할 검색어 가져오기 ('X'를 제외한 텍스트)
        let keywordToRemove = $(this).parent().text().trim().slice(0, -1);

        // 배열에서 검색어 제거. 공백 제거를 해줘야 확실하다.
        searchKeywords = searchKeywords.filter(recentKeyword => recentKeyword.trim() !== keywordToRemove.trim());
        console.log(searchKeywords);

        // 쿠키 업데이트
        updateSearchKeywordsInCookie();


        // 해당 검색어를 포함한 <li> 요소만 삭제
        $(this).parent().remove();
    });


    // 쿠키에 저장하는 함수
    function setCookie(name, value, days) {
        let expires = "";
        if (days) {
            let date = new Date();
            date.setTime(date.getTime() + (days * 24 * 60 * 60 * 1000));
            expires = "; expires=" + date.toUTCString();
        }
        document.cookie = name + "=" + (value || "") + expires + "; path=/";
    }

    // 쿠키에서 값 가져오는 함수
    function getCookie(name) {
        let nameEQ = name + "=";
        let ca = document.cookie.split(';');
        for (let i = 0; i < ca.length; i++) {
            let c = ca[i];
            while (c.charAt(0) === ' ') c = c.substring(1, c.length);
            if (c.indexOf(nameEQ) === 0) return c.substring(nameEQ.length, c.length);
        }
        return null;
    }

    // 쿠키 삭제 함수
    function deleteCookie(name) {
        document.cookie = name + '=; Max-Age=0; path=/;';
    }

    // 검색어 목록을 쿠키에 저장하는 함수
    function updateSearchKeywordsInCookie() {
        setCookie('searchKeywords', JSON.stringify(searchKeywords), 7); // 7일 동안 저장
    }


    // 검색어 목록을 화면에 업데이트하는 함수
    function updateRecentSearches() {
        $('.recent__searches').empty(); // 기존 목록 초기화

        searchKeywords.forEach(function (recentKeyword) {
            $('.recent__searches').prepend(`
                <li>${recentKeyword} <button class="delete__btn">X</button></li>
            `);
        });
    }


});


