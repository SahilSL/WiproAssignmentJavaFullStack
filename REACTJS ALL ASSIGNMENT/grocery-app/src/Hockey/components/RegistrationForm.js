import React from "react";
import { Formik, Form, Field, FieldArray, ErrorMessage } from "formik";
import { registrationSchema } from "../validation/validationSchema";

const RegistrationForm = ({ onSubmit }) => {
  return (
    <Formik
      initialValues={{
        playerName: "",
        jerseyNumber: "",
        position: "",
        stickHand: "",
        dateOfBirth: "",
        nationality: "",
        email: "",
        phone: "",
        playerId: "",
        guardianName: "",
        teamName: "",
        leagueLevel: "",
        tournamentName: "",
        startDate: "",
        endDate: "",
        jerseySize: "",
        padSize: "",
        hasMedicalCondition: false,
        medicalCertNumber: "",
        consent: false,
        pastTeams: [],
      }}
      validationSchema={registrationSchema}
      onSubmit={(values, { resetForm }) => {
        onSubmit(values);
        resetForm();
      }}
    >
      {({ values, isValid, dirty }) => (
        <Form className="row g-3">

          {/* Player Details */}
          <h4>Player Details</h4>
          <div className="col-md-6">
            <label>Player Name</label>
            <Field name="playerName" className="form-control" />
            <ErrorMessage name="playerName" component="div" className="text-danger" />
          </div>

          <div className="col-md-6">
            <label>Jersey Number</label>
            <Field name="jerseyNumber" type="number" className="form-control" />
            <ErrorMessage name="jerseyNumber" component="div" className="text-danger" />
          </div>

          <div className="col-md-6">
            <label>Position</label>
            <Field as="select" name="position" className="form-control">
              <option value="">Select</option>
              <option>Forward</option>
              <option>Defense</option>
              <option>Goalie</option>
            </Field>
            <ErrorMessage name="position" component="div" className="text-danger" />
          </div>

          <div className="col-md-6">
            <label>Stick Hand</label>
            <Field as="select" name="stickHand" className="form-control">
              <option value="">Select</option>
              <option>Left</option>
              <option>Right</option>
            </Field>
            <ErrorMessage name="stickHand" component="div" className="text-danger" />
          </div>

          <div className="col-md-6">
            <label>Date of Birth</label>
            <Field type="date" name="dateOfBirth" className="form-control" />
            <ErrorMessage name="dateOfBirth" component="div" className="text-danger" />
          </div>

          <div className="col-md-6">
            <label>Nationality</label>
            <Field name="nationality" className="form-control" />
            <ErrorMessage name="nationality" component="div" className="text-danger" />
          </div>

          <div className="col-md-6">
            <label>Email</label>
            <Field type="email" name="email" className="form-control" />
            <ErrorMessage name="email" component="div" className="text-danger" />
          </div>

          <div className="col-md-6">
            <label>Phone</label>
            <Field name="phone" className="form-control" />
            <ErrorMessage name="phone" component="div" className="text-danger" />
          </div>

          <div className="col-md-6">
            <label>Player ID</label>
            <Field name="playerId" className="form-control" />
            <ErrorMessage name="playerId" component="div" className="text-danger" />
          </div>

          {values.dateOfBirth && (
            <div className="col-md-6">
              <label>Guardian Name</label>
              <Field name="guardianName" className="form-control" />
              <ErrorMessage name="guardianName" component="div" className="text-danger" />
            </div>
          )}

          {/* Team & Event */}
          <h4 className="mt-4">Team & Event Information</h4>
          <div className="col-md-6">
            <label>Team Name</label>
            <Field name="teamName" className="form-control" />
            <ErrorMessage name="teamName" component="div" className="text-danger" />
          </div>

          <div className="col-md-6">
            <label>League Level</label>
            <Field as="select" name="leagueLevel" className="form-control">
              <option value="">Select</option>
              <option>Amateur</option>
              <option>College</option>
              <option>Pro</option>
            </Field>
            <ErrorMessage name="leagueLevel" component="div" className="text-danger" />
          </div>

          <div className="col-md-6">
            <label>Tournament Name</label>
            <Field name="tournamentName" className="form-control" />
            <ErrorMessage name="tournamentName" component="div" className="text-danger" />
          </div>

          <div className="col-md-3">
            <label>Start Date</label>
            <Field type="date" name="startDate" className="form-control" />
            <ErrorMessage name="startDate" component="div" className="text-danger" />
          </div>

          <div className="col-md-3">
            <label>End Date</label>
            <Field type="date" name="endDate" className="form-control" />
            <ErrorMessage name="endDate" component="div" className="text-danger" />
          </div>

          {values.position && values.position !== "Goalie" && (
            <div className="col-md-6">
              <label>Jersey Size</label>
              <Field name="jerseySize" className="form-control" />
              <ErrorMessage name="jerseySize" component="div" className="text-danger" />
            </div>
          )}

          {values.position === "Goalie" && (
            <div className="col-md-6">
              <label>Pad Size</label>
              <Field name="padSize" className="form-control" />
              <ErrorMessage name="padSize" component="div" className="text-danger" />
            </div>
          )}

          {/* Medical & Consent */}
          <h4 className="mt-4">Medical & Consent</h4>
          <div className="col-md-6 form-check">
            <Field type="checkbox" name="hasMedicalCondition" className="form-check-input" />
            <label className="form-check-label">Has Medical Condition</label>
          </div>

          {values.hasMedicalCondition && (
            <div className="col-md-6">
              <label>Medical Cert Number</label>
              <Field name="medicalCertNumber" className="form-control" />
              <ErrorMessage name="medicalCertNumber" component="div" className="text-danger" />
            </div>
          )}

          <div className="col-md-12 form-check">
            <Field type="checkbox" name="consent" className="form-check-input" />
            <label className="form-check-label">I give consent</label>
            <ErrorMessage name="consent" component="div" className="text-danger" />
          </div>

          {/* Past Teams */}
          <h4 className="mt-4">Past Teams</h4>
          <FieldArray name="pastTeams">
            {({ push, remove }) => (
              <div>
                {values.pastTeams.map((team, index) => (
                  <div key={index} className="row mb-2">
                    <div className="col-md-5">
                      <Field name={`pastTeams.${index}.clubName`} className="form-control" placeholder="Club Name" />
                      <ErrorMessage name={`pastTeams.${index}.clubName`} component="div" className="text-danger" />
                    </div>
                    <div className="col-md-3">
                      <Field name={`pastTeams.${index}.years`} type="number" className="form-control" placeholder="Years" />
                      <ErrorMessage name={`pastTeams.${index}.years`} component="div" className="text-danger" />
                    </div>
                    <div className="col-md-2">
                      <button type="button" className="btn btn-danger" onClick={() => remove(index)}>Remove</button>
                    </div>
                  </div>
                ))}
                {values.pastTeams.length < 3 && (
                  <button type="button" className="btn btn-secondary" onClick={() => push({ clubName: "", years: "" })}>
                    Add Past Team
                  </button>
                )}
              </div>
            )}
          </FieldArray>

          {/* Submit */}
          <div className="col-12 mt-3">
            <button type="submit" className="btn btn-primary" disabled={!dirty || !isValid}>
              Submit
            </button>
          </div>
        </Form>
      )}
    </Formik>
  );
};

export default RegistrationForm;
