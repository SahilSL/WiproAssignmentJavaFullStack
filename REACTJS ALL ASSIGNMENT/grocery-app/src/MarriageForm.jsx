import React, { Component } from "react";  

// Class Component 
class MarriageForm extends Component {
  // Constructor is used to initialize state and bind functions
  constructor(props) {
    super(props); //requiedto use 'this'

    // State will hold all the input values
    this.state = {
      brideName: "",     groomName: "",     date: "",           venue: "",           submitted: false 
    };
  }

  // Function to handle input changes
  // [event.target.name] helps update correct field dynamically
  handleChange = (event) => {
    this.setState({
      [event.target.name]: event.target.value
    });
  };

  // Function to handle form submit
  handleSubmit = (event) => {
    event.preventDefault(); // Prevents page reload when form is submitted
    this.setState({ submitted: true }); // Sets submitted to true so details are shown
  };

  // Render method is responsible for displaying UI
  render() {
    return (
      <div className="container mt-5"> 
        <div className="card shadow-lg p-4">
          <h2 className="text-center mb-4">Marriage Form</h2>
          <form onSubmit={this.handleSubmit}>

            <div className="form-group mb-3">
              <label>Bride Name</label>
              <input
                type="text"
                name="brideName"               // name must match state property
                className="form-control"
                value={this.state.brideName}   // value comes from state
                onChange={this.handleChange}   // updates state on typing
                placeholder="Enter Bride's Name"
                required
              />
            </div>

            <div className="form-group mb-3">
              <label>Groom Name</label>
              <input
                type="text"
                name="groomName"
                className="form-control"
                value={this.state.groomName}
                onChange={this.handleChange}
                placeholder="Enter Groom's Name"
                required
              />
            </div>


            <div className="form-group mb-3">
              <label>Marriage Date</label>
              <input
                type="date"
                name="date"
                className="form-control"
                value={this.state.date}
                onChange={this.handleChange}
                required
              />
            </div>

            <div className="form-group mb-3">
              <label>Venue</label>
              <input
                type="text"
                name="venue"
                className="form-control"
                value={this.state.venue}
                onChange={this.handleChange}
                placeholder="Enter Venue"
                required
              />
            </div>

            <button type="submit" className="btn btn-primary w-100">
              Submit
            </button>
          </form>
        </div>

        {/* Show submitted details after form submission */}
        {this.state.submitted && (
          <div className="card mt-4 p-3">
            <h4 className="text-success">Marriage Details Submitted:</h4>
            <p><strong>Bride Name:</strong> {this.state.brideName}</p>
            <p><strong>Groom Name:</strong> {this.state.groomName}</p>
            <p><strong>Date:</strong> {this.state.date}</p>
            <p><strong>Venue:</strong> {this.state.venue}</p>
          </div>
        )}
      </div>
    );
  }
}

export default MarriageForm;
