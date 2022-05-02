import React, { useState } from "react";
import { Button, Form, Row, Col } from "react-bootstrap";
import { useNavigate } from "react-router-dom";
import AppNavBar from "./AppNavBar";

function RegisterForm() {
  let navigate = useNavigate();
  const [customerFields, setCustomerFields] = useState({
    firstName: "",
    lastName: "",
    userName: "",
    password: "",
    email: "",
    dob: "",
  });

  const handleSubmit = (event) => {
    event.preventDefault();
    console.log("create new customer");
    createCustomer(customerFields);
    setCustomerFields({
      firstName: "",
      lastName: "",
      userName: "",
      password: "",
      email: "",
      dob: "",
    });
    navigate("/");
  };

  const handleChange = (event) => {
    setCustomerFields({
      ...customerFields,
      [event.target.name]: event.target.value,
    });
  };

  // create customer
  const createCustomer = async (props) => {
    await fetch("http://localhost:8080/customers", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({
        firstName: props.firstName,
        lastName: props.lastName,
        userName: props.userName,
        employee: false,
        password: props.password,
        email: props.email,
        dob: new Date(props.dob),
        flyerStatus: "GENERAL",
        milesAccrued: 0,
        companions: [],
      }),
    });
  };

  return (
    <div>
      <AppNavBar />
      <h4 align="center">Enter Your Information</h4>
      <div align="center">
        <Form className="form-width">
          <Form.Group as={Row} className="mb-3" onChange={handleChange}>
            <Form.Label column sm="2">
              First Name
            </Form.Label>
            <Col sm="10">
              <Form.Control
                type="text"
                placeholder="Enter first name"
                name="firstName"
              />
            </Col>
          </Form.Group>
          <Form.Group as={Row} className="mb-3" onChange={handleChange}>
            <Form.Label column sm="2">
              Last Name
            </Form.Label>
            <Col sm="10">
              <Form.Control
                type="text"
                placeholder="Enter last name"
                name="lastName"
              />
            </Col>
          </Form.Group>
          <Form.Group as={Row} className="mb-3" onChange={handleChange}>
            <Form.Label column sm="2">
              Username
            </Form.Label>
            <Col sm="10">
              <Form.Control
                type="text"
                placeholder="Enter username"
                name="userName"
              />
            </Col>
          </Form.Group>
          <Form.Group as={Row} className="mb-3" onChange={handleChange}>
            <Form.Label column sm="2">
              Password
            </Form.Label>
            <Col sm="10">
              <Form.Control
                type="password"
                placeholder="Enter password"
                name="password"
              />
            </Col>
          </Form.Group>
          <Form.Group as={Row} className="mb-3" onChange={handleChange}>
            <Form.Label column sm="2">
              Email
            </Form.Label>
            <Col sm="10">
              <Form.Control
                type="text"
                placeholder="Enter email"
                name="email"
              />
            </Col>
            <Form.Text className="text-muted">
              We'll never share your email with anyone else.
            </Form.Text>
          </Form.Group>
          <Form.Group as={Row} className="mb-3" onChange={handleChange}>
            <Form.Label column sm="2">
              Date of Birth
            </Form.Label>
            <Col sm="10">
              <Form.Control type="text" placeholder="YYYY-mm-DD" name="dob" />
            </Col>
          </Form.Group>
          <Button
            variant="outline-success"
            type="submit"
            onClick={handleSubmit}
          >
            Register
          </Button>
        </Form>
      </div>
    </div>
  );
}

export default RegisterForm;
