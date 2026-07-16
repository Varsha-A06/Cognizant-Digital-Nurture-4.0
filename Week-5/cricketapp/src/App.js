import ListofPlayers from "./ListofPlayers";
import IndianPlayers from "./IndianPlayers";

function App() {

  const flag = true; //const flag = false;(Odd Players / Even Players)

  if (flag) {
    return <ListofPlayers />;
  }
  else {
    return <IndianPlayers />;
  }

}

export default App;