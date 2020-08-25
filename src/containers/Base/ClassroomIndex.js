import React, { Component } from 'react';
import styled from 'styled-components';
import Homework from '../../pages/Classroom/Homework';
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
        height: 200px;
        position:relative
    }

    .backgroundcover{
        background-color:#0404048C;
        width: 100%;
        height: 200px;
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
        top:240px;
        left:85%; 
    }
`;


class ClassroomIndex extends Component {
    render() {
        return (
            <Positioner>
                <img className="classimage" src={ require('../../image/classroom2.png') } alt="classroomimage"/>
                <div className="backgroundcover"></div>
                <p className="classname">확률과 통계</p>
                <p className="semester">: 2020 -2 학기</p>
                <p className="profname">교수님 성함</p>
                <p className="subjectnum">과목번호 : 202020</p>
                <Homework></Homework>
            </Positioner>
        );
    }
}

export default ClassroomIndex;