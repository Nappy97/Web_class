


SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS test_member;




/* Create Tables */

CREATE TABLE test_member
(
	mb_no int,
	mb_name varchar(40),
	mb_birthdate datetime
);

SELECT * FROM test_member ;
DELETE FROM test_member ;

INSERT INTO test_member (mb_birthdate) VALUES('2021-01-03');

CREATE TABLE test_member2
(
	id int PRIMARY KEY AUTO_INCREMENT,
	name varchar(40),
	regdate datetime DEFAULT now()
);

SELECT * FROM test_member2;

INSERT INTO test_member2(name) VALUES('노진수'); 