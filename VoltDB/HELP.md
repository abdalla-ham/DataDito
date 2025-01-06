
Maybe this can help you understand some stuff regarding running the voltDB codes,,,,

1. check that docker is working 
2. then pull voltdb/voltdb-community (I used the terminal in intellij) --> docker pull voltdb/voltdb-community
3. to run voltDB --> docker run -it --rm -p 21212:21212 -p 8080:8080 -p 55004:55004 -v voltdb_data:/var/voltdb -e HOST_COUNT=1 voltdb/voltdb-community voltdb start -c 1 --ignore=thp
4. to connect voltDB to the DBeaver:
   Create new driver :
   upload the jar file, I used (voltdbclient-14.0.1.jar)
                      I named it: VoltDB ,
                      class name: org.voltdb.jdbc.Driver   ,
                      URL template: jdbc:voltdb://localhost:21212   ,
                      default port : 21212   ,
                      no authentication , Allow Empty Password , Thread safe driver
   ------> create the driver then create a connection to it.
   don't forget to execute the codes to create the needed tables and procedures  
   
6. after that you can run the codes that I uploaded
I added a this to the VM options(PLEASE don't skip this step) :
--add-opens=java.base/java.lang.invoke=ALL-UNNAMED
--add-opens=java.base/java.lang=ALL-UNNAMED
--add-opens=java.base/java.util=ALL-UNNAMED
--add-opens=java.base/sun.nio.ch=ALL-UNNAMED
--add-opens=java.base/java.time=ALL-UNNAMED
--add-opens=java.base/java.lang.reflect=ALL-UNNAMED
--add-opens=java.rmi/sun.rmi.transport=ALL-UNNAMED

Start with Running InsertingTest file, then run the VoltDbOperatorsTest file

/////////////////////////
Creat new VM instance ( Ubunto , E2, 20 GB , Allow everything in the Firewall section).
You also need.. 
To create a firewall rule for VoltDB's default port (21212), follow these steps:

Using the GCP Console
Navigate to VPC Networks:

Go to the VPC networks page in the GCP Console.
Create a New Firewall Rule:

Click "Firewall rules" from the left-hand menu.
Click "Create Firewall Rule".
Configure the Firewall Rule:

Name: Enter allow-voltdb-21212.
- Network: Select the appropriate VPC network (e.g., default or your custom network).
- Priority: Use the default 1000 unless you need a different priority.
- Direction of Traffic: Select Ingress.
- Action on Match: Select Allow.
- Targets: Choose the appropriate target option:
All instances in the network or
Specified target tags (e.g., voltdb-server).
- Source Filters:
- Set Source IP ranges to 0.0.0.0/0 to allow traffic from any IP, or restrict it to specific trusted IP ranges.
- Protocols and Ports:
Select Specified protocols and ports.
- Enable TCP and enter 21212.
- Save:

Click "Create" to save the rule.

IN SSH :
- sudo apt update
- sudo apt install docker.io
- sudo systemctl start docker
- sudo systemctl enable docker
- docker --version
- sudo docker pull voltdb/voltdb-community
- sudo docker ps
- sudo docker ps -a
- sudo docker run -it --rm -p 21212:21212 -p 8080:8080 -p 55004:55004 -v voltdb_data:/var/voltdb -e HOST_COUNT=1 voltdb/voltdb-community voltdb start -c 1 --ignore=thp
- sudo docker exec -it node1 bash  //// node1 is the container name OR container id
- sqlcmd


