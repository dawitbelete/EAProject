 
INSERT INTO credentials(username,password,enabled) VALUES ('guest','guest', TRUE);
INSERT INTO credentials(username,password,enabled) VALUES ('admin','admin', TRUE);
 
INSERT INTO authority (username, authority) VALUES ('guest', 'ROLE_USER');
INSERT INTO authority (username, authority) VALUES ('admin', 'ROLE_ADMIN');
INSERT INTO authority (username, authority) VALUES ('admin', 'ROLE_USER');

INSERT INTO users (firstname,lastname,email,rank,userid,IS_ADMIN,version) VALUES ('Curious','George','curious@george.com',2,'admin',1,1);
INSERT INTO users (firstname,lastname,email,rank,userid,IS_ADMIN,version) VALUES ('Allen','Rench','allen@rench.com',3,'guest',0,1);

INSERT INTO item (ITEM_ID,APPROVAL_DATETIME,CREATED,DESCRIPTION,END_DATE,initialPrice,ITEM_NAME,reservePrice,START_DATE,OBJ_VERSION,itemSellerId) VALUES (1,NULL,'2016-05-16 14:04:30','6 foot tall spider man figure',NULL,19.95,'Ant Man Figure',NULL,NULL,1,NULL);
INSERT INTO item (ITEM_ID,APPROVAL_DATETIME,CREATED,DESCRIPTION,END_DATE,initialPrice,ITEM_NAME,reservePrice,START_DATE,OBJ_VERSION,itemSellerId) VALUES (2,NULL,'2016-05-16 14:05:41','6 foot tall spiderman figure',NULL,19.95,'Spiderman Figure',NULL,NULL,0,NULL);

INSERT INTO address(id,city,street,zipcode,user_USER_ID) VALUES (1,'FAIRFIELD','802 S 9th Street',52556,1);