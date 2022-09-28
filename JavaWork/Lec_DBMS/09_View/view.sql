SHOW tables;

SHOW FULL TABLES IN mydb609;


CREATE OR REPLACE VIEW v_prof
AS
SELECT profno, name, email, hpage
FROM t_professor;

SELECT * FROM v_prof;

-- view ������ ������ �÷� �̸� �ټ� �ִ�
CREATE OR REPLACE VIEW v_prof(pfno, nm, em, hp)
AS
SELECT profno, name, email, hpage
FROM t_professor;


-- �ζ��κ�
-- View �� �ѹ� ����� ������ ��� ����Ҽ� �ֽ��ϴ�.
-- �׷��� 1ȸ�����θ� ����� ���� FROM ���� �������� ���·� ����� �ֽ��ϴ�. 
-- �̷��� �並 Inline View �� �մϴ�.

-- #8103) ����
-- t_student, t_department ���̺� : 
-- �а����� �л����� �ִ�Ű�� �ִ������, �а� �̸��� ����ϼ���

SELECT d.dname "�а���", s.max_height "�ִ�Ű", s.max_weight "�ִ������"
FROM
	(SELECT deptno1, MAX(height) "max_height", MAX(weight) "max_weight"
	FROM t_student
	GROUP BY deptno1) s,
	t_department d
WHERE s.deptno1 = d.deptno
;


