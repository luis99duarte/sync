option solver gurobi;

var x1 >= 0;    # toneladas de resíduos fábrica 1
var x2 >= 0;    # toneladas de resíduos fábrica 2
var x3 >= 0;    # toneladas de resíduos fábrica 3

s.t. R1: 0.1*x1 + 0.2*x2 + 0.4*x3 >= 30;
s.t. R2: 0.45*x1 + 0.25*x2 + 0.3*x3 >= 40;


minimize C: 15*x1 + 10*x2 + 20*x3;

# C = 1576.923077