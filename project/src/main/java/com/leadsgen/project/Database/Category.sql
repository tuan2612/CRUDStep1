DROP DATABASE IF EXISTS step1;
-- Create the database if it doesn't exist
CREATE DATABASE IF NOT EXISTS Step1;

-- Use the database
USE Step1;

-- Create the Category table
CREATE TABLE IF NOT EXISTS Category(
                                       id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY ,
                                       name VARCHAR(50) NOT NULL,
                                        create_at DATETIME DEFAULT NOW()
    );


INSERT INTO Category ( name)
VALUES
    ( 'Electronics');
