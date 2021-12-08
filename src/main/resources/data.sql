insert into empresa(id,nome,cnpj) 
values (1,'Prefeitura Municipal de São Paulo','123.456.789/0001-23');

insert into empresa(id,nome,cnpj) 
values (2,'VR Benefícios','789.456.123/0001-34');

insert into empresa(id,nome,cnpj) 
values (3,'Casas Bahia','456.123.789/0001-56');

insert into cartao(id,nome,sigla) 
values (1,'Vale Alimentação','VA');

insert into cartao(id,nome,sigla) 
values (2,'Vale refeição','VR');

insert into cartao(id,nome,sigla) 
values (3,'Vale Combustível','VG');

insert into cartao(id,nome,sigla) 
values (4,'Vale Cultura','VC');

insert into empregado(id,cpf,nome,empresa_id)
values (123,'123.456.789-00','José da Silva',1);

insert into empregado(id,cpf,nome,empresa_id)
values (456,'456.789.012-00','Carmelina Procopio',1);

insert into empregado(id,cpf,nome,empresa_id)
values (78,'789.123.456-00','Rodolfo Rodrigues',2);

insert into empregado(id,cpf,nome,empresa_id)
values (90,'135.791.357-00','Tercio de Sá',3);