var x >= 0; # número de vídeos com duas cabeças produzidos diariamente
var y >= 0; # número de vídeos com quatro cabeças produzidos diariamente

maximize P: 32*x + 8*y + x*y - 1/2*x*x - y*y;

s.t. R1: 5*x + 6*y <= 600;
s.t. R2: x + 2*y <= 160;

# P = 1312 (Not PL)
