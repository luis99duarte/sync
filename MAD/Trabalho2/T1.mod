### SETS ###

set types;              # tipos de marmelada
set months;             # meses do ano de 2057
set productionLines;    # linhas de produção que a companhia dispõe

### PARAMETERS ###

param mercuryPrices {months, types} >= 0;   # previsões dos preços da marmelada em mercúrio em função do mês e do tipo 
param venusPrices   {months, types} >= 0;   # previsões dos preços da marmelada em vénus em função do mês e do tipo 
param marsPrices    {months, types} >= 0;   # previsões dos preços da marmelada em marte em função do mês e do tipo 

param productionLinesCapacity {productionLines, types} >= 0; # capacidade máxima de uma linhas de produção em função da linha e do tipo de marmelada   

### VARIABLES ###

var mercuryShipped {months, types} >= 0 integer; # unidades de marmelada enviada para mercúrio 
var venusShipped   {months, types} >= 0 integer; # unidades de marmedada enviada para vénus
var marsShipped    {months, types} >= 0 integer; # unidades de marmelada enviada para marte

var produced {months, types} >= 0 integer;
var leftOver {months, types} >= 0 integer;

### CONSTRAINTS ###

subject to mercuryMaxAmountShipped {m in months}: sum {t in types} mercuryShipped[m, t] <= 1000; # só podem ser enviadas até 1000 unidades de marmelada para mercúrio
subject to venusMaxAmountShipped   {m in months}: sum {t in types} venusShipped[m, t] <= 1000;   # só podem ser enviadas até 1000 unidades de marmelada para vénus
subject to marsMaxAmountShipped    {m in months}: sum {t in types} marsShipped[m, t] <= 1000;    # só podem ser enviadas até 1000 unidades de marmelada para marte

subject to productionLinesMaxCapacity {m in months, p in productionLines}: sum {t in types} 
produced[m, t] / productionLinesCapacity[p, t] <= 1;

subject to firstMonthProduction   {t in types}: produced[1, t] = mercuryShipped[1, t] + venusShipped[1, t] + marsShipped[1, t] + leftOver[1, t];
subject to generalMonthProduction {m in 2 .. 12, t in types}: produced[m, t] = mercuryShipped[m, t] + venusShipped[m, t] + marsShipped[m, t] + leftOver[m, t] - leftOver[m - 1, t];  

### OBJECTIVE ###

maximize revenue: sum {m in months} sum {t in types} 
( mercuryShipped[m, t]*mercuryPrices[m, t] + venusShipped[m, t]*venusPrices[m, t] + marsShipped[m, t]*marsPrices[m, t] - leftOver[m, t] - 10000);

end;
