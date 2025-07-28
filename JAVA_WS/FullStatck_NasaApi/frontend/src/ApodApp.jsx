import "./ApodApp.css";
import { useState, useEffect } from "react";
import axios from "axios";

function ApodApp() {
  const [apods, setApods] = useState([]);

  // 저장된 데이터 가져옴
  const fetchApods = async () => {
    const res = await axios.get("http://localhost:5000/apod"); // apod에 저장된 데이터 랜더링
    setApods(res.data);
  };

  const fetchAndSave = async () => {
    const res = await axios.post("http://localhost:5000/apod/fetch");
    alert(res.data.message);
    fetchApods(); // 목록 새로고침
  };

  useEffect(() => {
    fetchApods();
  }, []);

  return (
    <div className="container">
      <h2>🚀 오늘의 우주 사진 저장소</h2>
      <button onClick={fetchAndSave}>NASA에서 불러와 MongoDB에 저장</button>

      {apods.length === 0 && <p>⏳ 아직 데이터가 없습니다.</p>}

      {apods.map((item) => (
        //_id: mongodb에서 자동으로 생성된 id
        <div className="card" key={item._id}>
          <h3>
            {item.title} ({item.date})
          </h3>
          <img src={item.url} alt={item.title} />
          <p>{item.explanation}</p>
        </div>
      ))}
    </div>
  );
}

export default ApodApp;
