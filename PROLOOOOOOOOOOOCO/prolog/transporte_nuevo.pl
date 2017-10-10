%clauses
transporte(roma,20).
transporte(londres,30).
transporte(tunez,10).

alojamiento(roma,hotel,50).
alojamiento(roma,hostal,30).
alojamiento(roma,camping,10).
alojamiento(londres,hotel,60).
alojamiento(londres,hostal,40).
alojamiento(londres,camping,20).
alojamiento(tunez,hotel,40).
alojamiento(tunez,hostal,20).
alojamiento(tunez,camping,5).
%finclauses
multiplicar(P,X,Y):- P is X*Y.
sumar(S,X,Y):- S is X+Y.
menor(X,Y):-  X<Y.

%viaje(C,S,H,P) que se interpreta por: el viaje a la ciudad C
%Durante S semanas con estancia en H cuesta P pesos.
viaje(C,S,H,P):-alojamiento(C,H,X),
                multiplicar(M,X,S),
                transporte(C,Y),
                sumar(P,M,Y).
%viaje(roma,2,hostal,P),write(P).


% viajeeconomico(C,S,H,P,Pmax) que expresa que el costo P es menor
% quePmax pesos.
viajeeconomico(C,S,H,P,Pmax):-viaje(C,S,H,P),menor(P,Pmax).
%viajeeconomico(C,2,H,P,81),write(C+H+P),nl,fail.
