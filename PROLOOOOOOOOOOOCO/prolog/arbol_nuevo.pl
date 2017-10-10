hombre(pedro) .
hombre(manuel) .
hombre(arturo) .
mujer(maría).
padre(pedro, manuel).
padre(pedro, arturo).
padre(pedro, maría).

%niño(X,Y)//expresa que X es hijo o hija de Y.
niño(X,Y):-padre(Y,X).
%niño(X,Y),write(X+Y),nl,fail.
%niño(arturo,pedro).

%hijo(X,Y)//expresa que X es un hijo varón de Y.
hijo(X,Y):-niño(X,Y),not(mujer(X)).
