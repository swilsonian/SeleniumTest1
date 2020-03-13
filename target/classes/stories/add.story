Meta:

Narrative:
As a user
I want to perform a math op
So that I can get the result of an op for two numbers

Scenario: scenario Addition
Given a adder website
When I give the first number as <number1>
And I give the second number as <number2>
And I click on the Click button
Then I should get the result as <result>

Examples:
| number1 | number2 | result |
| 3 | 9 | 12 |
