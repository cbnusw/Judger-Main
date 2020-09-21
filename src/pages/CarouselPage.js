import React from 'react';
import Button from '../components/common/Button';
import { Link } from 'react-router-dom';

const CarouselPage = () => {
    return (
        <div>
            <Link to="/login"><Button>login</Button></Link>  
             
            <Button>sign up</Button>   

            <Link to="/classroom"><Button>Classroom</Button></Link>

            <Link to="/test/imagepass"><Button>test</Button></Link>  
        </div>
    );   
};

export default CarouselPage;