%clauses

entrada(paella).
entrada(gazpacho).
entrada(consom�).

carne(filete_de_cerdo).
carne(pollo_asado).

pescado(trucha).
pescado(bacalao).

postre(flan).
postre(helado).
postre(pastel).

%fin clauses

menu(X,Y,Z):-entrada(X),
            (carne(Y);pescado(Y)),
            postre(Z).
%menu(X,Y,Z),X==consome,write(X+Y+Z),nl,fail

menu_consome(Y,Z):-entrada(consom�),
            (carne(Y);pescado(Y)),
            postre(Z).
%menu(X,Y,Z),X==consom�,write(X+Y+Z),nl,fail.
%menu_consome(Y,Z),write(consom�+Y+Z),nl,fail.


menu_sin_flan(X,Y,Z):-entrada(X),
                     (carne(Y);pescado(Y)),
                      postre(Z),not(Z==flan).
