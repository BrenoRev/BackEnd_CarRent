-- AUDI --

INSERT INTO
    brand (id, brand)
VALUES
    (1, 'Audi');

INSERT INTO
    model (id, model, brand_id)
VALUES
    (1, 'A1', 1);

INSERT INTO
    model (id, model, brand_id)
VALUES
    (2, 'A3', 1);

INSERT INTO
    model (id, model, brand_id)
VALUES
    (3, 'A4', 1);

INSERT INTO
    model (id, model, brand_id)
VALUES
    (4, 'A5', 1);

INSERT INTO
    model (id, model, brand_id)
VALUES
    (5, 'Q3', 1);

INSERT INTO
    model (id, model, brand_id)
VALUES
    (6, 'Q5', 1);

INSERT INTO
    model (id, model, brand_id)
VALUES
    (7, 'Q7', 1);

-- BMW--

INSERT INTO
    brand (id, brand)
VALUES
    (2, 'Bmw');

INSERT INTO
    model (id, model, brand_id)
VALUES
    (9, '118i', 2);

INSERT INTO
    model (id, model, brand_id)
VALUES
    (10, '328i', 2);

INSERT INTO
    model (id, model, brand_id)
VALUES
    (11, '330i', 2);

INSERT INTO
    model (id, model, brand_id)
VALUES
    (12, 'X1', 2);

INSERT INTO
    model (id, model, brand_id)
VALUES
    (8, 'X3', 2);

INSERT INTO
    model (id, model, brand_id)
VALUES
    (13, 'X5', 2);

INSERT INTO
    model (id, model, brand_id)
VALUES
    (14, 'X6', 2);

-- Chery --

INSERT INTO
    brand (id, brand)
VALUES
    (3, 'Chery');

INSERT INTO
    model (id, model, brand_id)
VALUES
    (15, 'Arrizo 5', 3);

INSERT INTO
    model (id, model, brand_id)
VALUES
    (16, 'Tiggo 2', 3);

INSERT INTO
    model (id, model, brand_id)
VALUES
    (17, 'QQ', 3);

INSERT INTO
    model (id, model, brand_id)
VALUES
    (18, 'Tiggo 5x', 3);

-- Chevrolet --

INSERT INTO
    brand (id, brand)
VALUES
    (4, 'Chevrolet');

INSERT INTO
    model (id, model, brand_id)
VALUES
    (19, 'Corsa', 4);

INSERT INTO
    model (id, model, brand_id)
VALUES
    (20, 'Meriva', 4);

INSERT INTO
    model (id, model, brand_id)
VALUES
    (21, 'Onix', 4);

INSERT INTO
    model (id, model, brand_id)
VALUES
    (22, 'Prisma', 4);

INSERT INTO
    model (id, model, brand_id)
VALUES
    (23, 'Vectra', 4);

-- Citroen --

INSERT INTO
    brand (id, brand)
VALUES
    (5, 'Citroen');

INSERT INTO
    model (id, model, brand_id)
VALUES
    (24, 'C3', 5);

INSERT INTO
    model (id, model, brand_id)
VALUES
    (25, 'C4', 5);

INSERT INTO
    model (id, model, brand_id)
VALUES
    (26, 'C4 Lounge', 5);

INSERT INTO
    model (id, model, brand_id)
VALUES
    (27, 'Xsara Picasso', 5);

INSERT INTO
    model (id, model, brand_id)
VALUES
    (28, 'Aircross', 5);

-- Dodge --

INSERT INTO
    brand (id, brand)
VALUES
    (6, 'Dodge');

INSERT INTO
    model (id, model, brand_id)
VALUES
    (29, 'Journey', 6);

INSERT INTO
    model (id, model, brand_id)
VALUES
    (30, 'Ram', 6);

-- Mini --

INSERT INTO
    brand (id, brand)
VALUES
    (7, 'Mini');

INSERT INTO
    model (id, model, brand_id)
VALUES
    (31, 'Cooper', 7);

-- Nissan --

INSERT INTO
    brand (id, brand)
VALUES
    (8, 'Nissan');

INSERT INTO
    model (id, model, brand_id)
VALUES
    (32, 'Frontier', 8);

INSERT INTO
    model (id, model, brand_id)
VALUES
    (33, 'Livina', 8);

INSERT INTO
    model (id, model, brand_id)
VALUES
    (34, 'Versa', 8);

INSERT INTO
    model (id, model, brand_id)
VALUES
    (35, 'Sentra', 8);

INSERT INTO
    model (id, model, brand_id)
VALUES
    (36, 'March', 8);

-- ROLES --

INSERT INTO
    Usuario (id, user_login, user_password, user_token)
values
(
        1,
        'admin',
        '$2a$10$tk3To364TGUZRs59ArZVfOW/WZTScRu5KCseMQB2IAFApMtVaC.cC',
        'https://s1.1zoom.me/b5349/962/KIA_Rio_Light_Blue_White_background_526267_2560x1440.jpg'
    );

INSERT INTO
    roles (id, nome_role)
VALUES
    (1, 'ROLE_ADMIN');

INSERT INTO
    roles (id, nome_role)
VALUES
    (2, 'ROLE_USER');

INSERT INTO
    Usuarios_role (usuario_id, role_id)
values
(1, 1);

-- Carros --

-- Audi
INSERT INTO
    car (
        id,
        car_name,
        car_age,
        car_color,
        car_fuel,
        car_transmission,
        car_type,
        car_ipva,
        car_km,
        car_photo,
        car_price,
        car_reserved,
        brand_id,
        model_id
    )
Values
    (
        1,
        'TFSI SPORTBACK',
        2013,
        'PRETO',
        'FLEX',
        'AUTOMATICO',
        'SEDAN',
        true,
        100378,
        'https://images.kavak.services/images/116310/EXTERIOR-frontSidePilotNear-16331060767933.jpg',
        77799,
        false,
        1,
        1
    );

INSERT INTO
    car (
        id,
        car_name,
        car_age,
        car_color,
        car_fuel,
        car_transmission,
        car_type,
        car_ipva,
        car_km,
        car_photo,
        car_price,
        car_reserved,
        brand_id,
        model_id
    )
Values
    (
        2,
        'TFSI SEDAN AMBITION',
        2015,
        'PRETO',
        'FLEX',
        'AUTOMATICO',
        'SEDAN',
        true,
        104865,
        'https://images.kavak.services/images/153344/EXTERIOR-frontSidePilotNear-1641749422035.jpeg',
        97799,
        false,
        1,
        2
    );

INSERT INTO
    car (
        id,
        car_name,
        car_age,
        car_color,
        car_fuel,
        car_transmission,
        car_type,
        car_ipva,
        car_km,
        car_photo,
        car_price,
        car_reserved,
        brand_id,
        model_id
    )
Values
    (
        3,
        'TFSI PRESTIGE PLUS',
        2019,
        'PRETO',
        'FLEX',
        'AUTOMATICO',
        'SEDAN',
        true,
        38400,
        'https://images.kavak.services/images/144213/EXTERIOR-frontSidePilotNear-1641601904788.jpeg',
        214799,
        false,
        1,
        3
    );

INSERT INTO
    car (
        id,
        car_name,
        car_age,
        car_color,
        car_fuel,
        car_transmission,
        car_type,
        car_ipva,
        car_km,
        car_photo,
        car_price,
        car_reserved,
        brand_id,
        model_id
    )
Values
    (
        4,
        'TFSI SPORTBACK PRESTIGE',
        2019,
        'BRANCO',
        'FLEX',
        'AUTOMATICO',
        'SEDAN',
        false,
        16707,
        'https://images.kavak.services/images/126030/EXTERIOR-frontSidePilotNear-16350284636798.jpg',
        255999,
        true,
        1,
        4
    );

INSERT INTO
    car (
        id,
        car_name,
        car_age,
        car_color,
        car_fuel,
        car_transmission,
        car_type,
        car_ipva,
        car_km,
        car_photo,
        car_price,
        car_reserved,
        brand_id,
        model_id
    )
Values
    (
        5,
        'TFSI AMBIENTE',
        2018,
        'CINZA',
        'FLEX',
        'AUTOMATICO',
        'SUV',
        true,
        71581,
        'https://images.kavak.services/images/156622/EXTERIOR-frontSidePilotNear-1641617231142.jpeg',
        121799,
        true,
        1,
        5
    );

INSERT INTO
    car (
        id,
        car_name,
        car_age,
        car_color,
        car_fuel,
        car_transmission,
        car_type,
        car_ipva,
        car_km,
        car_photo,
        car_price,
        car_reserved,
        brand_id,
        model_id
    )
Values
    (
        6,
        'TFSI PRESTIGE PLUS',
        2019,
        'PRETO',
        'FLEX',
        'AUTOMATICO',
        'SUV',
        true,
        37361,
        'https://images.kavak.services/images/125427/EXTERIOR-frontSidePilotNear-16349252367380.jpg',
        30999,
        false,
        1,
        6
    );

INSERT INTO
    car (
        id,
        car_name,
        car_age,
        car_color,
        car_fuel,
        car_transmission,
        car_type,
        car_ipva,
        car_km,
        car_photo,
        car_price,
        car_reserved,
        brand_id,
        model_id
    )
Values
    (
        7,
        'TFSI QUATTRO V6',
        2014,
        'BRANCO',
        'FLEX',
        'AUTOMATICO',
        'SUV',
        true,
        96500,
        'https://images.kavak.services/images/100744/q7-audi-tfsi-quattro-v6-2014-exterior-frontsidepilotnear-16203044284108.jpg',
        185799,
        false,
        1,
        7
    );

-- BMW
INSERT INTO
    car (
        id,
        car_name,
        car_age,
        car_color,
        car_fuel,
        car_transmission,
        car_type,
        car_ipva,
        car_km,
        car_photo,
        car_price,
        car_reserved,
        brand_id,
        model_id
    )
Values
    (
        8,
        'TWINPOWER M40l',
        2018,
        'PRETO',
        'FLEX',
        'AUTOMATICO',
        'SUV',
        true,
        69625,
        'https://images.kavak.services/images/125498/EXTERIOR-frontSidePilotNear-16348573226177.jpg',
        368999,
        false,
        2,
        8
    );

INSERT INTO
    car (
        id,
        car_name,
        car_age,
        car_color,
        car_fuel,
        car_transmission,
        car_type,
        car_ipva,
        car_km,
        car_photo,
        car_price,
        car_reserved,
        brand_id,
        model_id
    )
Values
    (
        9,
        'SPORT GP',
        2020,
        'BRANCO',
        'FLEX',
        'AUTOMATICO',
        'HATCHBACK',
        true,
        10940,
        'https://images.kavak.services/images/105145/118i-bmw-sport-gp-2020-exterior-frontsidepilotnear-16240199773191.jpg',
        206799,
        false,
        2,
        9
    );

INSERT INTO
    car (
        id,
        car_name,
        car_age,
        car_color,
        car_fuel,
        car_transmission,
        car_type,
        car_ipva,
        car_km,
        car_photo,
        car_price,
        car_reserved,
        brand_id,
        model_id
    )
Values
    (
        10,
        'SPORT GP ACTIVE',
        2017,
        'PRETO',
        'FLEX',
        'AUTOMATICO',
        'SEDAN',
        false,
        45866,
        'https://images.kavak.services/images/125408/EXTERIOR-frontSidePilotNear-16358572754696.jpg',
        175499,
        true,
        2,
        10
    );

INSERT INTO
    car (
        id,
        car_name,
        car_age,
        car_color,
        car_fuel,
        car_transmission,
        car_type,
        car_ipva,
        car_km,
        car_photo,
        car_price,
        car_reserved,
        brand_id,
        model_id
    )
Values
    (
        11,
        'TURBO SPORT',
        2020,
        'BRANCO',
        'FLEX',
        'AUTOMATICO',
        'SEDAN',
        true,
        39748,
        'https://images.kavak.services/images/128009/EXTERIOR-frontSidePilotNear-16355508660160.jpg',
        289299,
        true,
        2,
        11
    );

INSERT INTO
    car (
        id,
        car_name,
        car_age,
        car_color,
        car_fuel,
        car_transmission,
        car_type,
        car_ipva,
        car_km,
        car_photo,
        car_price,
        car_reserved,
        brand_id,
        model_id
    )
Values
    (
        12,
        'TRUBO ACTIVE SDRIVE20l',
        2019,
        'PRETO',
        'FLEX',
        'AUTOMATICO',
        'SUV',
        true,
        57598,
        'https://images.kavak.services/images/145658/EXTERIOR-frontSidePilotNear-1639609349454.jpeg',
        181299,
        false,
        2,
        12
    );

INSERT INTO
    car (
        id,
        car_name,
        car_age,
        car_color,
        car_fuel,
        car_transmission,
        car_type,
        car_ipva,
        car_km,
        car_photo,
        car_price,
        car_reserved,
        brand_id,
        model_id
    )
Values
    (
        13,
        '30D l6 TURBO',
        2020,
        'PRETO',
        'FLEX',
        'AUTOMATICO',
        'SUV',
        true,
        87922,
        'https://images.kavak.services/images/126970/EXTERIOR-frontSidePilotNear-16353396586768.jpg',
        273999,
        false,
        2,
        13
    );

INSERT INTO
    car (
        id,
        car_name,
        car_age,
        car_color,
        car_fuel,
        car_transmission,
        car_type,
        car_ipva,
        car_km,
        car_photo,
        car_price,
        car_reserved,
        brand_id,
        model_id
    )
Values
    (
        14,
        'M COUPE V8 BI-TURBO',
        2014,
        'BRANCO',
        'FLEX',
        'AUTOMATICO',
        'SUV',
        true,
        73800,
        'https://images.kavak.services/images/147761/EXTERIOR-frontSidePilotNear-1641885219635.jpeg',
        234999,
        false,
        2,
        14
    );

-- Chery
INSERT INTO
    car (
        id,
        car_name,
        car_age,
        car_color,
        car_fuel,
        car_transmission,
        car_type,
        car_ipva,
        car_km,
        car_photo,
        car_price,
        car_reserved,
        brand_id,
        model_id
    )
Values
    (
        15,
        'VVT TURBO i RXT',
        2019,
        'PRETO',
        'FLEX',
        'AUTOMATICO',
        'SEDAN',
        true,
        25244,
        'https://images.kavak.services/images/126751/EXTERIOR-frontSidePilotNear-16367972070892.jpg',
        75499,
        false,
        3,
        15
    );

INSERT INTO
    car (
        id,
        car_name,
        car_age,
        car_color,
        car_fuel,
        car_transmission,
        car_type,
        car_ipva,
        car_km,
        car_photo,
        car_price,
        car_reserved,
        brand_id,
        model_id
    )
Values
    (
        16,
        'MPFI ACT',
        2015,
        'AMARELO',
        'FLEX',
        'MANUAL',
        'HATCHBACK',
        false,
        42150,
        'https://images.kavak.services/images/148973/EXTERIOR-frontSidePilotNear-1641652821910.jpeg',
        77299,
        true,
        3,
        16
    );

INSERT INTO
    car (
        id,
        car_name,
        car_age,
        car_color,
        car_fuel,
        car_transmission,
        car_type,
        car_ipva,
        car_km,
        car_photo,
        car_price,
        car_reserved,
        brand_id,
        model_id
    )
Values
    (
        17,
        'MPFI ACT',
        2019,
        'VERMELHO',
        'GASOLINA',
        'MANUAL',
        'HATCHBACK',
        true,
        56849,
        'https://images.kavak.services/images/153864/EXTERIOR-frontSidePilotNear-1640606979594.jpeg',
        32999,
        false,
        3,
        17
    );

INSERT INTO
    car (
        id,
        car_name,
        car_age,
        car_color,
        car_fuel,
        car_transmission,
        car_type,
        car_ipva,
        car_km,
        car_photo,
        car_price,
        car_reserved,
        brand_id,
        model_id
    )
Values
    (
        18,
        'VVT TURBO i TXS DCT',
        2019,
        'CINZA',
        'FLEX',
        'MANUAL',
        'SUV',
        true,
        19545,
        'https://images.kavak.services/images/154471/EXTERIOR-frontSidePilotNear-1640646243811.jpeg',
        105999,
        true,
        3,
        18
    );

-- Chevrolet
INSERT INTO
    car (
        id,
        car_name,
        car_age,
        car_color,
        car_fuel,
        car_transmission,
        car_type,
        car_ipva,
        car_km,
        car_photo,
        car_price,
        car_reserved,
        brand_id,
        model_id
    )
Values
    (
        19,
        'MPFI MAXX',
        2012,
        'PRETO',
        'GASOLINA',
        'MANUAL',
        'HATCHBACK',
        true,
        84000,
        'https://images.kavak.services/images/141628/EXTERIOR-frontSidePilotNear-16388157648443.jpg',
        29799,
        false,
        4,
        19
    );

INSERT INTO
    car (
        id,
        car_name,
        car_age,
        car_color,
        car_fuel,
        car_transmission,
        car_type,
        car_ipva,
        car_km,
        car_photo,
        car_price,
        car_reserved,
        brand_id,
        model_id
    )
Values
    (
        20,
        'MPFI PREMIUM',
        2018,
        'BRANCO',
        'GASOLINA',
        'MANUAL',
        'HATCHBACK',
        true,
        110584,
        'https://images.kavak.services/images/127373/EXTERIOR-frontSidePilotNear-16384730454991.jpg',
        31299,
        false,
        4,
        20
    );

INSERT INTO
    car (
        id,
        car_name,
        car_age,
        car_color,
        car_fuel,
        car_transmission,
        car_type,
        car_ipva,
        car_km,
        car_photo,
        car_price,
        car_reserved,
        brand_id,
        model_id
    )
Values
    (
        21,
        'MPFI JOY',
        2018,
        'VERMELHO',
        'GASOLINA',
        'AUTOMATICO',
        'HATCHBACK',
        false,
        55435,
        'https://images.kavak.services/images/154423/EXTERIOR-frontSidePilotNear-1640878413134.jpeg',
        50799,
        false,
        4,
        21
    );

INSERT INTO
    car (
        id,
        car_name,
        car_age,
        car_color,
        car_fuel,
        car_transmission,
        car_type,
        car_ipva,
        car_km,
        car_photo,
        car_price,
        car_reserved,
        brand_id,
        model_id
    )
Values
    (
        22,
        'MPFI LT',
        2015,
        'CINZA',
        'FLEX',
        'AUTOMATICO',
        'SEDAN',
        true,
        82221,
        'https://images.kavak.services/images/143025/EXTERIOR-frontSidePilotNear-16379338695128.jpg',
        53999,
        true,
        4,
        22
    );

INSERT INTO
    car (
        id,
        car_name,
        car_age,
        car_color,
        car_fuel,
        car_transmission,
        car_type,
        car_ipva,
        car_km,
        car_photo,
        car_price,
        car_reserved,
        brand_id,
        model_id
    )
Values
    (
        23,
        'MPFI ELEGANCE',
        2020,
        'AZUL',
        'GASOLINA',
        'MANUAL',
        'SEDAN',
        false,
        79837,
        'https://images.kavak.services/images/130651/EXTERIOR-frontSidePilotNear-1638968955326.jpeg',
        39999,
        false,
        4,
        23
    );

-- Citroen
INSERT INTO
    car (
        id,
        car_name,
        car_age,
        car_color,
        car_fuel,
        car_transmission,
        car_type,
        car_ipva,
        car_km,
        car_photo,
        car_price,
        car_reserved,
        brand_id,
        model_id
    )
Values
    (
        24,
        'TENDANCE AUT',
        2015,
        'BRANCO',
        'FLEX',
        'AUTOMATICO',
        'HATCHBACK',
        true,
        81929,
        'https://images.kavak.services/images/122103/EXTERIOR-frontSidePilotNear-16365799054459.jpg?d=540x310',
        47799,
        false,
        5,
        24
    );

INSERT INTO
    car (
        id,
        car_name,
        car_age,
        car_color,
        car_fuel,
        car_transmission,
        car_type,
        car_ipva,
        car_km,
        car_photo,
        car_price,
        car_reserved,
        brand_id,
        model_id
    )
Values
    (
        25,
        'GLX',
        2010,
        'CINZA',
        'GASOLINA',
        'MANUAL',
        'HATCHBACK',
        true,
        96231,
        'https://images.kavak.services/images/116690/EXTERIOR-frontSidePilotNear-1641318108785.jpeg?d=540x310',
        29499,
        false,
        5,
        25
    );

INSERT INTO
    car (
        id,
        car_name,
        car_age,
        car_color,
        car_fuel,
        car_transmission,
        car_type,
        car_ipva,
        car_km,
        car_photo,
        car_price,
        car_reserved,
        brand_id,
        model_id
    )
Values
    (
        26,
        'LOUNGE MPFI TENDENCE',
        2015,
        'CINZA',
        'FLEX',
        'AUTOMATICO',
        'SEDAN',
        true,
        100750,
        'https://images.kavak.services/images/130467/EXTERIOR-frontSidePilotNear-16372496233906.jpg?d=540x310',
        51299,
        false,
        5,
        26
    );

INSERT INTO
    car (
        id,
        car_name,
        car_age,
        car_color,
        car_fuel,
        car_transmission,
        car_type,
        car_ipva,
        car_km,
        car_photo,
        car_price,
        car_reserved,
        brand_id,
        model_id
    )
Values
    (
        27,
        'L EXCLUSIVE',
        2011,
        'CINZA',
        'FLEX',
        'AUTOMATICO',
        'HATCHBACK',
        true,
        108200,
        'https://images.kavak.services/images/149311/EXTERIOR-frontSidePilotNear-1640650644146.jpeg?d=540x310',
        25799,
        false,
        5,
        27
    );

INSERT INTO
    car (
        id,
        car_name,
        car_age,
        car_color,
        car_fuel,
        car_transmission,
        car_type,
        car_ipva,
        car_km,
        car_photo,
        car_price,
        car_reserved,
        brand_id,
        model_id
    )
Values
    (
        28,
        'GLX',
        2012,
        'MARROM',
        'HIBRIDO',
        'AUTOMATICO',
        'SUV',
        true,
        108445,
        'https://images.kavak.services/images/119987/EXTERIOR-frontSidePilotNear-1640205243893.jpeg?d=540x310',
        37499,
        true,
        5,
        28
    );

-- Dodge
INSERT INTO
    car (
        id,
        car_name,
        car_age,
        car_color,
        car_fuel,
        car_transmission,
        car_type,
        car_ipva,
        car_km,
        car_photo,
        car_price,
        car_reserved,
        brand_id,
        model_id
    )
Values
    (
        29,
        'RT AWD V6',
        2015,
        'PRETO',
        'DIESEL',
        'AUTOMATICO',
        'SUV',
        true,
        73370,
        'https://images.kavak.services/images/131011/EXTERIOR-frontSidePilotNear-16369771211122.jpg?d=540x310',
        84499,
        false,
        6,
        29
    );

INSERT INTO
    car (
        id,
        car_name,
        car_age,
        car_color,
        car_fuel,
        car_transmission,
        car_type,
        car_ipva,
        car_km,
        car_photo,
        car_price,
        car_reserved,
        brand_id,
        model_id
    )
Values
    (
        30,
        '2500 LARAMIE',
        2012,
        'CINZA',
        'FLEX',
        'AUTOMATICO',
        'PICKUP',
        true,
        87500,
        'https://images.kavak.services/images/156680/EXTERIOR-frontSidePilotNear-1642069457046.jpeg?d=540x310',
        224799,
        false,
        6,
        30
    );

-- Mini
INSERT INTO
    car (
        id,
        car_name,
        car_age,
        car_color,
        car_fuel,
        car_transmission,
        car_type,
        car_ipva,
        car_km,
        car_photo,
        car_price,
        car_reserved,
        brand_id,
        model_id
    )
Values
    (
        31,
        'TWINPOWER S',
        2020,
        'AZUL',
        'FLEX',
        'AUTOMATICO',
        'HATCHBACK',
        true,
        209799,
        'https://images.kavak.services/images/128426/EXTERIOR-frontSidePilotNear-16360238526635.jpg?d=540x310',
        209799,
        false,
        7,
        31
    );

-- Nissan
INSERT INTO
    car (
        id,
        car_name,
        car_age,
        car_color,
        car_fuel,
        car_transmission,
        car_type,
        car_ipva,
        car_km,
        car_photo,
        car_price,
        car_reserved,
        brand_id,
        model_id
    )
Values
    (
        32,
        'TURBO LE CD',
        2020,
        'BRANCO',
        'FLEX',
        'AUTOMATICO',
        'PICKUP',
        true,
        16090,
        'https://images.kavak.services/images/120754/frontier-nissan-turbo-le-cd-2020-exterior-frontsidepilotnear-16345752271312.jpg?d=540x310',
        232999,
        false,
        8,
        32
    );

INSERT INTO
    car (
        id,
        car_name,
        car_age,
        car_color,
        car_fuel,
        car_transmission,
        car_type,
        car_ipva,
        car_km,
        car_photo,
        car_price,
        car_reserved,
        brand_id,
        model_id
    )
Values
    (
        33,
        'SL X-GEAR',
        2014,
        'CINZA',
        'GASOLINA',
        'MANUAL',
        'SUV',
        true,
        106953,
        'https://images.kavak.services/images/129176/EXTERIOR-frontSidePilotNear-16366580095709.jpg?d=540x310',
        41299,
        false,
        8,
        33
    );

INSERT INTO
    car (
        id,
        car_name,
        car_age,
        car_color,
        car_fuel,
        car_transmission,
        car_type,
        car_ipva,
        car_km,
        car_photo,
        car_price,
        car_reserved,
        brand_id,
        model_id
    )
Values
    (
        34,
        'START SV',
        2019,
        'PRETO',
        'FLEX',
        'AUTOMATICO',
        'SEDAN',
        true,
        27450,
        'https://images.kavak.services/images/128767/EXTERIOR-frontSidePilotNear-16361408655561.jpg?d=540x310',
        67799,
        false,
        8,
        34
    );

INSERT INTO
    car (
        id,
        car_name,
        car_age,
        car_color,
        car_fuel,
        car_transmission,
        car_type,
        car_ipva,
        car_km,
        car_photo,
        car_price,
        car_reserved,
        brand_id,
        model_id
    )
Values
    (
        35,
        'SV',
        2011,
        'AZUL',
        'FLEX',
        'AUTOMATICO',
        'SEDAN',
        true,
        93313,
        'https://images.kavak.services/images/122326/EXTERIOR-frontSidePilotNear-16359694243736.jpg?d=540x310',
        64299,
        false,
        8,
        35
    );

INSERT INTO
    car (
        id,
        car_name,
        car_age,
        car_color,
        car_fuel,
        car_transmission,
        car_type,
        car_ipva,
        car_km,
        car_photo,
        car_price,
        car_reserved,
        brand_id,
        model_id
    )
Values
    (
        36,
        'MARCH SV',
        2016,
        'VERMELHO',
        'FLEX',
        'MANUAL',
        'HATCHBACK',
        true,
        76377,
        'https://images.kavak.services/images/123133/EXTERIOR-frontSidePilotNear-16349455830028.jpg?d=540x310',
        44799,
        false,
        8,
        36
    );