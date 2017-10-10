parcial1(ana,7).
parcial1(juan,4).
parcial1(pedro,2).
parcial1(hector,10).
parcial1(maria,5).
parcial2(ana,9).
parcial2(juan,8).
parcial2(pedro,4).
parcial2(hector,10).
parcial2(maria,5).


multiplicar(P,X,Y):- P is X*Y.
sumar(S,X,Y):- S is X+Y.
menor(X,Y):-  X<Y.
promedio(P,X,Y):-sumar(S,X,Y), P is S/2.

promocionaste(Nombre,Final):-parcial1(Nombre,Y),
                             parcial2(Nombre,Z),
                             Y>=7,Z>=7,
                             promedio(Final,Y,Z).
%promocionaste(Nombre,Final),write(Nombre+Final),nl,fail.

cursada(Nombre,Final):-parcial1(Nombre,Y),
                       parcial2(Nombre,Z),
                       ((Z<7,Z>=4,Y>=4);(Z>=4, Y<7, Y>=4)),
                       promedio(Final,Y,Z).
%cursada(Nombre,Final),write(Nombre+Final),nl,fail.

recursan(Nombre,Final):-parcial1(Nombre,Y),
                       parcial2(Nombre,Z),
                       (Y<4;Z<4),
                       promedio(Final,Y,Z).
%recursan(Nombre,Final),write(Nombre+Final),nl,fail.

cursada2(Nombre,Final):- parcial1(Nombre,Y),
                        parcial2(Nombre,Z),
                        not(promocionaste(Nombre,Final)),
                        not(recursan(Nombre,Final)),
                        promedio(Final,Y,Z).
%cursada2(Nombre,Final),write(Nombre+Final),nl,fail.






