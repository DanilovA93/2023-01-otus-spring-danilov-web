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

create table users(
                      username varchar(50) not null primary key,
                      password varchar(500) not null,
                      enabled boolean not null
);

----------------------------------------------------------------------------------------------------
-------AUTHORITIES----------------------------------------------------------------------------------

create table authorities (
                             username varchar(50) not null,
                             authority varchar(50) not null,
                             constraint fk_authorities_users foreign key(username) references users(username)
);

create unique index ix_auth_username on authorities (username,authority);
