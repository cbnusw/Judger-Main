import React from 'react';
import styled from 'styled-components';
//import palette from '../../lib/styles/palette';
//import { Link } from 'react-router-dom';
import HeaderContainer from '../../containers/Base/HeaderContainer';
import EX from '../../containers/Base/ClassroomIndex/EX';
import ExamBox from '../../containers/Base/ExamBox';


const Array = styled.div`
    display:flex;
    justify-content:space-evenly;
`;

const Homework = () => {
  return (
      <div>
          <EX/>
          <Array>
            <ExamBox/>
          </Array>
          <HeaderContainer/>
      </div>


  );    
};

export default Homework;