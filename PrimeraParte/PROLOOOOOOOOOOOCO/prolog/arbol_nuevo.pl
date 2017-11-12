hombre(pedro) .
hombre(manuel) .
hombre(arturo) .
mujer(mar�a).
padre(pedro, manuel).
padre(pedro, arturo).
padre(pedro, mar�a).

%ni�o(X,Y)//expresa que X es hijo o hija de Y.
ni�o(X,Y):-padre(Y,X).
%ni�o(X,Y),write(X+Y),nl,fail.
%ni�o(arturo,pedro).

%hijo(X,Y)//expresa que X es un hijo var�n de Y.
hijo(X,Y):-ni�o(X,Y),not(mujer(X)).
