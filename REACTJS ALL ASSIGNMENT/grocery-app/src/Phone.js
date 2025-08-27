import React, { useState } from 'react';

const Phone = () => {
      // useState hooks - React hook to create state inside functional conponent
  const [brand] = useState('Apple');
  const [model] = useState('iPhone 16');
  const [price, newPrice] = useState(79999); 
// [Current value (state), Function to update that value]

// when we click on button price get update using this function
  const updatePrice = () => {
    newPrice(109999);
  };

  return (
    <div>
      <h2>Phone Details:</h2>
      <p>Brand: {brand}</p>
      <p>Model: {model}</p>
      <p>Price: Rs. {price}</p>
      <button className={`btn btn-primary`} onClick={updatePrice}>Increase Price</button>
    </div>
  );
};

export default Phone;
