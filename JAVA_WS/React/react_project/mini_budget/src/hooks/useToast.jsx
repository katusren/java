/* src/hooks/useToast.jsx */

/**
 * 토스트 메시지를 관리하고 메시지를 표시하거나 숨기는 커스텀 훅 입니다
 * @returns {
 * toast: { message: string, type: string },
 * showToast: (message: string, type: "success" | "error") => void,
 * closeToast: () => void
 * }
 */
import { useState, useCallback } from "react";

const useToast = () => {
  const [toast, setToast] = useState({ message: "", type: "" });

  const showToast = useCallback((message, type) => {
    setToast({ message, type });
  }, []);

  const closeToast = useCallback(() => {
    setToast({ message: "", type: "" });
  }, []);

  return { toast, showToast, closeToast };
};

export default useToast;
