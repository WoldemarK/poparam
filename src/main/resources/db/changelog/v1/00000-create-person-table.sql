CREATE TABLE person
(
    id            bigint primary key generated by default as identity,
    username      varchar(100) not null,
    year_of_birth int          not null,
    password      varchar      not null
);
insert into person(username, password, year_of_birth)values ('test', 123, 1990);
insert into person(username, password,year_of_birth)values ('test1', 321, 1991);