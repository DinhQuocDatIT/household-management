import React from 'react';
import { motion } from 'framer-motion';
import styles from './StatsGrid.module.css';

const StatCard = ({ label, value, subValue, isPrimary, trend, index }) => {
  return (
    <motion.div
      initial={{ opacity: 0, y: 20 }}
      animate={{ opacity: 1, y: 0 }}
      transition={{ delay: index * 0.1 }}
      className={`${styles.statCard} ${isPrimary ? styles.primaryCard : styles.normalCard}`}
    >
      <span className={styles.label}>{label}</span>
      <div className={styles.valueRow}>
        <span className={styles.value}>{value}</span>
        {trend ? (
          <span className={isPrimary ? styles.trendPrimary : styles.trendNormal}>
            {trend}
          </span>
        ) : (
          <span className={styles.subValue}>{subValue}</span>
        )}
      </div>
    </motion.div>
  );
};

const StatsGrid = () => {
  const stats = [
    { label: "Tổng số hộ", value: "1,284", subValue: "", trend: "+2.4%" },
    { label: "Hộ Nghèo", value: "42", subValue: "3.2% tổng" },
    { label: "Hộ Cận Nghèo", value: "156", subValue: "12.1% tổng" },
    { label: "Bình Thường", value: "1,086", subValue: "84.5%", isPrimary: true },
  ];

  return (
    <div className={styles.grid}>
      {stats.map((stat, index) => (
        <StatCard key={index} {...stat} index={index} />
      ))}
    </div>
  );
};

export default StatsGrid;