-- SELECT ������� �� ���� 5���� ����غ��� ������ ���� �ؾ� �ϳ�?
-- SELECT ������� n ��° ���� m ���� ����ϰ� �ʹٸ�?
--   ex) �Խ���.. ����¡

-- DBMS ���� ���� ��� �ٸ�
-- MYSQL : LIMIT
-- MS SQL server : TOP
-- ORACLE : ROWNUM 

SELECT empno, name FROM t_emp2;


-- ���ÿ� ���̺� �����
DROP TABLE IF EXISTS t_emp3;
CREATE TABLE t_emp3(
	uid INT PRIMARY KEY AUTO_INCREMENT,
	empno INT NOT NULL,
	name VARCHAR(10) NOT NULL
);

INSERT INTO t_emp3(empno, name) 
	SELECT empno, name FROM t_emp2;

SELECT * FROM t_emp3;

INSERT INTO t_emp3 (empno, name)
SELECT empno, name FROM t_emp3;

SELECT count(*) FROM t_emp3;

-- LIMIT n: ù n��
SELECT * FROM t_emp3 LIMIT 5;
SELECT * FROM t_emp3 ORDER BY uid DESC LIMIT 5;

-- LIMIT from, n : from ���� n��   (from �� index 0 ���� ����)
-- �鸸�� �� �������� 5���� �����شٸ�..

SELECT * FROM t_emp3 LIMIT 0, 5;  -- ù ������
SELECT * FROM t_emp3 LIMIT 5, 5;  -- �ι�° ������
SELECT * FROM t_emp3 LIMIT 10, 5;

SELECT * FROM t_emp3 LIMIT 40, 8;






