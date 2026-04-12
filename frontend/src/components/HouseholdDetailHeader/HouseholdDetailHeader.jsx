import React from "react";
import { ArrowLeft, Edit3, UserPlus } from "lucide-react";
import styles from "./HouseholdDetailHeader.module.css";

export default function HouseholdDetailHeader({ householdId }) {
  return (
    <div className={styles.header}>
      <div className={styles.leftGroup}>
        <button className={styles.backBtn}>
          <ArrowLeft size={24} />
        </button>
        <div className={styles.titleInfo}>
          <h1 className={styles.mainTitle}>Chi tiết hộ gia đình</h1>
          <p className={styles.subTitle}>Mã định danh: {householdId}</p>
        </div>
      </div>

      <div className={styles.rightGroup}>
        <button className={styles.secondaryBtn}>
          <Edit3 size={18} />
          <span>Sửa thông tin</span>
        </button>
        <button className={styles.primaryBtn}>
          <UserPlus size={18} />
          <span>Thêm thành viên</span>
        </button>
      </div>
    </div>
  );
}
