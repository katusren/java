import { clsx } from "clsx";
import { twMerge } from "tailwind-merge";

export function cn(...inputs) {
  return twMerge(clsx(inputs)); // 중복되거나 충돌되는 tailwind설정 자동으로 정리
}
