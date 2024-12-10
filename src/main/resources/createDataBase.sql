CREATE DATABASE GPMS;
USE GPMS;


-- Criação da tabela de Usuário
CREATE TABLE Usuario
(
    id       INT AUTO_INCREMENT PRIMARY KEY,
    nome     VARCHAR(100)        NOT NULL,
    email    VARCHAR(100) UNIQUE NOT NULL,
    senha    VARCHAR(255)        NOT NULL,
    telefone VARCHAR(15)
);

-- Criação da tabela de Endereço
CREATE TABLE Endereco
(
    id         INT AUTO_INCREMENT PRIMARY KEY,
    rua        VARCHAR(255) NOT NULL,
    cidade     VARCHAR(100) NOT NULL,
    estado     VARCHAR(100) NOT NULL,
    numero     VARCHAR(10)  NOT NULL,
    cep        VARCHAR(10)  NOT NULL,
    uf         CHAR(2)      NOT NULL,
    id_usuario INT          NOT NULL,
    FOREIGN KEY (id_usuario) REFERENCES Usuario (id) ON DELETE CASCADE
);

-- Criação da tabela de Anúncio
CREATE TABLE Anuncio
(
    id           INT AUTO_INCREMENT PRIMARY KEY,
    descricao    TEXT                                                                        NOT NULL,
    foto         LONGBLOB,
    tipo_anuncio ENUM ('Busca', 'Oferta')                                                    NOT NULL,
    preco        DECIMAL(10, 2),
    endereco     VARCHAR(255)                                                                NOT NULL,
    categoria    ENUM ('Livro', 'Roupa', 'Móvel', 'Aula Particular', 'Tecnologia', 'Imóvel') NOT NULL,
    id_usuario   INT                                                                         NOT NULL,
    FOREIGN KEY (id_usuario) REFERENCES Usuario (id) ON DELETE CASCADE
);

-- Criação da tabela de Avaliação
CREATE TABLE Avaliacao
(
    id                   INT AUTO_INCREMENT PRIMARY KEY,
    avaliacao            INT NOT NULL CHECK (avaliacao BETWEEN 1 AND 5), -- Avaliação entre 1 e 5
    id_usuario_avaliado  INT NOT NULL,
    id_usuario_avaliador INT NOT NULL,
    id_anuncio           INT NOT NULL,
    FOREIGN KEY (id_usuario_avaliado) REFERENCES Usuario (id) ON DELETE CASCADE,
    FOREIGN KEY (id_usuario_avaliador) REFERENCES Usuario (id) ON DELETE CASCADE,
    FOREIGN KEY (id_anuncio) REFERENCES Anuncio (id) ON DELETE CASCADE,
    UNIQUE (id_usuario_avaliado, id_usuario_avaliador, id_anuncio)
);



