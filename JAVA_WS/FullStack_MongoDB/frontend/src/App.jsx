import { useState, useEffect } from "react";
import axios from "axios";
import "./App.css";

function App() {
  const [notes, setNotes] = useState([]); // Notes 노트 목록을 저장하는 상태체크
  const [form, setForm] = useState({ title: "", content: "" });
  const [editId, setEditId] = useState(null); // 수정할 노트 ID

  // 노트 목록 불러오기
  const fetchNotes = async () => {
    const res = await axios.get("http://localhost:5000/notes");
    setNotes(res.data); // 응답받은 데이터를 notes에 저장
  };

  // 추가 또는 수정

  const addOrUdateNote = async () => {
    // 예외처리
    if (!form.title || !form.content) {
      alert("제목과 내용을 모두 입력하세요");
      return;
    }

    if (editId) {
      await axios.put(`http://localhost:5000/notes/${editId}`, form); // form에 있는 title,content를 PUT요청으로 보냄
    } else {
      await axios.post("http://localhost:5000/notes", form); // form에 있는 title,content를 POST요청으로 보냄
    }

    setForm({ title: "", content: "" }); // 입력창 초기화
    setEditId(null); // 수정 완료 후 상태 해제
    fetchNotes(); // 목록 다시 불러오기
  };

  // 삭제
  const deleteNote = async (id) => {
    if (window.confirm("정말 삭제하시겠습니까?")) {
      await axios.delete(`http://localhost:5000/notes/${id}`);
      fetchNotes();
    }
  };

  // 수정 시작
  const startEdit = (note) => {
    // 기존에 있던 제목과 내용을 채우고
    setForm({ title: note.title, content: note.content });
    setEditId(note._id);
  };

  useEffect(() => {
    fetchNotes();
  }, []); // 컴포넌트가 처음 로드(마운트) 되었을 때 1회만 실행

  return (
    <>
      <div class="container">
        <h1>나의 노트</h1>

        <div>
          <input
            placeholder="제목"
            value={form.title}
            onChange={(e) => setForm({ ...form, title: e.target.value })}
          />
          <input
            placeholder="내용"
            value={form.content}
            onChange={(e) => setForm({ ...form, content: e.target.value })}
          />
          <button onClick={addOrUdateNote}>{editId ? "수정" : "추가"}</button>
        </div>
        <p></p>
        {/* key={idx}: React에서 각 리스트의 요소를 식별하기 위해 생성해주는 키 */}
        {/* 각각의 항목마다 수정/삭제 버튼을 구현 */}
        <div>
          {notes.map((note) => (
            <div className="note-item" key={note._id}>
              <div>
                <strong>{note.title}</strong>: {note.content}
              </div>
              <div className="note-actions">
                <button onClick={() => startEdit(note)}>✏️</button>
                <button onClick={() => deleteNote(note._id)}>🗑️</button>
              </div>
            </div>
          ))}
        </div>
      </div>
    </>
  );
}

export default App;
