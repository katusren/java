import { useState } from "react";
import { useNavigate, Link } from "react-router-dom";
import { useForm } from "react-hook-form"; //검증관리, 폼관리
import { Eye, EyeOff, Lock, User, Mail, UserCheck } from "lucide-react";
import { authAPI } from "../services/api";
import Button from "../components/Button";
import Input from "../components/Input";
import toast from "react-hot-toast"; //알림

const SignUp = () => {
  const navigate = useNavigate();
  const [showPassword, setShowPassword] = useState(false);
  const [showConfirmPassword, setShowConfirmPassword] = useState(false);
  const [loading, setLoading] = useState(false);

  const {
    register, //입력 필드 폼에 등록
    handleSubmit, //제출 관리
    watch, //실시간 감지
    formState: { errors }, //검증 객체
  } = useForm();

  const password = watch("password"); //비번 확인

  //폼 제출 핸들러
  const onSubmit = async (data) => {
    try {
      setLoading(true);
      await authAPI.signUp(data); //암호화후 회원가입
      toast.success("회원가입에 성공했습니다! 로그인해주세요.");
      navigate("/login");
    } catch (error) {
      const message =
        error.response?.data?.message || "회원가입에 실패했습니다.";
      toast.error(message);
    } finally {
      setLoading(false);
    }
  };
  return (
    // 반응형 패딩
    <div className="min-h-screen bg-gray-50 flex flex-col justify-center py-12 sm:px-6 lg:px-8">
      {/* 반응형 너비 */}
      <div className="sm:mx-auto sm:w-full sm:max-w-md">
        <div className="text-center">
          {/* 반응형 텍스트 */}
          <h2 className="text-3xl font-bold text-gray-900">🛍️ 쇼핑몰</h2>
          <p className="mt-2 text-sm text-gray-600">새로운 계정을 만드세요</p>
        </div>
      </div>
      {/* 반응형 간격 */}
      <div className="mt-8 sm:mx-auto sm:w-full sm:max-w-md">
        <div className="card py-8 px-4 sm:px-10">
          <form className="space-y-6" onSubmit={handleSubmit(onSubmit)}>
            <div>
              <Input
                label="사용자명"
                type="text"
                placeholder="사용자명을 입력하세요"
                {...register("username", {
                  required: "사용자명을 입력해주세요.",
                  minLength: {
                    value: 3,
                    message: "사용자명은 최소 3자 이상이어야 합니다.",
                  },
                  pattern: {
                    value: /^[a-zA-Z0-9_]+$/,
                    message:
                      "사용자명은 영문, 숫자, 언더스코어만 사용 가능합니다.",
                  },
                })}
                error={errors.username?.message}
                icon={<User className="w-4 h-4" />}
              />
            </div>

            <div>
              <Input
                label="이메일"
                type="email"
                placeholder="이메일을 입력하세요"
                {...register("email", {
                  required: "이메일을 입력해주세요.",
                  pattern: {
                    value: /^[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,}$/i,
                    message: "올바른 이메일 형식을 입력해주세요.",
                  },
                })}
                error={errors.email?.message}
                icon={<Mail className="w-4 h-4" />}
              />
            </div>

            <div>
              <Input
                label="닉네임"
                type="text"
                placeholder="닉네임을 입력하세요"
                {...register("nickname", {
                  required: "닉네임을 입력해주세요.",
                  minLength: {
                    value: 2,
                    message: "닉네임은 최소 2자 이상이어야 합니다.",
                  },
                })}
                error={errors.nickname?.message}
                icon={<UserCheck className="w-4 h-4" />}
              />
            </div>

            <div>
              <div className="relative">
                <Input
                  label="비밀번호"
                  type={showPassword ? "text" : "password"}
                  placeholder="비밀번호를 입력하세요"
                  {...register("password", {
                    required: "비밀번호를 입력해주세요.",
                    minLength: {
                      value: 6,
                      message: "비밀번호는 최소 6자 이상이어야 합니다.",
                    },
                  })}
                  error={errors.password?.message}
                  icon={<Lock className="w-4 h-4" />}
                />
                <button
                  type="button"
                  className="absolute right-3 top-8 text-gray-400 hover:text-gray-600"
                  onClick={() => setShowPassword(!showPassword)}
                >
                  {showPassword ? (
                    <EyeOff className="w-4 h-4" />
                  ) : (
                    <Eye className="w-4 h-4" />
                  )}
                </button>
              </div>
            </div>

            <div>
              <div className="relative">
                <Input
                  label="비밀번호 확인"
                  type={showConfirmPassword ? "text" : "password"}
                  placeholder="비밀번호를 다시 입력하세요"
                  {...register("confirmPassword", {
                    required: "비밀번호 확인을 입력해주세요.",
                    validate: (value) =>
                      value === password || "비밀번호가 일치하지 않습니다.",
                  })}
                  error={errors.confirmPassword?.message}
                  icon={<Lock className="w-4 h-4" />}
                />
                <button
                  type="button"
                  className="absolute right-3 top-8 text-gray-400 hover:text-gray-600"
                  onClick={() => setShowConfirmPassword(!showConfirmPassword)}
                >
                  {showConfirmPassword ? (
                    <EyeOff className="w-4 h-4" />
                  ) : (
                    <Eye className="w-4 h-4" />
                  )}
                </button>
              </div>
            </div>

            <div>
              <Button type="submit" className="w-full" disabled={loading}>
                {loading ? "회원가입 중..." : "회원가입"}
              </Button>
            </div>
          </form>

          <div className="mt-6">
            <div className="relative">
              <div className="absolute inset-0 flex items-center">
                <div className="w-full border-t border-gray-300" />
              </div>
              <div className="relative flex justify-center text-sm">
                <span className="px-2 bg-white text-gray-500">
                  이미 계정이 있으신가요?
                </span>
              </div>
            </div>

            <div className="mt-6">
              <Link
                to="/login"
                className="w-full flex justify-center py-2 px-4 border border-transparent rounded-md shadow-sm text-sm font-medium text-primary-600 bg-white hover:bg-gray-50 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-primary-500"
              >
                로그인
              </Link>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default SignUp;
