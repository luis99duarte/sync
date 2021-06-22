option solver gurobi;

# (a)

#var x1 >= 0;    # número de acres de milho semeados
#var x2 >= 0;    # número de acres de trigo semeados

#maximize P: x1*10*3 + x2*25*4;

#s.t. R1: x1 + x2 <= 7;
#s.t. R2: 4*x1 + 10*x2 <= 40;
#s.t. R3: x1*10*52 >= 30;

# P = 399.4230769

# (b)

# i.        Admissível
# ii.       Não admissível
# iii.      Não admissível
# iv.       Admissível

# (c)

var x1 >= 0;    # número de galões de milho produzidos
var x2 >= 0;    #número de galões de trigo produzidos

maximize P: 3*x1 + 4*x2;

s.t. R1: x1/10 + x2/25 <= 7; 
s.t. R2: 4*x1/10 + 10*x2/25 <= 40;
s.t. R3: x1*52 >= 30;

# P = 399.4230769
