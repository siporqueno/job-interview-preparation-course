create table students
(
    id   bigint auto_increment,
    name varchar(255) not null,
    age  int          not null,
    constraint students_pk
        primary key (id)
);