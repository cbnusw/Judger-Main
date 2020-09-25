import React from 'react';
import styled from 'styled-components';
//import palette from '../../lib/styles/palette';
//import { Link } from 'react-router-dom';
import HeaderContainer from '../../containers/Base/HeaderContainer';
import GD from '../../containers/Base/ClassroomIndex/GD';
import GradeBox from '../../containers/Base/GradeBox';


const Array = styled.div`
    display:flex;
    justify-content:space-evenly;
`;


const Homework = () => {
  return (
      <div>
          <GD/>
          <Array>
            <GradeBox/>
          </Array>
          <HeaderContainer/>
      </div>


  );    
};

export default Homework;