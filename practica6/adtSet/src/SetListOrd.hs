module SetListOrd where
import SetADT

data SetList a = MakeSet [a]

instance Show a => Show (SetList a) where
    show (MakeSet xs) = "MakeSet " ++ show xs


instance Set SetList where
    -- emptySet :: s a
    emptySet = MakeSet []

    -- insert :: Ord a => a -> s a -> s a
    insert y (MakeSet xs)
        | y `elem` xs = MakeSet xs
        | otherwise = MakeSet (y:xs)
    -- `elem` verificar si un elemento está en una lista

    -- contains :: Ord a => a -> s a -> Bool
    contains x (MakeSet xs)
        | x `elem` xs = True
        | otherwise = False

    -- union :: Ord a => s a -> s a -> s a 
    union (MakeSet xs) (MakeSet ys) = MakeSet (xs ++ ys)
    --se puede añadir filter (`notElem` xs) antes del ++ para añadir solo elementos que no estan en ys

    -- difference :: Ord a => s a -> s a -> s a 
    difference (MakeSet xs) (MakeSet ys) = MakeSet(filter (`notElem` ys) xs)

    -- intersection ::Ord a => s a -> s a -> s a 
    intersection (MakeSet xs) (MakeSet ys) = MakeSet(filter (`elem` xs) ys)