import React from 'react';
//import styled from './styled-components';
//import palette from '../../lib/styles/palette';
//import { Link } from 'react-router-dom';
import HeaderContainer from '../../containers/Base/HeaderContainer';
import GD from '../../containers/Base/ClassroomIndex/GD';
import GradeBox from '../../containers/Base/GradeBox';





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