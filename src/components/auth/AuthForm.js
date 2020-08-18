import React from 'react';
import styled from 'styled-components'; //컴포넌트 만들때 styled-components로 스타일링
import { Link } from 'react-router-dom';
import palette from '../../lib/styles/palette';
import Button from '../common/Button';


/* 
 * 회원가입 또는 로그인 폼을 보여주는 컴포넌트 
 */

const AuthFormBlock = styled.div`
    h3{
        margin: 0;
        color: ${palette.gray[8]};
        margin-bottom: 1rem;
    }
    #guide_msg{
        font-size : 0.7rem;
        color: ${palette.blue[5]};
    }
`;

/**
 * 스타일링 된 input 폼
 */
const StyledInput = styled.input`
    font-size: 1rem;
    border: none;
    border-bottom: 1px solid ${palette.gray[5]};
    padding-bottom: 0.5rem;
    outline: none;
    width: 100%;
    &:focus{
        color: $oc-teal-7;
        border-bottom: 1px solid ${palette.gray[7]};
    }
    & + & {
        margin-top: 1rem;
    }
`;

/**
 * 폼 하단에 로그인/회원가입 링크를 보여줌
 */
const Footer = styled.div`
    margin-top: 2rem;
    text-align: right;
    a{
        color: ${palette.gray[6]};
        text-decoration: underline;
        &:hover{
            color: ${palette.gray[9]};
        }
    }
`;

const ButtonWithMarginTop = styled(Button)`
    margin-top: 1rem;
`;

const textMap = {
    login: 'Login',
    register: 'Sign Up',
};


const AuthForm = ({type}) => {
    const text = textMap[type];

    return(

        <AuthFormBlock>
          
            <form>
                <div>
                <StyledInput 
                    autoComplete="username" 
                    name="username" 
                    placeholder="사용자 ID" 
                />
                <p id='guide_msg'>※학생의 경우 학번으로, 교직원의 경우 학교 E-mail 아이디로 가입하시기 바랍니다. </p>
                <StyledInput 
                    autoComplete="new-password" 
                    name="password" 
                    placeholder="비밀번호" 
                    type="password" 
                />                    
                </div>
                <p></p>
                {type === 'register' && (
                    <div>
                    <StyledInput 
                        autoComplete="new-password" 
                        name="passwordConfirm" 
                        placeholder="비밀번호 확인" 
                        type="password" 
                    />
                    <StyledInput 
                        autoComplete="name" 
                        name="name" 
                        placeholder="이름" 
                         
                    />
                    <StyledInput 
                        autoComplete="college" 
                        name="college" 
                        placeholder="소속대학" 
                    />
                    <StyledInput 
                        autoComplete="major" 
                        name="major" 
                        placeholder="소속학과" 
                    />
                    <StyledInput 
                        autoComplete="email" 
                        name="email" 
                        placeholder="E-mail"
                        type="email" 
                    />
                    <StyledInput 
                        autoComplete="phone" 
                        name="phone" 
                        placeholder="연락처"
                        type="tel" 
                    />
                    
                    </div>                   
                    
                )}
                <ButtonWithMarginTop cyan fullWidth style={{marginTop: '1rem'}}>
                    {text}
                </ButtonWithMarginTop>
            </form>
            <Footer>
                {type ==='login' ? (
                    <Link to="/register">Sign Up</Link>
                ) : (
                    <Link to="/login">Login</Link>
                )}
                
            </Footer>
        </AuthFormBlock>
    );
};

export default AuthForm;