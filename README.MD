# comic-api
XKCD and Poorly Draw Lines consumer API 

## Summary

API to retrieve comics from XKCD and Poorly Draw Lines. It will return the latest 20 comics from both sites sorted by publish date.

Tech backgroung: Java application running with Spark Java. It's using Java 11 and Maven for build.

## How to run

To build and run the application please perform the following step. (Docker is required)

```shell script
docker-compose up
```


## Endpoint

To retrieve the comics from the repository, please hit the url
```
http://localhost:8080/retrieve
```

## API Response
Sample response for application:

```
[
  {
    "pictureURL":"https://imgs.xkcd.com/comics/prediction.png",
    "title":"Prediction",
    "browserURL":"https://xkcd.com/2370",
    "publishingDate":"2020-10-09"
  },
  {
    "pictureURL":"http://feedproxy.google.com/~r/PoorlyDrawnLines/~3/EKcE_QiSL8U/",
    "title":"Listen to Me",
    "browserURL":"http://www.poorlydrawnlines.com/?p=7793",
    "publishingDate":"2020-10-07"
  }
 ]
```


## Pending

List of items to be done in the future.

* Mock apis
* Add properties file and remove URL's and others parameters that are currently hard-coded.
* Fix Github Action 
* Add log


## Requirements (by Company)

There is a publicly available API for the webcomic XKCD – [https://xkcd.com/json.html](https://xkcd.com/json.html)

And an RSS feed for PDL: [http://feeds.feedburner.com/PoorlyDrawnLines](http://feeds.feedburner.com/PoorlyDrawnLines)

Create a RESTful service that pulls last 10 strips from each and combines them in a single json feed (20 recent entries in total). The response should contain the following data for each entry:

- picture url
- title / description
- web url for browser view
- publishing date

Sort the resulting feed by publishing date from recent to older.

* Build & Run

The solution should contain a docker-compose configuration to build and run it at [http://localhost:8080](http://localhost:8080) 

* Assessment

We have the following expectations towards your solution.

- It should work
- It is readable and comprehensible
- The code is structured reasonably and the architecture can be justified
- It has tests


* Publication

The solution sources should be hosted on github. Preferably the commit history should represent your iterative process.

* Finally

Please don't spend more than a couple of hours on this. We don't expect the solution to be perfect or surprisingly original. We expect it to work.


