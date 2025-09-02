import "bootstrap/dist/css/bootstrap.min.css"; 
//import React, { Component } from 'react'; 
//import React, { useState, useEffect } from "react";
import './App.css';
import Grocerylist from './Grocery';  //Assignment1
import Car from './car';  //Assignment2
import Phone from './Phone';  //Assignment3
import SweetsList from './Sweet';   //Assignment4
import Electronics from './Electronics';  //Assignment5
import CanteenMenu from './CanteenMenu';  //Assignment6
import JuiceList from './JuiceList';  //Assignment7
import Restaurant from './Restaurant';  //Assignment8
import Temple from "./Temple"; //Assignment9
import ServiceCard from "./ServiceCard";  //Assignment10
import Fruits from "./FruitsApp";   //Assignment11
import TelevisionManager from "./Television"; //Assignment12
import MarriageForm from "./MarriageForm"; //Assignment13
import AccessoriesForm from "./AccessoriesForm"; //Assignment14
import BakingForm from "./BakingForm"; //Assignment15
//Flight Booking Form - pending
//Movie List
//Electronic product details, ternary operator
//Furniture items
import FestivalApp from './FestivalApp'; //festival react app Assignment 19
//restaurant resgistration
//parent/child/sibling communication
import ChessTournamentForm from "./Forms/ChessTournamentForm"; //chess Tournament

import React, { useState } from "react";

import RegistrationForm from "./Hockey/components/RegistrationForm";
import RecordsTable from "./Hockey/components/RecordsTable"; //Hockey Tournament formik+yup+bs
//Tailoring shop inventory using json and axios
//football player management system
//Electricity Power Cut Announcement System Using React Context API and Bootstrap
//Create a React web app with multiple pages and a Bootstrap Navbar. Focus is on routing and navigation—no forms, no calculations.
import { BrowserRouter as Router, Routes, Route, useLocation  } from "react-router-dom";
import NavigationBar from "./RoutingAssignment/Navbar";
import Home from "./RoutingAssignment/Home";
import AddTaxpayer from "./RoutingAssignment/AddTaxpayer";
import TaxpayerList from "./RoutingAssignment/TaxpayerList";
import CalculateTax from "./RoutingAssignment/CalculateTax";
import TaxRates from "./RoutingAssignment/TaxRates";
import Contact from "./RoutingAssignment/Contact";
import About from "./RoutingAssignment/About";
import FAQ from "./RoutingAssignment/FAQ";
import NotFound from "./RoutingAssignment/NotFound";

//Assignment 28
import Navbar from './JewelleryShop/Navbar';
import Home1 from './JewelleryShop/Home1';
import Products from './JewelleryShop/Products';
import ProductDetails from './JewelleryShop/ProductDetails';
import Cart from './JewelleryShop/Cart';
import Checkout from './JewelleryShop/Checkout';
import NotFound1 from './JewelleryShop/NotFound1';

function App() {
  // for A1
  const groceryItems = ['Rice', 'Wheat', 'Sugar', 'Milk', 'Oil'];   // Grocery items array

  // For A10
  const services = [
    {
      serviceName: "Shirt",
      price: 20,
      fabrics: ["Cotton", "Linen", "Polyester"]
    },
    {
      serviceName: "Pant",
      price: 30,
      fabrics: ["Denim", "Wool", "Chino"]
    },
    {
      serviceName: "Lehenga",
      price: 150,
      fabrics: ["Silk", "Georgette",  "Chiffon"]
    },
    {
      serviceName: "Blouse",
      price: 40,
      fabrics: [ "Cotton", "Silk", "Satin"]
    }
  ];


//Assignment28
function AppWrapper() {
  const location = useLocation();

  return (
    <div className="page fade-in">
      <Navbar />
      <Routes location={location}>
        <Route path="/" element={<Home1 />} />
        <Route path="/products" element={<Products />} />
        <Route path="/products/:id" element={<ProductDetails />} />
        <Route path="/cart" element={<Cart />} />
        <Route path="/checkout" element={<Checkout />} />
        <Route path="*" element={<NotFound1 />} />
      </Routes>
    </div>
  );
}

//hockey
  const [records, setRecords] = useState([]);

  const handleAddRecord = (data) => {
    console.log("Submitted Data:", data);
    setRecords((prev) => [...prev, data]);
  };

  return (
    <>
      {/* Assignment1 */}
      <h1 style={{textAlign:"center", color:"grey"}}>Assignment 1</h1>
      <div className="App">
        <Grocerylist items={groceryItems} />
      </div>

      <div><br/><hr/><br/></div>

      {/* Assignment2 */}
      <h1 style={{textAlign:"center", color:"grey"}}>Assignment 2</h1>
      <div className="App">
        <Car brand="Toyota"
          model="Fortuner"
          color="Black"
          year="2022" />
      </div>

      <div><br></br><hr></hr><br></br></div>

      {/* Assignment3 */}
      <h1 style={{textAlign:"center", color:"grey"}}>Assignment 3</h1>
      <div className="App">
        <Phone />
      </div>

      <div><br></br><hr></hr><br></br></div>

      {/* Assignment4 */}
      <h1 style={{textAlign:"center", color:"grey"}}>Assignment 4</h1>
      <div className="App">
        <SweetsList />
      </div>

      <div><br></br><hr></hr><br></br></div>

      {/* Assignment5 */}
      <h1 style={{textAlign:"center", color:"grey"}}>Assignment 5</h1>
      <div className="App">
        <Electronics />
      </div>

      <div><br></br><hr></hr><br></br></div>

      {/* Assignment6 */}
      <h1 style={{textAlign:"center", color:"grey"}}>Assignment 6</h1>
      <div className="App" style={{ padding: '20px' }}>
        <CanteenMenu />
      </div>

      <div><br></br><hr></hr><br></br></div>

      {/* Assignment7 */}
      <h1 style={{textAlign:"center", color:"grey"}}>Assignment 7</h1>
      <div className="App" style={{ padding: '20px' }}>
        <JuiceList />
      </div>

      <div><br></br><hr></hr><br></br></div>

      {/* Assignment8 */}
      <h1 style={{textAlign:"center", color:"grey"}}>Assignment 8</h1>
      <div className="App" style={{ padding: '20px' }}>
        <Restaurant />
      </div>

      <div><br></br><hr></hr><br></br></div>

      {/* Assignment9 */}
      <h1 style={{textAlign:"center", color:"grey"}}>Assignment 9</h1>
       <div>
      <h1 style={{ textAlign: "center" }}>Famous Temples in India</h1>
      <Temple />
    </div>


      <div><br></br><hr></hr><br></br></div>
      {/* Assignment10 */}
      <h1 style={{textAlign:"center", color:"grey"}}>Assignment 10</h1>
      <div className="container">
      <h2 className="text-center mb-4">Tailoring Services</h2>
      <div className="row">
        {/* Looping through services */}
        {services.map((service, index) => (
          <ServiceCard key={index} service={service} />
        ))}
      </div>
    </div>

    <div><br></br><hr></hr><br></br></div>
    <h1 style={{textAlign:"center", color:"grey"}}>Assignment 11</h1>
      {/* Assignment11 */}
    <div className="text-center mb-4">
      <Fruits />
    </div>


<div><br></br><hr></hr><br></br></div>
{/* Assignment12 */}
<h1 style={{textAlign:"center", color:"grey"}}>Assignment 12</h1>
<div>
      <TelevisionManager />
    </div>


<div><br></br><hr></hr><br></br></div>
{/* Assignment13 */}
<h1 style={{textAlign:"center", color:"grey"}}>Assignment 13</h1>
 <div>
      <MarriageForm />  
    </div>

<div><br></br><hr></hr><br></br></div>
{/* Assignment14 */}
<h1 style={{textAlign:"center", color:"grey"}}>Assignment 14</h1>
<div>
      <AccessoriesForm />  
    </div>


<div><br></br><hr></hr><br></br></div>
{/* Assignment15 */}
<h1 style={{textAlign:"center", color:"grey"}}>Assignment 15</h1>
<div><BakingForm/></div>


<div><br></br><hr></hr><br></br></div>
{/* Assignment16 */}
<h1 style={{textAlign:"center", color:"grey"}}>Assignment 16</h1>



<div><br></br><hr></hr><br></br></div>
<h1 style={{textAlign:"center", color:"grey"}}>Assignment 17</h1>













<div><br></br><hr></hr><br></br></div>
<h1 style={{textAlign:"center", color:"grey"}}>Assignment 19</h1>
<div><FestivalApp /></div>




















<div><br></br><hr></hr><br></br></div>
<h1 style={{textAlign:"center", color:"grey"}}>Assignment 20</h1>



<div><br></br><hr></hr><br></br></div>
<h1 style={{textAlign:"center", color:"grey"}}>Assignment 21</h1>



<div><br></br><hr></hr><br></br></div>
<h1 style={{textAlign:"center", color:"grey"}}>Assignment 22</h1>
<div><ChessTournamentForm /></div>

<div><br></br><hr></hr><br></br></div>
<h1 style={{textAlign:"center", color:"grey"}}>Assignment 23</h1>
<div className="container my-4">
      <h2 className="mb-4">Hockey Tournament Registration</h2>
      <RegistrationForm onSubmit={handleAddRecord} />
      <RecordsTable records={records} />
    </div>

<div><br></br><hr></hr><br></br></div>
<h1 style={{textAlign:"center", color:"grey"}}>Assignment 24</h1>



<div><br></br><hr></hr><br></br></div>
<h1 style={{textAlign:"center", color:"grey"}}>Assignment 25</h1>



<div><br></br><hr></hr><br></br></div>
<h1 style={{textAlign:"center", color:"grey"}}>Assignment 26</h1>



<div><br></br><hr></hr><br></br></div>
<h1 style={{textAlign:"center", color:"grey"}}>Assignment 27</h1>
<Router> {/*Router handles navigation*/}
      {/* Navbar is common for all pages */}
      <NavigationBar /> {/*to display the nav bar alwasys on the top */}

      <div className="container mt-4">
        {/* Routes define page paths or we can say like it contains all the routes definitions */}
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/add-taxpayer" element={<AddTaxpayer />} />
          <Route path="/taxpayer-list" element={<TaxpayerList />} />
          <Route path="/calculate-tax" element={<CalculateTax />} />
          <Route path="/tax-rates" element={<TaxRates />} />
          <Route path="/contact" element={<Contact />} />
          <Route path="/about" element={<About />} />
          <Route path="/faq" element={<FAQ />} />
          {/* * means any unknown route */}
          <Route path="*" element={<NotFound />} />
        </Routes>
      </div>
    </Router>


<div><br></br><hr></hr><br></br></div>
<h1 style={{textAlign:"center", color:"grey"}}>Assignment 28</h1>
<Router>
      <AppWrapper />
    </Router>



<div><br></br><hr></hr><br></br></div>
<h1 style={{textAlign:"center", color:"grey"}}>Assignment 29</h1>

    </>
  );
}

export default App;
