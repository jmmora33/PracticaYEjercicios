es_un_pais(argentina). %hecho
es_un_pais(chile). %hecho
es_un_pais(paraguay).
es_un_pais(bolivia).
es_un_pais(brasil).
es_un_pais(ecuador).
es_un_pais(peru).
es_un_pais(venezuela).
es_un_pais(colombia).

limita_con(argentina,chile).%hecho
limita_con(argentina,brasil).%hecho
limita_con(paraguay,argentina).
limita_con(uruguay,argentina).
limita_con(brasil,uruguay).
limita_con(colombia,peru).
limita_con(colombia,ecuador).
limita_con(venezuela,colombia).
limita_con(colombia,brasil).

%regla Compuesta  cabeza(argumento)
son_limitrofes(X,Y):-limita_con(X,Y); limita_con(Y,X).

son_translimitrofes(X,Y):-son_limitrofes(X,Z),
                          son_limitrofes(Z,Y),
                          not(son_limitrofes(X,Y)),
                          dif(X,Y).



