import React from "react";
import { Navbar, Nav, Button, ButtonGroup, Container } from "react-bootstrap";

function AppNavBar() {
  return (
    <Navbar bg="light" expand="lg" className="normal-font">
      <Container>
        <Navbar.Brand className="app-brand" href="/">
          Cheapfare Booking
        </Navbar.Brand>
        <Navbar.Toggle aria-controls="basic-navbar-nav" />
        <Navbar.Collapse id="basic-navbar-nav">
          <Nav className="ms-auto">
            <ButtonGroup>
              <Button variant="outline-info" className="button-font">
                Log In
              </Button>
              <Button
                variant="outline-info"
                href="/customers/register"
                className="button-font"
              >
                Register
              </Button>
            </ButtonGroup>
          </Nav>
        </Navbar.Collapse>
      </Container>
    </Navbar>
  );
}

export default AppNavBar;
