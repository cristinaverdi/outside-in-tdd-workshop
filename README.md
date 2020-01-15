# Outside-in TDD workshop
During this live coding session Cristina and I will present Outside-in TDD implementing an end-to-end feature with Kotlin.

This is the part 2 of a 2 sessions workshop about Outside-in TDD. By the end of this session you will be able to test drive a simple end-to-end feature that fits into a defined architectural style.

##### Prerequisites

* Install SDKMAN: `https://sdkman.io/install`
* Install OpenJDK 11: 
```bash
sdk install java 11.0.5-open
sdk use java 11.0.5-open
```
Alternatively install
```bash
sdk install java 11.0.5-zulu
sdk use java 11.0.5-zulu
```

* Install Gradle: `sdk install gradle`
* Install IntelliJ IDEA (Community Edition): `https://www.jetbrains.com/idea/download/`

##### Exercise

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