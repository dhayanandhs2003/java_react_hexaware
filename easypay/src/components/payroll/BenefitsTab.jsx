import React, { useEffect, useState } from 'react';
import payrollService from '../../services/payrollService';
import { toast } from 'react-toastify';

const initialForm = {
  employeeId: '',
  type: '',
  benefit: '',
  effectiveDate: '',
};

const BenefitsTab = () => {
  const [benefits, setBenefits] = useState([]);
  const [filteredBenefits, setFilteredBenefits] = useState([]);
  const [formData, setFormData] = useState(initialForm);
  const [editingId, setEditingId] = useState(null);

  // Filter inputs
  const [filterId, setFilterId] = useState('');
  const [filterEmpId, setFilterEmpId] = useState('');
  const [filterType, setFilterType] = useState('');
  const [filterBenefit, setFilterBenefit] = useState('');
  const [filterDate, setFilterDate] = useState('');

  useEffect(() => {
    fetchBenefits();
  }, []);

  const fetchBenefits = async () => {
    try {
      const res = await payrollService.getAllBenefits();
      setBenefits(res.data || []);
      setFilteredBenefits(res.data || []);
    } catch (err) {
      toast.error('Failed to fetch benefits.');
      console.error(err);
    }
  };

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData((prev) => ({ ...prev, [name]: value }));
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      if (editingId) {
        await payrollService.updateBenefit(editingId, formData);
        toast.success('Benefit updated!');
      } else {
        await payrollService.addBenefit(formData);
        toast.success('Benefit added!');
      }
      fetchBenefits();
      setFormData(initialForm);
      setEditingId(null);
    } catch (err) {
      toast.error('Failed to submit benefit.');
      console.error(err);
    }
  };

  const handleEdit = (benefit) => {
    setFormData({
      employeeId: benefit.employeeId,
      type: benefit.type,
      benefit: benefit.benefit,
      effectiveDate: benefit.effectiveDate,
    });
    setEditingId(benefit.benefitId);
  };

  const handleDelete = async (id) => {
    if (!window.confirm('Are you sure you want to delete this benefit?')) return;
    try {
      await payrollService.deleteBenefit(id);
      toast.success('Benefit deleted!');
      fetchBenefits();
    } catch (err) {
      toast.error('Failed to delete benefit.');
      console.error(err);
    }
  };

  // Filtering logic
  useEffect(() => {
    const filtered = benefits.filter((b) => {
      return (
        (!filterId || b.benefitId.toString().includes(filterId)) &&
        (!filterEmpId || b.employeeId.toString().includes(filterEmpId)) &&
        (!filterType || b.type.toLowerCase().includes(filterType.toLowerCase())) &&
        (!filterBenefit || b.benefit.toLowerCase().includes(filterBenefit.toLowerCase())) &&
        (!filterDate || b.effectiveDate.includes(filterDate))
      );
    });
    setFilteredBenefits(filtered);
  }, [filterId, filterEmpId, filterType, filterBenefit, filterDate, benefits]);

  return (
    <div>
      <h5 className="mb-3 text-black">Manage Employee Benefits</h5>

      {/* Filter row */}
      <div className="row mb-4">
        <div className="col-md-2">
          <input
            type="text"
            className="form-control"
            placeholder="Filter by Benefit ID"
            value={filterId}
            onChange={(e) => setFilterId(e.target.value)}
          />
        </div>
        <div className="col-md-2">
          <input
            type="text"
            className="form-control"
            placeholder="Filter by Employee ID"
            value={filterEmpId}
            onChange={(e) => setFilterEmpId(e.target.value)}
          />
        </div>
        <div className="col-md-2">
          <input
            type="text"
            className="form-control"
            placeholder="Filter by Type"
            value={filterType}
            onChange={(e) => setFilterType(e.target.value)}
          />
        </div>
        <div className="col-md-3">
          <input
            type="text"
            className="form-control"
            placeholder="Filter by Benefit"
            value={filterBenefit}
            onChange={(e) => setFilterBenefit(e.target.value)}
          />
        </div>
        <div className="col-md-3">
          <input
            type="date"
            className="form-control"
            value={filterDate}
            onChange={(e) => setFilterDate(e.target.value)}
          />
        </div>
      </div>

      {/* Form */}
      <form
        className="row gy-3 gx-4 p-4 rounded shadow-sm bg-light"
        onSubmit={handleSubmit}
      >
        {/* Existing input fields */}
        <div className="col-md-2">
          <label htmlFor="employeeId" className="form-label fw-semibold">
            Employee ID
          </label>
          <input
            type="number"
            name="employeeId"
            id="employeeId"
            className="form-control border-primary"
            placeholder="e.g. 1001"
            value={formData.employeeId}
            onChange={handleChange}
            required
          />
        </div>

        <div className="col-md-2">
          <label htmlFor="type" className="form-label fw-semibold">
            Type
          </label>
          <input
            type="text"
            name="type"
            id="type"
            className="form-control border-primary"
            placeholder="e.g. Medical"
            value={formData.type}
            onChange={handleChange}
            required
          />
        </div>

        <div className="col-md-2">
          <label htmlFor="benefit" className="form-label fw-semibold">
            Benefit
          </label>
          <input
            type="text"
            name="benefit"
            id="benefit"
            className="form-control border-primary"
            placeholder="e.g. Health Cover"
            value={formData.benefit}
            onChange={handleChange}
            required
          />
        </div>

        <div className="col-md-3">
          <label htmlFor="effectiveDate" className="form-label fw-semibold">
            Effective Date
          </label>
          <input
            type="date"
            name="effectiveDate"
            id="effectiveDate"
            className="form-control border-primary"
            value={formData.effectiveDate}
            onChange={handleChange}
            required
          />
        </div>

        <div className="col-md-3 d-flex align-items-end">
          <button type="submit" className="btn btn-success w-100 fw-semibold">
            {editingId ? 'Update Benefit' : 'Add Benefit'}
          </button>
        </div>
      </form>

      <br /><br />

      {/* Table */}
      <div className="table-responsive">
        <table className="employee-table table table-bordered">
          <thead className="table-dark">
            <tr>
              <th>Benefit ID</th>
              <th>Employee ID</th>
              <th>Type</th>
              <th>Benefit</th>
              <th>Effective Date</th>
              <th>Actions</th>
            </tr>
          </thead>
          <tbody>
            {filteredBenefits.length > 0 ? (
              filteredBenefits.map((b) => (
                <tr key={b.benefitId}>
                  <td>{b.benefitId}</td>
                  <td>{b.employeeId}</td>
                  <td>{b.type}</td>
                  <td>{b.benefit}</td>
                  <td>{b.effectiveDate}</td>
                  <td>
                    <button
                      onClick={() => handleEdit(b)}
                      className="btn btn-sm btn-warning me-2"
                    >
                      Edit
                    </button>
                    <button
                      onClick={() => handleDelete(b.benefitId)}
                      className="btn btn-sm btn-danger"
                    >
                      Delete
                    </button>
                  </td>
                </tr>
              ))
            ) : (
              <tr>
                <td colSpan="6" className="text-center text-muted">
                  No benefits found.
                </td>
              </tr>
            )}
          </tbody>
        </table>
      </div>
    </div>
  );
};

export default BenefitsTab;
