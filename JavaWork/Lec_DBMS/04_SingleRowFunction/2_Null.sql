-- null  ������ ��� ���� ����� null �̴�
SELECT name, pay, bonus, pay + bonus
FROM t_professor;

# IFNULL : NULL���� ������ �ٸ� ������ ġȯ�ؼ� ����ϴ� �Լ�
# ISNULL : NULL ���� üũ�ϴ� �Լ�  (null �̸� 1, �ƴϸ� 0 ����)
# IF : ù��° ���ڰ� true �̸�  �ι�° ����, false �̸� ����° ��!

SELECT bonus, isnull(bonus), ifnull(bonus, 0), if(bonus, bonus, 0)
FROM t_professor;


SELECT name, pay, bonus, pay + ifnull(bonus, 0)
FROM t_professor;
