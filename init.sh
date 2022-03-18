#!bin/bash

sudo apt update -y
sudo apt-get install software-properties-common
sudo apt-add-repository 'deb http://security.debian.org/debian-security stretch/updates main'
sudo apt-get update
sudo apt-get install openjdk-8-jdk
sudo apt install -y maven
code-server --install-extension "redhat.java"
export JAVA_HOME=/usr/lib/jvm/java-8-openjdk-amd64/