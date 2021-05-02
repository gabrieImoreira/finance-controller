CREATE TABLE input (
    id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    description VARCHAR(50) NOT NULL,
    dt_due DATE NOT NULL,
    dt_payment DATE,
    value DECIMAL(10,2) NOT NULL,
    observation VARCHAR(100),
    type VARCHAR(20) NOT NULL,
    id_category BIGINT(20) NOT NULL,
    id_person BIGINT(20) NOT NULL,
    FOREIGN KEY (id_category) REFERENCES category(id),
    FOREIGN KEY (id_person) REFERENCES person(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO input (description, dt_due, dt_payment, value, observation, type, id_category, id_person) values ('Salário mensal', '2021-06-10', null, 6500.00, 'Distribuição de lucros', 'RECEITA', 1, 1);
INSERT INTO input (description, dt_due, dt_payment, value, observation, type, id_category, id_person) values ('Bahamas', '2021-02-10', '2021-02-10', 100.32, null, 'DESPESA', 2, 2);
INSERT INTO input (description, dt_due, dt_payment, value, observation, type, id_category, id_person) values ('Top Club', '2021-06-10', null, 120, null, 'RECEITA', 3, 3);
INSERT INTO input (description, dt_due, dt_payment, value, observation, type, id_category, id_person) values ('CEMIG', '2021-02-10', '2021-02-10', 110.44, 'Geração', 'RECEITA', 3, 4);
INSERT INTO input (description, dt_due, dt_payment, value, observation, type, id_category, id_person) values ('DMAE', '2021-06-10', null, 200.30, null, 'DESPESA', 3, 5);
INSERT INTO input (description, dt_due, dt_payment, value, observation, type, id_category, id_person) values ('Extra', '2021-03-10', '2021-03-10', 1010.32, null, 'RECEITA', 4, 6);
INSERT INTO input (description, dt_due, dt_payment, value, observation, type, id_category, id_person) values ('Bahamas', '2021-06-10', null, 500, null, 'RECEITA', 1, 7);
INSERT INTO input (description, dt_due, dt_payment, value, observation, type, id_category, id_person) values ('Top Club', '2021-03-10', '2021-03-10', 400.32, null, 'DESPESA', 4, 8);
INSERT INTO input (description, dt_due, dt_payment, value, observation, type, id_category, id_person) values ('Despachante', '2021-06-10', null, 123.64, 'Multas', 'DESPESA', 3, 9);
INSERT INTO input (description, dt_due, dt_payment, value, observation, type, id_category, id_person) values ('Pneus', '2021-04-10', '2021-04-10', 665.33, null, 'RECEITA', 5, 10);
INSERT INTO input (description, dt_due, dt_payment, value, observation, type, id_category, id_person) values ('Café', '2021-06-10', null, 8.32, null, 'DESPESA', 1, 5);
INSERT INTO input (description, dt_due, dt_payment, value, observation, type, id_category, id_person) values ('Eletrônicos', '2021-04-10', '2021-04-10', 2100.32, null, 'DESPESA', 5, 4);
INSERT INTO input (description, dt_due, dt_payment, value, observation, type, id_category, id_person) values ('Instrumentos', '2021-06-10', null, 1040.32, null, 'DESPESA', 4, 3);
INSERT INTO input (description, dt_due, dt_payment, value, observation, type, id_category, id_person) values ('Café', '2021-04-10', '2021-04-10', 4.32, null, 'DESPESA', 4, 2);
INSERT INTO input (description, dt_due, dt_payment, value, observation, type, id_category, id_person) values ('Lanche', '2021-06-10', null, 10.20, null, 'DESPESA', 4, 1);