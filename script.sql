DROP TABLE IF EXISTS students CASCADE;
DROP TABLE IF EXISTS groups CASCADE;
DROP TABLE IF EXISTS plans CASCADE;

-- ------------------------------------------------------------
-- Table: plans 
-- ------------------------------------------------------------
CREATE TABLE plans (
    id          SERIAL PRIMARY KEY,
    code        VARCHAR(50)  NOT NULL UNIQUE,   
    created_at  DATE         NOT NULL,           
    speciality  VARCHAR(50)
);

INSERT INTO plans (id, code, created_at, speciality) VALUES
    (11, '245/3- 12', '2015-07-23', 'It'),
    (12, '222/1- 02', '2019-09-15', 'It'),
    (21, '211/3- 11', '2008-09-15', 'A');

-- Sync the sequence after manual id inserts
SELECT setval('plans_id_seq', (SELECT MAX(id) FROM plans));

-- ------------------------------------------------------------
-- Table: groups
-- ------------------------------------------------------------
CREATE TABLE groups (
    id          SERIAL PRIMARY KEY,             
    name        VARCHAR(50)  NOT NULL UNIQUE,   
    formed_at   DATE         NOT NULL,          
    plan_id     INT          NOT NULL REFERENCES plans(id) ON DELETE CASCADE,  
    status      VARCHAR(50),
    status_date DATE
);

INSERT INTO groups (id, name, formed_at, plan_id, status, status_date) VALUES
    (1, 'It-1', '2018-07-23', 11, 'created',  '2021-06-15'),
    (2, 'It-2', '2019-09-15', 12, 'created',  '2021-06-15'),
    (3, 'A-2',  '2008-09-15', 21, 'finished', '2021-06-15'),
    (4, 'A-3',  '2008-09-15', 21, 'finished', '2021-06-15');

SELECT setval('groups_id_seq', (SELECT MAX(id) FROM groups));

-- ------------------------------------------------------------
-- Table: students  
-- ------------------------------------------------------------
CREATE TABLE students (
    record_book_no  BIGINT       PRIMARY KEY,   
    group_id        INT          NOT NULL REFERENCES groups(id) ON DELETE CASCADE,  
    last_name       VARCHAR(30)  NOT NULL,       
    first_name      VARCHAR(30)  NOT NULL,       
    middle_name     VARCHAR(30)  NOT NULL,       
    city            VARCHAR(30)  NOT NULL,       
    address         VARCHAR(80)  NOT NULL,       
    phone           VARCHAR(30)  NOT NULL,       
    status          VARCHAR(50),
    status_date     DATE
);

INSERT INTO students (record_book_no, group_id, last_name, first_name, middle_name, city, address, phone, status, status_date) VALUES
    (10122, 1, 'Ivanov',  '', 'Ivanich', 'Vitebsk', 'Moskow ave., 62, 2, 129', '+375297451421', 'enrolled',   '2021-06-15'),
    (10123, 1, 'Dremin',  '', 'Ivanich', 'Vitebsk', 'Moskow ave., 15, 19',     '+375297751421', 'enrolled',   '2021-06-15'),
    (10355, 3, 'Firsov',  '', 'Ivanich', 'Vitebsk', 'Moskow ave., 73, 2, 9',   '+375297451471', 'graduated',  '2008-09-15'),
    (10356, 2, 'Sidorov', '', 'Ivanich', 'Minsk',   'Moskow ave., 12, 2, 19',  '+375297433421', 'enrolled',   '2021-06-15'),
    (10361, 3, 'Pavlov',  '', 'Ivanich', 'Vitebsk', 'Pravdy st., 41, 19',      '+375297411421', 'graduated',  '2008-09-15'),
    (10362, 3, 'Shurov',  '', 'Ivanich', 'Vitebsk', 'Pravdy st., 12, 1',       '+375297451199', 'send_down',  '2007-05-15');