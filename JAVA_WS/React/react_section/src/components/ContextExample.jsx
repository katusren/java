import { createContext, useContext } from "react";

const UserContext = createContext();

const Profile = () => {
  const user = useContext(UserContext);
  return <p>안녕하세요, {user.name}님!</p>;
};

const ContextExample = () => {
  const user = { name: "soldesk" };

  return (
    // Provider: 서랍장에서 문서 꺼내기
    <UserContext.Provider value={user}>
      <Profile />
    </UserContext.Provider>
  );
};

export default ContextExample;

/* 
전역 데이터를 쉽게 전달해주는 Context API를 사용하는 Hook
→ props 없이 상태 공유 가능 (예: 로그인 정보, 테마 등)
*/
