import { useState } from "react";

const getRandomColor = () => {
  const letters = "0123456789ABCDEF";
  let color = "#";
  for (let i = 0; i < 6; i++) {
    color += letters[Math.floor(Math.random() * 16)];
  }
  return color;
};

const Counter = () => {
  const [state, setState] = useState(0);
  const [buttonColor, setButtonColor] = useState("#007bff");

  return (
    <div style={{ textAlign: "center" }}>
      <h1 style={{ fontWeight: "bold", fontSize: "40px" }}>Counter</h1>
      <p />
      <h4>Current count: {state}</h4>
      <p />
      <button
        onClick={() => {
          setState(state + 1);
          setButtonColor(getRandomColor());
        }}
        style={{
          backgroundColor: buttonColor,
          borderRadius: "15px",
          padding: "12px 25px",
          height: "40px",
          fontWeight: "bold",
          fontSize: "15px",
          border: "none",
          outline: "none",
          cursor: "pointer",
          boxShadow:
            "0 6px 12px rgba(0, 0, 0, 0.25), 0 0 0 3px rgba(255, 255, 255, 0.3) inset",
          textShadow: "0 1px 2px rgba(0, 0, 0, 0.2)",
          letterSpacing: "0.5px",
          transition: "background-color 0.3s ease, box-shadow 0.3s ease",
        }}
      >
        Increment
      </button>
    </div>
  );
};

export default Counter;
