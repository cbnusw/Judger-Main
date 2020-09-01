import React from 'react';
import styled from 'styled-components';
//import palette from '../../lib/styles/palette';
//import { Link } from 'react-router-dom';
import GDHW from '../../components/common/GDHW';

const GradeIndex = styled.div`
    display:flex;
    margin-top: 100px;
    padding-left:16%;
    
    .Index{
        height: 31px;
        text-align: left;
        font: normal normal 600 20px/25px Segoe UI;
        letter-spacing: 0px;
        color: #4D4F5C;
        opacity: 1;
    }
`;
const GradientBorder = styled.div`
    width: 80%;
    margin:auto;
    box-shadow: 0px 3px 10px #00000029;
    border: 0.1px solid #707070;
    opacity: 1;
`;


const GradeBox = () => {
  return (
      <div>
          <GradeIndex>
            <p className="Index" style={{ paddingRight:'130px'}}>항목</p>
            <p className="Index"  style={{ paddingRight:'250px'}}>제목</p>
            <p className="Index"  style={{ paddingRight:'130px'}}>제출 기한</p>
            <p className="Index"  style={{ paddingRight:'130px'}}>채점 현황</p>
            <p className="Index">채점 결과</p>
          </GradeIndex>
          <GradientBorder/>
          <div style={{ marginTop:'20px', marginBottom:'10px'}}>
            <div className="CardArray" style={{ paddingBottom:'40px',position:'absolute', left:'13%'  }}>
              <GDHW></GDHW>
              <GDHW></GDHW>
              <GDHW></GDHW>
              <GDHW></GDHW>

            </div>
          </div>
      </div>


  );    
};

export default GradeBox;