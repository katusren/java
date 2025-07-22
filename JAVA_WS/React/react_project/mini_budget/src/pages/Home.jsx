// src/pages/Home.jsx

import React, { useState } from "react";
import { format, parseISO } from "date-fns";
import { Link } from "react-router-dom";

// AppContext 임포트 (전역 상태 관리를 위해)
import { useAppContext } from "../contexts/AppContext";

// 커스텀 모달 컴포넌트 임포트
import ConfirmModal from "../components/common/ConfirmModal";

// Home 페이지 전용 CSS 파일 임포트
import "./Home.css";

/**
 * 홈 페이지 컴포넌트입니다.
 * 현재 월의 예산 현황과 최근 지출 내역을 표시합니다.
 */
const Home = () => {
  // 전역 상태(monthlyBudget, expenses, deleteExpense)를 AppContext에서 가져옵니다.
  const { monthlyBudget, expenses, deleteExpense } = useAppContext();

  // 모달 관련 상태
  const [showConfirmModal, setShowConfirmModal] = useState(false); // 확인 모달 표시 여부
  const [expenseToDeleteId, setExpenseToDeleteId] = useState(null); // 삭제할 지출 항목의 ID

  // 현재 날짜를 기준으로 월을 포맷합니다 (예: 2025-07)
  const currentMonth = format(new Date(), "yyyy-MM");

  // 현재 월의 총 지출을 계산합니다.
  const totalSpent = expenses
    .filter((exp) => format(parseISO(exp.date), "yyyy-MM") === currentMonth)
    .reduce((sum, exp) => sum + parseFloat(exp.amount), 0);

  // 남은 예산 계산
  const remainingBudget = monthlyBudget - totalSpent;

  // 최근 지출 내역 (최신 5개 항목)
  const recentExpenses = expenses
    .filter((exp) => format(parseISO(exp.date), "yyyy-MM") === currentMonth)
    .sort(
      (a, b) =>
        parseISO(b.createdAt).getTime() - parseISO(a.createdAt).getTime()
    )
    .slice(0, 5);

  // --- 삭제 기능 관련 핸들러 ---

  // 삭제 버튼 클릭 핸들러: 모달을 열고 삭제할 항목 ID를 저장합니다.
  const handleDeleteClick = (id) => {
    // console.log("삭제 버튼 클릭됨! ID:", id); // 디버깅용 로그
    setExpenseToDeleteId(id);
    setShowConfirmModal(true);
    // console.log("showConfirmModal 상태 변경:", true); // 디버깅용 로그
  };

  // 모달에서 '확인' 클릭 시 실제 삭제 로직을 실행합니다.
  const handleConfirmDelete = () => {
    // console.log("모달에서 확인 버튼 클릭됨. 삭제할 ID:", expenseToDeleteId); // 디버깅용 로그
    if (expenseToDeleteId) {
      deleteExpense(expenseToDeleteId);
      // console.log("지출 삭제 완료:", expenseToDeleteId); // 디버깅용 로그
      setExpenseToDeleteId(null);
      setShowConfirmModal(false);
    }
  };

  // 모달에서 '취소' 클릭 시
  const handleCancelDelete = () => {
    // console.log("모달에서 취소 버튼 클릭됨."); // 디버깅용 로그
    setExpenseToDeleteId(null);
    setShowConfirmModal(false);
  };

  // --- 렌더링 부분 ---
  return (
    <div className="home-container">
      {/* 월별 요약 섹션 */}
      <div className="month-summary-card">
        <h2 className="month-summary-title">
          {format(new Date(), "yyyy년 MM월")}
        </h2>
        <div className="budget-info">
          <div className="budget-item">
            <span className="budget-label">총 예산:</span>
            <span className="budget-value">
              ₩{monthlyBudget.toLocaleString()}
            </span>
          </div>
          <div className="budget-item">
            <span className="budget-label">총 지출:</span>
            <span className="spent-value">₩{totalSpent.toLocaleString()}</span>
          </div>
          <div className="budget-item">
            <span className="budget-label">남은 예산:</span>
            <span
              className={`remaining-value ${
                remainingBudget < 0 ? "negative" : ""
              }`}
            >
              ₩{remainingBudget.toLocaleString()}
            </span>
          </div>
        </div>
      </div>

      {/* 최근 지출 섹션 */}
      <div className="recent-expenses-card">
        <h3 className="recent-expenses-title">최근 지출</h3>
        {recentExpenses.length > 0 ? (
          <ul className="expense-list">
            {recentExpenses.map((expense) => (
              <li key={expense.id} className="expense-item">
                <div className="expense-details">
                  <span className="expense-category">{expense.category}</span>
                  <span className="expense-description">
                    {expense.description}
                  </span>
                </div>
                <div className="expense-amount-date">
                  <span className="expense-amount">
                    ₩{expense.amount.toLocaleString()}
                  </span>
                  <span className="expense-date">
                    {format(parseISO(expense.date), "MM.dd")}
                  </span>
                </div>
                {/* 삭제 버튼: 클릭 시 handleDeleteClick 함수 호출 */}
                <button
                  onClick={() => handleDeleteClick(expense.id)}
                  className="delete-expense-button"
                >
                  🗑️
                </button>
              </li>
            ))}
          </ul>
        ) : (
          <div className="no-expenses-message">
            <p>아직 등록된 지출이 없습니다.</p>
            <Link to="/add" className="add-expense-link">
              ➕ 지출 등록하기
            </Link>
          </div>
        )}
      </div>

      {/* 삭제 확인 모달 컴포넌트 */}
      <ConfirmModal
        isOpen={showConfirmModal}
        message="정말로 이 지출 내역을 삭제하시겠습니까?"
        onConfirm={handleConfirmDelete}
        onCancel={handleCancelDelete}
      />
    </div>
  );
};

export default Home;
