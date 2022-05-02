import React, { useState } from "react";
import { Button, Container, Form, FormGroup } from "reactstrap";
import { useNavigate } from "react-router-dom";
import AppNavBar from "./AppNavBar";

function PasswordUpdate() {
  let navigate = useNavigate();

  const [passwordFields, setPasswordFields] = useState({
    userName: "",
    password: "",
  });

  const handleSubmit = (event) => {
    event.preventDefault();
    console.log("create new customer");
    if (passwordFields.password !== "") {
      updatePassword(passwordFields.userName, passwordFields.password);
      setPasswordFields({
        userName: "",
        password: "",
      });
      console.log("update password");
    } else {
      console.log("password can't be empty, nothing changed");
    }
    navigate("/customers");
  };

  const handleChange = (event) => {
    setPasswordFields({
      ...passwordFields,
      [event.target.name]: event.target.value,
    });
  };

  // update customer (only password can be updated)
  const updatePassword = async (username, password) => {
    await fetch(`http://localhost:8080/customers/${username}/${password}`, {
      method: "PUT",
    });
  };

  return (
    <div className="normal-font">
      <AppNavBar />
      <Container>
        <h3 align="center">Update Your Password</h3>
        <form onSubmit={handleSubmit}>
          <table align="center">
            <tr>
              <td>
                <label htmlFor="userName">Username</label>
              </td>
              <td>
                <input type="text" name="userName" onChange={handleChange} />
              </td>
            </tr>

            <tr>
              <td>
                <label htmlFor="password">New Password</label>
              </td>
              <td>
                <input type="text" name="password" onChange={handleChange} />
              </td>
            </tr>
            <tr>
              <td>
                <Button
                  color="outline-success"
                  type="submit"
                  onClick={handleSubmit}
                >
                  Update
                </Button>
              </td>
            </tr>
          </table>
        </form>
      </Container>
    </div>
  );
}

export default PasswordUpdate;
