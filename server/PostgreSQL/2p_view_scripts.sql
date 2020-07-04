CREATE VIEW react_ticket AS
	SELECT cards.card_id AS ticket_id,
		cards.ticket_status AS ticket_status,
		u1.firstname AS user_first_name,
		u1.lastname AS user_last_name,
		u1.username AS user_name,
		u1.user_img AS user_image,
		u2.firstname AS admin_first_name,
		u2.lastname AS admin_last_name,
		cards.entry_time AS date_posted,
		cards.date_resolved AS date_resolved,
		cards.title AS title,
		cards.message AS message
	FROM cards
	LEFT JOIN users u1
	ON u1.uid = cards.user_id
	LEFT JOIN users u2
	ON u2.uid = cards.admin_id
	ORDER BY cards.entry_time DESC;

CREATE VIEW react_user AS
	SELECT users.username AS user_name,
		users.firstname AS first_name,
		users.lastname AS last_name,
		user_roles.user_role_name AS user_role,
		users.user_img AS userImage
	FROM users
	LEFT JOIN user_roles
	ON user_role_id = user_type;
	
CREATE VIEW react_reply AS
	SELECT replies.rid AS rid,
		replies.tpid AS ticket_post_id,
		replies.entry_time AS timestamp,
		users.firstname AS user_first_name,
		users.lastname AS user_last_name,
		users.username AS user_name,
		users.user_img AS user_image,
		replies.replies AS replies
	FROM replies
	LEFT JOIN users
	ON users.uid = replies.user_id 
	ORDER BY replies.entry_time DESC;
	

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