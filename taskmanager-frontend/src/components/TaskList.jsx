import React, { useEffect, useState } from 'react';
import API from '../services/api';
import TaskCard from './TaskCard';
import TaskForm from './TaskForm';

function TaskList() {
  const [tasks, setTasks] = useState([]);
  const [editingTask, setEditingTask] = useState(null);

  const fetchTasks = async () => {
    try {
      const res = await API.get('/tasks');
      setTasks(res.data);
    } catch (err) {
      alert('Error fetching tasks');
    }
  };

  useEffect(() => {
    fetchTasks();
  }, []);

  const handleDelete = async (id) => {
    if (window.confirm('Are you sure you want to delete this task?')) {
      await API.delete(`/tasks/${id}`);
      fetchTasks();
    }
  };

  const handleEdit = (task) => {
    setEditingTask(task);
  };

  const handleFormSubmit = () => {
    setEditingTask(null);
    fetchTasks();
  };

  return (
    <div className="container mt-4">
      <h3 className="mb-4">My Tasks</h3>
      <div className="row">
        {/* Left: Form + Search */}
        <div className="col-md-5">
          <TaskForm task={editingTask} onSuccess={handleFormSubmit} />
        </div>

        {/* Right: List of tasks */}
        <div className="col-md-7">
          {tasks.length === 0 ? (
            <p>No tasks found.</p>
          ) : (
            tasks.map((task) => (
              <TaskCard
                key={task.id}
                task={task}
                onEdit={handleEdit}
                onDelete={handleDelete}
              />
            ))
          )}
        </div>
      </div>
    </div>
  );
}

export default TaskList;
