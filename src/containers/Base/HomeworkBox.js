import React from 'react';
//import styled from 'styled-components';
//import palette from '../../lib/styles/palette';
import { Link } from 'react-router-dom';
import HWCode from '../../components/common/HWCode';
import HWReport from '../../components/common/HWReport';



const HomeworkBox = () => {
  return (
      <div>
          <div style={{ marginTop:'120px', marginBottom:'120px'}}>
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