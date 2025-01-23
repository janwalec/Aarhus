
printfn "Type/Model based programming"

type Person = {
        Name: string
        Age: int
    }

let person1 = {Name = "John"; Age = 60}
printfn "1. Immutable data\n%A" person1 //john cannot be changed

let equal_person (p1: Person) (p2: Person) = // <> -- not equal
    if (p1.Name <> p2.Name) || (p1.Age <> p2.Age) then
        "not equal"
    else
        "equal"
let person1_to_compare = {Name = "p1"; Age = 20}
let person2_to_compare = {Name = "p2"; Age = 30}
let person3_to_compare = {Name = "p1"; Age = 20}

printfn "2. Custom equality: p1 = p2: %s p3 = p1: %s"
    (equal_person person1_to_compare person2_to_compare)
    (equal_person person3_to_compare person1_to_compare)


type Point = {
    X: int;
    Y: int;
}

let A = {X = 1; Y = 2}
let B = {X = 1; Y = 3}
let C = {X = 4; Y = 1}

printfn "3.Ordering: \n\tA < B: %b \n\tC > B: %b \n\tC < A: %b"
    (A < B)
    (C > B)
    (C < A)
type Shape =
    | Circle of float
    | Rectangle of float * float
    | Square of float

let cr1 = Circle 5.0
let r1 = Rectangle (5.0, 2.0)
let s1 = Square 5.0
printfn "4. Different types: \n\t%A \n\t%A \n\t%A" cr1 r1 s1

let area shape =
    match shape with
    | Circle r -> 3.14 * r * r
    | Rectangle (w, h) -> w * h
    | Square a -> a * a
    
printfn "5. Calculated areas: \n\t%A \n\t%A \n\t%A" (area cr1) (area r1) (area s1)
    

let (|Even|Odd|) (num: int) =
    if (num % 2 = 0) then
        Even
    else
        Odd

let match_number x =
    match x with
    | Even -> printfn "\t%d is an even number" x
    | Odd -> printfn "\t%d is an odd number" x

printfn "6. Active pattern"
match_number 3
match_number 4

let (|IsPositive|_|) (num: int) =
    if (num > 0) then
        Some num
    else
        None
let match_positive x =
    match x with
    | IsPositive x -> printfn "\t%d is a positive number" x
    | _ -> printfn "\t%d is a negative number" x
    
printfn "7. Partially-Active pattern"
match_positive 7
match_positive -3



//https://fsharpforfunandprofit.com/posts/monoids-without-tears/
printfn "\nMonoids"

printfn "8. Benefit of closure: %A" ([ 1; 2; 3; 4 ] |> List.reduce (*))  //pairwise operation

let sum1To2 = 1 + 2
let sum3To4 = 3 + 4
let sum1To4 = sum1To2 + sum3To4
printfn "9. Benefit of associativity: %A %A %A" sum1To2 sum3To4 sum1To4 //parallelization


// let emptyList = [] |> List.reduce (+) // ERROR
let explicitZero = [] |> List.fold (+) 0 // fold empty list with initial elemnt of 0
printfn "10. Benefit of identity: %A" explicitZero
    
