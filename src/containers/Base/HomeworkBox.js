import React from 'react';
import styled from 'styled-components';
//import palette from '../../lib/styles/palette';
import { Link } from 'react-router-dom';
import HWCode from '../../components/common/HWCode';
import HWReport from '../../components/common/HWReport';

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

const HomeworkBox = () => {
  return (
      <div>
          <SearchBar>
            <p className="Text">교과번호, 교과명</p>
            <img className="Image" src={ require('../../image/Search.png') } alt="CBNU-logo"/>
          </SearchBar>
          <div style={{margin: '60px 110px'}}>
            <div className="CardArray" style={{  display:'flex', justifyContent:'space-evenly', paddingBottom:'40px'}}>
            <Link to="/homeworkcontent"style={{ textDecoration:'none'}} ><HWCode></HWCode></Link>
              <HWReport></HWReport>
            </div>
            <div className="CardArray" style={{  display:'flex', justifyContent:'space-evenly', paddingBottom:'40px'}}>
            <Link to="/homeworkcontent"style={{ textDecoration:'none'}} ><HWCode></HWCode></Link>
              <HWReport></HWReport>
            </div>
            <div className="CardArray" style={{  display:'flex', justifyContent:'space-evenly', paddingBottom:'40px'}}>
            <Link to="/homeworkcontent"style={{ textDecoration:'none'}} ><HWCode></HWCode></Link>
              <HWReport></HWReport>
            </div>
            <div className="CardArray" style={{  display:'flex', justifyContent:'space-evenly', paddingBottom:'40px'}}>
            <Link to="/homeworkcontent"style={{ textDecoration:'none'}} ><HWCode></HWCode></Link>
              <HWReport></HWReport>
            </div>
          </div>
      </div>


  );    
};

export default HomeworkBox;