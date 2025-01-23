namespace PersistendDataStructures
module main= 
    open BST
    
    
    type Person = {Age: int; Name: string}
    let p1 = {Age = 30; Name = "John"}
    let p1_changed_age = {p1 with Age = 31}
    printfn "1. Copying immutable data structure: \n\t%A \n\t%A" (p1) (p1_changed_age)
    
    
    // ##################################### BST
        
    let tree1 = Empty
    let tree2 = insert 10 tree1
    let tree3 = insert 5 tree2
    let tree4 = insert 6 tree3
    printfn "2. BTS: \n\t%A \n\tContains 6?: %b" (tree4) (contains 6 tree4)

    
    // ##################################### SET
    let s1 = set [
        7;          //<--- big number at the front
        1; 1; 1;    //<--- duplicates
        3; 4; 5
    ]
    printfn "3. Set creation, ordering, duplicates: %A" s1
    
    let s2 = Set.ofList [7; 1; 1; 1; 3; 4; 5]
    printfn "4. Set of list creation: %A" s2
    
    let s2' = Set.add 7 s2 //<--- number already in the set
    let s2'' = Set.add 2 s2' //<--- should be inserted between 1 and 3
    let s2''' = Set.remove 3 s2''
    
    printfn "5. Set operations \n\tAdd existing element: %A \n\tAdd not existing element: %A \n\tRemove existing element: %A" s2' s2'' s2'''
    
    let first_set = set ["a"; "b"; "c"]
    let second_set = set ["d"; "e"]
    let third_set = set ["c"; "d"]
    
    let set_union = Set.union first_set second_set
    let set_intersection = Set.intersect first_set third_set
    let set_difference = Set.difference  first_set third_set
    
    printfn "6. Operations on multiple sets \n\tUnion: %A \n\tIntersection: %A \n\tDifference: %A" (set_union) (set_intersection) (set_difference)
    
    
    
    let words_set = set ["hello"; "there"; "general"; "kenobi"]
    let length_of_words_set = Set.map (fun x -> String.length x) words_set
    let count_value_from_set = Set.fold (fun acc x -> acc + x) 0 length_of_words_set
    
    printfn "7. Words set: %A" words_set
    printfn "\tMap: %A" length_of_words_set
    printfn "\tFold: %A" count_value_from_set
    
    
    // #####################################  MAP
    let empty_map1 = Map.empty
    let map1 = empty_map1.Add(2, "Two").Add(1, "One").Add(3, "Something_but_not_three") // <-- elements are not sorted here (2, 1, 3)
    let map2 = map1.Add(3, "Three")
    printfn "8. Creation of a map: %A \n\tInserting element with the same key: %A"
        map1
        map2
        
    
    let create_string_with_fold = Map.fold (fun acc key value -> acc + $"{value};") "" map2
    let create_string_with_foldBack = Map.foldBack (fun key value acc -> acc + $"{value};") map2 ""
    
    printfn "9. \n\tFold: %s \n\tFoldBack: %s" create_string_with_fold create_string_with_foldBack
    
    
    // ##################################### EQUALITY
    let list1 = [1; 2; 3]
    let list2 = [1; 2; 3]
    let list3 = [2; 3; 1]
    printfn "10. Equality for lists \n\tl1 = l2: %b \n\tl1 = l3: %b" (list1 = list2) (list1 = list3)
    
    let set1 = set [1; 2; 3]
    let set2 = set [1; 2; 3]
    let set3 = set [2; 3; 1]
    
    printfn "11. Equality for sets \n\ts1 = s2: %b \n\ts1 = s3: %b" (set1 = set2) (set1 = set3)


    // ##################################### SEQUENCES
    let seq1 = seq [10; 17; 3; 4; 5; 1; 1]
    printfn "12. Simpliest sequence: %A" seq1
    let nat = Seq.initInfinite (fun i -> 2 * i)
    printfn "13. Inifinite sequence: %A" nat
    
    printfn "14. Give me 123th element: %A" (Seq.item 123 nat)
    
    let cashedNat = Seq.cache nat
    printfn "15. Give me 123th element from cashedNat: %A" (Seq.item 123 cashedNat)
    
    
    
    // ##################################### LISTS
    let rec sum_list lst =
        match lst with
        | [] -> 0
        | head::tail -> head + (sum_list tail)

    let list_1 = [2; 4; 8; 16]
    printfn "16. Sum list (head and tail): %A" (sum_list list_1)
    
    printfn "17. Sum list with fold: %A" (List.fold (fun acc value -> acc + value) 0 list_1)
    
    printfn "18. Map over list: %A" (List.map (fun x -> x * 3) list_1)
    
    let list_2 = [2; 5; 8; 17]
    
    printfn "19. Concatenated lists: %A" (list_1 @ list_2)
    
    let intersection l1 l2 = List.filter (fun x -> List.contains x l1) l2
    
    printfn "20. Intersection: %A" (intersection list_1 list_2)
    
    let difference l1 l2 = List.filter (fun x -> not (List.contains x l2)) l1
    
    printfn "21. Difference: \n\t%A \n\t%A" (difference list_1 list_2) (difference list_2 list_1)
    
    printfn "22. Difference using set: %A" (Set.difference (Set.ofList list_1) (Set.ofList list_2))
    