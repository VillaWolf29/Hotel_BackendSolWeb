CREATE TABLE consumption
(
    id_consumption   INT    NOT NULL,
    amount           INT    NOT NULL,
    date_consumption date   NOT NULL,
    subtotal         DOUBLE NOT NULL,
    id_booking       INT    NOT NULL,
    id_service       INT    NOT NULL,
    CONSTRAINT pk_consumption PRIMARY KEY (id_consumption)
);

ALTER TABLE consumption
    ADD CONSTRAINT FK_CONSUMPTION_ON_ID_BOOKING FOREIGN KEY (id_booking) REFERENCES booking (id_booking);

ALTER TABLE consumption
    ADD CONSTRAINT FK_CONSUMPTION_ON_ID_SERVICE FOREIGN KEY (id_service) REFERENCES service_hotel (id_service_hotel);