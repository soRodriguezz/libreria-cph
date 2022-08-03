import React , {useEffect, useState } from 'react';
import logo from './logo.svg';
import './App.css';
import {
  BrowserRouter as Router,
  Routes,
  Route,
} from "react-router-dom";
import Login from './components/login/index'
import HomeBook from './components/books/index'



function App() {
  const validateToken = localStorage.getItem('token') || false;


  return (
    <Router>
    <div>
      <Routes>
        <Route path="/" element={ validateToken ? <HomeBook token={validateToken} /> :  <Login></Login> } />
      </Routes>
    </div>
  </Router>
  );
}

export default App;
