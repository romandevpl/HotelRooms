# Task description

Build a room occupancy optimization tool for one of our hotel clients! Our customer has a
certain number of free rooms each night, as well as potential guests that would like to book a
room for that night.

Our hotel clients have two different categories of rooms: Premium and Economy. Our hotels
want their customers to be satisfied: they will not book a customer willing to pay over EUR
100 for the night into an Economy room. But they will book lower paying customers into
Premium rooms if these rooms would be empty and all Economy rooms will be filled by low
paying customers. Highest paying customers below EUR 100 will get preference for the
“upgrade”. Customers always only have one specific price they are willing to pay for the
night.

Please build a small API that provides an interface for hotels to enter the numbers of
Premium and Economy rooms that are available for the night and then tells them
immediately how many rooms of each category will be occupied and how much money they
will make in total. Potential guests are represented by an array of numbers that is their
willingness to pay for the night.

Use the following raw json file as mock data for potential guests in your tests (include the
downloaded file in the project or get and parse it from the github directly)
# Getting Started

### Reference Documentation

To run the project with tests :

`./mvnw clean package`

### API example

#### Request : 

`POST http://localhost:8080/roomsUsage`

`Content-Type: application/json`

`{"freePremiumRooms": 3, "freeEconomyRooms" : 3}`

#### Response: 

`HTTP/1.1 200`

`Content-Type: application/json`

`{
"usagePremium": 3,
"usageEconomy": 3,
"premiumRoomsTotalPrice": 738,
"economyRoomsTotalPrice": 167
}`
