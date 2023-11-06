-- Database Creation
CREATE DATABASE linketinder_core;



-- Tables Creation
CREATE TABLE candidates (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    city VARCHAR(50) NOT NULL,
    state_id INTEGER NOT NULL,
    country VARCHAR(50) NOT NULL,
    cep VARCHAR(8) NOT NULL,
    description VARCHAR(1000) NOT NULL,
    cpf VARCHAR(11) NOT NULL
);

CREATE TABLE companies (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    city VARCHAR(50) NOT NULL,
    state_id INTEGER NOT NULL,
    country VARCHAR(50) NOT NULL,
    cep VARCHAR(8) NOT NULL,
    description VARCHAR(1000) NOT NULL,
    cnpj VARCHAR(14) NOT NULL
);

CREATE TABLE certificates (
    id SERIAL PRIMARY KEY,
    candidate_id INTEGER NOT NULL REFERENCES candidates(id) ON DELETE CASCADE,
    title VARCHAR(50) NOT NULL,
    duration VARCHAR(50) NOT NULL
);

CREATE TABLE academic_experiences (
    id SERIAL PRIMARY KEY,
    candidate_id INTEGER NOT NULL REFERENCES candidates(id) ON DELETE CASCADE,
    educational_institution VARCHAR(50) NOT NULL,
    degree_type VARCHAR(50) NOT NULL,
    field_of_study VARCHAR(50) NOT NULL,
    course_status VARCHAR(50) NOT NULL
);

CREATE TABLE company_benefits (
    id SERIAL PRIMARY KEY,
    company_id INTEGER NOT NULL REFERENCES companies(id) ON DELETE CASCADE,
    benefit_id INTEGER NOT NULL
);

CREATE TABLE work_experiences (
    id SERIAL PRIMARY KEY,
    candidate_id INTEGER NOT NULL REFERENCES candidates(id) ON DELETE CASCADE,
    title VARCHAR(50) NOT NULL,
    company_name VARCHAR(50) NOT NULL,
    city VARCHAR(50) NOT NULL,
    currently_work BOOLEAN NOT NULL,
    description VARCHAR(1000) NOT NULL,
    state_id INTEGER NOT NULL,
    contract_type VARCHAR(50) NOT NULL,
    location_type VARCHAR(50) NOT NULL
);

CREATE TABLE job_vacancies (
    id SERIAL PRIMARY KEY,
    company_id INTEGER NOT NULL REFERENCES companies(id) ON DELETE CASCADE,
    title VARCHAR(50) NOT NULL,
    description VARCHAR(2000) NOT NULL,
    salary FLOAT NOT NULL,
    contract_type VARCHAR(50) NOT NULL,
    location_type VARCHAR(50) NOT NULL
);

CREATE TABLE job_vacancy_skills (
    id SERIAL PRIMARY KEY,
    job_vacancy_id INTEGER NOT NULL REFERENCES job_vacancies(id) ON DELETE CASCADE,
    skill_id INTEGER NOT NULL
);

CREATE TABLE candidate_languages (
    id SERIAL PRIMARY KEY,
    candidate_id INTEGER NOT NULL REFERENCES candidates(id) ON DELETE CASCADE,
    language_id INTEGER NOT NULL,
    proficiency VARCHAR(50) NOT NULL
);

CREATE TABLE candidate_skills (
    id SERIAL PRIMARY KEY,
    candidate_id INTEGER NOT NULL REFERENCES candidates(id) ON DELETE CASCADE,
    skill_id INTEGER NOT NULL,
    proficiency VARCHAR(50) NOT NULL
);

CREATE TABLE matches (
    id SERIAL PRIMARY KEY,
    candidate_id INTEGER NOT NULL REFERENCES candidates(id) ON DELETE CASCADE,
    job_vacancy_id INTEGER REFERENCES job_vacancies(id) ON DELETE CASCADE,
    company_id INTEGER REFERENCES companies(id) ON DELETE CASCADE
);



-- Data Inserts
INSERT INTO candidates (name, email, city, state_id, country, cep, description, cpf) VALUES
    ('Candidato 1', 'candidato1@gmail.com', 'Araraquara', 26, 'Brasil', '14800000', 'Descrição 1', '12312312334'),
    ('Candidato 2', 'candidato2@hotmail.com', 'São Carlos', 26, 'Brasil', '13560000', 'Descrição 2', '34534534567'),
    ('Candidato 3', 'candi@bol.com.br', 'Uberlândia', 11, 'Brasil', '38400000', 'Descrição 3', '67867845689'),
    ('Candidato 4', 'candidato4@gmail.com', 'São Paulo', 26, 'Brasil', '01153000', 'Descrição 4', '12378945634'),
    ('Candidato 5', 'candidato5@mail.com', 'Araxá', 11, 'Brasil', '38180000', 'Descrição 5', '45623467898');

INSERT INTO companies (name, email, city, state_id, country, cep, description, cnpj) VALUES
    ('Empresa 1', 'empresa1@gmail.com', 'Ribeirão Preto', 26, 'Brasil', '14010000', 'Descrição 1', '12345678945634'),
    ('Empresa 2', 'empresa2@gmail.com', 'Araraquara', 26, 'Brasil', '14800000', 'Descrição 2', '45645645667845'),
    ('Empresa 3', 'empresa3@gmail.com', 'Maceió', 2, 'Brasil', '57000000', 'Descrição 3', '32198765498745'),
    ('Empresa 4', 'empresa4@gmail.com', 'São Paulo', 26, 'Brasil', '01153015', 'Descrição 4', '98745835487515'),
    ('Empresa 5', 'empresa5@gmail.com', 'São Paulo', 26, 'Brasil', '01153000', 'Descrição 5', '23534567845629');

INSERT INTO certificates (candidate_id, title, duration) VALUES
    (1, 'Curso Certificado 1', '1 mês'),
    (1, 'Curso Certificado 2', '2 anos'),
    (2, 'Curso Certificado 3', '3 meses'),
    (3, 'Curso Certificado 4', '1 mês'),
    (3, 'Curso Certificado A', '3 semanas'),
    (3, 'Curso Certificado B', '1 ano'),
    (2, 'Curso Certificado C', '100 horas'),
    (5, 'Curso Certificado D', '10 horas'),
    (5, 'Curso Certificado E', '1 hora');

INSERT INTO academic_experiences (candidate_id, educational_institution, degree_type, field_of_study, course_status) VALUES
    (1, 'Anhanguera', 'Bacharel', 'Engenharia de Software', 'Cursando'),
    (2, 'FGV', 'Bacharel', 'Análise e Desenvolvimento de Sistemas', 'Concluído'),
    (2, 'PUC', 'Mestrado', 'Engenharia de Software', 'Cursando'),
    (3, 'Logatti', 'Bacharel', 'Engenharia de Software', 'Trancado'),
    (4, 'UFPR', 'Bacharel', 'Engenharia da Computação', 'Cursando'),
    (4, 'USP', 'Bacharel', 'Ciência da Computação', 'Concluído'),
    (5, 'FGV', 'Bacharel', 'Análise e Desenvolvimento de Sistemas', 'Concluído'),
    (5, 'PUC', 'Mestrado', 'Engenharia de Software', 'Cursando');

INSERT INTO work_experiences (candidate_id, title, company_name, city, currently_work, description, state_id, contract_type, location_type) VALUES
    (1, 'Assistente Fiscal', 'Empresa 1', 'Patos de Minas', true, 'Descrição Emprego 1', 11, 'CLT', 'Presencial'),
    (2, 'Assistente Contábil', 'Empresa Beta', 'Curitiba', false, 'Descrição Emprego 2', 18, 'Temporário', 'Remoto'),
    (2, 'Desenvolvedor Backend', 'Empresa Neo', 'São Paulo', true, 'Descrição Emprego 3', 26, 'PJ', 'Presencial'),
    (3, 'Estagiário de Desenvolvimento', 'Empresa 8', 'Patos de Minas', true, 'Descrição Emprego 4', 11, 'Estágio', 'Híbrido'),
    (5, 'Desenvolvedor Web', 'Empresa Neo', 'São Paulo', true, 'Descrição Emprego 5', 26, 'PJ', 'Presencial'),
    (5, 'Assistente Cantábil', 'Empresa Alfa', 'Curitiba', false, 'Descrição Emprego 6', 18, 'Temporário', 'Remoto'),
    (5, 'Desenvolvedor Web', 'Empresa Neo', 'São Paulo', false, 'Descrição Emprego 7',26, 'PJ', 'Presencial');

INSERT INTO job_vacancies (company_id, title, description, salary, contract_type, location_type) VALUES
    (1, 'Vaga 1', 'Descrição Vaga 1', 1000, 'Estágio', 'Híbrido'),
    (1, 'Vaga 2', 'Descrição Vaga 2', 2000, 'Temporário', 'Presencial'),
    (2, 'Vaga 3', 'Descrição Vaga 3', 3000, 'CLT', 'Remoto'),
    (4, 'Vaga 4', 'Descrição Vaga 4', 2500, 'PJ', 'Presencial'),
    (3, 'Vaga 5', 'Descrição Vaga 5', 3500, 'CLT', 'Presencial'),
    (2, 'Vaga 6', 'Descrição Vaga 6', 2250, 'PJ', 'Remoto');

INSERT INTO company_benefits (company_id, benefit_id) VALUES
    (1, 1),
    (1, 2),
    (1, 5),
    (3, 1),
    (2, 2),
    (3, 4),
    (2, 3),
    (4, 5),
    (4, 6),
    (4, 2),
    (5, 1),
    (5, 3),
    (5, 5);

INSERT INTO job_vacancy_skills (job_vacancy_id, skill_id) VALUES
    (1, 1),
    (1, 8),
    (1, 4),
    (2, 12),
    (2, 3),
    (4, 1),
    (4, 6),
    (4, 8),
    (5, 9),
    (5, 10),
    (5, 12),
    (6, 12),
    (6, 3),
    (2, 11),
    (6, 6),
    (6, 7);

INSERT INTO candidate_languages (candidate_id, language_id, proficiency) VALUES
    (1, 1, 'Avançado'),
    (1, 2, 'Intermediário'),
    (2, 1, 'Avançado'),
    (3, 1, 'Avançado'),
    (3, 3, 'Avançado'),
    (3, 5, 'Básico'),
    (4, 1, 'Avançado'),
    (4, 6, 'Intermediário'),
    (5, 1, 'Avançado');

INSERT INTO candidate_skills (candidate_id, skill_id, proficiency) VALUES
    (1, 1, 'Intermediário'),
    (2, 1, 'Avançado'),
    (2, 2, 'Intermediário'),
    (2, 4, 'Básico'),
    (3, 1, 'Avançado'),
    (3, 2, 'Intermediário'),
    (3, 5, 'Intermediário'),
    (3, 6, 'Básico'),
    (4, 7, 'Avançado'),
    (4, 3, 'Intermediário'),
    (4, 8, 'Básico'),
    (5, 10, 'Avançado'),
    (5, 11, 'Intermediário'),
    (5, 8, 'Básico'),
    (5, 12, 'Avançado');

INSERT INTO matches (candidate_id, job_vacancy_id, company_id) VALUES
    (1, 1, 1),
    (1, 2, 1),
    (1, 6, 2),
    (2, 3, 2),
    (4, 5, 3),
    (4, 1, 1),
    (3, 3, 2),
    (3, 4, 4),
    (5, 1, 1),
    (5, 6, 2),
    (5, 4, 4),
    (3, 1, 1),
    (1, NULL, 1),
    (1, 2, NULL),
    (1, NULL, 2),
    (2, 3, NULL),
    (4, NULL, 3),
    (4, 1, NULL),
    (3, NULL, 2),
    (3, NULL, 4),
    (5, NULL, 1),
    (5, 6, NULL),
    (5, 4, NULL),
    (3, NULL, 1);
