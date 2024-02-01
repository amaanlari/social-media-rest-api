INSERT INTO user_details(date_of_birth, id, username)
VALUES ( DATE '2002-01-01', 1, 'Shreyashi'),
       ( DATE '2001-12-30', 2, 'Amisha'),
       ( DATE '2004-01-01', 3, 'Nishi');

INSERT INTO POST (ID, DESCRIPTION, USER_ID)
VALUES ( 1001, 'I want to learn azure',  1),
       ( 1002, 'I want to learn docker', 1),
       ( 1003, 'I want to learn javascript', 1);