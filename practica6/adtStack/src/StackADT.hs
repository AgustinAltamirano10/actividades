module StackADT where

class Stack s where
    crearStack :: s a
    push :: a -> s a -> s a
    pop :: s a -> s a
    top :: s a -> a
    isEmpty :: s a -> Bool
