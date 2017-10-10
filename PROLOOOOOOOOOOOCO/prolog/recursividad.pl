serie_gauss(R,X):-R is (X*(X+1)/2).

fibonacci(0,1):- !.
fibonacci(1,1):- !.
fibonacci(X,F):- Z is X-1, W is X -2,
                 fibonacci(Z,Y1),fibonacci(W,Y2),
                 F is  Y1+Y2.

factorial(0,1):- !.
factorial(X,F):- Z is X-1, factorial(Z,Y), F is  X*Y.

mcd(X,X,X):-!.
mcd(X,Y,M):- X > Y, mcd(Y,X,M).
mcd(X,Y,M):- X < Y, Y1 is Y-X, mcd(X,Y1,M).

multiplicar(X,Y,Z,M):- M is (X*Y)/Z.
mcm(X,0,M):- M is X,!.
mcm(X,Y,M):- mcd(X,Y,Z),
             multiplicar(X,Y,Z,M).

