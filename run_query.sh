#!/bin/sh

output=$1
ql_file=$(realpath $2)

echo Using .ql file $ql_file
echo Will write results to $output

codeql database analyze --format=sarif-latest --output=$output $ql_file