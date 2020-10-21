import React, { Component } from 'react';
import styled from 'styled-components';
import Header from '../../components/base/Header';
import { Link } from 'react-router-dom';


const Headermenu = styled.div`
    .meun-ul{
        display: flex;
        margin-top: 48px;  /* flex로 내부 내용 정렬시킴 */
        text-decoration-line: none;
    }
    .menu-li{
        text-align: center; 
        list-style:none;
        float:left;
        margin:0 0 1em; 
        padding:8px 0 0 60px;
        font-size: 20px;
        font-weight: bold;
    }
    .menu-li:hover{
          color : #1062E5;
      }
`;



class HeaderContainer extends Component {
    componentDidMount() { //화면 상단으로 이동시켜줌
        window.scrollTo(0, 0);
    }
    render() {
        return (
            <Header>
                <Headermenu>
                    <ul className="meun-ul">
                        <li className="menu-li">
                            <Link to={"/DashboardPage"} style={{ textDecoration:'none', color:'black'}}>Dashboard</Link>
                        </li>
                        <li className="menu-li">
                            <Link to={"/classroom"} style={{ textDecoration:'none',color:'#1062E5'}}>Classroom</Link>
                        </li>
                        <li className="menu-li">
                            <Link to={"/"} style={{ textDecoration:'none', color:'black'}}>Contest</Link>
                        </li>
                    </ul>
                </Headermenu>
            </Header>
        );
    }
}

export default HeaderContainer;