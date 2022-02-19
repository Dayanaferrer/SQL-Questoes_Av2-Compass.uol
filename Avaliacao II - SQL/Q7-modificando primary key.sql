DESC tblproduto ;			

SET FOREIGN_KEY_CHECKS=0;
UPDATE tblproduto SET Id_Produto = 243924 WHERE Id_Produto = 455644;
SET FOREIGN_KEY_CHECKS=1;

SELECT * FROM tblproduto ;