import React, { Component } from 'react';
import Select from 'react-select';
import 'bootstrap/dist/css/bootstrap.min.css';

const Season = [
  { label: "2020-02학기", value: 202002 },
  { label: "2020-01학기", value: 202001 },
  { label: "2019-02학기", value: 201902 },
  { label: "2019-01학기", value: 201901 },
];

class Dropdown extends Component {
  render() {
    return (
      <div className="container">
        <div className="row">
          <div className="col-md-0.5"></div>
          <div className="col-md-4">
            <Select options={Season} />
          </div>
          <div className="col-md-1"></div>
        </div>
      </div>
    );
  }
}

export default Dropdown