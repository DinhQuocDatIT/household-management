import React from "react";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import {
  faUsers,
  faChartLine,
  faGear,
  faShieldHalved,
} from "@fortawesome/free-solid-svg-icons";
import styles from "./Sidebar.module.css";

const Sidebar = () => {
  const menuItems = [
    { icon: faUsers, label: "Danh sách hộ gia đình", active: true },
    { icon: faChartLine, label: "Thống kê", active: false },
    { icon: faGear, label: "Cài đặt", active: false },
  ];

  return (
    <div className={styles.sidebar}>
      <div className={styles.brandContainer}>
        <div className={styles.logoWrapper}>
          <div className={styles.iconBox}>
            <FontAwesomeIcon icon={faShieldHalved} size="lg" />
          </div>
          <h1 className={styles.brandName}>The Sovereign</h1>
        </div>
        <p className={styles.brandSub}>Administrative Interface</p>
      </div>

      <nav className={styles.nav}>
        {menuItems.map((item, index) => (
          <a
            key={index}
            href="#"
            className={`${styles.navItem} ${item.active ? styles.navItemActive : ""}`}
          >
            <div className={styles.iconContainer}>
              <FontAwesomeIcon icon={item.icon} />
            </div>
            <span>{item.label}</span>
          </a>
        ))}
      </nav>
    </div>
  );
};

export default Sidebar;
