CREATE TABLE client (
	id BIGINT auto_increment NOT NULL,
	email varchar(200) NOT NULL UNIQUE,
	complete_name varchar(300) NOT NULL,
	abrev_name varchar(300) NOT NULL,
	birthday DATE NOT NULL,
	cpf_cnpj varchar(11) NOT NULL UNIQUE,
	password varchar(100) NOT NULL,
	CONSTRAINT client_PK PRIMARY KEY (id)
)
