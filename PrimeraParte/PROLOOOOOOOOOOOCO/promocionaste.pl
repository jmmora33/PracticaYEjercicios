parcial1(ana,7).
parcial1(juan,4).
parcial1(agustin,8).
parcial1(ezequiel,7).
parcial1(figo,9).
parcial1(ronaldo,10).
parcial1(fede,7).

parcial2(figo,8).
parcial2(ronaldo,7).
parcial2(fede,2).
parcial2(ana,9).
parcial2(juan,8).
parcial2(agustin,3).
parcial2(ezequiel,7).

suma(S,X,Y):-S is X+Y.
division(D,X,Y):-D is X/Y.
promedio(P,X,Y):-P is ((X+Y)/2.00).
promedio2(P,X,Y):-suma(S,X,Y),division(P,S,2.00).

promocionan(NOM,NOTA):-parcial1(NOM,N1),N1>=7,parcial2(NOM,N2),N2>=7,
                       promedio(NOTA,N1,N2).
cursan(NOM,NOTA):-parcial1(NOM,N1),parcial2(NOM,N2),N1>=4,N2>=4,(N1<7 ; N2 <7),
                  promedio(NOTA,N1,N2).
recursan(NOM,NOTA):-parcial1(NOM,N1),parcial2(NOM,N2),(N1<4 ; N2<4),
                  promedio(NOTA,N1,N2).

prodCart(X,Y,Z,W):- promocionan(X,Y), promocionan(Z,W).
seleccion(X,Y,Z,W):- prodCart(X,Y,Z,W), Y<W.
proyeccion(X,Y):- seleccion(X,Y,_,_).
medallaDeHonor(X,Y):- promocionan(X,Y), not(proyeccion(X,Y)).
