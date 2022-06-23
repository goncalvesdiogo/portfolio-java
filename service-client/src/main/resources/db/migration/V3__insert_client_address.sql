INSERT INTO portfolio_db.client(id, email, complete_name, abrev_name, birthday, cpf_cnpj, password)
VALUES(1, 'test@test.com', 'This is The Complete Name', 'This Name', '2022-05-01', '70746245009', 'pass123');

INSERT INTO portfolio_db.address
( zip_code, street_address, street_number, complement, district, city, state, country, client_id)
VALUES('15997025', 'Teste Endereco', '1324' , NULL, 'BAIRRO', 'CIDADE', 'ESTADO', 'PAIS', 1);

INSERT INTO portfolio_db.address
( zip_code, street_address, street_number, complement, district, city, state, country, client_id)
VALUES('15997025', 'Teste Endereco2', '222' , 'COMPLEMENTO', 'BAIRRO2', 'CIDADE2', 'ESTADO2', 'PAIS2', 1);
