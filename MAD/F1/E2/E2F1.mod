var X;
var Y;

subject to R1: 5x + 6y <= 600;
subject to R2: 1x + 2y <= 160;
subject to R3: x >= 0;
subject to R4: y >= 0;

maximize L = 32*X + 8*Y + x*Y + X^2/2 - Y^2;