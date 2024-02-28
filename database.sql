CREATE DATABASE IF NOT EXISTS twitter_clone;

USE twitter_clone;

DROP table users;

CREATE TABLE IF NOT EXISTS users
(
    id               INT AUTO_INCREMENT,
    username         VARCHAR(100) NOT NULL,
    password         VARCHAR(100) NOT NULL,
    name             VARCHAR(100) NOT NULL,
    PRIMARY KEY (id),
    UNIQUE (username)
) ENGINE innoDB;

SELECT *
FROM users;

INSERT INTO users (username, password, name)
VALUES ('user', '$2a$10$L/XBkDfCMR5yWoia5vvoWuDlCzkLyTpRBqihX2liITUJuVV1OU7XG', 'test', 'asldkfja', 12331313)

DROP table posts;

CREATE TABLE IF NOT EXISTS posts(
    id      INT NOT NULL AUTO_INCREMENT,
    user_id INT NOT NULL,
    post    VARCHAR(255) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY fk_user_posts (user_id) REFERENCES users (id)
) ENGINE innoDB;

SELECT * FROM posts