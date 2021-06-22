option solver gurobi;

var x1 >= 0, <= 100;    # número de discos produzidos
var x2 >= 0, <= 100;    # número de leitores produzidos

# Profit por disco 100 - 50 - 30 = 20
# Profit por leitor 90 - 35 - 40 = 15

maximize P: 20*x1 + 15*x2;

s.t. R1: 50*x1 + 35*x2 <= 6000;
s.t. R2: 20*x1 + 15*x2 >= 2000;

# P = 2500