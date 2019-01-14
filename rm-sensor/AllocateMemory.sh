memAvailable=$(awk '/MemAvailable/{printf "%d\n", $2;}' < /proc/meminfo);
memTotal=$(awk '/MemTotal/{printf "%d\n", $2;}' < /proc/meminfo);
let "allocationSize=$memAvailable-$memTotal*$1";
echo "Allocating memory by $allocationSize KB";
stress --vm-bytes "$allocationSize"K --vm-keep -m 1;
