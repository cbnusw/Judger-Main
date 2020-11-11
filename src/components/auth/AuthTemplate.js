import React from 'react';
import styled from 'styled-components';
import palette from '../../lib/styles/palette';
import { Link } from 'react-router-dom';
/*
 * 회원가입과 로그인 페이지의 레이아웃을 담당하는 컴포넌트
 * childern으로 받아 온 내용을 보여주기만 하면 되는 역할
 */

 /* 화면 전체를 채움 
    --------- 나중에 배경 사진으로 수정해야 함-------------
    현재는 배경 그냥 회색ㅇ로 뜨게 해 둠
  */ 

 const AuthTemplateBlock = styled.div`
    position: absolute;
    left: 0;
    top: 0;
    bottom: 0;
    right: 0;
    background: ${palette.gray[2]};
    
    /* flex로 내부 내용 중앙 정렬시킴 */
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
`;

/* 중앙 흰색 박스 */
const WhiteBox = styled.div`
    .logo-area{
        display: block;
        padding-bottom: 2rem;
        text-align: center;
        font-size: 25px;
        font-weight: bold;
        font-style: italic;
        letter-spacing: 2px;
    }
    box-shadow: 0 0 8px rgba(0, 0, 0, 0.25);
    padding: 2rem;
    width: 500px;
    background: white;
    border-radius: 2px;
`;

 const AuthTemplate = ({children}) => {
     return (
         <AuthTemplateBlock>
            <WhiteBox>
                <div className="logo-area">
                    <Link to='/' style={{ textDecoration: 'none', color:'black'}}>Online Judge</Link>
                </div>
                {children}
            </WhiteBox>           
         </AuthTemplateBlock>
     );
 };

 export default AuthTemplate;