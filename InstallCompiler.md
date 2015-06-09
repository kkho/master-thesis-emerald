# Introduction #

To setup the Emerald compiler on your own PC and not on the smartphone.
We recommend you to have a linux distro 32 bits. (Emerald does not support 64 bits machines).




# Details #

You can download the Emerald version 0.99 for any linux distro here:

http://www.uio.no/studier/emner/matnat/ifi/INF5510/v11/undervisningsmateriale/kompilator/emerald-0.99-linux.tar.gz

to make is as simple as possible, do the following on the Terminal shell:


**untar the file:
tar xvf emerald-0.99-linux.tar.gz**


Then move the files into a directory (make an emerald directory, mkdir emerald)

After that, to find the path of the Emerald directory by going into the source of Emerald and type pwd and copy the output.

After the phase, you need to edit .bashrc file.

to edit the .bashrc in a simple way, type in : "gedit ~/.bashrc" in the terminal, eventually use whatever texteditor you want, but in this case I chose gedit!


Copy:

export EMERALDROOT='~/emerald-0.99-linux'
export PATH=$PATH:$EMERALDROOT/bin
set EMERALDARCH='i686mt'


Then in the end, exit the vi and type in: source ~/.bashrc