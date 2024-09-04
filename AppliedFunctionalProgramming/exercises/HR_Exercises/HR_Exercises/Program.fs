let g n = n + 4;;
printf "1.1 result: %d" (g 5);;

let h (x: float, y:float) =
    System.Math.Sqrt(x*x + y*y)
    
printf "\n1.2 result %f" (h (4.0, 5.0));;

let lambda_g = fun n -> n+4;;
let lambda_h = fun (x: float, y: float) -> System.Math.Sqrt(x*x + y*y);;
printf "\n1.3 result %d" (lambda_g 5);;
printf " %f" (lambda_h (4.0, 5.0));;

let rec f = function
    | 0 -> 0
    | n -> n + f(n-1);;
printf "\n1.4 result %d" (f(5));;

let rec fib = function
    | 0 -> 0
    | 1 -> 1
    | n -> fib(n - 1) + fib(n - 2);;
printf "\n1.5 result %d" (fib(10));;


let rec sum = function
    | m, 0 -> m
    | m, n -> (m + n) + sum(m, n-1);;

printf "\n1.6 result %d" (sum(4, 5));;

let rec pow = function
    | s, 1 -> s
    | s, n -> s + pow(s, n-1)

printf "\n2.2 result %s " (pow("a", 5));;

let isItChar (str:string, i:int, ch:char) =
    if str[i] = ch then "IT IS"
    else "IT IS NOT";;

printf "\n2.3 result %s" (isItChar("abc", 1, 'c'))
    
let rec occInString = function
    | ("", _, i) -> i
    | (str, ch, i) when str[0] = ch -> occInString(str.Remove(0,1), ch, i + 1)
    | (str, ch, i) -> occInString(str.Remove(0,1), ch, i)

printf "\n2.5 result: %d" (occInString("abcdeeeff", 'e', 0))

