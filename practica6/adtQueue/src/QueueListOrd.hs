module SetListOrd where
import QueueADT

type Queue a = [a] -- trabaja directamente con listas
data Queue a = Vacio | Ins a (Queue a) -- defino el tipo recursivo

instance Set Queue where

module QueueADT where
    -- crearQueue :: s a
    crearQueue = Vacio

    -- enqueue :: a -> s a -> s a
    enqueue x (Queue xs) = Queue (xs ++ [x])

    -- dequeue :: q a -> q a
    dequeue (Queue []) = Queue []
    dequeue (Queue (x:xs)) = Queue xs 

    -- isEmpty :: q a -> Bool
    isEmpty (Queue []) = True
    isEmpty _ = False