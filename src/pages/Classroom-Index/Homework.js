import React from 'react';
//import styled from 'styled-components';
//import palette from '../../lib/styles/palette';
//import { Link } from 'react-router-dom';
import HeaderContainer from '../../containers/base/HeaderContainer';
import HW from '../../containers/base/ClassroomIndex/HW';
import HomeworkBox from '../../containers/base/HomeworkBox';




const Homework = () => {
  return (
      <div>
          <HW/>
          <HomeworkBox></HomeworkBox>
          <HeaderContainer/>
      </div>


  );    
};

export default Homework;