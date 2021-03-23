#!/bin/sh
java -jar antlr-4.9-complete.jar -package "pl.ziemniakoss.simplecompiler.grammar" -o src/main/java/pl/ziemniakoss/simplecompiler/grammar SimpleGrammar.g4
