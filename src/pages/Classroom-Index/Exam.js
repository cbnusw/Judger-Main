import React from 'react';
//import styled from './styled-components';
//import palette from '../../lib/styles/palette';
//import { Link } from 'react-router-dom';
import HeaderContainer from '../../containers/Base/HeaderContainer';
import EX from '../../containers/Base/ClassroomIndex/EX';
import ExamBox from '../../containers/Base/ExamBox';




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