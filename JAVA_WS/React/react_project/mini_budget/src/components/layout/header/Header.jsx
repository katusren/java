/* src/components/layout/header/Header.jsx */

import React from "react";
import { Link } from "react-router-dom";
import "./Header.css";

const Header = () => {
  return (
    <header className="app-header">
      <div className="header-container">
        <Link to="/" className="app-title">
          CashNote
        </Link>
      </div>
    </header>
  );
};

export default Header;
