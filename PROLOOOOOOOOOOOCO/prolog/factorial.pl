factorial(0,1):- !.
factorial(X,F):- Z is X-1, factorial(Z,Y), F is  X*Y.

fibonacci(0,1):- !.
fibonacci(1,1):- !.
fibonacci(X,F):- Z is X-1, W is X -2,
                 fibonacci(Z,Y1),fibonacci(W,Y2),
                 F is  Y1+Y2.


