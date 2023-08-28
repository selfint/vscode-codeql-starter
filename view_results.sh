#!/bin/sh

t=$1
src=$2
spacing=$3

jq_cmd=".runs[0].results[0].codeFlows[0].threadFlows[0].locations | .[] | .location.physicalLocation.region.startLine"

cat $t \
    | jq "$jq_cmd" \
    | awk -v src=$src '{print "sed -n -e $((" $1 "-2)),$((" $1 "+2))p " src " && echo ------------------------------------------------------------" }'