CREATE TABLE pay
(
    id_pay         INT         NOT NULL,
    date_pay       date        NOT NULL,
    amount         DOUBLE      NOT NULL,
    payment_method VARCHAR(20) NOT NULL,
    bill_id_bill   INT         NOT NULL,
    CONSTRAINT pk_pay PRIMARY KEY (id_pay)
);

ALTER TABLE pay
    ADD CONSTRAINT FK_PAY_ON_BILL_IDBILL FOREIGN KEY (bill_id_bill) REFERENCES bill (id_bill);