CREATE TABLE students (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100),
    age INT
);

INSERT INTO students (name, age) VALUES ('Hanh', 21);
INSERT INTO students (name, age) VALUES ('Phuc', 12);