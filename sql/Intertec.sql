-- ===================================================
-- Intertec
-- ***************************************************
-- Projeto: Intertec Test
-- Programmer: Weverton de Souza Castanho
-- Data: 11.01.2016
-- =================================================== 

CREATE TABLE intertec.DICTONARY(
    ID INT AUTO_INCREMENT PRIMARY KEY,
    WORD VARCHAR(50) UNIQUE NOT NULL
);

CREATE TABLE intertec.USERNAME(
    ID INT AUTO_INCREMENT PRIMARY KEY,
    USERNAME VARCHAR(50) UNIQUE NOT NULL
);

insert into intertec.USERNAME(USERNAME) value("Weverton");
insert into intertec.USERNAME(USERNAME) value("john");
insert into intertec.USERNAME(USERNAME) value("Joao");
insert into intertec.USERNAME(USERNAME) value("Jose");
insert into intertec.USERNAME(USERNAME) value("Murilo");

insert into DICTONARY(WORD) values("cannabis");
insert into DICTONARY(WORD) values("abuse");
insert into DICTONARY(WORD) values("crack");
insert into DICTONARY(WORD) values("damm");
insert into DICTONARY(WORD) values("drunk");
insert into DICTONARY(WORD) values("grass");

