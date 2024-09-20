insert into user_tb(login_id, password, profile, nick_name, email, phone)
values ('ssar', '1234','/profileimg/man_img.png','hapssar', 'ssar@nate.com','010-1234-5678');

insert into festivalinfo_tb(content_id, contenttypeid, eventenddate, eventplace, event_start_date, origin_img_url, title)
values ('734219', '15', '20240929', '강원특별자치도 동해시', '20240926','https://tong.visitkorea.or.kr/cms/resource/14/3357214_image2_1.jpg', '동해 무릉제');
insert into festivalinfo_tb(content_id, contenttypeid, eventenddate, eventplace, event_start_date, origin_img_url, title)
values ('3365655', '15', '20240929', '충청북도 제천시', '20240927','https://tong.visitkorea.or.kr/cms/resource/65/3365565_image2_1.jpg', '코리아 튜닝카 페스티벌');
insert into festivalinfo_tb(content_id, contenttypeid, eventenddate, eventplace, event_start_date, origin_img_url, title)
values ('2616316', '15', '20240928', '경기도 수원시', '20240927','https://tong.visitkorea.or.kr/cms/resource/57/3352057_image2_1.JPG', '수원재즈페스티벌');

insert into scrap_tb(is_scrap, user_id, content_content_id)
values (true, 1, 2863965);
insert into scrap_tb(is_scrap, user_id, content_content_id)
values (true, 1, 2781669);