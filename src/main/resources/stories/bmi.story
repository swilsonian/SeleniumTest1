Meta:

Narrative:
As a user
I should be able to Calculate my Body Mass Index

Scenario: scenario BMI
When I open BMI Calculator Home Page
And I enter height as <height>
And I enter weight as <weight>
And I click on the Calculate button
Then I should see bmi as <bmi>

Examples:
|height | weight | bmi |
| 1.8 | 80 | 24.691358024691358 |