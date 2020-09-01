import React from 'react';
//import styled from './styled-components';
//import palette from '../../lib/styles/palette';
//import { Link } from 'react-router-dom';
import HeaderContainer from '../../containers/base/HeaderContainer';
import EX from '../../containers/base/ClassroomIndex/EX';
import ExamBox from '../../containers/base/ExamBox';




const Homework = () => {
  return (
      <div>
          <EX/>
          <ExamBox></ExamBox>
          <HeaderContainer/>
      </div>


  );    
};

export default Homework;