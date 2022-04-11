select *
from regions;
select *
from departments
where manager_id is not null;

select FIRST_NAME, LAST_NAME, SALARY
from EMPLOYEES
where ROWNUM < 6;