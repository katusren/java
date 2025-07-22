// date_luxon.js
// luxon
import { DateTime } from "luxon";

// 현재 날짜와 시간을 출력
const now = DateTime.now();
console.log("현재 날짜와 시간: ", now.toString());

// 특정 날짜로 DateTime 객체 생성
const dt = DateTime.local(2025, 7, 11, 12, 45);
console.log("지정한 날짜와 시간: ", dt.toString());

// 날짜 포맷팅
const formattedDate = dt.toLocaleString(DateTime.DATETIME_FULL);
console.log("포맷팅 날짜: ", formattedDate);

// 두 날짜 간의 차이 계산
const diff = now.diff(dt, ["years", "months", "days"]);
console.log("현재부터 지정된 날짜까지의 차이: ", diff.toObject());
