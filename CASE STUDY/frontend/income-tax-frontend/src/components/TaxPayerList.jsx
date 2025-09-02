import React from "react";
import api from "../api/api";

const TaxPayerList = ({ taxpayers, onEdit, onRefresh }) => {
  const handleDelete = async (id) => {
    if (!window.confirm("Delete this taxpayer?")) return;
    try {
      await api.delete(`/taxpayers/${id}`);
      alert("Deleted");
      if (onRefresh) onRefresh();
    } catch (err) {
      console.error("Delete error:", err);
      alert("Delete failed");
    }
  };

  return (
    <div style={{ border: "1px solid #eee", padding: 12 }}>
      <h3>Taxpayers</h3>
      {taxpayers.length === 0 ? (
        <div>No taxpayers found</div>
      ) : (
        // <table style={{ width: "100%", borderCollapse: "collapse" }}>
        //   <thead>
        //     <tr>
        //       <th style={{ border: "1px solid #ddd", padding: 6 }}>ID</th>
        //       <th style={{ border: "1px solid #ddd", padding: 6 }}>Name</th>
        //       <th style={{ border: "1px solid #ddd", padding: 6 }}>PAN</th>
        //       <th style={{ border: "1px solid #ddd", padding: 6 }}>Annual Income</th>
        //       <th style={{ border: "1px solid #ddd", padding: 6 }}>Actions</th>
        //     </tr>
        //   </thead>
        //   <tbody>
        //     {taxpayers.map((t) => (
        //       <tr key={t.id}>
        //         <td style={{ border: "1px solid #ddd", padding: 6 }}>{t.id}</td>
        //         <td style={{ border: "1px solid #ddd", padding: 6 }}>{t.name}</td>
        //         <td style={{ border: "1px solid #ddd", padding: 6 }}>{t.panNumber}</td>
        //         <td style={{ border: "1px solid #ddd", padding: 6 }}>{t.annualIncome}</td>
        //         <td style={{ border: "1px solid #ddd", padding: 6 }}>
        //           <button onClick={() => onEdit && onEdit(t)}>Edit</button>{" "}
        //           <button onClick={() => handleDelete(t.id)}>Delete</button>
        //         </td>
        //       </tr>
        //     ))}
        //   </tbody>
        // </table>

        <table className="table table-striped table-bordered">
  <thead className="table-dark">
    <tr>
      <th>ID</th>
      <th>Name</th>
      <th>PAN</th>
      <th>Annual Income</th>
      <th>Actions</th>
    </tr>
  </thead>
  <tbody>
    {taxpayers.map((t) => (
      <tr key={t.id}>
        <td>{t.id}</td>
        <td>{t.name}</td>
        <td>{t.panNumber}</td>
        <td>{t.annualIncome}</td>
        <td>
          <button onClick={() => onEdit && onEdit(t)} className="btn btn-sm btn-warning me-2">Edit</button>
          <button onClick={() => handleDelete(t.id)} className="btn btn-sm btn-danger">Delete</button>
        </td>
      </tr>
    ))}
  </tbody>
</table>

      )}
    </div>
  );
};

export default TaxPayerList;
