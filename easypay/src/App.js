import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Navbar from './components/Navbar';
import Footer from './components/Footer';
import Home from './pages/Home';
import Register from './pages/Register';
import Login from './pages/Login';

// Role-based dashboards
import AdminDashboard from './pages/AdminDashboard';
import EmployeeDashboard from './pages/EmployeeDashboard';
import PayrollDashboard from './pages/PayrollDashboard';
import ManagerDashboard from './pages/ManagerDashboard';
import SuperAdminDashboard from './pages/SuperAdminDashboard';

import { ToastContainer } from 'react-toastify'; // 🆕
import 'react-toastify/dist/ReactToastify.css'; // 🆕

// Manage Entities
import ManageUsers from './pages/ManageUsers';
import ManageEmployees from './pages/ManageEmployees';
import ManagePolicies from './pages/ManagePolicies';
import ManageAuditLogs from './pages/ManageAuditLogs';

function App() {
  return (
    <Router>
      <Navbar />

      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/register" element={<Register />} />
        <Route path="/login" element={<Login />} />

        {/* Role-based dashboard routes */}
        <Route
          path="/super_admin-dashboard"
          element={<SuperAdminDashboard />}
        />
        <Route path="/admin_hr-dashboard" element={<AdminDashboard />} />
        <Route path="/employee-dashboard" element={<EmployeeDashboard />} />
        <Route path="/payroll-dashboard" element={<PayrollDashboard />} />
        <Route path="/manager-dashboard" element={<ManagerDashboard />} />

        {/* manage users, employees */}
        <Route path="/manage-users" element={<ManageUsers />} />
        <Route path="/manage-employees" element={<ManageEmployees />} />
        <Route path="/policies" element={<ManagePolicies />} />
        <Route path="/audit-logs" element={<ManageAuditLogs />} />
      </Routes>
      <Footer />
      <ToastContainer />
    </Router>
  );
}

export default App;
