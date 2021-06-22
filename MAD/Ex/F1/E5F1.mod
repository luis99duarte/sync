option solver gurobi;

var x >= 0; # horas a produzir fitas
var y >= 0; # horas a produzir bobinas

s.t. R1: x + y <= 40;
s.t. R2: 200*x <= 6000;
s.t. R3: 140*y <= 4000;

maximize P: 25 * (200 * x) + 30 * (140 * y);

# P = 192000