import React from 'react';
import {Route} from 'react-router-dom';
import DashboardPage from './pages/DashboardPage';
import LoginPage from './pages/LoginPage';
import RegisterPage from './pages/RegisterPage';
import ClassroomPage from './pages/ClassroomPage';
import Classdetail from './pages/Classdetail';
import Homework from './pages/Classroom/Homework';


const App = () => {
  return (
    <>
      <Route component={DashboardPage} path={['/@:username', '/']}exact />
      <Route component={LoginPage} path="/login" />
      <Route component={RegisterPage} path="/register" />
      <Route component={ClassroomPage} path="/classroom" />
      <Route component={Classdetail} path="/classdetail" />
      <Route component={Homework} path="/classroom/Homework" />
    </>
  );
};

export default App;