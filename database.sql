CREATE DATABASE IF NOT EXISTS twitter_clone;

USE twitter_clone;

DROP table users;
DROP table posts;

CREATE TABLE IF NOT EXISTS users
(
    id               INT AUTO_INCREMENT,
    username         VARCHAR(100) NOT NULL,
    password         VARCHAR(100) NOT NULL,
    name             VARCHAR(100) NOT NULL,
    PRIMARY KEY (id),
    UNIQUE (username)
) ENGINE innoDB;

SELECT * FROM users;

CREATE TABLE IF NOT EXISTS posts(
    id      INT NOT NULL AUTO_INCREMENT,
    user_id INT NOT NULL,
    post    VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (id),
    FOREIGN KEY fk_user_posts (user_id) REFERENCES users (id)
) ENGINE innoDB;

SELECT * FROM posts