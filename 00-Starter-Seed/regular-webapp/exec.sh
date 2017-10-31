#!/usr/bin/env bash
docker build -t auth0-scala-web-app .
docker run --env-file .env -p 9000:9000 -it auth0-scala-web-app
