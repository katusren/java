/*
// properties: 매개변수
const Button = (props) => {
  console.log(props);
  return (
    <button style={{ color: props.color }}>
      {props.text} - {props.color}
    </button>
  );
};

export default Button;*/

// props 없이 버튼에 텍스트 적용
// 전달되어야 하는 속성 값이 여러개일때
// 버튼 하위 자식 엘리먼트
/*
const Button = ({ text, color = "black", children }) => {
  return (
    <button style={{ color }}>
      {text} - {color.toUpperCase()}
      {children}
    </button>
  );
};

export default Button;*/

// 이벤트 객체
const Button = ({ text, color = "black", children }) => {
  const onClickButton = (e) => {
    alert(`버튼 클릭함: ${e.target.textContent}`);
  };
  console.log();

  return (
    <button onClick={onClickButton} style={{ color: color }}>
      {text} - {color.toUpperCase()}
      {children}
    </button>
  );
};

export default Button;
