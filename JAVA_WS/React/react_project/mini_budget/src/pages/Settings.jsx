/* src/pages/Settings.jsx */

import React, { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";

import useToast from "../hooks/useToast";
import ToastMessage from "../components/common/ToastMessage";

// AppContext 임포트 (전역 상태 관리를 위해)
import { useAppContext } from "../contexts/AppContext";

import "./Settings.css";

/**
 * 설정 페이지 컴포넌트입니다.
 * 월별 예산을 설정하고 저장할 수 있는 기능을 제공합니다.
 */

const Settings = () => {
  // 전역 상태(monthlyBudget)와 상태 변경 함수(setMonthlyBudget, expenses)를 AppContext에서 가져옵니다.
  const { monthlyBudget, setMonthlyBudget } = useAppContext();

  // 입력 필드에 표시될 예산 값 상태.
  const [budgetInput, setBudgetInput] = useState(monthlyBudget.toString());

  const { toast, showToast, closeToast } = useToast();

  // 페이지 이동을 위한 useNavigate 훅
  const navigate = useNavigate();

  // monthlyBudget이 변경될 때마다 budgetInput을 업데이트하여 동기화합니다.
  useEffect(() => {
    setBudgetInput(monthlyBudget.toString());
  }, [monthlyBudget]);

  // 저장하기 버튼을 눌렀을때 발동되는 함수(유효성 검사 등)
  const handleSaveBudget = () => {
    const newBudget = parseFloat(budgetInput);

    if (!isNaN(newBudget) && newBudget >= 0) {
      setMonthlyBudget(newBudget);
      showToast("월 예산이 성공적으로 저장되었습니다!", "success");
    } else {
      showToast("유효한 예산 금액을 입력해주세요.", "error");
    }
  };

  return (
    <div className="settings-container">
      {/* 뒤로가기 버튼 및 페이지 제목 */}
      <div className="settings-header">
        <button onClick={() => navigate(-1)} className="back-button">
          ←
        </button>
        <h2 className="page-title">⚙️ 예산 설정</h2>
      </div>

      {/* 월별 예산 입력 필드 */}
      <div className="input-group">
        <label htmlFor="monthlyBudget" className="input-label">
          이달의 예산:
        </label>
        <div className="input-wrapper">
          <input
            type="number"
            id="monthlyBudget"
            value={budgetInput}
            onChange={(e) => setBudgetInput(e.target.value)}
            className="budget-input"
            placeholder="예: 1000000"
            required
          />
          <span className="currency-symbol">₩</span>
          {/* 예산 저장 버튼 */}
          <button onClick={handleSaveBudget} className="save-button">
            💾 저장하기
          </button>
        </div>
      </div>

      <ToastMessage
        message={toast.message}
        type={toast.type}
        onClose={closeToast}
      />
    </div>
  );
};

export default Settings;
