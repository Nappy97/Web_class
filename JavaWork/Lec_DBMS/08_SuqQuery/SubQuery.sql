----------------------------------------
-- Sub Query

-- #7101
-- t_emp ���̺��� 
-- scott ���� �޿��� ���� �޴� ����� �̸��� �޿� ���

SELECT * FROM t_emp;


SELECT sal FROM t_emp WHERE ename = 'SCOTT';

SELECT ename, sal
FROM t_emp
WHERE sal > (SELECT sal FROM t_emp WHERE ename = 'SCOTT')
;


-- 1. ������ ��������
-- SubQuery ����� �Ѱ� 1�ุ ������ ��.
-- ������ Sub Query ��  WHERE ���� ���Ǵ� ������
-- = , <> , !=, >, >= , <, <= 

-- #7103)����
-- t_student, t_department ���̺� ����Ͽ� 
-- ������ �л��� 1����(deptno1)�� ������ �л����� 
-- �̸�(name)�� 1�����̸�(dname)�� ����ϼ���

SELECT s.name "�л��̸�", d.dname "1����"
FROM t_student s, t_department d
WHERE s.deptno1 = d.deptno
	AND 
	s.deptno1 = (SELECT deptno1 FROM t_student WHERE name = '������')
;



-- #7107) ����
-- t_emp2, t_dept2 ���̺� : 
-- �ٹ����� (t_dept2.area) �� ���� ������ ��� ������� 
-- ���(empno)�� �̸�(name), �μ���ȣ(deptno)�� ����ϼ���

SELECT * FROM t_emp2;
SELECT * FROM t_dept2;


-- 2. ������ ����
-- Sub Query ����� 2�� �̻� ��µǴ� ���� ���մϴ�.
-- ������ Sub Query �� �Բ� ����ϴ� ������
--		 IN ���� ���� ã��
--		>ANY �ּҰ��� ��ȯ�� (�������� ����� ���������ͺ��� ū)
--		<ANY �ִ밪�� ��ȯ�� (�������� ����� ����ū�ͺ��� ����)
--		<ALL �ּҰ��� ��ȯ�� (�������� ����� ���������ͺ��� ����)
--		>ALL �ִ밪�� ��ȯ�� (�������� ����� ����ū�ͺ��� ū)
--		EXIST Sub Query ���� ���� ��� ��ȯ


-- �ٹ������� �������� �� �μ�����?
SELECT dcode FROM t_dept2 WHERE area = '��������';

SELECT empno, name, deptno
FROM t_emp2
WHERE deptno IN (SELECT dcode FROM t_dept2 WHERE area = '��������')
;


-- #7108) ����
-- t_emp2 ���̺� : 
-- ��ü������ ���� ������ �ּҿ����ں��� 
-- ������ ���� ����� 
-- �̸�(name)�� ����(post), ����(pay)�� ����ϼ���.  
-- ��, ���� ��� ������ õ ���� ���� ��ȣ�� �� ǥ�ø� �ϼ���

SELECT pay FROM t_emp2 WHERE post = '����';


SELECT name "�̸�", post "����", concat(format(pay, 0), '��') "����"
FROM t_emp2
WHERE pay >ANY (SELECT pay FROM t_emp2 WHERE post = '����')
;


-- ��Į�� ���� ����
SELECT
	(SELECT 10),
	(SELECT 20)
	;

-- #7206) ����
-- t_emp2, t_dept2 ���̺�: 
-- ��ȸ�Ͽ� ������� �̸��� �μ� �̸��� ���

SELECT e.name "����̸�", 
	(SELECT d.dname FROM t_dept2 d WHERE d.dcode = e.deptno ) "�μ��̸�"
FROM t_emp2 e;

-- JOIN �� ���� ��� ����.  
-- �׷��� ������ ���� ���� ���� ��Į�󼭺����� ����� Join ���� ���� ������ ������



