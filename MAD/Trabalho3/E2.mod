set T;                              # Types
set O;                              # Operations

param W;                            # Number of weeks
param H;                            # Hold cost 
param B;                            # Backlog Cost
param S;                            # Setup Cost
param M;                            # Big M
param F{w in 1..W, t in T} >= 0;    # Forecast
param P{o in O, t in T} >= 0;       # Production Lines Capacity

var produced{w in 1..W, t in T} >= 0;
var inventory{w in 0..W, t in T} >= 0;
var delivered{w in 1..W, t in T} >= 0;
var backlogged{w in 0..W, t in T} >= 0;
var setupChecker{w in 0..W, t in T} binary;     # Flag que decide se pagamos setupCost ou não

subject to DomainR{t in T}: sum{w in 1..W} produced[w, t] = sum{w in 1..W} F[w, t];     # Production = orders

subject to ProductionLinesR{o in O, w in 1..W}: sum{t in T} produced[w, t] / P[o, t] <= 1;      # Maximum produced <= than available in Production Lines

subject to FirstWeekInventoryR{t in T}: inventory[0, t] = 0; 
subject to FirstWeekBackloggedR{t in T}: backlogged[0, t] = 0;
subject to LastWeekBackloggedR{t in T}: backlogged[W, t] = 0;
subject to GeneralWeekR{w in 1..W, t in T}: produced[w, t] + inventory[w - 1, t] = F[w, t] + backlogged[w - 1, t] - backlogged[w, t] + inventory[w, t];     # Esta restrição trata do inventário e do backlog simultaneamente

subject to SetupCheckerR{w in 1..W, t in T}: produced[w, t] <= M * setupChecker[w, t];      # Semanas e tipos que precisam de Setup

subject to CleaningProblemR{w in 1..W}: sum{t in T} setupChecker[w, t] <= 2;        # Não posso produzir mais que 2 tipos diferentes por semanas

subject to RI1R{w in 1..W}: setupChecker[w, 'R'] + setupChecker[w, 'I'] <= 1;       # Não posso produzir tipos R e I na mesma semana

subject to FirstRI2R: setupChecker[0, 'R'] = 0;
subject to RI2R{w in 1..W}: setupChecker[w - 1, 'R'] + setupChecker[w, 'I'] <= 1;   # Não posso produzir o tipo I se na semana anterior produzi R

minimize C: sum{w in 1..W, t in T} (setupChecker[w, t] * S + inventory[w, t] * H + backlogged[w, t] * B);