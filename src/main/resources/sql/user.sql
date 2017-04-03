CREATE TABLE IF NOT EXISTS user (
	id INT(11) AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR (255),
  password INT(100) NOT NULL
);

INSERT INTO user(username, password) VALUE("xiaoli", "111111");