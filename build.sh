#!/usr/bin/env bash
set -euo pipefail

# Make script location-independent
SCRIPT_DIR=$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)
SRC_DIR="$SCRIPT_DIR/src"
OUT_DIR="$SCRIPT_DIR/out"
JAR_NAME="$SCRIPT_DIR/PageSimulator.jar"

if [[ "${1:-}" == "clean" ]]; then
    echo "Cleaning..."
    rm -rf "$OUT_DIR" "$JAR_NAME"
    echo "Cleaned $OUT_DIR and $JAR_NAME"
    exit 0
fi

mkdir -p "$OUT_DIR"

echo "Compiling..."

# Compile all .java files under src (works for src/app or src/main/java/app layouts)
javac -d "$OUT_DIR" $(find "$SRC_DIR" -name "*.java")

echo "Packaging JAR..."
# Set the Main-Class to the package present in src (pagesimulator.Main)
jar --create --file "$JAR_NAME" --main-class=pagesimulator.Main -C "$OUT_DIR" .

echo "Built $JAR_NAME"
