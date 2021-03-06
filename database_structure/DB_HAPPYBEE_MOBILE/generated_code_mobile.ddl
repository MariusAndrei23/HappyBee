-- Generated by Oracle SQL Developer Data Modeler 20.3.0.283.0710
--   at:        2020-12-05 21:21:26 EET
--   site:      Oracle Database 11g
--   type:      Oracle Database 11g



-- predefined type, no DDL - MDSYS.SDO_GEOMETRY

-- predefined type, no DDL - XMLTYPE

CREATE TABLE cantar (
    id_cantar           INTEGER NOT NULL,
    data                DATE NOT NULL,
    greutate_stup       FLOAT(3) NOT NULL,
    descriere           VARCHAR2(300),
    is_deleted          CHAR(1) NOT NULL,
    stupina_id_stupina  INTEGER NOT NULL
);

ALTER TABLE cantar ADD CONSTRAINT greutate_stup_ck CHECK ( greutate_stup = 0 );

ALTER TABLE cantar ADD CONSTRAINT cantar_pk PRIMARY KEY ( id_cantar );

CREATE TABLE deplasari (
    id_deplasare          INTEGER NOT NULL,
    locatie               VARCHAR2(25) NOT NULL,
    data_start            DATE NOT NULL,
    data_sfarsit          DATE,
    nr_stupi_transferati  INTEGER NOT NULL,
    tip_cules             VARCHAR2(30) NOT NULL,
    decriere              VARCHAR2(300),
    is_deleted            CHAR(1) NOT NULL,
    stupina_id_stupina    INTEGER NOT NULL
);

ALTER TABLE deplasari ADD CONSTRAINT nr_stupi_transferati_ck CHECK ( nr_stupi_transferati = 0 );

ALTER TABLE deplasari ADD CONSTRAINT deplasari_pk PRIMARY KEY ( id_deplasare );

CREATE TABLE extractie (
    id_extractie        INTEGER NOT NULL,
    data                DATE NOT NULL,
    tip_miere           VARCHAR2(15) NOT NULL,
    cantitate           FLOAT(3) NOT NULL,
    descriere           VARCHAR2(300),
    is_deleted          CHAR(1) NOT NULL,
    stupina_id_stupina  INTEGER NOT NULL
);

ALTER TABLE extractie ADD CONSTRAINT cantitate_extractie_ck CHECK ( cantitate = 0 );

ALTER TABLE extractie ADD CONSTRAINT extractie_pk PRIMARY KEY ( id_extractie );

CREATE TABLE hranire (
    id_hranire          INTEGER NOT NULL,
    tip_hranire         VARCHAR2(15) NOT NULL,
    hrana               VARCHAR2(15) NOT NULL,
    cantitate           FLOAT(3) NOT NULL,
    nr_stupi_hraniti    INTEGER NOT NULL,
    cantitate_per_stup  FLOAT(3) NOT NULL,
    descriere           VARCHAR2(300),
    is_deleted          CHAR(1) NOT NULL,
    stupina_id_stupina  INTEGER NOT NULL
);

ALTER TABLE hranire ADD CONSTRAINT cantitate_ck CHECK ( cantitate = 0 );

ALTER TABLE hranire ADD CONSTRAINT nr_stupi_hraniti_ck CHECK ( nr_stupi_hraniti = 1 );

ALTER TABLE hranire ADD CONSTRAINT cantitate_per_stup_ck CHECK ( cantitate_per_stup = 0 );

ALTER TABLE hranire ADD CONSTRAINT hranire_pk PRIMARY KEY ( id_hranire );

CREATE TABLE stup (
    id_stup             INTEGER NOT NULL,
    nume_identificare   VARCHAR2(20) NOT NULL,
    nr_rame             INTEGER NOT NULL,
    orientare_stup      VARCHAR2(15) NOT NULL,
    stare_stup          VARCHAR2(15) NOT NULL,
    putere_stup         INTEGER NOT NULL,
    descriere           VARCHAR2(300),
    is_deleted          CHAR(1) NOT NULL,
    stupina_id_stupina  INTEGER NOT NULL
);

ALTER TABLE stup
    ADD CONSTRAINT nr_rame_ck CHECK ( nr_rame BETWEEN 1 AND 100 );

ALTER TABLE stup
    ADD CONSTRAINT putere_stup_ck CHECK ( putere_stup BETWEEN 0 AND 100 );

ALTER TABLE stup ADD CONSTRAINT stup_pk PRIMARY KEY ( id_stup );

CREATE TABLE stupina (
    id_stupina                 INTEGER NOT NULL,
    nume_stupina               VARCHAR2(50) NOT NULL,
    locatie                    VARCHAR2(100) NOT NULL,
    descriere                  VARCHAR2(300),
    is_deleted                 CHAR(1) NOT NULL,
    id_parinte                 INTEGER NOT NULL,
    utilizatori_id_utilizator  INTEGER NOT NULL,
    stupina_id_stupina         INTEGER NOT NULL
);

ALTER TABLE stupina ADD CONSTRAINT stupina_pk PRIMARY KEY ( id_stupina );

CREATE TABLE tratare (
    id_tratare          INTEGER NOT NULL,
    data                DATE NOT NULL,
    boala               VARCHAR2(50) NOT NULL,
    tip_tratament       VARCHAR2(150) NOT NULL,
    repetare_tratament  INTEGER NOT NULL,
    nr_stupi_tratati    INTEGER NOT NULL,
    doza                FLOAT(3) NOT NULL,
    um                  VARCHAR2(20) NOT NULL,
    descriere           VARCHAR2(300),
    is_deleted          CHAR(1) NOT NULL,
    stupina_id_stupina  INTEGER NOT NULL
);

ALTER TABLE tratare
    ADD CONSTRAINT repetare_tratament_ck CHECK ( repetare_tratament BETWEEN 0 AND 365 );

ALTER TABLE tratare ADD CONSTRAINT nr_stupi_tratati_ck CHECK ( nr_stupi_tratati = 1 );

ALTER TABLE tratare ADD CONSTRAINT doza_ck CHECK ( doza = 0 );

ALTER TABLE tratare ADD CONSTRAINT tratare_pk PRIMARY KEY ( id_tratare );

CREATE TABLE utilizatori (
    id_utilizator  INTEGER NOT NULL,
    fotografie     BLOB,
    nume           VARCHAR2(20) NOT NULL,
    prenume        VARCHAR2(20) NOT NULL,
    sex            VARCHAR2(1),
    email          VARCHAR2(45) NOT NULL,
    alias          VARCHAR2(10) NOT NULL,
    parola         VARCHAR2(15) NOT NULL,
    judet          VARCHAR2(10),
    localitate     VARCHAR2(10),
    adresa         VARCHAR2(25),
    is_admin       CHAR(1),
    is_deleted     CHAR(1)
);

ALTER TABLE utilizatori ADD CONSTRAINT utilizatori_pk PRIMARY KEY ( id_utilizator );

CREATE TABLE verificari (
    id_verificare  INTEGER NOT NULL,
    data           DATE NOT NULL,
    actiune        VARCHAR2(30) NOT NULL,
    is_deleted     CHAR(1) NOT NULL,
    stup_id_stup   INTEGER NOT NULL
);

ALTER TABLE verificari ADD CONSTRAINT verificari_pk PRIMARY KEY ( id_verificare );

ALTER TABLE cantar
    ADD CONSTRAINT cantar_stupina_fk FOREIGN KEY ( stupina_id_stupina )
        REFERENCES stupina ( id_stupina )
            ON DELETE CASCADE;

ALTER TABLE deplasari
    ADD CONSTRAINT deplasari_stupina_fk FOREIGN KEY ( stupina_id_stupina )
        REFERENCES stupina ( id_stupina )
            ON DELETE CASCADE;

ALTER TABLE extractie
    ADD CONSTRAINT extractie_stupina_fk FOREIGN KEY ( stupina_id_stupina )
        REFERENCES stupina ( id_stupina )
            ON DELETE CASCADE;

ALTER TABLE hranire
    ADD CONSTRAINT hranire_stupina_fk FOREIGN KEY ( stupina_id_stupina )
        REFERENCES stupina ( id_stupina )
            ON DELETE CASCADE;

ALTER TABLE stup
    ADD CONSTRAINT stup_stupina_fk FOREIGN KEY ( stupina_id_stupina )
        REFERENCES stupina ( id_stupina )
            ON DELETE CASCADE;

ALTER TABLE stupina
    ADD CONSTRAINT stupina_stupina_fk FOREIGN KEY ( stupina_id_stupina )
        REFERENCES stupina ( id_stupina )
            ON DELETE CASCADE;

ALTER TABLE stupina
    ADD CONSTRAINT stupina_utilizatori_fk FOREIGN KEY ( utilizatori_id_utilizator )
        REFERENCES utilizatori ( id_utilizator )
            ON DELETE CASCADE;

ALTER TABLE tratare
    ADD CONSTRAINT tratare_stupina_fk FOREIGN KEY ( stupina_id_stupina )
        REFERENCES stupina ( id_stupina )
            ON DELETE CASCADE;

ALTER TABLE verificari
    ADD CONSTRAINT verificari_stup_fk FOREIGN KEY ( stup_id_stup )
        REFERENCES stup ( id_stup )
            ON DELETE CASCADE;



-- Oracle SQL Developer Data Modeler Summary Report: 
-- 
-- CREATE TABLE                             9
-- CREATE INDEX                             0
-- ALTER TABLE                             29
-- CREATE VIEW                              0
-- ALTER VIEW                               0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           0
-- ALTER TRIGGER                            0
-- CREATE COLLECTION TYPE                   0
-- CREATE STRUCTURED TYPE                   0
-- CREATE STRUCTURED TYPE BODY              0
-- CREATE CLUSTER                           0
-- CREATE CONTEXT                           0
-- CREATE DATABASE                          0
-- CREATE DIMENSION                         0
-- CREATE DIRECTORY                         0
-- CREATE DISK GROUP                        0
-- CREATE ROLE                              0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE SEQUENCE                          0
-- CREATE MATERIALIZED VIEW                 0
-- CREATE MATERIALIZED VIEW LOG             0
-- CREATE SYNONYM                           0
-- CREATE TABLESPACE                        0
-- CREATE USER                              0
-- 
-- DROP TABLESPACE                          0
-- DROP DATABASE                            0
-- 
-- REDACTION POLICY                         0
-- 
-- ORDS DROP SCHEMA                         0
-- ORDS ENABLE SCHEMA                       0
-- ORDS ENABLE OBJECT                       0
-- 
-- ERRORS                                   0
-- WARNINGS                                 0
