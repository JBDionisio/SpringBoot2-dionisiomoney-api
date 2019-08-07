CREATE TABLE person (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(50) NOT NULL,
	active BOOLEAN NOT NULL,
	street VARCHAR(60),
	number VARCHAR(20),
	adjunct VARCHAR(50),
	neighborhood VARCHAR(40),
	zip_code VARCHAR(30),
	city VARCHAR(40),
	state VARCHAR(40)
) ENGINE=InnoDB DEFAULT CHARSET=utf8; 

INSERT INTO person (name, active, street, number, adjunct, neighborhood, zip_code, city, state) VALUES ('João Batista', true, 'Rua Sebastião', '49', 'Condominio Portal', 'Jardim Eledy', '05856-140', 'São Paulo', 'SP');
INSERT INTO person (name, active, street, number, adjunct, neighborhood, zip_code, city, state) VALUES ('Maria ria', true, 'Rua Advincula', '30', null, 'Jardim das Rosas', '04038-140', 'São Paulo', 'SP');
INSERT INTO person (name, active, street, number, adjunct, neighborhood, zip_code, city, state) VALUES ('Pedro Santos', true, 'Rua do Sabiá', '12', null, 'Morumbi', '03876-140', 'São Paulo', 'SP');
INSERT INTO person (name, active, street, number, adjunct, neighborhood, zip_code, city, state) VALUES ('Ricardo Pereira', true, 'Rua Teixeira', '45', 'Em cima da igreja', 'Opua', '03879-140', 'Maracuja', 'MG');
INSERT INTO person (name, active, street, number, adjunct, neighborhood, zip_code, city, state) VALUES ('Pedro Barbosa', true, 'Rua Yuke', '5', null, 'Toupeira', '09579-300', 'São Bernado', 'SP');
INSERT INTO person (name, active, street, number, adjunct, neighborhood, zip_code, city, state) VALUES ('Isabela Martins', true, 'Rua das Timparas', '25', 'Na esquina', 'Jardim Hip', '09549-300', 'Natal', 'RN');

