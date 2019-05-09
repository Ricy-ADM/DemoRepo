Feature: e.ggtime coundown check

Scenario Outline: Verify countdown timer for e.ggtime
	Given User navigates to "url"
	When Enters "time" as "<time>"
	And Clicks on "Go" button
	Then Counter should start and decriment per second on page
	Examples:
	|time                       |time2                           |
	|25 seconds                 |25 							 |