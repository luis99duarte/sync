var A;
var B;

subject to R1: 0.400 * A + 0.500 * B <= 100;
subject to R2: 0.500 * A + 0.200 * B <= 100;
subject to R3: 0.300 * A + 0.800 * B <= 120;
subject to R4: A >= 0;
subject to R5: B >= 0;

maximize L: 500 * A + 200 * B;