CREATE TABLE address (
  id bigint NOT NULL AUTO_INCREMENT,
  zip_code varchar(8) NOT NULL,
  street_address varchar(500) NOT NULL,
  street_number varchar(50) NOT NULL,
  complement varchar(200) DEFAULT NULL,
  district varchar(200) NOT NULL,
  city varchar(100) NOT NULL,
  state varchar(100) NOT NULL,
  country varchar(100) DEFAULT NULL,
  client_id bigint NOT NULL,
  PRIMARY KEY (id),
  KEY client_id_FK (client_id),
  CONSTRAINT client_id_FK FOREIGN KEY (client_id) REFERENCES client (id) ON DELETE CASCADE ON UPDATE CASCADE)