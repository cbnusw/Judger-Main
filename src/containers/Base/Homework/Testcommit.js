import React, { Component } from 'react';
import styled from 'styled-components';
import Button from '../../../components/common/Button';
import { Link } from 'react-router-dom';
//import palette from '../../lib/styles/palette';



const Header = styled.div`
    padding-top: 30px;
    padding-left: 80px;
    width:190px;
    .HeaderText{
        text-align: left;
        font: normal normal 600 18px/30px Segoe UI;
        letter-spacing: 0px;
        color: #000000;
        opacity: 1;
    }
`;

const Content = styled.div`
    margin-top: 30px;
    margin-left: 20px;
    width: 680px;
    height: 500px;
    background: #FFFFFF 0% 0% no-repeat padding-box;
    border: 1px solid #B4B5B6;
    border-radius: 4px;
    opacity: 1;
    .ContentText{
        padding:40px;
        font: normal normal normal 16px/20px Segoe UI;
        letter-spacing: 0px;
        color: #000000;
        opacity: 1;
    }
`;

const SourceBox = styled.div`
    window.scrollTo(0, 0);
    display:flex;
`;

const CommentBox = styled.div`
    display:flex;
`;

const Comment = styled.div`
    margin-top: 30px;
    margin-left: 20px;
    width: 680px;
    height: 120px;
    background: #FFFFFF 0% 0% no-repeat padding-box;
    border: 1px solid #B4B5B6;
    border-radius: 4px;
    opacity: 1;
    .ContentText{
        padding:40px;
        font: normal normal normal 16px/20px Segoe UI;
        letter-spacing: 0px;
        color: #000000;
        opacity: 1;
    }
`;

class Testcontent extends Component {
    componentDidMount() {
        window.scrollTo(0, 0);
    }
  render() {
    return (
        <div>
            <SourceBox>
                <Header>
                    <p className="HeaderText">소스코드</p>
                </Header>
                <Content>
                    <p className="ContentText">
                        Hello! World.
                    </p>
                </Content>
            </SourceBox>
            <CommentBox>
                <Header>
                    <p className="HeaderText">코멘트 작성</p>
                </Header>
                <Comment>
                    <p className="ContentText">
                        Hello! World.
                    </p>
                </Comment>
            </CommentBox>
            <Link to="/homeworkCheck"><Button style={{ marginTop:'60px', marginLeft:'400px'}}>제출</Button></Link>
        </div>

    );
  }
}

export default Testcontent