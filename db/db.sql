CREATE TABLE cliente(
idcliente BIGSERIAL NOT NULL PRIMARY KEY,
nome TEXT,
tipo VARCHAR(2),
numero_documento TEXT,
score INT
);

CREATE SEQUENCE idconta_seq
    INCREMENT 1
    MINVALUE 100000
	MAXVALUE 999999999999999
    START 100000;

CREATE TABLE conta(
idconta BIGINT PRIMARY KEY DEFAULT nextval('idconta_seq'),
agencia INT,
tipo VARCHAR(1),
score INT,
idcliente BIGINT REFERENCES cliente (idcliente) NOT NULL
);



CREATE TABLE credito(
score BIGSERIAL NOT NULL PRIMARY KEY,
limite_cheque FLOAT,
limite_cartao FLOAT
);


CREATE TABLE config(
idconfig BIGSERIAL NOT NULL PRIMARY KEY,
agencia_padrao INT
);




INSERT INTO config VALUES(1,45793);

INSERT INTO credito VALUES(0,0.00,0.00);
INSERT INTO credito VALUES(2,1000.00,200.00);
INSERT INTO credito VALUES(3,1000.00,200.00);
INSERT INTO credito VALUES(4,1000.00,200.00);
INSERT INTO credito VALUES(5,1000.00,200.00);
INSERT INTO credito VALUES(6,2000.00,2000.00);
INSERT INTO credito VALUES(7,2000.00,2000.00);
INSERT INTO credito VALUES(8,2000.00,2000.00);
INSERT INTO credito VALUES(9,5000.00,15000.00);


CREATE OR REPLACE FUNCTION CriaConta()

      RETURNS trigger AS $BODY$
      BEGIN
        INSERT INTO conta (agencia,tipo,score,idcliente)
         VALUES ( (SELECT agencia_padrao
		     FROM config 
		    WHERE idconfig = 1 ), 
                                 (CASE WHEN new.tipo = 'PJ' 
					                   THEN 'E'
                                       ELSE 'C' END) , (SELECT round(CAST (random()*9 AS NUMERIC),0)),
									   new.idcliente);

         RETURN NULL;
      END;$BODY$
       LANGUAGE 'plpgsql';

CREATE  TRIGGER  CRIACONTA 
AFTER INSERT 
ON  cliente FOR EACH ROW
EXECUTE PROCEDURE CriaConta();