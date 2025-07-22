//math.js 모듈
function add(a, b) {
  return a + b;
}

// subtract
function subtract(a, b) {
  return a - b;
}

// multiply
function multiply(a, b) {
  return a * b;
}

// divide(if문 예외)
function divide(a, b) {
  if (b == 0) {
    return false;
  }
  return a / b;
}

export { add, subtract, multiply, divide };
