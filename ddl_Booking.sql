CREATE TABLE booking
(
    id_booking     INT         NOT NULL,
    date_booking   date        NOT NULL,
    date_check_in  date        NOT NULL,
    date_check_out date        NOT NULL,
    state          VARCHAR(20) NOT NULL,
    id_customer    INT         NOT NULL,
    id_room        INT         NOT NULL,
    id_employee    INT         NOT NULL,
    CONSTRAINT pk_booking PRIMARY KEY (id_booking)
);

ALTER TABLE booking
    ADD CONSTRAINT FK_BOOKING_ON_ID_CUSTOMER FOREIGN KEY (id_customer) REFERENCES customer (id_customer);

ALTER TABLE booking
    ADD CONSTRAINT FK_BOOKING_ON_ID_EMPLOYEE FOREIGN KEY (id_employee) REFERENCES employee (id_empleado);

ALTER TABLE booking
    ADD CONSTRAINT FK_BOOKING_ON_ID_ROOM FOREIGN KEY (id_room) REFERENCES room (id_room);