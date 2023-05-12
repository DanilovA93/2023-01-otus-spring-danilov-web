----------------------------------------------------------------------------------------------------
-------AUTHORS--------------------------------------------------------------------------------------

insert into authors(id, name) values (nextval('author_sequence'), 'Stephen King');
insert into authors(id, name) values (nextval('author_sequence'), 'Fyodor Dostoevsky');

----------------------------------------------------------------------------------------------------
-------GENRES---------------------------------------------------------------------------------------

insert into genres(id, name) values (nextval('genre_sequence'), 'Horror');
insert into genres(id, name) values (nextval('genre_sequence'), 'Roman');

----------------------------------------------------------------------------------------------------
-------BOOKS----------------------------------------------------------------------------------------

insert into books(id, name, author_id, genre_id)
values (
        nextval('book_sequence'), 'The Brothers Karamazov',
        currval('author_sequence'), currval('genre_sequence')
        );

insert into books(id, name, author_id, genre_id)
values (
        nextval('book_sequence'), 'Poor Folk',
        currval('author_sequence'), currval('genre_sequence')
        );

----------------------------------------------------------------------------------------------------
-------COMMENT--------------------------------------------------------------------------------------
