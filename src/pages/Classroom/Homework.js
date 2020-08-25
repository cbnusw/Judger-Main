import React, { Component } from 'react';
import styled from 'styled-components';
//import palette from '../../lib/styles/palette';



const Box = styled.div`
    width: 100%;
    height: 50px;
    background:  #EBEBEB 0% 0% no-repeat padding-box;
    border: 1px solid #707070;
    opacity: 0.83;

    .Indextext{
        font: 20px/50px Hancom Gothic;
        font-weight: bolder;
        letter-spacing: 2px;
        color: black;
        opacity: 1;
        position:absolute;
    }

`;



class CLAIndex extends Component {
  render() {
    return (
        <Box>
            <p className="Indextext" style={{ paddingLeft:'200px', color:'blue'}}>과제</p>
            <p className="Indextext" style={{ paddingLeft:'350px'}}>시험</p>
            <p className="Indextext" style={{ paddingLeft:'500px'}}>성적</p>
        </Box>

    );
  }
}

export default CLAIndex