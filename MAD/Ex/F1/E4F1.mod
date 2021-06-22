option solver gurobi;

var a >= 0, <= 100000;      # quantidade de lã amarela utilizada
var v >= 0, <= 100000;      # quantidade de lã verde utilizada
var p >= 0, <= 120000;      # quantidade de lã preta utilizada

maximize P: 500*(400 * a + 500 * v + 300 * p) + 200*(500 * a + 200 * v + 800 * p);

# P = 9.62e+10