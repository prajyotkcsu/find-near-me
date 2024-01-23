## Features:
Type something like
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

App returns
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
      },
      {
        "_index" : "restaurants",
        "_type" : "_doc",
        "_id" : "GxwRNI0Be1mGWNDd9nm5",
        "_score" : 2.3286238,
        "_source" : {
          "name" : "Smashburger (1425 E. Renner Rd.)",
          "category" : "American, Burgers",
          "full_address" : "1425 E. Renner Rd., Richardson, TX, 75082",
          "pin" : {
            "location" : {
              "lat" : 32.9978317,
              "lon" : -96.6976462
            }
          }
        }
      },
      {
        "_index" : "restaurants",
        "_type" : "_doc",
        "_id" : "YhwTNI0Be1mGWNDdB94Q",
        "_score" : 2.2925732,
        "_source" : {
          "name" : "Hootie's Burger Bar (720 Central Expressway)",
          "category" : "Burgers, American, Bar Food, Sandwiches, Burgers",
          "full_address" : "720 Central Expy, Plano, TX, 75074",
          "pin" : {
            "location" : {
              "lat" : 33.0104668,
              "lon" : -96.7066085
            }
          }
        }
      },
      {
        "_index" : "restaurants",
        "_type" : "_doc",
        "_id" : "hRwRNI0Be1mGWNDd9na5",
        "_score" : 2.1044445,
        "_source" : {
          "name" : "Good Union BBQ",
          "category" : "BBQ, American, Burgers",
          "full_address" : "1150 State St #150, Richardson, TX, 75082",
          "pin" : {
            "location" : {
              "lat" : 33.00099,
              "lon" : -96.70229
            }
          }
        }
      },
      {
        "_index" : "restaurants",
        "_type" : "_doc",
        "_id" : "jRwTNI0Be1mGWNDdB-QR",
        "_score" : 2.1044445,
        "_source" : {
          "name" : "Char'd: Southeast Asian Kitchen - Richardson TX",
          "category" : "BBQ, American, Burgers",
          "full_address" : "1251 State Street, Richardson, TX, 75082",
          "pin" : {
            "location" : {
              "lat" : 33.00162,
              "lon" : -96.70143
            }
          }
        }
      },
      {
        "_index" : "restaurants",
        "_type" : "_doc",
        "_id" : "xxwTNI0Be1mGWNDdB9gQ",
        "_score" : 1.9196389,
        "_source" : {
          "name" : "Hooters (N Central Expy E Plano Pkwy)",
          "category" : "American, Wings, Chicken, Burgers",
          "full_address" : "720 Central Expressway, Plano, TX, 75074",
          "pin" : {
            "location" : {
              "lat" : 33.0104668,
              "lon" : -96.7066085
            }
          }
        }
      },
      {
        "_index" : "restaurants",
        "_type" : "_doc",
        "_id" : "xRwRNI0Be1mGWNDd9na5",
        "_score" : 0.0,
        "_source" : {
          "name" : "Nestlé Toll House Café by Chip (1201 State St)",
          "category" : "Desserts",
          "full_address" : "1201 State St, Richardson, TX, 75082",
          "pin" : {
            "location" : {
              "lat" : 33.0018642,
              "lon" : -96.7019373
            }
          }
        }
      },
      {
        "_index" : "restaurants",
        "_type" : "_doc",
        "_id" : "4xwRNI0Be1mGWNDd9na5",
        "_score" : 0.0,
        "_source" : {
          "name" : "Good Union BBQ",
          "category" : "BBQ, Sandwich",
          "full_address" : "1150 State St, Richardson, TX, 75082",
          "pin" : {
            "location" : {
              "lat" : 33.0009142,
              "lon" : -96.7021589
            }
          }
        }
      },
      {
        "_index" : "restaurants",
        "_type" : "_doc",
        "_id" : "KBwRNI0Be1mGWNDd9ne5",
        "_score" : 0.0,
        "_source" : {
          "name" : "Genji Sushi (Cityline)",
          "category" : "Asian, Japanese, Healthy, Sushi",
          "full_address" : "1411 E. Renner Road, Richardson, TX, 75074",
          "pin" : {
            "location" : {
              "lat" : 32.99848,
              "lon" : -96.69809
            }
          }
        }
      },
      {
        "_index" : "restaurants",
        "_type" : "_doc",
        "_id" : "LxwRNI0Be1mGWNDd9ne5",
        "_score" : 0.0,
        "_source" : {
          "name" : "Pho is for Lovers",
          "category" : "Vietnamese, Asian, Rice &amp; Curry, Rolls",
          "full_address" : "1551 E Renner Rd, Richardson, TX, 75074",
          "pin" : {
            "location" : {
              "lat" : 32.9981283,
              "lon" : -96.6965416
            }
          }
        }
      }
    ]
  }
}

```

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

