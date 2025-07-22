// src/contexts/AppContext.jsx
import { createContext, useContext } from "react";

// AppContext 생성
export const AppContext = createContext();

// AppContext를 쉽게 사용할 수 있도록 커스텀 훅으로 만듬
export const useAppContext = () => useContext(AppContext);
