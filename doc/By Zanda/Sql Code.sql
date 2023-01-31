create database bancoStudents;

use bancoStudents;

create table student(
	id integer auto_increment primary key,
    nome varchar(200) not null,
    senha varchar(200) not null,
    cra integer not null
);

insert into student values ( null, 'Daniel','daniel123', 70); 