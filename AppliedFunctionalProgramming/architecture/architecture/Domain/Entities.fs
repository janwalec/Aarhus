module entities

type Username = string

type ActivityType = 
        | Run
        | Walk
        | Cycle
        | Swim

    type FoodGoal = 
        | EatHealthy
        // ... to be continued

    type Goal = 
        | ActivityType of ActivityType
        | FoodGoal of FoodGoal

    type Month = 
        | January
        | February
        | March
        | April
        | May
        | June
        | July
        | August
        | September
        | October
        | November
        | December
        
    type Date = {
        year: int;
        month: Month;
        day: int
    }

    type TimeInMins = int
    type BurntCalories = int
    
    type Activity = {
        burntCalories : BurntCalories;
        timeInMinutes: TimeInMins
    }

    type MealType = 
        | Breakfast
        | Lunch
        | Dinner
        | Snack

    type Ingredient = {
        name: string;
        calories: int
    }
    type Meal = {
        mealType: MealType;
        totalCalories: int;
        ingredients: Set<Ingredient>
    }

    type Content = 
        | Activity of Activity 
        | Meal of Meal
    
    type Entry = Date * Content

    type Progress = List<Entry>

    type Profile = {
        username: Username;
        performance: Map<Goal, Progress>
    }


    //device to track your sports performance
    //can only store one workout at the time
    type WearableDevice = {
        profileConnected: Profile;
        workout: Option<ActivityType*Activity>
    }