--DROP TABLE IF EXISTS user;
 
--CREATE TABLE user (
--  id BIGINT AUTO_INCREMENT  PRIMARY KEY,
--  user_name VARCHAR(250) NOT NULL,
--  role VARCHAR(100) NOT NULL
--);

 
INSERT INTO user (user_name, role) VALUES ('Test User', 'Default');
insert into User_Cache_Log (user_id) values (1); 