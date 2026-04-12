import React from "react";
import Sidebar from "./Sidebar/Sidebar";
import TopBar from "./TopBar/TopBar";
import styles from "./DashboardLayout.module.css";

const DashboardLayout = ({ children }) => {
  return (
    <div className={styles.wrapper}>
      <aside className={styles.sidebarWrapper}>
        <Sidebar />
      </aside>

      <div className={styles.mainContainer}>
        <TopBar />
        <main className={styles.content}>{children}</main>
      </div>
    </div>
  );
};

export default DashboardLayout;
