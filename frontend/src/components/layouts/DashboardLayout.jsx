import React, { useState } from "react";
import Sidebar from "./Sidebar/Sidebar";
import TopBar from "./TopBar/TopBar";
import styles from "./DashboardLayout.module.css";

const DashboardLayout = ({ children }) => {
  const [isSidebarOpen, setSidebarOpen] = useState(false);

  const toggleSidebar = () => setSidebarOpen(!isSidebarOpen);
  const closeSidebar = () => setSidebarOpen(false);

  return (
    <div className={styles.wrapper}>
     
      {isSidebarOpen && (
        <div className={styles.overlay} onClick={closeSidebar} />
      )}

      {/* Sidebar Wrapper */}
      <aside className={`${styles.sidebarWrapper} ${isSidebarOpen ? styles.open : ""}`}>
        <Sidebar closeSidebar={closeSidebar} />
      </aside>

      {/* Vùng nội dung chính */}
      <div className={styles.mainContainer}>
        <TopBar onMenuClick={toggleSidebar} />
        <main className={styles.content}>
          {children}
        </main>
      </div>
    </div>
  );
};

export default DashboardLayout;