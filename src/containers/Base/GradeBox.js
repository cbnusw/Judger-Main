import React from 'react';
import styled from 'styled-components';
//import palette from '../../lib/styles/palette';
//import { Link } from 'react-router-dom';
import GDHW from '../../components/common/GDHW';

const GradeIndex = styled.div`
    display:flex;
    margin-top: 60px;
    padding-left:10%;
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
    width: 1300px;height:0.1px;
    box-shadow: 0px 3px 10px #00000029;
    border: 0.1px solid #707070;
    left:0; right:0; margin-left:auto; margin-right:auto;
    top: 0; bottom:0; margin-top:auto; margin-bottom:auto; 
`;

const SearchBar = styled.div`
    margin-top: 40px;
    margin-left: 70%;
    width: 395px;
    height: 40px;
    background: #EBEBEB 0% 0% no-repeat padding-box;
    opacity: 1;
    display:flex;
    .Text{
      padding:13px;
      text-align: left;
      width: 350px;
      font: normal normal 600 15px/18px Segoe UI;
      letter-spacing: 0.56px;
      color: #202020;
      text-transform: uppercase;
      opacity: 0.5;
    }
    .Image{
      margin-top: 10px;
      margin-bottom: 10px;
      width: 18px;
      height: 18px;
      opacity: 1;
    }
`;

const GradeBox = () => {
  return (
      <div>
          <SearchBar>
            <p className="Text">교과번호, 교과명</p>
            <img className="Image" src={ require('../../image/Search.png') } alt="CBNU-logo"/>
          </SearchBar>
          <GradeIndex>
            <p className="Index" style={{ paddingRight:'130px'}}>항목</p>
            <p className="Index"  style={{ paddingRight:'250px'}}>제목</p>
            <p className="Index"  style={{ paddingRight:'130px'}}>제출 기한</p>
            <p className="Index"  style={{ paddingRight:'130px'}}>채점 현황</p>
            <p className="Index">채점 결과</p>
          </GradeIndex>
          <GradientBorder/>
          <div style={{ marginTop:'20px', marginBottom:'10px', display:'flex', justifyContent:'space-evenly'}}>
            <div style={{ paddingBottom:'40px',position:'absolute' }}>
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