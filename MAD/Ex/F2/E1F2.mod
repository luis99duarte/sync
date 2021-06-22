option solver gurobi;

var x1 >= 0;    # número de portáteis produzidos
var x2 >= 0;    # número de desktops produzidos

s.t. R1: x1/9 + x2/8 <= 1;
s.t. R2: x1/10 + x2/16 <= 1;
s.t. R3: x1 >= x2 + 1;

maximize P: 250*x1 + 150*x2;

# P = 2250