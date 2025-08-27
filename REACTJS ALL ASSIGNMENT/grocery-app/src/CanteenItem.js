import React from 'react';

const CanteenItem = ({ name, price, category, available }) => {
  return (
    <div style={{ marginBottom: '10px' }}>
      <p>
        <strong>{name}</strong> - Price: Rs.{price} - Category: {category} - {available === "Yes" ? "Available" : "Not Available"}
      </p>
    </div>
  );
};

export default CanteenItem;
