insert into cozinha (id, nome) values (1, 'Tailandesa');
insert into cozinha (id, nome) values (2, 'Indiana');

insert into estado (id, nome) values (1, 'Rio de Janeiro');
insert into estado (id, nome) values (2, 'São Paulo');
insert into estado (id, nome) values (3, 'Minas Gerais');

insert into cidade (id, nome, estado_id) values (1, 'Rio de Janeiro', 1);
insert into cidade (id, nome, estado_id) values (2, 'Volta Redonda', 1);
insert into cidade (id, nome, estado_id) values (3, 'São José dos Campos', 2);
insert into cidade (id, nome, estado_id) values (4, 'Itú', 2);
insert into cidade (id, nome, estado_id) values (5, 'Belo Horizonte', 3);
insert into cidade (id, nome, estado_id) values (6, 'Ipatinga', 3);

insert into restaurante (id, endereco_cep, endereco_logradouro, endereco_numero, endereco_complemento, endereco_bairro, endereco_cidade_id, nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao) values (1, '22441120', 'Rua Rainha Guilhermina', '95', 'LOJA B', 'Leblon', 1, 'Nam Thai', 7, 1, utc_timestamp, utc_timestamp);
insert into restaurante (id, nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao) values (2,'Càm Om', 8.5, 1, utc_timestamp, utc_timestamp);
insert into restaurante (id, nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao) values (3,'Govinda', 5, 2, utc_timestamp, utc_timestamp);
insert into restaurante (id, nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao) values (4,'Govardhana Hari', 11, 2, utc_timestamp, utc_timestamp);

insert into produto (id, ativo, descricao, nome, preco, restaurante_id) values (1, 1, 'Salada picante de camarões, papaia e manga | Médio picante', 'Yam Kung Mammuang', 47, 1);
insert into produto (id, ativo, descricao, nome, preco, restaurante_id) values (2, 1, 'Camarões com abacaxí, curry vermelho tailandês e leite de coco', 'Gaeng Kua Sapparod', 94, 1);

insert into forma_pagamento (id, descricao) values (1, 'Cartão de crédito');
insert into forma_pagamento (id, descricao) values (2, 'Cartão de débito');
insert into forma_pagamento (id, descricao) values (3, 'Dinheiro');
insert into forma_pagamento (id, descricao) values (4, 'Pix');


insert into permissao (id, nome, descricao) values (1, 'CONSULTAR_COZINHAS', 'Permite consultar cozinhas');
insert into permissao (id, nome, descricao) values (2, 'EDITAR_COZINHAS', 'Permite editar cozinhas');

insert into restaurante_forma_pagamento (restaurante_id, forma_pagamento_id) values (1, 1), (1, 2), (1, 3), (2, 3), (3, 2), (3, 3), (4,4), (4,2);

