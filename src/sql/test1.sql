select * from test1;

show tables;

-- DDL (구조 관계) 필드

create table test1 (
	idx int not null auto_increment primary key,
	-- inx : index
	name varchar(20) not null
);

desc test1;

select * from test1;

insert into test1 values (default, '홍길동');
insert into test1 values (default, '김말숙');
insert into test1 values (default, '이기자');
insert into test1 values (default, '소나무');
insert into test1 values (default, '대나무');
-- insert into test1 values (default, '감나무', 35);  adress 값이 주어지지 않아 실행되지 않음
insert into test1 values (default, '감나무', 35, '청주','남자');
insert into test1 values (default, '대추나무', 45, '경주','여자');
insert into test1 values (default, '가가가', 45, '경주','여자');
insert into test1 values (default, '나나나', 28, '경주','남자');
insert into test1 values (default, '닫다다', 32, '경주','남자');
insert into test1 values (default, '라라라', 25, '경주','여자');
insert into test1 values (default, '마마마', 7, '경주','여자');
insert into test1 values (default, '아아아', 13, '대전','여자');
insert into test1 values (default, '가바아', 43, '부산','남자');
insert into test1 values (default, '이우이', 10, '광주','여자');
insert into test1 values (default, '홍홍홍', 22, '인천','남자');
insert into test1 (name) values ('연습2');   


-- 구조 바꾸기 <alter talbe> (test1 table에 age column 추가 (int, default 15))
alter table test1 add column age int default 15;  -- 테이블에 필드 추가 (add column)

-- test1 table에 addr column 추가 (varchar(50))
ALTER TABLE TEST1 ADD COLUMN ADDR VARCHAR(50);

-- test1 table에 addr column을 address로 변경 (change / modify)
-- filed 명 변경할때 change 사용
ALTER TABLE TEST1 CHANGE COLUMN ADDR ADDRESS VARCHAR(50);

-- 성격 바꾸기 (test1 table에 address column의 varchar(50)을 30Byte로 변경(change / modify)
-- filed의 옵션 바꿀때 modify 사용
ALTER TABLE TEST1 MODIFY COLUMN ADDRESS VARCHAR(30); ///

-- column 삭제 (drop column)
ALTER TABLE TEST1 DROP COLUMN ADDRESS;

-- address column 추가 (varchar(30) default '청주')
ALTER TABLE TEST1 ADD COLUMN ADDRESS VARCHAR(30) DEFAULT '청주';

-- 성별 (gender) 필드 추가 (add column)
ALTER TABLE TEST1 ADD COLUMN GENDER CHAR(2) NOT NULL;

-- test1 table을 exam table로 이름 변경 (rename)
ALTER TABLE TEST1 RENAME EXAM;

-- table을 삭제 (구조 완전 삭제)
drop table test1;   -- table의 구조까지 완전히 삭제한다. (data를 포함)

----------------------------------------------------------------------------------------------------

-- DML (데이터 조작어) 레코드

desc test1;

-- test1 table 내용 보기
-- 제대로 실행이 되었는지 확인하기 위해서 계속 쓰기 때문에 맨 위에 올려두는것이 좋음
select * from test1;

insert into test1 values (default, '가나다', 55, '제주');

-- test1 table의 '성명/나이' 정보의 모든 record를 보여주시오.
SELECT NAME,AGE FROM TEST1;

-- 홍길동의 나이를 25세로 변경 (update 테이블명 set 필드명 = '변경내용' where __조건__)
UPDATE TEST1 SET AGE=25 WHERE NAME ='홍길동';

-- 홍길동의 성별을 남자로 변경
UPDATE TEST1 SET GENDER='남자' WHERE NAME ='홍길동';

-- '이기자'의 성별을 남자로 변경
UPDATE TEST1 SET GENDER='남자' WHERE NAME = '이기자';

-- '소나무/대나무/감나무/가나다/마마마'의 성별을 '남자'로 변경
UPDATE TEST1 SET GENDER='남자' WHERE NAME IN ('소나무','대나무','감나무','가나다','마마마');

-- '가가가/나나나/바바바'의 성별을 '남자'로 변경 ((in == or)한번에 바꾸는 명령어)
update test1 set gender='남자' where name in ('가가가','나나나','바바바');

-- 정렬 : order by 필드명 _옵션_ : 옵션 생략시 오름차순(asc) // 내림차순(desc)
-- 오름차순
SELECT * FROM TEST1 ORDER BY NAME;   
SELECT * FROM TEST1 ORDER BY AGE;

-- 내림차순
SELECT * FROM TEST1 ORDER BY NAME DESC;
SELECT * FROM TEST1 ORDER BY AGE DESC;

-- 나이 내림차순
select * from test1 order by age desc;

-- 성별 오름차순
select * from test1 order by gender;

-- 성별 오름차순 단, 성별이 같으면 두번째 키는 성명 내림차순
SELECT * FROM TEST1 ORDER BY GENDER, NAME DESC;

-- 성별 내림차순 단, 성별이 같으면 나이가 적은 사람 우선 출력
SELECT * FROM TEST1 ORDER BY GENDER DESC, AGE;

-- 1차 성별 내림차순, 2차 나이 내림차순, 3차 idx내림차순 출력
SELECT * FROM TEST1 ORDER BY GENDER DESC, AGE DESC, IDX DESC;

-- 나이 30대만 출력(30~39) : 필드명 between ___ and ___
SELECT * FROM TEST1 WHERE AGE>=30 AND AGE<40;
SELECT * FROM TEST1 WHERE AGE BETWEEN 30 AND 40;

-- 나이 30대 이면서 남자만 출력(30~39)
select * from test1 where age>=30 and age<40 and gender='남자'

-- 나이 30대 이면서 남자만 이름 내림차순 출력(30~39)
select * from test1 where age>=30 and age<40 and gender='남자' order by name desc;

-- 나이가 30대 이거나 50대인 자료만 출력
select * from test1 where (age>=30 and age<40) or (age>=50 and age<60);

-- 서울에 살거나 청주에 사는 사람이 있으면 출력
select * from test1 where address='서울' or adress='청주';
select * from test1 where address in ('서울', '청주');

-- 서울에 살거나 청주에 사는 사람중에 나이가 20대 이하만 출력
select * from test1 where (address='서울' or address='청주') and age<=20;
select * from test1 where address in ('서울', '청주') and age<=20;

-- 청주에 살거나 나이가 20대인 남자만 출력
select * from test1 where adress='청주' or (age between 20 and 29) and gender='남자';

-- 이름 성 '가'씨만 출력 (like 연산자 : %를 의미 (복수개의 와일드카드) , _(단수개의 와일드카드)
select * from test1 where name like '가%'; 
-- 가로 시작한다는 의미

-- 주소의 마지막 글자가 '주'로 끝나는 자료 출력
select * from test1 where address like '%주'

-- 이름중에 '나'자를 포함한 자료 출력
select * from test1 where name like '%나%'

-- 이름중에 두번째글자가 '나'자를 포함한 자료 출력
select * from test1 where name like '_나%';

-- 이름중에서 두번째 글자가 '나'자를 포함한 자료의 '성명/주소'를 출력
select name,adㅇress from test1 where name like '_나%';

-- 자료를 10개만 출력 (제한 : limit)
select * from test1 limit 10;

-- index 번호 4에서부터 5개만 출력
select * from test1 limit 4,5;

-- 주소의 마지막 글자가 '주'로 끝나는 자료dml 나이를 1살씩 추가해서 출력
update test1 set age=age+1 where address like '%주';

-- 청주에 사는 남자
select * from test1 where address='청주' and gender='남자';

-- 청주에 사는 남자 삭제
delete from test1 where address='청주' and gender='남자';

-- 나이가 많은 사람 5명만 출력
select * from test1 order by age desc limit 5;
