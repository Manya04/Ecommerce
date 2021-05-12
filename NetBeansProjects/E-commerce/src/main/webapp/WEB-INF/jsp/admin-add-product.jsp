<%-- 
    Document   : admin-add-product
    Created on : 19-Apr-2021, 2:19:38 pm
    Author     : manyaagarwal
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="cp" value="${pageContext.request.servletContext.contextPath}/resources" scope="request" />
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
    <meta name="description" content="Vuexy admin is super flexible, powerful, clean &amp; modern responsive bootstrap 4 admin template with unlimited possibilities.">
    <meta name="keywords" content="admin template, Vuexy admin template, dashboard template, flat admin template, responsive admin template, web app">
    <meta name="author" content="PIXINVENT">
    <title>Register Page - Vuexy - Bootstrap HTML admin template</title>
    <link rel="apple-touch-icon" href="${cp}/home/app-assets/images/ico/apple-icon-120.png">
    <link rel="shortcut icon" type="image/x-icon" href="${cp}/home/app-assets/images/ico/favicon.ico">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:300,400,500,600" rel="stylesheet">

    <!-- BEGIN: Vendor CSS-->
    <link rel="stylesheet" type="text/css" href="${cp}/home/app-assets/vendors/css/vendors.min.css">
    <!-- END: Vendor CSS-->

    <!-- BEGIN: Theme CSS-->
    <link rel="stylesheet" type="text/css" href="${cp}/home/app-assets/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="${cp}/home/app-assets/css/bootstrap-extended.css">
    <link rel="stylesheet" type="text/css" href="${cp}/home/app-assets/css/colors.css">
    <link rel="stylesheet" type="text/css" href="${cp}/home/app-assets/css/components.css">
    <link rel="stylesheet" type="text/css" href="${cp}/home/app-assets/css/themes/dark-layout.css">
    <link rel="stylesheet" type="text/css" href="${cp}/home/app-assets/css/themes/semi-dark-layout.css">

    <!-- BEGIN: Page CSS-->
    <link rel="stylesheet" type="text/css" href="${cp}/home/app-assets/css/core/menu/menu-types/vertical-menu.css">
    <link rel="stylesheet" type="text/css" href="${cp}/home/app-assets/css/core/colors/palette-gradient.css">
    <link rel="stylesheet" type="text/css" href="${cp}/home/app-assets/css/pages/authentication.css">
    <!-- END: Page CSS-->

    <!-- BEGIN: Custom CSS-->
    <link rel="stylesheet" type="text/css" href="${cp}/home/assets/css/style.css">
    <!-- END: Custom CSS-->

</head>
<!-- END: Head-->

<!-- BEGIN: Body-->

<body class="vertical-layout vertical-menu-modern 1-column  navbar-floating footer-static bg-full-screen-image  blank-page blank-page" data-open="click" data-menu="vertical-menu-modern" data-col="1-column">
    
    
    <!-- BEGIN: Content-->
    <div class="app-content content">
        <div class="content-overlay"></div>
        <div class="header-navbar-shadow"></div>
        <div class="content-wrapper">
            <div class="content-header row">
            </div>
            <div class="content-body">
                <section class="row flexbox-container">
                    <div class="col-xl-8 col-10 d-flex justify-content-center">
                        <div class="card bg-authentication rounded-0 mb-0">
                            <div class="row m-0">
                                <div class="col-lg-6 d-lg-block d-none text-center align-self-center pl-0 pr-3 py-0">
                                    <img src="${cp}/home/app-assets/images/pages/register.jpg" alt="branding logo">
                                </div>
                                <div class="col-lg-6 col-12 p-0">
                                    <div class="card rounded-0 mb-0 p-2">
                                        <div class="card-header pt-50 pb-1">
                                            <div class="card-title">
                                                <h4 class="mb-0">Add Product</h4>
                                            </div>
                                        </div>
                                        <p class="px-2">Fill the below form to add a new account.</p>
                                        <div class="card-content">
                                            <div class="card-body pt-0">
                                                <form id="add-event-form" action="addProduct" method="post" enctype = "multipart/form-data">
                                                     <div class="form-label-group">
                                                        <input type="text" id="inputName" class="form-control" name="name" placeholder="Product Name" required>
                                                        <label for="inputName">Name</label>
                                                    </div>
                                                    <div class="form-label-group">
                                                        <input type="number" id="inputPrice" class="form-control" name="price" placeholder="Price" required>
                                                        <label for="inputPrice">Price</label>
                                                    </div>
                                                    <div class="form-label-group">
                                                      <textarea class="form-control" rows="4" cols="50" name="description"  required></textarea>
                                                        <label for="inputDescription">Description</label>
                                                    </div>
                                                    <div class="form-label-group">
                                                        <input type="text" id="inputBrand" class="form-control" name="brand" placeholder="Brand" required>
                                                        <label for="inputBrand">Brand</label>
                                                    </div>
                                                    <div class="form-label-group">
                                                        <input type="number" id="inputQuantity" class="form-control" name="quantity" placeholder="Quantity" required>
                                                        <label for="inputQuantity">Quantity</label>
                                                    </div>
                                                    
                                                    <div class="form-label-group">
                                                        <input type="number" id="inputDiscount" class="form-control" name="discount" placeholder="Discount" required>
                                                        <label for="inputDiscount">Discount</label>
                                                    </div>
                                                    <div class="form-label-group">
                                                        <input type="file" id="inputImage" class="form-control" name="file" placeholder="Image">
                                                        <label for="inputImage">Image</label>
                                                    </div>
                                                    <a href="dashboard-analytics" class="btn btn-outline-primary float-left btn-inline mb-50">Cancel</a>
                                                    <button id="submit-btn" class="btn btn-primary float-right btn-inline mb-50">Add</button>
                                                </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                        </div>
                    </div>   
                </section>

            </div>
        </div>
    </div>
    <!-- END: Content-->

    
    <!-- BEGIN: Vendor JS-->
    <script src="${cp}/home/app-assets/vendors/js/vendors.min.js"></script>
    <!-- BEGIN Vendor JS-->

    <!-- BEGIN: Page Vendor JS-->
    <!-- END: Page Vendor JS-->

    <!-- BEGIN: Theme JS-->
    <script src="${cp}/home/app-assets/js/core/app-menu.js"></script>
    <script src="${cp}/home/app-assets/js/core/app.js"></script>
    <script src="${cp}/home/app-assets/js/scripts/components.js"></script>
    <script>
    $(document).ready(function(){
       $('#add-event-form').submit(function(event) 
       {  
           event.preventDefault();
           var form = $('#add-event-form')[0];	
        // Create an FormData object 
        var data = new FormData(form);
          $.ajax({
               type: "POST",
               enctype: 'multipart/form-data',
               url:"/E-commerce/addProduct",
               data: data,
               encode: true,
               processData: false,
            contentType: false, // this
            cache: false,
            timeout: 600000
             }).done(function(response){
                 console.log(response);
                 if(isNumeric(response)){
                     console.log("hey");
                    window.location.href = "/E-commerce/app-ecommerce-details?idproduct="+response;
                      //window.location.href = "/E-commerce/app-ecommerce-details";
                }else if(response === "CannotAdd"){
                    window.location.href = "/E-commerce/admin-add-product";
                    alert(response);
                }
                 console.log(response);
             });   
           });
         });
         function isNumeric(str) {
  if (typeof str != "string") return false // we only process strings!  
  return !isNaN(str) && // use type coercion to parse the _entirety_ of the string (`parseFloat` alone does not do this)...
         !isNaN(parseFloat(str)) // ...and ensure strings of whitespace fail
}
   </script>  
   
    <!-- END: Theme JS-->

    <!-- BEGIN: Page JS-->
    <!-- END: Page JS-->

</body>
</html>
