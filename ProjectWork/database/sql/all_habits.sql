SELECT Habit.Name, Habit.Description
FROM User_Habit
JOIN Habit ON User_Habit.Habit_ID = Habit.Habit_ID
WHERE User_Habit.UserName = 'john_doe';

/*
SELECT DISTINCT HabitCategory.Name, HabitCategory.Description
FROM User_Habit 
JOIN Habit ON User_Habit.Habit_ID = Habit.Habit_ID
JOIN HabitCategory ON Habit.Habit_Cat_ID = HabitCategory.Habit_Cat_ID
WHERE User_Habit.UserName = 'john_doe';
*/
