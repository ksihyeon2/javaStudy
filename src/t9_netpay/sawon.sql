show tables;

select * from bonbong;
desc bonbong;

create table bonbong(
	jikkub char(1) default 'S',
	bonbong int default 0
);

desc sawon;


select * from sawon;
create table sawon(
	sabun int not null auto_increment primary key,
	name varchar(20) not null,
	jikkub char(1) default 'S',
	night int default 0
);

insert into bonbong values ('B', 3500000);
insert into sawon values (default, '홍길동', 'B', default); 