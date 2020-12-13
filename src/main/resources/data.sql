INSERT INTO endereco (id, bairro, cep, complemento, logradouro, municipio, numero, uf)
VALUES (1, 'Bairro A','21730-660', null, 'Rua 1', 'Rio de Janeiro', '76', 'RJ');

INSERT INTO endereco (id, bairro, cep, complemento, logradouro, municipio, numero, uf)
VALUES (2, 'Bairro C','21730-660', null, 'Rua 2132', 'Rio de Janeiro', '32', 'RJ');

INSERT INTO endereco (id, bairro, cep, complemento, logradouro, municipio, numero, uf)
VALUES (3, 'Bairro A','21730-660', null, 'Rua 1', 'Rio de Janeiro', '76', 'RJ');

INSERT INTO pessoa (id, celular, cpf, data_nasc, identidade, nome, sexo, endereco_id)
VALUES (1, '(11) 11111-1111', '111.111.111-11', '11/11/1990', '11.111.111-11', 'Rodrigo Werneck', 'Masculino', 1);

INSERT INTO pessoa (id, celular, cpf, data_nasc, identidade, nome, sexo, endereco_id)
VALUES (2, '(22) 22222-2222', '222.222.222-22', '22/11/1990', '22.222.222-22', 'Maria Luiza', 'Feminino', 2);

INSERT INTO pessoa (id, celular, cpf, data_nasc, identidade, nome, sexo, endereco_id)
VALUES (3, null, null, '01/08/2005', '12.312.553-87', 'Filha 01', 'Feminino', 3);

INSERT INTO usuario (id, email, senha, tipo_usuario, pessoa_id)
VALUES (1, 'rodrigo.werneck@id.uff.br', '123456', 0, 1);

INSERT INTO usuario (id, email, senha, tipo_usuario, pessoa_id)
VALUES (2, 'malu@id.uff.br', '123456', 0, 2);

INSERT INTO aluno (id, id_responsavel, naturalidade, nome_mae, nome_pai, pessoa_id)
VALUE (1, 1, 'fluminense', 'mãe', 'pai', 3);

INSERT INTO ano_escolaridade (id, nome, descricao)
VALUES (1, '1º Ano', 'primeiro ano do ensino fundamental');
INSERT INTO ano_escolaridade (id, nome, descricao)
VALUES (2, '2º Ano', 'segundo ano do ensino fundamental');
INSERT INTO ano_escolaridade (id, nome, descricao)
VALUES (3, '3º Ano', 'terceiro ano do ensino fundamental');
INSERT INTO ano_escolaridade (id, nome, descricao)
VALUES (4, '4º Ano', 'quarto ano do ensino fundamental');
INSERT INTO ano_escolaridade (id, nome, descricao)
VALUES (5, '5º Ano', 'quinto ano do ensino fundamental');
INSERT INTO ano_escolaridade (id, nome, descricao)
VALUES (6, '6º Ano', 'sexto ano do ensino fundamental');
INSERT INTO ano_escolaridade (id, nome, descricao)
VALUES (7, '7º Ano', 'sétimo ano do ensino fundamental');
INSERT INTO ano_escolaridade (id, nome, descricao)
VALUES (8, '8º Ano', 'oitavo ano do ensino fundamental');
INSERT INTO ano_escolaridade (id, nome, descricao)
VALUES (9, '9º Ano', 'nono ano do ensino fundamental');




