CREATE TABLE cliente(
idcliente BIGSERIAL NOT NULL PRIMARY KEY,
nome TEXT,
tipo VARCHAR(2),
numero_documento TEXT,
score INT
);

CREATE TABLE conta(
idconta BIGSERIAL NOT NULL PRIMARY KEY,
agencia INT,
tipo VARCHAR(1),
limite_cheque FLOAT,
limite_cartao FLOAT,
idcliente BIGINT REFERENCES cliente (idcliente) NOT NULL
);

CREATE SEQUENCE idconta
    INCREMENT 1
    MINVALUE 100000
    MAXVALUE 9223372036854775807
    START 100000
    CACHE 1;


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
        INSERT INTO conta (agencia,tipo,limite_cheque, limite_cartao,idcliente)
         VALUES ( (SELECT agencia_padrao
		     FROM config 
		    WHERE idconfig = 1 ), 
                                          (CASE WHEN new.tipo = 'PJ' 
					        THEN 'E'
                                                ELSE 'C' END) ,
                                               (SELECT limite_cheque
						  FROM credito 
					         WHERE score = new.score),
                                               (SELECT limite_cartao
						  FROM credito 
					         WHERE score = new.score), new.idcliente);

         RETURN NULL;
      END;$BODY$
       LANGUAGE 'plpgsql';

CREATE  TRIGGER  CRIACONTA 
AFTER INSERT 
ON  cliente FOR EACH ROW
EXECUTE PROCEDURE CriaConta();