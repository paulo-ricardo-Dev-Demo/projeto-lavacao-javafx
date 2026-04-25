DROP DATABASE IF EXISTS db_lavacao;
CREATE DATABASE db_lavacao;
USE db_lavacao;

CREATE TABLE cor (
    id BIGINT NOT NULL AUTO_INCREMENT,
    nome varchar(25) not null UNIQUE,
    CONSTRAINT pk_cor PRIMARY KEY(id)
) engine = InnoDB;

CREATE TABLE marca (
    id INT NOT NULL AUTO_INCREMENT,
    nome varchar(25) not null unique,
    CONSTRAINT pk_marca
    PRIMARY KEY(id)
) engine = InnoDB;

CREATE TABLE servico (
    id INT NOT NULL AUTO_INCREMENT,
    descricao VARCHAR(100) NOT NULL,
    valor DECIMAL NOT NULL,
    categoria ENUM('PEQUENO','MEDIO','GRANDE', 'MOTO', 'PADRAO') NOT NULL DEFAULT 'PADRAO',
    CONSTRAINT pk_servico
    PRIMARY KEY(id)
) engine = InnoDB;

CREATE TABLE parametros_de_sistema (
    chave char(6) not null,
    pontos int not null,
    constraint pk_parametros_de_sistema primary key(chave)
) engine=InnoDB;

CREATE TABLE modelo (
    id INT NOT NULL AUTO_INCREMENT,
    descricao VARCHAR(100) NOT NULL unique,
    marca_id int NOT NULL references marca(id),
    categoria ENUM('PEQUENO','MEDIO','GRANDE', 'MOTO', 'PADRAO') NOT NULL DEFAULT 'PADRAO',
    potencia int not null,
    tipo_combustivel ENUM('GASOLINA','ETANOL','FLEX','DIESEL','GNV','OUTRO') NOT NULL DEFAULT 'GASOLINA',
    CONSTRAINT pk_modelo PRIMARY KEY(id)
) engine = InnoDB;

CREATE TABLE cliente (
    id INT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    celular varchar(20) NOT NULL,
    email varchar(50) CHECK (email LIKE '%@%.%') unique,
    data_cadastro datetime,
    CONSTRAINT pk_cliente PRIMARY KEY(id)
) engine = InnoDB;

CREATE TABLE pessoa_fisica (
    id_cliente INT NOT NULL REFERENCES cliente(id) ON DELETE CASCADE,
    cpf CHAR(14) NOT NULL check (cpf LIKE '___.___.___-__') unique,
    data_nascimento date,
    CONSTRAINT pk_pessoa_fisica PRIMARY KEY(id_cliente)
) engine = InnoDB;

CREATE TABLE pessoa_juridica (
    id_cliente INT NOT NULL REFERENCES cliente(id) ON DELETE CASCADE,
    cnpj CHAR(18) NOT NULL check (cnpj LIKE '__.___.___/____-__') unique,
    inscricao_estadual varchar(20) unique CHECK(length(inscricao_estadual) >= 8 AND inscricao_estadual NOT LIKE '%[a-zA-Z]%') ,
    CONSTRAINT pk_pessoa_juridica PRIMARY KEY(id_cliente)
) engine = InnoDB;

CREATE TABLE pontuacao (
    id_cliente INT NOT NULL REFERENCES cliente(id) ON DELETE CASCADE,
    quantidade int not null default 0,
    CONSTRAINT pk_pontuacao PRIMARY KEY(id_cliente)
) engine = InnoDB;

CREATE TABLE veiculo (
    id int not null auto_increment,
    placa varchar(20) not null,
    observacoes text,
    id_cliente int not null references cliente(id) ON DELETE CASCADE,
    id_cor long not null references cor(id),
    id_modelo int not null references modelo(id),
    constraint pk_veiculo primary key(id)
) engine = InnoDB;


INSERT INTO cor(nome)
VALUES ('Vermelho');

INSERT INTO marca(nome)
VALUES ('Chevrolet');

insert into servico(descricao, valor) values ('polimento',100);

insert into parametros_de_sistema values ('pontos',20);

insert into modelo(descricao, marca_id, categoria, potencia, tipo_combustivel) values
        ("Maserati MC20", 1,'MEDIO',630, 'GASOLINA');