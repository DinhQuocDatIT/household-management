import React from "react";
import {
  Table as TableIcon,
  Filter,
  Download,
  MoreVertical,
} from "lucide-react";
import styles from "./MemberTable.module.css";

export default function MemberTable({ members }) {
  return (
    <section className={styles.card}>
      <div className={styles.header}>
        <h4 className={styles.title}>
          <TableIcon className={styles.icon} size={20} />
          Danh sách thành viên
        </h4>

        <div className={styles.actions}>
          <button className={styles.toolBtn}>
            <Filter size={18} />
          </button>
          <button className={styles.toolBtn}>
            <Download size={18} />
          </button>
        </div>
      </div>

      <div className={styles.tableWrapper}>
        <table className={styles.table}>
          <thead>
            <tr>
              <th>CCCD/Định danh</th>
              <th>Họ và Tên</th>
              <th>Giới tính</th>
              <th style={{ textAlign: "center" }}>Ngày sinh</th>
              <th>Quê quán</th>
              <th style={{ textAlign: "right" }}>Thao tác</th>
            </tr>
          </thead>

          <tbody>
            {members.map((member) => (
              <tr key={member.id}>
                {/* CCCD */}
                <td className={styles.mono}>{member.idNumber}</td>

                {/* NAME */}
                <td>
                  <div className={styles.userCell}>
                    
                    <div>
                      <p className={styles.userName}>{member.name}</p>
                      <p
                        className={
                          member.role === "Chủ hộ"
                            ? styles.rolePrimary
                            : styles.roleSecondary
                        }
                      >
                        {member.role}
                      </p>
                    </div>
                  </div>
                </td>

                <td>{member.gender}</td>

                {/* DOB */}
                <td style={{ textAlign: "center" }}>{member.dateOfBirth}</td>

                <td>{member.hometown}</td>

                <td style={{ textAlign: "right" }}>
                  <button className={styles.moreBtn}>
                    <MoreVertical size={18} />
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </section>
  );
}
