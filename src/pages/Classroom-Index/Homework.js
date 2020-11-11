import React from 'react';
//import styled from 'styled-components';
//import palette from '../../lib/styles/palette';
//import { Link } from 'react-router-dom';
import HeaderContainer from '../../containers/Base/HeaderContainer';
import HW from '../../containers/Base/ClassroomIndex/HW';
import HomeworkBox from '../../containers/Base/HomeworkBox';




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