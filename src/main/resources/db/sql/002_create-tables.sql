--liquibase formatted sql

--changeset mvolinger:starting_app_tables

CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE IF NOT EXISTS dbo.tabela_nutricional (
    tabela_nutricional_id uuid DEFAULT uuid_generate_v4 (),
    calorias NUMERIC NOT NULL DEFAULT 0,
    carboidratos NUMERIC NOT NULL DEFAULT 0,
    proteinas NUMERIC NOT NULL DEFAULT 0,
    gorduras_totais NUMERIC NOT NULL DEFAULT 0,
    gorduras_saturadas NUMERIC NOT NULL DEFAULT 0,
    fibra_alimentar NUMERIC NOT NULL DEFAULT 0,
    sodio NUMERIC NOT NULL DEFAULT 0,
    PRIMARY KEY (tabela_nutricional_id)
);

CREATE TABLE IF NOT EXISTS dbo.tipo_ingrediente (
    tipo_ingrediente_id uuid DEFAULT uuid_generate_v4 (),
    carboidrato BOOLEAN NOT NULL DEFAULT FALSE,
    proteina_animal BOOLEAN NOT NULL DEFAULT FALSE,
    proteina_vegetal BOOLEAN NOT NULL DEFAULT FALSE,
    verdura BOOLEAN NOT NULL DEFAULT FALSE,
    legume BOOLEAN NOT NULL DEFAULT FALSE,
    fruta BOOLEAN NOT NULL DEFAULT FALSE,
    PRIMARY KEY (tipo_ingrediente_id)
);

CREATE TABLE IF NOT EXISTS dbo.tipo_refeicao (
    tipo_refeicao_id uuid DEFAULT uuid_generate_v4 (),
    cafe_da_manha BOOLEAN NOT NULL DEFAULT FALSE,
    lanche BOOLEAN NOT NULL DEFAULT FALSE,
    almoco BOOLEAN NOT NULL DEFAULT FALSE,
    jantar BOOLEAN NOT NULL DEFAULT FALSE,
    PRIMARY KEY (tipo_refeicao_id)
);

CREATE TABLE IF NOT EXISTS dbo.tipo_dieta (
    tipo_dieta_id uuid DEFAULT uuid_generate_v4 (),
    onivoro BOOLEAN NOT NULL DEFAULT FALSE,
    vegetariano_estrito BOOLEAN NOT NULL DEFAULT FALSE,
    ovovegetariano BOOLEAN NOT NULL DEFAULT FALSE,
    lactovegetariano BOOLEAN NOT NULL DEFAULT FALSE,
    ovolactovegetariano BOOLEAN NOT NULL DEFAULT FALSE,
    pescetariano BOOLEAN NOT NULL DEFAULT FALSE,
    doenca_celiaca BOOLEAN NOT NULL DEFAULT FALSE,
    doenca_hipolactasia BOOLEAN NOT NULL DEFAULT FALSE,
    doenca_diabetes BOOLEAN NOT NULL DEFAULT FALSE,
    PRIMARY KEY (tipo_dieta_id)
);

CREATE TABLE IF NOT EXISTS dbo.usuario (
    usuario_id uuid DEFAULT uuid_generate_v4 (),
    nome VARCHAR(255) NOT NULL,
    sobrenome VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    senha VARCHAR(255) NOT NULL,
    tipo_dieta_id uuid NOT NULL,
    PRIMARY KEY (usuario_id),
    FOREIGN KEY (tipo_dieta_id) REFERENCES dbo.tipo_dieta(tipo_dieta_id) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS dbo.cardapio_semanal (
    cardapio_semanal_id uuid DEFAULT uuid_generate_v4 (),
    descricao VARCHAR(255) NOT NULL,
    usuario_id uuid NOT NULL,
    PRIMARY KEY (cardapio_semanal_id),
    FOREIGN KEY (usuario_id) REFERENCES dbo.usuario(usuario_id) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS dbo.refeicao_individual (
    refeicao_individual_id uuid DEFAULT uuid_generate_v4 (),
    descricao VARCHAR(255) NOT NULL,
    usuario_id uuid NOT NULL,
    tipo_refeicao_id uuid NOT NULL,
    PRIMARY KEY (refeicao_individual_id),
    FOREIGN KEY (usuario_id) REFERENCES dbo.usuario(usuario_id) ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (tipo_refeicao_id) REFERENCES dbo.tipo_refeicao(tipo_refeicao_id) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS dbo.cardapio_refeicao (
    cardapio_semanal_id uuid REFERENCES dbo.cardapio_semanal(cardapio_semanal_id) ON UPDATE CASCADE ON DELETE CASCADE,
    refeicao_individual_id uuid REFERENCES dbo.refeicao_individual(refeicao_individual_id) ON UPDATE CASCADE ON DELETE CASCADE,
    PRIMARY KEY (cardapio_semanal_id, refeicao_individual_id)
);

CREATE TABLE IF NOT EXISTS dbo.ingrediente (
    ingrediente_id uuid DEFAULT uuid_generate_v4 (),
    nome VARCHAR(255) NOT NULL,
    descricao VARCHAR(255) NOT NULL,
    tabela_nutricional_id uuid NOT NULL,
    tipo_ingrediente_id uuid NOT NULL,
    tipo_refeicao_id uuid NOT NULL,
    tipo_dieta_id uuid NOT NULL,
    PRIMARY KEY (ingrediente_id),
    FOREIGN KEY (tabela_nutricional_id) REFERENCES dbo.tabela_nutricional(tabela_nutricional_id) ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (tipo_ingrediente_id) REFERENCES dbo.tipo_ingrediente(tipo_ingrediente_id) ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (tipo_refeicao_id) REFERENCES dbo.tipo_refeicao(tipo_refeicao_id) ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (tipo_dieta_id) REFERENCES dbo.tipo_dieta(tipo_dieta_id) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS dbo.refeicao_ingrediente (
    refeicao_individual_id uuid REFERENCES dbo.refeicao_individual(refeicao_individual_id) ON UPDATE CASCADE ON DELETE CASCADE,
    ingrediente_id uuid REFERENCES dbo.ingrediente(ingrediente_id) ON UPDATE CASCADE ON DELETE CASCADE,
    PRIMARY KEY (refeicao_individual_id, ingrediente_id)
);

CREATE TABLE IF NOT EXISTS dbo.receita (
    receita_id uuid DEFAULT uuid_generate_v4 (),
    usuario_id uuid NOT NULL,
    titulo VARCHAR(255) NOT NULL,
    descricao VARCHAR(255) NOT NULL,
    preparacao VARCHAR(1000) NOT NULL,
    categoria VARCHAR(255) NOT NULL,
    PRIMARY KEY (receita_id),
    FOREIGN KEY (usuario_id) REFERENCES dbo.usuario(usuario_id) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS dbo.ingrediente_receita (
    ingrediente_id uuid REFERENCES dbo.ingrediente(ingrediente_id) ON UPDATE CASCADE ON DELETE CASCADE,
    receita_id uuid REFERENCES dbo.receita(receita_id) ON UPDATE CASCADE ON DELETE CASCADE,
    quantidade VARCHAR(255) NOT NULL,
    PRIMARY KEY (ingrediente_id, receita_id)
);

CREATE TABLE IF NOT EXISTS dbo.lista_compras (
    lista_compras_id uuid DEFAULT uuid_generate_v4 (),
    usuario_id uuid NOT NULL,
    PRIMARY KEY (lista_compras_id),
    FOREIGN KEY (usuario_id) REFERENCES dbo.usuario(usuario_id) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS dbo.ingrediente_compras (
    ingrediente_id uuid REFERENCES dbo.ingrediente(ingrediente_id) ON UPDATE CASCADE ON DELETE CASCADE,
    lista_compras_id uuid REFERENCES dbo.lista_compras(lista_compras_id) ON UPDATE CASCADE ON DELETE CASCADE,
    quantidade VARCHAR(255) NOT NULL,
    PRIMARY KEY (ingrediente_id, lista_compras_id)
);

--rollback DROP TABLE dbo.usuario;
--rollback DROP TABLE dbo.cardapio_semanal;
--rollback DROP TABLE dbo.refeicao_individual;
--rollback DROP TABLE dbo.ingrediente;
--rollback DROP TABLE dbo.tipo_refeicao;
--rollback DROP TABLE dbo.tipo_ingrediente;
--rollback DROP TABLE dbo.tabela_nutricional;
--rollback DROP TABLE dbo.tipo_dieta;
--rollback DROP TABLE dbo.receita;
--rollback DROP TABLE dbo.lista_compras;
--rollback DROP TABLE dbo.ingrediente_compras;
--rollback DROP TABLE dbo.ingrediente_receita;
--rollback DROP TABLE dbo.refeicao_ingrediente;
--rollback DROP TABLE dbo.cardapio_refeicao;