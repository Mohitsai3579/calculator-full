#!/usr/bin/env bash
set -euo pipefail

# Use default MODE if not set (but Dockerfile already sets MODE)
MODE="${MODE:-DEVE}"

if [ "$MODE" = "DEVE" ]; then
    exec java -jar /app.jar < /input.txt
else
    exec java -jar /app.jar
fi
