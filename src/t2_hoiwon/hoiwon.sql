show tables;

create table hoiwon (
	idx int not null auto_increment primary key,
	name varchar(20) not null,
	age int default 20,
	address varchar(50),
	gender char(2) default '여자'
);

desc hoiwon;

insert into hoiwon values (default, '감나무', 35, '청주','남자');
insert into hoiwon values (default, '대추나무', 45, '경주','여자');
insert into hoiwon values (default, '가가가', 45, '광주','여자');
insert into hoiwon values (default, '나나나', 28, '전주','남자');
insert into hoiwon values (default, '닫다다', 32, '서울','남자');
insert into hoiwon values (default, '라라라', 25, '음성','여자');
insert into hoiwon values (default, '마마마', 7, '증평','여자');
insert into hoiwon values (default, '아아아', 13, '남양주','여자');
insert into hoiwon values (default, '가바아', 43, '서울','남자');
insert into hoiwon values (default, '이우이', 10, '청주','여자');
insert into hoiwon values (default, '홍홍홍', 22, '나주','남자');
insert into hoiwon values (default, '파파파', 43, '괴산','남자');
insert into hoiwon values (default, '하하하', 27, '여수','여자');
insert into hoiwon values (default, '돌맹이', 22, '양양','여자');

select * from hoiwon;
