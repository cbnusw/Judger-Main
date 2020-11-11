import React, { Component } from 'react';
//import Button from '../components/common/Button';
//import { Link } from 'react-router-dom';
import styled from 'styled-components';
import HeaderContainer from '../containers/Base/HeaderContainer';

   
const Classroombox = styled.div`
    width: 300px;
    height: 300px;
    background:  #EBEBEB 0% 0% no-repeat padding-box;
    border: 1px solid #707070;
    opacity: 0.83;
`;
   

class DashboardPage extends Component {
    render(){
        return(
            <div>
                <Classroombox>
                    <div className="header">
                        <p>CLASSROOM</p>
                    </div>
                </Classroombox>
                <HeaderContainer/>
            </div>


        );
    }
}

export default DashboardPage;