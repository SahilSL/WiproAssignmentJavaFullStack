import React, { Component } from 'react';
import MenuItem from './MenuItem'; //child component

//parent class component
class Restaurant extends Component {
  render() {
    const menuItems = [
      { 
        name: "Paneer Butter Masala", 
        price: 150, 
        category: "Main Course", 
        available: "Yes" 
      },
      { 
        name: "Chicken Biryani", 
        price: 200, 
        category: "Main Course", 
        available: "Yes"
       },
      { 
        name: "Masala Dosa", 
        price: 80, 
        category: "Breakfast", 
        available: "Yes"
        
       },
      { name: "Gulab Jamun", price: 40, 
        category: "Dessert", 
        available: "No"
        
       },
      { 
        name: "Veg Thali", 
        price: 120,
         category: "Combo",
         available: "Yes"
        
       },
    ];

    return (
      <div>
        <h2>Restaurant Name: Spice Hub</h2>
        <p><strong>Location:</strong> Block B, First Floor</p>
        <p><strong>Open Hours:</strong> 10:00 AM - 10:00 PM</p>

        <h3>Restaurant Menu:</h3>
        {menuItems.map((item, index) => (
          <MenuItem
            key={index}
            name={item.name}
            price={item.price}
            category={item.category}
            available={item.available}
          />
        ))}
      </div>
    );
  }
}

export default Restaurant;
