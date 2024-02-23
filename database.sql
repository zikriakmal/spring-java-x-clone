CREATE DATABASE IF NOT EXISTS twitter_clone;

USE twitter_clone;

CREATE TABLE IF NOT EXISTS users
(
    username         VARCHAR(100) NOT NULL,
    password         VARCHAR(100) NOT NULL,
    name             VARCHAR(100) NOT NULL,
    token            VARCHAR(100),
    token_expired_at BIGINT,
    PRIMARY KEY (username),
    UNIQUE (token)
) ENGINE innoDB;

SELECT *
FROM users;

INSERT INTO users (username, password, name, token, token_expired_at)
VALUES ('user', '$2a$10$L/XBkDfCMR5yWoia5vvoWuDlCzkLyTpRBqihX2liITUJuVV1OU7XG', 'test', 'asldkfja', 12331313)