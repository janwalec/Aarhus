module UseCases
open System
open entities
let isDateValid (date: Date) =
        
        let translateToNumberOfDays = function
            | January, _ | March, _ | May, _ | July, _ | August, _ | October, _ | December, _ -> 31
            | April, _ | June, _ | September, _ | November, _ -> 30
            | February, false -> 28
            | February, true -> 29
        
        let checkIfLeapYear = function
            | year when year % 400 = 0 -> true
            | year when year % 100 = 0 -> false
            | year when year % 4 = 0 -> true
            | _ -> false

        let checkIfDayValid = function
            | date when date.day <= 0 -> (Error "wrong day")
            | date when date.day <= (translateToNumberOfDays (date.month, (checkIfLeapYear date.year))) -> Ok date
            | _ -> (Error "wrong day")

        let checkIfYearValid = function
            | date when date.year < 1900 -> (Error "wrong year")
            | date when date.year > 2024 -> (Error "wrong year")
            | _ -> Ok date

        //let a = checkIfYearValid date
        //Result.bind (checkIfDayValid) (a)
        Result.bind (checkIfDayValid) (checkIfYearValid date)
        
            
        //checkIfDayValid date && checkIfYearValid date
   
let changeUsername (newUsername: Username) (profile: Profile) =
    {username = newUsername; performance = profile.performance}

let addGoal (goal: Goal) (profile: Profile) = 
    {username = profile.username; performance = profile.performance.Add (goal, [])}

let calculateCaloriesBurnt (activity: ActivityType) (time: TimeInMins)= 
    let caloriesBurntPerHour = function
            | Cycle -> 273
            | Run -> 350
            | Walk -> 110
            | Swim -> 440
    int (float (caloriesBurntPerHour activity) / 60.0 * float time)

 

let changeProfileOnDevice (wearableDevice : WearableDevice) (profile : Profile) = 
    {profileConnected = profile; workout = None}
    
 
 
let createMeal meal =
    {mealType = meal; totalCalories = 0; ingredients = Set.ofList([])}


let updateTotalCalories meal = 
    let rec sumCalories = function
            | [] -> 0
            | list_start::list_rest-> list_start + sumCalories list_rest

    let rec getCalories = function
            | [] -> []
            | list_start::list_rest -> list_start.calories::getCalories list_rest
        
    let toList set = Set.fold (fun l se -> se::l) [] set

    {mealType = meal.mealType; totalCalories = (sumCalories (getCalories (toList meal.ingredients))); ingredients = meal.ingredients}


 
let addIngredient (meal : Meal) (ingredient : Ingredient) =
        updateTotalCalories {mealType = meal.mealType; totalCalories = 0; ingredients = meal.ingredients.Add(ingredient)}

    
let addMeal (profile: Profile) (date: Date) (meal:Meal) = 
        let addMealToPerformance = 
            match (profile.performance.TryFind(FoodGoal EatHealthy) |> Option.map (fun s -> s @ [(date,Meal meal)] )) with
                | Some p -> Ok {username = profile.username; performance = profile.performance.Add (FoodGoal EatHealthy, p)}
                | None -> Error profile
            
        match (isDateValid date), (addMealToPerformance) with
            | Ok _, Ok p -> p
            | Error _, Ok p -> profile
            | _, Error p -> profile


let addActivity (profile: Profile) (activity: ActivityType) (date: Date) (timeInMin: TimeInMins) = 
        let addActivityToPerformance =
            match 
                profile.performance.TryFind(ActivityType activity) 
                |> Option.map (fun s -> s @ [(date, Activity {burntCalories = calculateCaloriesBurnt activity timeInMin; timeInMinutes = timeInMin})])
            with
                | Some p -> Ok {username = profile.username; performance = profile.performance.Add(ActivityType activity, p)}
                | None -> Error profile
        
        match (isDateValid date), (addActivityToPerformance) with
            | Ok _, Ok p -> p
            | Error _, _ -> profile
            | _, Error p -> profile

   

let syncProfileWithDevice (wearableDevice : WearableDevice) (date : Date) =
        let newProfile = 
            match wearableDevice.workout with
            | Some w -> addActivity wearableDevice.profileConnected (fst w) date (snd w).timeInMinutes     //fst - first member of tuple 
            | None -> failwith "no workout registered on device"
          
        {profileConnected = newProfile; workout = wearableDevice.workout}

    
let registerWorkout (wearableDevice : WearableDevice) (activityType : ActivityType, activity : Activity) =
    let getMonth = function
            | 1 -> January
            | 2 -> February
            | 3 -> March
            | 4 -> April
            | 5 -> May
            | 6 -> June
            | 7 -> July
            | 8 -> August
            | 9 -> September
            | 10 -> October
            | 11 -> November
            | _ -> December

    let calculateActivity = 
            {burntCalories = calculateCaloriesBurnt activityType activity.timeInMinutes; timeInMinutes = activity.timeInMinutes}
            
    try 
            syncProfileWithDevice {profileConnected = wearableDevice.profileConnected; workout = Some(activityType, calculateActivity)} {year = DateTime.Now.Year; month = (getMonth DateTime.Now.Month); day = DateTime.Now.Day}
    with 
            Failure f -> wearableDevice

