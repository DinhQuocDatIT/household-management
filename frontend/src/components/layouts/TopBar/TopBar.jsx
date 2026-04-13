import React from "react";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faSearch, faBell, faBars } from "@fortawesome/free-solid-svg-icons";
import styles from "./TopBar.module.css";
import svgreactjs from "../../../assets/react.svg";
const TopBar = ({ onMenuClick }) => {
  return (
    <header className={styles.topBar}>
      {/* Cụm 1: Menu & Title */}
      <div className={styles.leftGroup}>
        <button className={styles.menuBtn} onClick={onMenuClick}>
          <FontAwesomeIcon icon={faBars} />
        </button>
        <h2 className={styles.title}>Quản lý Hộ gia đình</h2>
      </div>

      {/* Cụm 2: Ô tìm kiếm (Sẽ nhảy xuống hàng riêng khi co màn hình) */}
      <div className={styles.searchContainer}>
        <div className={styles.searchWrapper}>
          <FontAwesomeIcon icon={faSearch} className={styles.searchIcon} />
          <input
            type="text"
            placeholder="Tìm kiếm theo tên hoặc mã hộ..."
            className={styles.searchInput}
          />
        </div>
      </div>

      {/* Cụm 3: Thông báo & Avatar */}
      <div className={styles.rightGroup}>
        <button className={styles.iconBtn}>
          <FontAwesomeIcon icon={faBell} />
          <span className={styles.badge}></span>
        </button>
        <div className={styles.divider}></div>
        <img src={svgreactjs} className={styles.avatar} alt="Admin" />
      </div>
    </header>
  );
};

export default TopBar;
