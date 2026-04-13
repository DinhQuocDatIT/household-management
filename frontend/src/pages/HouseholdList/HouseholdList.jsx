import React from 'react';
import { motion } from 'framer-motion';
import { Eye, Edit2, Plus, ChevronLeft, ChevronRight, LayoutGrid } from 'lucide-react';
import StatsGrid from '../../components/StatsGrid/StatsGrid';
import styles from './HouseholdList.module.css';

const households = [
  { id: 'HK-2023-001', owner: 'Nguyễn Văn A', initials: 'NV', type: 'Bình thường', address: '123 Đường Lê Lợi, Quận 1' },
  { id: 'HK-2023-042', owner: 'Trần Thị Lành', initials: 'TL', type: 'Hộ Nghèo', address: '45 Hẻm 67, Phường 5, Quận 3' },
  { id: 'HK-2023-115', owner: 'Lý Mạnh Hùng', initials: 'LM', type: 'Cận nghèo', address: '89/22 Nguyễn Huệ, Quận 1' },
  { id: 'HK-2023-201', owner: 'Phạm Thanh Tâm', initials: 'PT', type: 'Bình thường', address: '202 Võ Văn Kiệt, Quận 5' },
];

const HouseholdList = () => {
  return (
    <div className={styles.container}>
      <header className={styles.header}>
        <div className={styles.titleGroup}>
          <div className={styles.iconDecor}><LayoutGrid size={20} /></div>
    
        </div>
        <button className={styles.addBtn}>
          <Plus size={20} />
          <span>Thêm hộ mới</span>
        </button>
      </header>

      {/* Tầng 1: Thống kê (Đã chỉnh lại giao diện trong StatsGrid) */}
      <StatsGrid />

      {/* Tầng 2: Bảng dữ liệu Glassmorphism */}
      <div className={styles.tableSection}>
        <div className={styles.tableScroll}>
          <table className={styles.table}>
            <thead>
              <tr>
                <th>Mã Hộ Khẩu</th>
                <th>Chủ Hộ</th>
                <th>Phân Loại</th>
                <th>Địa Chỉ</th>
                <th style={{ textAlign: 'right' }}>Thao Tác</th>
              </tr>
            </thead>
            <tbody>
              {households.map((hh, idx) => (
                <motion.tr 
                  key={hh.id}
                  initial={{ opacity: 0, y: 15 }}
                  animate={{ opacity: 1, y: 0 }}
                  transition={{ delay: idx * 0.1 }}
                  className={styles.tableRow}
                >
                  <td className={styles.idCell}><span>{hh.id}</span></td>
                  <td>
                    <div className={styles.ownerInfo}>
                    
                      <span className={styles.ownerName}>{hh.owner}</span>
                    </div>
                  </td>
                  <td>
                    <div className={`${styles.statusTag} ${
                      hh.type === 'Hộ Nghèo' ? styles.poor : 
                      hh.type === 'Cận nghèo' ? styles.nearPoor : styles.normal
                    }`}>
                      <div className={styles.dot} />
                      {hh.type}
                    </div>
                  </td>
                  <td className={styles.addressCell}>{hh.address}</td>
                  <td>
                    <div className={styles.actions}>
                      <button className={styles.btnIcon}><Eye size={16} /></button>
                      <button className={styles.btnIcon}><Edit2 size={16} /></button>
                    </div>
                  </td>
                </motion.tr>
              ))}
            </tbody>
          </table>
        </div>

        <footer className={styles.footer}>
          <p>Hiển thị <b>5</b> trên <b>1,284</b> hộ</p>
          <div className={styles.pagination}>
            <button className={styles.arrowBtn}><ChevronLeft size={18} /></button>
            <button className={`${styles.pageBtn} ${styles.activePage}`}>1</button>
            <button className={styles.pageBtn}>2</button>
            <button className={styles.arrowBtn}><ChevronRight size={18} /></button>
          </div>
        </footer>
      </div>
    </div>
  );
};

export default HouseholdList;