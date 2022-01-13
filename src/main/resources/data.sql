

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

-- Mini
INSERT INTO brand (id,brand) VALUES (7, 'Mini');
    INSERT INTO model (id,model,brand_id) VALUES (31,'Cooper',7);

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
Values (1,'Audi A1 TFSI SPORT' ,2013, 'PRETO', 'FLEX', 'AUTOMATICO', 'SEDAN', true, 100378,
 'x', 77799, false, 1, 1);

 INSERT INTO car (id,car_name, car_age, car_color, car_fuel, car_transmission, car_type, car_ipva, car_km, car_photo, car_price, car_reserved, brand_id, model_id)
 Values (2,'AUDI A3 TFSI SEDAN AMBITION', 2015, 'PRETO', 'FLEX', 'AUTOMATICO', 'SEDAN', true, 104865,
  '', 97799, false, 1, 2);

 INSERT INTO car (id,car_name, car_age, car_color, car_fuel, car_transmission, car_type, car_ipva, car_km, car_photo, car_price, car_reserved, brand_id, model_id)
 Values (3,'AUDI A4 TFSI SEDAN PRESTIGE PLUS', 2019, 'PRETO', 'FLEX', 'AUTOMATICO', 'SEDAN', true, 38400,
  '', 214799, false, 1, 3);

 INSERT INTO car (id,car_name, car_age, car_color, car_fuel, car_transmission, car_type, car_ipva, car_km, car_photo, car_price, car_reserved, brand_id, model_id)
 Values (4,'AUDI A5 TFSI SPORTBACK PRESTIGE', 2019, 'BRANCO', 'FLEX', 'AUTOMATICO', 'SEDAN', false, 16707,
  '', 255999, true, 1, 4);

INSERT INTO car (id,car_name, car_age, car_color, car_fuel, car_transmission, car_type, car_ipva, car_km, car_photo, car_price, car_reserved, brand_id, model_id)
Values (5,'AUDI Q3 TFSI AMBIENTE' ,2018, 'CINZA', 'FLEX', 'AUTOMATICO', 'SUV', true, 71581,
 'x', 121799, true, 1, 5);

 INSERT INTO car (id,car_name, car_age, car_color, car_fuel, car_transmission, car_type, car_ipva, car_km, car_photo, car_price, car_reserved, brand_id, model_id)
 Values (6,'AUDI Q5 TFSI PRESTIGE PLUS' ,2019, 'PRETO', 'FLEX', 'AUTOMATICO', 'SUV', true, 37361,
  'x', 30999, false, 1, 6);

 INSERT INTO car (id,car_name, car_age, car_color, car_fuel, car_transmission, car_type, car_ipva, car_km, car_photo, car_price, car_reserved, brand_id, model_id)
 Values (7,'AUDI Q7 TFSI QUATTRO V6' ,2014, 'BRANCO', 'FLEX', 'AUTOMATICO', 'SUV', true, 96500,
  'x', 185799, false, 1, 7);

-- BMW

 INSERT INTO car (id,car_name, car_age, car_color, car_fuel, car_transmission, car_type, car_ipva, car_km, car_photo, car_price, car_reserved, brand_id, model_id)
 Values (8, 'BMW 116i TURBO',2019, 'VERMELHO', 'FLEX', 'AUTOMATICO', 'SEDAN', true, 25100,
  '', 295000, false, 2, 8);

  INSERT INTO car (id,car_name, car_age, car_color, car_fuel, car_transmission, car_type, car_ipva, car_km, car_photo, car_price, car_reserved, brand_id, model_id)
  Values (9, 'BMW 118i SPORT GP',2020, 'BRANCO', 'FLEX', 'AUTOMATICO', 'HATCHBACK', true, 10940,
   '', 206799, false, 2, 9);

 INSERT INTO car (id,car_name, car_age, car_color, car_fuel, car_transmission, car_type, car_ipva, car_km, car_photo, car_price, car_reserved, brand_id, model_id)
 Values (10, 'BMW 318i SPORT',2019, 'CINZA', 'FLEX', 'AUTOMATICO', 'SEDAN', false, 90161,
  '', 66799, true, 2, 10);

  INSERT INTO car (id,car_name, car_age, car_color, car_fuel, car_transmission, car_type, car_ipva, car_km, car_photo, car_price, car_reserved, brand_id, model_id)
  Values (11, 'BMW 330I TURBO SPORT',2020, 'BRANCO', 'FLEX', 'AUTOMATICO', 'SEDAN', true, 39748,
  '', 289299, true, 2, 11);

   INSERT INTO car (id,car_name, car_age, car_color, car_fuel, car_transmission, car_type, car_ipva, car_km, car_photo, car_price, car_reserved, brand_id, model_id)
   Values (12, 'BMW X1 TRUBO ACTIVE SDRIVE20l',2019, 'PRETO', 'FLEX', 'AUTOMATICO', 'SUV', true, 57598,
    '', 181299, false, 2, 12);

    INSERT INTO car (id,car_name, car_age, car_color, car_fuel, car_transmission, car_type, car_ipva, car_km, car_photo, car_price, car_reserved, brand_id, model_id)
    Values (13, 'BMW X5 30D l6 TURBO',2020, 'PRETO', 'FLEX', 'AUTOMATICO', 'SUV', true, 87922,
     '', 273999, false, 2, 13);

    INSERT INTO car (id,car_name, car_age, car_color, car_fuel, car_transmission, car_type, car_ipva, car_km, car_photo, car_price, car_reserved, brand_id, model_id)
    Values (14, 'BMW X6 M COUPE V8 BI-TURBO',2014, 'BRANCO', 'FLEX', 'AUTOMATICO', 'SUV', true, 73800,
     '', 234999, false, 2, 14);

-- Chery

   INSERT INTO car (id,car_name, car_age, car_color, car_fuel, car_transmission, car_type, car_ipva, car_km, car_photo, car_price, car_reserved, brand_id, model_id)
    Values (15, 'CHERY ARRIZO 5 VVT TURBO i RXT',2019, 'PRETO', 'FLEX', 'AUTOMATICO', 'SEDAN', true, 25244,
     '', 75499, false, 3, 15);

    INSERT INTO car (id,car_name, car_age, car_color, car_fuel, car_transmission, car_type, car_ipva, car_km, car_photo, car_price, car_reserved, brand_id, model_id)
     Values (16, 'CHERY CELER MPFI',2015, 'AMARELO', 'FLEX', 'MANUAL', 'HATCHBACK', false, 89350,
      '', 38000, true, 3, 16);

    INSERT INTO car (id,car_name, car_age, car_color, car_fuel, car_transmission, car_type, car_ipva, car_km, car_photo, car_price, car_reserved, brand_id, model_id)
    Values (17, 'CHERY QQ MPFI ACT',2018, 'BRANCO', 'GASOLINA', 'MANUAL', 'HATCHBACK', true, 56849,
     '', 32999, false, 3, 17);

    INSERT INTO car (id,car_name, car_age, car_color, car_fuel, car_transmission, car_type, car_ipva, car_km, car_photo, car_price, car_reserved, brand_id, model_id)
       Values (18, 'CHERY TIGGO 5x VVT TURBO i TXS DCT',2019, 'CINZA', 'FLEX', 'MANUAL', 'SUV', true, 19545,
        '', 105999, true, 3, 18);


-- Chevrolet


-- Citroen


-- Dodge
   INSERT INTO car (id,car_name, car_age, car_color, car_fuel, car_transmission, car_type, car_ipva, car_km, car_photo, car_price, car_reserved, brand_id, model_id)
    Values (29, 'CITROEN JUMPY BLUEHDI MINIBUS',2020, 'BRANCO', 'GASOLINA', 'MANUAL', 'VAN', true, 15320,
     '', 151799, false, 6, 29);

    INSERT INTO car (id,car_name, car_age, car_color, car_fuel, car_transmission, car_type, car_ipva, car_km, car_photo, car_price, car_reserved, brand_id, model_id)
       Values (30, 'DODGE RAM 2500 LARAMIE',2012, 'CINZA', 'FLEX', 'AUTOMATICO', 'PICKUP', true, 87500,
        '', 224799, false, 6, 30);

-- Jaguar
      INSERT INTO car (id,car_name, car_age, car_color, car_fuel, car_transmission, car_type, car_ipva, car_km, car_photo, car_price, car_reserved, brand_id, model_id)
           Values (31, 'MINI COOPER TWINPOWER S',2020, 'AZUL', 'FLEX', 'AUTOMATICO', 'HATCHBACK', true, 209799,
            '', 209799, false, 7, 31);

-- Volvo



