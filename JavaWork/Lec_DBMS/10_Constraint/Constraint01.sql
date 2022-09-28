-- 제약조건 (Constraint)

-- MySQL 에서 Table 제약조건 확인
SELECT  *
FROM information_schema.TABLE_CONSTRAINTS 
WHERE table_schema = 'mydb609' AND TABLE_NAME = 't_emp4';

SELECT * FROM t_dept2;

-- DROP TABLE IF EXISTS ~ CASCADE 옵션을 주면 
-- 이를 참조하는 다른 관계된 테이블의 데이터도 연쇄 삭제딤
DROP TABLE IF EXISTS t_emp4 CASCADE;
CREATE TABLE t_emp4(
	no INT(4) PRIMARY KEY,
	name VARCHAR(10) NOT NULL,
	jumin VARCHAR(13) NOT NULL UNIQUE, 
	area INT(1) CHECK(area < 5),  -- area 컬럼은 5 보다 작아야 하는 제약조건
	deptno VARCHAR(6) REFERENCES t_dept2(dcode)  -- 외래키(FK:Foreign Key) 제약조건
);

-- 제약조건을 별도로 기술
CREATE TABLE t_emp4(
	NO INT(4),
	name varchar(10) NOT NULL,
	jumin varchar(13) NOT NULL,
	area INT(1),
	deptno VARCHAR(6),
	PRIMARY KEY(no),
	UNIQUE(jumin),
	CHECK(area < 5),
	FOREIGN KEY (deptno) REFERENCES t_dept2(dcode)
);

-- 제약조건에 이름을 달아 정의
DROP TABLE IF EXISTS t_emp3 CASCADE;
CREATE TABLE t_emp3(
	NO INT(4),
	name varchar(10) NOT NULL,  -- NN
	jumin varchar(13) NOT NULL, -- NN
	area INT(1),
	deptno VARCHAR(6),
	CONSTRAINT emp3_no_pk PRIMARY KEY(no),  -- PK
	CONSTRAINT emp3_jumin_uk UNIQUE(jumin),  -- UK
	CONSTRAINT emp3_area_ck CHECK(area < 5),  -- CK
	CONSTRAINT emp3_deptno_fk FOREIGN KEY (deptno) REFERENCES t_dept2(dcode) -- FK
);

SELECT  *
FROM information_schema.TABLE_CONSTRAINTS 
WHERE table_schema = 'mydb609' AND TABLE_NAME = 't_emp3';

-- t_emp3 에 제약조건에 맞는 / 위배되는  DML 시도
INSERT INTO t_emp3 VALUES(
	1, 'MySQL', '1234561234567', 4, 1000
);
-- 두번 실행하면 에러   (PK 제약조건 위배)
-- Error [1062] [23000]: Duplicate entry '1' for key 't_emp3.PRIMARY'

INSERT INTO t_emp3 VALUES(
	2, '오라클', '1234561234567', 4, 1000
);
-- UK 제약조건 위배
--  Error [1062] [23000]: Duplicate entry '1234561234567' for key 't_emp3.emp3_jumin_uk'

INSERT INTO t_emp3 VALUES(
	2, '오라클', '22222222222222222222', 4, 1000
);
-- VARCHAR(13) 문자 초과
-- SQL Error [1406] [22001]: Data truncation: Data too long for column 'jumin' at row 1

INSERT INTO t_emp3 VALUES(
	2, 'tigers', '2222222222222', 10, 1000
);
-- CK 제약조건 위배
-- SQL Error [3819] [HY000]: Check constraint 'emp3_area_ck' is violated.


INSERT INTO t_emp3 VALUES(
	2, 'tigers', '2222222222222', 3, 2000
);
-- FK 제약조건 위배
-- SQL Error [1452] [23000]: Cannot add or update a child row: a foreign key constraint fails (`mydb609`.`t_emp3`, CONSTRAINT `emp3_deptno_fk` FOREIGN KEY (`deptno`) REFERENCES `t_dept2` (`DCODE`))

SELECT * FROM t_dept2;

INSERT INTO t_emp3(NO, jumin, area, deptno) VALUES(
	2, '3333333333333', 4, 1001
);
-- NN 제약조건 위배
-- SQL Error [1364] [HY000]: Field 'name' doesn't have a default value

-- UPDATE / DELETE 에서도 제약조건 오류 가능
SELECT * FROM t_emp3;

UPDATE t_emp3 SET area = 10 WHERE NO = 1;
-- SQL Error [3819] [HY000]: Check constraint 'emp3_area_ck' is violated.

DELETE FROM t_dept2 WHERE dcode = 1000;
-- 참조되고 있는 부모는 삭제 불가.
-- SQL Error [1451] [23000]: Cannot delete or update a parent row: a foreign key constraint fails (`mydb609`.`t_emp3`, CONSTRAINT `emp3_deptno_fk` FOREIGN KEY (`deptno`) REFERENCES `t_dept2` (`DCODE`))

-- ------------------------------------------------------
-- 복합키 제약조건 만들기
CREATE TABLE test_member(
	mb_uid INT NOT NULL,
	mb_nick VARCHAR(10) NOT NULL,
	mb_name VARCHAR(10) NOT NULL,
	CONSTRAINT test_member_pk PRIMARY KEY(mb_uid, mb_nick)
);

INSERT INTO test_member VALUES(1, 'aaa', 'John');
INSERT INTO test_member VALUES(1, 'bbb', 'John');
INSERT INTO test_member VALUES(2, 'aaa', 'John');

SELECT * FROM test_member;





