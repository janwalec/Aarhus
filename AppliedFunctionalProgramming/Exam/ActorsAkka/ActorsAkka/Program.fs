open System
open ActorsAkka.Messages
open Akka.FSharp
open Akka.Actor
open ActorsAkka.Actors
open Akka.Routing

    
let actorSystem = System.create "ActorSystem" (Configuration.load())
let actor1 = spawn actorSystem "HelloActor" (actorOf helloActor)

// ####################### SIMPLIEST ACTOR
//actor1 <! "hello"
//actor1 <! "not hello"




// ####################### ACTOR PATH
let actorRef = actorSystem.ActorSelection("/user/HelloActor")
//actorRef <! "hello"




// ####################### ACTOR WITH TYPE
let typeActor = spawn actorSystem "HelloActorWithType" (actorOf helloActorWithType)
//typeActor <! Hello "Hello"
//typeActor <! "Hello"



// ####################### ACTOR WITH MAILBOX
let mailboxActor = spawn actorSystem "HelloActorWithMailbox" (actorOf2 helloActorWithMailbox)
let sender = spawn actorSystem "SenderActor" (actorOf2 (senderActor mailboxActor))

//sender <! Start
//actorSystem.WhenTerminated.Wait()




// ####################### ACTOR HIERARCHY
let actorSystem2 = System.create "ActorSystem2" (Configuration.load())

//optional (parameters) spawn
let users = spawnOpt actorSystem "users" usersSupervisor [SpawnOption.SupervisorStrategy(Strategy.OneForOne( 
                                                            (fun error -> match error with
                                                                           | :? ArithmeticException -> Directive.Resume
                                                                           | _ -> Directive.Restart    ))) ]
let notificationSupervisor = spawnOpt actorSystem "notifications" notificationSupervisorActor [SpawnOption.SupervisorStrategy(Strategy.OneForOne( 
                                                            (fun error -> match error with
                                                                           | :? ArithmeticException -> Directive.Resume
                                                                           | _ -> Directive.Restart    ))) ]
//users <! Start
//actorSystem2.WhenTerminated.Wait()


// ####################### ACTOR ROUTER
let routerActor = spawnOpt actorSystem "router" workerActor [ SpawnOption.Router(RoundRobinPool(10)) ]
//routerActor <! Broadcast ("passing it to every worker")
//routerActor <! PoisonPill.Instance
