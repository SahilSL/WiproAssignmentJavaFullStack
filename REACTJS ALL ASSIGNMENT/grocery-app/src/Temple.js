import React from "react";

// functional componene
const Temple = () => {
  //Array of data
  const temples = [
    {
      id: 1,
      name: "Meenakshi Amman Template",
      location: "Madurai, Tamil Nadu",
      deities: ["Meenakshi", "Sundareswarar"]
    },
    {
      id: 2,
      name: "Sri Venkateswara Temple",
      location: "Tirupati, AP",
      deities: ["Venkateswara", "Lakshmi"]
    },
    {
      id: 3,
      name: "Jagannath Temple",
      location: "Puri, Odisha",
      deities: ["Jagannath", "Balabhadra" ,"Subhadra"]
    }
  ];

  return (
    <div style={{ display: "flex", justifyContent: "center", marginTop: "20px" }}>
      <table border="2" cellPadding="8" cellSpacing="0">
        <thead>
          <tr>
            <th>ID</th>
            <th>Temple Name</th>
            <th>Location</th>
            <th>Deities</th>
          </tr>
        </thead>
        <tbody>
          {temples.map((temple, index) => (
      
            <tr key={temple.id}>          { /* Each row needs a unique key → we use temple.id */ }
                { /* to start indexing from 1 we use +1 */}
              <td>{index +1}</td>  
              <td>{temple.name}</td>    { /* temp name */ }
              <td>{temple.location}</td>
              <td>
                <ul>
                  { /* Each temple has multiple deities so for that only again use .map function so that it get display properly one by one as a list */ }
                  {temple.deities.map((deity, i) => (   
                    <li key={i}>{deity}</li>
                  ))}
                </ul>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default Temple;
