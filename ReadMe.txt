<<<<-----StockEurekaServer----->>>>
This project contains the EurekaServer

<<<<-----ZuulServer----->>>>
This project contains the ZuulServer

<<<<-----StockMarketUser----->>>>
This project contains the functionality which are required for the User like the user login, signup

<<<<-----Company----->>>>
This project contains the functionality which are required for the Admin like adding Ipo, Company Details, listing the companies etc.

<<<<-----Steps to Run the project----->>>>
1. Run the stockEurekaServer
2. Run the ZuulServer
3. Run the StockMarketUser
4. Run the Company
5. Call the microservices through the zuul gateway (e.g: "localhost:8090/stock-market-user/company" where stock-market-user calls the company microservice through zuul gateway which is running on localhost:8090)
6. Hit the localhost for the required functionality