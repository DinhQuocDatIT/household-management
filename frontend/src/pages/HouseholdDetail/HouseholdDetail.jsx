import React from "react";
import HouseholdSummary from "../../components/HouseholdSummary/HouseholdSummary";
import MemberTable from "../../components/MemberTable/MemberTable";
import styles from "./HouseholdDetail.module.css";
import HouseholdDetailHeader from "../../components/HouseholdDetailHeader/HouseholdDetailHeader";
export default function HouseholdDetail() {
  const data = {
    household: {
      headName: "Nguyễn Văn A",
      status: "Bình thường",
      registrationDate: "12/05/2023",
      area: "Quận 1, TP.HCM",
      memberCount: 4,
    },
    logs: [
      {
        id: 1,
        action: "Cập nhật địa chỉ",
        author: "Đạt",
        date: "12/04/2026",
        isActive: true,
      },
      {
        id: 2,
        action: "Đăng ký mới",
        author: "Hệ thống",
        date: "12/05/2023",
        isActive: false,
      },
    ],
    members: [
      {
        id: 1,
        name: "Nguyễn Văn A",
        initials: "VA",
        role: "Chủ hộ",
        gender: "Nam",
        age: 45,
        idNumber: "079085001234",
        hometown: "TP.HCM",
        colorClass: styles.bgBlue,
      },
      {
        id: 2,
        name: "Trần Thị B",
        initials: "TB",
        role: "Vợ",
        gender: "Nữ",
        age: 42,
        idNumber: "079085005678",
        hometown: "Long An",
        colorClass: styles.bgPink,
      },
    ],
  };

  return (
    <div className={styles.page}>
      <HouseholdDetailHeader householdId="HGD-2024-00892" />
      <HouseholdSummary household={data.household} />
      <MemberTable members={data.members} />
    </div>
  );
}
