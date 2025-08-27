import React, { useState } from "react";

// Functional Component
function BakingForm() {
  // State
  const [formData, setFormData] = useState({
    itemName: "",      
    quantity: "",      
    ingredients: "",   
    bakingTime: "",    
    category: "Cake"   
  });

  // State for storing list of all submitted baking items
  const [items, setItems] = useState([]);

  // Handle input changes (works for all fields)
  const handleChange = (event) => {
    const { name, value } = event.target; // Extract name & value from input
    setFormData((prevData) => ({
      ...prevData,   // Spread operator keeps other fields unchanged
      [name]: value  // Update only the changed field
    }));
  };

  // Handle form submission
  const handleSubmit = (event) => {
    event.preventDefault(); // Prevents page refresh
    
    // Add new form data into items array
    setItems((prevItems) => [...prevItems, formData]);

    // Reset form after submission
    setFormData({
      itemName: "",
      quantity: "",
      ingredients: "",
      bakingTime: "",
      category: "Cake"
    });
  };

  return (
    <div className="container mt-5">
      <div className="card shadow-lg p-4">
        <h2 className="text-center mb-4">Baking Items Form</h2>

        <form onSubmit={handleSubmit}>
          <div className="form-group mb-3">
            <label>Item Name</label>
            <input
              type="text"
              name="itemName"
              className="form-control"
              value={formData.itemName}
              onChange={handleChange}
              placeholder="Enter baking item name"
              required
            />
          </div>

          <div className="form-group mb-3">
            <label>Quantity</label>
            <input
              type="number"
              name="quantity"
              className="form-control"
              value={formData.quantity}
              onChange={handleChange}
              placeholder="Enter quantity"
              required
            />
          </div>
          <div className="form-group mb-3">
            <label>Ingredients</label>
            <textarea
              name="ingredients"
              className="form-control"
              rows="3"
              value={formData.ingredients}
              onChange={handleChange}
              placeholder="Enter ingredients"
              required
            />
          </div>

          <div className="form-group mb-3">
            <label>Baking Time</label>
            <input
              type="text"
              name="bakingTime"
              className="form-control"
              value={formData.bakingTime}
              onChange={handleChange}
              placeholder="Enter baking time (e.g., 45 mins)"
              required
            />
          </div>

          <div className="form-group mb-3">
            <label>Category</label>
            <select
              name="category"
              className="form-control"
              value={formData.category}
              onChange={handleChange}
            >
              <option value="Cake">Cake</option>
              <option value="Bread">Bread</option>
              <option value="Pastry">Pastry</option>
            </select>
          </div>

          <button type="submit" className="btn btn-success w-50">
            Add Baking Item
          </button>
        </form>
      </div>

      {items.length > 0 && (
        <div className="card mt-4 p-3">
          <h4 className="text-dark">Baking Items List</h4>

          <table className="table table-bordered mt-3">
            <thead>
              <tr>
                <th>#</th>
                <th>Item Name</th>
                <th>Quantity</th>
                <th>Ingredients</th>
                <th>Baking Time</th>
                <th>Category</th>
              </tr>
            </thead>
            <tbody>
              {/* Render each submitted item dynamically */}
              {items.map((item, index) => (
                <tr key={index}>
                  <td>{index + 1}</td>
                  <td>{item.itemName}</td>
                  <td>{item.quantity}</td>
                  <td>{item.ingredients}</td>
                  <td>{item.bakingTime}</td>
                  <td>{item.category}</td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      )}
    </div>
  );
}

export default BakingForm;
