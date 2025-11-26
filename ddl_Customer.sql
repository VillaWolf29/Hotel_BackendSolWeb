CREATE TABLE customer
(
    id_customer INT          NOT NULL,
    first_name  VARCHAR(70)  NOT NULL,
    last_name   VARCHAR(70)  NOT NULL,
    email       VARCHAR(70)  NULL,
    phone       VARCHAR(30)  NULL,
    id_card     VARCHAR(20)  NOT NULL,
    address     VARCHAR(150) NULL,
    CONSTRAINT pk_customer PRIMARY KEY (id_customer)
);