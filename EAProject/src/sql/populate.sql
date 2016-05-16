 
INSERT INTO credentials(username,password,enabled) VALUES ('guest','guest', TRUE);
INSERT INTO credentials(username,password,enabled) VALUES ('admin','admin', TRUE);
 
INSERT INTO authority (username, authority) VALUES ('guest', 'ROLE_USER');
INSERT INTO authority (username, authority) VALUES ('admin', 'ROLE_ADMIN');
INSERT INTO authority (username, authority) VALUES ('admin', 'ROLE_USER');

INSERT INTO users (firstname,lastname,email,rank,userid,IS_ADMIN,version) VALUES ('Curious','George','curious@george.com',2,'admin',1,1);
INSERT INTO users (firstname,lastname,email,rank,userid,IS_ADMIN,version) VALUES ('Allen','Rench','allen@rench.com',3,'guest',0,1);

					