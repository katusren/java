import React from "react";
import ReactDOM from "react-dom/client"; // Concurrent Mode 기능을 사용할 수 있음
import "./index.css";
import App from "./App.jsx";

// html로 바로 랜더링
ReactDOM.createRoot(document.getElementById("root")).render(
  <React.StrictMode>
    <App />
  </React.StrictMode>
);
