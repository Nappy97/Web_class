
# DATE_FORMAT() �Լ�
# ��¥ -> ���ڿ�

SELECT now();

SELECT DATE_FORMAT(now(), '%Y%m%d');  -- ����� ���ڿ�
SELECT DATE_FORMAT(now(), '%Y-%m-%d %H:%i:%s');

# ��¥/�ð� -> ����
SELECT YEAR(now()), MONTH(now()), DAY(now());

# ���� ���ڸ����� �޸� ���
SELECT 1234567, format(1234567, 0);


-- #4304
-- t_professor ���̺��� 2000�� ������ �Ի��� ������� �Ի���,
-- ���� ������ 10% �λ� �� ������ ����ϼ���.
-- ������ ���ʽ�(bonus)�� ������ pay * 12 �� ����ϰ�
-- ������ �λ��� ������ õ���� ���� ��ȣ�� �߰��Ͽ� ����ϼ���

SELECT
	name, 
	date_format(hiredate, '%Y-%m-%d') �Ի���,
	format(pay * 12, 0) ����,
	format((pay * 12) * 1.1, 0) �λ���
FROM
	t_professor
WHERE
	YEAR(hiredate) < 2000;



