import React, { Component } from "react";

// functional Component and Displays TV models
function TelevisionList({ models }) { //It receives props which is models as decelared below.
  return (
    <ul>
      {models.map((model, index) => (
        <li key={index}>{model}</li>
  ))}
    </ul>
  );
}

/*
Props: data passed from a parent component to a child component.
.map(): used to loop through arrays and render multiple JSX elements.
key={index}: helps React identify each list item uniquely.
*/

//class Component and Manages TV models in state
class TelevisionManager extends Component {
  constructor(props) {
    super(props);     //super() written in class components to use this

    this.state = {
      models: ["MI", "TCL", "ONIDA", "VIDEOCON"],
      newModel: ""
    };
  }

  // handle input typing
  handleChange = (e) => {
    this.setState({ newModel: e.target.value });  //current text type
  };  //setState updates the state

  // add new TV model to list
  addModel = () => {
    if (this.state.newModel.trim() !== "") {
      this.setState((prevState) => ({
        models: [...prevState.models, prevState.newModel], // spread operator which copies old array values
        newModel: "" // clear input
      }));
    }
  };

  render() {
    return (
      <div>
        <h2>Television Manager</h2>
        <input
          type="text"
          value={this.state.newModel}
          onChange={this.handleChange}
          placeholder="Enter TV model"
        /><br></br>
        <button className="btn btn-primary " onClick={this.addModel}>Add TV Model</button>

        {/* Passing models array to child */}
        <TelevisionList models={this.state.models} />
      </div>
    );
  }
}

export default TelevisionManager;
