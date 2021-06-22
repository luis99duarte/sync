option solver gurobi;

var a >= 0;
var b >= 0;

subject to R1: a + b <= 5;
subject to R2: a <= 3;

maximize P: 4*a + 3.5*b;

# P = 19
