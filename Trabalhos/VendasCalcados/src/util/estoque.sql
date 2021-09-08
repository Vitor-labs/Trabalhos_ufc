CREATE TABLE IF NOT EXISTS PRODUTO
(
	codigo serial,
	modelo varchar(30) not null,
	marca varchar(15) not null,
	precoProduto float not null,
	tamanho varchar(4) not null,
	cor varchar(10) not null,
	genero varchar(1) not null,
	quantidade integer not null,
	
	CONSTRAINT codigoProdutoPkey PRIMARY KEY (codigo)
);
CREATE TABLE IF NOT EXISTS FORNECEDOR
(
	idFornecedor serial,
	preco float not null,
	codigoFornecedor varchar(25),
	empresa varchar(30) not null,
	produto integer not null,
	
	CONSTRAINT codigoForncedorPkey PRIMARY KEY (codigoFornecedor),
	CONSTRAINT produtoFkey FOREIGN KEY (produto)
	REFERENCES PRODUTO(codigo)
);

CREATE TABLE IF NOT EXISTS fornecedorLocal
(
	cpf varchar(15),
	
	CONSTRAINT fornecedorLocalFKEY FOREIGN KEY (cpf)
	REFERENCES FORNECEDOR(codigoFornecedor)
) INHERITS (FORNECEDOR);

CREATE TABLE IF NOT EXISTS fornecedorGrande
(
	cnpj varchar(25),
	
	CONSTRAINT fornecedorGrandeFkey FOREIGN KEY (cnpj)
	REFERENCES FORNECEDOR(codigoFornecedor)
) INHERITS (FORNECEDOR);

CREATE TABLE IF NOT EXISTS FORNECE
(
	idFornecedor varchar(25),
	codigoProduto integer,
	
	CONSTRAINT fornecedorFkey FOREIGN KEY (idFornecedor)
	REFERENCES FORNECEDOR(codigoFornecedor),
	CONSTRAINT codigoProdutoFkey FOREIGN KEY (codigoProduto)
	REFERENCES PRODUTO(codigo)
);

CREATE OR REPLACE FUNCTION fornecedor_log()
	RETURNS TRIGGER AS $$
		BEGIN 
			IF(CHAR_LENGTH(new.codigoFornecedor) > 11) THEN 
-- 				DELETE FROM FORNECEDOR WHERE codigoFornecedor = new.codigoFornecedor;
                INSERT INTO fornecedorGrande(codigoFornecedor, preco, cnpj, empresa, produto)
				VALUES(new.codigoFornecedor, new.preco, new.codigoFornecedor, new.empresa, new.produto);
                RETURN NEW;
			ELSE 
-- 				DELETE FROM FORNECEDOR WHERE codigoFornecedor = new.codigoFornecedor;
                INSERT INTO fornecedorLocal(codigoFornecedor, preco, cpf, empresa, produto)
				VALUES(new.codigoFornecedor, new.preco, new.codigoFornecedor, new.empresa, new.produto);
                RETURN NEW;
			END IF;	
		END;
	$$
LANGUAGE 'plpgsql';


CREATE TRIGGER gatilho_Fornecedor AFTER INSERT ON FORNECEDOR
	FOR EACH ROW EXECUTE PROCEDURE fornecedor_log();