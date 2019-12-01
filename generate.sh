#!/bin/sh
set -e -x

rm -rf src gradle .gitignore build.gradle gradlew gradlew.bat settings.gradle runelite-plugin.properties null || true

../external-plugins/create_new_plugin.py \
	--noninteractive \
	--output_directory . \
	--name "Example External Plugin" \
	--package "com.example" \
	--description "Greets you when you login" \
	--author nobody
