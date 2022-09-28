-- FROM ���� ���̺��� ����(alias) �ټ� �ִ�

-- �л� 20��
SELECT s.studno, s.name, s.deptno1
FROM t_student s;

-- �а� 12��
SELECT d.deptno, d.dname
FROM t_department d;

-- īƼ�ǰ� (Cartesian Product)
-- �ΰ��� ���̺��� JOIN �ϰ� �Ǹ�, 
-- �� ���̺��� ���ڵ���� ��� ������ ��µȴ�.
-- WHERE �� ON ������ JOIN ������ �־����� ������ 
-- ��� īƼ�ǰ��� ��µȴ�. 

-- 240 = 20 x 12
SELECT s.studno, s.name, s.deptno1,
	d.deptno, d.dname
FROM t_student s, t_department d;
					
-- ���� īƼ�� ������ ������ �ָ� ���Ѵ� ���ڵ常 ���� ����.

-----------------------------------------------------------------------------------
-- Equi Join (� Join)
-- �Ϲ������� ���� ���̴� Join �̸�, ���� ���̺� Join �� īƼ�ǰ����� ���������ǡ��� ������ ��츸 ���� �������� ��

-- ��) #6101 
-- t_student ���̺�� t_department ���̺��� ����Ͽ� �л��̸�, 1���� �а���ȣ, 1���� �а� �̸��� ����ϼ���

-- MySQL ����
SELECT s.name "�л��̸�", s.deptno1 "�а���ȣ", d.dname "�а��̸�"
FROM t_student s, t_department d
WHERE s.deptno1 = d.deptno     -- JOIN ����
;

-- ANSI SQL ����
SELECT s.name "�л��̸�", s.deptno1 "�а���ȣ", d.dname "�а��̸�"
FROM t_student s 
	JOIN t_department d ON s.deptno1 = d.deptno     -- JOIN ����
;

-- ���� #6102)
-- t_student ���̺�, t_professor ���̺� �� join�Ͽ� 
-- ���л��̸���, ������������ȣ��, �����������̸��� �� ����ϼ���

-- MySQL ����
SELECT s.name "�л��̸�", s.profno "��������", p.name "���������̸�" 
FROM t_student s, t_professor p 
WHERE s.profno = p.profno;

-- ANSI ����
SELECT s.name "�л��̸�", s.profno "��������", p.name "���������̸�" 
FROM t_student s 
	JOIN t_professor p ON s.profno = p.profno;

-- �� ��� ���� ��� �л��� SELECT  ���� �ʴ´� ���������� ���� null �� �л��� �ִ� ���̴�
--  null ���� join ���ǿ� ���� ���Ѵ�

-- 3���̺� JOIN

-- #6103
-- t_student, t_department, t_professor ���̺� �� join �Ͽ� 
--  �л��� �̸�, �а��̸�, �������� �̸�  �� ����ϼ���

-- MySQL����
SELECT s.name "�л��̸�",  d.dname "�а��̸�", p.name "�����̸�"
FROM t_student s, t_department d, t_professor p
WHERE s.deptno1 = d.deptno AND s.profno = p.profno
;
-- ANSI ����
SELECT s.name "�л��̸�",  d.dname "�а��̸�", p.name "�����̸�"
FROM t_student s 
	JOIN t_department d ON s.deptno1 = d.deptno
	JOIN t_professor p ON  s.profno = p.profno
;

-- ���� #6105
-- t_student - t_professor ���̺� join �Ͽ� 
-- ��1����(deptno1) �� 101���� �л����� 
-- �л��̸��� �������� �̸��� ����ϼ���

SELECT s.name "�л��̸�", p.name "�����̸�"
FROM t_student s, t_professor p
WHERE s.profno = p.PROFNO  -- JOIN ���� 
	AND s.deptno1 = 101    -- �˻� ����
;

-- ANSI ����
SELECT s.name "�л��̸�", p.name "�����̸�"
FROM t_student s JOIN t_professor p
	ON s.profno = p.PROFNO  -- JOIN ���� 
WHERE s.deptno1 = 101    -- �˻� ����
;

SELECT s.name "�л��̸�", p.name "�����̸�"
FROM t_student s JOIN t_professor p
	ON s.profno = p.PROFNO  -- JOIN ���� 
	AND s.deptno1 = 101    -- �˻� ����
;


-- �� ���� (Non-Equi Join)

-- #6201) 
-- t_customer ���̺�, t_gift ���̺��� join �Ͽ�  
-- ���� ���ϸ��� ����Ʈ���� ������ �ִ� ��ǰ�� ��ȸ�Ͽ� 
-- ���� '�̸�(c_name)'�� ����Ʈ(c_point) ��ǰ��(g_name)�� ����ϼ���
-- BETWEEN ~ AND ~ ���

SELECT * FROM t_customer;
SELECT * FROM t_gift;

SELECT c.c_name "����", c.c_point "POINT", g.g_name "��ǰ��"
FROM t_customer c, t_gift g
WHERE c.c_point BETWEEN g.g_start AND g.g_end
;

--  #6202) ���� 
-- �� �������� ��ȸ�� ��ǰ�� �̸�(gname)�� �ʿ������ ����� ��ȸ�ϼ���
-- (�׷��Լ� �����Ǿ�� �Ѵ�)

SELECT g.g_name "��ǰ��", count(*) "�ʿ����"
FROM t_customer c, t_gift g
WHERE c.c_point BETWEEN g.g_start AND g.g_end
GROUP BY g.g_name
;

-- ---------------------------------------------------------
-- OUTER JOIN (�ܺ� ����)

SELECT s.name, p.name
FROM t_student s, t_professor p
WHERE s.profno = p.PROFNO
;

SELECT s.name, p.name
FROM t_student s INNER JOIN t_professor p ON s.profno = p.PROFNO -- INNER JOIN
;

SELECT s.name, p.name
FROM t_student s LEFT OUTER JOIN t_professor p ON s.profno = p.PROFNO 
;

SELECT s.name, p.name
FROM t_student s RIGHT OUTER JOIN t_professor p ON s.profno = p.PROFNO 
;

-- MySQL �� FULL OUTER JOIN �� �������� �ʴ´�
-- ��� UNION �� ����ϸ� �ȴ�.
SELECT s.name, p.name
FROM t_student s LEFT OUTER JOIN t_professor p ON s.profno = p.PROFNO 
UNION
SELECT s.name, p.name
FROM t_student s RIGHT OUTER JOIN t_professor p ON s.profno = p.PROFNO 
;


-- SELF JOIN
SELECT * FROM t_dept2;

-- #6209) 
-- t_dept2 ���̺��� 
-- �μ��� �� �� �μ��� �����μ����� ����ϼ���

SELECT d1.dname �μ���, d2.dname �����μ���
FROM t_dept2 d1, t_dept2 d2
WHERE d1.pdept = d2.dcode
;














