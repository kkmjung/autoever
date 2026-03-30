CREATE TABLE IF NOT EXISTS posts (
                                     id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                     title VARCHAR(255) NOT NULL,
    content TEXT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
    );

INSERT INTO posts (title, content) VALUES
                                       ('first title', 'first content'),
                                       ('second title', 'second content'),
                                       ('third title', 'third content');