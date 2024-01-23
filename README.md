## Project motivation

This project is driven by the objective of seamlessly querying and retrieving information about restaurants that cater to specific culinary preferences. <br> 
Utilizing Elasticsearch's indexing power, the system efficiently organizes and retrieves relevant information based on specific criteria.
## Features:

#### Type something like
   ```
   noodles place near me
   ```

The app runs a query similar to the below one,
```
GET /restaurants/_search
{
  "query": {
    "bool": {
      "should": [
        {
          "match": {
            "category": "noodles"
          }
        },
        {
          "match": {
            "category": "burgers"
          }
        }
      ],
      "filter": [{
        "geo_distance": {
          "distance": "1km", 
          "pin.location": {
            "lat": 33.00165594272553,
            "lon": -96.70513953195999
          }
        }
      }]
    }
  }
}
```
Here, lat and lon values are taken from google maps coordinates

#### App returns
```
{
  "took" : 1087,
  "timed_out" : false,
  "_shards" : {
    "total" : 1,
    "successful" : 1,
    "skipped" : 0,
    "failed" : 0
  },
  "hits" : {
    "total" : {
      "value" : 33,
      "relation" : "eq"
    },
    "max_score" : 4.2395544,
    "hits" : [
      {
        "_index" : "restaurants",
        "_type" : "_doc",
        "_id" : "RBwRNI0Be1mGWNDd9nm5",
        "_score" : 4.2395544,
        "_source" : {
          "name" : "Sticky Rice - Richardson",
          "category" : "Thai, Asian, Noodles",
          "full_address" : "120 W. CityLine Drive, #500, Richardson, TX, 75074",
          "pin" : {
            "location" : {
              "lat" : 33.002223,
              "lon" : -96.705388
            }
          }
        }
      }
    ]
  }
}

```
#### fun fact: Sticky Rice is located inside our building, merely 200 ft away. 

## Installation:
Use docker container of Elastic, Logstash, Kibana at```src/main/resources/docker-compose.yml```

## Indexing dataset

#### Transform dataset into elasticsearch accepted json format
```
{"index": {}}
{"id": 1, "position": 19, "name": "PJ Fresh (224 Daniel Payne Drive)", "score": "", "ratings": "", "category": "Burgers, American, Sandwiches", "price_range": "$", "full_address": "224 Daniel Payne Drive, Birmingham, AL, 35207", "zip_code": 35207, "lat": 33.5623653, "lng": -86.8307025}
{"index": {}}
{"id": 2, "position": 9, "name": "J' ti`'z Smoothie-N-Coffee Bar", "score": "", "ratings": "", "category": "Coffee and Tea, Breakfast and Brunch, Bubble Tea", "price_range": "", "full_address": "1521 Pinson Valley Parkway, Birmingham, AL, 35217", "zip_code": 35217, "lat": 33.58364, "lng": -86.77333}
{"index": {}}
{"id": 3, "position": 6, "name": "Philly Fresh Cheesesteaks (541-B Graymont Ave)", "score": "", "ratings": "", "category": "American, Cheesesteak, Sandwiches, Alcohol", "price_range": "$", "full_address": "541-B Graymont Ave, Birmingham, AL, 35204", "zip_code": 35204, "lat": 33.5098, "lng": -86.85464}
```
#### Create 'restaurants' index
Create 'restaurants' index
``` curl -XPUT "http://localhost:9200/restaurants" ```

#### List indices
``` curl -XGET "http://localhost:9200/_cat/indices" ```
 
![image](https://github.com/prajyotkcsu/find-near-me/assets/154280801/8202976e-fa6f-4829-a80f-fe71236e15e3)

#### Using elastic's bulk api to populate elastic cluster with json data
``` curl -s -H "Content-Type: application/json" -XPOST "http://localhost:9200/restaurants/_bulk" --data-binary "@restaurant.json" ```

