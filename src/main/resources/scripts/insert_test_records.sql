INSERT INTO users (username, password, email, role, created_at)
VALUES
       ('test_user', 'test123', 'test@test.com', 'USER', NOW()),
('test_user2', 'test12345', 'test2@test.com', 'USER', NOW()),
('test_user3', 'test1234567', 'test3@test.com', 'USER', NOW());

INSERT INTO posts (user_id, title, content)
VALUES
       (1, 'Babys First Post', 'Do not be alarmed. This is only a test.'),
(2, 'Title for test post 2', 'Do not be alarmed. This is only a test.'),
(3, 'Title for test post 3', 'Do not be alarmed. This is only a test.');


INSERT INTO categories (name)
VALUES ('MUSIC'),
       ('FOOD'),
       ('PROGRAMMING');

INSERT INTO post_category (post_id, category_id)
VALUES
       (1, 3),
(2,3),
(3,2);
SELECT *
FROM users;

SELECT *
FROM posts;
SELECT *
FROM post_category;