@echo off
:loop
ping 127.0.0.1 -n 1 > nul
echo Current time : %time%
echo Current time : %time% >> date.txt
if 30 GTR 21 goto loop