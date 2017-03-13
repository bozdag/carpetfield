
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

INSERT INTO game (name, description, address, time_of_creation, time_of_start, ORG_ID) VALUES ('oyun1', 'oyun 1 açıklama', 'oyun 1 adres', '2017-03-10 00:00:00', '2017-03-12 20:00:00', 1);
INSERT INTO game (name, description, address, time_of_creation, time_of_start, ORG_ID) VALUES ('oyun2', 'oyun 2 açıklama', 'oyun 2 adres', '2017-03-10 00:00:00', '2017-03-13 20:00:00', 2);
INSERT INTO game (name, description, address, time_of_creation, time_of_start, ORG_ID) VALUES ('oyun3', 'oyun 3 açıklama', 'oyun 3 adres', '2017-03-10 00:00:00', '2017-03-14 20:00:00', 1);
INSERT INTO game (name, description, address, time_of_creation, time_of_start, ORG_ID) VALUES ('oyun4', 'oyun 4 açıklama', 'oyun 4 adres', '2017-03-10 00:00:00', '2017-03-15 20:00:00', 2);

INSERT Into games_users (user_id, game_id) VALUES (1,1);
INSERT Into games_users (user_id, game_id) VALUES (2,1);
INSERT Into games_users (user_id, game_id) VALUES (3,1);
INSERT Into games_users (user_id, game_id) VALUES (4,1);

INSERT Into games_users (user_id, game_id) VALUES (1,3);
INSERT Into games_users (user_id, game_id) VALUES (2,2);
INSERT Into games_users (user_id, game_id) VALUES (3,3);
INSERT Into games_users (user_id, game_id) VALUES (4,4);

INSERT INTO invitation_response_type (id, status) VALUES (1, 'Not Responded');
INSERT INTO invitation_response_type (id, status) VALUES (2, 'Accepted');
INSERT INTO invitation_response_type (id, status) VALUES (3, 'Rejected');
INSERT INTO invitation_response_type (id, status) VALUES (4, 'Maybe Attend');

INSERT INTO invitation (context, invitation_time, GAME_ID, USER_ID, RESPONSE_TYPE_ID) VALUES ('davetiye1', '2017-03-10 17:00:00', 1, 1, 1);
INSERT INTO invitation (context, invitation_time, GAME_ID, USER_ID, RESPONSE_TYPE_ID) VALUES ('davetiye2', '2017-03-10 17:00:00', 2, 2, 1);
INSERT INTO invitation (context, invitation_time, GAME_ID, USER_ID, RESPONSE_TYPE_ID) VALUES ('davetiye3', '2017-03-10 17:00:00', 3, 3, 1);
INSERT INTO invitation (context, invitation_time, GAME_ID, USER_ID, RESPONSE_TYPE_ID) VALUES ('davetiye4', '2017-03-10 17:00:00', 4, 4, 1);

INSERT INTO team (name, description, GAME_ID) VALUES ('takım adı 1', 'takım açıklama 1', 1);
INSERT INTO team (name, description, GAME_ID) VALUES ('takım adı 2', 'takım açıklama 2', 1);
INSERT INTO team (name, description, GAME_ID) VALUES ('takım adı 3', 'takım açıklama 3', 3);
INSERT INTO team (name, description, GAME_ID) VALUES ('takım adı 4', 'takım açıklama 4', 4);

INSERT Into teams_users (user_id, team_id) VALUES (1,1);
INSERT Into teams_users (user_id, team_id) VALUES (2,2);
INSERT Into teams_users (user_id, team_id) VALUES (3,3);
INSERT Into teams_users (user_id, team_id) VALUES (4,4);
