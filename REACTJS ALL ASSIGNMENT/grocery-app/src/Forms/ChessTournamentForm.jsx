import React, { useState } from "react";
import { Formik, Form, Field, ErrorMessage } from "formik";
import * as Yup from "yup";
import "bootstrap/dist/css/bootstrap.min.css";

const ChessTournamentForm = () => {
  // State to store submitted players
  const [players, setPlayers] = useState([]);

  //Validation using yup
  const validationSchema = Yup.object({
    playerName: Yup.string()
      .min(3, "Name must be at least 3 characters")
      .required("Player Name is required"),
    dob: Yup.date()
      .required("Date of Birth is required")
      .test("age-range", "Age must be between 5 and 90", function (value) {
        if (!value) return false;
        const today = new Date();
        const birthDate = new Date(value);
        const age = today.getFullYear() - birthDate.getFullYear();
        return age >= 5 && age <= 90;
      }),

    gender: Yup.string().required("Gender is required"),

    fideId: Yup.string()
      .matches(/^\d{8}$/, "FIDE ID must be exactly 8 digits")
      .required("FIDE ID is required"),

    rating: Yup.number()
      .min(100, "Rating must be at least 100")
      .max(3000, "Rating must be less than or equal to 3000")
      .required("Rating is required"),

    email: Yup.string().email("Invalid email").required("Email is required"),

    mobile: Yup.string()
      .matches(/^[6-9]\d{9}$/, "Mobile must be 10 digits starting with 6-9")
      .required("Mobile Number is required"),

    country: Yup.string().required("Country is required"),
    
    category: Yup.string().required("Category is required"),

    //Fixed parentContact validation (callback style)
    parentContact: Yup.string().when("category", (category, schema) => {
      if (category === "Under 12") {
        return schema
          .matches(/^[6-9]\d{9}$/, "Parent Contact must be valid 10-digit number")
          .required("Parent Contact is required for Under 12");
      }
      return schema.notRequired();
    }),

    payment: Yup.boolean()
      .oneOf([true], "Payment confirmation is required")    //Checkboxes are booleans and .oneOf([true]) means to be checked.
      .required(),
    terms: Yup.boolean()
      .oneOf([true], "You must accept Terms & Conditions")
      .required(),
  });

  //Initial values
  const initialValues = {
    playerName: "",
    dob: "",
    gender: "",
    fideId: "",
    rating: "",
    email: "",
    mobile: "",
    country: "",
    category: "",
    parentContact: "",
    payment: false,
    terms: false,
  };

  //Submit handler
  const onSubmit = (values, { resetForm }) => {
    console.log("Submitted Data:", values); // log data print on console
    setPlayers([...players, values]); // add to table
    resetForm(); // reset form which clears the form after success
  };

  return (
    <div className="container mt-4">
      <h2 className="text-center mb-4">Chess Tournament Registration</h2>

      {/* Formik wrappera and Formik takes your initial values, validation schema, and submit function.*/}
      <Formik
        initialValues={initialValues}
        validationSchema={validationSchema}
        onSubmit={onSubmit}
      >
        {/* Formik Form */}
        <Form className="border p-4 rounded shadow">
          {/* Player Name */}
          <div className="mb-3">
            <label className="form-label">Player Name</label>
            <Field name="playerName" className="form-control" />
            <ErrorMessage name="playerName" component="div" className="text-danger" />
          </div>

          {/* Date of Birth */}
          <div className="mb-3">
            <label className="form-label">Date of Birth</label>
            <Field type="date" name="dob" className="form-control" />
            <ErrorMessage name="dob" component="div" className="text-danger" />
          </div>

          {/* Gender */}
          <div className="mb-3">
            <label className="form-label">Gender</label>
            <Field as="select" name="gender" className="form-select">
              <option value="">Select Gender</option>
              <option value="Male">Male</option>
              <option value="Female">Female</option>
              <option value="Other">Other</option>
            </Field>
            <ErrorMessage name="gender" component="div" className="text-danger" />
          </div>

          {/* FIDE ID */}
          <div className="mb-3">
            <label className="form-label">FIDE ID</label>
            <Field name="fideId" className="form-control" />
            <ErrorMessage name="fideId" component="div" className="text-danger" />
          </div>

          {/* Rating */}
          <div className="mb-3">
            <label className="form-label">Rating</label>
            <Field type="number" name="rating" className="form-control" />
            <ErrorMessage name="rating" component="div" className="text-danger" />
          </div>

          {/* Email */}
          <div className="mb-3">
            <label className="form-label">Email</label>
            <Field type="email" name="email" className="form-control" />
            <ErrorMessage name="email" component="div" className="text-danger" />
          </div>

          {/* Mobile */}
          <div className="mb-3">
            <label className="form-label">Mobile Number</label>
            <Field name="mobile" className="form-control" />
            <ErrorMessage name="mobile" component="div" className="text-danger" />
          </div>

          {/* Country */}
          <div className="mb-3">
            <label className="form-label">Country</label>
            <Field name="country" className="form-control" />
            <ErrorMessage name="country" component="div" className="text-danger" />
          </div>

          {/* Category */}
          <div className="mb-3">
            <label className="form-label">Category</label>
            <Field as="select" name="category" className="form-select">
              <option value="">Select Category</option>
              <option value="Under 12">Under 12</option>
              <option value="Under 18">Under 18</option>
              <option value="Open">Open</option>
            </Field>
            <ErrorMessage name="category" component="div" className="text-danger" />
          </div>

          {/* Parent Contact */}
          <div className="mb-3">
            <label className="form-label">Parent Contact</label>
            <Field name="parentContact" className="form-control" />
            <ErrorMessage name="parentContact" component="div" className="text-danger" />
          </div>

          {/* Payment Confirmation */}
          <div className="form-check mb-3">
            <Field type="checkbox" name="payment" className="form-check-input" />
            <label className="form-check-label">Payment Confirmed</label>
            <ErrorMessage name="payment" component="div" className="text-danger" />
          </div>

          {/* Terms */}
          <div className="form-check mb-3">
            <Field type="checkbox" name="terms" className="form-check-input" />
            <label className="form-check-label">Accept Terms & Conditions</label>
            <ErrorMessage name="terms" component="div" className="text-danger" />
          </div>

          {/* Submit button */}
          <button type="submit" className="btn btn-primary w-100">
            Register Player
          </button>
        </Form>
      </Formik>

      {/* Table for registered players */}
      {players.length > 0 && (
        <div className="mt-5">
          <h3 className="mb-3">Registered Players</h3>
          <table className="table table-striped table-bordered">
            <thead>
              <tr>
                <th>Player Name</th>
                <th>DOB</th>
                <th>Gender</th>
                <th>FIDE ID</th>
                <th>Rating</th>
                <th>Email</th>
                <th>Mobile</th>
                <th>Country</th>
                <th>Category</th>
                <th>Parent Contact</th>
              </tr>
            </thead>
            <tbody>
              {players.map((p, index) => (
                <tr key={index}>
                  <td>{p.playerName}</td>
                  <td>{p.dob}</td>
                  <td>{p.gender}</td>
                  <td>{p.fideId}</td>
                  <td>{p.rating}</td>
                  <td>{p.email}</td>
                  <td>{p.mobile}</td>
                  <td>{p.country}</td>
                  <td>{p.category}</td>
                  <td>{p.parentContact}</td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      )}
    </div>
  );
};

export default ChessTournamentForm;
