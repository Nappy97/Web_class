SHOW tables;

SHOW FULL TABLES IN mydb609;


CREATE OR REPLACE VIEW v_prof
AS
SELECT profno, name, email, hpage
FROM t_professor;

SELECT * FROM v_prof;

-- view 생성시 별도의 컬럼 이름 줄수 있다
CREATE OR REPLACE VIEW v_prof(pfno, nm, em, hp)
AS
SELECT profno, name, email, hpage
FROM t_professor;


-- 인라인뷰
-- View 는 한번 만들어 놓으면 계속 사용할수 있습니다.
-- 그러나 1회용으로만 사용할 경우는 FROM 절의 서브쿼리 형태로 만들수 있습니다. 
-- 이러한 뷰를 Inline View 라 합니다.

-- #8103) 예제
-- t_student, t_department 테이블 : 
-- 학과별로 학생들의 최대키와 최대몸무게, 학과 이름을 출력하세요

SELECT d.dname "학과명", s.max_height "최대키", s.max_weight "최대몸무게"
FROM
	(SELECT deptno1, MAX(height) "max_height", MAX(weight) "max_weight"
	FROM t_student
	GROUP BY deptno1) s,
	t_department d
WHERE s.deptno1 = d.deptno
;


