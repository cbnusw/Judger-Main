import React from 'react';
import {Route} from 'react-router-dom';
import CarouselPage from './pages/CarouselPage';
import LoginPage from './pages/LoginPage';
import RegisterPage from './pages/RegisterPage';

const App = () => {
  return (
    <>
      <Route component={CarouselPage} path={['/@:username', '/']}exact />
      <Route component={LoginPage} path="/login" />
      <Route component={RegisterPage} path="/register" />
    </>
  );
};

export default App;