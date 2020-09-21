import React, { Component } from 'react';
import styled from 'styled-components';
import Header from '../../components/base/Header';
//import { Link } from 'react-router-dom';


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
        padding:8px 0 0 60px;
        text-align: left;
        font-size: 25px;
        font-weight: semibold;
    }
`;



class HeaderContainer extends Component {
    render() {
        return (
            <Header>
                <Headermenu>
                    <ul className="meun-ul">
                        <li className="menu-li"><a href='/'
                            style={{ textDecorationLine:'none', color:'black'}}>Home</a></li>
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