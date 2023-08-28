#!/bin/sh

t=$1
src=$2
spacing=$3
result=$4

jq_cmd=".runs[0].results[$result].codeFlows[0].threadFlows[0].locations | .[] | .location.physicalLocation.region.startLine"

cat $t \
    | jq "$jq_cmd" \
    | awk -v src=$src -v spc=$spacing '{print "sed -n -e $((" $1 "-" spc ")),$((" $1 "+" spc "))p= " src " | grep --color  -e \"^\" -e \"$(sed -n -e " $1 "p " src ")\" && echo ---" }'