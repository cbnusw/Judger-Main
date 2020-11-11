import React from 'react';
import styled from 'styled-components';
//import palette from '../../lib/styles/palette';
import { Link } from 'react-router-dom';
import Button from '../../components/common/Button';



const Header = styled.div`
    display:flex;
    .HeaderText{
        margin-top: 100px;
        margin-left: 100px;
        width: 368px;
        height: 35px;
        text-align: left;
        font: normal normal bold 30px/13px Segoe UI;
        letter-spacing: 0px;
        color: #000000;
        opacity: 1;
    }
`;

const Body = styled.div`
    display:flex;
    margin-left: 100px;
    width: 1300px;
    height: 400px;
    background: #FFFFFF 0% 0% no-repeat padding-box;
    border: 1px solid #aab7ad;
    border-radius: 9px;
    opacity: 1;

`;

const Title = styled.div`
    margin-top: 10px;
    margin-left: 10px;
    width: 140px;
    height: 370px;
    background: #FFFFFF 0% 0% no-repeat padding-box;
    border-right:2px solid  #ced4da;
    opacity: 1;

    .ExText{
        padding-top: 50px;
        padding-left: 20px;
        text-align: left;
        font: normal normal 600 20px/13px Segoe UI;
        letter-spacing: 0px;
        color: #000000;
        opacity: 1;
    }
`;

const Explanation = styled.div`
    margin-top: 30px;
    margin-left: 30px;
    width: 800px;
    height: 330px;
    background: #FFFFFF 0% 0% no-repeat padding-box;
    opacity: 1;
    .ExText{
        font: normal normal 600 15px/40px Segoe UI;
        letter-spacing: 0px;
        color: #000000;
        opacity: 1;
    }
`;

const TestDate = styled.div`
    margin-right:30px;
    padding:10px;
    width: 250px;
    height: 110px;
    background: #FFFFFF 0% 0% no-repeat padding-box;
    border: 2px solid #ced4da;
    border-radius: 9px;
    opacity: 1;
    .TextArrayHead{
        margin-bottom:10px;
        font: normal normal 600 16px Segoe UI;
        letter-spacing: 0px;
        color: #5D5D5D;
        opacity: 1;
        text-align: center
    }
    .TextArray{
        margin-bottom:10px;
        font: normal normal 600 16px Segoe UI;
        letter-spacing: 0px;
        color: #000000;
        opacity: 1;
        text-align: center
    }
`;

const DeadDate = styled.div`
    padding:10px;
    width: 250px;
    height: 110px;
    background: #FFFFFF 0% 0% no-repeat padding-box;
    border: 2px solid #ced4da;
    border-radius: 9px;
    opacity: 1;
    .TextArrayHead{
        margin-bottom:10px;
        font: normal normal 600 16px Segoe UI;
        letter-spacing: 0px;
        color: #5D5D5D;
        opacity: 1;
        text-align: center
    }
    .TextArray{
        margin-bottom:10px;
        font: normal normal 600 16px Segoe UI;
        letter-spacing: 0px;
        color: #000000;
        opacity: 1;
        text-align: center
    }
`;

const Date = styled.div`
    display:flex;
`;

const Array = styled.div`
    display:inline;
`;


const ExamTest = () => {
  return (
        <div style={{ marginBottom:'100px' }}>
        <Header>
            <p className="HeaderText">Homework 1</p>
        </Header>
        <Body>
            <Title>
                <p className="ExText">과제 정보</p>
            </Title>
            <Array>
                <Explanation>
                    <p className="ExText">
                    1. Listen to the invited lecture carefully. <br/>
                    2. Submit a short summary report of what you understand. <br/>
                    Deadline: June 26, 2020, 18:00  <br/>
                    You can receive up to THREE points if you enter the lecture and write a short report  <br/>
                    (one point for attendance and two points for report).                                                                                                                  
                    </p>
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
                </Explanation>
            </Array>
        </Body>
        <Link to="/HomeworkSubmit"><Button style={{ marginTop:'30px', marginLeft:'1200px'}}>과제 제출</Button></Link>
    </div>


  );    
};

export default ExamTest;