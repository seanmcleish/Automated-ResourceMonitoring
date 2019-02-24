# RessourceMonitor
Bachelor Thesis - Author: Sean McLeish

**# Automated Resource-Monitoring**

## Description
This tool enables automated resource monitoring.

## Structure
The application is divided into two main components:
1. the "sensor", which reads the raw data from a SUT and makes them available via REST-API
2. the "Webservice", which queries the raw data from the sensor, persists and provides key figures via REST-API.

## Purpose
The key figures of the SUT, such as the current hardware data or process information, can then be queried via HTTP using any test tool and checked for conditions. Within the repository, the standardized test language TTCN-3 is used as an example.


