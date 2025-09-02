import React, { useEffect, useState } from "react";
import api from "../api/api";
import TaxPayerForm from "../components/TaxPayerForm";
import TaxPayerList from "../components/TaxPayerList";

const Dashboard = () => {
  const [taxpayers, setTaxpayers] = useState([]);
  const [editing, setEditing] = useState(null);

  const fetchAll = async () => {
    try {
      const res = await api.get("/taxpayers");
      setTaxpayers(res.data);
    } catch (err) {
      console.error("Fetch error", err);
      setTaxpayers([]);
      // if 401/403, tell user to login / set token
      if (err?.response?.status === 401 || err?.response?.status === 403) {
        alert("Unauthorized. Please ensure you have a valid JWT token in localStorage.");
      }
    }
  };

  useEffect(() => { fetchAll(); }, []);

  const handleSaved = () => {
    setEditing(null);
    fetchAll();
  };

  return (
    // <div style={{ padding: 16 }}>
    //   <h2>Income Tax Management Dashboard</h2>

    //   <TaxPayerForm initialValues={editing} onSaved={handleSaved} />

    //   <TaxPayerList
    //     taxpayers={taxpayers}
    //     onEdit={(t) => setEditing(t)}
    //     onRefresh={fetchAll}
    //   />
    // </div>
  
  <div>
      <h2 className="mb-4 text-center text-primary">Income Tax Management Dashboard</h2>
      <div className="row">
        <div className="col-lg-4 mb-4">
          <TaxPayerForm initialValues={editing} onSaved={handleSaved} />
        </div>
        <div className="col-lg-8">
          <TaxPayerList
            taxpayers={taxpayers}
            onEdit={(t) => setEditing(t)}
            onRefresh={fetchAll}
          />
        </div>
      </div>
    </div>
  
  );
};

export default Dashboard;
