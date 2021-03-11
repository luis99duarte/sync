var A; # Toneladas
var B; # Toneladas

subject to R1: A + B <= 5;
subject to R2: 0 <= A <= 3;
subject to R3: B >= 0;

maximize L: 4*A + 3.5*B;