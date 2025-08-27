import React from "react";

// this is functional compoent and receives a prop - service
function ServiceCard({ service }) {
  return (
    <div className="col-md-4 mb-4">
      <div className="card shadow-md">
        <div className="card-body">
          <h5 className="card-title">{service.serviceName}</h5>
          <p className="card-text">Price: Rs. {service.price}</p>
          {/*  .map() for looping fabrics */}
          <h6>Fabrics:</h6>
          <ul>
            {service.fabrics.map((fabric, index) => (
              <li key={index}>{fabric}</li>
            ))}
          </ul>
        </div>
      </div>
    </div>
  );
}

export default ServiceCard;
