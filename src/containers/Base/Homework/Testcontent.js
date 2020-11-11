import React, { Component } from 'react';
import styled from 'styled-components';
//import palette from '../../lib/styles/palette';


const Header = styled.div`
    padding-top: 25px;
    padding-left: 50px;
    .HeaderText{
        text-align: left;
        font: normal normal 600 18px/30px Segoe UI;
        letter-spacing: 0px;
        color: #000000;
        opacity: 1;
    }
`;

const Index = styled.div`
    padding-top: 25px;
    padding-left: 50px;
    .HeaderText{
        text-align: left;
        font: normal normal 600 18px/30px Segoe UI;
        letter-spacing: 0px;
        color: #000000;
        opacity: 1;
    }
    .HeaderContent{
        margin-left: 30px;
        width: 300px;
        height: 30px;
        background: #FFFFFF 0% 0% no-repeat padding-box;
        border: 1px solid #B4B5B6;
        border-radius: 4px;
        opacity: 1;
    }
`;

const IndexArray = styled.div`
    display:flex;
`;

const Content = styled.div`
    margin-left: 50px;
    width: 520px;
    height: 400px;
    background: #FFFFFF 0% 0% no-repeat padding-box;
    border: 1px solid #B4B5B6;
    border-radius: 4px;
    opacity: 1;
    .ContentText{
        padding:50px;
        font: normal normal normal 16px/20px Segoe UI;
        letter-spacing: 0px;
        color: #000000;
        opacity: 1;
    }
`;

const DeadTime = styled.div`
    padding-top:10px;
    display:flex;
    margin-left: 130px;
    margin-top: 200px;
    width: 350px;
    height: 70px;
    background: #FFFFFF 0% 0% no-repeat padding-box;
    border: 1.1px solid #B4B5B6;
    border-radius: 11px;
    opacity: 1;
    .Header{
        padding-top:10px;
        width: 140px;
        height: 50px;
        border-right: 1.5px solid #B4B5B6;
        font: normal normal 600 18px/30px Segoe UI;
        letter-spacing: 0px;
        color: #5D5D5D;
        opacity: 1;
        text-align: center;
    }
    .Time{
        width: 260px;
        height: 57px;
        text-align: center;
        font: normal normal normal 15px/24px Segoe UI;
        border: 1.1px;
        letter-spacing: 0px;
        color: #000000;
        opacity: 1;
    }
`;

class Testcontent extends Component {
    componentDidMount() {
        window.scrollTo(0, 0);
    }
  render() {
    return (
        <div>
            <Index>
                <IndexArray>
                <p className="HeaderText">과목 코드</p>
                <p className="HeaderContent"></p>
                </IndexArray>
                <IndexArray>
                <p className="HeaderText" style={{marginLeft:'42px'}}>제목</p>
                <p className="HeaderContent"></p>
                </IndexArray>
                <IndexArray>
                <p className="HeaderText" style={{marginLeft:'42px'}}>형식</p>
                <p className="HeaderContent" style={{width: '100px'}}></p>
                </IndexArray>
            </Index>
            <Header>
                <p className="HeaderText">과제 정보</p>
            </Header>
            <Content>
                <p className="ContentText">
                    1. Listen to the invited lecture carefully.<br/><br/>
                    2. Submit a short summary report of what you understand. <br/><br/>
                    Deadline: June 26, 2020, 18:00 <br/><br/>
                    You can receive up to THREE points <br/>
                    if you enter the lecture and write a short report <br/>
                    (one point for attendance and two points for report).
                </p>
                <DeadTime>
                        <p className="Header">마감시간</p>
                        <p className="Time">2020년 6월 26일 금요일 <br/>오후 6:00</p>
                </DeadTime>
            </Content>
        </div>

    );
  }
}

export default Testcontent