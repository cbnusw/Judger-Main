import React, { Component } from "react";
import Slider from "react-slick";
import "slick-carousel/slick/slick.css"; 
import "slick-carousel/slick/slick-theme.css";
import styled from 'styled-components';
import Button from '../../components/common/Button';
import { Link } from 'react-router-dom';

const Bgimg = styled.div`
    position:relative;
    .img{
      width: 100vw;
      height: 100vh;
    }
    .backgroundcover{
        background-color:#000000;
        opacity:0.7;
        width: 100vw;
        height: 100vh;
        position:absolute;
        top:0px;
        left:0px    
    }
    .button{    
      position:absolute; 
      left:0; right:0; margin-left:auto; margin-right:auto;
      top: 300px; bottom:0; margin-top:auto; margin-bottom:auto;
      width:1100px; height:40px; 
    }
`;

const Center = styled.div`
    position:absolute; 
    left:0; right:0; margin-left:auto; margin-right:auto;
    top: 0; bottom:0; margin-top:auto; margin-bottom:auto;
    width:1100px; height:40px;
    text-align: center; 
    .Logo{
      font: normal 40px Gill_Sans;
      letter-spacing: 2px;
      color: #DEE0E1;
    }
    .Semi-Logo{
      font: lighter 15px/40px NanumSquare_ac;
      letter-spacing: 2.5px;
      color: #DEE0E1;
    }

`;


export default class SimpleSlider extends Component {
  render() {
    const settings = {
      arrows:false,
      infinite: true,
      speed: 500,
      slidesToShow: 1,
      slidesToScroll:1,
      autoplay:true, //true
      autoplaySpeed:2000,
      pauseOnHover: false,
      fade: true
    };
    return (
      <div>
        <Slider {...settings}>
          <div>
              <Bgimg>
                <img className="img" src={ require('../../image/bg1.png') } alt="bg"/>
                <div className="backgroundcover"></div>
                <Center>
                <h3 className="Logo">CBNU Online Judge</h3>
                  <h5 className="Semi-Logo">과제와 콘테스트의 제출과 채점을 위한 충북대학교의 온라인 저지 시스템입니다.</h5>
                  <div className="button">
                    <Link to="/login"><Button>login</Button></Link>  
                    <Button>sign up</Button>   
                    <Link to="/classroom"><Button>Classroom</Button></Link>
                  </div>
                </Center>
              </Bgimg>
          </div>
          <div>
              <Bgimg>
                <img className="img" src={ require('../../image/bg2.png') } alt="bg"/>
                <div className="backgroundcover"></div>
                <Center>
                <h3 className="Logo">CBNU Online Judge</h3>
                  <h5 className="Semi-Logo">과제와 콘테스트의 제출과 채점을 위한 충북대학교의 온라인 저지 시스템입니다.</h5>
                  <div className="button">
                    <Link to="/login"><Button>login</Button></Link>  
                    <Button>sign up</Button>   
                    <Link to="/classroom"><Button>Classroom</Button></Link>
                  </div>
                </Center>
              </Bgimg>
          </div>
          <div>
              <Bgimg>
                <img className="img" src={ require('../../image/bg3.png') } alt="bg"/>
                <div className="backgroundcover"></div>
                <Center>
                  <h3 className="Logo">CBNU Online Judge</h3>
                  <h5 className="Semi-Logo">과제와 콘테스트의 제출과 채점을 위한 충북대학교의 온라인 저지 시스템입니다.</h5>
                  <div className="button">
                    <Link to="/login"><Button>login</Button></Link>  
                    <Button>sign up</Button>   
                    <Link to="/classroom"><Button>Classroom</Button></Link>
                  </div>
                </Center>
              </Bgimg>
          </div>
        </Slider>
      </div>
    );
  }
}