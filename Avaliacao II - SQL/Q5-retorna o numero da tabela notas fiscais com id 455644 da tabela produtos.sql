-- Quey que retorna os numero da tabela notas fiscais com o id 455644

SELECT tblproduto.Id_Produto, tbl_notas_fiscais.numero 
FROM tblproduto INNER JOIN tbl_notas_fiscais
ON tblproduto.Id_Produto = tbl_notas_fiscais.id AND Id_Produto = 455644;


-- Junta as duas tabelas

SELECT * FROM tblproduto 
INNER JOIN tbl_notas_fiscais
ON tblproduto.Id_Produto = tbl_notas_fiscais.id;

