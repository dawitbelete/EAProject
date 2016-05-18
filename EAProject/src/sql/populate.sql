INSERT INTO credentials(username,password,enabled) VALUES ('guest','$2a$06$hbXPAiaqNc8p8hKIzW8.mexShs9fTc/syLZiwoUHVrRNQJ48sU3mC', TRUE);
INSERT INTO credentials(username,password,enabled) VALUES ('admin','$2a$06$KoOnHC1Q1eAoAiTe/c7qN.TiNhNaRU/JS0.RRMEHg6ax.gg5S.uDi', TRUE);
INSERT INTO credentials(username,password,enabled) VALUES ('admin1','$2a$06$KoOnHC1Q1eAoAiTe/c7qN.TiNhNaRU/JS0.RRMEHg6ax.gg5S.uDi', TRUE);

INSERT INTO Authority (username, authority) VALUES ('guest', 'ROLE_USER');
INSERT INTO Authority (username, authority) VALUES ('admin', 'ROLE_ADMIN');
INSERT INTO Authority (username, authority) VALUES ('admin', 'ROLE_USER');
INSERT INTO Authority (username, authority) VALUES ('admin1', 'ROLE_ADMIN');

INSERT INTO users (firstname,lastname,email,rank,userid,IS_ADMIN,version) VALUES ('Curious','George','aloaiza@mum.edu',1,'admin',1,1);
INSERT INTO users (firstname,lastname,email,rank,userid,IS_ADMIN,version) VALUES ('Admin1','Admin1','admin1@mum.edu',2,'admin1',1,1);
INSERT INTO users (firstname,lastname,email,rank,userid,IS_ADMIN,version) VALUES ('Allen','Rench','allen@rench.com',3,'guest',0,1);

INSERT INTO item (ITEM_ID,APPROVAL_DATETIME,CREATED,DESCRIPTION,END_DATE,initialPrice,ITEM_NAME,reservePrice,START_DATE,OBJ_VERSION,itemSellerId) VALUES (1,NULL,'2016-05-16 14:04:30','6 foot tall spider man figure',NULL,19.95,'Ant Man Figure',NULL,NULL,1,NULL);
INSERT INTO item (ITEM_ID,APPROVAL_DATETIME,CREATED,DESCRIPTION,END_DATE,initialPrice,ITEM_NAME,reservePrice,START_DATE,OBJ_VERSION,itemSellerId) VALUES (2,NULL,'2016-05-16 14:05:41','6 foot tall spiderman figure',NULL,19.95,'Spiderman Figure',NULL,NULL,0,NULL);
INSERT INTO item (ITEM_ID,APPROVAL_DATETIME,CREATED,DESCRIPTION,END_DATE,initialPrice,ITEM_NAME,reservePrice,START_DATE,OBJ_VERSION,itemSellerId) VALUES (3,NULL,'2016-05-16 14:05:43','NBA Legends',NULL,15.95,'NBA Legends',NULL,NULL,0,NULL);


INSERT INTO address(id,city,street,zipcode,user_USER_ID) VALUES (1,'FAIRFIELD','802 S 9th Street',52556,1);

INSERT INTO category(id,description,name)VALUES(1,'Entertaiment Section','Toys');
INSERT INTO category(id,description,name)VALUES(2,'Sports Section','Sports');
INSERT INTO category(id,description,name)VALUES(3,'Electronics Section','Electronics');
INSERT INTO category(id,description,name)VALUES(4,'Beauty Section','Beauty');
INSERT INTO category(id,description,name)VALUES(5,'Books Section','Books');

INSERT INTO item_category(items_ITEM_ID,categories_id)VALUES(1,1);
INSERT INTO item_category(items_ITEM_ID,categories_id)VALUES(2,1);
INSERT INTO item_category(items_ITEM_ID,categories_id)VALUES(3,2);
INSERT INTO item_category(items_ITEM_ID,categories_id)VALUES(3,5);