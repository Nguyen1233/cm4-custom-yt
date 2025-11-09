#!/bin/sh
IFACE="can0"
BITRATE="500000"

ip link set $IFACE down 2>/dev/null
ip link set $IFACE type can bitrate $BITRATE berr-reporting on restart-ms 100
ip link set $IFACE up
exit 0
