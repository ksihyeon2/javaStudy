show tables;

-- 회원 정보 관리


create table member (
	idx int not null auto_increment primary key,
	id varchar(10) not null,            					 -- 아이디
	pw varchar(15) not null,            					 -- 비밀번호
	name varchar(10) not null,           					 -- 성명
	gender varchar(2) not null,							     -- 성별
	age int not null,                 					     -- 나이
	email varchar(50) not null,         					 -- 이메일
	phonenum varchar(15) not null,      					 -- 전화번호
	address varchar(50) not null,      						 -- 주소
	entry datetime default now(),     					     -- 가입날
	rating varchar(20) default 'SILVER',                     -- 회원 등급
	point int default 5000           		                 -- 포인트
);


select * from member;


-- 책 정보
 

create table book (
	idx int not null auto_increment primary key,
	category varchar(10) not null,                           -- 카테고리
	bookname varchar(50) not null,                           -- 책 제목 
	company varchar(20) not null,                            -- 출판사
	writer varchar(20) not null,                             -- 저자
	publication varchar(10) not null,                        -- 출판일
	price int not null, 								     -- 가격
	grade char(3) default 0,						         -- 평점
	review varchar(1000) default '<줄거리를 입력하세요>',         -- 줄거리
	cover varchar(500) default '<사진을 등록하세요>'			 -- 표지
);


select * from book;
select bookname from book where bookname='모순';

-- 장바구니


create table mypage (
	idx int not null auto_increment primary key,
	id varchar(10) not null,                                 -- 아이디
	bookname varchar(50) default '',		                 -- 책 이름
	item int default 0,			                             -- 갯수
	price int default 0	                                     -- 가격  
);


select * from mypage;


-- 구매 목록


create table shopping (
	idx int not null auto_increment primary key,
	id varchar(10) not null,                                 -- 아이디
	bookname varchar(50) not null,                           -- 책 제목
	item int not null,									     -- 책 구매 개수	
	buydate datetime default now()                           -- 구매 날짜
);


select * from shopping;

-- 회원의 책 등록 희망



create table bookUpdate(
	idx int not null auto_increment primary key,   
	id varchar(10) not null,			                 	 -- 아이디
	name varchar(10) not null,			                 	 -- 이름
	bookname varchar(50) not null,		                 	 -- 등록을 원하는 책
	situation varchar(5) default '대기중'                 	 -- 등록 상태
);


delete from bookUpdate where id='admin1234';

select * from bookUpdate;