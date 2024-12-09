desc Code;
desc CodeInfo;
desc SubCode;

select * from Code;
alter table SubCode modify column value varchar(32) not null;
select * from CodeInfo;
select * from SubCode;

select * from CodeUser;
desc CodeUser;
drop table CodeUser;

select *
  from Code c inner join CodeInfo ci on c.id = ci.code; 

drop table CodeInfo;
drop table Code;
drop table Code_codeUsers;