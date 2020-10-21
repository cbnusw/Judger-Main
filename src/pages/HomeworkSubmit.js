import React from 'react';
import styled from 'styled-components';
//import palette from '../../lib/styles/palette';
//import { Link } from 'react-router-dom';
import HeaderContainer from '../containers/Base/HeaderContainer';
import Testcontent from '../containers/Base/Homework/Testcontent';
import Testcommit from '../containers/Base/Homework/Testcommit';

const Header = styled.div`
    border-bottom: 0.1px solid #707070;
    .HeaderText{
        margin-bottom: 3px;
        margin-top: 10px;
        margin-left: 93px;
        width: 200px;
        height: 38px;
        text-align: left;
        font: normal 600 25px/38px Segoe UI;
        color: #000000;
        opacity: 1;
    }
    .HeaderBar{
        margin-left: 55px;
        width: 170px;
        height: 0px;
        border: 2px solid #000000;
        background-color: black;
        opacity: 1;
    }
`;

const TestContentBox = styled.div`
    display:flex;
    width: 600px;
    height: 850px;
    border-right: 1px solid #707070;
`;

const HeaderArray = styled.div`
    display:flex;
    margin-top: 85px;    
`;



const ExamTest = () => {
  return (
      <div>
          <Header>
              <HeaderArray>
                <p className="HeaderText">과제 제출</p>
              </HeaderArray>
            <div className="HeaderBar"></div>
          </Header>
          <TestContentBox>
              <Testcontent/>
              <Testcommit/>
          </TestContentBox>
          <HeaderContainer/>
      </div>


  );    
};

export default ExamTest;