#!/bin/bash
set -e

# Function to update version in gradle.properties
# Uses an approach compatible with both GNU and BSD sed
update_version() {
    if [[ "$OSTYPE" == "darwin"* ]]; then
        sed -i '' "s/^version=.*/version=$1/" gradle.properties
    else
        sed -i "s/^version=.*/version=$1/" gradle.properties
    fi
}

# Function to confirm with the user
confirm() {
    echo "You are about to set version to: $1"
    read -p "Confirm (Y/N): " choice
    case "$choice" in
        Y|y ) echo "Proceeding with version $1";;
        N|n ) echo "Cancelled"; exit 1;;
        * ) echo "Invalid response"; exit 1;;
    esac
}

echo "Release Script"

# Get the release version and next version
read -p "Enter the release version (e.g., 1.0.0): " release_version
read -p "Enter the next snapshot version (e.g., 1.1.0-SNAPSHOT): " next_version

# Confirm release version
confirm $release_version

# Update to release version
update_version $release_version
echo "Updated version to $release_version in gradle.properties"
git commit -am "Prepare version $release_version"
echo "Committed changes for version $release_version"
git tag -am "Version $release_version" $release_version
echo "Tagged version $release_version"
git push --tags
echo "Pushed tags to remote"

# Confirm next snapshot version
confirm $next_version

# Update to next snapshot version
update_version $next_version
echo "Updated version to $next_version in gradle.properties"
git commit -am "Prepare next development version"
echo "Committed changes for next development version"
git push && git push --tags
echo "Pushed changes and tags to remote"

echo "Release process completed."
