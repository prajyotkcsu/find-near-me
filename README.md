# Find near me           

## Overview
Restaurant-recommendation system(helps you find nearest restaurant based on fine grained specifications like [user query: Check for a place that serves butter chicken, has 5-star ratings, and has been eaten at by at least 10 of my friends)
      🍕🌏 this project demonstrates the power of Elasticsearch, and how indexing and querying works.
Sample Request Body:
{"query":"food near me"}

Sample Response Body:
{[storeId: "123xyz", "store_meta:{
"store_name":"wholefoods",
"location":"",
"product": ["food","meat,"snacks","flowers","cake"]
}],
[storeId: "124xyz", "store_meta:{
"store_name":"bharat bazaar",
"location":"",
"product": ["food","vegetables","india grocery"]
}]
}


Sample Request Body:
{"query":"indian food near me"}

Sample Response Body:
{
[storeId: "124xyz", "store_meta:{
"store_name":"bharat bazaar",
"location":"",
"product": ["food","vegetables","india grocery"]
}]
}






## How it is done.
Postman acts like the frontend for the APIs
1) Send request to the app on localhost:8084/whishlist as,
   {
wishlist:["cycling","taking a walk","calling mom tonight", "putting trash out", "commit code on git","going to the bank", "calling amazon customer service for a refund"]
   }
3) App utilizes OpenAI API https://api.openai.com/v1/chat/completions. API transforms your wishlist into actionable tasks and puts them into categories. Majorly four, Fitness, Social, Work, Responsibility, Self-dev. Example as shown below,
   1) Cycling: Fitness,
   2) Taking a walk: Fitness,
   3) Calling mom: Social,
   4) Commit code: Work,
   5) Going to the bank: Responsibility,
   6) Calling Amazon for refund: Self-help
   
4) Further, upon receiving this as a response from the AI, app sends the curation to the Kafka server, and appends partitions with values. Here, Kafka has a topic: "assist-topic", with 5 partitions each dedicated for five separate categories of tasks.
5) Until now Kafka producer is doing its part. As soon as user takes a break, an API triggers the application at localhost:8084/tasks
6) The application now fetches List<Tasks> from the Kafka topic. It constructs the list as list of tasks from each partition/category based on the break duration. Say calling a friend would need 10 min+ taking a walk would require 5 min and both can be done together. These kind of logic are built using OpenAI API. The core of this project is storing key value in Kafka, and logically presenting tasks from each partition and adjusting the offset pointer.

## Features
- **Smart Task Reminders**: Rather than overwhelming you with a list of all remaining tasks, RemindGPT intelligently considers the time you have before your break. It prompts you to input the available time, and then suggests tasks that can be achieved within that timeframe.

- **Personalized Assistance**: Think of RemindGPT as your friend. It assists you in making the most out of your break time by recommending tasks that align with the time you have available.

## Getting Started
To start using RemindGPT, follow these simple steps:
1. [Installation](#installation): Instructions on how to install and set up RemindGPT.
2. [Usage](#usage): A guide on how to use the application and take advantage of its features.

## Installation
1. Clone the repository: `git clone https://github.com/your-username/RemindGPT.git`
2. Navigate to the project directory: `cd RemindGPT`
3. Use docker file to run project with its dependencies

## Usage
1. Launch the application.
2. Enter your wishlist for the day.
3. When prompted, input the time you have for your break.
4. Receive personalized task recommendations.
5. Enjoy a productive break with RemindGPT's assistance.

## Contributing

