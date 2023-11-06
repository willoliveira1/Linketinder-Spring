-- Database Creation
-- CREATE DATABASE linketinder_auxiliar;



-- Tables Creation
CREATE TABLE states (
    id SERIAL PRIMARY KEY,
    name VARCHAR(25) NOT NULL,
    acronym VARCHAR(2) NOT NULL
);

CREATE TABLE skills (
    id SERIAL PRIMARY KEY,
    title VARCHAR(50) NOT NULL
);

CREATE TABLE benefits (
    id SERIAL PRIMARY KEY,
    title VARCHAR(50) NOT NULL
);

CREATE TABLE languages (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);



-- Data Inserts
INSERT INTO states (name, acronym) VALUES
    ('Acre', 'AC'),
    ('Alagoas', 'AL'),
    ('Amazonas', 'AM'),
    ('Amapá', 'AP'),
    ('Bahia', 'BA'),
    ('Ceará', 'CE'),
    ('Distrito Federal', 'DF'),
    ('Espírito Santo', 'ES'),
    ('Goiás', 'GO'),
    ('Maranhão', 'MA'),
    ('Minas Gerais', 'MG'),
    ('Mato Grosso', 'MT'),
    ('Mato Grosso do Sul', 'MS'),
    ('Pará', 'PA'),
    ('Paraiba', 'PB'),
    ('Pernambuco', 'PE'),
    ('Piauí', 'PI'),
    ('Paraná', 'PR'),
    ('Rio de Janeiro', 'RJ'),
    ('Rio Grande do Norte', 'RN'),
    ('Rondônia', 'RO'),
    ('Roraima', 'RR'),
    ('Rio Grande do Sul', 'RS'),
    ('Santa Catarina', 'SC'),
    ('Sergipe', 'SE'),
    ('São Paulo', 'SP'),
    ('Tocantins', 'TO');

INSERT INTO skills (title) VALUES
    ('Java'),
    ('Groovy'),
    ('SQL Server'),
    ('PostgreSQL'),
    ('Rust'),
    ('C++'),
    ('Kotlin'),
    ('Angular'),
    ('Typescript'),
    ('Python'),
    ('Javascript'),
    ('C#');

INSERT INTO benefits (title) VALUES
    ('Vale-Transporte'),
    ('Vale-Refeição'),
    ('Vale-Alimentação'),
    ('Refeição no local'),
    ('Plano de Saúde'),
    ('Plano Odontológico'),
    ('Gympass'),
    ('Seguro de Vida'),
    ('Participação nos Lucros');

INSERT INTO languages (name) VALUES
    ('Português'),
    ('Inglês'),
    ('Espanhol'),
    ('Alemão'),
    ('Francês'),
    ('Chinês'),
    ('Japonês');
