select row_number() over(order by dept, salary desc) 'No',
    rank() over w,
    dense_rank() over w,
    e.*
  from Emp e
 where e.ename like '박%'
 WINDOW w as (partition by dept order by dept, salary desc); 
 
-- Pivot
select d1.id pid, d2.id, 
       (case when d1.id is not null then max(d1.dname) else ' - 총계 -' end) pname,
       (case when d2.id is not null then max(d2.dname) else ' - 소계 - ' end) dname,
       sum(e.salary) totsal
  from Dept d1 inner join Dept d2 on d1.id = d2.pid
               inner join Emp e on d1.id = e.dept
 group by d1.id, d2.id
 with rollup;
 
select * from v_emp_dept;
 
select dept, dname, avg(salary) '평균급여', sum(salary) '급여합계'
  from v_emp_dept
 where dept between 3 and 5
 group by dept order by dept;
 
select '평균급여' as '구분',
    avg(case dept when 3 then 1 else 0 end) as '영업1팀',
    avg(case dept when 4 then 1 else 0 end) as '영업2팀',
    avg(case dept when 5 then 1 else 0 end) as '영업3팀'
  from v_emp_dept where dept between 3 and 5
UNION
select '급여합계' as '구분',
    sum(case dept when 3 then 1 else 0 end) as '영업1팀',
    sum(case dept when 4 then 1 else 0 end) as '영업2팀',
    sum(case dept when 5 then 1 else 0 end) as '영업3팀'
  from v_emp_dept where dept between 3 and 5;

-- JSON
select * from Emp;
alter table Emp add column remark json;

select * from Emp where id < 5;
update Emp set remark = '{"id": 1, "age": 30, "fam": [{"id": 1, "name": "유세차"}]}'
 where id = 2;

update Emp set remark = '{"id": 3, "age": 33, "fam": [{"id": 1, "name": "유세차"}, {"id":2, "name": "홍길숭"]}'
 where id = 3;

update Emp set remark = '{"id": 4, "age": 34, "fam": [{"id": 1, "name": "유세차"}]}'
 where id = 4;
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 