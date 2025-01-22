open System
open System.Threading

//https://fsharpforfunandprofit.com/posts/concurrency-reactive/
printfn "1. Simple event"
let createTimer (timerInterval, eventHandler) =
    let timer = new System.Timers.Timer(float timerInterval)
    timer.AutoReset <- true // fires events repeatedly (in intervals)

    timer.Elapsed.Add eventHandler

    // return an async task
    async {
        timer.Start()
        do! Async.Sleep 3000
        timer.Stop()
        }

let basicHandler _ = printfn "\ttick %A" DateTime.Now
let basicTimer1 = createTimer (1000, basicHandler)

//  Async.RunSynchronously basicTimer1




printfn "2. Built in observable"

let createTimerAndObservable timerInterval =
    let timer = new System.Timers.Timer(float timerInterval)
    timer.AutoReset <- true

    let observable = timer.Elapsed

    let task = async {
        timer.Start()
        do! Async.Sleep 5000
        timer.Stop()
    }

    (task,observable)
    
let basicTimer2, timerEventStream = createTimerAndObservable 1000

timerEventStream
|> Observable.subscribe (fun _ -> printfn "\ttick %A" DateTime.Now)

//Async.RunSynchronously basicTimer2


printfn "3. Piping events"
let timerCount2, timerEventStream2 = createTimerAndObservable 500

timerEventStream2
|> Observable.scan (fun count _ -> count + 1) 0
//|> Observable.filter (fun count -> count % 2 = 0)
//|> Observable.map (fun count -> count * 10)
|> Observable.subscribe (fun count -> printfn "\ttimer ticked with count %i" count)

//Async.RunSynchronously timerCount2



printfn "4. Merging event streams"
let toMergeTimer1, toMergeEventStream1 = createTimerAndObservable 1000
let toMergeTimer2, toMergeEventStream2 = createTimerAndObservable 200

let mergedStream = Observable.merge toMergeEventStream1 toMergeEventStream2

mergedStream
|> Observable.subscribe (fun _ -> printfn "\ttick %A" DateTime.Now)

//Async.RunSynchronously toMergeTimer1
//Async.RunSynchronously toMergeTimer2

printfn "5. Running merged event streams in parallel"

//[toMergeTimer1;toMergeTimer2]
//|> Async.Parallel
//|> Async.RunSynchronously
