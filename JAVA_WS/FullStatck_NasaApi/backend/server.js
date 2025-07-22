const express = require("express");
const mongoose = require("mongoose");
const axios = require("axios");
const cors = require("cors");
const Apod = require("./models/Apod");

const app = express();
app.use(cors());
app.use(express.json());

// MongoDB와 Connect
mongoose
  .connect("mongodb://localhost:27017/fullstackDB", {
    useNewUrlParser: true,
    useUnifiedTopology: true,
  })
  .then(() => console.log("✅ MongoDB 연결 완료"));

app.post("/apod/fetch", async (req, res) => {
  try {
    const response = await axios.get(
      "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY"
    );
    const { date, title, url, explanation } = response.data;

    const exists = await Apod.findOne({ date });
    if (exists)
      return res.status(200).json({ message: "이미 저장된 데이터입니다." });

    const newApod = new Apod({ date, title, url, explanation });
    await newApod.save();
    res.json({ message: "🌌 저장 완료", data: newApod });
  } catch (err) {
    res.status(500).json({ message: "API 연동 실패" });
  }
});

// 저장된 사진 가져오기
app.get("/apod", async (req, res) => {
  const all = await Apod.find().sort({ date: -1 });
  res.json(all);
});

app.listen(5000, () => {
  console.log("🚀 서버 실행 중: http://localhost:5000");
});
