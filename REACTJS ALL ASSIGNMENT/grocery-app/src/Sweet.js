import React from 'react';

const SweetsList = () => {
// Array of sweets
  const sweets = [
    { id: 1, name: 'laddu', price: 50 },
    { id: 2, name: 'Jalebi', price: 40 },
    { id: 3, name: 'Rasgulla', price: 60 },
    { id: 4, name: 'Gula Jamun', price: 70 },
  ];

  return (
    <div>
      <h2>Sweet List:</h2>
      {/* Loop  */}
      {sweets.map((sweet) => (
        <p key={sweet.id}>
          {sweet.id} {sweet.name} - Price: Rs. {sweet.price}
        </p>
      ))}
    </div>
  );
};

export default SweetsList;
