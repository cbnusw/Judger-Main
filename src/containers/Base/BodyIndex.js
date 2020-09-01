import React from './react';
import styled from './styled-components';
//import oc from 'open-color';
import {  media } from '../../lib/styles/styleUtil';
//import { Link } from 'react-router-dom';
//import Button from '../../components/common/Button';



// 위치 고정, 그림자
const Positioner = styled.div`
    display: flex;
    flex-direction: column;
    position: fixed;
    top: 70px;
    width: 100%;
`;

// 흰 배경, 내용 중간 정렬
const WhiteBackground = styled.div`
    background: white;
    display: flex;
    height: auto;
`;

// 바디의 내용
const BodyContents = styled.div`
    .logo-area{
        display: block;
        text-align: center;
        font-size: 25px;
        font-weight: bold;
        font-style: italic;
        letter-spacing: 2px;
    }
    .logo-image{
        width: 40px;
        height: 40px;
    }


    width: auto;
    height: 55px;
    display: flex;
    flex-direction: row;
    align-items: center;

    margin-left: 80px;
    margin-top: 10px;

    padding-right: 1rem;
    padding-left: 2rem;
    ${media.wide`
        width: 992px;
    `}

    ${media.tablet`
        width: 100%;
    `}
`;

// 중간 여백
const Spacer = styled.div`
    flex-grow: 1;
`;




const BodyIndex = ({children}) => {
    return (
        <Positioner>
            <WhiteBackground>
                <BodyContents>                   
                    {children}
                    <Spacer/>
                </BodyContents>
            </WhiteBackground>
        </Positioner>
        
    );
};

export default BodyIndex;