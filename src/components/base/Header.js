import React from 'react';
import styled from 'styled-components';
import palette from '../../lib/styles/palette';
import { shadow, media } from '../../lib/styles/styleUtil';
//import { Link } from 'react-router-dom';



// 상단 고정, 그림자
const Positioner = styled.div`
    display: flex;
    flex-direction: column;
    position: fixed;
    top: 0px;
    width: 100%;
    ${shadow(1)}
`;

// 흰 배경, 내용 중간 정렬
const WhiteBackground = styled.div`
    background: white;
    display: flex;
    height: auto;
`;

// 해더의 내용
const HeaderContents = styled.div`
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

    width: 1200px;
    height: 55px;
    display: flex;
    flex-direction: row;
    align-items: center;

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

// 하단 그래디언트 테두리
const GradientBorder = styled.div`
    height: 3px;
    background: linear-gradient(to right,  ${palette.gray[5]});
`;

const Header = ({children}) => {
    return (
        <Positioner>
            <WhiteBackground>
                <HeaderContents>
                    <img className="logo-image" src={ require('../../logo-image.png') } alt="CBNU-logo"/>
                    <div className="logo-area">
                        <a href='/'
                        style={{ textDecorationLine:'none',
                        color:'black'}}
                        >Online Judge</a>
                    </div>
                    <Spacer/>
                    {children}
                </HeaderContents>
            </WhiteBackground>
            <GradientBorder/>
        </Positioner>
    );
};

export default Header;