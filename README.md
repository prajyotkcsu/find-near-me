## Features:
Type something like
   ```
   butter chicken place in Richardson, TX
   ```
App returns
```
{
   "name":"",
   "location":""
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

