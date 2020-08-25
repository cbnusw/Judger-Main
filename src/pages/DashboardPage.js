import React from 'react';
import Button from '../components/common/Button';
import { Link } from 'react-router-dom';
//import styled from 'styled-components';

          

const DashboardPage = () => {
    return (
        <div>
            <Button>대시</Button>
            <br></br>
            <Link to="/classroom"><Button>Classroom</Button></Link>
        </div>
    );   
};

export default DashboardPage;