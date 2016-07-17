#Ordering tasking

* ###/products

1. return 201 when POST product  
estimate: 10 min  
real: 6 min

2. create product with parameters and find product by product id  
 e: 20 min  
 r: 24 min

3. return 201 when POST product with parameters  
 e: 5 min  
 r: 7 min

4. return 200 when GET products  
 e: 3 min  
 r: 3 min

5. find all products  
 e: 15 min  
 r: 6 min
 
6. return a list of products when GET products  
 e: 5 min  
 r: 15 min  
 reason: should have implement Record interface
 

* ###/products/{productId}

1. return 200 when GET product by product id  
 e: 5 min  
 r: 10 min 
 reason: complete tasking 3 at the same time
 

2. return 404 when GET product by product id fails  
 e: 5 min   
 r: 3 min
 

3. return product when GET product by product id  
 e: 10 min  
 r: 0 min  
 reason: already done in task 1.
 

* ###/users

1. return 201 when POST user  
 e: 8 min  
 r: 5 min
 
2. create user with parameters and find user by user id  
 e: 20 min  
 r: 17 min

3. return 201 when POST user with parameters  
 e: 10 min  
 r: 7 min
 
4. return 200 when GET users  
 e: 3 min  
 r: 2 min
 
5. find all users  
 e: 6 min  
 r: 6 min
 
6. return a list of users when GET users  
 e: 5 min  
 r: 6 min
 

* ###/users/{userId}

1. return user when GET user by user id  
e: 10 min  
r: 7 min
 
2. return 404 when GET by userId fails  
 e: 5 min 


* ###/users/{userId}/orders

1. return 201 when POST order  
 e:  
 

2. create order with name and find by orderId  
 e: 

3. return 201 when POST order with name  
 e:  
 

4. create order with parameters and find by userId and orderId  
 e:  

5. return 201 when POST order with parameters  
 e:  
  

6. return 500 when POST order fails  
 e:  
 

7. return 200 when GET orders  
 e:  
 

8. find orders  
 e:  
 

9. return a list of order when GET orders  
 e:  
 

* ###/users/{userId}/orders/{orderId}

1. return 200 when GET by userId and orderId  
 e:  
 

2. return 404 when GET by userId and orderId fails  
 e:  
 

3. return order when GET by userId and orderId  
 e:

* ###/users/{userId}/orders/{orderId}/payment

1. return 201 when POST  
 e:  
 

2. create payment with amount and find by userId and orderId  
 e:  

3. return 201 when POST with amount  
 e:  
 

4. create payment with parameters and find by userId and orderId  
 e:  
   
reason: after previous practice, already able to create repository in one step 


5. return 201 when POST with parameters  
 e:  

6. return 500 when POST fails  
 e:  
 

7. return 200 when GET payments by orderId  
 e:  
 

8. find all payments  
 e:  
 

9. return payments when GET 
 e:  
