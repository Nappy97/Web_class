-- �ּ��Դϴ�
# �ּ��Դϴ�

SELECT 'abcde';
SELECT '�ȳ��ϼ���', 2022, 4 + 3;

#-- SELECT - ������ ��ȸ/����
#-- SELECT [�÷��� �Ǵ� ǥ����] FROM [���̺��, ���]

SELECT * FROM t_professor;

SELECT * FROM t_emp;

SELECT empno, ename FROM t_emp;

SELECT ename, empno, empno, EMPNO, empno FROM t_emp;

-- �÷� ��Ī(alias)

SELECT studno �й�, name �̸�
FROM t_student;

SELECT
	studno "�л� �й�",
	name AS �̸�
FROM t_student;

-- DISTINCT - �ߺ��� �����ϰ� ���
-- SELECT  DISTINCT [�÷��� �Ǵ� ǥ����] FROM [���̺��, ���] ;

SELECT deptno FROM t_emp;
SELECT DISTINCT deptno FROM t_emp;

# MySQL ���� ���ڿ� ���� concat()

SELECT name, POSITION FROM t_professor;
SELECT concat(name, POSITION) "������" FROM t_professor;

-- ��������� ��� ����

-- t_emp ���̺�
-- �����̸�(ename), �޿�(sal), �޿�10%�λ��
SELECT ename, sal, sal * 1.1 FROM t_emp;

-- WHERE : ���ϴ� ���Ǹ� �˻�

-- SELECT [�÷��� �Ǵ� ǥ����] 
-- FROM [���̺��, ���]  
-- WHERE [������] ;

SELECT * FROM t_emp;
SELECT * FROM t_emp WHERE job = 'SALESMAN';
SELECT * FROM t_emp WHERE job = 'SALESman';  -- MySQL �� ��ҹ��� ���� ���� ���ڿ� �� (����Ʈ)
SELECT * FROM t_emp WHERE BINARY(job) = 'SALESman';

#--���� ���̺�(t_emp) ���� �޿�(sal) �� 2000���� ū ����� 
#--�̸�(ename)�� �޿�(sal)�� ����ϼ���
SELECT ename, SAL  FROM t_emp WHERE sal > 2000;




