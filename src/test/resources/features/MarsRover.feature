Feature: Validate Rover Movement

  @SmokeTest
  Scenario Outline: Validate Rover Position Setting
    Given Move Rover to Initial Location
    When Rover Position is set as "<X_Coordinate>" "<Y_Coordinate>" "<Direction>"
    And User validates the position of the Rover "<X_Coordinate>" "<Y_Coordinate>" "<Direction>"

    Examples:
      | X_Coordinate | Y_Coordinate | Direction |
      | 0            | 0            | 1         |
      | 0            | 0            | 2         |
      | 0            | 0            | 3         |
      | 0            | 0            | 4         |
      | 1            | 1            | 1         |
      | 2            | 3            | 2         |
      | 3            | 5            | 3         |
      | -5           | -10          | 4         |
      | -5           | -8           | 1         |
      | 6            | 9            | 2         |
      | 7            | 10           | 3         |
      | -8           | -15          | 4         |

  @SmokeTest
  Scenario Outline: Validate Rover Move Action
    Given Move Rover to Initial Location
    When Rover Position is set as "<X_Coordinate>" "<Y_Coordinate>" "<Direction>"
    Then Rover Moves as per the input "<Command>"
    And User validates the position of the Rover "<X_CoordinateDest>" "<Y_CoordinateDest>" "<DirectionDest>"

    Examples:
      | X_Coordinate | Y_Coordinate | Direction | Command   | X_CoordinateDest | Y_CoordinateDest | DirectionDest |
      | 0            | 0            | 1         | LMLMLMLMM | 0                | 1                | 1             |
      | 0            | 0            | 2         | LMLMLMLMM | 1                | 0                | 2             |
      | 0            | 1            | 3         | LMLMLLLMM | 3                | 2                | 2             |
      | 1            | 0            | 4         | LMLMLRLMM | 2                | 1                | 1             |
      | 1            | 0            | 4         | LMLMLLLMM | 2                | -3               | 3             |
      | 0            | -1           | 4         | LMLMLLLMM | 1                | -4               | 3             |
