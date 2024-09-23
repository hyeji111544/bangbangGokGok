$(function() {
    // input-group 클릭 시 모달 열기
    $('.input-group').on('click', function() {
        $('#search__modal').fadeIn(); // 모달을 페이드인으로 표시
        $('.modal__search input').focus();
    });

    // 모달 바깥을 클릭하면 모달 닫기
    $('#search__modal').on('click', function(e) {
        if ($(e.target).is('#search__modal')) {
            $('#search__modal').fadeOut(); // 모달을 페이드아웃으로 닫기
        }
    });

    //검색 버튼 클릭시
    $(".btn-primary").on('click', function() {


    });

});

