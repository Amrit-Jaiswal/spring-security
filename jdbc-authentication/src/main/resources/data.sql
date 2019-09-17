insert into users(username, password, enabled)
values('user', 'password', true);

insert into users(username, password, enabled)
values('admin', 'password', true);

insert into authorities(username, authority)
values('user', 'ROLE_USER');

insert into authorities(username, authority)
values('admin', 'ROLE_ADMIN');
