import React, { Component } from "react"; 

// class component 
class AccessoriesForm extends Component {
  constructor(props) {
    super(props); // Calling parent constructor beacuse it is alwaysrequired in class components

    // Initializing state to store all form input values
    this.state = {
      accessoryName: "",   
      description: "",     
      category: "Select Cateory",   // if i dont select then default value will be selecect category
      brand: "",           
      available: false,    
      warranty: "",        
      submitted: false     
    };
  }


  handleChange = (event) => {
    const { name, value, type, checked } = event.target; 
    // Destructuring values from the input field
    // Update state dynamically
    this.setState({
      [name]: type === "checkbox" ? checked : value 
      // If checkbox → store checked (true/false)
      // Else → store value
    });
  };

  // Function to handle form submission
  handleSubmit = (event) => {
    event.preventDefault(); // Prevents page from refreshing or reloading after form submit
    this.setState({ submitted: true }); // Mark the form as submitted
  };





  // Render method is responsible for returning UI
  render() {
    return (
      <div className="container mt-5">
        <div className="card shadow-lg p-4">
          <h2 className="text-center mb-4">Accessories Form</h2>
          <form onSubmit={this.handleSubmit}>
            
            <div className="form-group mb-3">
              <label>Accessory Name</label>
              <input
                type="text"                        
                name="accessoryName"               
                className="form-control"           
                value={this.state.accessoryName}   // Bind value from state
                onChange={this.handleChange}       // Update state on typing
                placeholder="Enter accessory name"
                required                           
              />
            </div>

            <div className="form-group mb-3">
              <label>Description</label>
              <textarea
                name="description"                 
                className="form-control"
                value={this.state.description}     // Bind value from state
                onChange={this.handleChange}
                placeholder="Enter description"
                required
              />
            </div>

            <div className="form-group mb-3">
              <label>Category</label>
              <select
                name="category"
                className="form-control"
                value={this.state.category}        // Bind selected value
                onChange={this.handleChange}
              >
                <option value="">--Select Category--</option>
                <option value="Mobile">Mobile</option>
                <option value="Laptop">Laptop</option>
                <option value="Headphones">Headphones</option>
                <option value="Smartwatch">Smartwatch</option>
              </select>
            </div>

            <div className="form-group mb-3">
              <label>Brand</label>
              <div>
                <input
                  type="radio"
                  name="brand"                      // Same name → only one can be selected
                  value="Apple"                    // Value stored in state
                  checked={this.state.brand === "Apple"} // true if selected
                  onChange={this.handleChange}
                  className="form-check-input"
                />
                <label className="form-check-label ms-2">SAMSUNG</label>
              </div>
              <div>
                <input
                  type="radio"
                  name="brand"
                  value="Samsung"
                  checked={this.state.brand === "Samsung"}
                  onChange={this.handleChange}
                  className="form-check-input"
                />
                <label className="form-check-label ms-2">SONY</label>
              </div>
              <div>
                <input
                  type="radio"
                  name="brand"
                  value="Sony"
                  checked={this.state.brand === "Sony"}
                  onChange={this.handleChange}
                  className="form-check-input"
                />
                <label className="form-check-label ms-2">MOTOROLA</label>
              </div>
            </div>

            <div className="form-group mb-3">
              <div className="form-check">
                <input
                  type="checkbox"
                  name="available"
                  className="form-check-input"
                  checked={this.state.available}     // true/false from state
                  onChange={this.handleChange}
                />
                <label className="form-check-label">
                  Available in Stock
                </label>
              </div>
            </div>

            <div className="form-group mb-3">
              <label>Warranty (in years)</label>
              <input
                type="number"
                name="warranty"
                className="form-control"
                value={this.state.warranty}         // Bind state
                onChange={this.handleChange}
                placeholder="Enter warranty period"
                required
              />
            </div>

            <button type="submit" className="btn btn-primary w-100">
              Submit
            </button>
          </form>
        </div>

        {/* Show Submitted Data in Bootstrap Table */}
        {/* this is condotional rendering if it is true then only it will show table else it does not show anythiong */}
        {this.state.submitted && (
          <div className="card mt-4 p-3">
            <h4 className="text-success">Submitted Accessory Details</h4>
        
            <table className="table table-bordered mt-3">
              <tbody>
                <tr>
                  <th>Accessory Name</th>
                  <td>{this.state.accessoryName}</td>
                </tr>
                <tr>
                  <th>Description</th>
                  <td>{this.state.description}</td>
                </tr>
                <tr>
                  <th>Category</th>
                  <td>{this.state.category}</td>
                </tr>
                <tr>
                  <th>Brand</th>
                  <td>{this.state.brand}</td>
                </tr>
                <tr>
                  <th>Available</th>
                  <td>{this.state.available ? "Yes" : "No"}</td>
                </tr>
                <tr>
                  <th>Warranty</th>
                  <td>{this.state.warranty} Years</td>
                </tr>
              </tbody>
            </table>
          </div>
        )}
      </div>
    );
  }
}

export default AccessoriesForm;
