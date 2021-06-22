option solver gurobi;

var c >= 0;     # comprimento da caixa
var l >= 0;     # largura da caixa
var a >= 0;     # altura da caixa

s.t. R1: c <= 42;
s.t. R2: c + l <= 72;
s.t. R3: a <= l;
s.t. R4: l <= c;

maximize V: c * l * a;

# Gurobi can't handle general nonlinear objectives.