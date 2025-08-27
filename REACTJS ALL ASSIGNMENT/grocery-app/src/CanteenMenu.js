import React from 'react';
import CanteenItem from './CanteenItem';

const CanteenMenu = () => {
  const items = [
    { name: "Idli", price: 30, category: "Breakfast", available: "Yes" },
    { name: "Dosa", price: 50, category: "Breakfast", available: "Yes" },
    { name: "Vada", price: 20, category: "Snack", available: "No" },
    { name: "Poori", price: 40, category: "Breakfast", available: "Yes" },
    { name: "Meals", price: 120, category: "Lunch", available: "Yes" }
  ];

  return (
    <div>
      <h2>Canteen Name:</h2>
      <h2>Campus Food Court</h2>
      <p><strong>Location:</strong> Block A, Ground Floor</p>
      <p><strong>Open Hours:</strong> 8:00 AM - 8:00 PM</p>

      <h3>Canteen Menu:</h3>
      {items.map((item, index) => (
        <CanteenItem
          key={index}
          name={item.name}
          price={item.price}
          category={item.category}
          available={item.available}
        />
      ))}
    </div>
  );
};

export default CanteenMenu;
