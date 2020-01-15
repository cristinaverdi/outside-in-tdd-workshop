# Outside-in TDD workshop
Imagine that your team is developing a carsharing app. During the Sprint you need to implement the folloing feature:

Scenario: As a user I want to successfully cancel a specific booking. I can have more than one booking

The Acceptance Criteria is:
```
Given a booking with ID 1230
And an endpoint

 /api/v1/bookings/{id}

When receiving an http PUT request

Then perform booking cancellation
And respond with status code 200
```