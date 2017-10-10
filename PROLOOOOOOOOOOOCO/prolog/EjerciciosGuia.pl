%Ejercicio 1.
%clauses

entrada(paella).
entrada(gazpacho).
entrada(consomé).

carne(filete_de_cerdo).
carne(pollo_asado).

pescado(trucha).
pescado(bacalao).

postre(flan).
postre(helado).
postre(pastel).

bebida(vino).
bebida(agua).
bebida(gaseosa).


%fin clauses

%Reglas
menu(X,Y,Z):- entrada(X),
             (carne(Y);pescado(Y)),
             postre(Z).
%Consultas
%menu(X,Y,Z),X==consome,write(X+Y+Z),nl,fail.

menu_sin_flan(X,Y,Z):-entrada(X),
                     (carne(Y);pescado(Y)),
                      postre(Z),not(Z==flan).

menu_con_bebida(X,Y,Z,W):- entrada(X),
               (carne(Y);pescado(Y)),
               postre(Z),
               bebida(W).



%Ejercicio2.
%Clauses

hombre(manuel) .
hombre(arturo) .
hombre(pedro).
mujer(maria).
padre(pedro, manuel).
padre(pedro, arturo).
padre(pedro, maria) .

%reglas
niño(X,Y):-padre(Y,X).

hijo(X,Y):-niño(X,Y),
        not(mujer(X)).

hija(X,Y):-niño(X,Y),
           not(hombre(X)).

hermano_a(X,Y):-niño(X,Z),
                niño(Y,Z),
                dif(X,Y).

hermano(X,Y):-niño(X,Z),
              niño(Y,Z),
              dif(X,Y),
              not(mujer(X)).

hermana(X,Y):-niño(X,Z),
              niño(Y,Z),
              dif(X,Y),
              not(hombre(X)).


















