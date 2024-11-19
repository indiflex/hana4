drop procedure if exists sp_emprange;

delimiter $$

CREATE DEFINER=`hana4`@`%` PROCEDURE `sp_emprange`(_sid int, _eid int)
xxx:BEGIN
    declare v_sid int default _sid;
    declare v_eid int default _eid;
    
    IF _sid < 0 and _eid < 0 THEN
        leave xxx;
    END IF;
    
    IF _sid > _eid THEN
        set v_sid = _eid;
        set v_eid = _sid;
    END IF;
    
    select * from Emp where id between v_sid and v_eid;
END $$

delimiter ;
