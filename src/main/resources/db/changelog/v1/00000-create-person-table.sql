CREATE TABLE if not exists person
(
    id         bigint primary key generated by default as identity,
    last_name  varchar(255)             not null,
    first_name int                      not null,
    password   varchar                  not null,
    email      varchar(255) unique      not null,
    last_visit timestamp with time zone not null,
    username   varchar                  not null,
    updateDate timestamp with time zone not null,
    createDate timestamp with time zone not null,
    role       varchar                  not null
);

