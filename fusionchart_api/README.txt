I - Project goals
=================
The project aims to build a Java API for fusion chart. The API permits to 
generate an xml string which used by the flash file as xml data.

II - Project organization
=========================
The project is based on a generator and a meta description of chart written in excel files. 
Therefore the project source contains only the java classes about the generator and few
common classes. The main part of the API is generated and must be committed in SVN.

The project is based on Ant for the generation. Here is the main target :
compile: compile the source of the project (generator mainly)
generate: generate the API from the excel files availlable in 'etc' directory
jar: build the jar containing the API.

III - Adding/modify a chart
===========================
For each chart corresponds an excel file in the 'etc' directory. An excel file describes 
the structure of the xml expected by the flash animation (.swf). I choose to use flat 
representation of the xml tree because the grammar is very simple (no node reuse) and 
very easy to write by a simple copy/paste from the fusion chart documentation. 
Some details about the excel files:
 - The first tab (named 'attributes') contains the list of attributes for each node.
 - The second tab (named 'nodes') describes the organization of the nodes by defining
the relationship between a node and its children. 

* To add a chart you have to create a new .xls file (Excel 2003) containing the meta
description of your chart. Then, you have to launch the generation in order to rebuild
generated classes.  

============================================
If you any question, contact me: sebastien@chassande.fr
