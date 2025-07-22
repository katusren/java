//weatherSimulator.js 모듈
export const weatherConditions = ["맑음", "흐림", "비", "폭풍", "눈", "바람"];

export function suggestActivity(weather) {
  switch (weather) {
    case "맑음":
      return "하이킹을 가보세요!";
    case "흐림":
      return "책 읽기에 좋은 날씨입니다";
    case "비":
      return "비소리를 들으며 잠들기";
    case "폭풍":
      return "집에서 얌전히 있기";
    case "눈":
      return "눈구경 하면서 우동 한그릇";
    case "바람":
      return "시원한 바람은 좋아";
  }
}
