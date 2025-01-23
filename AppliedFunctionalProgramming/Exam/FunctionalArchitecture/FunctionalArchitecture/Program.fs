

let pure_add x y =
    x + y
let impure_add x y =
    printfn "Adding %d %d" x y // <-- side effect
    x + y
 
let multiplier = 2    
let impure_multiply x =
    x * multiplier
    


// BUSINESS LOGIC
let calculateInterest (initial_balance: float) (rate: float) (time: float) : float =
    initial_balance * rate * time / 100.0
let calculateTotalAmount (initial_balance: float) (interest: float) : float =
    initial_balance + interest

//APPLICATION LOGIC
    
let addTotalInterestToBalance (initial_balance: float) (rate: float) (time: float) : float =
    calculateTotalAmount (initial_balance) (calculateInterest initial_balance rate time)
let principalAmount = 5000.0
let interestRate = 5.0
let timeInYears = 3.0

printfn "Total balance: %A" (addTotalInterestToBalance principalAmount interestRate timeInYears)

    