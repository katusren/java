// src/pages/AddExpense.jsx

import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import { format } from "date-fns";

// 커스텀 훅 및 공통 컴포넌트 임포트
import useToast from "../hooks/useToast";
import ToastMessage from "../components/common/ToastMessage";

// AppContext 임포트 (전역 상태 관리를 위해)
import { useAppContext } from "../contexts/AppContext";

import "./AddExpense.css";

/**
 * 지출 등록 페이지 컴포넌트입니다.
 */

const AddExpense = () => {
  // 전역 상태(addExpense, generateUniqueId)를 AppContext에서 가져옵니다.
  const { addExpense, generateUniqueId } = useAppContext();

  // 폼 입력 필드의 상태 관리
  const [amount, setAmount] = useState(""); // 금액
  const [category, setCategory] = useState("식비"); // 카테고리 (기본값 설정)
  const [description, setDescription] = useState(""); // 내용
  const [date, setDate] = useState(format(new Date(), "yyyy-MM-dd")); // 날짜 (오늘 날짜로 기본값 설정)

  // useToast 커스텀 훅을 사용하여 토스트 메시지 기능 가져오기
  const { toast, showToast, closeToast } = useToast();

  // 페이지 이동을 위한 useNavigate 훅
  const navigate = useNavigate();

  // 지출 등록 폼 제출 핸들러
  const handleSubmit = (e) => {
    e.preventDefault(); // 폼 기본 제출 동작(페이지 새로고침) 방지

    // 입력 값 유효성 검사
    const parsedAmount = parseFloat(amount);
    if (isNaN(parsedAmount) || parsedAmount <= 0) {
      showToast("유효한 금액을 입력해주세요.", "error");
      return;
    }
    if (!category) {
      showToast("카테고리를 선택해주세요.", "error");
      return;
    }
    if (!description.trim()) {
      showToast("내용을 입력해주세요.", "error");
      return;
    }
    if (!date) {
      showToast("날짜를 선택해주세요.", "error");
      return;
    }

    // 새로운 지출 객체 생성
    const newExpense = {
      id: generateUniqueId(), // 고유 ID 생성
      amount: parsedAmount,
      category,
      description: description.trim(),
      date,
      createdAt: new Date().toISOString(), // 등록 시점 기록
    };

    addExpense(newExpense); // 전역 상태에 지출 추가
    showToast("지출이 성공적으로 등록되었습니다!", "success"); // 성공 토스트 메시지 표시

    // 폼 초기화
    setAmount("");
    setCategory("식비");
    setDescription("");
    setDate(format(new Date(), "yyyy-MM-dd"));

    // 지출 등록 후 홈 페이지로 이동 (선택 사항)
    navigate("/");
  };

  return (
    // 페이지 컨테이너
    <div className="add-expense-container">
      {/* 뒤로가기 버튼 및 페이지 제목 */}
      <div className="add-expense-header">
        <button
          onClick={() => navigate(-1)} // 이전 페이지로 이동
          className="back-button"
        >
          ←
        </button>
        <h2 className="page-title">➕ 지출 등록</h2>
      </div>

      {/* 지출 등록 폼 */}
      <form onSubmit={handleSubmit} className="expense-form">
        {/* 금액 입력 필드 */}
        <div className="form-group">
          <label htmlFor="amount" className="form-label">
            금액:
          </label>
          <input
            type="number"
            id="amount"
            value={amount}
            onChange={(e) => setAmount(e.target.value)}
            className="form-input"
            placeholder="예: 15000"
            required
          />
        </div>

        {/* 카테고리 선택 필드 */}
        <div className="form-group">
          <label htmlFor="category" className="form-label">
            카테고리:
          </label>
          <select
            id="category"
            value={category}
            onChange={(e) => setCategory(e.target.value)}
            className="form-select"
            required
          >
            <option value="식비">식비</option>
            <option value="교통">교통</option>
            <option value="문화생활">문화생활</option>
            <option value="생활용품">생활용품</option>
            <option value="의료">의료</option>
            <option value="교육">교육</option>
            <option value="기타">기타</option>
          </select>
        </div>

        {/* 내용 입력 필드 */}
        <div className="form-group">
          <label htmlFor="description" className="form-label">
            내용:
          </label>
          <input
            type="text"
            id="description"
            value={description}
            onChange={(e) => setDescription(e.target.value)}
            className="form-input"
            placeholder="예: 점심 식사, 버스 요금"
            required
          />
        </div>

        {/* 날짜 선택 필드 */}
        <div className="form-group">
          <label htmlFor="date" className="form-label">
            날짜:
          </label>
          <input
            type="date"
            id="date"
            value={date}
            onChange={(e) => setDate(e.target.value)}
            className="form-input"
            required
          />
        </div>

        {/* 지출 등록 버튼 */}
        <button type="submit" className="submit-button">
          ✔️ 지출 등록
        </button>
      </form>

      {/* 토스트 메시지 컴포넌트 */}
      <ToastMessage
        message={toast.message}
        type={toast.type}
        onClose={closeToast}
      />
    </div>
  );
};

export default AddExpense;
