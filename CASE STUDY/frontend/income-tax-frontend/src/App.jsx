
 import React from "react";
 import Dashboard from "./pages/Dashboard";

// function App() {
//   return (
//     <div>
//       <header style={{ background: "#282c34", color: "white", padding: 10 }}>
//         <h1 style={{ margin: 0 }}>Income Tax Management System</h1>
//       </header>
//       <main style={{ padding: 12 }}>
//         <Dashboard />
//       </main>
//     </div>
//   );
// }

// export default App;


function App() {
  return (
    <div>
      <header className="bg-dark text-white p-3 mb-4">
        <h1 className="text-center m-0">Income Tax Management System</h1>
      </header>
      <main className="container">
        <Dashboard />
      </main>
    </div>
  );
}

export default App;  
