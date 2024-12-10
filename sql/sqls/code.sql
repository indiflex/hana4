desc Code;
desc CodeInfo;
desc SubCode;

select * from Code;
alter table SubCode modify column value varchar(32) not null;
select * from CodeInfo;
select * from SubCode;

select *
  from Code c inner join CodeInfo ci on c.id = ci.code; 

drop table CodeInfo;
drop table Code;

desc CodeUser;
-- drop table CodeUser;
select * from Code;
select * from SubCode;
-- truncate table SubCode;

select * from CodeInfo;
select * from CodeUser;
select * from DemoUser;

select *
  from Code c inner join CodeUser cu on c.id = cu.code
              inner join DemoUser u on cu.user = u.id;

delete from DemoUser where id > 2;
ALTER TABLE `testdb`.`DemoUser`  AUTO_INCREMENT = 3;


truncate table CodeUser;
truncate table Code;
truncate table DemoUser;

select * from Post;
-- insert into Post(body, 