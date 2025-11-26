CREATE TABLE service_hotel
(
    id_service_hotel INT          NOT NULL,
    name_service     VARCHAR(100) NOT NULL,
    price            DOUBLE       NOT NULL,
    `description`    VARCHAR(200) NULL,
    CONSTRAINT pk_servicehotel PRIMARY KEY (id_service_hotel)
);