const express = require("express"); // Node.js 프레임워크 -> 라우팅 및 서버 기능 구현
const mongoose = require("mongoose"); // ODM(Object Data Modeling) -> mongodb 모델링
const cors = require("cors"); // 도메인간의 통신

const app = express();
app.use(cors()); // 모든 출처의 요청 허용 -> 브라우저의 정책
app.use(express.json()); // JSON data 파싱을 허용(POST, PUT...)

mongoose
  .connect("mongodb://localhost:27017/fullstackDB", {
    useNewUrlParser: true,
    useUnifiedTopology: true,
  })
  .then(() => console.log("✅ MongoDB connected"))
  .catch((err) => console.error("❌ MongoDB error:", err));

// 스키마 + 모델
const NoteSchema = new mongoose.Schema({
  title: String,
  content: String,
});
const Note = mongoose.model("Note", NoteSchema);

// 기본 API
app.get("/notes", async (req, res) => {
  const notes = await Note.find(); // 전체 문서 검색
  res.json(notes); // json데이터로 반환
});

// 추가 API(저장하기)
app.post("/notes", async (req, res) => {
  const { title, content } = req.body; // 클라이언트가 요청한 데이터를 본문에서 추출
  const newNote = new Note({ title, content }); // NoteSchema 테이블의 객체 생성
  await newNote.save(); // MongoDB에 newNote 저장
  res.json({ message: "저장 완료" }); // 응답에 사용될 저장 완료 메시지 생성
});

// 삭제
app.delete("/notes/:id", async (req, res) => {
  const { id } = req.params; // url(/notes/:id)에서 id 추출
  await Note.findByIdAndDelete(id);
  res.json({ message: "🗑️ 삭제 완료" });
});

// 수정
app.put("/notes/:id", async (req, res) => {
  const { id } = req.params;
  const { title, content } = req.body; //
  await Note.findByIdAndUpdate(id, { title, content });
  res.json({ message: "✏️ 수정 완료" });
});

// 5000번 포트에서 서버 실행
app.listen(5000, () => {
  console.log("🚀 서버 실행 중: http://localhost:5000");
});
