CREATE DATABASE IF NOT EXISTS db_lavacao;
USE db_lavacao;

CREATE TABLE cor (
    id INT NOT NULL AUTO_INCREMENT,
    nome varchar(25) not null,
    CONSTRAINT pk_cor
            PRIMARY KEY(id)
) engine = InnoDB;

CREATE TABLE marca (
    id INT NOT NULL AUTO_INCREMENT,
    nome varchar(25) not null,
    CONSTRAINT pk_cor
    PRIMARY KEY(id)
) engine = InnoDB;

CREATE TABLE servico (
    id INT NOT NULL AUTO_INCREMENT,
    descricao VARCHAR(100) NOT NULL,
    valor DECIMAL NOT NULL,
    CONSTRAINT pk_servico
    PRIMARY KEY(id)
) engine = InnoDB;

CREATE TABLE parametros_de_sistema (
    chave char(6) not null,
    pontos int not null,
    constraint pk_parametros_de_sistema primary key(chave)
) engine=InnoDB;

INSERT INTO cor(nome)
VALUES ('Vermelho');

INSERT INTO marca(nome)
VALUES ('Chevrolet');

insert into servico(descricao, valor) values ('polimento',100);

insert into parametros_de_sistema values ('pontos',20);