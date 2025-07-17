/* eslint-disable import/no-anonymous-default-export */
// services/payrollService.js
import axios from 'axios';

const BASE_URL = 'http://localhost:8080/api';

const getAuthHeaders = () => ({
  headers: {
    Authorization: `Bearer ${localStorage.getItem('token')}`,
  },
});

// Payroll
const getAllPayrolls = () => axios.get(`${BASE_URL}/payrolls`, getAuthHeaders());
const addPayroll = (data) => axios.post(`${BASE_URL}/payrolls`, data, getAuthHeaders());
const updatePayroll = (id, data) => axios.put(`${BASE_URL}/payrolls/${id}`, data, getAuthHeaders());
const deletePayroll = (id) => axios.delete(`${BASE_URL}/payrolls/${id}`, getAuthHeaders());

// Benefits
const getAllBenefits = () => axios.get(`${BASE_URL}/benefits`, getAuthHeaders());
const addBenefit = (data) => axios.post(`${BASE_URL}/benefits`, data, getAuthHeaders());
const updateBenefit = (id, data) => axios.put(`${BASE_URL}/benefits/${id}`, data, getAuthHeaders());
const deleteBenefit = (id) => axios.delete(`${BASE_URL}/benefits/${id}`, getAuthHeaders());

// Timesheets
const getAllTimesheets = () => axios.get(`${BASE_URL}/timesheets`, getAuthHeaders());
const updateTimesheet = (id, data) => axios.put(`${BASE_URL}/timesheets/${id}`, data, getAuthHeaders()); // ✅ Added this

export default {
  // Payroll
  getAllPayrolls,
  addPayroll,
  updatePayroll,
  deletePayroll,

  // Benefits
  getAllBenefits,
  addBenefit,
  updateBenefit,
  deleteBenefit,

  // Timesheets
  getAllTimesheets,
  updateTimesheet, // ✅ Make sure this is exported
};
