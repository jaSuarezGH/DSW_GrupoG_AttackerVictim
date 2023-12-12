

---------------------( USER )--------------------------------

insert into user (firstname, lastname, username, personal_id, email, mac_address, password) values
('Jesus', 'Manuel', 'jesumanu', 'V-29.552.507', 'jesumanu@gmail.com', '00-B0-D0-63-C2-26', 'eY6>K2|D+*j0Ssd'),
('Mariangel', 'Torres', 'marpastelito', 'V-26.260.787', 'mariangeltsilva@gmail.com', '01-B2-D1-64-C1-27', 'wJ6"<|~xLM"!N'),
('Shae', 'O''Corr', 'socorr0', 'V-48.271.945', 'socorr0@huffingtonpost.com', 'D5-AB-50-D6-18-BD', 'uH6=*j+/Lt*$('),
('Esra', 'Staresmeare', 'estaresmeare1', 'V-97.356.668', 'estaresmeare1@ihg.com', '39-56-1A-FE-E0-54', 'zF5?uJIa$@VxI'),
('Ellary', 'McMeanma', 'emcmeanma2', 'V-90.241.316', 'emcmeanma2@altervista.org', '0E-82-9F-9C-A9-31', 'yY3)8aj+VW7Co'),
('Coralyn', 'Cicutto', 'ccicutto3', 'V-09.336.728', 'ccicutto3@biblegateway.com', '89-BE-BD-D4-1C-14', 'pY0<fOM&PUdLAb4'),
('Gerti', 'Lewton', 'glewton4', 'V-97.609.913', 'glewton4@intel.com', 'B4-C8-72-60-23-1C', 'aC1+pW$$0'),
('Minor', 'Crosson', 'mcrosson5', 'V-98.037.194', 'mcrosson5@facebook.com', '14-37-91-85-D9-7A', 'lO8)|M.j`$'),
('Donnie', 'Delieu', 'ddelieu6', 'V-88.547.482', 'ddelieu6@reuters.com', 'AF-0C-EE-3D-79-A2', 'fI7\\5&q'),
('Warde', 'Greenhouse', 'wgreenhouse7', 'V-64.181.609', 'wgreenhouse7@wikipedia.org', '7A-9E-A8-9C-70-91', 'gU5_6~Dc'),
('Constantina', 'Walley', 'cwalley8', 'V-56.773.057', 'cwalley8@rambler.ru', '56-46-6F-17-50-28', 'mK4+Bawtd/'),
('Tonia', 'Elvey', 'telvey9', 'V-54.006.916', 'telvey9@sphinn.com', 'B4-D5-00-2B-3C-30', 'pP2"rI`4'),
('Damian', 'Scarlon', 'dscarlona', 'V-71.351.325', 'dscarlona@oaic.gov.au', '65-8D-69-FA-DB-F6', 'cO6&`h6T\bIJ'),
('Korey', 'Scad', 'kscadb', 'V-05.853.086', 'kscadb@bbb.org', '52-69-99-C8-4E-B1', 'nT9*u1QN9k)K'),
('Hew', 'Toping', 'htopingc', 'V-70.701.274', 'htopingc@gmpg.org', '5B-FD-F1-F5-33-93', 'cR9\I.GU6'),
('Aeriela', 'Fevier', 'afevierd', 'V-82.086.269', 'afevierd@chicagotribune.com', '2E-08-4F-E2-3F-64', 'tE5!gA"+1$8o~yy'),
('Madge', 'Mingardo', 'mmingardoe', 'V-78.127.801', 'mmingardoe@about.com', '07-93-3B-CA-4A-E6', 'sS5_/dFxOMZ/'),
('Luciana', 'Gask', 'lgaskf', 'V-85.792.476', 'lgaskf@latimes.com', '73-E9-38-10-B5-8C', 'uY7=Rx$l0o<Nqv1I'),
('Theodoric', 'Keedwell', 'tkeedwellg', 'V-39.659.414', 'tkeedwellg@edublogs.org', 'BF-63-BC-3E-F2-BD', 'aG8!pnNRJ.XPUe'),
('Kahlil', 'Rickaby', 'krickabyh', 'V-45.695.587', 'krickabyh@mashable.com', 'FD-69-87-41-CB-81', 'vV5#,oGtVkp?C'),
('Fan', 'Varty', 'fvartyi', 'V-63.266.413', 'fvartyi@issuu.com', '93-8F-57-C6-4C-CB', 'fD3$77@W+%'),
('Sybila', 'Hutchinson', 'shutchinsonj', 'V-18.188.376', 'shutchinsonj@google.com.hk', 'B7-C0-B3-5A-01-1B', 'dD7!2jzma?9mT');


---------------------( VICTIM )------------------------------

insert into victim (user) values
(13),
(16),
(11),
(5),
(20);


---------------------( ATTACKER )----------------------------

insert into attacker (user) values
(10),
(2),
(14),
(6),
(22);


---------------------( INCIDENT )----------------------------

insert into incident (victim, attacker, separation_distance) values 
(1, 4, 10.5),
(2, 5, 7),
(3, 3, 6.9),
(4, 2, 8),
(5, 1, 15);


---------------------( COORDINATE )--------------------------

insert into coordinate (latitude, longitude) values 
(63.132703, -158.530488),
(-19.591096, 18.687783),
(-40.556831, -101.387749),
(-49.170316, 22.405661),
(15.034053, -78.737179),
(54.762855, -141.654787),
(59.132204, -99.30293),
(-47.276635, -28.922981),
(39.003233, -134.409384),
(-2.419063, -27.519034),
(-27.70042, -95.449171),
(-12.575319, -33.068038),
(-79.044679, 127.320566),
(-55.710979, -93.900461),
(86.907974, -74.051957),
(1.128029, -77.831631),
(-42.058298, 163.716467),
(38.721889, 78.79819),
(36.306531, -124.010563),
(70.615678, 165.420055),
(17.238841, 6.590775),
(-43.649555, -111.422463),
(76.481896, 78.171043),
(-14.019947, -17.984129),
(-32.374243, -42.539621),
(-9.656971, 60.245551),
(12.182225, 88.851284),
(-74.107604, 5.874162),
(84.952221, -33.782559),
(72.345036, -98.865839),
(65.76181, 14.972993),
(19.060272, 64.941118),
(-81.907824, 117.328078),
(-52.267091, -97.567181),
(11.582068, -63.983882),
(88.572517, 43.098552),
(25.192279, -48.555201),
(-66.250003, 82.453301),
(19.268086, 56.523243),
(42.882057, -69.898258),
(-73.575733, 113.951339),
(-61.56495, 115.535988),
(69.245284, 4.764514),
(-82.293232, -125.128954),
(-24.708913, 156.09742),
(-85.76672, 167.758247),
(23.115605, -64.977757),
(56.299776, 69.044305),
(-62.779296, 123.602091),
(-74.821498, 135.223828),
(86.734659, 107.22761),
(-34.957619, -130.069938),
(-27.410771, -138.450584),
(58.26404, -44.148651),
(-13.65225, 27.409028),
(-47.81376, 157.461107),
(52.882424, 118.212042),
(-36.097015, -78.492314),
(-21.553976, -49.914775),
(81.823848, 152.053586),
(-69.847075, -112.816264),
(-81.142303, -86.389761),
(0.9724, -98.559899),
(35.713282, 56.541528),
(80.833712, -119.322076),
(0.320386, -169.303035),
(39.08184, -56.487539),
(-30.056093, 170.141058),
(65.623815, 174.475395),
(-58.207709, 62.485311),
(-82.784375, -43.181226),
(57.991109, 49.074778),
(-29.052719, 68.808539),
(-27.027478, -162.733522),
(86.300155, -71.797636),
(87.379347, 162.276735),
(6.758869, 109.635813),
(46.42559, -43.630488),
(14.349432, -48.952506),
(-39.743982, 69.384305),
(84.306835, -121.707777),
(25.791675, -83.538835),
(37.788073, 177.260043),
(63.715734, 99.454268),
(32.129846, -34.521855),
(62.67735, -31.13481),
(-65.917152, 91.500753),
(-1.120261, -78.793998),
(79.056178, 51.536929),
(-40.141455, -59.690295),
(-4.028937, -70.784349),
(11.378921, -50.504217),
(-76.061241, -35.806225),
(-63.846389, -43.025415),
(18.511022, 145.813237),
(-2.328237, 94.91454),
(81.587929, 62.84388),
(-76.737164, -91.281033),
(-26.032974, -50.540131),
(-28.622599, -79.900517);


---------------------( SAFE ZONE )---------------------------

insert into safe_zone (name, user, coordinate) values
('ESCUELA', 13, 83),
('ESCUELA', 13, 97),
('ESCUELA', 13, 11),
('ESCUELA', 13, 75),
('CINE', 13, 46),
('CINE', 13, 12),
('CINE', 13, 39),
('CINE', 13, 76),
-----------------
('CASA', 16, 23),
('CASA', 16, 46),
('CASA', 16, 33),
('CASA', 16, 56),
('TRABAJO', 16, 28),
('TRABAJO', 16, 51),
('TRABAJO', 16, 17),
('TRABAJO', 16, 28),
-----------------
('CASA', 11, 25),
('CASA', 11, 58),
('CASA', 11, 92),
('CASA', 11, 63),
-----------------
('BIBLIOTECA', 5, 75),
('BIBLIOTECA', 5, 36),
('BIBLIOTECA', 5, 80),
-----------------
('SUPERMERCADO', 20, 89),
('SUPERMERCADO', 20, 5),
('SUPERMERCADO', 20, 41),
('SUPERMERCADO', 20, 88),
('SUPERMERCADO', 20, 64),
('SUPERMERCADO', 20, 10),
('SUPERMERCADO', 20, 29),
('SUPERMERCADO', 20, 25);


---------------------( HISTORY )-----------------------------

insert into history (full_date, latitude, longitude, status, user) values 
('2023-07-27 21:53:00', -28.918329, 68.28137, 'INMOBILE', 13),
('2023-10-15 02:07:00', 60.598379, 44.321948, 'INMOBILE', 6),
('2023-06-16 03:28:00', -39.053195, 58.729968, 'OFFLINE', 13),
('2023-10-31 19:28:00', -87.633788, 156.192509, 'OFFLINE', 20),
('2023-09-15 03:34:00', 58.2824, 135.369497, 'INMOBILE', 10),
('2023-06-14 18:16:00', -9.652658, -52.048526, 'INMOBILE', 6),
('2023-08-17 03:25:00', -64.958057, -42.540248, 'OFFLINE', 16),
('2023-10-05 12:46:00', 37.113336, 156.284459, 'OFFLINE', 6),
('2023-09-11 07:20:00', 49.061782, 32.517336, 'INMOBILE', 13),
('2023-11-12 22:34:00', 49.148405, -99.647361, 'MOBILE', 6),
('2023-06-04 07:34:00', 73.249795, -72.805017, 'OFFLINE', 22),
('2023-06-26 00:21:00', -78.578092, -27.756696, 'OFFLINE', 14),
('2023-08-11 09:30:00', -4.506529, 13.311966, 'MOBILE', 22),
('2023-08-16 08:30:00', -40.528632, -73.187651, 'OFFLINE', 5),
('2023-06-17 22:38:00', -35.332509, -20.864866, 'OFFLINE', 11),
('2023-09-20 00:34:00', 31.146193, -83.585875, 'INMOBILE', 10),
('2023-01-20 04:00:00', -53.972795, -58.102104, 'OFFLINE', 5),
('2023-10-02 10:33:00', 84.923965, -171.864014, 'MOBILE', 16),
('2023-11-10 21:30:00', -3.347823, 35.421372, 'MOBILE', 13),
('2023-08-29 07:41:00', 25.284413, -60.613422, 'MOBILE', 6),
('2023-02-06 12:39:00', -42.035782, 17.374842, 'MOBILE', 20),
('2023-06-20 17:49:00', 21.849647, -116.519047, 'MOBILE', 6),
('2023-03-10 18:35:00', 8.623791, -26.654056, 'OFFLINE', 5),
('2023-12-10 10:06:00', 18.272404, -22.170785, 'INMOBILE', 13),
('2023-01-08 20:11:00', 20.833117, -150.427205, 'OFFLINE', 2),
('2023-07-17 08:29:00', -87.620023, -31.136096, 'INMOBILE', 22),
('2023-10-03 21:35:00', 71.023824, -129.594548, 'INMOBILE', 20),
('2023-09-23 15:03:00', 54.153933, -175.184191, 'OFFLINE', 13),
('2023-02-26 07:07:00', -12.811247, 77.688502, 'OFFLINE', 11),
('2023-02-07 19:56:00', 11.979056, 121.329303, 'MOBILE', 11),
('2023-12-29 07:27:00', 76.738437, 85.012317, 'INMOBILE', 20),
('2023-08-08 14:33:00', 56.896116, 79.511901, 'INMOBILE', 11),
('2023-04-21 00:07:00', 63.481421, 67.943016, 'MOBILE', 13),
('2023-03-16 22:57:00', -19.530636, 142.229573, 'MOBILE', 20),
('2023-04-26 22:05:00', -85.284875, 4.950138, 'OFFLINE', 14),
('2023-03-10 15:52:00', -60.919769, -130.134039, 'MOBILE', 2),
('2023-06-04 06:05:00', 15.923282, 175.538137, 'INMOBILE', 10),
('2023-10-27 19:34:00', 76.512039, 53.180323, 'MOBILE', 6),
('2023-04-20 06:02:00', -78.370082, -22.560802, 'MOBILE', 20),
('2023-02-02 20:44:00', -37.237508, -166.211296, 'MOBILE', 14),
('2023-03-12 10:15:00', 6.630682, -97.849222, 'OFFLINE', 22),
('2023-11-22 19:13:00', 4.881976, 85.485726, 'INMOBILE', 14),
('2023-07-06 16:27:00', -4.92671, -102.707787, 'MOBILE', 13),
('2023-03-26 00:46:00', 20.43688, 57.41061, 'MOBILE', 20),
('2023-02-25 08:58:00', -28.450899, -129.116275, 'INMOBILE', 10),
('2023-09-10 02:15:00', -73.801653, 121.159383, 'MOBILE', 20),
('2023-06-24 18:22:00', 10.699783, 93.977461, 'MOBILE', 20),
('2023-01-03 04:28:00', -39.384863, -176.508329, 'INMOBILE', 16),
('2023-08-06 09:19:00', -71.915795, -152.382818, 'MOBILE', 2),
('2023-12-07 23:21:00', -40.093715, -144.635201, 'OFFLINE', 10),
('2023-08-11 01:53:00', -68.489407, 142.211378, 'INMOBILE', 5),
('2023-03-26 09:53:00', 78.430574, -105.490202, 'MOBILE', 11),
('2023-10-11 21:45:00', 71.880873, -100.754457, 'OFFLINE', 6),
('2023-01-02 01:18:00', -48.014272, -135.133781, 'MOBILE', 11),
('2023-11-11 20:30:00', 46.030681, 159.941227, 'MOBILE', 6),
('2023-08-17 01:26:00', 74.409387, 165.393933, 'OFFLINE', 10),
('2023-09-08 23:04:00', -41.427235, -55.235584, 'MOBILE', 6),
('2023-01-24 17:12:00', 31.418502, -110.804728, 'INMOBILE', 11),
('2023-08-16 06:35:00', 29.458231, 83.355355, 'MOBILE', 14),
('2023-11-26 00:56:00', 28.943537, -90.954378, 'INMOBILE', 10),
('2023-06-24 03:06:00', 81.683612, -141.852878, 'INMOBILE', 16),
('2023-08-03 18:06:00', -38.504111, 0.781511, 'OFFLINE', 22),
('2023-10-23 11:01:00', -36.786775, 52.256725, 'MOBILE', 11),
('2023-10-11 21:51:00', 19.341758, -168.430414, 'OFFLINE', 11),
('2023-09-07 20:57:00', 30.83415, -171.02519, 'MOBILE', 6),
('2023-09-09 11:42:00', 60.371193, 94.770524, 'OFFLINE', 22),
('2023-02-13 10:59:00', -2.712113, 146.005018, 'OFFLINE', 20),
('2023-01-17 20:49:00', -66.43955, -109.295178, 'OFFLINE', 11),
('2023-08-17 15:43:00', -34.702595, 54.590818, 'MOBILE', 14),
('2023-12-19 23:22:00', -72.588185, 169.704279, 'INMOBILE', 20),
('2023-10-22 16:41:00', -24.650629, 4.516534, 'INMOBILE', 22),
('2023-09-24 11:53:00', 14.611952, -31.378751, 'MOBILE', 10),
('2023-01-08 14:14:00', -50.716411, 22.494607, 'INMOBILE', 2),
('2023-07-17 00:56:00', 24.962517, -44.892596, 'MOBILE', 16),
('2023-04-08 16:04:00', 75.501569, -126.131829, 'MOBILE', 10),
('2023-08-23 05:07:00', -0.15051, -5.038077, 'OFFLINE', 5),
('2023-04-17 12:53:00', 10.682886, -5.983635, 'MOBILE', 22),
('2023-11-25 23:12:00', -77.738274, -19.803897, 'INMOBILE', 20),
('2023-12-18 01:28:00', -33.416939, 134.563034, 'OFFLINE', 22),
('2023-05-19 21:42:00', -6.921304, 83.878911, 'OFFLINE', 20),
('2023-03-13 18:57:00', 39.004178, 13.595825, 'INMOBILE', 11),
('2023-05-23 15:41:00', 22.703582, 73.271559, 'INMOBILE', 16),
('2023-08-19 06:42:00', -81.815859, -116.989149, 'OFFLINE', 5),
('2023-12-25 09:22:00', 45.477862, 26.154379, 'INMOBILE', 14),
('2023-12-30 19:55:00', 85.022013, 147.191552, 'INMOBILE', 10),
('2023-07-27 16:36:00', -83.000507, 170.439598, 'INMOBILE', 10),
('2023-08-16 00:48:00', -83.833023, 76.321395, 'INMOBILE', 6),
('2023-01-02 16:37:00', -4.198511, -141.418628, 'MOBILE', 20),
('2023-09-22 11:29:00', -56.248373, 112.816575, 'MOBILE', 22),
('2023-11-24 01:39:00', -57.11947, -103.083863, 'INMOBILE', 11),
('2023-10-31 14:50:00', 13.865303, -14.96711, 'INMOBILE', 10),
('2023-01-13 13:22:00', 2.12368, 102.643428, 'MOBILE', 11),
('2023-08-02 18:01:00', 38.368293, -40.729581, 'INMOBILE', 20),
('2023-09-14 08:57:00', -52.269717, -179.017023, 'OFFLINE', 5),
('2023-07-09 08:24:00', -49.758816, -122.768248, 'INMOBILE', 20),
('2023-05-10 02:56:00', 47.719048, 145.808872, 'OFFLINE', 10),
('2023-10-03 14:40:00', 55.548032, -30.212388, 'MOBILE', 5),
('2023-07-08 14:25:00', -70.231729, -102.570595, 'INMOBILE', 14),
('2023-01-05 02:35:00', -6.84753, -68.815282, 'OFFLINE', 11),
('2023-10-18 23:07:00', 12.860027, 46.733112, 'INMOBILE', 14);


---------------------( ADMINISTRATOR )-----------------------

insert into administrator (username, email, password) values
('joseAdmin', 'joseantonsr@gmail.com', 'uA2#bxfdx)usFd2'),
('gaboAdmin', 'gadv1331@gmail.com', 'xA6{b%WxtwIRd?'),
('mickelAdmin', 'arrozmickel@gmail.com', 'zZ2$T8D.yRFdua');