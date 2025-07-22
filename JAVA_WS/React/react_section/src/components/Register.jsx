import { useRef, useState } from "react";

// 회원가입
/*
1. 이름
2. 생년월일
3. 국적
4. 자기소개
*/
/*
const Register = () => {
  const [name, setName] = useState(""); // 이름
  const [birth, setBirth] = useState(""); // 생년월일
  const [country, setCountry] = useState(""); // 국적
  const [bio, setBio] = useState(""); // 자기소개

  const onChangeName = (e) => {
    setName(e.target.value);
  };

  const onChangeBirth = (e) => {
    setBirth(e.target.value);
  };

  const onChangeCountry = (e) => {
    setCountry(e.target.value);
  };

  const onChangeBio = (e) => {
    setBio(e.target.value);
  };

  return (
    <div style={{ padding: "20px" }}>
      <h2>회원가입</h2>

      <div>
        <label>이름 : </label>
        <input
          value={name}
          onChange={onChangeName}
          placeholder="이름"
          style={{ width: "85px", height: "18px" }}
        />
        <p>입력된 이름: {name}</p>
      </div>

      <div>
        <label>생년월일 : </label>
        <input type="date" value={birth} onChange={onChangeBirth} />
        <p>입력된 생년월일: {birth}</p>
      </div>

      <div>
        <label>국적 : </label>
        <input
          value={country}
          onChange={setCountry}
          placeholder="대한민국"
          style={{ width: "85px", height: "18px" }}
        />
        <p>입력된 국적: {country}</p>
      </div>

      <div>
        <label>자기소개:</label>
        <br />
        <textarea
          value={bio}
          onChange={onChangeBio}
          placeholder="자기소개를 입력하세요"
          rows={4}
          cols={50}
        />
        <p>자기소개 내용: {bio}</p>
      </div>
    </div>
  );
};*/

const Register = () => {
  const [input, setInput] = useState({
    name: "",
    birth: "",
    country: "",
    bio: "",
  });

  const countRef = useRef(0);
  const inputRef = useRef();
  //console.log(refObj.current);
  //console.log("Register-랜더링");

  const onChange = (e) => {
    console.log(countRef.current);
    console.log(e.target.name + " : " + e.target.value);
    setInput({
      ...input,
      [e.target.name]: e.target.value,
    });
  };

  const onsubmit = () => {
    if (input.name === "") {
      console.log(inputRef.current);
      inputRef.current.focus();
    }
  };

  return (
    <div>
      <button
        onClick={() => {
          countRef.current++;
          console.log(countRef.current);
        }}
      >
        조회수
      </button>
      <div>
        <input
          name="name"
          value={input.name}
          onChange={onChange}
          placeholder={"이름"}
          ref={inputRef}
        />
      </div>
      <div>
        <input
          name="birth"
          value={input.birth}
          onChange={onChange}
          placeholder={"생년월일"}
          type="date"
        />
      </div>
      <div>
        <select name="country" value={input.country} onChange={onChange}>
          <option value=""></option>
          <option value="kr">한국</option>
          <option value="us">미국</option>
          <option value="uk">영국</option>
          <option value="jp">일본</option>
        </select>
      </div>

      <div>
        <textarea
          name="bio"
          value={input.bio}
          onChange={onChange}
          placeholder="자기소개를 입력하세요"
          rows={4}
          cols={50}
        />
      </div>
      <button onClick={onsubmit}>제출</button>
    </div>
  );
};

export default Register;
