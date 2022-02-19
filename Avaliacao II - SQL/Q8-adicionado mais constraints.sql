
ALTER TABLE tblproduto
CHANGE data_Registradora
DATA DATE NOT NULL;

ALTER TABLE tbl_notas_fiscais
ADD CONSTRAINT ckValor
CHECK (valor > 0);
