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
        nextval('book_sequence'),
        'Poor Folk',
        currval('author_sequence'),
        currval('genre_sequence')
        );

----------------------------------------------------------------------------------------------------
-------COMMENT--------------------------------------------------------------------------------------

insert into comments(id, text, book_id)
values (
        nextval('comment_sequence'),
        'first comment',
        currval('book_sequence')
       );

insert into comments(id, text, book_id)
values (
           nextval('comment_sequence'),
           'second comment',
           currval('book_sequence')
       );

----------------------------------------------------------------------------------------------------
-------USERS----------------------------------------------------------------------------------------

insert into users(username, password, enabled)
values (
        'username',
        'password',
        true
        );

insert into authorities(username, authority)
values (
           'username',
           'USER'
       );
