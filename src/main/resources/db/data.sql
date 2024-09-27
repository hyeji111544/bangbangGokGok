insert into user_tb(login_id, password, profile, nick_name, email, phone)
values ('ssar', '1234','/profileimg/man_img.png','hapssar', 'ssar@nate.com','010-1234-5678');

-- insert into festivalinfo_tb(content_id, content_type_id, event_end_date, event_place, event_start_date, origin_img_url, title)
-- values ('734219', '15', '20240929', '강원특별자치도 동해시', '20240926','https://tong.visitkorea.or.kr/cms/resource/14/3357214_image2_1.jpg', '동해 무릉제');
-- insert into festivalinfo_tb(content_id, content_type_id, event_end_date, event_place, event_start_date, origin_img_url, title)
-- values ('3365655', '15', '20240929', '충청북도 제천시', '20240927','https://tong.visitkorea.or.kr/cms/resource/65/3365565_image2_1.jpg', '코리아 튜닝카 페스티벌');
-- insert into festivalinfo_tb(content_id, content_type_id, event_end_date, event_place, event_start_date, origin_img_url, title)
-- values ('2616316', '15', '20240928', '경기도 수원시', '20240927','https://tong.visitkorea.or.kr/cms/resource/57/3352057_image2_1.JPG', '수원재즈페스티벌');

insert into festivalinfo_tb(content_id, title, content_type_id, event_start_date, event_end_date, event_place, sponsor1, sponsor1tel, sponsor2, sponsor2tel, zip_code, addr1, addr2, first_image, first_image2, home_page, img_name, info_name, overview, mapx, mapy, play_time, tel, tel_name, area_code, sigungu_code, origin_img_url, use_time_festival, info_text)
values ('631268', '한화와 함께하는 서울세계불꽃축제', '15', '20241005', '20241005', '여의도 한강공원 일대', '한화그룹, SBS', '02-519-9778', '(주) 한화,한화생명,한화손해보험,한화에어로스페이스,한화토탈에너지스,한화솔루션,한화투자증권,한화시스템,한화비전,한화임팩트,한화자산운용', '', '07337', '서울특별시 영등포구 여의동로 330 (여의도동)', '', 'http://tong.visitkorea.or.kr/cms/resource/77/3357677_image2_1.jpg', 'http://tong.visitkorea.or.kr/cms/resource/77/3357677_image3_1.jpg', '<a href=\"https://www.hanwhafireworks.com/kor/main.html\" target=\"_blank\" title=\"새창 : 한화와 함께하는 서울세계불꽃축제 홈페이지 이동\">www.hanwhafireworks.com</a>', '2024 한화와 함께하는 서울세계불꽃축제 포스터', '행사소개', '서울세계불꽃축제는 바쁜 매일을 살아가는 시민의 일상에 즐거움을 선사하기 위해 한화그룹에서 2000년부터 사회공헌 사업으로 꾸준히 진행해 온 축제이다.<br>매년 세계적인 수준의 불꽃 전문 기업들이 초청되어 여의도의 밤 하늘을 무대로 환상적인 불꽃 연출을 선보이며,<br>주간에도 다채로운 부대행사가 진행된다.<br>(주)한화가 자랑하는 멀티미디어 불꽃쇼는 불꽃과 음악, 레이저 연출이 결합된 아시아 최고 수준의 불꽃쇼이다.', '126.9336095794', '37.5263997727', '13:00~21:30', '02-519-9778', '한화그룹, SBS', '1', '20', 'http://tong.visitkorea.or.kr/cms/resource/78/3357678_image2_1.jpg', '무료 (일부 관람석 유료화)', '- 시민참여 프로그램<br>- 공식행사 및 불꽃쇼');

-- INSERT INTO festivalinfo_tb (addr1, addr2, area_code, content_id, first_image, first_image2, mapx, mapy, sigungu_code, tel, title, zip_code) VALUES ('강원특별자치도 동해시 덕골길 10 (천곡동)', '', '32', '734219', 'http://tong.visitkorea.or.kr/cms/resource/14/3357214_image2_1.jpg', 'http://tong.visitkorea.or.kr/cms/resource/14/3357214_image3_1.jpg', '129.1028194007', '37.5149722608', '6', '033-532-1945', '동해 무릉제', '25750');


--insert into scrap_tb(is_scrap, user_id, content_content_id)
--values (true, 1, 2863965);
--insert into scrap_tb(is_scrap, user_id, content_content_id)
--values (true, 1, 2781669);

--insert into review_tb(user_id, is_deleted, context, content_id_content_id, rating, created_at)values(1, false, '22222', 126289, 4.5, now());
--insert into review_tb(user_id, is_deleted, context, content_id_content_id, rating, created_at)values(1, false, '감사합니다', 126289, 4, now());





-- insert into festivalinfo_tb (content_id, content_type_id) values (3021762, 15);
-- insert into festivalinfo_tb (content_id, content_type_id) values (3020141, 15);
--
--insert into review_tb(user_id, is_deleted, context, content_id_content_id, rating, created_at)values(1, false, '감사합니다',734219, 4.5, now());
-- insert into review_tb(user_id, is_deleted, context, content_id_content_id, festival_info_content_id, rating)
-- values(1,false, '감사합니다', 3021762, 3021762, 3.5);
-- insert into review_tb(user_id, is_deleted, context, content_id_content_id, festival_info_content_id, rating)
-- values(1,false, '안녕하세요', 3020141, 3020141, 5);