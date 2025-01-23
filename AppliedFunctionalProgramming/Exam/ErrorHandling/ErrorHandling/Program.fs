
let divide x y : Result <int, string> =
    if y = 0 then
        Error "Division by 0 is forbidden"
    else
        Ok (x / y)
    
printfn "1. Result of division (10/2): %A" (divide 10 2)
printfn "2. Result of division (10/0): %A" (divide 10 0)
       
let bind func input =
    match input with
    | Ok value -> func value
    | Error e  -> Error e
    
printfn "3. Now we binding: %A"
    (Ok 10 |> bind (fun x -> divide x 2) |> bind (fun x -> divide x 5))

printfn "4. Binding, error in the way!: %A"
    (Ok 12345 |> bind (fun x -> divide x 2) |> bind (fun x -> divide x 0) |> bind (fun x -> divide x 10)) 


let combinedComputation =
    let comp1 = bind (fun x -> divide x 2)
    let comp2 = bind (fun x -> divide x 5)
    comp1 >> comp2

printfn "5. Dividing by 10 in composition: %A"
    (Ok 120 |> combinedComputation)
    
let (>>=) twoTrackInput switchFunction =
    bind switchFunction twoTrackInput

let chainComputationMonadicWay x =
    x |>
        (fun x -> divide x 2)
    >>= (fun x -> divide x 5)
    >>= (fun x -> divide x 5)
printfn "6. Monadic way for chain computation: %A"
    (chainComputationMonadicWay 150)
    

let (>=>) aFun bFun x =
    match aFun x with
    | Ok y    -> bFun y
    | Error e -> Error e

let switchComposition =
    (fun x -> divide x 5)
    >=> (fun x -> divide x 2)

printfn "7. Switch composition %A"
    (switchComposition 100)
    
    
   
let divisionWithException x y =
    if y = 0 then
        invalidArg "y" "=0"
    else
        Ok (x / y)
        
       
let tryCatch f input =
    try
        f input
    with
        | ex -> Error ex.Message

let tryCatch_swtichComposition y =
    tryCatch (fun x -> divisionWithException x 5)
    >=>
        tryCatch (fun x -> divisionWithException x y) // <--------- this can throw an exception
    >=>
        tryCatch (fun x -> divisionWithException x 2)

 
printfn "8. Division with try/catch (swtich composition): \n\t%A \n\t%A"
    (tryCatch_swtichComposition 2 1200)
    (tryCatch_swtichComposition 0 1200)
    
    
let tryCatch_monadicWay y x =
    x
    |> tryCatch (fun x -> divisionWithException x 5)
    >>= tryCatch (fun x -> divisionWithException x y) // <--------- this can throw an exception
    >>= tryCatch (fun x -> divisionWithException x 2)

printfn "8. Division with try/catch (monadic way): \n\t%A \n\t%A"
    (tryCatch_swtichComposition 2 1200)
    (tryCatch_swtichComposition 0 1200)


let combineOks (s1) (s2) =
    s1 + " " + s2
let combineErrors (f1) (f2) =
    f1 + " " + f2
let switch1 input =
    if input > 0 then
        Ok "Positive"
    else
        Error "negative"
        
let switch2 input =
    if input > 10 then
        Ok "greater than 10"
    else
        Error "less than 10"

let validate_number combineOks combineErrors switch1 switch2 x =
    match (switch1 x), (switch2 x) with
    | Ok s1, Ok s2 -> Ok (combineOks s1 s2)
    | Error f1, Ok _ -> Error f1
    | Ok _, Error f2 -> Error f2
    | Error f1, Error f2 -> Error (combineErrors f1 f2)

printfn "9. Parallel validation: \n\tx = -3: %A     \n\tx = 1: %A       \n\tx = 11: %A"
    (validate_number combineOks combineErrors switch1 switch2 -3)
    (validate_number combineOks combineErrors switch1 switch2 1)
    (validate_number combineOks combineErrors switch1 switch2 11)