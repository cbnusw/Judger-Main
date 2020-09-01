import React from 'react';
//import styled from './styled-components';
//import palette from '../../lib/styles/palette';
//import { Link } from 'react-router-dom';
import HeaderContainer from '../../containers/base/HeaderContainer';
import GD from '../../containers/base/ClassroomIndex/GD';
import GradeBox from '../../containers/base/GradeBox';





const Homework = () => {
  return (
      <div>
          <GD/>
          <GradeBox></GradeBox>
          <HeaderContainer/>
      </div>


  );    
};

export default Homework;