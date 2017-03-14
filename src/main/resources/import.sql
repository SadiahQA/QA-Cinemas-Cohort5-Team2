INSERT INTO ACTOR(IDACTOR, DOB, FIRSTNAME, GENDER, LASTNAME) VALUES (1, '1987-11-10', 'Some', 'Male', 'GUY');
INSERT INTO ACTOR(IDACTOR, DOB, FIRSTNAME, GENDER, LASTNAME) VALUES (2, '1989-11-10', 'Some', 'Male', 'Other Guy');
INSERT INTO ACTOR(IDACTOR,DOB, FIRSTNAME, GENDER, LASTNAME) VALUES (3, '1971-11-10', 'Some', 'Male', 'Further Guy');
INSERT INTO CINEMA(IDCINEMA, CITY, NAME, OPENINGTIMES) VALUES (1, 'Manchester', 'QAC Manch', 'Times');
INSERT INTO CINEMA(IDCINEMA, CITY, NAME, OPENINGTIMES) VALUES (2, 'Liverpool', 'QAC Liver', 'OtherTimes');
INSERT INTO CINEMA(IDCINEMA, CITY, NAME, OPENINGTIMES) VALUES (3, 'Dorset', 'QAC Dorset', 'FurtherTimes');
INSERT INTO MOVIE(IDMOVIE, CERTIFICATION, DESCRIPTION, DURATION, GENRE, POSTERURL, RELEASEDATE, TITLE)	VALUES (1, 'U', 'Bruce Wayne must not only deal with the criminals of Gotham City, but also the responsibility of raising a boy he adopted.', '104m', 'Animation, Action, Adventure', 'https://images-na.ssl-images-amazon.com/images/M/MV5BMTcyNTEyOTY0M15BMl5BanBnXkFtZTgwOTAyNzU3MDI@._V1_SY1000_CR0,0,674,1000_AL_.jpg', '2017-02-10', 'The LEGO Batman Movie');
INSERT INTO MOVIE(IDMOVIE, CERTIFICATION, DESCRIPTION, DURATION, GENRE, POSTERURL, RELEASEDATE, TITLE) VALUES (2, '12A', 'A team of scientists, soldiers and adventurers unites to explore an uncharted island in the Pacific. Cut off from everything they know, the team ventures into the domain of the mighty Kong. As their mission becomes one of survival, they must fight to escape a primal Eden.', '118m', 'Action, Adventure, Fantasy', 'https://images-na.ssl-images-amazon.com/images/M/MV5BMTUwMzI5ODEwNF5BMl5BanBnXkFtZTgwNjAzNjI2MDI@._V1_SY1000_CR0,0,674,1000_AL_.jpg', '2017-03-09', 'Kong: Skull Island');
INSERT INTO MOVIE(IDMOVIE, CERTIFICATION, DESCRIPTION, DURATION, GENRE, POSTERURL, RELEASEDATE, TITLE) VALUES (3, '15', 'In the near future, a weary Logan cares for an ailing Professor X in a hide out on the Mexican border. But Logans attempts to hide from the world and his legacy are up-ended when a young mutant arrives, being pursued by dark forces.', '137m', 'Action, Drama, Sci-Fi', 'https://images-na.ssl-images-amazon.com/images/M/MV5BMjI1MjkzMjczMV5BMl5BanBnXkFtZTgwNDk4NjYyMTI@._V1_SY1000_CR0,0,676,1000_AL_.jpg', '2017-03-01', 'Logan');
INSERT INTO SCREEN(IDSCREEN, ISDIRECTORSBOX, NOOFSEATS, SCREENNUM, SCREENTYPE, CINEMA_IDCINEMA) VALUES (1, 'false', '120', '1', '3D', 1);
INSERT INTO SCREEN(IDSCREEN, ISDIRECTORSBOX, NOOFSEATS, SCREENNUM, SCREENTYPE, CINEMA_IDCINEMA) VALUES (2, 'true', '50', '1', '3D', 2);
INSERT INTO SCREEN(IDSCREEN, ISDIRECTORSBOX, NOOFSEATS, SCREENNUM, SCREENTYPE, CINEMA_IDCINEMA) VALUES (3, 'false', '120', '1', '3D', 3);
INSERT INTO SHOWING(IDSHOWING, AVAILABLESEATS, SHOWINGTYPE, STARTTIME, MOVIE_IDMOVIE, SCREEN_IDSCREEN, SHOWINGDATE) VALUES (1, '119', '3D', '7pm', 1, 1, '2017-03-14');
INSERT INTO SHOWING(IDSHOWING, AVAILABLESEATS, SHOWINGTYPE, STARTTIME, MOVIE_IDMOVIE, SCREEN_IDSCREEN, SHOWINGDATE) VALUES (2, '49', '3D', '7pm', 2, 2, '2017-03-14');
INSERT INTO SHOWING(IDSHOWING, AVAILABLESEATS, SHOWINGTYPE, STARTTIME, MOVIE_IDMOVIE, SCREEN_IDSCREEN, SHOWINGDATE) VALUES (3, '119', '3D', '7pm', 3, 3, '2017-03-15');
INSERT INTO SHOWING(IDSHOWING, AVAILABLESEATS, SHOWINGTYPE, STARTTIME, MOVIE_IDMOVIE, SCREEN_IDSCREEN, SHOWINGDATE) VALUES (4, '0', '3D', '4pm', 1, 1, '2017-03-14');
INSERT INTO SHOWING(IDSHOWING, AVAILABLESEATS, SHOWINGTYPE, STARTTIME, MOVIE_IDMOVIE, SCREEN_IDSCREEN, SHOWINGDATE) VALUES (5, '25', '3D', '4pm', 2, 1, '2017-03-14');
INSERT INTO SHOWING(IDSHOWING, AVAILABLESEATS, SHOWINGTYPE, STARTTIME, MOVIE_IDMOVIE, SCREEN_IDSCREEN, SHOWINGDATE) VALUES (6, '100', '2D', '4pm', 3, 1, '2017-03-15');
INSERT INTO SHOWING(IDSHOWING, AVAILABLESEATS, SHOWINGTYPE, STARTTIME, MOVIE_IDMOVIE, SCREEN_IDSCREEN, SHOWINGDATE) VALUES (7, '20', '2D', '12pm', 2, 1, '2017-03-14');
INSERT INTO SHOWING(IDSHOWING, AVAILABLESEATS, SHOWINGTYPE, STARTTIME, MOVIE_IDMOVIE, SCREEN_IDSCREEN, SHOWINGDATE) VALUES (8, '19', '2D', '12pm', 1, 1, '2017-03-15');
INSERT INTO USER(ID, DOB, EMAIL, FIRSTNAME, LASTNAME, PASSWORD, ACTIVE) VALUES (1, '2001-11-11', 'anemail', 'Some', 'Guy', 'hashpass', TRUE);
INSERT INTO USER(ID, DOB, EMAIL, FIRSTNAME, LASTNAME, PASSWORD, ACTIVE) VALUES (2, '1999-11-11', 'anotheremail', 'Some', 'Other Guy', 'hashpass', TRUE);
INSERT INTO USER(ID, DOB, EMAIL, FIRSTNAME, LASTNAME, PASSWORD, ACTIVE) VALUES (3, '1989-11-11', 'anfurtheremail', 'Some', 'Other Guy', 'hashpass', FALSE);
INSERT INTO TICKET(IDTICKET, TICKETTYPE, SHOWING_IDSHOWING, USER_IDUSER) VALUES (1, 'Normal', 1, 1);
INSERT INTO TICKET(IDTICKET, TICKETTYPE, SHOWING_IDSHOWING, USER_IDUSER)VALUES (2, 'Normal', 2, 2);
INSERT INTO TICKET(IDTICKET, TICKETTYPE, SHOWING_IDSHOWING, USER_IDUSER) VALUES (3, 'Normal', 3, 3);
INSERT INTO ACTOR_HAS_MOVIE(MOVIE_IDMOVIE, ACTOR_IDACTOR) VALUES (1, 1);
INSERT INTO ACTOR_HAS_MOVIE(MOVIE_IDMOVIE, ACTOR_IDACTOR) VALUES (2, 2);
INSERT INTO ACTOR_HAS_MOVIE(MOVIE_IDMOVIE, ACTOR_IDACTOR) VALUES (3, 3);