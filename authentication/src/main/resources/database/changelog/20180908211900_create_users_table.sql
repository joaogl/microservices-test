--liquibase formatted sql
--changeset jhipster:20180908211900

CREATE TABLE users
(
    id int PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(15) NOT NULL,
    password VARCHAR(64) NOT NULL
);

CREATE UNIQUE INDEX users_id_uindex ON users (id);
CREATE UNIQUE INDEX users_username_uindex ON users (username);

--rollback DROP TABLE users;