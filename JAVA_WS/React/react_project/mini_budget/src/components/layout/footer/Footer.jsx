/* src/components/layout/footer/Footer.jsx */

import React from "react";
import { Link } from "react-router-dom";
import "./Footer.css";

const Footer = () => {
  const links = [
    { to: "/", icon: "🏠", text: "홈" },
    { to: "/add", icon: "➕", text: "등록" },
    { to: "/statistics", icon: "📊", text: "통계" },
    { to: "/settings", icon: "⚙️", text: "설정" },
  ];

  return (
    <footer className="app-footer">
      <nav className="footer-nav">
        {links.map(({ to, icon, text }) => (
          <Link
            key={to}
            to={to}
            className={`nav-item ${location.pathname === to ? "active" : ""}`}
          >
            <span className="nav-icon">{icon}</span>
            <span className="nav-text">{text}</span>
          </Link>
        ))}
      </nav>
    </footer>
  );
};

export default Footer;
