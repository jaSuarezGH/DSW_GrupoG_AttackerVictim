

---------------------( USER )--------------------------------

insert into user (firstname, lastname, username, personal_id, email, mac_address, password) values
('Mariangel', 'Torres', 'marpastelito', '26260787', 'mariangeltsilva@gmail.com', '01-B2-D1-64-C1-27', 'azul'),
('Jesus', 'Manuel', 'jesumanu', '29552507', 'jesumanu@gmail.com', '00-B0-D0-63-C2-26', 'amarillo');


---------------------( VICTIM )------------------------------

insert into victim (user) values
(1);


---------------------( ATTACKER )----------------------------

insert into attacker (user) values
(2);


---------------------( INCIDENT )----------------------------

insert into incident (victim, attacker, separation_distance) values 
(1, 1, 15);


---------------------( COORDINATE )--------------------------

insert into coordinate (latitude, longitude) values 
------- UCAB ---------
(10.464380, -66.978726), -- 1
(10.465496, -66.977413),
(10.465927, -66.975895),
(10.465469, -66.973420),
(10.464810, -66.973215),
(10.463035, -66.976306),
(10.460823, -66.976544),
(10.460653, -66.977628),

------- CCCT ---------
(10.483704, -66.854637), -- 9
(10.484474, -66.856429),
(10.486902, -66.853886),
(10.484648, -66.853892),
(10.483693, -66.854962),

------- Res. Los Arboles ---------
(10.488275, -66.881860), -- 14
(10.487842, -66.882034),
(10.487581, -66.881463),
(10.487407, -66.880948),
(10.487866, -66.880763),
(10.488077, -66.881401),

------- Sambil Chacao ---------
(10.490457,	-66.855010), -- 20
(10.490288,	-66.853594),
(10.488280,	-66.853664),
(10.487270,	-66.855157),
(10.488954,	-66.855108),

------- Centro Santa Ines ---------
(10.466897, -66.974411), -- 25 
(10.466316, -66.974622), 
(10.466070, -66.973378), 
(10.466713, -66.973387), 

------- Modulo 8 ---------
(10.466693, -66.973746), -- 29
(10.466096, -66.973840),
(10.466105, -66.972373),
(10.466757, -66.972532),

------- Casa (Generica) ---------
(10.471661, -66.957097), -- 33 
(10.471789, -66.956520), 
(10.471314, -66.957001), 
(10.471402, -66.956420),

------- CC El Recreo ---------
(10.491223,	-66.876976), -- 37
(10.492088,	-66.876705),
(10.492016,	-66.877281),
(10.491761,	-66.877501),
(10.491399,	-66.877617),

------- CC El Tolon ---------	
(10.479523, -66.860997), -- 42
(10.480477, -66.860981),
(10.481176, -66.860930),
(10.480467, -66.860129),
(10.480047, -66.860544);



---------------------( SAFE ZONE )---------------------------

insert into safe_zone (name, user, coordinate) values
('CC EL TOLON', 1, 42), -- Hay ultima posicion de atacante en esta zona
('CC EL TOLON', 1, 43),
('CC EL TOLON', 1, 44),
('CC EL TOLON', 1, 45),
('CC EL TOLON', 1, 46),
('CC EL RECREO', 1, 37),
('CC EL RECREO', 1, 38),
('CC EL RECREO', 1, 39),
('CC EL RECREO', 1, 40),
('CC EL RECREO', 1, 41),
-----------------
('CASA', 1, 33),
('CASA', 1, 34),
('CASA', 1, 35),
('CASA', 1, 36),
('SAMBIL CHACAO', 1, 20),
('SAMBIL CHACAO', 1, 21),
('SAMBIL CHACAO', 1, 22),
('SAMBIL CHACAO', 1, 23),
('SAMBIL CHACAO', 1, 24),
-----------------
('CCCT', 1, 9), -- Hay ultima posicion de atacante en esta zona
('CCCT', 1, 10),
('CCCT', 1, 11),
('CCCT', 1, 12),
('CCCT', 1, 13),
-----------------
('RES. LOS ARBOLES', 1, 14),
('RES. LOS ARBOLES', 1, 15),
('RES. LOS ARBOLES', 1, 16),
('RES. LOS ARBOLES', 1, 17),
('RES. LOS ARBOLES', 1, 18),
('RES. LOS ARBOLES', 1, 19),
-----------------
('UCAB', 1, 1),
('UCAB', 1, 2),
('UCAB', 1, 3),
('UCAB', 1, 4),
('UCAB', 1, 5),
('UCAB', 1, 6),
('UCAB', 1, 7),
('UCAB', 1, 8),
('CENTRO SANTA INES', 1, 25), -- Hay ultima posicion de atacante en esta zona
('CENTRO SANTA INES', 1, 26),
('CENTRO SANTA INES', 1, 27),
('CENTRO SANTA INES', 1, 28),
('MODULO 8', 1, 29), -- Hay ultima posicion de atacante en esta zona
('MODULO 8', 1, 30),
('MODULO 8', 1, 31),
('MODULO 8', 1, 32);


---------------------( HISTORY )-----------------------------

insert into history (full_date, latitude, longitude, status, user) values 
('2023-07-27 21:53:00', -28.918329, 68.28137, 'MOBILE', 1),
('2023-10-15 02:07:00', 10.46459572094806, -66.97681524081271, 'MOBILE', 2);


---------------------( ADMINISTRATOR )-----------------------

insert into administrator (username, email, password) values
('joseAdmin', 'joseantonsr@gmail.com', 'devjose'),
('gaboAdmin', 'gadv1331@gmail.com', 'devgabo'),
('mickelAdmin', 'arrozmickel@gmail.com', 'devmickel');