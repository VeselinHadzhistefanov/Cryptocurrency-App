package com.example.cryptocurrencylist

data class CryptoCurrency(

    var image: String, //(30% width and height on top left of screen)

    var name:  String,  //Name (capital first letter only and bold text, top of screen and to right of logo)

    var symbol: String,  //Symbol (capital letters, under the name and to right of logo)

    var current_price: Float,   //Price

    var market_cap : Float,  //Market cap (left-aligned)

    var high_24h : Float,       //Highest value for last 24 h (left-aligned, “high_24h”)

    var price_change_24h: Float,        //Percentage price change for last 24h (right-aligned, “price_change_percentage_24h”, green text if positive, red text if negative)

    var market_cap_change_percentage_24h: Float,     //Percentage market cap change for last 24h (right-aligned, “market_cap_change_percentage_24h”, green text if positive, red text if negative)

    var low_24h: Float      //Lowest value for last 24 h (right-aligned, “low_24h”)
)
