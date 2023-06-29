----------------------------------------------------------------------------------------------------
-------AUTHORS--------------------------------------------------------------------------------------

create table if not exists authors
(
    id      bigint not null primary key,
    name    varchar(32) not null
);

create sequence author_sequence increment by 50;;

----------------------------------------------------------------------------------------------------
-------GENRES---------------------------------------------------------------------------------------

create table if not exists genres
(
    id      bigint not null primary key,
    name    varchar(32) not null
);

create sequence genre_sequence increment by 50;

----------------------------------------------------------------------------------------------------
-------BOOKS----------------------------------------------------------------------------------------

create table if not exists books
(
    id          bigint not null primary key,
    name        varchar(32) not null,
    author_id   bigint not null references authors (id),
    genre_id    bigint not null references genres (id)
);

create sequence book_sequence increment by 50;

----------------------------------------------------------------------------------------------------
-------COMMENT--------------------------------------------------------------------------------------

create table if not exists comments
(
    id          bigint not null primary key,
    text        varchar(128) not null,
    book_id     bigint not null references books (id)
);

create sequence comment_sequence increment by 50;

----------------------------------------------------------------------------------------------------
-------USERS----------------------------------------------------------------------------------------

create table if not exists users
(
    id          bigint not null primary key,
    username    varchar(32) not null,
    password    varchar(32) not null,
    role        varchar(32) not null,
    enabled     boolean not null default true
);

create sequence user_sequence increment by 50;
