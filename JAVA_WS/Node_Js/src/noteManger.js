//noteManager.js
//메모 추가, 조회, 삭제의 기능을 보유한 JSON형식의 메모 모듈
//추가: writeNotes(notes), addNote(title, content)
//조회: readNotes(),getNotes()
//삭제: deleteNote(id)
//저장파일: notes.json

const fs = require("fs");
const notesFile = "notes.json";

function readNotes() {
  // notes.json 파일의 존재 여부
  // 존재하지 않으면 true
  if (!fs.existsSync(notesFile)) {
    return [];
  }

  const data = fs.readFileSync(notesFile, "utf-8");

  if (!data.trim()) {
    // 가져온 data가 공백이거나 비어있으면
    return [];
  }

  return JSON.parse(data);
}

function writeNotes(notes) {
  // null : 사용하지 않을 경우 null을 넣음
  // 2 : 2칸 들여쓰기
  fs.writeFileSync(notesFile, JSON.stringify(notes, null, 2));
}

function addNote(title, content) {
  const notes = readNotes(); // 저장된 기존의 메모 읽어오기

  // 새로 가져온 메모가 있다면 기존 메모중 가장 id가 큰값보다 1이 크도록하여 메모가 없으면 기본값 1
  // ...notes : 전개연산자
  const id =
    notes.length > 0 ? Math.max(...notes.map((note) => note.id)) + 1 : 1;

  notes.push({
    id,
    title,
    content,
  });

  writeNotes(notes);
  console.log("added successfully");
}

// 조회
function getNotes() {
  const notes = readNotes();
  console.log(notes);
}

//삭제
function deleteNote(id) {
  let notes = readNotes();
  //filter 메소드를 사용해서 매개변수로 받아온 id의 존재여부를 확인하여 제거
  const initialLength = notes.length; //메모의 갯수
  //id가 일치하기 않는 아이디의 메모
  const updatedNotes = notes.filter((note) => note.id !== id);

  //삭제전과 후의 배열의 길이가 완전히 일치하면 삭제한 적이 없음
  if (updatedNotes.length === initialLength) {
    console.log(`Note with ID ${id} not found.`);
  } else {
    writeNotes(updatedNotes);
    console.log("Deleted successfully");
  }
}

module.exports = { addNote, getNotes, deleteNote };
