CREATE TABLE test_emp_a (
   emp_id    INT,
   emp_name  VARCHAR(100)
);

CREATE TABLE test_emp_b (
   emp_id    INT,
   emp_name  VARCHAR(100)
);

INSERT INTO test_emp_a VALUES(101, '���̾��');
INSERT INTO test_emp_a VALUES(201, 'ĸƾ�Ƹ޸�ī');

SELECT * FROM test_emp_a ;
SELECT * FROM test_emp_b ;

-- �������� row �� �ѹ��� INSERT
INSERT INTO test_emp_a
VALUES (102, '��������'), (103, '�丣'), (104, '���Ҽ�')
;

-- sub query �� INSERT ����
INSERT INTO test_emp_a (SELECT 105, '�����̴���')

-- �ι�� ��Ƣ��(?) �ϱ�
INSERT INTO test_emp_a (SELECT * FROM test_emp_a)

INSERT INTO test_emp_b (emp_id)
SELECT emp_id FROM test_emp_a;


INSERT INTO test_emp_a
	SELECT * FROM test_emp_a
	UNION ALL
	SELECT * FROM test_emp_b
	;


-- CREATE TABLE + SuqQuery 
CREATE TABLE test_emp_c
AS
SELECT * FROM test_emp_a;


SELECT * FROM test_emp_c;

