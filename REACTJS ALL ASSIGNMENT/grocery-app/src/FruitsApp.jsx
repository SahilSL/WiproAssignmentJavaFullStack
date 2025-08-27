import React, { Component } from "react";

// THis is Functional Component {/* fruits is props*/}
function FruitList({ fruits }) {    
  return (
    <ul>
      {fruits.map((fruit, index) => (
        <li key={index}>{fruit}</li>
      ))}
    </ul>
  );
}

// this is clas7 Component  {/* constrctor */}
class Fruits extends Component {
  constructor(props) {          
    super(props);
    this.state = {
      fruits: ["Apple", "Banana", "Mango"],
      newFruit: ""
    };
  }

  //handleChange updates the state whenever the user types in the input box so the input value is always stored in React state.
  handleChange = (e) => {
    this.setState({ newFruit: e.target.value });
  };

  addFruit = () => {
    if (this.state.newFruit.trim() !== "") {
      this.setState((prevState) => ({
        fruits: [...prevState.fruits, prevState.newFruit],
        newFruit: ""
      }));
    }
  };

  render() {
    return (
      <div>
        <h2>Fruit List</h2>
        <input
          type="text"
          value={this.state.newFruit}
          onChange={this.handleChange}
          placeholder="Enter a fruit"
        />
        <button className="btn btn-primary " onClick={this.addFruit}>Add Fruit</button>

        {/* Passing fruits as props */}
        <FruitList fruits={this.state.fruits} />
      </div>
    );
  }
}

export default Fruits;
