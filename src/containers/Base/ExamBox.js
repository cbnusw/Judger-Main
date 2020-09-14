import React from 'react';
import styled from 'styled-components';
import Button from '../../components/common/Button';
//import palette from '../../lib/styles/palette';
import { Link } from 'react-router-dom';


const Header = styled.div`
    display:flex;
    .HeaderText{
        margin-top: 50px;
        margin-left: 100px;
        width: 368px;
        height: 67px;
        text-align: left;
        font: normal normal 600 40px/50px Segoe UI;
        letter-spacing: 0px;
        color: #181647;
        opacity: 1;
    }
`;

const Body = styled.div`
    display:flex;
    margin-left: 100px;
    width: 1300px;
    height: 400px;
    background: #FFFFFF 0% 0% no-repeat padding-box;
    border: 2px solid rgba(16,113,174);
    border-radius: 13px;
    opacity: 1;

`;

const Explanation = styled.div`
    margin-top: 30px;
    margin-left: 30px;
    width: 800px;
    height: 330px;
    background: #FFFFFF 0% 0% no-repeat padding-box;
    border-right:2px solid  #ced4da;
    opacity: 1;

    .ExText{
        font: normal normal 600 20px/40px Segoe UI;
        letter-spacing: 0px;
        color: #000000;
        opacity: 1;
    }
`;

const TestDate = styled.div`
    margin-bottom:30px;
    width: 250px;
    height: 110px;
    background: #FFFFFF 0% 0% no-repeat padding-box;
    border: 2px solid #ced4da;
    border-radius: 11px;
    opacity: 1;
    .TextArrayHead{
        font: normal normal 600 18px Segoe UI;
        letter-spacing: 0px;
        color: #5D5D5D;
        opacity: 1;
        text-align: center
    }
    .TextArray{
        font: normal normal 600 16px Segoe UI;
        letter-spacing: 0px;
        color: #000000;
        opacity: 1;
        text-align: center
    }
`;

const DeadDate = styled.div`
    width: 250px;
    height: 110px;
    background: #FFFFFF 0% 0% no-repeat padding-box;
    border: 2px solid #ced4da;
    border-radius: 11px;
    opacity: 1;
    .TextArrayHead{
        font: normal normal 600 18px Segoe UI;
        letter-spacing: 0px;
        color: #5D5D5D;
        opacity: 1;
        text-align: center
    }
    .TextArray{
        font: normal normal 600 16px Segoe UI;
        letter-spacing: 0px;
        color: #000000;
        opacity: 1;
        text-align: center
    }
`;

const Date = styled.div`
    margin-top: 70px;
    margin-left: 100px;
    display : inline;
`;


const GradeBox = () => {
  return (
      <div style={{ marginBottom:'100px' }}>
        <Header>
            <p className="HeaderText">MIDDLE - EXAM</p>
            <Link to="/examTest"><Button style={{ marginTop:'85px', marginLeft:'750px'}}>시험 시작하기</Button></Link>
        </Header>
        <Body>
            <Explanation>
                <p className="ExText">
                # 주의 사항 <br/><br/>
                1. Listen to the invited lecture carefully. <br/>
                2. Submit a short summary report of what you understand. <br/>
                Deadline: June 26, 2020, 18:00  <br/>
                You can receive up to THREE points if you enter the lecture and write a short report  <br/>
                (one point for attendance and two points for report).                                                                                                                  
                </p>
            </Explanation>
            <Date>
                <TestDate>
                    <p className="TextArrayHead">시험 일시</p>
                    <p className="TextArray">2020년 6월 26일 금요일</p>
                    <p className="TextArray">오후 4시</p>
                </TestDate>
                <DeadDate>
                    <p className="TextArrayHead">시험 일시</p>
                    <p className="TextArray">2020년 6월 26일 금요일</p>
                    <p className="TextArray">오후 4시</p>
                </DeadDate>
            </Date>
        </Body>
      </div>

  );    
};

export default GradeBox;