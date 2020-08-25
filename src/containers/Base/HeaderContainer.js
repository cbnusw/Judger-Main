import React, { Component } from 'react';
import Header from '../../components/base/Header';
import styled from 'styled-components';
//import { Link } from 'react-router-dom';

// 하단 그래디언트 테두리
const Headermenu = styled.div`
    .meun-ul{
        display: flex;
        margin-top: 48px;
        /* flex로 내부 내용 정렬시킴 */


    }
    .menu-li{
        list-style:none;
        float:left;
        margin:0 0 1em; 
        padding:8px 0 0 50px;
        text-align: center;
        font-size: 20px;
        font-weight: bold;
    }
`;



class HeaderContainer extends Component {
    render() {
        return (
            <Header>
                <Headermenu>
                    <ul className="meun-ul">
                        <li className="menu-li"><a href='/'
                            style={{ textDecorationLine:'none',
                            color:'black'}}>Home</a></li>
                        <li className="menu-li"><a href='/classroom'
                            style={{ textDecorationLine:'none',
                            color:'#1062E5'}}>Classroom</a></li>
                        <li className="menu-li"><a href='/'
                            style={{ textDecorationLine:'none',
                            color:'black'}}>Contest</a></li>
                    </ul>
                </Headermenu>
            </Header>
        );
    }
}

export default HeaderContainer;