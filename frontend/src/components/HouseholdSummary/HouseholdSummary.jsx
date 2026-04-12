import React from 'react';
import { Home, Calendar, MapPin, Users } from 'lucide-react';
import styles from './HouseholdSummary.module.css';

export default function HouseholdSummary({ household }) {
  return (
    <section className={styles.container}>
      <div className={styles.decoration}></div>
      <div className={styles.content}>
        <div className={styles.mainInfo}>
          <div className={styles.iconBox}>
            <Home size={40} fill="currentColor" />
          </div>
          <div className={styles.details}>
            <div className={styles.titleRow}>
              <h3 className={styles.headName}>{household.headName}</h3>
              <span className={styles.statusBadge}>{household.status}</span>
            </div>
            <div className={styles.metaGrid}>
              <div className={styles.metaItem}>
                <Calendar size={18} />
                <span>Ngày đăng ký: {household.registrationDate}</span>
              </div>
              <div className={styles.metaItem}>
                <MapPin size={18} />
                <span>Khu vực: {household.area}</span>
              </div>
              <div className={styles.metaItem}>
                <Users size={18} />
                <span className={styles.highlight}>{household.memberCount} Thành viên</span>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
  );
}