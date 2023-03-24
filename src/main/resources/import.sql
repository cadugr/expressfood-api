insert into cozinha (id, nome) values (1, 'Tailandesa');
insert into cozinha (id, nome) values (2, 'Indiana');

insert into restaurante (id, nome, taxa_frete, cozinha_id) values (1,'Nam Thai', 7, 1);
insert into restaurante (id, nome, taxa_frete, cozinha_id) values (2,'Càm Om', 8.5, 1);
insert into restaurante (id, nome, taxa_frete, cozinha_id) values (3,'Govinda', 5, 2);
insert into restaurante (id, nome, taxa_frete, cozinha_id) values (4,'Govardhana Hari', 11, 2);

insert into forma_pagamento (id, descricao) values (1, 'Cartão de crédito');
insert into forma_pagamento (id, descricao) values (2, 'Cartão de débito');
insert into forma_pagamento (id, descricao) values (3, 'Dinheiro');
insert into forma_pagamento (id, descricao) values (4, 'Pix');

insert into estado (id, nome) values (1, 'Rio de Janeiro');
insert into estado (id, nome) values (2, 'São Paulo');
insert into estado (id, nome) values (3, 'Minas Gerais');

insert into cidade (id, nome, estado_id) values (1, 'Niterói', 1);
insert into cidade (id, nome, estado_id) values (2, 'Volta Redonda', 1);
insert into cidade (id, nome, estado_id) values (3, 'São José dos Campos', 2);
insert into cidade (id, nome, estado_id) values (4, 'Itú', 2);
insert into cidade (id, nome, estado_id) values (5, 'Belo Horizonte', 3);
insert into cidade (id, nome, estado_id) values (6, 'Ipatinga', 3);

insert into permissao (id, nome, descricao) values (1, 'CONSULTAR_COZINHAS', 'Permite consultar cozinhas');
insert into permissao (id, nome, descricao) values (2, 'EDITAR_COZINHAS', 'Permite editar cozinhas');

