CREATE TABLE User (
    UserName VARCHAR(64) PRIMARY KEY,
    Name VARCHAR(64) NOT NULL,
    Surname VARCHAR(64) NOT NULL,
	Age INT NOT NULL,
	Email VARCHAR(64) NOT NULL,
	Password VARCHAR(64) NOT NULL,
    ImageID VARCHAR(64)
);


CREATE TABLE Habit (
    HabitID INT PRIMARY KEY AUTO_INCREMENT,
    CurrentStreak INT NOT NULL,
    LongestStreak INT NOT NULL,
	HabitName VARCHAR(64) NOT NULL,

    UserName VARCHAR(64),
    FOREIGN KEY (UserName) REFERENCES User(UserName)
);

CREATE TABLE Entry (
	EntryID INT PRIMARY KEY AUTO_INCREMENT,
	Date DATE,
	Value BOOLEAN,
    
    HabitID INT,
    FOREIGN KEY (HabitID) REFERENCES Habit(HabitID)
);
