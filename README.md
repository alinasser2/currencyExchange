# Currency Exchange Application

***This repository contains currency exchange application code
The application allows users to convert between different currencies using real-time exchange rates, allow users to mark specific currencies as their favorites for quick
access.***

For a demonstration of the swagger documentation, you can access it [here](https://currencyexchange-wbtr.onrender.com/swagger-ui/index.html).


# Services
The currency exchange application provides the following services:
**Currency Conversion**: 
 - Users can convert an amount from one currency to another.
 - They can specify the source currency, target currency, and the amount to be converted.
 - The application will fetch the latest exchange rate from the reliable API and perform the conversion.
 
**Historical Exchange Rates**:
 - Users can view historical exchange rates for a specific currency pair over a given time period.
 - They can specify the source and target currencies, as well as the start and end dates for which they want to see historical rates.
 
 **Exchange Rate Lookup**:
 
 - Users can look up the current exchange rate between two currencies.
 - They need to provide the source and target currencies, as the application will retrieve and display the latest exchange rate.

##  Rest API Success Responses

 

 1. Get  Latest Conversion Rates of Specific Currency
 **Request** https://currencyexchange-wbtr.onrender.com/latest/USD
 **Expected Response**
 ```
{
  "baseCode": "USD",
  "conversionRates": {
    "AED": "3.67250000",
    "JPY": "146.48797082",
    "EUR": "0.92552683",
    "QAR": "3.64000000",
    "GBP": "0.79453722",
    "OMR": "0.38449700",
    "SAR": "3.75000000",
    "USD": "1",
    "KWD": "0.30838425",
    "BHD": "0.37600000",
    "EGP": "30.83817498"
  }
}
```

 2. Convert Between Two Currencies **EGP** and **USD** And the Amount **100**
  **Request** https://currencyexchange-wbtr.onrender.com/pair/EGP/USD/100
   **Expected Response**
   ```
  {
  "conversionRate": "0.03246204",
  "conversionValue": "3.2462039999999996"
}
```

 3. Get Latest Conversion Rates of Specific Currency **USD** in Specific Date **2023/8/28**
 **Request** https://currencyexchange-wbtr.onrender.com/history/USD/2023/8/28
  **Expected Response**
  ```
{
  "baseCode": "USD",
  "conversionRates": {
    "AED": "3.67250000",
    "JPY": "146.48797082",
    "EUR": "0.92552683",
    "QAR": "3.64000000",
    "GBP": "0.79453722",
    "OMR": "0.38449700",
    "SAR": "3.75000000",
    "USD": "1",
    "KWD": "0.30838425",
    "BHD": "0.37600000",
    "EGP": "30.83817498"
  }
}
   ```
   

 4. Compare the Conversion Values For a Specific Currency **USD** And Two Other Currencies  **AED**  and **EGP** with specific amount **$50**
 **Request** https://currencyexchange-wbtr.onrender.com/compare/USD/AED/EGP/50
 **Expected Response**
 ```
{
  "firstConversionValue": "183.625",
  "secondConversionValue": "1541.9087490000002"
}
```

 5. Get Latest Exchange Rates of Specific Currency **USD** With Many other Currencies  **AED**,**EUR**,**EGP**,**GBP**
**Request**
https://currencyexchange-wbtr.onrender.com/rates?baseCode=USD&targets=AED%2CEUR%2CEGP%2CGBP
**Expected Response**
```
{
  "baseCurrency": "USD",
  "targets": [
    {
      "currency": "AED",
      "exchangeRate": "3.67250000",
      "flag": "https://www.countryflagicons.com/FLAT/64/AE.png"
    },
    {
      "currency": "EUR",
      "exchangeRate": "0.92552683",
      "flag": "https://www.countryflagicons.com/FLAT/64/EU.png"
    },
    {
      "currency": "EGP",
      "exchangeRate": "30.83817498",
      "flag": "https://www.countryflagicons.com/FLAT/64/EG.png"
    },
    {
      "currency": "GBP",
      "exchangeRate": "0.79453722",
      "flag": "https://www.countryflagicons.com/FLAT/64/GB.png"
    }
  ]
}
```
## Features

we have implemented a fully functional currency exchange application with all of the above services.
Here's an overview of what we have accomplished:

 - **Integration with Exchange Rate API**:
 We have integrated our application with a reliable Exchange Rate API to fetch real-time exchange rates.
This ensures that our conversion and services provide accurate results based on current market rates.
 - **Error Handling**:
 We have incorporated error handling mechanisms throughout our codebase to gracefully handle any unexpected errors or exceptions that may occur during runtime.
***Error 400 if the wrong currency was entered**
**Request**  https://currencyexchange-wbtr.onrender.com/latest/USU
**Expected Response**
```      
{
  "statusCode": 400,
  "message": "Invalid currency "
}        
```
***Error 400 if negative or zero amount was entered** 
**Request**  https://currencyexchange-wbtr.onrender.com/pair/EGP/USD/-100
**Expected Response**
```
{
  "statusCode": 400,
  "message": "Amount must be positive number."
}
```
***Error 400 if invalid date was entered** 
**Request**  https://currencyexchange-wbtr.onrender.com/history/USD/2023/8/55
**Expected Response**
```
{
  "statusCode": 400,
  "message": "Invalid date"
}
```
   
 - **Testing**
 We have written comprehensive unit tests to ensure the correctness and reliability of our application.
These tests cover various scenarios and edge cases to validate the behavior of our services.
 - **Logger**:
 The logger feature in this project allows you to log important information, warnings, and errors during the execution of the code.
It helps in debugging and monitoring the application.
 - **Actuator**:
 The actuator feature in this project provides endpoints to monitor and manage the application.
 - **Caching**:
 special caching for application as first minute of every hour, it clears the old caching and makes a new caching,
 which will make the app always up to date
- **API Documentation**:
 We've integrated Swagger into our Spring Boot application to provide interactive API documentation.
 This allows you to easily explore and understand the endpoints, request/response formats, and more.

## Getting Started
To get started with the currency exchange application, follow these steps:
1. Clone this repository to your local machine.
2. Install any necessary dependencies.
3. Access the application through your web browser at `https://currencyexchange-wbtr.onrender.com/swagger-ui/index.html`.


## Contributing

We welcome contributions from anyone interested in improving this currency exchange application.
If you find any bugs, have suggestions for new features, or want to contribute code enhancements, please feel free to submit a pull request.


**Thanks .. 
BackEnd Team :)**
