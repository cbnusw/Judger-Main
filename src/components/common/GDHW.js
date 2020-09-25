import React, { Component } from 'react';
import styled from 'styled-components';
//import palette from '../../lib/styles/palette';

// 흰 배경, 내용 중간 정렬

const CardBody = styled.div`
    padding-bottom:20px;
    left:0; right:0; margin-left:auto; margin-right:auto;
    top: 0; bottom:0; margin-top:auto; margin-bottom:auto;
    .Cardborder{
        width: 1300px;
        height: 60px;
        background: #FFFFFF 0% 0% no-repeat padding-box;
        border-radius: 5px;
        box-shadow: 0px 2px 10px #00000054;
        border: 1px solid #ffffff;
        opacity: 1;
        display:flex;
    }
    .Cardindex{
        padding-top: 13px;
        padding-left: 10%;
        text-align: center;
        text-decoration: underline;
        font: normal normal 600 20px/28px Segoe UI;
        letter-spacing: 0px;
        color: #000000;
        opacity: 1;
    }
    .Cardtitle{
        padding-top: 21px;
        padding-left: 80px;
        width: 167px;
        height: 33px;
        text-align: left;
        font: normal normal bold 20px/13px Segoe UI;
        letter-spacing: 0px;
        color: #4D4F5C;
        opacity: 1;
    }
    .Carditem{
        padding-top: 17px;
        padding-left: 10%;
        width: 59px;
        height: 31px;
        text-align: left;
        font: normal normal normal 18px/25px Segoe UI;
        letter-spacing: 0px;
        color: #4D4F5C;
        opacity: 1;
    }
    .Carddate{
        padding-top: 17px;
        padding-left: 10%;
        width: 300px;
        height: 31px;
        text-align: left;
        font: normal normal normal 18px/25px Segoe UI;
        letter-spacing: 0px;
        color: #4D4F5C;
        opacity: 1;
    }
    .Cardstate{
        padding-top: 17px;
        padding-left: 6%;
        width: 220px;
        height: 31px;
        text-align: left;
        font: normal normal normal 18px/25px Segoe UI;
        letter-spacing: 0px;
        color: #4D4F5C;
        opacity: 1;
    }
    .GradeLog{
        padding-top: 17px;
        padding-left: 5%;
        width: 170px;
        height: 40px;
    }
    outline: none;
    cursor: pointer;
    

`;



class GDCode extends Component {
  render() {
    return (
        <CardBody>
            <div className="Cardborder" >
                <p className="Cardindex">H.W</p>
                <div className="Cardtitle">HOMEWORK1</div>
                <p className="Carditem">Code</p>
                <p className="Carddate">2020-12-31</p>
                <p className="Cardstate">채점완료</p>
                <img className="GradeLog" src={ require('../../image/CompileError.png') } alt="CBNU-logo"/>
            </div>
        </CardBody>

    );
  }
}

export default GDCode