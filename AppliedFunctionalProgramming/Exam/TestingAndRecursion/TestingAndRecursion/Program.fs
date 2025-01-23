open FsCheck
open FsCheck.Xunit

printfn "Recusrion"
let rec factorial n =
    match n with
    | 0 -> 1
    | n -> n * factorial (n - 1)
    

printfn "1. Factorail: %A" (factorial 5)

let rec sum_list lst =
    match lst with
    | [] -> 0
    | head::tail -> head + (sum_list tail)

printfn "2. Sum list: %A" (sum_list [2; 4; 8; 16])


let tail_recursive_factorial n =
    let rec loop n acc =
        match n with
        | 0 -> acc
        | x -> loop (x - 1) (acc * x)
    loop n 1
    
printfn "3. Not-tail: %A; Tail: %A" (factorial 5) (tail_recursive_factorial 5)


let rec bigList = function
    | 0 -> []
    | n -> (n - 1) :: (bigList (n-1))

printfn "4. Big list, not-tail: %A" (bigList 5)    
  
printfn "5."
let rec bigListC continuationFun = function
    | 0 -> continuationFun []  
    | n -> bigListC            
             ( fun res ->      // Create a new continuation function
                 printfn "\tres: %A; execute: %A" (res) (n - 1)
                 continuationFun ((n - 1) :: res)
             )
             (n - 1)           // Call recursively with n - 1
    
printfn "5. Big list with continuation function: %A" (bigListC (fun a -> a) (5))

//bigList 1000000 //stack overflow

let reverse_list lst =
    let rec loop lst acc =
        match lst with
        | [] -> acc
        | head::tail -> loop tail (head :: acc)
    loop lst []

printfn "6. Tail recursive and accumulator: %A" (reverse_list [1; 2; 3; 4])





printfn "\nFSCheck\n7. property based:"
let add x y = x + y// correct implementation

[<Property>]
let commutativeProperty (x,y) =
  let result1 = add x y
  let result2 = add y x
  result1 = result2
Check.Quick commutativeProperty



[<Property>]
let addTwiceProperty x y =
    let result1 = x |> add y |> add y
    let result2 = x |> add (2 * y)
    result1 = result2
Check.Quick addTwiceProperty

[<Property>]
let addZeroProperty (x) =
    let result1 = x |> add 0
    result1 = x
Check.Quick addZeroProperty

[<Property>]
let associativeProperty x y z =
    let result1 = add (add x y) z
    let result2 = add x (add y z)
    result1 = result2
Check.Quick associativeProperty

printfn "8. Example based"
//EXAMPLE BASED
[<Property>]
let addTwicePropertyExampleBased x =
    let result1 = x |> add 1 |> add 1
    let result2 = x |> add 2
    result1 = result2
Check.Quick addTwicePropertyExampleBased


printfn "9. Lazy"
let tooEager a = a <> 0 ==> (1/a = 1/a) // throws exception
let moreLazy a = a <> 0 ==> (lazy (1/a = 1/a))

Check.Quick moreLazy
