SELECT name, id, lower(id), upper(id) FROM t_student;

#---------------------------------------------
#-- SUBSTR �Լ� 
#-- ����: SUBSTR( �����ڿ��� �Ǵ� �÷���,   ������ġ,  ������ ���ڼ� )
#-- ���ڿ����� Ư�� ������ ���ڸ� ������ �� ����ϴ� �Լ�
#-- ������ġ, ���� ����.
#-- �� ���� �ε����� 1���� �����Ѵ� (�ε����� 1���� ����) 


SELECT substr('ABCDE', 2, 3);

-- #4107
SELECT name, substr(jumin, 1, 6) "�������" FROM t_student;

-- #4108
-- t_student ���̺� : 
-- jumin Į���� ����ؼ� 
--  �¾ ���� 8���� ����� �̸��� ��������� ����ϼ��� / substr() ���

SELECT name, substr(jumin, 1, 6) "�������" FROM t_student
-- WHERE substr(jumin, 3, 2) = '08'
WHERE jumin LIKE '__08%'
;

#-------------------------------------------------
# INSTR()
# �־��� ���ڿ��̳� �÷����� Ư�� ������ ��ġ�� ã���ִ� �Լ� (�ε��� ����)

SELECT instr('ABCDEFG', 'D');

-- #4110, #4111
SELECT name, tel, instr(tel, ')') "��ġ"
FROM t_student WHERE deptno1 = 101;

SELECT name, tel, substr(tel, 1, instr(tel, ')') - 1) "������ȣ"  
FROM t_student WHERE deptno1 = 101;







