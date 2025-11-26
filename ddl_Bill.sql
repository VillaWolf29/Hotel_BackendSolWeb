CREATE TABLE bill
(
    id_bill        INT         NOT NULL,
    date_emission  date        NOT NULL,
    total          DOUBLE      NOT NULL,
    payment_method VARCHAR(20) NOT NULL,
    state          VARCHAR(20) NOT NULL,
    id_booking     INT         NOT NULL,
    CONSTRAINT pk_bill PRIMARY KEY (id_bill)
);

ALTER TABLE bill
    ADD CONSTRAINT FK_BILL_ON_ID_BOOKING FOREIGN KEY (id_booking) REFERENCES booking (id_booking);
CREATE TABLE bill
(
    id_bill        INT         NOT NULL,
    date_emission  date        NOT NULL,
    total          DOUBLE      NOT NULL,
    payment_method VARCHAR(20) NOT NULL,
    state          VARCHAR(20) NOT NULL,
    id_booking     INT         NOT NULL,
    CONSTRAINT pk_bill PRIMARY KEY (id_bill)
);

ALTER TABLE bill
    ADD CONSTRAINT FK_BILL_ON_ID_BOOKING FOREIGN KEY (id_booking) REFERENCES booking (id_booking);