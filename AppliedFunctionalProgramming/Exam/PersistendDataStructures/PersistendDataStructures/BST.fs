namespace PersistendDataStructures
module BST =
    type BST<'a> =
    | Empty
    | Node of left: BST<'a> * value: 'a *  right: BST<'a>
    
    let rec insert value tree =
        match tree with
        | Empty -> Node (Empty, value, Empty)
        | Node (left, v, right) when (value < v) -> Node (insert value left, v, right)
        | Node (left, v, right) when (value > v) -> Node (left, v, insert value right)
        | _ -> tree
    
    let rec contains value tree =
        match tree with
        | Empty -> false
        | Node (_, v, _) when (value = v) -> true
        | Node (left, v, _) when (value < v) -> contains value left
        | Node (_, v, right) when (value > v) -> contains value right
        | _ -> false



