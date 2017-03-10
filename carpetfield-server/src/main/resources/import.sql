
-- userId table test data
INSERT INTO user (email, password_hash, role) VALUES ('root@gmail.com', '12345', 'ADMIN');
INSERT INTO user (email, password_hash, role) VALUES ('selcuk.bozdag@gmail.com', '12345', 'USER');
INSERT INTO user (email, password_hash, role) VALUES ('albayrakalican@gmail.com', '12345', 'USER');
INSERT INTO user (email, password_hash, role) VALUES ('skiranoglu@gmail.com', '12345', 'USER');



INSERT INTO organization (name, description) VALUES ('şentepe', 'ayhanın halısaha takımı');
INSERT INTO organization (name, description) VALUES ('ayss', 'ayesas halısaha grubu');


INSERT Into CF_MEMBERSHIP (USER_ID, ORG_ID, IS_OWNER ) VALUES (1,1,false);
INSERT Into CF_MEMBERSHIP (USER_ID, ORG_ID, IS_OWNER ) VALUES (2,1,true);
INSERT Into CF_MEMBERSHIP (USER_ID, ORG_ID, IS_OWNER ) VALUES (3,1,false);
INSERT Into CF_MEMBERSHIP (USER_ID, ORG_ID, IS_OWNER ) VALUES (4,1,false);

INSERT Into CF_MEMBERSHIP (USER_ID, ORG_ID, IS_OWNER ) VALUES (1,2,0);
INSERT Into CF_MEMBERSHIP (USER_ID, ORG_ID, IS_OWNER ) VALUES (2,2,0);
INSERT Into CF_MEMBERSHIP (USER_ID, ORG_ID, IS_OWNER ) VALUES (3,2,1);
INSERT Into CF_MEMBERSHIP (USER_ID, ORG_ID, IS_OWNER ) VALUES (4,2,0);

INSERT INTO game (name, description, address, time_of_creation, time_of_start) VALUES ('oyun1', 'oyun 1 açıklama', 'oyun 1 adres', '2017-03-10 00:00:00', '2017-03-12 20:00:00');
INSERT INTO game (name, description, address, time_of_creation, time_of_start) VALUES ('oyun2', 'oyun 2 açıklama', 'oyun 2 adres', '2017-03-10 00:00:00', '2017-03-13 20:00:00');
