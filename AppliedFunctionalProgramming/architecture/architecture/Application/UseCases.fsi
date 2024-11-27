module UseCases

open entities

    //checks if month > 0 && < 28/30/31, year>1900 && <currYear
val isDateValid: Date -> Result<Date, string> 

    //modifies the profile by changing username 
val changeUsername: Username -> Profile -> Profile

    
    //to profile's performance adds a goal with an empty progress
val addGoal: Goal -> Profile -> Profile

    
    // returns Meal with updated calories
val updateTotalCalories: Meal -> Meal   

    
    //sets totalCalories to 0 and ingredients to an empty set
val createMeal: MealType -> Meal    


    //adds ingredient to a meal and calls updateTotalCalories function
val addIngredient: Meal -> Ingredient -> Meal   


    //adds entry to profil's Performace to Goal = EatHealthy key
    //checks if date is valid
val addMeal: Profile -> Date -> Meal -> Profile

    
    //calculates number of calories burnt based on activity type and time spent
val calculateCaloriesBurnt: ActivityType -> TimeInMins -> BurntCalories

    
    //adds entry to profile's Performance to Goal = ActivityType
    //calls calculateCaloriesBurnt
val addActivity: Profile -> ActivityType -> Date -> TimeInMins -> Profile

    
    //sets the owner's profile on device
val changeProfileOnDevice: WearableDevice -> Profile -> WearableDevice 
    
    //adds workout registered on device to user's profile
val syncProfileWithDevice: WearableDevice -> Date -> WearableDevice
    
    
    //registers workout on device
    //date is set as current date
    //calls syncProfileWithDevice
val registerWorkout: WearableDevice -> ActivityType*Activity -> WearableDevice

