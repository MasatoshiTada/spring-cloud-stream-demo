#!/bin/bash
docker container run --rm -p 5672:5672 -p 15672:15672 rabbitmq:3.7.8-management-alpine