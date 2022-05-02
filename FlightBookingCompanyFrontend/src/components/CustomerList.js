import React, { useState, useEffect } from "react";
import { Button, ButtonGroup, Container, Table } from "reactstrap";
import AppNavBar from "./AppNavBar";
import { Link } from "react-router-dom";

function CustomerList() {
  const [customers, setCustomers] = useState([]);

  // read all customers
  useEffect(() => {
    fetch("http://localhost:8080/customers", {
      method: "GET",
    })
      .then((response) => response.json())
      .then((data) => setCustomers(data));
  }, []);

  // delete customer
  const deleteCustomer = async (userName) => {
    await fetch(`http://localhost:8080/customers/${userName}`, {
      method: "DELETE",
    });
    setCustomers(
      [...customers].filter((customer) => customer.userName !== userName)
    );
  };

  const customerList = customers.map((customer) => {
    let dateObj = new Date(customer.dob);
    let dobFormatted =
      dateObj.getUTCFullYear() +
      "-" +
      (dateObj.getUTCMonth() + 1) +
      "-" +
      dateObj.getUTCDate();
    return (
      <tr key={customer.id}>
        <td>{customer.firstName}</td>
        <td>{customer.lastName}</td>
        <td>{customer.userName}</td>
        <td>{customer.email}</td>
        <td>{dobFormatted}</td>
        <td>{customer.flyerStatus}</td>
        <td>{customer.milesAccrued}</td>
        <td>
          <ButtonGroup>
            <Button
              size="sm"
              color="outline-primary"
              tag={Link}
              to={"/customers/password"}
            >
              Edit
            </Button>
            <Button
              size="sm"
              color="outline-danger"
              onClick={() => deleteCustomer(customer.userName)}
            >
              Delete
            </Button>
          </ButtonGroup>
        </td>
      </tr>
    );
  });

  return (
    <div className="normal-font">
      <AppNavBar />
      <Container>
        <div className="float-right">
          <Button color="outline-success" tag={Link} to="/customers/register">
            Add Customers
          </Button>
        </div>
        <h3>Customers</h3>
        <Table className="mt-4">
          <thead>
            <tr>
              <th width="10%">First Name</th>
              <th width="10%">Last Name</th>
              <th width="10%">User Name</th>
              <th width="10%">Email</th>
              <th width="10%">Birthday</th>
              <th width="10%">Flyer Status</th>
              <th width="10%">Miles Accrued</th>
              <th width="20%">Actions</th>
            </tr>
          </thead>
          <tbody>{customerList}</tbody>
        </Table>
      </Container>
    </div>
  );
}

export default CustomerList;
