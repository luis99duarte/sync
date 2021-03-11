var A;
var B;
var C;

subject to R1: 0 <= C <= 42;
subject to R2: C + L <= 72;
subject to R3: 0 <= A <= L;
subject to R4: 0 <= L <= C;

maximize V: A * C * L;