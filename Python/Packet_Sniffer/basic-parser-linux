"""
This file and all associated files were created using the tutorial found at www.uv.mx
The code is not my code but is the author's code. This was recreated for learning purposes and contain only my comments.

"""

#Import packages
import socket
from struct import *
import sys

# Main Function
def main():
    # Get socket information
    s = socket.socket(socket.AF_PACKET, socket.SOCK_RAW, socket.ntohs(3))
    while True:
        #Set the raw_data and adr vars to the data from the socket
        raw_data, adr = s.recvfrom(65535)
        #Calls ethernet_head function
        eth = ethernet_head(raw_data)
        #Prints to console
        print('\n Ethernet Frame:')
        print('Destination: {}, Source: {}, Protocol {}'.format(eth[0], eth[1], eth[2]))

        #IF statements separate out the different sections of information from the socket
        #IPV4 SEGMENT
        if eth[2] == 8:
            ipv4 = ipv4(eth[4])
            print('\t - ' + 'IPV4 Packet:')
            print('\t\t - ' + 'Version: {}, Header Length: {}, Source: {}, TTL: {}'.format(ipv4[1], ipv4[2], ipv4[3]))
            print('\t\t - ' + 'Protocol: {}, Source: {}, Target: {}'.format(ipv4[4], ipv4[5], ipv4[6]))
        #TCP SEGMENT
        if ipv4[4] == 6:
            tcp = tcp_head(ipv4[7])
            print(TAB_1 + 'TCP Segment:')
            print(TAB_2 + 'Source Port: {}, Destination Port: {}'.format(tcp[0], tcp[1]))
            print(TAB_2 + 'Sequence: {}, Acknowledgement: {}'.format(tcp[2], tcp[3]))
            print(TAB_2 + 'Flags:')
            print(TAB_3 + 'URG: {}, ACK: {}, PSH:{}'.format(tcp[4],tcp[5],tcp[6]))
            print(TAB_3 + 'RST: {}, SYN: {}, FIN: {}'.format(tcp[7],tcp[8], tcp[9]))

            #HTTP SEGMENT
            if len(tcp[10]) >0:
                if tcp[0] == 80 or tcp[1] == 80:
                    print(TAB_2 + 'HTTP Data:')
                    try:
                        http = HTTP(tcp[10])
                        http_info = str(http[10]).split('\n')
                        for line in http_info:
                            print(DATA_TAB_3 + str(line))
                    except:
                        print(format_multi_line(DATA_TAB_3, tcp[10]))
                    else:
                        print(TAB_2 + 'TCP Data:')
                        print(format_multi_line(DATA_TAB_3, tcp[10]))
        #ICMP SEGEMENT
        elif ipv4[4] == 1:
            icmp = icmp_head(ipv4[7])
            print('\t -' + 'ICMP Packet:')
            print('\t\t - ' + 'Type: {}, Code: {}, Checksum: {}'.format(icmp[0], icmp[1], icmp[2]))
            print('\t\t - ' + 'ICMP Data:')
            print(format_multi_line('\t\t\t', icmp[3]))
        #UDP SEGMENT
        elif ipv4[4] == 17:
            udp = udp_head(ipv4[7])
            print('\t -' + 'UDP Segment:')
            print('\t\t -' + 'Source Port: {}, Destination Port: {}, Length: {}'.format(udp[0], udp[1], udp[2]))
"""
Ethernet Head Function:
    @param raw_data
    @return dest_mac, dest_src, proto, data

"""
def ethernet_head(raw_data):
    dest, src, prototype = Struct.unpack('! 6s 6s H', raw_data[:14])
    #Need to define get_mac_addr function
    dest_mac = get_mac_addr(dest)
    dest_src = get_mac_addr(src)
    proto = socket.htons(prototype)
    data = raw_data[14:]
    return dest_mac, dest_src, proto, data
"""
IPV4 Head Function:
    @param raw_data
    @return version, head_len, ttl, proto, src, target, data

"""
def ipv4_head(raw_data):
    vers_head_len = raw_data[0]
    version = vers_head_len >> 4
    head_len = (vers_head_len & 15) * 4
    ttl, proto, src, target =  Struct.unpack('! 8x B B 2x 4s 4s', raw_data[:20])
    data =  raw_data[head_len:]
    src = get_ip(src)
    target = get_ip(target)
    return version, head_len, ttl, proto, src, target, data

"""
Get IP Function:
    @param addr
    @return IP address

"""
def get_ip(addr):
    return '.'.join(map(str, addr))
"""
Get MAC Address Function:
    @param dest
    @return 

"""
def get_mac_addr(dest):
    return
"""
TCP Head Function:
    @param raw_data
    @return src_port, dest_port, sequence, acknowledgement, flag_urg, flag_ack, flag_psh, flag_rst, flag_syn, flag_fin, data

"""
def tcp_head(raw_data):
    (src_port, dest_port, sequence, acknowledgement, offset_reserved_flag) = Struct.unpack('! H H L L H', raw_data[:14])
    offset = (offset_reserved_flag >> 12) * 4
    flag_urg = (offset_reserved_flag & 32) >> 5
    flag_ack = (offset_reserved_flag & 16) >> 4
    flag_psh = (offset_reserved_flag & 8) >> 3
    flag_rst = (offset_reserved_flag & 4) >> 2
    flag_syn = (offset_reserved_flag & 2) >> 1
    flag_fin =  offset_reserved_flag & 1
    data = raw_data[offset:]
    return src_port, dest_port, sequence, acknowledgement, flag_urg, flag_ack, flag_psh, flag_rst, flag_syn, flag_fin, data