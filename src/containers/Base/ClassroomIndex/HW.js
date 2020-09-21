import React, { Component } from 'react';
import styled from 'styled-components';
//import CLAIndex from '../../components/base/CLAIndex';
//import Homework from '../../pages/Classroom/Homework';
//import styled from 'styled-components';

// 위치 고정, 그림자
const Positioner = styled.div`
    display: flex;
    flex-direction: column;
    top: 70px;
    width: 100%;

    .classimage{
        margin-top:100px;
        width: 100%;
        height: 250px;
        position:relative
    }

    .backgroundcover{
        background-color:#4242429c;
        width: 100%;
        height: 250px;
        position:absolute;
        top:100px;
        left:0px    
    }
    
    .classname{
        font: normal normal normal 40px/65px Hancom Gothic;
        letter-spacing: 2px;
        color: #FFFFFF;
        opacity: 1;
        position:absolute;
        top:150px;
        left:100px   
    }

    .semester{
        font: normal normal normal 20px/65px Hancom Gothic;
        letter-spacing: 2px;
        color: #FFFFFF;
        opacity: 1;
        position:absolute;
        top:160px;
        left:320px   
    }
    
    .profname{
        font: normal normal normal 20px/65px Hancom Gothic;
        letter-spacing: 2px;
        color: #FFFFFF;
        opacity: 1;
        position:absolute;
        top:200px;
        left:190px  
    }

    .subjectnum{
        font: normal normal normal 18px/65px Hancom Gothic;
        letter-spacing: 2px;
        color: #FFFFFF;
        opacity: 1;
        position:absolute;
        top:280px;
        left:85%; 
    }
`;

const Box = styled.div`
    width: 100%;
    height: 50px;
    background:  #EBEBEB 0% 0% no-repeat padding-box;
    border: 1px solid #707070;
    opacity: 0.83;

    .meun-ul{
      display: flex;
      /* flex로 내부 내용 정렬시킴 */
    }

    .menu-li{
      list-style:none;
      display: inline-block;
      float:left;
      text-align: center;
      font-size: 20px;
      font-weight: bold;
      padding-left: 30px;
      margin-left: 50px;
      padding-right: 30px;
      height: 49px;
    }

    .menu-li:hover{
      background-color:#ced4da;
        color : blue;
    }

    .Indextext{
      text-decoration:none;
      font: 20px/50px Hancom Gothic;
      font-weight: bolder;
      letter-spacing: 2px;
      color: black;
      opacity: 1;

    }
        
    .underbar{
      background-color:#1062E5;
      width: 102px;
      height: 10px;        
      position:absolute;
      top:390px;
      left:90px   
    }
    
`;


class ClassroomIndex extends Component {
    render() {
        return (
            <Positioner>
                <img className="classimage" src={ require('../../../image/classroom2.png') } alt="classroomimage"/>
                <div className="backgroundcover"></div>
                <p className="classname">확률과 통계</p>
                <p className="semester">: 2020 - 2 학기</p>
                <p className="profname">교수님 성함</p>
                <p className="subjectnum">과목번호 : 202020</p>
                <Box>
                    <ul className="meun-ul">
                        <a href='/classroom-Index/homework' className="Indextext" 
                        style={{  color:'#1062E5'}}><li className="menu-li">과제
                        <div className="underbar"></div></li></a>
                        <a href='/classroom-Index/exam' className="Indextext"><li className="menu-li">시험</li></a>
                        <a href='/classroom-Index/grade' className="Indextext"><li className="menu-li">성적</li></a>
                    </ul>
                </Box>
            </Positioner>
        );
    }
}

export default ClassroomIndex;