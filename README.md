# e-ftasee
The application is developed for the purpose of the course Android Programming (SDU).

The main idea of the application is the idea of a Digital/Virtual Waiter, that means restaurant's clients can place their orders from the e-ftasee application and admin can receive them.

Application architecture: MVVM, Single-Activity with multiple Fragments

Support Languages: English, Greek

Client-Server Model: 
The admin is the server and the users are the clients. 
The server must have a static ip address.
Devices in the same wifi network with the Server can send to the server messages. 
Clients sends messages to server (such as "Table 5 Calls a waiter" or "Table 9 Dish 1\n Dish 2 \n Soft Drink .... Total 50.00")
Admin is using a service to accept all the clients, receive their messages and save the messages to the device.

Database: Room
Every user saves its own order to orders database
Admin saves all the messages to messages database


The application's functionalities are:

User:
  1. A user can enter the table code (Mandotary for functonality 2)
  2. User can:
      a. Call a waiter (for extra information)
      b. Request the bill
      c. Select from menu dish/dishes, soft drinks, desserts to add at their order
      d. Place their order
      e. Give feedback
      
Admin:
  1. Log In as Admin 
  2. Admin can:
     a. receive the messages from the clients
     b. see today's messages
     c. delete a message
  
  
Testing:

For testing the device sends messages to the ip address 127.0.0.1 (loopback addres), so the device can behave as server and client in the same time!

1. Press the button "admin log in"
2. Log in as admin (username="anaoum" password="anaoum123"), the server service will start
3. Go back to the fisrt page
4. Enter one of the codes "11111", "22222", "33333", ....., "99999" and press submit
5. Call a waiter, Request the bill - Device (client) sends a message to the server
6. Press the menu button (imagebutton) and add some dishes to your order
7. Press the order button (imagebutton) and place your order -- Device (client) sends a message to the server
8. Go back to the first fragment and log in again as admin 
9. Now you can see the messages
10. Press a message, then select the option delete 
  





