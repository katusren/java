/* src/components/layout/Layout.jsx */

import React from "react";
import Header from "./header/Header"; 
import Footer from "./footer/Footer";
import "./Layout.css";

const Layout = ({ children }) => {
  return (
    <div className="layout-container">
      {/* 상단 헤더 */}
      <Header />

      <main className="main-content">{children}</main>

      {/* 하단 푸터 */}
      <Footer />
    </div>
  );
};

export default Layout;
