SELECT count(*) FROM t_professor;

-- �׷��Լ����� �����Ҷ� null ���� (�⺻������) �����ȴ�.
SELECT count(pay), count(bonus) FROM t_professor;
SELECT sum(pay), max(pay), min(pay), avg(pay) FROM t_professor;

SELECT avg(bonus), avg(ifnull(bonus, 0)) FROM t_professor;

-- '�а���', �������� ��ձ޿� ���
SELECT deptno, avg(pay) FROM t_professor;

-- SELECT ���� �׷��Լ��� �׷��Լ��� �ƴѰ��� �Բ� �ü� ����
-- �� ��� �׷��Լ��� �ƴ� �͵��� GROUP BY ���� ������ �Ѵ�.

SELECT deptno, avg(pay) FROM t_professor
GROUP BY deptno
;

-- #5101)����
-- t_professor ���̺� : �а���(deptno) �׸��� ���޺�(position)�� �������� ��� �޿��� ����Ͽ� ����ϼ���

SELECT deptno, POSITION, avg(pay) "��ձ޿�"
FROM t_professor
GROUP BY deptno, POSITION
ORDER BY deptno ASC, POSITION ASC
;

-- HAVING �� : �׷��Լ��� ����� ������ ���̱�
-- �а��� ��ձ޿��� 300���� ���� �а��� ���
SELECT deptno, avg(pay) FROM t_professor
-- WHERE avg(pay) > 300  -- �׷��Լ��� WHERE ������ ��� �Ұ�
GROUP BY deptno
HAVING avg(pay) > 300
;

-- <SELECT ������ ����>   - ó������
-- SELECT               - (5)
-- FROM                 - (1)
-- WHERE                - (2)
-- GROUP BY             - (3)
-- HAVING               - (4)
-- ORDER BY             - (6)

-- #5104
SELECT 	deptno1 �а�, max(weight) - min(weight) "�ִ��ּҸ�������"  
FROM t_student
GROUP BY deptno1
HAVING (max(weight) - min(weight)) >= 30
;




