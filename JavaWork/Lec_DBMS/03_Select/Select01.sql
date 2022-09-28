-- 주석입니다
# 주석입니다

SELECT 'abcde';
SELECT '안녕하세요', 2022, 4 + 3;

#-- SELECT - 데이터 조회/질의
#-- SELECT [컬럼명 또는 표현식] FROM [테이블명, 뷰명]

SELECT * FROM t_professor;

SELECT * FROM t_emp;

SELECT empno, ename FROM t_emp;

SELECT ename, empno, empno, EMPNO, empno FROM t_emp;

-- 컬럼 별칭(alias)

SELECT studno 학번, name 이름
FROM t_student;

SELECT
	studno "학생 학번",
	name AS 이름
FROM t_student;

-- DISTINCT - 중복값 제거하고 출력
-- SELECT  DISTINCT [컬럼명 또는 표현식] FROM [테이블명, 뷰명] ;

SELECT deptno FROM t_emp;
SELECT DISTINCT deptno FROM t_emp;

# MySQL 에서 문자열 연결 concat()

SELECT name, POSITION FROM t_professor;
SELECT concat(name, POSITION) "교수님" FROM t_professor;

-- 산술연산자 사용 가능

-- t_emp 테이블
-- 직원이름(ename), 급여(sal), 급여10%인상분
SELECT ename, sal, sal * 1.1 FROM t_emp;

-- WHERE : 원하는 조건만 검색

-- SELECT [컬럼명 또는 표현식] 
-- FROM [테이블명, 뷰명]  
-- WHERE [조건절] ;

SELECT * FROM t_emp;
SELECT * FROM t_emp WHERE job = 'SALESMAN';
SELECT * FROM t_emp WHERE job = 'SALESman';  -- MySQL 은 대소문자 구분 없이 문자열 비교 (디폴트)
SELECT * FROM t_emp WHERE BINARY(job) = 'SALESman';

#--직원 테이블(t_emp) 에서 급여(sal) 가 2000보다 큰 사람의 
#--이름(ename)과 급여(sal)를 출력하세요
SELECT ename, SAL  FROM t_emp WHERE sal > 2000;




