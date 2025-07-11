import React from 'react';
import { Link } from 'react-router-dom';
import './Home.css'; // import the CSS

function Home() {
  const token = localStorage.getItem('token');

  return (
    <div className="home-container">
      <div className="home-content text-center">
        <h1 className="mb-3 text-white">Welcome to Task Manager</h1>
        <p className="lead text-light mb-4">
          {token
            ? 'Manage your tasks with ease.'
            : 'Track your goals and stay organized. Register or login to begin.'}
        </p>
        {token ? (
          <Link className="btn btn-light" to="/tasks">Go to My Tasks</Link>
        ) : (
          <div className="d-flex justify-content-center gap-3">
            <Link className="btn btn-light" to="/login">Login</Link>
            <Link className="btn btn-outline-light" to="/register">Register</Link>
          </div>
        )}
      </div>
    </div>
  );
}

export default Home;
