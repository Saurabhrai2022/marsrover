package com.test.validations.definitions;

import com.test.marsrover.Rover;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class RoverTestStepDefinition {

    Rover rover;

    @Before
    public void setUp() {
        rover = new Rover();
        rover.setPosition(0, 0, 1);
    }

    @After
    public void teardown() {
        rover.setPosition(0, 0, 1);
    }

    @Given("Move Rover to Initial Location")
    public void move_rover_to_initial_location() {
        rover.setPosition(0, 0, 1);
    }

    @When("Rover Position is set as {string} {string} {string}")
    public void rover_position_is_set_as(String x_Coordinate, String y_Coordinate, String direction) {
        rover.setPosition(Integer.parseInt(x_Coordinate), Integer.parseInt(y_Coordinate), Integer.parseInt(direction));
    }

    @When("User validates the position of the Rover {string} {string} {string}")
    public void user_validates_the_position_of_the_rover(String x_Coordinate, String y_Coordinate, String direction) {
        char dir = 'N';

        switch (direction) {
            case "1": {
                dir = 'N';
                break;
            }
            case "2": {
                dir = 'E';
                break;
            }
            case "3": {
                dir = 'S';
                break;
            }
            case "4": {
                dir = 'W';
                break;
            }
        }

        String actPosition = rover.printPosition();
        String expPosition = x_Coordinate + " " + y_Coordinate + " " + dir;

        Assert.assertEquals(actPosition, expPosition);

    }

    @Then("Rover Moves as per the input {string}")
    public void rover_moves_as_per_the_input(String command) {
        rover.process(command);
    }


}
