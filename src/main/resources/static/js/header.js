$(function() {
    // 검색어 저장 배열
    let searchKeywords = [];




    // input-group 클릭 시 모달 열기
    $('.input-group').on('click', function() {
        $('#search__modal').fadeIn(); // 모달을 페이드인으로 표시
        $('.modal__search input').focus();

        // 최근 검색어
        // 배열에 값이 있으면 로딩
        if (searchKeywords.length > 0) {
            // 기존 검색어 목록 초기화
            $('.recent__searches').empty();

            // 배열의 값을 <ul>에 동적으로 추가
            searchKeywords.forEach(function(recentKeyword) {
                $('.recent__searches').prepend(`
                        <li>${recentKeyword} <button class="delete__btn">X</button></li>
                    `);
            });
        }



    });

    // 모달 바깥을 클릭하면 모달 닫기
    $('#search__modal').on('click', function(e) {
        if ($(e.target).is('#search__modal')) {
            $('#search__modal').fadeOut(); // 모달을 페이드아웃으로 닫기
            $('.searching__keyword').val("");
        }
    });




    //검색 버튼 클릭시
    $('.btn-primary').on('click', function() {
        let keyword = $('.searching__keyword').val();
        console.log(keyword);




        let recentKeyword = $('.searching__keyword').val();

        if (recentKeyword.trim() !== '') {
            // 검색어를 배열에 추가
            searchKeywords.unshift(recentKeyword); // 검색어를 배열 앞에 추가

            // <ul>에 동적으로 추가
            $('.recent__searches').prepend(`
                <li>${recentKeyword} <button class="delete__btn">X</button></li>
            `);

            // 검색어 입력 필드 초기화
            $('.searching__keyword').val('');
            console.log("recentKeyword", recentKeyword);


            //페이지 이동


        }




        // 검색어 삭제 기능
        $(document).on('click', '.delete__btn', function(e) {
            e.stopPropagation(); // delete 버튼 눌렀을 때 li 클릭 이벤트 방지
            let keywordToRemove = $(this).parent().text().trim().slice(0, -1); // 'X'를 제외한 텍스트만 가져옴
            searchKeywords = searchKeywords.filter(recentKeyword => recentKeyword !== keywordToRemove); // 배열에서 제거
            $(this).parent().remove(); // 클릭한 항목 삭제
        });

        // 최근 검색어 클릭 시 검색창에 해당 검색어 넣기
        $(document).on('click', '.recent__searches li', function() {
            let selectedKeyword = $(this).text().trim().slice(0, -1); // 'X'를 제외한 텍스트만 가져옴
            $('.searching__keyword').val(selectedKeyword); // 검색창에 선택한 검색어 넣기
        });



    });

    $('.searching__keyword').on('keyup', function(e) {
        if (e.keyCode === 13) { // 엔터 키 감지
            $('.btn-primary').trigger('click'); // 검색 버튼 클릭 이벤트 실행
        }
    });






});


