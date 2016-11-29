
/* Drop Tables */

DROP TABLE coupon CASCADE CONSTRAINTS;
DROP TABLE event CASCADE CONSTRAINTS;
DROP TABLE map CASCADE CONSTRAINTS;
DROP TABLE notice CASCADE CONSTRAINTS;
DROP TABLE pr_reply CASCADE CONSTRAINTS;
DROP TABLE reservation CASCADE CONSTRAINTS;
DROP TABLE pub CASCADE CONSTRAINTS;
DROP TABLE qr_reply CASCADE CONSTRAINTS;
DROP TABLE question CASCADE CONSTRAINTS;
DROP TABLE r_social CASCADE CONSTRAINTS;
DROP TABLE social CASCADE CONSTRAINTS;
DROP TABLE talk CASCADE CONSTRAINTS;
DROP TABLE members CASCADE CONSTRAINTS;



/* Drop Sequences */

DROP SEQUENCE SEQ_coupon_c_num;
DROP SEQUENCE SEQ_event_e_num;
DROP SEQUENCE SEQ_notice_n_num;
DROP SEQUENCE SEQ_pr_reply_pr_num;
DROP SEQUENCE SEQ_pub_p_num;
DROP SEQUENCE SEQ_qr_reply_qr_num;
DROP SEQUENCE SEQ_question_q_num;
DROP SEQUENCE SEQ_reservation_res_num;
DROP SEQUENCE SEQ_r_social_rs_num;
DROP SEQUENCE SEQ_social_s_num;
DROP SEQUENCE SEQ_talk_t_num;




/* Create Sequences */

CREATE SEQUENCE SEQ_coupon_c_num INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_event_e_num INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_notice_n_num INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_pr_reply_pr_num INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_pub_p_num INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_qr_reply_qr_num INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_question_q_num INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_reservation_res_num INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_r_social_rs_num INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_social_s_num INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_talk_t_num INCREMENT BY 1 START WITH 1;



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
	e_email varchar2(128) NOT NULL,
	e_viewcnt number(10,0) NOT NULL,
	e_upload varchar2(1000),
	e_date varchar2(128) NOT NULL,
	PRIMARY KEY (e_num)
);


CREATE TABLE map
(
	p_num number(5,0) NOT NULL,
	address varchar2(256) NOT NULL,
	mart varchar2(2000) NOT NULL,
	area varchar2(2000) NOT NULL,
	latitude varchar2(2000) NOT NULL,
	longitude varchar2(2000) NOT NULL
);


CREATE TABLE members
(
	id varchar2(128) NOT NULL,
	pw varchar2(128) NOT NULL,
	phone varchar2(128) NOT NULL,
	email varchar2(128) NOT NULL,
	email_agree char NOT NULL,
	sex char NOT NULL,
	name varchar2(128) NOT NULL,
	birth varchar2(128) NOT NULL,
	userchk char NOT NULL,
	face varchar2(1000),
	allow_chk char NOT NULL,
	PRIMARY KEY (id)
);


CREATE TABLE notice
(
	id varchar2(128) NOT NULL,
	n_num number(3,0) NOT NULL,
	n_title varchar2(128) NOT NULL,
	n_contents varchar2(2000) NOT NULL,
	n_viewcnt number(10,0) NOT NULL,
	n_upload varchar2(1000),
	n_date varchar2(128) NOT NULL,
	PRIMARY KEY (n_num)
);


CREATE TABLE pr_reply
(
	pr_num number(5,0) NOT NULL,
	id varchar2(128) NOT NULL,
	p_num number(5,0) NOT NULL,
	pr_like number(5,0),
	PRIMARY KEY (pr_num)
);


CREATE TABLE pub
(
	p_num number(5,0) NOT NULL,
	id varchar2(128) NOT NULL UNIQUE,
	p_mupload varchar2(1000) NOT NULL,
	p_supload varchar2(1000),
	p_title varchar2(128) NOT NULL,
	p_contents varchar2(3000) NOT NULL,
	p_address varchar2(1000) NOT NULL,
	p_maxpeople number(3,0) NOT NULL,
	p_pub_chk char NOT NULL,
	PRIMARY KEY (p_num)
);


CREATE TABLE qr_reply
(
	qr_num number(5,0) NOT NULL,
	q_num number(3,0) NOT NULL,
	id varchar2(128) NOT NULL,
	PRIMARY KEY (qr_num)
);


CREATE TABLE question
(
	id varchar2(128) NOT NULL,
	q_num number(3,0) NOT NULL,
	q_title varchar2(128) NOT NULL,
	q_contents varchar2(2000) NOT NULL,
	q_viewcnt number(10,0) NOT NULL,
	q_upload varchar2(1000) NOT NULL,
	q_date varchar2(128) NOT NULL,
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
	PRIMARY KEY (t_num)
);



/* Create Foreign Keys */

ALTER TABLE coupon
	ADD FOREIGN KEY (id)
	REFERENCES members (id)
;


ALTER TABLE event
	ADD FOREIGN KEY (id)
	REFERENCES members (id)
;


ALTER TABLE notice
	ADD FOREIGN KEY (id)
	REFERENCES members (id)
;


ALTER TABLE pr_reply
	ADD FOREIGN KEY (id)
	REFERENCES members (id)
;


ALTER TABLE pub
	ADD FOREIGN KEY (id)
	REFERENCES members (id)
;


ALTER TABLE qr_reply
	ADD FOREIGN KEY (id)
	REFERENCES members (id)
;


ALTER TABLE question
	ADD FOREIGN KEY (id)
	REFERENCES members (id)
;


ALTER TABLE reservation
	ADD FOREIGN KEY (id)
	REFERENCES members (id)
;


ALTER TABLE r_social
	ADD FOREIGN KEY (id)
	REFERENCES members (id)
;


ALTER TABLE social
	ADD FOREIGN KEY (id)
	REFERENCES members (id)
;


ALTER TABLE talk
	ADD FOREIGN KEY (id)
	REFERENCES members (id)
;


ALTER TABLE map
	ADD FOREIGN KEY (p_num)
	REFERENCES pub (p_num)
;


ALTER TABLE pr_reply
	ADD FOREIGN KEY (p_num)
	REFERENCES pub (p_num)
;


ALTER TABLE reservation
	ADD FOREIGN KEY (p_num)
	REFERENCES pub (p_num)
;


ALTER TABLE qr_reply
	ADD FOREIGN KEY (q_num)
	REFERENCES question (q_num)
;


ALTER TABLE r_social
	ADD FOREIGN KEY (s_num)
	REFERENCES social (s_num)
;



