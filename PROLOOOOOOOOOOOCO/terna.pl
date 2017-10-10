numero(-1).
numero(-2).
numero(-3).
numero(-4).
numero(-5).
numero(-6).
numero(-7).
numero(-8).
numero(-9).
numero(-10).
numero(1).
numero(2).
numero(3).
numero(4).
numero(5).
numero(6).
numero(7).
numero(8).
numero(9).
numero(10).

terna(X,Y,Z):- numero(X),numero(Y),numero(Z).

%funcionModulo

menorCero(X,Y):- Y is -X.
igualCero(X):- X is 0.
mayorCero(X,Y):- Y is X.

modulo(X,Y):- X==0, igualCero(Y); X<0, menorCero(X,Y); X>0, mayorCero(X,Y).

%MetodoDelProfe
moduloProf(X,Y):- X<0, Y is -1*X,!.
moduloProf(X,0):- X==0,!.
moduloProf(X,X):- X>0.


prodCart(X,Y):- numero(X),numero(Y).
%Maximo
seleccionMax(X,Y):- prodCart(X,Y), X<Y.
proyeccionMax(X):- seleccionMax(X,_).
maximo(X):- numero(X),not(proyeccionMax(X)).

%Minimo
seleccionMin(X,Y):- prodCart(X,Y), X>Y.
proyeccionMin(X):- seleccionMin(X,_).
minimo(X):- numero(X),not(proyeccionMin(X)).

%MesConMayorImporte

ventas(enero,1000).
ventas(febrero,9000).
ventas(marzo,2000).
ventas(abril,3000).

prodCartVent(X,Y,Z,W):- ventas(X,Y),ventas(Z,W).

seleccionMaxVent(X,Y,Z,W):- prodCartVent(X,Y,Z,W), Y<W.
proyeccionMaxVent(X):- seleccionMaxVent(X,_,_,_).
maxVent(X):- ventas(X,_), not(proyeccionMaxVent(X)).

seleccionMinVent(X,Y,Z,W):- prodCartVent(X,Y,Z,W), Y>W.
proyeccionMinVent(X):- seleccionMinVent(X,_,_,_).
minVent(X):- ventas(X,_), not(proyeccionMinVent(X)).

