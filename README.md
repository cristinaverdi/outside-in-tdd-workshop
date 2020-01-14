# Outside-in TDD workshop


Durante el sprint actual, tienes que desarrollar una feature que permita a un usuario cancelar una reserva.
```
Scenario: As a user I want to successfully cancel a specific booking. I can have more than one bookings

Given a booking Id 1929
And a  valid authorization token  AAAAAAAAAAAAAAAAAAAAAMLheAAAAAAA-1%2BuSeid%2BULvsea4JtiGRiSDSJSI%3DEUifiRBkKG5E2XzMDjRfl76ZC9Ub0wnz4XsNiRVBChTYbJcE3F


When performing an http request to /api/v0/bookings/{id}
And with request headers
{
Authorization: “Bearer AAAAAAAAAAAAAAAAAAAAAMLheAAAAAAA-1%2BuSeid%2BULvsea4JtiGRiSDSJSI%3DEUifiRBkKG5E2XzMDjRfl76ZC9Ub0wnz4XsNiRVBChTYbJcE3F”
}

Then respond with response status 200
```