DROP DATABASE IF EXISTS db_lavacao;
CREATE DATABASE db_lavacao;
USE db_lavacao;

CREATE TABLE cor (
    id BIGINT NOT NULL AUTO_INCREMENT,
    nome varchar(25) not null UNIQUE,
    CONSTRAINT pk_cor
        PRIMARY KEY(id)
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
    constraint pk_parametros_de_sistema
        primary key(chave)
) engine=InnoDB;

CREATE TABLE modelo (
    id INT NOT NULL AUTO_INCREMENT,
    descricao VARCHAR(100) NOT NULL unique,
    categoria ENUM('PEQUENO','MEDIO','GRANDE', 'MOTO', 'PADRAO') NOT NULL DEFAULT 'PADRAO',
    marca_id int NOT NULL,
    CONSTRAINT pk_modelo
        PRIMARY KEY(id),
    CONSTRAINT fk_modelo_marca
        foreign key (marca_id) references marca(id) on update cascade
) engine = InnoDB;

CREATE TABLE motor (
    id_modelo int not null,
    potencia int not null,
    tipo_combustivel ENUM('GASOLINA','ETANOL','FLEX','DIESEL','GNV','OUTRO') not null,
    CONSTRAINT pk_motor
        PRIMARY KEY (id_modelo),
    CONSTRAINT fk_motor_modelo
        foreign key (id_modelo) references modelo(id) on delete cascade on update cascade
) engine = InnoDB;

CREATE TABLE cliente (
    id INT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    celular varchar(20) NOT NULL,
    email varchar(50) CHECK (email LIKE '%@%.%') unique,
    data_cadastro datetime,
    CONSTRAINT pk_cliente
        PRIMARY KEY(id)
) engine = InnoDB;

CREATE TABLE pessoa_fisica (
    id_cliente INT NOT NULL,
    cpf CHAR(14) NOT NULL check (cpf LIKE '___.___.___-__') unique,
    data_nascimento date,
    CONSTRAINT pk_pessoa_fisica
        PRIMARY KEY(id_cliente),
    CONSTRAINT fk_pessoa_fisica_cliente
        foreign key (id_cliente) references cliente(id) on delete cascade on update cascade
) engine = InnoDB;

CREATE TABLE pessoa_juridica (
    id_cliente INT NOT NULL,
    cnpj CHAR(18) NOT NULL check (cnpj LIKE '__.___.___/____-__') unique,
    inscricao_estadual varchar(20)
        CHECK(length(inscricao_estadual) >= 8 AND inscricao_estadual NOT LIKE '%[a-zA-Z]%'),
    CONSTRAINT pk_pessoa_juridica PRIMARY KEY(id_cliente),
    CONSTRAINT fk_pessoa_juridica_cliente
        foreign key (id_cliente) references cliente(id) on delete cascade on update cascade
) engine = InnoDB;

CREATE TABLE pontuacao (
    id_cliente INT NOT NULL,
    quantidade int not null default 0,
    CONSTRAINT pk_pontuacao PRIMARY KEY(id_cliente),
    CONSTRAINT fk_pontuacao_cliente
        foreign key (id_cliente) references cliente(id) on delete cascade on update cascade
) engine = InnoDB;

CREATE TABLE veiculo (
    id int not null auto_increment,
    placa varchar(20) not null,
    observacoes text,
    id_cliente int not null,
    id_cor bigint not null,
    id_modelo int not null,
    constraint pk_veiculo primary key(id),
    CONSTRAINT fk_veiculo_cliente
        foreign key (id_cliente) references cliente(id) on delete cascade on update cascade,
    CONSTRAINT fk_veiculo_cor
        foreign key (id_cor) references cor(id) on delete cascade on update cascade,
    CONSTRAINT fk_veiculo_modelo
        foreign key (id_modelo) references modelo(id) on delete cascade on update cascade
) engine = InnoDB;

CREATE TABLE ordem_servico(
    numero bigint not null auto_increment,
    total double not null,
    agenda datetime not null,
    desconto double not null default 0,
    status ENUM('ABERTA','FECHADA','CANCELADA') NOT NULL DEFAULT 'ABERTA',
    id_veiculo INT NOT NULL,
    constraint pk_ordem_servico primary key(numero),
    CONSTRAINT fk_ordem_servico_veiculo
        FOREIGN KEY (id_veiculo) REFERENCES veiculo(id)
)engine = InnoDB;

CREATE TABLE item_os (
    numero_os bigint not null,
    id_servico int not null,
    valor_servico double not null,
    constraint pk_item_os
        primary key(numero_os),
    CONSTRAINT fk_item_os_ordem_servico
        FOREIGN KEY (numero_os) REFERENCES ordem_servico(numero),
    CONSTRAINT fk_item_os_servico
        FOREIGN KEY (id_servico) REFERENCES servico(id)
)engine = InnoDB;


INSERT INTO cor(nome)
VALUES ('Vermelho');

INSERT INTO marca(nome)
VALUES ('Maserati');

insert into servico(descricao, valor) values ('polimento',100);

insert into parametros_de_sistema values ('pontos',20);

insert into modelo(descricao, marca_id, categoria) values
        ("Maserati MC20", 1,'MEDIO');

insert into motor VALUES ((SELECT MAX(ID) FROM modelo), 630, 'GASOLINA');

