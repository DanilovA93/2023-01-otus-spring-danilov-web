----------------------------------------------------------------------------------------------------
-------AUTHORS--------------------------------------------------------------------------------------

create table if not exists authors
(
    id      bigint not null primary key auto_increment,
    name    varchar(32) not null
);

----------------------------------------------------------------------------------------------------
-------GENRES---------------------------------------------------------------------------------------

create table if not exists genres
(
    id      bigint not null primary key auto_increment,
    name    varchar(32) not null
);

----------------------------------------------------------------------------------------------------
-------BOOKS----------------------------------------------------------------------------------------

create table if not exists books
(
    id          bigint not null primary key auto_increment,
    name        varchar(32) not null,
    author_id   bigint not null references authors (id),
    genre_id    bigint not null references genres (id)
);

----------------------------------------------------------------------------------------------------
-------COMMENT--------------------------------------------------------------------------------------

create table if not exists comments
(
    id          bigint not null primary key auto_increment,
    text        varchar(128) not null,
    book_id     bigint not null references books (id)
);