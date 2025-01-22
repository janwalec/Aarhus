namespace ActorsAkka

module Messages =
    type Hello =
        | Hello of string
        
    type SenderMessages =
        | Start
        | Continue
        
        
        
        
    type Username =
        | Username of string

    type Input =
        | InputSuccess of Username
        | InputError of string

    type PersonMessage =
        | LoginSuccess

    type UsersMessage = 
        | Start