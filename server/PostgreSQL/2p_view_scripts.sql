SELECT cards.card_id AS ticketId,
	cards.ticket_status AS ticketStatus,
	users.firstname AS userFirstName,
	users.lastname AS userLastName,
	users.user_img AS userImage,
	users.firstname AS adminFirstName,
	users.lastname AS adminLastName,
	cards.entry_time AS datePosted,
	cards.date_resolved AS dateResolved,
	cards.title AS title,
	cards.message AS message
FROM cards c
LEFT JOIN users
ON 

CREATE VIEW reactuser AS
SELECT users.user_img AS userImage,
	users.username AS username,
	user_types.user_type_name AS userRole
	FROM users
	LEFT JOIN user_types
	ON user_type_id = user_type;
	
CREATE 

CREATE TABLE user_types (
	user_type_id int PRIMARY KEY UNIQUE NOT NULL,
	user_type_name varchar(8) UNIQUE NOT NULL
	);
	
alter table users add user_type_id int;

update users
   set user_type_id = user_types.user_type_id
from user_types
where a.user_type = b.tractfips;

ALTER TABLE users
DROP COLUMN user_type_id int
REFERENCES user_types(user_type_id);

INSERT INTO user_types(user_type_id, user_type_name)
VALUES
	(0, 'employee'),
	(1, 'admin');