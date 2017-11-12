hombre(pedro) .
hombre(manuel) .
hombre(arturo) .
mujer(maria).
padre(pedro, manuel).
padre(pedro, arturo).
padre(pedro, maria).

%ni�o(X,Y)//expresa que X es hijo o hija de Y.
ni�o(X,Y):-padre(Y,X).
%ni�o(X,Y),write(X+Y),nl,fail.
%ni�o(arturo,pedro).

%hijo(X,Y)//expresa que X es un hijo var�n de Y.
hijo(X,Y):-ni�o(X,Y),not(mujer(X)).
%hijo(arturo,pedro). TRUE
%hijo(maria,pedro). FALSE

%hija(x,y)//expresa que X es una hija de Y.
hija(X,Y):-ni�o(X,Y),not(hombre(X)).
%hija(arturo,pedro). FALSE
%hija(maria,pedro). TRUE

%hermano-o-hermana(X,Y)//expresa que X es hermano o hermana de Y.
hermano_o_hermana(X,Y):-ni�o(X,Z),ni�o(Y,Z),dif(X,Y).
%hermano_o_hermana(maria,arturo). true
%hermano_o_hermana(maria,pedro). false
%hermano_o_hermana(maria,maria). false

%hermano(X,Y)//expresa que X es un hermano de Y.
hermano(X,Y):-hermano_o_hermana(X,Y),not(mujer(X)).

hermana(X,Y):-hermano_o_hermana(X,Y),not(hombre(X)).
