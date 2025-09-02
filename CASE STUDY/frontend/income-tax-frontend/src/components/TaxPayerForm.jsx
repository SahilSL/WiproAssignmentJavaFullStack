import React from "react";
import { Formik, Form, Field, ErrorMessage } from "formik";
import * as Yup from "yup";
import api from "../api/api";

const schema = Yup.object().shape({
  name: Yup.string().trim().required("Name is required"),
  panNumber: Yup.string().trim().required("PAN is required"),
  annualIncome: Yup.number()
    .typeError("Annual Income must be a number")
    .min(0, "Annual Income must be positive")
    .required("Annual Income is required"),
});

const TaxPayerForm = ({ initialValues, onSaved }) => {
  // default empty values (used when creating new)
  const defaults = { id: null, name: "", panNumber: "", annualIncome: "" };

  return (
    <div style={{ border: "1px solid #ddd", padding: 12, marginBottom: 12 }}>
      <h3>{initialValues && initialValues.id ? "Edit Taxpayer" : "Add Taxpayer"}</h3>

      <Formik
        initialValues={initialValues || defaults}
        validationSchema={schema}
        enableReinitialize
        onSubmit={async (values, { setSubmitting, resetForm }) => {
          try {
            if (values.id) {
              await api.put(`/taxpayers/${values.id}`, values);
              alert("Taxpayer updated successfully");
            } else {
              await api.post("/taxpayers", values);
              alert("Taxpayer created successfully");
            }
            resetForm();
            if (onSaved) onSaved();
          } catch (err) {
            console.error("Error saving taxpayer:", err);
            const msg = err?.response?.data?.message || err?.message || "Save failed";
            alert("Error: " + msg);
          } finally {
            setSubmitting(false);
          }
        }}
      >
        {({ isSubmitting }) => (
          // <Form>
          //   <div style={{ marginBottom: 8 }}>
          //     <label htmlFor="name">Name</label><br />
          //     <Field id="name" name="name" placeholder="Full name" />
          //     <div style={{ color: "red", fontSize: 12 }}><ErrorMessage name="name" /></div>
          //   </div>

          //   <div style={{ marginBottom: 8 }}>
          //     <label htmlFor="panNumber">PAN Number</label><br />
          //     <Field id="panNumber" name="panNumber" placeholder="PAN" />
          //     <div style={{ color: "red", fontSize: 12 }}><ErrorMessage name="panNumber" /></div>
          //   </div>

          //   <div style={{ marginBottom: 8 }}>
          //     <label htmlFor="annualIncome">Annual Income</label><br />
          //     <Field id="annualIncome" name="annualIncome" placeholder="0" type="number" />
          //     <div style={{ color: "red", fontSize: 12 }}><ErrorMessage name="annualIncome" /></div>
          //   </div>

          //   <div>
          //     <button type="submit" disabled={isSubmitting}>
          //       {isSubmitting ? "Saving..." : (initialValues && initialValues.id ? "Update" : "Save")}
          //     </button>
          //   </div>
          // </Form>

          <Form>
  <div className="mb-3">
    <label htmlFor="name" className="form-label">Name</label>
    <Field id="name" name="name" placeholder="Full name" className="form-control" />
    <div className="text-danger small"><ErrorMessage name="name" /></div>
  </div>

  <div className="mb-3">
    <label htmlFor="panNumber" className="form-label">PAN Number</label>
    <Field id="panNumber" name="panNumber" placeholder="PAN" className="form-control" />
    <div className="text-danger small"><ErrorMessage name="panNumber" /></div>
  </div>

  <div className="mb-3">
    <label htmlFor="annualIncome" className="form-label">Annual Income</label>
    <Field id="annualIncome" name="annualIncome" placeholder="0" type="number" className="form-control" />
    <div className="text-danger small"><ErrorMessage name="annualIncome" /></div>
  </div>

  <button type="submit" disabled={isSubmitting} className="btn btn-primary">
    {isSubmitting ? "Saving..." : (initialValues && initialValues.id ? "Update" : "Save")}
  </button>
</Form>

        )}
      </Formik>
    </div>
  );
};

export default TaxPayerForm;
