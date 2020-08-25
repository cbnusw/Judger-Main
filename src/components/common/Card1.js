import React, { Component } from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';


class Card extends Component {
  render() {
    return (
        <div class="card border-blue mb-3" style={{width: '18rem',borderColor:'#1062E5'}}>
            <div class="card-header" style={{color:'black', fontWeight: 'bold', fontSize:'20px', borderColor:'#1062E5'}}>확률과 통계</div>
            <div class="card-body text-dark">
                <h5 class="card-title">..</h5>
                <p class="card-text">교수님 성함</p>
                <p class="card-text">과목 번호 : 20202020</p>
            </div>
        </div>
    );
  }
}

export default Card
