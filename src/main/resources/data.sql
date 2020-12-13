INSERT INTO endereco (id, bairro, cep, complemento, logradouro, municipio, numero, uf)
VALUES (1, 'Bairro A', '11130-310', 'Em frente a casa 184', 'Rua XD', 'Rio de Janeiro', '76', 'RJ');
INSERT INTO endereco (id, bairro, cep, complemento, logradouro, municipio, numero, uf)
VALUES (2, 'Bairro C', '21721-263', 'LT. 78', 'Rua 2132', 'Rio de Janeiro', '32', 'RJ');
INSERT INTO endereco (id, bairro, cep, complemento, logradouro, municipio, numero, uf)
VALUES (3, 'Bairro K', '23120-191', 'S/N', 'Rua K1', 'Rio de Janeiro', '8', 'RJ');
INSERT INTO endereco (id, bairro, cep, complemento, logradouro, municipio, numero, uf)
VALUES (4, 'Bairro C', '21721-263', '', 'Rua 2167', 'Rio de Janeiro', '226', 'RJ');
INSERT INTO endereco (id, bairro, cep, complemento, logradouro, municipio, numero, uf)
VALUES (5, 'Bairro A', '11130-310', 'Em frente a casa 184', 'Rua XD', 'Rio de Janeiro', '76', 'RJ');
INSERT INTO endereco (id, bairro, cep, complemento, logradouro, municipio, numero, uf)
VALUES (6, 'Bairro A', '11130-310', 'Em frente a casa 184', 'Rua XD', 'Rio de Janeiro', '76', 'RJ');

INSERT INTO endereco (id, bairro, cep, complemento, logradouro, municipio, numero, uf)
VALUES (7, 'Bairro A', '11130-310', 'Paralela a Rua XD', 'Rua XF', 'Rio de Janeiro', '310', 'RJ');
INSERT INTO endereco (id, bairro, cep, complemento, logradouro, municipio, numero, uf)
VALUES (8, 'Bairro H', '23178-981', 'Próximo ao posto Z', 'Rua O23', 'Rio de Janeiro', '23', 'RJ');

<<<<<<< HEAD
=======
INSERT INTO endereco (id, bairro, cep, complemento, logradouro, municipio, numero, uf)
VALUES (4, 'Bairro A','21730-660', null, 'Rua ABC', 'Rio de Janeiro', '126', 'RJ');

INSERT INTO endereco (id, bairro, cep, complemento, logradouro, municipio, numero, uf)
VALUES (5, 'Bairro A','21730-660', null, 'Rua DFG', 'Rio de Janeiro', '226', 'RJ');

INSERT INTO pessoa (id, celular, cpf, data_nasc, identidade, nome, sexo, endereco_id)
VALUES (1, '(11) 11111-1111', '111.111.111-11', '11/11/1990', '11.111.111-11', 'Rodrigo Werneck', 'Masculino', 1);
>>>>>>> master

INSERT INTO pessoa (id, celular, cpf, data_nasc, identidade, nome, sexo, endereco_id)
VALUES (1, '(11) 11111-1111', '111.111.111-11', '01/01/1990', '11.111.111-11', 'Rodrigo Werneck', 'Masculino', 1);
INSERT INTO pessoa (id, celular, cpf, data_nasc, identidade, nome, sexo, endereco_id)
VALUES (2, '(22) 22222-2222', '222.222.222-22', '02/02/1990', '22.222.222-22', 'Maria Luiza', 'Feminino', 2);
INSERT INTO pessoa (id, celular, cpf, data_nasc, identidade, nome, sexo, endereco_id)
VALUES (3, '(33) 33333-3333', '333.333.333-33', '22/11/1990', '33.333.333-33', 'Amanda Inácio', 'Feminino', 3);
INSERT INTO pessoa (id, celular, cpf, data_nasc, identidade, nome, sexo, endereco_id)
VALUES (4, '(44) 44444-4444', '444.444.444-44', '22/11/1990', '44.444.444-44', 'Shaiana', 'Feminino', 4);
INSERT INTO pessoa (id, celular, cpf, data_nasc, identidade, nome, sexo, endereco_id)
VALUES (5, '(55) 55555-5555', '555.555.555-55', '01/01/2015', '55.555.555-55', 'Filha 01', 'Feminino', 5);
INSERT INTO pessoa (id, celular, cpf, data_nasc, identidade, nome, sexo, endereco_id)
VALUES (6, '(66) 66666-6666', '666.666.666-66', '01/01/2016', '66.666.666-66', 'Filho 01', 'Masculino', 6);

INSERT INTO usuario (id, email, senha, tipo_usuario, pessoa_id)
VALUES (1, 'rodrigo.werneck@id.uff.br', '123456', 2, 1);
<<<<<<< HEAD
=======

>>>>>>> master
INSERT INTO usuario (id, email, senha, tipo_usuario, pessoa_id)
VALUES (2, 'maria.luiza@id.uff.br', '123456', 0, 2);
INSERT INTO usuario (id, email, senha, tipo_usuario, pessoa_id)
VALUES (3, 'amanda.inacio@id.uff.br', '123456', 1, 3);
INSERT INTO usuario (id, email, senha, tipo_usuario, pessoa_id)
VALUES (4, 'shaiana.@id.uff.br', '123456', 1, 4);

INSERT INTO aluno (id, id_responsavel, naturalidade, nome_mae, nome_pai, pessoa_id)
VALUE (1, 1, 'Fluminense', 'Nome Mãe', 'Nome Pai', 5);
INSERT INTO aluno (id, id_responsavel, naturalidade, nome_mae, nome_pai, pessoa_id)
VALUE (2, 1, 'Fluminense', 'Nome Mãe', 'Nome Pai', 6);

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

INSERT INTO unidade_escolar (id, data, nome, num_vagas, endereco_id)
<<<<<<< HEAD
VALUES (1, '2020-12-2020', 'Unidade Escolar - ABC', 240, 7);
INSERT INTO unidade_escolar (id, data, nome, num_vagas, endereco_id)
VALUES (2, '2020-12-2020', 'Unidade Escolar - DFG', 310, 8);
=======
VALUES (1, '2020-12-2020', 'Unidade Escolar - ABC', 240, 4);

INSERT INTO unidade_escolar (id, data, nome, num_vagas, endereco_id)
VALUES (2, '2020-12-2020', 'Unidade Escolar - DFG', 310, 5);
>>>>>>> master

INSERT INTO unidade_escolar_ano_escolaridade (unidade_escolar_id, ano_escolaridade_id)
VALUES (1, 1);
INSERT INTO unidade_escolar_ano_escolaridade (unidade_escolar_id, ano_escolaridade_id)
VALUES (1, 2);
INSERT INTO unidade_escolar_ano_escolaridade (unidade_escolar_id, ano_escolaridade_id)
VALUES (1, 3);
INSERT INTO unidade_escolar_ano_escolaridade (unidade_escolar_id, ano_escolaridade_id)
VALUES (1, 7);
<<<<<<< HEAD
=======

INSERT INTO unidade_escolar_ano_escolaridade (unidade_escolar_id, ano_escolaridade_id)
VALUES (2, 4);
INSERT INTO unidade_escolar_ano_escolaridade (unidade_escolar_id, ano_escolaridade_id)
VALUES (2, 6);
INSERT INTO unidade_escolar_ano_escolaridade (unidade_escolar_id, ano_escolaridade_id)
VALUES (2, 7);
INSERT INTO unidade_escolar_ano_escolaridade (unidade_escolar_id, ano_escolaridade_id)
VALUES (2, 9);
>>>>>>> master



