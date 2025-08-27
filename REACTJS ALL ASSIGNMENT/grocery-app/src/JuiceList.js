import React from 'react';
import Juice from './Juice';

const JuiceList = () => {
  const juices = [
    { id: 1, name: 'Orange Juice', price: 80 },
    { id: 2, name: 'Mango Juice', price: 100 },
    { id: 3, name: 'Apple Juice', price: 120 },
  ];

  return (
    <div style={{ display: "flex", justifyContent: "center", alignItems: "center", flexDirection: "column" }}>
      <h2>Juice Menu</h2>
      <table border="3" cellPadding="10">
        <thead>
          <tr>
            <th>ID</th>
            <th>Juice Name</th>
            <th>Price</th>
          </tr>
        </thead>
        <tbody>

          {juices.map(juice => (
            <Juice
              key={juice.id}
              id={juice.id}
              name={juice.name}
              price={juice.price}
            />
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default JuiceList;
