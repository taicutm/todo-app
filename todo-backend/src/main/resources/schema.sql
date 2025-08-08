-- CREATE TABLE tasks (
--     id SERIAL PRIMARY KEY,
--     title VARCHAR(255) NOT NULL,
--     description TEXT,
--     is_completed BOOLEAN DEFAULT false,
--     due_date TIMESTAMP
-- );
-- INSERT INTO tasks (title, description, is_completed, due_date)
-- VALUES
-- ('Học Spring Boot', 'Tìm hiểu cách tạo REST API với Spring Boot', false, '2025-08-10 18:00:00'),
-- ('Làm UI TODO App', 'Thiết kế giao diện TODO App bằng Next.js + MUI', false, '2025-08-15 20:00:00'),
-- ('Viết MyBatis Mapper', 'Kết nối database và viết CRUD với MyBatis', false, '2025-08-12 23:59:00');

Select * from tasks