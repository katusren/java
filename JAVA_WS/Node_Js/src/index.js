// ES module 시스템 사용
import { add, subtract, multiply, divide } from "./ESM_math.js";

console.log(add(5, 3));
console.log(subtract(5, 3));
console.log(multiply(5, 3));
console.log(divide(5, 3));

console.log("--------------------------------------");

import { add2, subtract2, multiply2, divide2 } from "./ESM_math2.js";

console.log(add2(5, 3));
console.log(subtract2(5, 3));
console.log(multiply2(5, 3));
console.log(divide2(5, 3));
