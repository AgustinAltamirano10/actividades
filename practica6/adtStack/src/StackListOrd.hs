module StackListADT where
import StackADT

data Stack a = Vacio | Ins a (Stack a) -- defino el tipo recursivo

instance Set Stack where
    
    --crearStack :: Stack a
    crearStack = Vacio

    -- push :: a -> Stack a -> Stack a
    push x pila = Ins x pila

    -- pop :: s a -> s a
    pop Vacio = Vacio
    pop (Ins _ xs) = xs

    -- isEmpty :: s a -> Bool
    isEmpty Vacio = True 
    isEmpty _ = False

    -- top :: s a -> a
    top (Ins x _) = x