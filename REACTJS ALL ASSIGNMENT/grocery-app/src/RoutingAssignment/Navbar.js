import React from "react";
import { NavLink } from "react-router-dom"; // NavLink is used to highlight active page
import { Navbar, Nav, Container } from "react-bootstrap"; // Bootstrap Navbar

// Navbar Component
const NavigationBar = () => {
  return (
    <Navbar bg="light" expand="lg"> {/* Bootstrap Navbar with light background */}
      <Container>
        {/* Brand name (like a logo or title) */}
        <Navbar.Brand href="/"><h2>Income Tax Department</h2></Navbar.Brand>

        {/* Hamburger menu toggle button for small screens */}
        <Navbar.Toggle aria-controls="basic-navbar-nav" />

        {/* Collapsible menu items */}
        <Navbar.Collapse id="basic-navbar-nav">
          <Nav className="me-auto">
            {/* NavLink used for routing - 'end' ensures exact matching for Home */}
            <Nav.Link as={NavLink} to="/" end>Home</Nav.Link>
            <Nav.Link as={NavLink} to="/add-taxpayer">Add Taxpayer</Nav.Link>
            <Nav.Link as={NavLink} to="/taxpayer-list">Taxpayer List</Nav.Link>
            <Nav.Link as={NavLink} to="/calculate-tax">Calculate Tax</Nav.Link>
            <Nav.Link as={NavLink} to="/tax-rates">Tax Rates</Nav.Link>
            <Nav.Link as={NavLink} to="/contact">Contact</Nav.Link>
            <Nav.Link as={NavLink} to="/about">About</Nav.Link>
            <Nav.Link as={NavLink} to="/faq">FAQ</Nav.Link>
            <Nav.Link as={NavLink} to="/*">* Not Found</Nav.Link>
          </Nav>
        </Navbar.Collapse>
      </Container>
    </Navbar>
  );
};

export default NavigationBar;
