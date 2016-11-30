
/* Drop Tables */

DROP TABLE coupon CASCADE CONSTRAINTS;
DROP TABLE event CASCADE CONSTRAINTS;
DROP TABLE notice CASCADE CONSTRAINTS;
DROP TABLE pr_reply CASCADE CONSTRAINTS;
DROP TABLE reservation CASCADE CONSTRAINTS;
DROP TABLE pub CASCADE CONSTRAINTS;
DROP TABLE question CASCADE CONSTRAINTS;
DROP TABLE r_social CASCADE CONSTRAINTS;
DROP TABLE social CASCADE CONSTRAINTS;
DROP TABLE talk CASCADE CONSTRAINTS;
DROP TABLE members CASCADE CONSTRAINTS;
DROP TABLE Stars CASCADE CONSTRAINTS;



/* Drop Sequences */

DROP SEQUENCE SEQ_coupon_c_num;
DROP SEQUENCE SEQ_event_e_num;
DROP SEQUENCE SEQ_notice_n_num;
DROP SEQUENCE SEQ_pr_reply_pr_num;
DROP SEQUENCE SEQ_pub_p_num;
DROP SEQUENCE SEQ_question_q_num;
DROP SEQUENCE SEQ_question_qr_num; 
DROP SEQUENCE SEQ_reservation_res_num;
DROP SEQUENCE SEQ_r_social_rs_num;
DROP SEQUENCE SEQ_social_s_num;
DROP SEQUENCE SEQ_talk_t_num;





/* Create Sequences */

CREATE SEQUENCE SEQ_coupon_c_num INCREMENT BY 1 START WITH 1 nocache nocycle;
CREATE SEQUENCE SEQ_event_e_num INCREMENT BY 1 START WITH 1 nocache nocycle;
CREATE SEQUENCE SEQ_notice_n_num INCREMENT BY 1 START WITH 1 nocache nocycle;
CREATE SEQUENCE SEQ_pr_reply_pr_num INCREMENT BY 1 START WITH 1 nocache nocycle;
CREATE SEQUENCE SEQ_pub_p_num INCREMENT BY 1 START WITH 1 nocache nocycle;
CREATE SEQUENCE SEQ_question_q_num INCREMENT BY 1 START WITH 1 nocache nocycle;
CREATE SEQUENCE SEQ_question_qr_num INCREMENT BY 1 START WITH 1 nocache nocycle;
CREATE SEQUENCE SEQ_reservation_res_num INCREMENT BY 1 START WITH 1 nocache nocycle;
CREATE SEQUENCE SEQ_r_social_rs_num INCREMENT BY 1 START WITH 1 nocache nocycle;
CREATE SEQUENCE SEQ_social_s_num INCREMENT BY 1 START WITH 1 nocache nocycle;
CREATE SEQUENCE SEQ_talk_t_num INCREMENT BY 1 START WITH 1 nocache nocycle;



/* Create Tables */

CREATE TABLE coupon
(
	c_num number(7,0) NOT NULL,
	id varchar2(128) NOT NULL,
	c_contents varchar2(128) NOT NULL,
	c_coupon varchar2(1000) NOT NULL,
	c_date varchar2(128) NOT NULL,
	c_use char NOT NULL,
	PRIMARY KEY (c_num)
);


CREATE TABLE event
(
	id varchar2(128) NOT NULL,
	e_num number(3,0) NOT NULL,
	e_title varchar2(128) NOT NULL,
	e_contents varchar2(2000) NOT NULL,
	e_viewcnt number(10,0) NOT NULL,
	e_upload varchar2(1000),
	e_uploads varchar2(1000),
	e_date varchar2(128) NOT NULL,
	PRIMARY KEY (e_num)
);


CREATE TABLE members
(
	id varchar2(128) NOT NULL,
	pw varchar2(128) NOT NULL,
	phone varchar2(128) NOT NULL,
	email varchar2(128) NOT NULL,
	email_agree char,
	sex char NOT NULL,
	name varchar2(128) NOT NULL,
	birth varchar2(128) NOT NULL,
	userchk char NOT NULL,
	face varchar2(1000),
	allow_chk char NOT NULL,
	login_time varchar2(128) NOT NULL,
	saupja_num varchar2(2000),
	dates varchar2(2000) NOT NULL,
	PRIMARY KEY (id)
);


CREATE TABLE notice
(
	id varchar2(128) NOT NULL,
	n_num number(3,0) NOT NULL,
	n_title varchar2(128) NOT NULL,
	n_contents varchar2(2000) NOT NULL,
	n_viewcnt number(10,0) NOT NULL,
	n_date varchar2(128) NOT NULL,
	PRIMARY KEY (n_num)
);


CREATE TABLE pr_reply
(
	pr_num number(5,0) NOT NULL,
	id varchar2(128) NOT NULL,
	p_num number(5,0) NOT NULL,
	pr_content varchar2(2000),
	PRIMARY KEY (pr_num)
);


CREATE TABLE pub
(
	p_num number(5,0) NOT NULL,
	id varchar2(128) NOT NULL UNIQUE,
	p_mupload varchar2(3000),
	p_supload varchar2(1000),
	p_title varchar2(128) NOT NULL,
	p_contents varchar2(3000) NOT NULL,
	p_address varchar2(1000) NOT NULL,
	p_maxpeople number(3,0) NOT NULL,
	p_pub_chk char NOT NULL,
	p_addr_post varchar2(1000) NOT NULL,
	PRIMARY KEY (p_num)
);


CREATE TABLE question
(
   id varchar2(128) NOT NULL,
   q_num number(3,0) NOT NULL,   
   q_title varchar2(128) NOT NULL,
   q_contents varchar2(2000) NOT NULL,
   q_viewcnt number(10,0) NOT NULL,
   q_upload varchar2(1000) ,
   q_date varchar2(128) NOT NULL,
   qr_num number(3,0) NOT NULL,
   qr_step number(10,0),
   qr_level number(10,0),
   PRIMARY KEY (q_num)
);

CREATE TABLE reservation
(
   res_num number(5,0) NOT NULL,
   p_num number(5,0) NOT NULL,
   id varchar2(128) NOT NULL,
   res_people number(5,0) NOT NULL,
   res_date varchar2(128) NOT NULL,
   res_concheck char,
   res_sellcheck char,
   res_time varchar2(128) NOT NULL,
   c_num number(7,0),
   PRIMARY KEY (res_num)
);

CREATE TABLE r_social
(
	s_num number(5,0) NOT NULL,
	rs_num number(5,0) NOT NULL,
	rs_contents varchar2(1000) NOT NULL,
	rs_like number(5,0) NOT NULL,
	id varchar2(128) NOT NULL,
	PRIMARY KEY (rs_num)
);


CREATE TABLE social
(
	s_num number(5,0) NOT NULL,
	id varchar2(128) NOT NULL,
	s_upload varchar2(1000),
	s_contents varchar2(1000) NOT NULL,
	s_like number(5,0) NOT NULL,
	s_date varchar2(128) NOT NULL,
	PRIMARY KEY (s_num)
);


CREATE TABLE talk
(
	t_num number(5,0) NOT NULL,
	id varchar2(128) NOT NULL,
	t_resp varchar2(128) NOT NULL,
	t_message varchar2(1000) NOT NULL,
	t_date varchar2(128) NOT NULL,
	t_check char NOT NULL,
	t_title varchar2(2000) NOT NULL,
	PRIMARY KEY (t_num)
);

CREATE TABLE Stars
(
	p_num number(5,0) NOT NULL,
	id varchar2(128) NOT NULL,
	s_stars number(10,0)
);


/* Create Foreign Keys */

ALTER TABLE coupon
	ADD CONSTRAINT FK_coupon_id FOREIGN KEY (id)
	REFERENCES members (id) ON DELETE CASCADE
;


ALTER TABLE event
	ADD CONSTRAINT FK_event_id FOREIGN KEY (id)
	REFERENCES members (id) ON DELETE CASCADE
;


ALTER TABLE notice
	ADD CONSTRAINT FK_notice_id FOREIGN KEY (id)
	REFERENCES members (id) ON DELETE CASCADE
;



ALTER TABLE pr_reply
	ADD CONSTRAINT FK_pr_reply_id FOREIGN KEY (id)
	REFERENCES members (id) ON DELETE CASCADE
;


ALTER TABLE pub
	ADD CONSTRAINT FK_pub_id  FOREIGN KEY (id)
	REFERENCES members (id) ON DELETE CASCADE
;


ALTER TABLE qr_reply
	ADD CONSTRAINT FK_qr_reply_id FOREIGN KEY (id)
	REFERENCES members (id) ON DELETE CASCADE
;


ALTER TABLE question
	ADD CONSTRAINT FK_question_id FOREIGN KEY (id)
	REFERENCES members (id) ON DELETE CASCADE
;


ALTER TABLE reservation
	ADD CONSTRAINT FK_reservation_id FOREIGN KEY (id) 
	REFERENCES members (id) ON DELETE CASCADE
;


ALTER TABLE r_social
	ADD CONSTRAINT FK_r_social_id FOREIGN KEY (id)
	REFERENCES members (id) ON DELETE CASCADE
;


ALTER TABLE social
	ADD CONSTRAINT FK_social_id FOREIGN KEY (id)
	REFERENCES members (id) ON DELETE CASCADE
;


ALTER TABLE talk
	ADD CONSTRAINT FK_talk_id FOREIGN KEY (id)
	REFERENCES members (id) ON DELETE CASCADE
;

ALTER TABLE pr_reply
	ADD CONSTRAINT FK_pr_reply_num FOREIGN KEY (p_num)
	REFERENCES pub (p_num) ON DELETE CASCADE
;


ALTER TABLE reservation
	ADD CONSTRAINT FK_reservation_num FOREIGN KEY (p_num)
	REFERENCES pub (p_num) ON DELETE CASCADE
;


ALTER TABLE r_social
	ADD CONSTRAINT FK_r_social_num FOREIGN KEY (s_num) 
	REFERENCES social (s_num) ON DELETE CASCADE
;

ALTER TABLE Stars
	ADD CONSTRAINT FK_Stars_id FOREIGN KEY (id)
	REFERENCES members (id) ON DELETE CASCADE
;

ALTER TABLE Stars
	ADD CONSTRAINT FK_Stars_num FOREIGN KEY (p_num)
	REFERENCES pub (p_num) ON DELETE CASCADE
;

