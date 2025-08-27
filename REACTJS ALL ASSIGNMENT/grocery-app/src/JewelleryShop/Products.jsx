import React from 'react';
import { Link } from 'react-router-dom';

const sampleProducts = [
  { id: 1, name: "Gold Ring" },
  { id: 2, name: "Diamond Necklace" },
];

const Products = () => (
  <div>
    <h2>Products</h2>
    <ul>
      {sampleProducts.map(product => (
        <li key={product.id}>
          <Link to={`/products/${product.id}`}>{product.name}</Link>
        </li>
      ))}
    </ul>
  </div>
);

export default Products;
