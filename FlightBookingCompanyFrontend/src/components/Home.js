import React, { useState } from "react";
import AppNavBar from "./AppNavBar";
import "../Home.css";
import { DropdownButton, Button, Dropdown } from "react-bootstrap";
import { useNavigate } from "react-router-dom";

function Home() {
  let navigate = useNavigate();
  const airports = [
    "ATL",
    "BOS",
    "DCA",
    "DEN",
    "HNL",
    "HOU",
    "JFK",
    "LAX",
    "MIA",
    "ORD",
    "SAN",
    "SEA",
    "SFO",
  ];
  const [departure, setDeparture] = useState("Departure");
  const [arrival, setArrival] = useState("Arrival");

  const handleDepartureSelect = (e) => {
    setDeparture(e.target.textContent);
  };

  const handleArrivalSelect = (e) => {
    setArrival(e.target.textContent);
  };

  const handleSearch = (departureAirport, arrivalAirport) => {
    if (departureAirport === "Departure" || arrivalAirport === "Arrival") {
      alert("You must select departure and arrival before searching!");
      return;
    }
    //let props = { departure: departureAirport, arrival: arrivalAirport };
    navigate(`/searchresult/${departure}/${arrival}`);
  };

  return (
    <div className="background">
      <AppNavBar />
      <div className="normal-font">
        <div className="flexbox-container home-button">
          <DropdownButton title={departure} className="dropdown-button">
            {[...airports].map((airport, index) => (
              <Dropdown.Item key={index} onClick={handleDepartureSelect}>
                {airport}
              </Dropdown.Item>
            ))}
          </DropdownButton>
          <DropdownButton title={arrival} className="dropdown-button">
            {[...airports].map((airport, index) => (
              <Dropdown.Item key={index} onClick={handleArrivalSelect}>
                {airport}
              </Dropdown.Item>
            ))}
          </DropdownButton>
          <Button
            variant="warning"
            className="dropdown-button"
            onClick={() => handleSearch(departure, arrival)}
          >
            Search
          </Button>
        </div>
      </div>
    </div>
  );
}

export default Home;
