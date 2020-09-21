import React from 'react';
import {Route} from 'react-router-dom';
//import CarouselPage from './pages/CarouselPage';
import LoginPage from './pages/LoginPage';
import RegisterPage from './pages/RegisterPage';
import ClassroomPage from './pages/ClassroomPage';
import Homework from './pages/Classroom-Index/Homework';
import Grade from './pages/Classroom-Index/Grade';
import Exam from './pages/Classroom-Index/Exam';
import ExamTest from './pages/ExamTest';
import Homeworkcontent from './pages/Homeworkcontent';
import HomeworkCheck from './pages/HomeworkCheck';
import HomeworkSubmit from './pages/HomeworkSubmit';
import ExamCheck from './pages/ExamCheck';
import ImagePass from './pages/test/imagepass';

const App = () => {
  return (
    <>
      <Route component={ImagePass} path="/"exact />
      {/* <Route component={CarouselPage} path={['/@:username', '/']}exact /> */}
      <Route component={LoginPage} path="/login" />
      <Route component={RegisterPage} path="/register" />
      <Route component={ClassroomPage} path="/classroom" />
      <Route component={ExamTest} path="/examTest" />
      <Route component={ExamCheck} path="/examCheck" />
      <Route component={Homework} path="/classroom-Index/homework" />
      <Route component={Grade} path="/classroom-Index/grade" />
      <Route component={Exam} path="/classroom-Index/exam" />
      <Route component={Homeworkcontent} path="/homeworkcontent" />
      <Route component={HomeworkCheck} path="/homeworkCheck" />
      <Route component={HomeworkSubmit} path="/HomeworkSubmit" />

    </>
  );
};

export default App;