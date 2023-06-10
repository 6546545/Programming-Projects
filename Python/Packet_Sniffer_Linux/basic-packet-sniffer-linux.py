"""
This file and all associated files were created using the tutorial found at www.uv.mx
The code is not my code but is the author's code. This was recreated for learning purposes.

"""
import socket

#Create INET socket
s = socket.socket(socket.AF_INET, socket.SOCK_RAW, socket.IPPROTO_TCP)

#Print data packet information to console
while True:
    print(s.recvfrom(65565))