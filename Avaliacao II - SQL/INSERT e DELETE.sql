USE loja;
 -- Populando o Banco de dados loja --
INSERT INTO tblproduto (Id_Produto, nome, descricao, desconto, data_Registradora) 
VALUES (455640, 'HardWare', 'Disco rídigo - HD', 0.10, 20220217 );

INSERT INTO tblproduto (Id_Produto, nome, descricao, desconto, data_Registradora) 
VALUES (455641, 'HardWare', 'Memória RAM', 0.01, 20200101 );

INSERT INTO tblproduto (Id_Produto, nome, descricao, desconto, data_Registradora) 
VALUES (455642, 'HardWare', 'Coolers', 0.03, 20210815 );

INSERT INTO tblproduto (Id_Produto, nome, descricao, desconto, data_Registradora) 
VALUES (455644, 'Periférico', 'Headset', 0.50, 20210611 );

INSERT INTO tblproduto (Id_Produto, nome, descricao, desconto, data_Registradora) 
VALUES (455645, 'Periférico', 'Mesa digitalizadora', 0.07, 20210611 );

INSERT INTO tblproduto (Id_Produto, nome, descricao, desconto, data_Registradora) 
VALUES (455646, 'Periférico', 'Som e acessórios', 0.82, 20210711 );

INSERT INTO tblproduto (Id_Produto, nome, descricao, desconto, data_Registradora) 
VALUES (455647, 'Itens de conectividade', 'Switches', 0.8, 20210911 );

INSERT INTO tblproduto (Id_Produto, nome, descricao, desconto, data_Registradora) 
VALUES ( '455650','Itens de conectividade', 'Modem', 0.09, 20200429 );

INSERT INTO tblproduto (Id_Produto, nome, descricao, desconto, data_Registradora) 
VALUES ( '455650','Testando chave primaria', 'teste', 0.00, 20220217);

INSERT INTO tblproduto (Id_Produto, nome, descricao, desconto, data_Registradora) 
VALUES ( '455651','Hardware', ' Placas-mãe', 0.19, 219-01-17);

INSERT INTO tblproduto (Id_Produto, nome, descricao, desconto, data_Registradora) 
VALUES ( '4556444','Hardware', ' HD SSD ', 0.50, 20220118);

SELECT * FROM tblproduto;

DELETE FROM tblproduto WHERE Id_Produto =4556;