-- Users Table
CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    bio TEXT,
    profile_photo TEXT
);

-- Skills Table
CREATE TABLE skills (
    id SERIAL PRIMARY KEY,
    user_id INT REFERENCES users(id) ON DELETE CASCADE,
    skill_name VARCHAR(100) NOT NULL
);

-- Projects Table
CREATE TABLE projects (
    id SERIAL PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    description TEXT,
    creator_id INT REFERENCES users(id) ON DELETE SET NULL,
    required_skills TEXT
);

-- Example Data for Testing
INSERT INTO users (name, bio, profile_photo) VALUES 
('Alice', 'Frontend Developer', 'alice.jpg'),
('Bob', 'Backend Specialist', 'bob.jpg');

INSERT INTO skills (user_id, skill_name) VALUES 
(1, 'React'),
(1, 'JavaScript'),
(1, 'CSS'),
(2, 'Node.js'),
(2, 'Docker'),
(2, 'SQL');

INSERT INTO projects (title, description, creator_id, required_skills) VALUES
('Build a Social App', 'A platform to connect users based on skills', 1, 'React, Node.js, Docker'),
('Database Optimization', 'Improve database performance for large datasets', 2, 'SQL, Docker');
