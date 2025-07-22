// src/App.jsx

import React, { useState, useEffect } from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";

// 레이아웃 컴포넌트 임포트
import Layout from "./components/layout/Layout";

// 페이지 컴포넌트 임포트
import Settings from "./pages/Settings";
import AddExpense from "./pages/AddExpense"; // AddExpense 페이지 임포트
import Home from "./pages/Home";
import StatisticsView from "./pages/StatisticsView";

// App 전역 CSS
import "./App.css";

// AppContext와 useAppContext 훅을 별도의 파일에서 임포트합니다.
import { AppContext } from "./contexts/AppContext";

// 유니크 ID 생성 유틸리티 함수 (지출 항목 ID 생성에 사용)
const generateUniqueId = () => {
  return Date.now().toString(36) + Math.random().toString(36).substring(2);
};

function App() {
  // 앱의 핵심 상태: 지출 내역과 월별 예산
  const [expenses, setExpenses] = useState([]);
  const [monthlyBudget, setMonthlyBudget] = useState(0);

  // 컴포넌트가 처음 마운트될 때 localStorage에서 데이터 로드
  useEffect(() => {
    const storedExpenses =
      JSON.parse(localStorage.getItem("cashnote_expenses")) || [];
    const storedBudget =
      parseFloat(localStorage.getItem("cashnote_monthlyBudget")) || 0;
    setExpenses(storedExpenses);
    setMonthlyBudget(storedBudget);
  }, []); // 빈 의존성 배열: 컴포넌트 마운트 시 한 번만 실행

  // expenses 상태가 변경될 때마다 localStorage에 저장
  useEffect(() => {
    localStorage.setItem("cashnote_expenses", JSON.stringify(expenses));
  }, [expenses]); // expenses가 의존성 배열에 있으므로, expenses가 변경될 때마다 실행

  // monthlyBudget 상태가 변경될 때마다 localStorage에 저장
  useEffect(() => {
    localStorage.setItem("cashnote_monthlyBudget", monthlyBudget.toString());
  }, [monthlyBudget]); // monthlyBudget이 의존성 배열에 있으므로, monthlyBudget이 변경될 때마다 실행

  // 지출 항목 추가 함수
  const addExpense = (newExpense) => {
    setExpenses((prevExpenses) => [...prevExpenses, newExpense]);
  };

  // 지출 항목 삭제 함수
  const deleteExpense = (id) => {
    setExpenses((prevExpenses) => prevExpenses.filter((exp) => exp.id !== id));
  };

  return (
    // AppContext.Provider를 통해 앱의 전역 상태와 함수들을 하위 컴포넌트에 제공
    <AppContext.Provider
      value={{
        expenses,
        monthlyBudget,
        setMonthlyBudget,
        addExpense,
        deleteExpense,
        generateUniqueId,
      }}
    >
      <Router>
        {/* Layout 컴포넌트로 전체 앱 구조를 감쌉니다. */}
        <Layout>
          {/* 라우팅 설정 */}
          <Routes>
            {/* 홈 페이지 라우트 */}
            <Route path="/" element={<Home />} />
            {/* 설정 페이지 라우트 */}
            <Route path="/settings" element={<Settings />} />
            {/* 지출 등록 페이지 라우트 */}
            <Route path="/add" element={<AddExpense />} />
            {/* 통계 페이지 라우트 */}
            <Route path="/statistics" element={<StatisticsView />} />
          </Routes>
        </Layout>
      </Router>
    </AppContext.Provider>
  );
}

export default App;
