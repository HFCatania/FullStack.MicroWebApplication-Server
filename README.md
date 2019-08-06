[Link to Angular App Repo](https://github.com/calebPowell-oak/moneymanager)

# Micro Web Application - Server

## Group 6 - Team Beansbeans

* **Objective** - to create an implementation of a small web service
* **Purpose** - to demonstrate the construction of a full-stacked web-application

## Mission

Provide an account management system that layers onto an existing financial account to provide useful services for organizing and allocating funds for multiple purposes.

### Current Tech Stack
* **Frontend** - Angular / React
* **Business Logic** - Java (Spring)
* **Data Layer** - MySQL
* **Cloud** - AWS/Heroku

<hr>

### Money Management Application

#### Features
* Users can login and create new user accounts.
* Users, once logged in may
	* Create a transaction account
	* Delete an owned transaciton account
	* Deposit into an owned transaction account
	* Withdraw from an owned transaction account
	* Transfer money to any existing account from an owned account
	* Log off
<hr>

#### Running this Project
* Clone this repo as well as the one listed at this link: [Link to Angular App Repo](https://github.com/calebPowell-oak/moneymanager)
* Initialize a docker mySQL container on port 3306.
* run `npm install` in the angular app root directory.
* Start Spring Appliaction
* run `ng serve --open` in angular app root directory.
	* `--open` will open the app's webpage in the default browser once it finished compiling.
