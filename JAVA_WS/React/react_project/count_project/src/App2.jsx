import "./App.css";
import Controller from "./components/Controller";
import Viewer from "./components/Viewer";
import Even from "./components/Even";
import { useState, useEffect } from "react";

function App() {
  const [count, setCount] = useState(0);
  const [isVisible, setIsVisible] = useState(0);

  const handleButtonClick = (value) => {
    setCount(count + value);
  };

  // useEffect: count 값이 변경될 때 자동으로 로그 출력 및 언마운트 시 메모리 청소
  useEffect(() => {
    //실행할 코드
    console.log(`Count 값이 변경되었습니다: ${count}`);

    //정리 함수
    return () => {
      console.log("컴포넌트가 곧 언마운트됩니다");
    };
  }, [count]); // [count]: 의존성 배열로 count 값이 변경될 때만 useEffect가 작독되도록 제한

  return (
    <>
      <div className="App">
        <h1>Simple Counter</h1>
        <section>
          <button onClick={() => setIsVisible(!isVisible)}>
            {isVisible ? "Hide" : "Show"} Counter
          </button>
        </section>
        <section>
          {/* 조건부 랜더링 */}
          {isVisible && <Viewer count={count} />}
        </section>

        <section>
          <Controller onClickButton={handleButtonClick} />
        </section>
      </div>
    </>
  );
}

export default App;
