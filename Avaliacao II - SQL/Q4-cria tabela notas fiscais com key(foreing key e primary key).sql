
CREATE TABLE tbl_Notas_Fiscais (
numero INT PRIMARY KEY AUTO_INCREMENT,
id INT,
FOREIGN KEY (id) 
REFERENCES tblproduto (Id_Produto),   
valor DOUBLE );

ALTER TABLE tbl_notas_fiscais 
ADD FOREIGN KEY (id)
REFERENCES tblproduto (Id_Produto);

SELECT * FROM tbl_notas_fiscais;