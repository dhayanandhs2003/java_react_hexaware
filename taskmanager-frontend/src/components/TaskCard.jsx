import React from 'react';

function TaskCard({ task, onEdit, onDelete }) {
  return (
    <div className="card mb-3 shadow-sm">
      <div className="card-body">
        <h5 className="card-title">{task.title}</h5>
        <p className="card-text">{task.description}</p>
        <p className="card-text">
          <strong>Due:</strong> {task.dueDate} <br />
          <strong>Priority:</strong> {task.priority} <br />
          <strong>Status:</strong> {task.status}
        </p>
        <button className="btn btn-sm btn-outline-primary me-2" onClick={() => onEdit(task)}>Edit</button>
        <button className="btn btn-sm btn-outline-danger" onClick={() => onDelete(task.id)}>Delete</button>
      </div>
    </div>
  );
}

export default TaskCard;
