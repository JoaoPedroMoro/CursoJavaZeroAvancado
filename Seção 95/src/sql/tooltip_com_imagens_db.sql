CREATE DATABASE IF NOT EXISTS tooltip_com_imagens_db

  CHARACTER SET utf8mb4
  COLLATE utf8mb4_0900_ai_ci;

USE tooltip_com_imagens_db;

CREATE TABLE IF NOT EXISTS produtos (

  id INT AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(120) NOT NULL UNIQUE,
  caminho_imagem VARCHAR(255) NULL

) ENGINE=InnoDB; -- A cláusula "ENGINE=InnoDB" especifica 
-- o mecanismo de armazenamento usado para essa tabela

CREATE TABLE IF NOT EXISTS vendas (

  id INT AUTO_INCREMENT PRIMARY KEY,
  vendedor   VARCHAR(120) NOT NULL,
  produto_id INT NOT NULL,
  total      DECIMAL(10,2) NOT NULL,
  CONSTRAINT fk_vendas_produtos
    FOREIGN KEY (produto_id)
    REFERENCES produtos(id)
    ON UPDATE CASCADE
    ON DELETE RESTRICT

) ENGINE=InnoDB;

SET FOREIGN_KEY_CHECKS = 0;

TRUNCATE TABLE vendas;

TRUNCATE TABLE produtos;

SET FOREIGN_KEY_CHECKS = 1;

INSERT INTO produtos (nome, caminho_imagem) VALUES

  ('Bolsa de Trabalho','src/imagens/Bolsa de Trabalho.jpg'),
  ('Boné','src/imagens/Boné.jpg'),
  ('Calça Feminina Jogger','src/imagens/Calça Feminina Jogger.jpg'),
  ('Camisa Masculina','src/imagens/Camisa Masculina.jpg'),
  ('Camisa Masculina Festa Balada','src/imagens/Camisa Masculina Festa Balada.jpg'),
  ('Camisa Térmica','src/imagens/Camisa Térmica.jpg'),
  ('Chinelo','src/imagens/Chinelo.jpg'),
  ('Colar Pingente','src/imagens/Colar Pingente.jpg'),
  ('Jaqueta Masculina Preta','src/imagens/Jaqueta Masculina Preta.jpg'),
  ('Kit de Pincéis de Maquiagem','src/imagens/Kit de Pincéis de Maquiagem.jpg'),
  ('Relógio','src/imagens/Relógio.jpg'),
  ('Sapatilha Sapato','src/imagens/Sapatilha Sapato.jpg'),
  ('Sapato Social','src/imagens/Sapato Social.jpg'),
  ('Tênis Feminino','src/imagens/Tênis Feminino.jpg'),
  ('Vestido Infantil','src/imagens/Vestido Infantil.jpg');
  
INSERT INTO vendas (vendedor, produto_id, total)
SELECT
  ELT(1 + FLOOR(RAND()*20),
      'Bruno','Carla','Elisa','Felipe','Gabriela','Henrique','Isabela','João',
      'Karen','Lucas','Mariana','Nicolas','Olívia','Paulo','Queila','Rafael',
      'Sofia','Tiago','Tatiane','Vinícius') AS vendedor,
  p.id AS produto_id,
  ROUND((RAND() * (799.90 - 59.90)) + 59.90, 2) AS total
FROM produtos p;

SELECT * FROM vendas LIMIT 20;