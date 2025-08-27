import React, { useState } from 'react';

function Electronics() {
  const [name] = useState("Laptop");
  const [brand, setBrand] = useState("Dell");
  const [price, setPrice] = useState(5500);

  //when click on button ---> Brand get update
  const updateBrand = () => {
    setBrand("HP");
  };

   //when click on button ---> price get increase
  const increasePrice = () => {
    setPrice(prevPrice => prevPrice + 4500);
  };

  return (
    <div>
      <h2>Electronic Item Details</h2>
      <p><strong>Name:</strong> {name}</p>
      <p><strong>Brand:</strong> {brand}</p>
      <p><strong>Price:</strong> Rs. {price}</p>

{/* This are button with buttons with func*/}
      <button className={`btn btn-primary`}  onClick={updateBrand}>Change Brand</button>
      <button className={`btn btn-warning`}  onClick={increasePrice}>Increase Price</button>
    </div>
  );
}

export default Electronics;
