var F;
var B;

subject to R1: 0 <= F <= 6000;
subject to R2: 0 <= B <= 4000;
subject to R3: F/200 + B/140 <= 40;

maximize L: 25 * F + 30 * B;