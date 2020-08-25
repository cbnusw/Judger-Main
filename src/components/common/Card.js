import React, { Component } from 'react';
import styled from 'styled-components';
//import palette from '../../lib/styles/palette';

// 흰 배경, 내용 중간 정렬

const CardBody = styled.div`
    .Cardheadertext{
        font-size:13px;
        margin-bottom: 5px;
    }
    .Cardborder{
        width: 350px;
        height: 250px;
        background: #FFFFFF 0% 0% no-repeat padding-box;
        box-shadow: 0px 2px 10px #00000054;
        border: 1px solid #377CD6;
        opacity: 1;

    }
    .Cardheader{
        margin-top: 60px;
        margin-left: 80px;
        color: black;
        fontWeight: bold;
        fontSize:20px;
        font-size:x-large;
        font-weight: bold;
    }
    .Cardbody{
        margin-top:20px;
        margin-left: 80px;
    }
    .Cardtext{
        margin-bottom:5px;
        color:black;
    }
    outline: none;
    cursor: pointer;

`;



class Card extends Component {
  render() {
    return (
        <CardBody>
            <div className="Cardborder" >
                <div className="Cardheader" >
                <p className="Cardheadertext">교과목</p>확률과 통계</div>
                <div className="Cardbody">
                    <p className="Cardtext">교수님 성함</p>
                    <p className="Cardtext">과목번호 : 20202020</p>
                </div>
            </div>
        </CardBody>

    );
  }
}

export default Card