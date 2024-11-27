create database gym
use gym
drop table receptionist
CREATE TABLE admin (
    fname VARCHAR(20) PRIMARY KEY,
    password VARCHAR(50)
);

-- Creating the captain table
CREATE TABLE captain (
    id VARCHAR(20) PRIMARY KEY,
    name VARCHAR(20),
    address VARCHAR(20),
    phone VARCHAR(12),
    salary VARCHAR(20),
    passwords VARCHAR(20)
);

-- Creating the receptionist table
CREATE TABLE receptionist (
    id VARCHAR(20) PRIMARY KEY,
    fname VARCHAR(20),
	lname VARCHAR(20),
	dob DATE NOT NULL,
    salary DECIMAL(10, 2) NOT NULL,
    password VARCHAR(255) NOT NULL,
    phone VARCHAR(255) NOT NULL
);

-- Creating the manager table
CREATE TABLE manager (
    id VARCHAR(20) PRIMARY KEY,
    name VARCHAR(20),
    address VARCHAR(20),
    phone VARCHAR(12),
    salary VARCHAR(20),
    password VARCHAR(20)
);

-- Creating the suite table
CREATE TABLE suite (
    destination VARCHAR(20) PRIMARY KEY,
    price VARCHAR(10),
    capacity VARCHAR(5)
);

-- Creating the passenger table
CREATE TABLE passenger (
    id VARCHAR(20) PRIMARY KEY,
    name VARCHAR(20),
    address VARCHAR(20),
    phone VARCHAR(12),
    destination VARCHAR(20),
    FOREIGN KEY (destination) REFERENCES suite(destination)
);

-- Creating the locker table
CREATE TABLE locker (
    locker_id VARCHAR(20) PRIMARY KEY,
    location VARCHAR(50),
    size VARCHAR(10),
    assignedto VARCHAR(255),
    FOREIGN KEY (assignedto) REFERENCES passenger(id)
);

-- Creating the machines table
CREATE TABLE machines (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    quantity INT NOT NULL,
    buydate DATE NOT NULL,
    repairs VARCHAR(255) DEFAULT NULL
);

-- Creating the trainer table
CREATE TABLE trainer (
    id VARCHAR(255) PRIMARY KEY,
    fname VARCHAR(255) NOT NULL,
    lname VARCHAR(255) NOT NULL,
    dob DATE NOT NULL,
    salary DECIMAL(10, 2) NOT NULL,
    password VARCHAR(255) NOT NULL,
    phone VARCHAR(255) NOT NULL,
    comission DECIMAL(10, 2) NOT NULL
);

-- Creating the dietplan table
CREATE TABLE dietplan (
    id INT AUTO_INCREMENT PRIMARY KEY,
    tid VARCHAR(255) NOT NULL,
    cid VARCHAR(255) NOT NULL,
    plan TEXT NOT NULL,
    FOREIGN KEY (tid) REFERENCES trainer(id),
    FOREIGN KEY (cid) REFERENCES passenger(id)
);

-- Creating the workoutplan table
CREATE TABLE workoutplan (
    id INT AUTO_INCREMENT PRIMARY KEY,
    tid VARCHAR(255) NOT NULL,
    cid VARCHAR(255) NOT NULL,
    plan TEXT NOT NULL,
    FOREIGN KEY (tid) REFERENCES trainer(id),
    FOREIGN KEY (cid) REFERENCES passenger(id)
);

-- Creating the complaints table
CREATE TABLE complaints (
    id INT AUTO_INCREMENT PRIMARY KEY,
    items VARCHAR(255) NOT NULL,
    dateregistered VARCHAR(10) NOT NULL,
    solvedstatus BOOLEAN NOT NULL DEFAULT FALSE
);
CREATE TABLE Shopkeeper (
    id VARCHAR(20) PRIMARY KEY,
    fname VARCHAR(20),
	lname VARCHAR(20),
	dob DATE NOT NULL,
    salary DECIMAL(10, 2) NOT NULL,
    password VARCHAR(255) NOT NULL,
    phone VARCHAR(255) NOT NULL
);
CREATE TABLE customer (
    id VARCHAR(255) PRIMARY KEY,
    fname VARCHAR(255) NOT NULL,
    lname VARCHAR(255) NOT NULL,
    dob DATE NOT NULL,
    feepaid BOOLEAN NOT NULL,
    phone VARCHAR(255) NOT NULL,
    tid VARCHAR(255),
    lid VARCHAR(255),
    FOREIGN KEY (tid) REFERENCES trainer(id),
    FOREIGN KEY (lid) REFERENCES locker(locker_id)
);

INSERT INTO admin (fname, password) VALUES ('ALI', '123');
INSERT INTO locker (locker_id, location, size) VALUES (1, 'hi', '1');
  
INSERT INTO manager (id, name, password) VALUES ('123', 'ALI', '123');

SELECT * FROM Shopkeeper;
SELECT * FROM receptionist;
