create table TICKET_STATUS (
	TID INTEGER primary key,
	ticket_status VARCHAR(8)
);

create table USERS (
	UID INTEGER generated always as identity primary key,
	user_type INTEGER,
	username VARCHAR(50) unique,
	userpass VARCHAR(100),
	hash VARCHAR,
	salt VARCHAR,
	user_img VARCHAR,
	firstname VARCHAR(100),
	lastname VARCHAR(100),
	email VARCHAR(100) unique,
	rating_sigma DECIMAL,
	times_rated INTEGER
);

create table CARDS (
	card_ID INTEGER generated always as identity primary key,
	ticket_status INTEGER references TICKET_STATUS (TID),
	user_ID INTEGER references USERS (UID),
	admin_ID INTEGER references USERS (UID),
	entry_time TIMESTAMP,
	title VARCHAR(100),
	message VARCHAR(1500)
);

create table REPLIES (
	CID INTEGER generated always as identity primary key,
	TPID INTEGER references CARDS (card_ID),
	user_ID INTEGER references USERS (UID),
	entry_time TIMESTAMP,
	replies VARCHAR(1500)
);

grant usage on schema public to p2_admin;
grant select, update, insert on all tables in schema public to p2_admin;

-- View for get request for the dummy server. Drop view command here just in case
drop view all_tickets_and_posts;

create view all_tickets_and_posts as
select card_id,
	cards.title,
	cards.entry_time,
	cards.date_resolved,
	users.firstname,
	users.lastname,
	users.user_img_id,
	cards.message,
	cards.ticket_status,
	cards.admin_id
	from cards
	left join users on cards.user_id = users.uid
	left join user_img on users.user_img_id = user_img.uiid;

-- Initial dummy data inserted if needed

insert into ticket_status (ticket_status)
	values
	('Post'), 
	('Pending'), 
	('Accepted'), 
	('Resolved');

select * from ticket_status;
	
insert into user_img (user_img)
	values
	('img1'),
	('img2'),
	('img3');
	
select * from user_img;

insert into users 
(user_img_id, 
user_type, 
username, 
userpass, 
hash, 
salt,
firstname,
lastname,
email)
values
(
1, 
1, 
'hughthorn', 
'1234', 
'hahshshdfsadfklj', 
'saltdafs;ldjkseio', 
'Hugh', 
'Thornhill', 
'hugh@gmail.com'
);

insert into users 
(user_img_id, 
user_type, 
username, 
userpass, 
hash, 
salt,
firstname,
lastname,
email,
rating_sigma,
times_rated
)
values
(
2, 
2, 
'admin', 
'1234', 
'hahshshdfsadfklj', 
'saltdafs;ldjkseio', 
'Jon', 
'Smith', 
'jsmith@gmail.com',
5,
1
);

select * from users;

insert into cards
(
ticket_status,
user_id,
admin_id,
entry_time,
date_resolved,
title,
message
)
values
(
3,
1,
2,
'2020-06-30 12:00',
'2020-06-30 13:00',
'Ticket title',
'Loreum ipsum'
);

insert into cards
(
ticket_status,
user_id,
admin_id,
entry_time,
date_resolved,
title,
message
)
values
(
0,
1,
2,
'2020-06-30 12:00',
null,
'Ticket title',
'Loreum ipsum'
);

select * from cards;

insert into replies (tpid, user_id, entry_time, replies)
values (1, 1, '2020-6-30 12:10', 'blahblah blah');

insert into replies (tpid, user_id, entry_time, replies)
values (2, 2, '2020-6-30 12:11', 'blahblah blahblah');

select * from replies;