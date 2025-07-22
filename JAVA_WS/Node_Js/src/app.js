import formatMessage, { getCurrentDate, getDayOfWeek } from "./getdate.js";
// expoart default 모듈은 줄여서 사용 가능

const today = getCurrentDate();
console.log("오늘 날짜: ", today);

const toweek = getDayOfWeek();
console.log("요일: ", toweek);

console.log(formatMessage("katusren", "1234"));
console.log("--------------------------------------");

import { getRandomQuote } from "./quotes.js";

console.log("랜덤 명언: ", getRandomQuote());
console.log("--------------------------------------");
// 3.weatherSimulator.js
import { weatherConditions, suggestActivity } from "./weatherSimulator.js";

const randomIndex = Math.floor(Math.random() * weatherConditions.length);
const currentweather = weatherConditions[randomIndex];
//console.log(`현재 날씨:${currentweather} `, suggestActivity(currentweather));
console.log("오늘의 날씨: ", currentweather);
console.log("추천 활동: ", suggestActivity(currentweather));
console.log("--------------------------------------");
// 4.fortuneGenerator.js
import { getZodiac, getFortune } from "./fortuneGenerator.js";

const birthYear = 1997;
console.log("오늘의 운세");
console.log(`띠: ${getZodiac(birthYear)}`);
