CREATE TABLE room
(
    id_room  INT         NOT NULL,
    num_room INT         NOT NULL,
    type     VARCHAR(50) NOT NULL,
    ability  VARCHAR(50) NOT NULL,
    price    DOUBLE      NOT NULL,
    state    BIT(1)      NOT NULL,
    CONSTRAINT pk_room PRIMARY KEY (id_room)
);