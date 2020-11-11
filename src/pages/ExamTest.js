import React from 'react';
import styled from 'styled-components';
//import palette from '../../lib/styles/palette';
//import { Link } from 'react-router-dom';
import HeaderContainer from '../containers/Base/HeaderContainer';
import Testcontent from '../containers/Base/ExamIndex/Testcontent';
import Testcommit from '../containers/Base/ExamIndex/Testcommit';

const Header = styled.div`
window.scrollTo(0, 0);
    border-bottom: 0.1px solid #707070;
    .HeaderText{
        margin-bottom: 3px;
        margin-top: 10px;
        margin-left: 93px;
        width: 80px;
        height: 38px;
        text-align: left;
        font: normal normal 600 25px/38px Segoe UI;
        letter-spacing: 0px;
        color: #000000;
        opacity: 1;
    }
    .HeaderBar{
        margin-left: 43px;
        width: 170px;
        height: 0px;
        border: 3px solid #000000;
        background-color: black;
        opacity: 1;
    }
`;

const TestContentBox = styled.div`
    display:flex;
    width: 600px;
    height: 850px;
    border-right: 0.1px solid #707070;
`;

const HeaderArray = styled.div`
    display:flex;
    margin-top: 85px;
`;

const RestTime = styled.div`
    padding-top:4px;
    margin-left:950px;
    display:flex;
    width: 250px;
    height: 40px;
    background: #FFFFFF 0% 0% no-repeat padding-box;
    border: 2px solid #B4B5B6;
    border-radius: 8px;
    opacity: 1;
    
    .Header{
        width: 180px;
        height: 28px;
        border-right: 1.5px solid #B4B5B6;
        font: normal normal 600 18px/30px Segoe UI;
        letter-spacing: 0px;
        color: #5D5D5D;
        opacity: 1;
        text-align: center;
    }
    .Time{
        width: 260px;
        height: 50px;
        text-align: center;
        font: normal normal 600 20px/30px Segoe UI;
        letter-spacing: 0px;
        color: #000000;
        opacity: 1;
    }
`;

const ExamTest = () => {
  return (
      <div>
          <Header>
              <HeaderArray>
                <p className="HeaderText">EXAM</p>
                <RestTime>
                    <p className="Header">남은시간</p>
                    <p className="Time">30분</p>
                </RestTime>
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