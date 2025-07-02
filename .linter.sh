#!/bin/bash
cd /home/kavia/workspace/code-generation/vocabflip-16651-a94c6842/flashcards_frontend
./gradlew lint
LINT_EXIT_CODE=$?
if [ $LINT_EXIT_CODE -ne 0 ]; then
   exit 1
fi

