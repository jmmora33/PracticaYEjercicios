factorial(0,1):- !.
factorial(X,Y):- X1 is X-1, factorial(X1,Y1), Y is X*Y1,!.
