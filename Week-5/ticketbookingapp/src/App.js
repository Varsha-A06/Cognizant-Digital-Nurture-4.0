import { useState } from "react";
import Guest from "./Components/Guest";
import User from "./Components/User";

function App() {

  const [isLoggedIn, setIsLoggedIn] = useState(false);

  return (

    <div style={{ margin: "20px" }}>

      <h1>Ticket Booking App</h1>

      {

        isLoggedIn ?

          <div>

            <button onClick={() => setIsLoggedIn(false)}>
              Logout
            </button>

            <User />

          </div>

          :

          <div>

            <button onClick={() => setIsLoggedIn(true)}>
              Login
            </button>

            <Guest />

          </div>

      }

    </div>

  );

}

export default App;