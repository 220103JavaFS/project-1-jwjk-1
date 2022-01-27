DROP TABLE IF EXISTS user_roles CASCADE 
DROP TABLE IF EXISTS reimbursement_type CASCADE 
DROP TABLE IF EXISTS reimbursement_status CASCADE 
DROP TABLE IF EXISTS reimbursement CASCADE 
DROP TABLE IF EXISTS users CASCADE 

CREATE TABLE user_roles(
user_role_id INT PRIMARY KEY,
user_role VARCHAR(25)
);


INSERT INTO user_roles(user_role_id, user_role)
	VALUES( 1,'manager'),
	( 2,'employee');



CREATE TABLE reimbursement_type(
	reimb_type_id INT PRIMARY KEY,
	reimb_type VARCHAR(25)
);

INSERT INTO reimbursement_type(reimb_type_id, reimb_type)
	VALUES( 1 , 'supplies'),
	(2, 'travel'),
	(3, 'accomadation');



CREATE TABLE reimbursement_status(
reimb_status_id INT PRIMARY KEY,
reimb_status VARCHAR(10)
);

INSERT INTO reimbursement_status(reimb_status_id, reimb_status)
	VALUES(1, 'requested'),
	(2, 'accepted'),
	(3,'denied');


CREATE TABLE users(
	user_id SERIAL PRIMARY KEY,
	username VARCHAR(50) UNIQUE,
	passwords VARCHAR(50),
	user_first_name VARCHAR(100),
	user_last_name VARCHAR(100),
	user_email VARCHAR(150) UNIQUE,
	user_role_id INT REFERENCES user_roles(user_role_id)
);

INSERT INTO users(username, passwords, user_first_name, user_last_name, user_email, user_role_id)
	VALUES('PWhite', 'planetmanager156', 'perry', 'white', 'perry.white@dailyplanet.com', 1),
	('pultizerwinner', 'sup3rm@nst0r13s', 'lois', 'lane', 'llane@dailyplanet.com', 2),
	('superman', 'imsupermn', 'clark', 'kent', 'superman@dailyplanet.com', 1);
 

CREATE TABLE reimbursement(
reimb_id SERIAL PRIMARY KEY,
reimb_amount FLOAT,
reimb_submitted TIMESTAMP,
reimb_resolved TIMESTAMP,
reimb_description VARCHAR(250),
reimb_author INT REFERENCES users(user_id),
reimb_resolver INT REFERENCES users(user_id),
reimb_status_id INT REFERENCES reimbursement_status(reimb_status_id),
reimb_type_id INT REFERENCES reimbursement_type(reimb_type_id)
);

INSERT INTO reimbursement (reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_author, reimb_resolver, reimb_status_id, reimb_type_id)
	VALUES(5.00, '2022/01/21 07:40:00', '2022/01/21 07:45:00', 'coffee on my way to a story', 2, 1, 2, 1),
	(500.00, '2022/01/17 09:00:00', '2022/01/21 16:59:00', 'car rental to report on the meteroplis football playoffs game', 3, 1, 1, 2);











