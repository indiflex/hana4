select * from Dept;
desc Dept;
select * from Emp where auth < 9;
desc Emp;

WITH RECURSIVE CteDept(id, pid, dname, captain, depth, h) AS (
  select id, pid, dname, captain, 0, cast(id as char(10)) from Dept where pid = 0
  UNION ALL
  select d.id, d.pid, d.dname, d.captain, depth + 1, concat(c.h, '-', d.id)
    from CteDept c inner join Dept d on c.id = d.pid
) 
select id, pid, dname, captain, depth
  from CteDept c order by c.h;

