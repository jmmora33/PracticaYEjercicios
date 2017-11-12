%Fibo: 1,1,2,3,5,8,13,21,34,55,89,144...

fibonacci(0,0):-!.
fibonacci(1,1):-!.
fibonacci(2,1):-!.
fibonacci(X,Y):- X1 is X-1, X2 is X-2, fibonacci(X1,Y1), fibonacci(X2,Y2), Y is Y1+Y2.
