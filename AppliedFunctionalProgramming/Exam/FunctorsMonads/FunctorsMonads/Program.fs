// FUNCTORS
let list = [1; 2; 3]
let list_addition = List.map (fun x -> x + 3) list
printfn "1. List before fmap: %A, list after fmap: %A" list list_addition

let some_value = Some 5
let some_transformation = Option.map (fun x -> x * 2) some_value
printfn "2. Some before: (%A), some after: (%A)" some_value some_transformation

let nothing = None
let nothing_transformation = Option.map (fun x -> x * 3 * 4 * 5) nothing
printfn "3. Nothing before: %A, nothing after: %A" nothing nothing_transformation

// Other functions
let some_string = Some "hello"
let length_of_some_string = Option.map String.length some_string
printfn "4. Some string: %A, some string length: %A" some_string length_of_some_string 




printfn "\nFunctor laws"
let the_same x = x
let the_same_transformation = the_same list
printfn "5. List %A After the same transformation: %A" list the_same_transformation


let transformation1 x = x + 1
let transformation2 x = x * 2

let oneMap = List.map (transformation1 >> transformation2) list
let twoMaps = ((List.map transformation1) >> (List.map transformation2)) list

printfn "6. One map: %A Two maps %A" oneMap twoMaps

printfn "7. Other way %A; %A" (list |> List.map transformation1 |> List.map transformation2) (List.map (transformation1 >> transformation2) list)














printfn "\nApplicatives"

//fOpt -- an option that contains a function (Some (fun x -> x + 1)
//xOpt -- contains a value (Some 2)
// <*> -- Infix Operator
let (<*>) fOpt xOpt =
    match fOpt, xOpt with
    | Some f, Some x ->  Some (f x)
    | _ -> None

let add x y = x + y
let a = Some 2
let b = Some 3
let partially_applied_function = Some add <*> a
printfn "8. Partially applied function: %A" partially_applied_function

let fully_applied_function = Some add <*> a <*> b
printfn "9. Fully applied function (result): %A" fully_applied_function

let apply fOpt xOpt =
    match fOpt, xOpt with
    | Some f, Some x -> Some (f x)
    | _ -> None
    
//apply (Some add) a -- partially applied
let different_syntax_apply = apply (apply (Some add) a) b
printfn "10. Different syntax apply: %A" fully_applied_function







printfn "\nApplicatives laws"

let pure x = Some x //wrap function
let id x = x
let jus_some_v = Some 42

//Identity: pure id <*> v = v
printfn "11. Identity: %A" (pure id <*> jus_some_v = jus_some_v)


//Composition: u <*> v <*> w = u <*> (v <*> w)
let u = Some (fun x -> x + 1)
let v = Some(fun x -> x * 2)
let w = Some 3
let composition f g x = f (g x)
printfn "12. Composition %A" (
    (pure composition <*> u <*> v <*> w) = (u <*> (v <*> w))
    )


//Homomorphism: pure f <*> v = pure (f v)
let just_one x = x + 1

printfn "13. Homomorphism %A" (
    (pure just_one) <*> (Some 3) = pure (just_one 3)
    )
 

//Interchange: l <*> pure y = pure (fun a -> a y) <*> l

let l = Some (fun x -> x * 2)
let y = 3
printfn "14. Interchange %A" (
    (l <*> pure y) = (pure (fun f -> f y) <*> l)
    )








// MONADS

printfn "\nMonads"
let bind f opt =
    match opt with
    | Some x -> f x
    | None -> None

let some_function = fun x -> Some (x + 1) // returns a wrapped value

printfn "15. Just add 1: %A" (some_function 5)
//some_function (Some 5) //cannot do that, why? => handle what's inside "Some"
printfn "    Add some 1: %A" (Some 5 |> bind (some_function))

// Example problem from the lecture
let hard_to_write_add (a: int option) (b: int option) (c: int option) =
    match a with
    | None -> None
    | Some aa -> 
        match b with
        | None -> None
        | Some bb -> 
            match c with
            | None -> None
            | Some cc -> Some(aa + bb + cc)

let monadic_add (a: int option) (b: int option) (c: int option) =
    a |> bind (fun aa ->
        b |> bind (fun bb ->
            c |> bind (fun cc ->
                Some (aa + bb + cc)) ))

let option_add (a: int option) (b: int option) (c: int option) =
    a |> Option.bind (fun aa ->
        b |> Option.bind (fun bb ->
            c |> Option.bind (fun cc ->
                Some (aa + bb + cc)) ))

printfn "16. Hard add: %A ; Monadic add: %A ; Option add: %A" 
    (hard_to_write_add (Some 1) (Some 2) (Some 3))
    (monadic_add (Some 1) (Some 2) (Some 3))
    (option_add (Some 1) (Some 2) (Some 3))
    
    
let bind_list f lst =
    List.collect f lst // concatenate result

let some_list_function = fun x -> [x; x * 2]

printfn "17. Bind list: %A" ([1; 2; 3] |> bind_list some_list_function)



printfn "\nMonadic laws"
let f_1 x = Some (x + 1)
let f_2 x = Some (x * 2)
let some_return x = Some x

printfn "18. Left identity: %A" (
    bind f_1 (Some 5) = some_function 5
    ) //return x >>= f = f x


printfn "19. Right identity: %A" (
    bind some_return (Some 5) = Some 5
    ) // m >>= return = m
   

printfn "20. Associativity: %A" (
    bind f_2 (bind f_1 (Some 5)) = bind (fun x -> bind f_2 (f_1 x)) (Some 5)
    )   // (m >>= f) >>= g        =        m >>= (λx→f(x) >>= g)



    
    