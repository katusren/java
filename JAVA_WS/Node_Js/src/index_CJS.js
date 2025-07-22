// CommonJS 방식

//console.log("안녕 Node.js")
console.log("---------------------------");
//1. greeting 모듈
//greeting.js 모듈 가져오기
const sayHello = require("./greeting");

//함수 호출
const message = sayHello("SolDesk");
console.log(message);
console.log("---------------------------");

//2. math 모듈
//math.js
// const { add, subtract, multiply, divide } = require("./ESM_math");
// //const math=require("./math");
// console.log(add(5, 3));
// console.log(subtract(5, 3));
// console.log("---------------------------");
// //console.log(math.multiply(5,3));
// console.log(multiply(5, 3));
// console.log(divide(5, 3));
// console.log("---------------------------");
//3.fileManager(fs) 모듈
const fileManager = require("./fileManager");
//console.log(fileManager);
const fileName = "sample.txt";
const content = "Hello NodeJS!";

//함수 호출
fileManager.writeFile(fileName, content);
console.log(fileManager.readFile(fileName));
console.log("----------------------------");
//4.getWeather 모듈
const getWeather = require("./weatherModule");
getWeather("Seoul");
console.log("---------------------------");
const { addNote, getNotes, deleteNote } = require("./noteManger");

addNote("Node3", "Learn how to use Node3");
getNotes();
// deleteNote(2);
