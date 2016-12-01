select * from members
select dates from members
select * from pub
	e_uploads varchar2(1000),
ALTER TABLE talk
ADD(t_title varchar2(2000) NOT NULL)

ALTER TABLE members
ADD dates varchar2(1000)


select * from stars
delete from talk

delete from members where id='selltest'

alter table pub modify(p_mupload varchar2(3000));

var newWindow = window.open("about:blank");
newWindow.location.href = 'http://www.daum.net';


<textarea class="form-control" rows="3"></textarea>

--제약조건 추가
ALTER TABLE coupon
	ADD CONSTRAINT FK_coupon_id FOREIGN KEY (id)
	REFERENCES members (id) ON DELETE CASCADE

--제약조건 확인
select * from user_constraints

--제약조건 삭제
ALTER TABLE pub
DROP CONSTRAINT sys_c004337


--등급조정
--customer 회원필요(구매자)
update members set userchk='S' where id='snowwalk';
update members set birth='1985-09-02';
--sell2 회원필요(판매자)
--cus2 예약 삭제 회원필요(구매자)  11/14추가
--sell3 회원필요(등업테스트) 11/15추가
update members set userchk='C' where id='customer';
update members set userchk='S' where id='chopas1ze';
update members set userchk='A' where id='adminadmin';
update members set allow_chk='N' where id='cus';
update members set allow_chk='R' where id='sell2';
update members set allow_chk='Y' where id='selltest';
update members set email_agree='Y' where id='chopas1ze';

--coupon 등록
insert into coupon values(SEQ_coupon_c_num.nextval,'selltest','c_contents','c_coupon',to_char(sysdate+20,'YYYY"년"MM"월"DD"일"'),'N');
insert into coupon values(SEQ_coupon_c_num.nextval,'customer','c_contents2','c_coupon2',to_char(sysdate+20,'YYYY"년"MM"월"DD"일"'),'N');
insert into coupon values(SEQ_coupon_c_num.nextval,'sell','c_contents','c_coupon',to_char(sysdate+20,'YYYY"년"MM"월"DD"일"'),'N');
select * from coupon
update coupon set c_use='Y' where c_num=15


--pub 등록
insert into pub values(SEQ_pub_p_num.nextval,'sell','abcd.jpg','efgh.jpg','title','contents','address','20','Y','205-222');
insert into pub values(SEQ_pub_p_num.nextval,'sell2','mupload','supload','title','contents','address','15','N');
select * from pub
delete from pub 
update pub set p_pub_chk='Y' where id='chopas1ze'
 

--reservation 등록
insert into reservation values(SEQ_reservation_res_num.nextval,2,'customer','10',to_char(sysdate,'YYYY"년"MM"월"DD"일"'),'Y','N',to_char(sysdate,'HH"시'),15);
insert into reservation values(SEQ_reservation_res_num.nextval,2,'customer','8',to_char(sysdate,'YYYY"년"MM"월"DD"일"'),'Y','N',to_char(sysdate,'HH"시'));
insert into reservation values(SEQ_reservation_res_num.nextval,1,'cus','7',to_char(sysdate,'YYYY"년"MM"월"DD"일"'),'Y','N',to_char(sysdate,'HH"시'));
--11/14 추가
insert into reservation values(SEQ_reservation_res_num.nextval,1,'customer','9',to_char(sysdate,'YYYY"년"MM"월"DD"일"'),'Y','N',to_char(sysdate,'HH"시'));
insert into reservation values(SEQ_reservation_res_num.nextval,2,'cus','7',to_char(sysdate,'YYYY"년"MM"월"DD"일"'),'Y','N',to_char(sysdate,'HH"시'));
insert into reservation values(SEQ_reservation_res_num.nextval,2,'cus2','16',to_char(sysdate,'YYYY"년"MM"월"DD"일"'),'Y','N',to_char(sysdate,'HH"시'));

select * from reservation
update reservation set c_num=13 where res_num=6
update reservation set res_sellcheck='Y' where res_num=3
delete from reservation 

--소셜 등록
insert into social values(SEQ_social_s_num.nextval,'selltest','나.jpg','efgh.jpg',5,'adf');
delete from social
--퀘스천 등록
insert into question values('selltest',SEQ_question_q_num.nextval,'12','df',5,'마.jpg','adf',SEQ_question_qr_num.nextval,5,6)
delete from question


--쪽지 등록
insert into talk values(SEQ_talk_t_num.nextval,'sell','cus','내용','2016-05-09 15:22:23','N','가나다')


--쿠폰 출력(사용자 정보포함)
select m.*, c.c_num,c.id as ccid, c.c_contents, c.c_coupon, c.c_date,c.c_use, r.p_num as rpnum,p.p_title
from(select * from members where id='customer')m , coupon c, reservation r, pub p
where m.id=c.id(+) and c.c_num=r.c_num(+) and r.p_num = p.p_num(+)

delete from coupon where id ='customer'


--구매자 예약현황
select rownum, a.*
from(select m.*, r.res_num, r.p_num, r.id as rrid ,r.res_people, r.res_date, r.res_concheck, r.res_sellcheck,r.res_time,r.c_num, p.p_title
from members m, reservation r, pub p
where m.id=r.id(+) and r.p_num=p.p_num(+) and m.id='cus'
order by r.res_num)a
where rownum<=4	


--판매자 예약현황
/* 
select z.*
from(select rownum as rm, b.* 
from(select a.*
from(select p.*, r.res_num,r.p_num as rpnum , r.id as rrid, r.res_people,r.res_date,r.res_concheck,r.res_sellcheck,r.res_time,r.c_num,m.name,c.c_use,c.c_contents
from(select * from pub where id='sell')p,  reservation r, members m, coupon c
where p.p_num=r.p_num(+) and  r.id=m.id(+) and r.c_num=c.c_num(+)
order by r.res_num desc)a)b 
where b.res_sellcheck='N')z
where z.rm<=4
*/

select b.*
from(select rownum as rm,a.*
from(select p.*, r.res_num,r.p_num as rpnum , r.id as rrid, r.res_people,r.res_date,r.res_concheck,r.res_sellcheck,r.res_time,r.c_num,m.name,c.c_use,c.c_contents
from(select * from pub where id='selltest')p,  reservation r, members m, coupon c
where p.p_num=r.p_num(+) and  r.id=m.id(+) and r.c_num=c.c_num(+)
order by r.res_num desc)a)b
where b.rm<=4 




--어드민 : 판매자 등업 신청 현황
select rownum, a.*
from(select * from members where allow_chk='R'
order by id)a 
where rownum<=3

--어드민 : PUB 신청 현황
select rownum, a.*
from(select p.*,m.name from pub p, members m where p.id=m.id and p.p_pub_chk='N')a
where rownum<=3

--구매자 예약리스트 삭제
delete from reservation where id='cus2' and res_num=7

--판매자 예약신청 수락
update reservation set res_sellcheck='Y' where res_num=7

--판매자 예약신청 거부
update reservation set res_sellcheck='C' where res_num=7

--어드민 : 판매자 신청 수락 
update members set userchk='S', allow_chk='Y' where id='sell'
insert into talk values(SEQ_talk_t_num.nextval,'admin','sell','판매자로 등급 조정되었습니다. PUB 등록 신청이 가능합니다.',to_char(sysdate,'MM"월"DD"일" HH:MI'),'N')
select * from talk
delete from talk

--어드민 : 판매자 신청 거부
 update members set allow_chk='N' where id='sell'
 insert into talk values(SEQ_talk_t_num.nextval,'admin','sell','판매자 등급 신청이 취소되었습니다.',to_char(sysdate,'MM"월"DD"일" HH:MI'),'N')
 
--펍등록 신청 현황(미구현)

 --회원 탈퇴 필요한 정보(mem+소유pub)
select m.* , p.p_title
from members m, pub p
where m.id=p.id(+) and m.id='cus'
 
 --회원 탈퇴
 delete from members where id = 'sell2'
 
 --회원이 가진 사진 검색
 select m.id,m.face,p.p_mupload,p.p_supload, s.s_upload, q.q_upload
 from members m, pub p, social s, question q
 where m.id=p.id(+) and m.id=s.id(+) and m.id=q.id(+) and m.id='selltest'
 
 
 --판매자 신청
 update members set saupja_num=#{saupja_num}, allow_chk=#{allow_chk} where id=#{id}

--판매자가 쿠폰사용 Y로 체인지
update coupon set c_use='Y' where c_num=#{cnum}


--판매자의 예약수
select count(*) from(select p.*,r.*
from(select * from pub where id='sell')p, reservation r
where p.p_num=r.p_num(+))

--판매자의 총 예약 리스트
select b.*
from(select rownum as rm,a.*
from(select p.*, r.res_num,r.p_num as rpnum , r.id as rrid, r.res_people,r.res_date,r.res_concheck,r.res_sellcheck,r.res_time,r.c_num,m.name,c.c_use,c.c_contents
from(select * from pub where id='sell')p,  reservation r, members m, coupon c
where p.p_num=r.p_num(+) and  r.id=m.id(+) and r.c_num=c.c_num(+)
order by r.res_num desc)a)b
where b.rm>=1 and b.rm<=13

--펍 수정 정보
select m.* , p.p_num,p.id as ppid , p.p_mupload, p.p_supload, p.p_title, p.p_contents, p.p_address, p.p_maxpeople, p.p_pub_chk
from members m, pub p
where m.id=p.id(+) and m.id='selltest'

--기존 펍 첨부파일 삭제
select p_mupload from pub where id='sell'
select p_supload from pub where id='sell'

--받은 쪽지함 갯수
select count(*) from(select * from talk where t_resp='sell')

--받은 쪽지함
select b.*
from(select rownum as rm, a.*
from(select * from talk where t_resp='sell' order by t_num desc)a)b
where b.rm>=1 and b.rm<=7 

--받은 쪽지  쪽지삭제
delete from talk
where t_num in(1,2)

--받은 쪽지 제목 검색갯수
select count(*)
from(select * from talk where t_resp='sell' and t_title like '%' || '제목' || '%')

--받은 쪽지  제목 검색 리스트
select b.*
from(select rownum as rm, a.*
from(select * from talk where t_resp='sell' and t_title like '%' || '제목' || '%' order by t_num desc)a)b
where b.rm>=1 and b.rm<=7

select * from talk
--받은 쪽지 내용 검색갯수 
select count(*)
from(select * from talk where t_resp='sell' and t_message like '%' || '방가' || '%')

--받은 쪽지 내용 검색 리스트
select b.*
from(select rownum as rm, a.*
from(select * from talk where t_resp='sell' and t_message like '%' || '방가' || '%' order by t_num desc)a)b
where b.rm>=1 and b.rm<=7

--받은 쪽지 제목+내용 검색갯수
select count(*)
from(select * from talk where t_resp='sell' and t_message like '%' || '방가' || '%' or id='sell' and t_title like  '%' || '가나다' || '%')

--받은 쪽지 제목+내용 검색 리스트
select b.*
from(select rownum as rm, a.*
from(select * from talk where t_resp='sell' and t_message like '%' || '방가' || '%' or id='sell' and t_title like  '%' || '가나다' || '%')a)b
where b.rm>=1 and b.rm<=7

--받은 쪽지 ID 검색 갯수
select count(*)
from(select * from talk where t_resp='sell' and id='cus')a

--받은 쪽지 ID 검색 리스트
select b.*
from(select rownum as rm, a.*
from(select * from talk where t_resp='sell' and id='cus')a)b
where b.rm>=1 and b.rm<=7

--보낸 쪽지함 갯수
select count(*) from(select * from talk where id='sell')

--보낸 쪽지함 리스트
select b.*
from(select rownum as rm, a.*
from(select * from talk where id='sell' order by t_num desc)a)b
where b.rm>=1 and b.rm<=7 

--보낸 쪽지함 제목 검색 갯수
select count(*)
from(select * from talk where id='sell' and t_title like '%' || '가나다' || '%')

--보낸 쪽지함 제목 검색 리스트
select b.*
from(select rownum as rm, a.*
from(select * from talk where id='sell' and t_title like '%' ||'가나다' || '%' order by t_num desc)a)b
where b.rm>=1 and b.rm<=7 

--보낸 쪽지함 내용 검색 갯수
select count(*)
from(select * from talk where id='sell' and t_message like '%' || '가나다' || '%')

--보낸 쪽지함 내용 검색 리스트
select b.*
from(select rownum as rm, a.*
from(select * from talk where id='sell' and t_message like '%' || '가나다' || '%' order by t_num desc)a)b
where b.rm>=1 and b.rm<=7

--보낸 쪽지함 제목+내용 검색 갯수
select count(*)
from(select * from talk where id='sell' and t_message like '%' || '가나다' || '%' or id='sell' and t_title like  '%' || '가나다' || '%')

--보낸 쪽지함 제목+내용 검색 리스트
select b.*
from(select rownum as rm, a.*
from(select * from talk where id='sell' and t_message like '%' ||  '가나다'  || '%' or id='sell' and t_title like  '%' ||  '가나다' || '%')a)b
where b.rm>=1 and b.rm<=7 


--보낸 쪽지함 ID 검색 갯수
select count(*)
from(select * from talk where id='sell' and t_resp='cus')a


--보낸 쪽지함 ID 검색 리스트
select b.*
from(select rownum as rm, a.*
from(select * from talk where  id='sell' and t_resp='cus')a)b
where b.rm>=1 and b.rm<=7


select * from talk
--쪽지 쓰기
insert into talk values(SEQ_talk_t_num.nextval,'cus','sell','message',to_char(sysdate,'YYYY"-"MM"-"DD HH24:MI:SS'),'N','t_title')

--받은 쪽지함 뷰 보기
select * from talk where t_num=7

--받은 쪽지함 뷰 삭제
delete from talk where t_num = 7



select m.* , p.p_num,p.id as ppid , p.p_mupload, p.p_supload, p.p_title, p.p_contents, p.p_address, p.p_maxpeople, p.p_pub_chk,p.p_addr_post
from members m, pub p
where m.id=p.id(+) and m.id='chopas1ze'