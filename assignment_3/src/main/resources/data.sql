INSERT into DENTIST (dentist_name) values ('Aarne Viirsalu'),('Age Kuusk '),('Jelena Sviridova');


INSERT INTO VISIT_TIME (VISIT_TIME ) VALUES
 parsedatetime('25.02.2020 9:00', 'dd.MM.yyyy HH:mm'),
 parsedatetime('25.02.2020 10:00', 'dd.MM.yyyy HH:mm'),
 parsedatetime('25.02.2020 11:00', 'dd.MM.yyyy HH:mm'),
 parsedatetime('25.02.2020 12:00', 'dd.MM.yyyy HH:mm'),
 parsedatetime('25.02.2020 13:00', 'dd.MM.yyyy HH:mm'),
 parsedatetime('25.02.2020 14:00', 'dd.MM.yyyy HH:mm'),
 parsedatetime('25.02.2020 15:00', 'dd.MM.yyyy HH:mm'),
 parsedatetime('25.02.2020 16:00', 'dd.MM.yyyy HH:mm'),
 parsedatetime('26.02.2020 9:00', 'dd.MM.yyyy HH:mm'),
 parsedatetime('26.02.2020 10:00', 'dd.MM.yyyy HH:mm'),
 parsedatetime('26.02.2020 11:00', 'dd.MM.yyyy HH:mm');


Insert INTO DENTIST_VISIT(dentist_name, VISIT_TIME) VALUES ( 'Aarne Viirsalu', parsedatetime('25.02.2020 9:00', 'dd.MM.yyyy HH:mm') );