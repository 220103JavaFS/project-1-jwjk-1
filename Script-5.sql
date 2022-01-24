DROP TABLE IF EXISTS user_roles

CREATE TABLE user_roles(
	user_role_id PRIMARY KEY,
	user_role VARCHAR(25)
);


INSERT INTO user_roles(user_role_id, user_role)
	VALUES( 1,'admin'),
	( 2,'employee'),
	( 3,'employee');