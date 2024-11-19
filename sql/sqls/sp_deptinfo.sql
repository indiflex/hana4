drop procedure if exists sp_deptinfo;

delimiter $$

CREATE DEFINER=`hana4`@`%` PROCEDURE `sp_deptinfo`(_dname varchar(31))
BEGIN
    select count(*) empcnt, format(avg(salary) * 10000, 0) avgsal
      from v_emp_dept 
     where dname = _dname;
    
END $$

delimiter ;
