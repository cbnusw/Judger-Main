import React from 'react';
import styled from 'styled-components';
//import oc from 'open-color';
import {  media } from '../../lib/styles/styleUtil';
import { Link } from 'react-router-dom';
import Button from '../../components/common/Button';
import Dropdown from '../../components/common/Dropdown';
import Card from '../../components/common/Card';


// 바디의 내용
const BodyContents = styled.div`
    width: 2000px;
    display: inline;
    flex-direction: row;
    align-items: center;

    margin-top: 100px;

    padding-right: 1rem;
    padding-left: 2rem;
    ${media.wide`
        width: 992px;
    `}

    ${media.tablet`
        width: 100%;
    `}

    .Array{
        display : flex;
        margin-bottom:40px;
        margin-top:80px;
        margin-left: 200px;
    }

    .Card-array{
        margin: 40px 200px 40px 200px;
        display : inline-flex;
    }

`;



const Body = ({children}) => {
    return (
        <BodyContents>
            <div className="Array">
            <Button>신청하기</Button>
            <Dropdown></Dropdown>
            </div>      
            <div className="Card-array" style={{  display:'flex', justifyContent:'space-evenly'}}>
                    <Link to={"/classroom-Index/homework"} style={{ textDecoration:'none'}}><Card></Card></Link>
                    <Link to={"/classroom-Index/homework"} style={{ textDecoration:'none'}}><Card></Card></Link>
                    <Link to={"/classroom-Index/homework"} style={{ textDecoration:'none'}}><Card></Card></Link>
            </div>
            <div className="Card-array" style={{  display:'flex', justifyContent:'space-evenly'}}>
                    <Link to={"/classroom-Index/homework"} style={{ textDecoration:'none'}}><Card></Card></Link>
                    <Link to={"/classroom-Index/homework"} style={{ textDecoration:'none'}}><Card></Card></Link>
                    <Link to={"/classroom-Index/homework"} style={{ textDecoration:'none'}}><Card></Card></Link>
            </div>
            {children}
        </BodyContents>
    );
};

export default Body ;