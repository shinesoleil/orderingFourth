CREATE TABLE products (
  id VARCHAR(255) PRIMARY KEY ,
  name VARCHAR(255) NOT NULL ,
  description VARCHAR(255) NOT NULL ,
  price DOUBLE NOT NULL
);

CREATE TABLE users (
  id VARCHAR(255) PRIMARY KEY,
  name VARCHAR(255) NOT NULL
);

CREATE TABLE orders (
  id VARCHAR(255) PRIMARY KEY ,
  name VARCHAR(255) NOT NULL ,
  address VARCHAR(255) NOT NULL ,
  phone VARCHAR(255) NOT NULL ,
  time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  user_id VARCHAR(255) NOT NULL ,

  FOREIGN KEY (user_id)
    REFERENCES users(id)
);

CREATE TABLE order_items (
  order_id VARCHAR(255) PRIMARY KEY ,
  product_id VARCHAR(255) NOT NULL ,
  quantity INT NOT NULL ,

  FOREIGN KEY (order_id)
    REFERENCES orders(id),

  FOREIGN KEY (product_id)
    REFERENCES products(id)
)