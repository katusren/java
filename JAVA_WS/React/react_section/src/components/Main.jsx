/*const Main = () => {
  // JSX 주의사항
  // 1. 중괄화 내부에는 자바스크립트 표현식만 넣을 수 있다.
  // 2. 조건문을 사용할 수 없다({if(){ }}) {for(){ }})
  // 3. 숫자, 문자, 배열 값만 렌더링 된다.
  // 4. {true} {null} {obj} {undefined} 가 안된다.
  // 5. 모든 태그는 반드시 닫혀 있어야 한다.
  // 6. 최상위 태그는 반드시 하나여야만 한다. 권장<></>

  const number = 10;

  return (
    <main>
      <h1>Main</h1>
      <h2>{number}</h2>
      <h2>{number + 10}</h2>
      <h2>{number % 2 === 0 ? "짝수" : "홀수"}</h2>
    </main>
  );

};

export default Main;*/

import "./Main.css";

const Main = () => {
  const user = { name: "SolDesk", isLogin: true };

  if (user.isLogin) {
    return <div className="logout">로그아웃</div>;
  } else {
    return <div>로그인</div>;
  }
};

export default Main;
