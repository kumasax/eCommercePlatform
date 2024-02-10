# eCommercePlatform
ECommerce Platform
A Spring Boot-based REST API that  supports CRUD operations for products  to manage products for an e-commerce platform. Each product has the following attributes:

- ProductID (unique identifier)
- Name
- Description
- Price
- Quantity Available
 
The following operations are implemented:

-  Create Product:
Input:  Product details (Name, Description, Price, Quantity Available)
Output:  Product details (ProductID , Name, Description, Price, Quantity Available) an error message if creation fails.

- Read Product:
Input:  ProductID of the product to retrieve
Output:  Product details (ProductID, Name, Description, Price, Quantity Available) or an error message if the product is not found.

- Update Product:
Input: Product details (ProductID , Name, Description, Price, Quantity Available) an error message if update fails.
Output: Success/Failure message

- Delete Product:
Input: ProductID of the product to delete
Output: Success/Failure message

-  Apply Discount or Tax:
The API supports the application of either a discount or a tax to a product which implements a mechanism to modify the price of a product based on either a discount percentage or a tax rate provided in the request.
Input: ProductID, Discount Percentage OR Tax Rate (client can choose either discount or tax), and applicable value
Output: Success/Failure message, Updated Product details (including modified price)
