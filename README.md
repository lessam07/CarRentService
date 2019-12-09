Microservices for Car Renting Service

Purpose of the system:

This website is for online car renting which has information about orders, users and their payment details. 

Brief description: 

Order-details: 

Get list of orders - GET 
Get order detail by order_id - GET 
Save order details - POST 
Update order details - PUT 
Delete order details - DELETE

Payment-details:

Get list of payments - GET 

Order-history: 

get list of orders by user_id – GET
Get full name by user_id - GET
Get created_at and car_type - GET

User - details: 

Get list of users - GET 
Get user by user_id - GET


Zuul-Service

 Rearranges all requests to micro services
 Sends request to auth-service

Authentication service:
 
 Checks users validation 
 Creates token for users 


