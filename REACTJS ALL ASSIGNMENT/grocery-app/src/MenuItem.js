import React, { Component } from 'react';

// child component
class MenuItem extends Component {
  render() {
    //Destructuring Props
    const { name, price, category, available } = this.props;

    return (
      <p> 
       <ul> {name} - ₹ {price} ({category}), {available === "Yes" ? "Available" : "Not Available"}</ul> 
      </p>
    );
  }
}//ternary operator

export default MenuItem;
