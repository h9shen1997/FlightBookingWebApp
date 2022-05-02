import React, { useState, useEffect } from "react";
import AppNavBar from "./AppNavBar";
import { useParams } from "react-router-dom";
import { Card, Form, Button } from "react-bootstrap";
import { propTypes } from "react-bootstrap/esm/Image";

function SearchResult() {
  const [results, setResults] = useState([]);
  const [checkedState, setCheckedState] = useState([true, true, true]);
  const { departure, arrival } = useParams();

  useEffect(() => {
    fetch(`http://localhost:8080/recommendation/${departure}/${arrival}`, {
      method: "GET",
    })
      .then((response) => response.json())
      .then((data) => {
        setResults(data);
      });
  }, []);

  const onChangeNonStop = () => {
    setCheckedState(([x, y, z]) => [!x, y, z]);
  };
  const onChangeOneStop = () => {
    setCheckedState(([x, y, z]) => [x, !y, z]);
  };
  const onChangeTwoMoreStops = () => {
    setCheckedState(([x, y, z]) => [x, y, !z]);
  };

  const addToReservation = (props) => {
    fetch("http://localhost:8080/trips", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({
        duration: props.duration,
        totalMiles: props.totalMiles,
        totalCost: props.totalCost,
        flights: props.flights,
      }),
    })
      .then((response) => response.json())
      .then((responseData) => {
        fetch("http://localhost:8080/reservations/BASIC", {
          method: "POST",
          headers: { "Content-Type": "application/json" },
          body: JSON.stringify({
            id: responseData.id,
            duration: responseData.duration,
            totalMiles: responseData.totalMiles,
            totalCost: responseData.totalCost,
            flights: responseData.flights,
          }),
        });
      });
    alert("successfully booked your trip!");
  };

  const filteredResults = results.filter((result) => {
    const stops = result.flights.length;
    const [x, y, z] = checkedState;
    if (stops === 1 && x) {
      return true;
    }
    if (stops === 2 && y) {
      return true;
    }
    if (stops >= 3 && z) {
      return true;
    }
    return false;
  });

  return (
    <div className="normal-font">
      <AppNavBar />
      <div className="flexbox-container">
        <div className="side-bar-view m-3">
          <Form>
            <Form.Group>
              <Form.Check
                name="non-stop"
                id="0"
                type="checkbox"
                label="non-stop"
                onChange={onChangeNonStop}
                checked={checkedState[0]}
              />
              <Form.Check
                name="1 stop"
                id="1"
                type="checkbox"
                label="1 stop"
                onChange={onChangeOneStop}
                checked={checkedState[1]}
              />
              <Form.Check
                name="2+ stops"
                id="2"
                type="checkbox"
                label="2+ stops"
                onChange={onChangeTwoMoreStops}
                checked={checkedState[2]}
              />
            </Form.Group>
          </Form>
        </div>
        <div>
          {filteredResults.map((route, i) => (
            <Card
              key={i}
              style={{ width: "60vw" }}
              bg="light"
              text="dark"
              className="m-3 flexbox-container"
            >
              <Card.Body>
                {route.flights.map((flight, j) => {
                  let departureTime = new Date(flight.departureTime);
                  let arrivalTime = new Date(flight.arrivalTime);
                  let departureTimeFormatted;
                  if (departureTime.getHours() < 12) {
                    departureTimeFormatted =
                      String(departureTime.getHours()).padStart(2, "0") +
                      ":" +
                      String(departureTime.getMinutes()).padStart(2, "0") +
                      "am";
                  } else if (departureTime.getHours() === 12) {
                    departureTimeFormatted =
                      String(departureTime.getHours()).padStart(2, "0") +
                      ":" +
                      String(departureTime.getMinutes()).padStart(2, "0") +
                      "pm";
                  } else {
                    departureTimeFormatted =
                      String(departureTime.getHours() % 12).padStart(2, "0") +
                      ":" +
                      String(departureTime.getMinutes()).padStart(2, "0") +
                      "pm";
                  }
                  let arrivalTimeFormatted;
                  if (arrivalTime.getHours() < 12) {
                    arrivalTimeFormatted =
                      String(arrivalTime.getHours()).padStart(2, "0") +
                      ":" +
                      String(arrivalTime.getMinutes()).padStart(2, "0") +
                      "am";
                  } else if (arrivalTime.getHours() === 12) {
                    arrivalTimeFormatted =
                      String(arrivalTime.getHours()).padStart(2, "0") +
                      ":" +
                      String(arrivalTime.getMinutes()).padStart(2, "0") +
                      "pm";
                  } else {
                    arrivalTimeFormatted =
                      String(arrivalTime.getHours() % 12).padStart(2, "0") +
                      ":" +
                      String(arrivalTime.getMinutes()).padStart(2, "0") +
                      "pm";
                  }
                  return (
                    <Card key={j}>
                      <Card.Body>
                        <div>
                          Departure: {departureTimeFormatted} {"→"} Arrival:{" "}
                          {arrivalTimeFormatted}
                        </div>
                        <div>
                          {flight.departureAirport} {"→"}{" "}
                          {flight.arrivalAirport}
                        </div>
                        <div>{flight.airline}</div>
                      </Card.Body>
                    </Card>
                  );
                })}
                <div>${route.totalCost} per traveler</div>
              </Card.Body>
              <Button
                variant="outline-warning"
                onClick={() => addToReservation(route)}
              >
                Book
              </Button>
            </Card>
          ))}
        </div>
      </div>
    </div>
  );
}

export default SearchResult;
