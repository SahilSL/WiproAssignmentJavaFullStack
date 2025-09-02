import * as Yup from "yup";

const today = new Date();
const minDate = new Date(today.getFullYear() - 55, today.getMonth(), today.getDate());
const maxDate = new Date(today.getFullYear() - 10, today.getMonth(), today.getDate());

export const registrationSchema = Yup.object({
  playerName: Yup.string()
    .matches(/^[A-Za-z ]+$/, "Only alphabets and spaces allowed")
    .min(3).max(40).required("Player name is required"),

  jerseyNumber: Yup.number()
    .min(1).max(99).required("Jersey number is required"),

  position: Yup.string().required("Position is required"),

  stickHand: Yup.string().required("Stick hand is required"),

  dateOfBirth: Yup.date()
    .min(minDate, "Player too old")
    .max(maxDate, "Player too young")
    .required("Date of birth is required"),

  nationality: Yup.string().required("Nationality is required"),

  email: Yup.string().email("Invalid email").required("Email is required"),

  phone: Yup.string()
    .matches(/^[6-9]\d{9}$/, "Invalid Indian mobile number")
    .required("Phone is required"),

  playerId: Yup.string()
    .matches(/^HOCK-\d{4}$/, "Format must be HOCK-XXXX")
    .required("Player ID is required"),

  guardianName: Yup.string().when("dateOfBirth", (dob, schema) => {
    if (dob) {
      const age = today.getFullYear() - new Date(dob).getFullYear();
      if (age < 18) return schema.required("Guardian name is required");
    }
    return schema;
  }),

  teamName: Yup.string().required("Team name is required"),

  leagueLevel: Yup.string().required("League level is required"),

  tournamentName: Yup.string().required("Tournament name is required"),

  startDate: Yup.date().required("Start date is required"),

  endDate: Yup.date()
    .required("End date is required")
    .min(Yup.ref("startDate"), "End date must be on or after start date"),

  jerseySize: Yup.string().when("position", {
    is: (val) => val !== "Goalie",
    then: (schema) => schema.required("Jersey size is required"),
    otherwise: (schema) => schema.notRequired(),
  }),

  padSize: Yup.string().when("position", {
    is: "Goalie",
    then: (schema) => schema.required("Pad size is required"),
    otherwise: (schema) => schema.notRequired(),
  }),

  hasMedicalCondition: Yup.boolean(),

  medicalCertNumber: Yup.string().when("hasMedicalCondition", {
    is: true,
    then: (schema) => schema.matches(/^MED-\d{4}$/, "Format must be MED-XXXX").required("Medical Cert is required"),
    otherwise: (schema) => schema.notRequired(),
  }),

  consent: Yup.boolean().oneOf([true], "Consent is required"),

  pastTeams: Yup.array().of(
    Yup.object({
      clubName: Yup.string().min(2).max(30).required("Club name is required"),
      years: Yup.number().min(1).max(20).required("Years required"),
    })
  ).max(3, "Max 3 past teams allowed"),
});
