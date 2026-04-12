import React from "react";
import { BrowserRouter, Routes, Route, Navigate } from "react-router-dom";
import DashboardLayout from "../components/layouts/DashboardLayout";
import HouseholdList from "../pages/HouseholdList/HouseholdList";
import HouseholdDetail from "../pages/HouseholdDetail/HouseholdDetail";

const AppRoutes = () => {
  return (
    <BrowserRouter>
      <DashboardLayout>
        <Routes>
          {/* Tự động điều hướng từ "/" sang trang danh sách hộ gia đình */}
          <Route path="/" element={<Navigate to="/households" />} />

          {/* Route cho trang danh sách */}
          <Route path="/households" element={<HouseholdList />} />

          {/* Các trang khác bạn sẽ tạo thêm sau này */}
          <Route path="/statistics" element={<HouseholdDetail />} />
          {/* <Route path="/settings" element={<div>Trang Cài đặt</div>} /> */}
        </Routes>
      </DashboardLayout>
    </BrowserRouter>
  );
};

export default AppRoutes;
