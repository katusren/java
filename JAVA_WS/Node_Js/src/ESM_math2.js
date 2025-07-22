//math.js 모듈
export function add2(a, b) {
  return a + b;
}

// subtract
export function subtract2(a, b) {
  return a - b;
}

// multiply
export function multiply2(a, b) {
  return a * b;
}

// divide(if문 예외)
export function divide2(a, b) {
  if (b == 0) {
    return false;
  }
  return a / b;
}
