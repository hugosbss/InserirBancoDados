# InserirBancoDados
Aula 28/04

-- Cria o banco de dados 
CREATE DATABASE IF NOT EXISTS concessionaria;
USE concessionaria;

-- Cria a tabela veiculo
CREATE TABLE IF NOT EXISTS veiculo (
    id INT AUTO_INCREMENT PRIMARY KEY,
    descricao VARCHAR(255) NOT NULL,
    fabricante VARCHAR(255) NOT NULL
);
