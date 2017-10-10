hombre(pedro) .
hombre(manuel) .
hombre(arturo) .
mujer(maria).
padre(pedro, manuel).
padre(pedro, arturo).
padre(pedro, maria).

%niño(X,Y)//expresa que X es hijo o hija de Y.
niño(X,Y):-padre(Y,X).
%niño(X,Y),write(X+Y),nl,fail.
%niño(arturo,pedro).

%hijo(X,Y)//expresa que X es un hijo varón de Y.
hijo(X,Y):-niño(X,Y),not(mujer(X)).
%hijo(arturo,pedro). TRUE
%hijo(maria,pedro). FALSE

%hija(x,y)//expresa que X es una hija de Y.
hija(X,Y):-niño(X,Y),not(hombre(X)).
%hija(arturo,pedro). FALSE
%hija(maria,pedro). TRUE

%hermano-o-hermana(X,Y)//expresa que X es hermano o hermana de Y.
hermano_o_hermana(X,Y):-niño(X,Z),niño(Y,Z),dif(X,Y).
%hermano_o_hermana(maria,arturo). true
%hermano_o_hermana(maria,pedro). false
%hermano_o_hermana(maria,maria). false

%hermano(X,Y)//expresa que X es un hermano de Y.
hermano(X,Y):-hermano_o_hermana(X,Y),not(mujer(X)).

hermana(X,Y):-hermano_o_hermana(X,Y),not(hombre(X)).
