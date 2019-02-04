memAvailable=$(awk '/MemFree/{ printf "%f\n", $2}' /proc/meminfo);
memTotal=$(awk '/MemTotal/{printf "%f\n", $2;}' < /proc/meminfo);
allocationSize=$(echo "($memTotal * $1)-$memAvailable" | bc -l);
echo "Allocating memory by $allocationSize KB";
stress --vm-bytes "$allocationSize"K --vm-keep -m 1;
