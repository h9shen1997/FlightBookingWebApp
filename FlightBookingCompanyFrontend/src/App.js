import logo from "./logo.svg";
import "./App.css";
import "bootstrap/dist/css/bootstrap.min.css";
import Home from "./components/Home";
import { Routes, Route } from "react-router-dom";
import CustomerList from "./components/CustomerList";
import ResgiterForm from "./components/RegisterForm";
import PasswordUpdate from "./components/PasswordUpdate";
import React, { Component } from "react";
import SearchResult from "./components/SearchResult";
function App() {
  return (
    <Routes>
      <Route exact path="/" element={<Home />} />
      <Route exact path="/customers" element={<CustomerList />} />
      <Route exact path="/customers/register" element={<ResgiterForm />} />
      <Route exact path="/customers/password" element={<PasswordUpdate />} />
      <Route
        exact
        path="/searchresult/:departure/:arrival"
        element={<SearchResult />}
      />
    </Routes>
  );
}

export default App;
