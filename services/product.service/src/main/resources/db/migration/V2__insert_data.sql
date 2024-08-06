
-- Insert categories
INSERT INTO category (id, name, description) VALUES
(1, 'Electronics', 'Devices and gadgets'),
(2, 'Furniture', 'Home and office furniture'),
(3, 'Books', 'Various genres of books'),
(4, 'Clothing', 'Apparel and accessories');



-- Insert products
INSERT INTO product (id, name, description, quantity, price, category_id) VALUES
(1, 'Smartphone', 'Latest model with advanced features', 100, 699.99, 1),
(2, 'Laptop', 'High-performance laptop for professionals', 50, 1299.99, 1),
(3, 'Sofa', 'Comfortable 3-seater sofa', 20, 499.99, 2),
(4, 'Office Chair', 'Ergonomic chair for office use', 30, 149.99, 2),
(5, 'Science Fiction Novel', 'Exciting and futuristic novel', 200, 19.99, 3),
(6, 'Cookbook', 'Collection of recipes for home cooking', 150, 29.99, 3),
(7, 'T-Shirt', 'Casual cotton T-shirt', 500, 9.99, 4),
(8, 'Jeans', 'Comfortable and stylish jeans', 300, 39.99, 4);



