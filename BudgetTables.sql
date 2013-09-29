DROP TABLE IF EXISTS Accounts, Activities;

CREATE TABLE IF NOT EXISTS Accounts(Id INT PRIMARY KEY AUTO_INCREMENT, 
    Name VARCHAR(25)) ENGINE=InnoDB;
CREATE TABLE IF NOT EXISTS Activities(Id INT PRIMARY KEY AUTO_INCREMENT, 
    AccountId INT, ActivityName VARCHAR(100), Amount DOUBLE, ActivityDate INT, Frequency INT, TypeFlag INT,
    FOREIGN KEY(AccountId) REFERENCES Accounts(Id) ON DELETE CASCADE)
    ENGINE=InnoDB;

INSERT INTO Accounts(Id, Name) VALUES(1, 'Alice''s Checkings');
INSERT INTO Accounts(Id, Name) VALUES(2, 'Bob''s Savings');
INSERT INTO Accounts(Id, Name) VALUES(3, 'Carrie''s Savings');
INSERT INTO Accounts(Id, Name) VALUES(4, 'David''s Checkings');
INSERT INTO Accounts(Id, Name) VALUES(5, 'Fabio''s Checkings');

INSERT INTO Activities(Id, AccountId, ActivityName, Amount, ActivityDate, Frequency, TypeFlag) VALUES(1, 3, 'Comcast Cable Bill', 71.36, 15, 4, 0);
INSERT INTO Activities(Id, AccountId, ActivityName, Amount, ActivityDate, Frequency, TypeFlag) VALUES(2, 4, 'The Groves Rent', 710.50, 1, 4, 0);
INSERT INTO Activities(Id, AccountId, ActivityName, Amount, ActivityDate, Frequency, TypeFlag) VALUES(3, 1, 'Geico Car Insurance', 80.30, 12, 4, 0);
INSERT INTO Activities(Id, AccountId, ActivityName, Amount, ActivityDate, Frequency, TypeFlag) VALUES(5, 4, 'Renter''s Insurance', 15.00, 18, 4, 0);
INSERT INTO Activities(Id, AccountId, ActivityName, Amount, ActivityDate, Frequency, TypeFlag) VALUES(6, 1, 'Car Payment', 200.59, 6, 4, 0);
INSERT INTO Activities(Id, AccountId, ActivityName, Amount, ActivityDate, Frequency, TypeFlag) VALUES(7, 5, 'Yoga', 40.22, 23, 4, 0);
INSERT INTO Activities(Id, AccountId, ActivityName, Amount, ActivityDate, Frequency, TypeFlag) VALUES(9, 2, 'AT&T Cell Bill', 86.27, 2, 4, 0);