# comic-api
XKCD and Poorly Draw Lines consumer API 

## Index

- [Summary](#summary-)
- [How to run](#how to run-)
- [Endpoint](#endpoint-)
- [Pending](#pending-)
- [Requirements](#requirements-)

## Summary

API to retrieve comics from XKCD and Poorly Draw Lines. It will return the latest 20 comics from both sites sorted by publish date.

Tech Stuff:Java application running with Spark Java. It's using Java 11 and Maven for build.

## How to run

To build and run the application please perform the following steps. Note, Docker is required.

```shell script
docker-compose build
```

```shell script
docker-compose up
```

## Endpoint

To retrieve the comics from the repository, please hit the url
```
http://localhost:8080/retrieve
```

## Pending

List of items to be done in the future.

* Mock apis
* Add properties file and remove URL's and others parameters that are currently hard-coded.
* Add contract API on Readme.md
* Add log to the application


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


