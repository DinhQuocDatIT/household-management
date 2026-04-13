import React from "react";
import { NavLink } from "react-router-dom"; // Dùng NavLink thay cho <a>
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import {
  faUsers,
  faChartLine,
  faGear,
  faShieldHalved,
  faXmark,
} from "@fortawesome/free-solid-svg-icons";
import styles from "./Sidebar.module.css";

const Sidebar = ({ closeSidebar }) => {
  const menuItems = [
    { icon: faUsers, label: "Danh sách hộ gia đình", path: "/households" },
    { icon: faChartLine, label: "Thống kê", path: "/statistics" },
    { icon: faGear, label: "Cài đặt", path: "/settings" },
  ];

  return (
    <div className={styles.sidebar}>
      <div className={styles.brandContainer}>
        <div className={styles.logoWrapper}>
          <div className={styles.iconBox}>
            <FontAwesomeIcon icon={faShieldHalved} size="lg" />
          </div>
          <h1 className={styles.brandName}>LTHD</h1>
        </div>
        <button className={styles.closeBtn} onClick={closeSidebar}>
          <FontAwesomeIcon icon={faXmark} />
        </button>
      </div>

      <nav className={styles.nav}>
        {menuItems.map((item, index) => (
          <NavLink
            key={index}
            to={item.path}
            className={({ isActive }) =>
              `${styles.navItem} ${isActive ? styles.navItemActive : ""}`
            }
            onClick={closeSidebar}
          >
            <div className={styles.iconContainer}>
              <FontAwesomeIcon icon={item.icon} />
            </div>
            <span>{item.label}</span>
          </NavLink>
        ))}
      </nav>
    </div>
  );
};

export default Sidebar;
