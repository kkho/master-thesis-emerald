# Introduction #

To communicate with several devices or machines, each machine must initialize an Emerald node and be a part of a node collection.


# Details #

To initialize an Emerald node, you type in:

_emx -U -R_

-U is to ignore port issue when nodes wants to communicate with each other.

-R is for remote, which makes it possible to distribute objects to that node.

To be a part of a node collection, a machine must type in:

_emx -U -R<hostname of an Emerald node>:<portnumber of the host>_

To actually run Emerald program and distribute objects, you need to type in:

_emx -U -R<hostname of an Emerald node>:<portnumber ofthe host> filename.x_