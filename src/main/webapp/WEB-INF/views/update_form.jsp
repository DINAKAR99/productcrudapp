<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="ISO-8859-1" />
    <%@ include file="./base.jsp" %>
  </head>
  <body>
    <!-- <h1>this is add product from</h1> -->
    <div class="container mt-3">
      <div class="row">
        <div class="col-md-6 offset-md-3">
          <h1 class="text-center mb-3">Change Product Details</h1>
          <form
            action="${pageContext.request.contextPath }/handle-product"
            method="post"
          >
            <input
              type="hidden"
              value="${product.id }"
              name="id"
              class="form-control"
            />
            <div class="form-group">
              <label for="name" class="form-label">Product Name</label>
              <input
                type="text"
                class="form-control"
                id="name"
                name="name"
                placeholder="Enter the product name here"
                value="${product.name }"
              />
            </div>
            <div class="form-group">
              <label for="description" class="form-label"
                >Product Description</label
              >
              <textarea
                class="form-control"
                id="description"
                name="description"
                placeholder="Enter the product description"
                rows="5"
              >
${product.description}</textarea
              >
            </div>
            <div class="form-group">
              <label for="price" class="form-label">Product Price</label>
              <input
                type="text"
                class="form-control"
                id="price"
                name="price"
                value="${product.price }"
                placeholder="Enter Product Price"
              />
            </div>
            <div class="container text-center mt-3">
              <a
                href="${pageContext.request.contextPath }"
                class="btn btn-outline-danger"
                >Back</a
              >
              <button type="submit" class="btn btn-warning">Update</button>
            </div>
          </form>
        </div>
      </div>
    </div>
  </body>
</html>
