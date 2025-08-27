import React from 'react';

// Functional Component with props
const Grocerylist = ({ items }) => {
  // When we click on button then this function runs
  const handleClick = () => {
    alert("Groceries Added to Cart");
  };

  return (
    
    <div>
      <h2>Groceries List:</h2>
      <ul>
        {/* Loop through items array */}
        {items.map((item, index) => (       
          <li key={index}>{item}</li>
        ))}
      </ul>
      <button className="btn btn-primary" onClick={handleClick}>Add to cart</button>
    </div>
  );
};

export default Grocerylist;
