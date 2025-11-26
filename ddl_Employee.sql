CREATE TABLE employee
(
    id_empleado INT          NOT NULL,
    first_name  VARCHAR(100) NOT NULL,
    last_name   VARCHAR(100) NOT NULL,
    post        VARCHAR(50)  NOT NULL,
    phone       VARCHAR(20)  NULL,
    email       VARCHAR(100) NULL,
    CONSTRAINT pk_employee PRIMARY KEY (id_empleado)
);

ALTER TABLE employee
    ADD CONSTRAINT uc_employee_email UNIQUE (email);