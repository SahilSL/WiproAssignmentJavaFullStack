import React from "react";

const RecordsTable = ({ records }) => {
  if (records.length === 0) return null;

  return (
    <div className="mt-5">
      <h4>Submitted Records</h4>
      <table className="table table-bordered">
        <thead>
          <tr>
            <th>Player Name</th>
            <th>Jersey #</th>
            <th>Position</th>
            <th>Stick Hand</th>
            <th>DOB</th>
            <th>Nationality</th>
            <th>Email</th>
            <th>Phone</th>
            <th>Team</th>
            <th>League</th>
            <th>Tournament</th>
          </tr>
        </thead>
        <tbody>
          {records.map((rec, i) => (
            <tr key={i}>
              <td>{rec.playerName}</td>
              <td>{rec.jerseyNumber}</td>
              <td>{rec.position}</td>
              <td>{rec.stickHand}</td>
              <td>{rec.dateOfBirth}</td>
              <td>{rec.nationality}</td>
              <td>{rec.email}</td>
              <td>{rec.phone}</td>
              <td>{rec.teamName}</td>
              <td>{rec.leagueLevel}</td>
              <td>{rec.tournamentName}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default RecordsTable;
