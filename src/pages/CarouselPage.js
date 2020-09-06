import React from 'react';
import Button from '../components/common/Button';
import { Link } from 'react-router-dom';

const CarouselPage = () => {
    return (
        <div>
            <Button>login</Button>   
             
            <Button>sign up</Button>   

            <Link to="/classroom"><Button>Classroom</Button></Link>
        </div>
    );   
};

export default CarouselPage;