
printfn "Type/Model based programming"

type Person = {
        Name: string
        Age: int
    }

let person1 = {Name = "John"; Age = 60}
printfn "1. Immutable data\n%A" person1 //john cannot be changed


type Shape =
    | Circle of float
    | Rectangle of float * float
    | Square of float

let cr1 = Circle 5.0
let r1 = Rectangle (5.0, 2.0)
let s1 = Square 5.0
printfn "2. Different types: \n\t%A \n\t%A \n\t%A" cr1 r1 s1

let area shape =
    match shape with
    | Circle r -> 3.14 * r * r
    | Rectangle (w, h) -> w * h
    | Square a -> a * a
    
printfn "3. Calculated areas: \n\t%A \n\t%A \n\t%A" (area cr1) (area r1) (area s1)
    


//https://fsharpforfunandprofit.com/posts/monoids-without-tears/
printfn "\nMonoids"

printfn "4. Benefit of closure: %A" ([ 1; 2; 3; 4 ] |> List.reduce (*))  //pairwise operation

let sum1To2 = 1 + 2
let sum3To4 = 3 + 4
let sum1To4 = sum1To2 + sum3To4
printfn "5. Benefit of associativity: %A %A %A" sum1To2 sum3To4 sum1To4 //parallelization


// let emptyList = [] |> List.reduce (+) // ERROR
let explicitZero = [] |> List.fold (+) 0
printfn "6. Benefit of identity: %A" explicitZero

