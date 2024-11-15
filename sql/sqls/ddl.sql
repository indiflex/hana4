create table Student (
  id mediumint unsigned not null auto_increment comment '학번',
  createdate timestamp DEFAULT CURRENT_TIMESTAMP COMMENT '등록일시',
  updatedate timestamp DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '등록일시',
  name varchar(31) not null comment '이름',
  birthdt varchar(6) not null comment '생일(YYMMDD)',
  major tinyint unsigned not null comment '학과코드',
  mobile varchar(15) not null comment '전화번호',
  email varchar(150) not null comment '이메일주소',
  gender boolean not null default 0 comment '성별(0:여성, 1:남성)',
  graduatedt date null comment '졸업일',
  PRIMARY KEY (id),
  UNIQUE KEY uniq_Student_email(email),
  UNIQUE KEY uniq_Student_name_mobile(name, mobile)
);

alter table Student modify column name varchar(25) not null default '' comment '학생명';
alter table Student modify column major tinyint unsigned null comment '학과코드';

alter table Student add constraint foreign key fk_Student_major_Major(major) 
    references Major(id) on DELETE set null on UPDATE cascade;

desc Student;

create table Major (
  id tinyint unsigned not null auto_increment primary key comment '학과코드',
  name varchar(20) not null comment '학과명'
);