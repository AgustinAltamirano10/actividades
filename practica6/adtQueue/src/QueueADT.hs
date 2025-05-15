module QueueADT where

class Queue s where
    crearQueue :: s a
    enqueue :: a -> s a -> s a
    dequeue :: q a -> q a
    isEmpty :: q a -> Bool
