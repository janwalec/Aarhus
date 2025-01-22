namespace ActorsAkka
open System
open ActorsAkka.Messages
open Akka.Actor
open Akka.FSharp

module Actors=
    // SIMPLIEST ACTOR
    let helloActor msg =
        match msg with
        | "hello" -> printfn "\tHello back"
        | _ -> printfn "\tnot understand"
        
    //ACTOR WITH TYPE
    let helloActorWithType (msg: Hello) =
        match msg with
        | Hello _ -> printfn "Hello back"
        
    // ACTOR WITH MAILBOX
        
    let helloActorWithMailbox (mailbox: Actor<_>) msg =
        match msg with
        | Hello txt ->
            printfn "Hello there %s" txt
            mailbox.Sender() <! Continue    //back to whoever sent a message
            
    let senderActor sendToActor (mailbox: Actor<_>) _ =
        let txt = Console.ReadLine()
        if txt = "Exit" then
            mailbox.Context.System.Terminate() |> ignore
        else
            sendToActor <! (Hello txt)
            
            
    
    
    //ACTOR HIERARCHY
    
    let personActor (name: string) (msg: PersonMessage) =
        match msg with
        | LoginSuccess -> printfn "I have logged in ~%s" name
        
    let usersSupervisor (mailbox: Actor<UsersMessage>) =
        let user1 = spawn mailbox.Context "user1" (actorOf (personActor ("USER1")))
        let user2 = spawn mailbox.Context "user2" (actorOf (personActor ("USER2")))
        let notifications = select "/user/notifications" mailbox.Context.System
        
        let rec loop() = actor {
            let! message = mailbox.Receive()
            printfn "enter your login:"
            
            match message with
            | Start ->
                let txt = Console.ReadLine()
                if (txt = "Exit") then
                    mailbox.Context.System.Terminate() |> ignore
                else if (txt = "user1" || txt = "user2") then
                    notifications <! (InputSuccess (Username txt))
                else
                    notifications <! (InputError "Error")
            | _ -> mailbox.Unhandled message
            
            return! loop()
        }
        loop()

    let smsActor (mailbox: Actor<Username>) (msg : Username) = 
        let user = 
            match msg with 
            | Username un -> 
                select ("/user/users/" + un) mailbox.Context.System
        printfn "I am sms"
        user <! LoginSuccess
        
    let emailActor (mailbox: Actor<Username>) (msg: Username) = 
        let user = 
            match msg with
            | Username un ->
                select ("user/users/" + un) mailbox.Context.System
        printfn "I am email"
        user <! LoginSuccess
        
        
    let notificationSupervisorActor (mailbox: Actor<Input>) = 
        let sms = spawn mailbox.Context "sms" (actorOf2 smsActor)
        let email = spawn mailbox.Context "email" (actorOf2 emailActor)

        let rec loop () = actor {
            let! message = mailbox.Receive()
            match message with 
            | InputSuccess username -> email (*sms*) <! username
            | InputError txt -> mailbox.Unhandled message
            printfn "I am supervisor"
            return! loop()
        }
        loop()
        
        
    //ACTOR ROUTER
    let workerActor (mailbox: Actor<string>) =
        actor {
            let! message = mailbox.Receive()
            printfn "Worker %A received: %s" mailbox.Self message
        }

    


    
    
    