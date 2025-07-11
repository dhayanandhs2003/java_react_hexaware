import React from 'react';
import { Link, Navigate } from 'react-router-dom';
import { jwtDecode } from 'jwt-decode';
import useDashboardStats from '../hooks/useDashboardStats';

function AdminDashboard() {
  const token = localStorage.getItem('token');
  const stats = useDashboardStats();
  let role = null;

  if (token) {
    try {
      const decoded = jwtDecode(token);
      role = decoded.role;
    } catch (err) {
      console.error('Invalid token');
    }
  }

  // 🚫 Redirect if not ADMIN_HR
  if (role !== 'ADMIN_HR') {
    return <Navigate to="/login" replace />;
  }

  return (
    <div className="container">
      <h2 className="mb-4">Welcome, Admin HR!</h2>
      <div className="card text-white bg-transparent border-light shadow" style={{ backdropFilter: "blur(10px)" }}>

        <div className="col-md-3">
          <div className="card text-white border-light bg-transparent">
            <div className="card-body text-center">
              <h5 className="card-title">Users</h5>
              <p className="card-text display-6">{stats.users}</p>
            </div>
          </div>
        </div>
        <div className="col-md-3">
          <div className="card text-white border-light bg-transparent">
            <div className="card-body text-center">
              <h5 className="card-title">Employees</h5>
              <p className="card-text display-6">{stats.employees}</p>
            </div>
          </div>
        </div>
        <div className="col-md-3">
          <div className="card text-white border-light bg-transparent">
            <div className="card-body text-center">
              <h5 className="card-title">Policies</h5>
              <p className="card-text display-6">{stats.policies}</p>
            </div>
          </div>
        </div>
        <div className="col-md-3">
          <div className="card text-white border-light bg-transparent">
            <div className="card-body text-center">
              <h5 className="card-title">Audit Logs</h5>
              <p className="card-text display-6">{stats.logs}</p>
            </div>
          </div>
        </div>
      </div>

      <div className="row">
        {/* Manage Users Card */}
        <div className="col-md-6 col-lg-3 mb-4">
          <div className="card h-100">
            <div className="card-body d-flex flex-column">
              <h5 className="card-title">Manage Users</h5>
              <p className="card-text">
                Create, update, or remove user accounts and assign roles.
              </p>
              <div className="mt-auto">
                <Link to="/manage-users" className="btn btn-primary w-100">
                  Go to Users
                </Link>
              </div>
            </div>
          </div>
        </div>

        {/* Manage Employees Card */}
        <div className="col-md-6 col-lg-3 mb-4">
          <div className="card h-100">
            <div className="card-body d-flex flex-column">
              <h5 className="card-title">Manage Employees</h5>
              <p className="card-text">
                Add new employees, view details, and manage department info.
              </p>
              <div className="mt-auto">
                <Link to="/manage-employees" className="btn btn-primary w-100">
                  Go to Employees
                </Link>
              </div>
            </div>
          </div>
        </div>

        {/* View Policies Card */}
        <div className="col-md-6 col-lg-3 mb-4">
          <div className="card h-100">
            <div className="card-body d-flex flex-column">
              <h5 className="card-title">View Policies</h5>
              <p className="card-text">
                Review and edit payroll and leave policies for the organization.
              </p>
              <div className="mt-auto">
                <Link to="/policies" className="btn btn-primary w-100">
                  View Policies
                </Link>
              </div>
            </div>
          </div>
        </div>

        {/* Audit Logs Card */}
        <div className="col-md-6 col-lg-3 mb-4">
          <div className="card h-100">
            <div className="card-body d-flex flex-column">
              <h5 className="card-title">Audit Logs</h5>
              <p className="card-text">
                Track system activities and user actions for security auditing.
              </p>
              <div className="mt-auto">
                <Link to="/audit-logs" className="btn btn-primary w-100">
                  View Logs
                </Link>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}

export default AdminDashboard;
