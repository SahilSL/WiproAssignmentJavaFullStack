import React from 'react';

const Juice = ({ id, name, price }) => {
  return (
    <tr>
      <td>{id}</td>
      <td>{name}</td>
      <td>Rs. {price}</td>
    </tr>
  );
};

export default Juice;
