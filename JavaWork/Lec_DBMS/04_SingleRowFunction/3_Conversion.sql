
# DATE_FORMAT() 함수
# 날짜 -> 문자열

SELECT now();

SELECT DATE_FORMAT(now(), '%Y%m%d');  -- 결과는 문자열
SELECT DATE_FORMAT(now(), '%Y-%m-%d %H:%i:%s');

# 날짜/시간 -> 숫자
SELECT YEAR(now()), MONTH(now()), DAY(now());

# 숫자 세자리마다 콤마 찍기
SELECT 1234567, format(1234567, 0);


-- #4304
-- t_professor 테이블에서 2000년 이전에 입사한 교수명과 입사일,
-- 현재 연봉과 10% 인상 후 연봉을 출력하세요.
-- 연봉은 보너스(bonus)를 제외한 pay * 12 로 계산하고
-- 연봉과 인상후 연봉은 천단위 구분 기호를 추가하여 출력하세요

SELECT
	name, 
	date_format(hiredate, '%Y-%m-%d') 입사일,
	format(pay * 12, 0) 연봉,
	format((pay * 12) * 1.1, 0) 인상후
FROM
	t_professor
WHERE
	YEAR(hiredate) < 2000;



