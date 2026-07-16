import React, { Component } from "react";

class App extends Component {

  constructor() {
    super();

    this.state = {
      count: 1,
      amount: 80,
      currency: "Euro"
    };
  }

  
  increment = () => {
    this.setState({
      count: this.state.count + 1
    });
  };

  
  decrement = () => {
    this.setState({
      count: this.state.count - 1
    });
  };

  sayHello = () => {
    alert("Hello! Member!");
};

 
  incrementValue = () => {
    this.increment();
    this.sayHello();
  };

  
  sayWelcome = (msg) => {
    alert(msg);
  };

  
  handlePress = () => {
    alert("I was clicked");
};

 
  handleSubmit = () => {

   const euro = this.state.amount / 80;
alert("Euro Amount = " + euro.toFixed(2));

  };

  render() {

    return (

      <div style={{ margin: "20px" }}>

        <h3>{this.state.count}</h3>

        <button onClick={this.incrementValue}>
          Increment
        </button>

        <br /><br />

        <button onClick={this.decrement}>
          Decrement
        </button>

        <br /><br />
<button onClick={() => this.sayWelcome("Welcome to React!")}>
    Say welcome
</button>

        <br /><br />

        <button onClick={this.handlePress}>
  Click on me
</button>

        <br /><br /><br />

        <h1 style={{ color: "green" }}>
          Currency Convertor!!!
        </h1>

        <table>

          <tbody>

            <tr>

              <td>Amount:</td>

              <td>

                <input
                  type="number"
                  value={this.state.amount}
                  onChange={(e) =>
                    this.setState({ amount: e.target.value })
                  }
                />

              </td>

            </tr>

            <tr>

              <td>Currency:</td>

              <td>

                <select
                  value={this.state.currency}
                  onChange={(e) =>
                    this.setState({ currency: e.target.value })
                  }
                >

                  <option>Euro</option>

                </select>

              </td>

            </tr>

            <tr>

              <td></td>

              <td>

                <button onClick={this.handleSubmit}>
                  Submit
                </button>

              </td>

            </tr>

          </tbody>

        </table>

      </div>

    );

  }

}

export default App;