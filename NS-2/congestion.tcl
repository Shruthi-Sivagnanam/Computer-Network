global ns namFile

set ns [new Simulator]

$ns set color 1 Blue
$ns set color 2 Red

# nam file creation
set namFile [open congestion.nam w]
$ns namtrace-all $namFile

#finish function
proc finish {} {
	global ns namFile
	$ns flush-trace
	close $namFile
	exec nam congestion.nam
	exit 0
}

# Creation of node. This network contains four nodes.
set n0 [$ns node]
set n1 [$ns node]
set n2 [$ns node]
set n3 [$ns node]

# Creating duplex link between the nodes.
$ns duplex-link $n0 $n1 2mb 10ms DropTail
$ns duplex-link $n1 $n2 2mb 10ms DropTail
$ns duplex-link $n2 $n3 1.7mb 20ms DropTail

# Setting the queue limit
$ns set queue-limit $n2 $n3 10

# Orientation of nodes in network animator
$ns duplex-link-op $n0 $n1 orient right-down
$ns duplex-link-op $n1 $n2 orient right-up
$ns duplex-link-op $n2 $n3 orient right

#TCP connection source and sink
set tcp [new Agent/TCP]
$ns attach-agent $n0 $tcp
set sink [new Agent/TCPSink]
$ns attach-agent $n3 $sink
$ns connect $tcp $sink
$tcp set fid_ 1

#FTP over TCP
set ftp [new Application/FTP]
$ftp attach-agent $tcp
$ftp set type_ FTP

#UDP Connection
set udp [new Agent/UDP]
$ns attach-agent $n2 $udp
set null [new Agent/Null]
$ns attach-agent $n3 $null
$ns connect $udp $null
$udp set fid_ 2

#CBR connection
set cbr [new Application/Traffic/CBR]
$cbr attach-agent $udp
$cbr set type_ CBR
$cbr set packet_size_ 1000
$cbr set rate_ 1mb
$cbr set random_ false

#Events
$ns at 0.1 "$cbr start"
$ns at 1.0 "$ftp start"
$ns at 4.0 "$ftp stop"
$ns at 4.5 "$cbr stop"
$ns at 5.0 "finish"

$ns run
