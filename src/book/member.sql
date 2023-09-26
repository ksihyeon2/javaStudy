show databases;

show tables;
desc member;

-- 회원 정보 관리
create table member (
	idx int not null auto_increment primary key,
	id varchar(10) not null,             -- 아이디
	pw varchar(15) not null,             -- 비밀번호
	name varchar(10) not null,           -- 성명
	age int not null,                    -- 나이
	email varchar(50) not null,          -- 이메일
	phonenum varchar(15) not null,       -- 전화번호
	address varchar(50) not null,        -- 주소
	entry datetime default now()         -- 가입날짜
);

insert into member values(default,'admin1234','1234','홍길동',25,'admin1234@naver.com','010-1234-5678','청주',default);

delete from member where name='김말숙';
select * from member;
drop table member;

-- 책 정보
create table book (
	idx int not null auto_increment primary key,
	category varchar(10) not null,       -- 카테고리
	bookname varchar(50) not null,       -- 책 이름 
	company varchar(20) not null,        -- 출판사
	writer varchar(20) not null,         -- 저자
	publication varchar(10) default '',  -- 출판일
	price int not null, 								 -- 가격
	grade int default 0,								 -- 평점
	review varchar(500)								   -- 서평
);

insert into book values (default,'소설','모순','쓰다','양귀자','2013-04-01',11700,4.6,default);

select * from book;

-- 쇼핑 목록
create table shopping (
	idx int not null auto_increment primary key,
	id varchar(10) not null,             -- 아이디
	bookname varchar(50) default '',		 -- 책 이름
	item int default 0,			             -- 갯수
	pricetot int default 0	             -- 총 가격
);

select * from shopping;

insert into shopping values (default,'admin1234',default,default,default);

-- 마이 페이지
create table mypage (
	idx int not null auto_increment primary key,
	id varchar(10) not null,             -- 아이디
	point int default 0,          		   -- 포인트
	buydate varchar(10)	default ''       -- 구매 날짜
);

insert into mypage values(default,'admin1234',default,default);

select * from mypage;