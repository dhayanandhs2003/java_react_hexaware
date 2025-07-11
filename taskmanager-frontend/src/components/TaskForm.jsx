import React, { useEffect, useState } from 'react';
import API from '../services/api';

function TaskForm({ task, onSuccess }) {
  const [formData, setFormData] = useState({
    title: '',
    description: '',
    dueDate: '',
    priority: 'MEDIUM',
    status: 'PENDING',
  });

  const [searchId, setSearchId] = useState('');

  useEffect(() => {
    if (task) {
      setFormData(task);
    }
  }, [task]);

  const handleChange = (e) => {
    setFormData((prev) => ({ ...prev, [e.target.name]: e.target.value }));
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      if (task) {
        await API.put(`/tasks/${task.id}`, formData);
      } else {
        await API.post('/tasks', formData);
      }
      setFormData({
        title: '',
        description: '',
        dueDate: '',
        priority: 'MEDIUM',
        status: 'PENDING',
      });
      onSuccess();
    } catch (err) {
      alert('Failed to save task');
    }
  };

  const handleSearch = async () => {
    if (!searchId) return alert('Enter Task ID to search');
    try {
      const res = await API.get(`/tasks/${searchId}`);
      setFormData(res.data);
    } catch (err) {
      alert('Task not found');
    }
  };

  return (
    <>
      {/* 🔍 Search Task by ID */}
      <div className="mb-3">
        <div className="input-group">
          <input
            type="text"
            className="form-control"
            placeholder="Search Task by ID"
            value={searchId}
            onChange={(e) => setSearchId(e.target.value)}
          />
          <button className="btn btn-secondary" onClick={handleSearch}>
            Search
          </button>
        </div>
      </div>

      {/* 📝 Task Form */}
      <form onSubmit={handleSubmit}>
        <div className="mb-3">
          <input
            type="text"
            name="title"
            value={formData.title}
            onChange={handleChange}
            placeholder="Title"
            className="form-control"
            required
          />
        </div>
        <div className="mb-3">
          <input
            type="text"
            name="description"
            value={formData.description}
            onChange={handleChange}
            placeholder="Description"
            className="form-control"
          />
        </div>
        <div className="mb-3">
          <input
            type="date"
            name="dueDate"
            value={formData.dueDate}
            onChange={handleChange}
            className="form-control"
            required
          />
        </div>
        <div className="mb-3">
          <select
            name="priority"
            value={formData.priority}
            onChange={handleChange}
            className="form-select"
          >
            <option value="LOW">Low</option>
            <option value="MEDIUM">Medium</option>
            <option value="HIGH">High</option>
          </select>
        </div>
        <div className="mb-3">
          <select
            name="status"
            value={formData.status}
            onChange={handleChange}
            className="form-select"
          >
            <option value="PENDING">Pending</option>
            <option value="IN_PROGRESS">In Progress</option>
            <option value="COMPLETED">Completed</option>
          </select>
        </div>
        <div className="mb-3">
          <button className="btn btn-primary w-100" type="submit">
            {task ? 'Update' : 'Add'} Task
          </button>
        </div>
      </form>
    </>
  );
}

export default TaskForm;
