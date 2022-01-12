

-- AUDI
INSERT INTO brand (id,brand) VALUES (1, 'Audi');
	INSERT INTO model (id,model,brand_id) VALUES (1,'A1',1);
	INSERT INTO model (id,model,brand_id) VALUES (2,'A3',1);
	INSERT INTO model (id,model,brand_id) VALUES (3,'A4',1);
	INSERT INTO model (id,model,brand_id) VALUES (4,'A5',1);
	INSERT INTO model (id,model,brand_id) VALUES (5,'Q3',1);
	INSERT INTO model (id,model,brand_id) VALUES (6,'Q5',1);
	INSERT INTO model (id,model,brand_id) VALUES (7,'Q7',1);
-- BMW
INSERT INTO brand (id,brand) VALUES (2, 'Bmw');
    INSERT INTO model (id,model,brand_id) VALUES (8,'116i',2);
    INSERT INTO model (id,model,brand_id) VALUES (9,'118i',2);
    INSERT INTO model (id,model,brand_id) VALUES (10,'318i',2);
    INSERT INTO model (id,model,brand_id) VALUES (11,'330i',2);
    INSERT INTO model (id,model,brand_id) VALUES (12,'X1',2);
    INSERT INTO model (id,model,brand_id) VALUES (13,'X5',2);
    INSERT INTO model (id,model,brand_id) VALUES (14,'X6',2);


-- Chery
INSERT INTO brand (id,brand) VALUES (3, 'Chery');
    INSERT INTO model (id,model,brand_id) VALUES (15,'Arrizo 5',3);
    INSERT INTO model (id,model,brand_id) VALUES (16,'Celer',3);
    INSERT INTO model (id,model,brand_id) VALUES (17,'QQ',3);
    INSERT INTO model (id,model,brand_id) VALUES (18,'Tiggo 5x',3);

-- Chevrolet
INSERT INTO brand (id,brand) VALUES (4, 'Chevrolet');
    INSERT INTO model (id,model,brand_id) VALUES (19,'Corsa',4);
    INSERT INTO model (id,model,brand_id) VALUES (20,'Meriva',4);
    INSERT INTO model (id,model,brand_id) VALUES (21,'Onix',4);
    INSERT INTO model (id,model,brand_id) VALUES (22,'Prisma',4);
    INSERT INTO model (id,model,brand_id) VALUES (23,'Vectra',4);

-- Citroen
INSERT INTO brand (id,brand) VALUES (5, 'Citroen');
    INSERT INTO model (id,model,brand_id) VALUES (24,'C3',5);
    INSERT INTO model (id,model,brand_id) VALUES (25,'C4',5);
    INSERT INTO model (id,model,brand_id) VALUES (26,'Jumpy',5);
    INSERT INTO model (id,model,brand_id) VALUES (27,'Xsara Picasso',5);
    INSERT INTO model (id,model,brand_id) VALUES (28,'Aircross',5);

-- Dodge
INSERT INTO brand (id,brand) VALUES (6, 'Dodge');
    INSERT INTO model (id,model,brand_id) VALUES (29,'Journey',6);
    INSERT INTO model (id,model,brand_id) VALUES (30,'Ram',6);

-- Jaguar
INSERT INTO brand (id,brand) VALUES (7, 'Jaguar');
    INSERT INTO model (id,model,brand_id) VALUES (31,'XF',7);

-- Nissan
INSERT INTO brand (id,brand) VALUES (8, 'Volvo');
    INSERT INTO model (id,model,brand_id) VALUES (32,'Frontier',8);
    INSERT INTO model (id,model,brand_id) VALUES (33,'Livina',8);
    INSERT INTO model (id,model,brand_id) VALUES (34,'Versa',8);
    INSERT INTO model (id,model,brand_id) VALUES (35,'Sentra',8);
    INSERT INTO model (id,model,brand_id) VALUES (36,'March',8);


-- ROLES
INSERT INTO Usuario (id,user_login, user_password, user_token) values(1,'admin', '$2a$10$tk3To364TGUZRs59ArZVfOW/WZTScRu5KCseMQB2IAFApMtVaC.cC', '');

INSERT INTO roles (id, nome_role) VALUES (1, 'ROLE_ADMIN');
INSERT INTO roles (id, nome_role) VALUES (2, 'ROLE_USER');

INSERT INTO Usuarios_role (usuario_id, role_id) values(1, 1);

-- Carros

-- Audi
INSERT INTO car (id,car_name, car_age, car_color, car_fuel, car_transmission, car_type, car_ipva, car_km, car_photo, car_price, car_reserved, brand_id, model_id)
Values (1,'Audi Q3 TFSI AMBIENTE' ,2018, 'BRANCO', 'FLEX', 'AUTOMATICO', 'SEDAN', true, 71581,
 'https://s3.ecompletocarros.dev/images/lojas/103/veiculos/35898/veiculoInfoVeiculoImagesMobile/vehicle_image_1599262418_a1559fe1ef60e4473f5b2791f5125e7b.jpeg', 121799, false, 1, 5);

INSERT INTO car (id,car_name, car_age, car_color, car_fuel, car_transmission, car_type, car_ipva, car_km, car_photo, car_price, car_reserved, brand_id, model_id)
Values (2,'Audi A1 TFSI SPORT' ,2013, 'PRETO', 'FLEX', 'AUTOMATICO', 'SEDAN', true, 97616,
 'https://i.ytimg.com/vi/9C3eidGTIAI/maxresdefault.jpg', 80499, false, 1, 1);

 INSERT INTO car (id,car_name, car_age, car_color, car_fuel, car_transmission, car_type, car_ipva, car_km, car_photo, car_price, car_reserved, brand_id, model_id)
 Values (3,'Audi A3 TFSI SEDAN', 2015, 'CINZA', 'FLEX', 'AUTOMATICO', 'SEDAN', true, 59000,
  'https://cdn.motor1.com/images/mgl/KV8yG/s1/audi-a3-sedan-comeca-a-ser-produzido-no-brasil.jpg', 101799, false, 1, 2);

-- BMW
 INSERT INTO car (id,car_name, car_age, car_color, car_fuel, car_transmission, car_type, car_ipva, car_km, car_photo, car_price, car_reserved, brand_id, model_id)
 Values (4, 'BMW X1 TURBO ACTIVE SDRIVE20l',2019, 'BRANCO', 'FLEX', 'AUTOMATICO', 'SUV', true, 53700,
  'https://s3.ecompletocarros.dev/images/lojas/164/veiculos/30143/veiculoInfoVeiculoImagesMobile/vehicle_image_1594846610_63c85d8fea3a65f4a0888e30607c53a7.jpeg', 200999, false, 2, 12);







