
Maybe this can help you understand some stuff regarding running the voltDB codes,,,,

1. check that docker is working 
2. then pull voltdb/voltdb-community (I used the terminal in intellij) --> docker pull voltdb/voltdb-community
3. to run voltDB --> docker run -it --rm -p 21212:21212 -p 8080:8080 -p 55004:55004 -v voltdb_data:/var/voltdb -e HOST_COUNT=1 voltdb/voltdb-community voltdb start -c 1 --ignore=thp
5. to connect voltDB to the DBeaver:
   Create new driver :
   upload the jar file, I used (voltdbclient-14.0.1.jar)
                      I named it: VoltDB 
                      class name: org.voltdb.jdbc.Driver
                      URL template: jdbc:voltdb://localhost:21212
                      default port : 21212
                      no authentication , Allow Empty Password , Thread safe driver
   
7. after that you can run the codes that I uploaded
I added a this to the VM options :
--add-opens=java.base/java.lang.invoke=ALL-UNNAMED
--add-opens=java.base/java.lang=ALL-UNNAMED
--add-opens=java.base/java.util=ALL-UNNAMED
--add-opens=java.base/sun.nio.ch=ALL-UNNAMED
--add-opens=java.base/java.time=ALL-UNNAMED
--add-opens=java.base/java.lang.reflect=ALL-UNNAMED
--add-opens=java.rmi/sun.rmi.transport=ALL-UNNAMED

Start with Running InsertingTest file, then run the VoltDbOperatorsTest file
